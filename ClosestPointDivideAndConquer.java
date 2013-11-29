package closestpoints;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ClosestPointDivideAndConquer implements ClosestPoint{
	private IndexedPoint [] pointsX; // indexed point sorted based on x co-ordinates
	private IndexedPoint[] pointsY; // indexed point sorted based on y co-ordinates
	private int [] indxMapY; // a mapping such if point indexed i present in indexed j of y-axis sorted array ie. pointsY than indxMapY[i] = j
	
	private double min; // the minimum distance between two points found so far
	private Point pf; // first point in pair for the minimum distance computed so far
	private Point ps; // // second point in pair for the minimum distance computed so far
	
	private static final double INF = 100000.00;
	
	/** 
	 * Comparator to sort the indexed point with respect to x-axis
	 * @author prupakheti
	 *
	 */
	private class XComparator implements Comparator<IndexedPoint>{
		@Override
		public int compare(IndexedPoint arg0, IndexedPoint arg1) {
			Point p1 = arg0.getPoint();
			Point p2 = arg1.getPoint();
			if( p1.getX() < p2.getX() ) return -1;
			else if( p1.getX() > p2.getX() ) return 1;
			return 0;
		}
		
	}
	
	/** 
	 * Comparator to sort the indexed point with respect to y-axis
	 * @author prupakheti
	 *
	 */
	private class YComparator implements Comparator<IndexedPoint>{
		@Override
		public int compare(IndexedPoint arg0, IndexedPoint arg1) {
			Point p1 = arg0.getPoint();
			Point p2 = arg1.getPoint();
			if( p1.getY() < p2.getY() ) return -1;
			else if( p1.getY() > p2.getY() ) return 1;
			return 0;
		}		
	}
	
	/**
	 * 
	 * @param points : list of points to pre process
	 */
	private void preProcess(List<Point> points){		
		pointsX = new IndexedPoint[points.size()];
		pointsY = new IndexedPoint[points.size()];
		indxMapY = new int[points.size()];
		Iterator<Point> pointItr = points.iterator();
		
		int idx = 0;
		while( pointItr.hasNext() ){
			Point p = pointItr.next();
			pointsX[idx] = new IndexedPoint(p, idx);
			pointsY[idx] = new IndexedPoint(p, idx);
			++idx;
		}
		
		Arrays.sort(pointsX, new XComparator());
		Arrays.sort(pointsY, new YComparator());
		
		for( int i = 0; i < pointsY.length; ++i ){
			indxMapY[ pointsY[i].getIndex()] = i;
		}
		min = INF;
		
	}
	
	
	private double findClosestPoints(int start, int end) throws Exception{
		double m = INF;
		if( start == end ) return m;
		else if ( end - start == 1 ) {
			double tempMin = pointsX[start].getPoint().distanceTo( pointsX[end].getPoint());
			if( tempMin < min ){				
				pf = pointsX[start].getPoint(); ps = pointsX[end].getPoint();
				min = tempMin;
			}
			return tempMin;
		}
		else{
			// divide strategy
			int mid = ( start + end ) / 2;			
			double min1 = findClosestPoints(start, mid); 
			double min2 = findClosestPoints(mid+1, end); 
			
			m = Math.min(min1, min2);		
			
			//conquer strategy
			m = mergeMin(start,end, m);
			if( m < min){
				min = m;
			}
			
		}
		return m;
		
	}
	
	private double mergeMin(int start, int end, double m) throws Exception{		
		boolean []isPresent = new boolean[pointsY.length];
		int mid = (start+end)/2;
		double boarder = pointsX[mid].getPoint().getX();
		double leftBoundry = boarder -(  min / 2.0 ); // left boundry of the bounding rectangle that spans mid/2 across the boarder line either side
		double rightBoundry = boarder + (min / 2.0 ); // right boundry of the bounding rectangle that spans mid/2 across the boarder line either side
		Point[] sortedY = new Point[end - start + 1]; // we are storing all the points(sorted by y co-ordinates ) from start to end in the array pointX 
		
		//marking phase to identify points in pointsY that is mapped to pointsX
		for( int i = start; i <= end; ++i) {
			int idx = pointsX[i].getIndex();
			isPresent[idx] = true;
		}
		
		// collection phase after marking. it collects all the corresponding mapping sorted by y co-ordinates
		int idx = 0;
		for( int i = 0; i < pointsY.length; ++i ){
			if( isPresent[i]){
				sortedY[idx] = pointsY[i].getPoint();
				idx++;
			}
		}		
		
		// the rectangle bounding technique where each points is only copared to maximum of 6 neighbouring points 
		for( int i = 0; i < sortedY.length; ++i ){
			double x = sortedY[i].getX();
			if( x >= leftBoundry && x <= rightBoundry ){
				double y = sortedY[i].getY();
				int j = i + 1;
				while( j < sortedY.length && sortedY[j].getY() - y < min){
					double tempDist = sortedY[i].distanceTo(sortedY[j]);
					if( tempDist < m){
						if( tempDist < min ){
							pf = sortedY[i]; ps = sortedY[j];
							min = tempDist;
						}
						m = tempDist;
					}
					++j;
				}
				
			}
			
		}
		
		return m;
		
		
	}
	
	@Override
	public void findClosestPoints(List<Point> points) throws Exception {
		if( points.size() < 2 ) return;
		preProcess(points);
		findClosestPoints(0, pointsX.length - 1 );
		
	}

	@Override
	public void showResult() throws Exception {
		if(pf != null && ps != null ){
			System.out.println("Closest points are "+ps+" and "+pf+" "+ pf.distanceTo(ps)+" units apart");
		}
		
	}

}

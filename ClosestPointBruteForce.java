package closestpoints;


import java.util.Iterator;
import java.util.List;

public class ClosestPointBruteForce implements ClosestPoint{
	private Point p1; 
	private Point p2;
	double minDist;
	public ClosestPointBruteForce() {
		minDist = Double.MAX_VALUE;
	}

	@Override
	public void findClosestPoints(List<Point> points) throws Exception{
		if(points.size() < 2 ) return;
		Point[] pointArr = new Point[points.size()];
		Iterator<Point> pointItr = points.iterator();
		int idx = 0;
		while( pointItr.hasNext() ){
			pointArr[idx++] = pointItr.next();
		}
		
		for( int i =0; i < pointArr.length - 1; ++i){
			for( int j = i + 1; j < pointArr.length; ++j){
				double tempDist = pointArr[i].distanceTo(pointArr[j]);
				if( tempDist < minDist){
					minDist = tempDist;
					p1 = pointArr[i]; p2 = pointArr[j];
				}
			}
		}
		
		
	}

	@Override
	public void showResult() throws Exception{
		if(p1 != null && p2 != null ){
			System.out.println("Closest points are "+p1+" and "+p2+" "+ p1.distanceTo(p2)+" units apart");
		}
		
	}
	

}

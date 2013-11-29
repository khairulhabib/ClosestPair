package closestpoints;

public class IndexedPoint {
	private Point point; // cartesian point 
	private int index; // the index location of the point where the given point is located in an array of our interest.
	
	public IndexedPoint(Point p, int i){
		point = p;
		index = i;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}	
}

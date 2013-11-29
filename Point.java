package closestpoints;

public class Point {
	private double x;
	private double y;
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * 
	 * @param that : the point to which the distance of this point has to be computer
	 * @return the cartesian distance between this point and that
	 * @throws Exception
	 */
	public double distanceTo(Point that) throws Exception{
		if( that == null ) throw new Exception("Null point exception ");
		double dist = 0.0;
		double delx = that.x - this.x;
		double dely = that.y - this.y;
		dist = Math.sqrt( (delx * delx)  + (dely * dely) );
		return dist;
	}
	
	@Override
	public String toString(){
		return "("+x+","+y+")" ;
	}

}

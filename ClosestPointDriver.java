package closestpoints;

import java.util.List;
import java.util.Scanner;

public class ClosestPointDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		long bruteForceTime;
		long divideAndConquerTime;
		long t1;
		long t2;
		
		PointReader pointsReader = new ScannerPointsReader();
		if(args.length > 0 ){
			if(args[0] != null && "r".equals(args[0].toLowerCase())){
				pointsReader = new RandomPointsReader();
			}
		}
		List<Point> points = pointsReader.getPoints(new Scanner(System.in));
		ClosestPoint closestPointBruteForce = new ClosestPointBruteForce();
		ClosestPoint closestPointDivideAndConquer = new ClosestPointDivideAndConquer();
		
		t1= System.currentTimeMillis();
		closestPointBruteForce.findClosestPoints(points);
		t2 = System.currentTimeMillis();
		bruteForceTime = t2 - t1;
		System.out.println(" Brute Force Results : ");
		closestPointBruteForce.showResult();
		System.out.println("Total time : " + bruteForceTime);
		
		
		t1= System.currentTimeMillis();
		closestPointDivideAndConquer.findClosestPoints(points);
		t2 = System.currentTimeMillis();
		divideAndConquerTime = t2 - t1;
		System.out.println(" Divide and Conquer Results : ");
		closestPointBruteForce.showResult();
		System.out.println("Total time : " + divideAndConquerTime);
		
		
		
	}

}

package closestpoints;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomPointsReader implements PointReader{

	@Override
	public List<Point> getPoints(Scanner sc) throws Exception {
		List<Point> points = new ArrayList<Point>();		
		Random random = new Random(System.currentTimeMillis());
		int total = 1000;
		System.out.println(" How many random points ? ");
		total = Integer.parseInt(sc.nextLine());
		for( int i = 0; i < total; ++i){
			points.add(new Point(random.nextInt(10000),random.nextInt(10000)));
		}
		
		return points;
	}

}

package closestpoints;

import java.util.List;
import java.util.Scanner;

public interface PointReader {
	public List<Point> getPoints(Scanner sc)throws Exception;
}

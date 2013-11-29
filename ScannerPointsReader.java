package closestpoints;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerPointsReader implements PointReader{
	
	
	public List<Point> getPoints(Scanner sc)throws Exception{
		List<Point> points = new ArrayList<Point>();
		String line;
		Point p;
		while(sc.hasNext()){
			line = sc.nextLine();
			if("end".equals(line)) break;
			p = getPoint(line);
			if( p != null ){
				points.add(p);
			}
			else{
				System.out.println("Invalid entry. Moving on to read next line of data entry");
			}
		}
		return points;
	}
	private Point getPoint(String line){
		if( line == null ) return null;
		String []tokens = line.split("\\s+");
		Point p = null;
		if(tokens.length == 2) {
			try{
				double x = Double.parseDouble(tokens[0]);
				double y = Double.parseDouble(tokens[1]);	
				p = new Point(x, y);
			}
			catch(Exception e){
				
			}		
		}			
		return p;
	}

}

import java.util.ArrayList;

public class PolygonHW {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		// constructor 1
		ArrayList<Point> coors1 = new ArrayList<Point>();
		coors1.add(new Point(0.0, 0.0));
		coors1.add(new Point(0.0, 1.0));
		coors1.add(new Point(1.0, 0.0));
		Triangle t1 = new Triangle(3, coors1);
//		System.out.println(t1);
		
		ArrayList<Point> coors2 = new ArrayList<Point>();
		Triangle t2 = new Triangle(3, coors2);
//		t2.addOneCordinate(0, 0);
//		t2.addOneCordinate(4, 0);
//		t2.addOneCordinate(2, 2*Math.sqrt(3));
//		System.out.println(t2.isEquilateral());
//		
		
		//constructor 2
		Triangle t3 = new Triangle(new Point(0.0, 0.0), new Point(0.0, 1.0), new Point(1.0, 0.0));
//		System.out.println(t3);
		
		ArrayList<Point> coors3 = new ArrayList<Point>();
		Triangle t4 = new Triangle(coors3);
		t4.addOneCordinate(0.0, 1.0);
		t4.addOneCordinate(0.0, -1.0);
		t4.addOneCordinate(Math.sqrt(3), 0.0);
//		System.out.println(t4);
		
		System.out.println("t3 is equilateral:");
		System.out.println(t3.isEquilateral());
		System.out.println("t4 is equilateral:");
		System.out.println(t4.isEquilateral());
		System.out.println("t3 area:");
		System.out.println(t3.area());
		System.out.println("t4 area:");
		System.out.println(t4.area());
	}
	
	
	public static abstract class Polygon{
		
		int numOfSides;
		ArrayList<Point> coordinates; 
		
		
		public Polygon(int sides) {
			
			this.numOfSides = sides; 
			coordinates = new ArrayList<>();
			
		}
		
		
		public Polygon(int sides, ArrayList<Point> coors) {
			
			this.numOfSides = sides;
			coordinates = coors; 
			
		}
		
		void addOneCordinate(double x, double y) {
			
			//Finish this by adding one point on the ArrayList in the abstract class
			Point p = new Point(x, y);
			coordinates.add(p);

		}
		
		
		abstract double area(); //Finish this
		abstract boolean isEquilateral(); //Finish this
		
		
		public int sumOfInteriorAngles() {
			
			return 180 * (numOfSides-2);
			
		}
		
		
		public int interiorAngle() {
			
			if(isEquilateral()) return sumOfInteriorAngles()/numOfSides; 
			return -1; 
			
		}
		
	}


	public static class Triangle extends Polygon {
	
		public Triangle(int sides, ArrayList<Point> coors){
			super(sides, coors);
		}
		
		public Triangle(ArrayList<Point> coors){
			super(3, coors);
		}
		
		public Triangle(Point p1, Point p2, Point p3){
			super(3);
			coordinates = new ArrayList<Point>();
			coordinates.add(p1);
			coordinates.add(p2);
			coordinates.add(p3);
		}


		@Override
		double area() {
			// TODO Auto-generated method stub
			
			double x0 = coordinates.get(0).x;
			double y0 = coordinates.get(0).y;
			double x1 = coordinates.get(1).x;
			double y1 = coordinates.get(1).y;
			double x2 = coordinates.get(2).x;
			double y2 = coordinates.get(2).y;
			
			return Math.abs((x0*y1+x1*y2+x2*y0-x0*y2-x1*y0-x2*y1)*0.5);
		}

		@Override
		boolean isEquilateral() {
			
			// TODO Auto-generated method stub
			Point p0 = coordinates.get(0);
			Point p1 = coordinates.get(1);
			Point p2 = coordinates.get(2);
			
			
			double d1 = getDistanceSquared(p0, p1);
			double d2 = getDistanceSquared(p1, p2);
			double d3 = getDistanceSquared(p2, p0);
			
//			System.out.println(d1);
//			System.out.println(d2);
//			System.out.println(d3);
//			System.out.println(d1-d2);
////			
			return (Math.abs(d1-d2) <= 0.0000003 && Math.abs(d2-d3)<= 0.0000003);
		}
	
	}
	
	
	public static class Point {
		
		double x; 
		double y;
		
		public Point(double xx, double yy) {
			x = xx;
			y = yy; 
		}
		
	}
	
	private static double getDistanceSquared(Point p1, Point p2) {

		return Math.pow((p1.x-p2.x), 2)+ Math.pow((p1.y-p2.y), 2);
		
	}
}

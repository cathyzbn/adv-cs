
public class HW {
		
	public interface Place{
		int distance(Place other);
	}
	
	public static class Point implements Place{
		
		private int d;
		
		public Point(int d) {
			
			this.d = d; 
			
		}
		
		public int distance(Place other)
		{
			return Math.abs(this.d - ((Point)other).d);
		}
		
		
	}
	
	public static boolean sameDistance(Place p1, Place p2, Place p3){
        return p1.distance(p2) == p1.distance(p3);
      }
	
	public static void main(String[] args)
    {
      Point p1 = new Point(0);
      Point p2 = new Point(1);
      Point p3 = new Point(2);
      System.out.println(sameDistance(p2, p1, p3));
}
}

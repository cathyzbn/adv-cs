import java.awt.Color;
import java.awt.Graphics;

public class FancyBalloon extends Balloon {
	
	public FancyBalloon() {}
	
	public FancyBalloon(int x, int y, int r, Color c) {
		super(x, y, r, c);
	}
	  public double distance(int x, int y)
	  {
		int xCenter = getX();
		int yCenter = getY();
		
	    double dx = 2*(x - xCenter);
	    double dy = y - yCenter;
	    return Math.max(Math.abs(dx), Math.abs(dy));
	  }
	  
	  public void draw(Graphics g, boolean makeItFilled)
	  {
		int x = getX();
		int y = getY();
		int r = getRadius();
		g.setColor(getColor());
		if (makeItFilled)
		  g.fillRect(x-r, y-r, r, 2*r);
		else
		  g.drawRect(x-r, y-r, r, 2*r);
		}	
}


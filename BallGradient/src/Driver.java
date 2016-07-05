import java.awt.Color;

/**
 * @author PMARINA
 * @version May 6, 2016
 */

public class Driver {
	private static Pointer mp = new Pointer(0, 0);

	public static void main(String[] args) {
		StdDraw.setScale(-1, 1);
		StdDraw.setPenColor(StdDraw.BLACK);
		//StdDraw.filledCircle(0, 0, 1); //this is the black circle 
		drawGradient();
	}

	public static void drawGradient() {
		while (true) {
			double[] place = mp.updatePos();
			double startx = place[0];
			double starty = place[1];
			double x = 1;
			double y = 1;
			while (x > -1) {
				y = 1;
				while (y > -1) {
					double distTo = ((Math.sqrt(Math.pow(startx + x, 2) +  Math.pow(starty+y,2)))/2.0);
					if(distTo>1){
						distTo = 1;
					}
					StdDraw.setPenColor(new Color(1-(int)(distTo*255),1-(int)(distTo*255),1-(int)(distTo*255)));
					StdDraw.filledCircle(x, y, .01);//too small?
					y -=0.01;//Should run
				}
				x-=0.01;//Through entire grid
			}
		}
	}
}

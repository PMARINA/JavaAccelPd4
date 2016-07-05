import java.util.ArrayList;

/**
 * Web Exercise 47: Simple harmonic motion. Create an animation like the one
 * below from Wikipedia of simple harmonic motion:
 * https://en.wikipedia.org/wiki/File:Simple_harmonic_motion_animation.gif
 * 
 * @author PMARINA
 * @version Jun 14, 2016
 */

public class SimpleHarmonic {
	public static void main(String[] args) {
		// set scale
		StdDraw.setYscale(-1, 1);
		StdDraw.setXscale(-Math.PI, Math.PI);
		// arraylist to save pts
		ArrayList<Double> x = new ArrayList<Double>();
		ArrayList<Double> y = new ArrayList<Double>();
		// current x position (for sin)
		double s = 0;
		// sim loop
		while (true) {
			// Make a new coordinate,
			x.add(new Double(0));
			y.add(Math.sin(s));
			// increase the s, for the next frame
			s += 0.01;
			// Decrease x values so that it looks like the ball is only moving
			// up and down
			for (int i = 0; i < x.size() - 1; i++) {
				x.set(i, x.get(i).doubleValue() - 0.01);
			}
			// Remove numbers if they are off the screen, we dont want to slow
			// down the sim as it continues by drawing points that dont exist
			for (int i = 0; i < x.size(); i++) {
				if (x.get(i) < -Math.PI) {
					x.remove(i);
					y.remove(i);
				}
				StdDraw.point(x.get(i), y.get(i));
			}
			// We draw an ellipse because x and y dont have the same scale
			StdDraw.filledEllipse(x.get(x.size() - 1), y.get(y.size() - 1), Math.PI / 16.0, 1.0 / 16.0);// This
																										// is
																										// how
																										// we
																										// make
																										// a
																										// circle...
			// Draw the axis
			StdDraw.line(-Math.PI, 0, Math.PI, 0);
			StdDraw.line(0, -1, 0, 1);
			// Dont give people seizures (show)
			StdDraw.show(5);
			StdDraw.clear();
		}
	}
}

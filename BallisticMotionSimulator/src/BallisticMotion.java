import java.awt.Font;
import java.util.ArrayList;

/**
 * Use the program given in exercise 23 to enhance it to show the image bellow:
 * 1. The values should change as the ball travels through the air. 2. The
 * values should move with the ball. 3. The arrow should get smaller or larger
 * according to the velocity. 4. The blue text and dotted curve is not included
 * in the GUI.
 * 
 * @author PMARINA
 * @version April 8, 2016
 */
public class BallisticMotion {

	/**
	 * @return whether or not the user has pressed the space bar for pausing the
	 *         sim
	 */
	public static boolean checkForPause() {
		if (StdDraw.hasNextKeyTyped()) {
			if (StdDraw.nextKeyTyped() == ' ')
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		double G = 9.8; // gravitational constant m/s^2
		double C = 0.002; // drag force coefficient
		Font font = new Font("Comic Sans MS", Font.PLAIN, 20);
		StdDraw.setFont(font);
		double v = Double.parseDouble(args[0]); // velocity
		double theta = Math.toRadians(Double.parseDouble(args[1])); // angle in
																	// radians
		double t = 0;
		double x = 0.0, y = 0.0; // position
		double vx = v * Math.cos(theta); // velocity in x direction
		double vy = v * Math.sin(theta); // velocity in y direction

		double ax = 0.0, ay = 0.0; // acceleration
		double dt = 0.01; // time quantum

		double maxR = v * v / G; // maximum distance without drag force
		ArrayList<Double> xPoints = new ArrayList<Double>();
		xPoints.add(new Double(0.0));
		ArrayList<Double> yPoints = new ArrayList<Double>();
		yPoints.add(new Double(0.0));
		StdDraw.setXscale(0, maxR);
		StdDraw.setYscale(0, maxR); // set the same as for X-scale

		// loop until ball hits ground
		int posInArr = 1;
		while (y >= 0.0) {
			t+= dt;
			if (checkForPause())
				pause(); // If the user wishes to pause the simulation, then
							// pause it!
			StdDraw.clear(); // Clear the screen to avoid a giant line
			posInArr++; // Increment the position of the values in the
						// arrayLists - xcoord, and ycoord
			v = Math.sqrt(vx * vx + vy * vy); // The velocity
			ax = -C * v * vx; // The x acceleration
			ay = -G - C * v * vy; // The y acceleration
			vx += ax * dt; // The x velocity
			vy += ay * dt; // The y velocity
			x += vx * dt; // The x coord of the thingamabob
			y += vy * dt; // The y coord of the thingamabob
			xPoints.add(new Double(x));// Add the x coordinate to the arrayList
										// of x coordinates
			yPoints.add(new Double(y)); // Add the y coordinate to the arrayList
										// of y coordinates
			StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
			StdDraw.filledCircle(x, y, 0.25);// Draw the ball
			StdDraw.setPenColor();
			for (int i = 1; i < posInArr; i++)
				StdDraw.line(xPoints.get(i - 1), yPoints.get(i - 1), xPoints.get(i), yPoints.get(i)); // Draw
																										// the
																										// trajectory
																										// of
																										// the
																										// space
																										// it
																										// has
																										// already
																										// moved
																										// through
			// Draw all the Information around the ball
			StdDraw.textLeft(4 * maxR / 100 + x, y, "vx = " + roundOff(vx, 3));
			StdDraw.textLeft(4 * maxR / 100 + x, y - 4 * maxR / 100, "x = " + roundOff(x, 3));
			StdDraw.textLeft(4 * maxR / 100 + x, y - 8 * maxR / 100, "ax = " + roundOff(ax, 3));
			StdDraw.textLeft(x - 20 * maxR / 100, y - 0 * maxR / 100, "vy = " + roundOff(vy, 3));
			StdDraw.textLeft(x - 20 * maxR / 100, y - 4 * maxR / 100, "y = " + roundOff(y, 3));
			StdDraw.textLeft(x - 20 * maxR / 100, y - 8 * maxR / 100, "ay = " + roundOff(ay, 3));
			StdDraw.text(x, y + 4 * maxR / 100, "t = " + t);
			StdDraw.setPenColor(StdDraw.BOOK_RED);
			StdDraw.textRight(maxR, maxR - 5 * maxR / 100, "Ballistic Motion Simulator");
			// Draw the arrow, which represents the velocities
			StdDraw.line(x, y, x + vx / maxR, y);
			StdDraw.line(x, y, x, y + vy / maxR);

			StdDraw.show(5);
		}
		// Wait for the user to want to see the end-stats
		StdDraw.textLeft(0, maxR - 10 * maxR / 100, "Press Enter/Return for stats");
		StdDraw.show();
		waitForEnter();
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.textLeft(0, maxR - 4 * maxR / 100, "End Stats");
		StdDraw.textLeft(0, maxR - 8 * maxR / 100, "vx = " + roundOff(vx, 3));
		StdDraw.textLeft(0, maxR - 12 * maxR / 100, "x = " + roundOff(x, 3));
		StdDraw.textLeft(0, maxR - 16 * maxR / 100, "ax = " + roundOff(ax, 3));
		StdDraw.textLeft(0, maxR - 20 * maxR / 100, "vy = " + roundOff(vy, 3));
		StdDraw.textLeft(0, maxR - 24 * maxR / 100, "y = " + roundOff(y, 3));
		StdDraw.textLeft(0, maxR - 28 * maxR / 100, "ay = " + roundOff(ay, 3));
		StdDraw.textLeft(0, maxR - 32	 * maxR / 100, "t = " + t);
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		StdDraw.textLeft(maxR, maxR - 5 * maxR / 100, "Ballistic Motion Simulator");
	}

	/**
	 * Pause the simulation until the spacebar has been pressed again
	 */
	public static void pause() {
		boolean done = false;
		while (!done) {
			if (StdDraw.hasNextKeyTyped()) {
				if (StdDraw.nextKeyTyped() == ' ')
					done = true;
			}
		}
	}

	/**
	 * @param num
	 *            - the number being rounded
	 * @param roundFactor
	 *            - the number of decimal places
	 * @return - the number, rounded to the specified place value
	 */
	private static double roundOff(double num, int roundFactor) {
		return ((double) ((int) (num * Math.pow(10, roundFactor)))) / Math.pow(10, roundFactor);
	}

	/**
	 * Wait for the user to press enter
	 */
	private static void waitForEnter() {
		boolean done = false;
		while (!done) {
			if (StdDraw.hasNextKeyTyped())
				if (StdDraw.nextKeyTyped() == '\n')
					done = true;
		}
	}

}

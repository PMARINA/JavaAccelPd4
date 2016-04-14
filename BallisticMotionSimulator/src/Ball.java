import java.awt.Font;
import java.util.ArrayList;

/**
 * Use the program given in exercise 23 to enhance it to show the image bellow:
 * 1. The values should change as the ball travels through the air. 2. The
 * values should move with the ball. 3. The arrow should get smaller or larger
 * according to the velocity. 4. The blue text and dotted curve is not included
 * in the GUI. - with object oriented design
 * 
 * @author PMARINA
 * @version 3/13/2016
 */
public class Ball {
	public static final double G = 9.8;
	public static final double C = 0.002;
	private double v;
	private double theta;
	private Font font = new Font("Comic Sans MS", Font.PLAIN, 20);
	private double t = 0;
	private double[] pos = new double[2];
	private double vx = v * Math.cos(theta); // velocity in x direction
	private double vy = v * Math.sin(theta); // velocity in y direction
	private double ax = 0, ay = 0;
	private double dt;
	private double maxR = v * v / G;
	private ArrayList<Double> xPoints = new ArrayList<Double>();
	private ArrayList<Double> yPoints = new ArrayList<Double>();
	private double posInArr = 0;
	private boolean innited = false;
	private int simSpeedMillis;
	private boolean moving = true;

	/**
	 * Default constructor of the Ball object. It sets the values of fields to
	 * their default values.
	 */
	public Ball() {
		this.v = 0;
		this.theta = 0;
		this.dt = 0.001;
		Double zero = new Double(0);
		xPoints.add(zero);
		yPoints.add(zero);
		this.maxR = v * v / G;
	}

	/**
	 * @param v
	 *            - velocity of the ball
	 * @param degrees
	 *            - the direction angle of ball's vector
	 */
	public Ball(double v, double degrees) {
		this.v = v;
		this.theta = Math.toRadians(degrees);
		this.dt = 0.001;
		Double zero = new Double(0);
		xPoints.add(zero);
		yPoints.add(zero);
		this.maxR = v * v / G;
	}

	/**
	 * @param v
	 *            - the velocity of the ball
	 * @param degrees
	 *            - the direction angle of the ball's vector
	 * @param dt
	 *            - the difference in time between each call of update();
	 */
	public Ball(double v, double degrees, double dt) {
		this.v = v;
		this.theta = Math.toRadians(degrees);
		this.dt = dt;
		Double zero = new Double(0);
		xPoints.add(zero);
		yPoints.add(zero);
		this.maxR = v * v / G;
	}

	/**
	 * A setter of the ball's velocity
	 * 
	 * @param v
	 *            - the new velocity of the ball
	 */
	public void setVelocity(double v) {
		this.v = v;
	}

	/**
	 * A setter of the ball's vector's direction angle
	 * 
	 * @param degrees
	 *            - the new direction angle of the ball
	 */
	public void setAngle(double degrees) {
		this.theta = Math.toRadians(degrees);
	}

	/**
	 * The new font to be used - java.awt.Font
	 * 
	 * @param font
	 *            - new font
	 */
	public void setFont(Font font) {
		this.font = font;
	}

	/**
	 * Updates the position of the ball, using the given time constraints
	 */
	public void update() {
		if (!innited) {
			this.vx = this.v * Math.cos(theta); // velocity in x direction
			this.vy = this.v * Math.sin(theta); // velocity in y direction
			this.maxR = this.v * this.v / this.G;
		}
		if ((this.moving && this.pos[0] >= -0.01)) {
			this.posInArr++;
			this.t += this.dt;
			this.v = Math.sqrt(this.vx * this.vx + this.vy * this.vy); // The
																		// velocity
			this.ax = -this.C * this.v * this.vx; // The x acceleration
			this.ay = -this.G - this.C * this.v * this.vy; // The y acceleration
			this.vx += this.ax * this.dt; // The x velocity
			this.vy += this.ay * this.dt; // The y velocity
			this.pos[0] += this.vx * this.dt; // The x coord of the thingamabob
			this.pos[1] += this.vy * this.dt; // The y coord of the thingamabob
			this.xPoints.add(new Double(this.pos[0]));// Add the x coordinate to
														// the arrayList
			// of x coordinates
			this.yPoints.add(new Double(this.pos[1])); // Add the y coordinate
														// to the arrayList
			// of y coordinates
			this.moving = this.pos[1] > 0;
			// of y coordinates
		} else
			this.moving = false;
	}

	/**
	 * @return whether or not the ball is moving
	 */
	public boolean isMoving() {
		return this.moving;
	}

	/**
	 * Draws the current position of the ball, as well as its trail
	 */
	public void drawToScreen() {
		if (!innited) {
			StdDraw.setXscale(0, maxR);
			StdDraw.setYscale(0, maxR);
			StdDraw.setFont(font);
			innited = true;
		}
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.filledCircle(pos[0], pos[1], 0.25);// Draw the ball
		StdDraw.setPenColor();
		for (int i = 1; i < posInArr; i++)
			StdDraw.line(xPoints.get(i - 1), yPoints.get(i - 1), xPoints.get(i), yPoints.get(i));
		// Draw all the Information around the ball
		StdDraw.textLeft(4 * maxR / 100 + pos[0], pos[1], "vx = " + roundOff(vx, 3));
		StdDraw.textLeft(4 * maxR / 100 + pos[0], pos[1] - 4 * maxR / 100, "x = " + roundOff(pos[0], 3));
		StdDraw.textLeft(4 * maxR / 100 + pos[0], pos[1] - 8 * maxR / 100, "ax = " + roundOff(ax, 3));
		StdDraw.textLeft(pos[0] - 20 * maxR / 100, pos[1] - 0 * maxR / 100, "vy = " + roundOff(vy, 3));
		StdDraw.textLeft(pos[0] - 20 * maxR / 100, pos[1] - 4 * maxR / 100, "y = " + roundOff(pos[1], 3));
		StdDraw.textLeft(pos[0] - 20 * maxR / 100, pos[1] - 8 * maxR / 100, "ay = " + roundOff(ay, 3));
		StdDraw.text(pos[0], pos[1] + 4 * maxR / 100, "t = " + roundOff(t, 3));
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		StdDraw.textRight(maxR, maxR - 5 * maxR / 100, "Ballistic Motion Simulator");
		// Draw the arrow, which represents the velocities
		StdDraw.line(pos[0], pos[1], pos[0] + vx / maxR, pos[1]);
		StdDraw.line(pos[0], pos[1], pos[0], pos[1] + vy / maxR);

		StdDraw.show(simSpeedMillis);
	}

	/**
	 * @param num
	 *            - the number being rounded
	 * @param roundFactor
	 *            - the number of decimal places to be rounded to
	 * @return
	 */
	private static double roundOff(double num, int roundFactor) {
		return ((double) ((int) (num * Math.pow(10, roundFactor)))) / Math.pow(10, roundFactor);
	}
}
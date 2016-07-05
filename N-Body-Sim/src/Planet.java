/**
 * planet object class, see main for more info
 * 
 * @author PMARINA
 * @version lets just say late
 */
public class Planet {
	private final static double time = 2.5e5;
	private static final double G = 6.67e-11;
	private double x;
	private double y;
	private double vx;
	private double vy;
	private double m;
	private String name;

	/**
	 * @param x
	 *            starting x value of planet
	 * @param y
	 *            starting y value of planet
	 * @param vx
	 *            initial velocity in the x direction
	 * @param vy
	 *            initial velocity in the y direction
	 * @param m
	 *            mass of the planet
	 * @param name
	 *            the file name of the image
	 */
	public Planet(double x, double y, double vx, double vy, double m, String name) {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.m = m;
		this.name = name;
	}

	/**
	 * Draws the planet
	 */
	public void drawToScreen() {
		StdDraw.picture(x, y, name);
	}

	/**
	 * @return mass
	 */
	public double getMass() {
		return m;
	}

	/**
	 * @return name of the planet
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Velocity of planet in x direction
	 */
	public double getVx() {
		return vx;
	}

	/**
	 * @return Velocity of the planet in the y direction
	 */
	public double getVy() {
		return vy;
	}

	/**
	 * @return horizontal positioning of the planet
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return vertical positioning of the planet
	 */
	public double getY() {
		return y;
	}

	/**
	 * Update x and y, based on base values (does not compare)
	 */
	public void timePlusPlus() {
		this.x += time * this.vx;
		this.y += time * this.vy;
	}

	/*
	 * Recalculate the forces of this planet, based off of other planets' forces
	 */
	public void updatePos(Planet plan) {
		double distanceSqr = Math.pow(plan.x - this.x, 2) + Math.pow(plan.y - this.y, 2);
		double force = G * this.m * plan.m / distanceSqr;
		double vx = force * (plan.x - this.x) / Math.sqrt(distanceSqr);
		double vy = force * (plan.y - this.y) / Math.sqrt(distanceSqr);
		double ax = vx / this.m;
		double ay = vy / this.m;
		this.vx += time * ax;
		this.vy += time * ay;
		System.out.println("**vx " + vx + " vy " + vy + " " + this.name + plan.name);
	}
}

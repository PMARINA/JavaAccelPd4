/**
 * Implement a class Circle that has methods getArea() and getPerimeter(). In
 * the constructor, supply the radius of the circle.
 * 
 * @author PMARINA
 * @version Feb 23, 2016
 */
public class Circle23 {
	private double radius;

	/**
	 * The only constructor of the circle object, which takes the radius as an
	 * argument.
	 * 
	 * @param radius
	 *            - the radius of the circle object
	 */
	public Circle23(double radius) {
		this.setRadius(radius); // Set the radius.
	}

	/**
	 * Calculates and returns the area of the circle.
	 * 
	 * @return - the area of the circle, using formula pi * r^2
	 */
	public double getArea() {
		return Math.PI * Math.pow(radius, 2); // Calculate the area using pr^2
	}

	/**
	 * Calculates and returns the perimeter of the circle
	 * 
	 * @return - the perimeter of the circle
	 */
	public double getPerimeter() {
		return Math.PI * radius * 2; // Get the perimeter of the circle, through
										// the formula 2*pi*r
	}

	/**
	 * An accessor for the radius
	 * 
	 * @return - the radius of the circle
	 */
	public double getRadius() {
		return radius; // return the radius
	}

	/**
	 * A method for changing the radius of the circle object.
	 * 
	 * @param radius
	 *            - the new radius of the circle
	 */
	public void setRadius(double radius) {
		this.radius = radius; // Reset the radius.
	}
}

/**
 * Implement a class Circle that has methods getArea() and getPerimeter(). In
 * the constructor, supply the radius of the circle.
 * 
 * @author PMARINA
 * @version Feb 23, 2016
 */
public class CircleDriver23 {
	/**
	 * Implement a class Circle that has methods getArea() and getPerimeter().
	 * In the constructor, supply the radius of the circle.-- driver class.
	 * 
	 * @param args
	 *            - has no use
	 */
	public static void main(String[] args) {
		Circle23 c = new Circle23(2); // make a circle of radius 4
		System.out.println("The circle of radius: " + c.getRadius() + " units has area: " + c.getArea()
				+ " units^2, and perimeter: " + c.getPerimeter() + " units."); // Print
																				// out
																				// circle
																				// stats
	}
}

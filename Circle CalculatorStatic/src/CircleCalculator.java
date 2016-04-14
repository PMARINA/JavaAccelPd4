
/**
 * CircleCalculator class Write static methods:
 * 
 * public static double sphereVolume(double r) public static double
 * sphereSurface(double r) public static double cylinderVolume(double r, double
 * h) public static double cylinderSurface(double r, double h) public static
 * double coneVolume(double r, double h) public static double coneSurface(double
 * r, double h)
 * 
 * that compute the volume and surface area of a sphere with radius r, a
 * cylinder with circular base with radius r and height h, and a cone with
 * circular base with radius r and height h. Place them into an appropriate
 * class (CircleCalculator).Then write a program, CircleTester that prompts the
 * user for the values of r and h, calls the six methods, and prints the
 * results. - the calculator
 * 
 * @author PMARINA
 * @version 3/20/2016
 */
public class CircleCalculator {
	private static int accuracy = 3; // The accuracy. Note if 0 is the last
										// digit, then it will only be
										// accuracy-1 decimal places.

	/**
	 * @param r
	 *            - the radius of the sphere
	 * @return - the volume of the sphere
	 */
	public static double sphereVolume(double r) {
		return ((double) ((int) (Math.PI * (4.0 / 3.0) * Math.pow(r, 3) * Math.pow(10, accuracy))))
				/ Math.pow(10, accuracy);
	}

	/**
	 * @param r
	 *            - the radius of the sphere
	 * @return - the surface area of the sphere
	 */
	public static double sphereSurface(double r) {
		return ((double) ((int) (Math.pow(10, accuracy) * 4.0 * Math.PI * Math.pow(r, 2)))) / Math.pow(10, accuracy);
	}

	/**
	 * @param r
	 *            - the radius of the cylinder
	 * @param h
	 *            - the height of the cylinder
	 * @return - the volume of the cylinder
	 */
	public static double cylinderVolume(double r, double h) {
		return ((double) ((int) (Math.PI * Math.pow(r, 2) * h * Math.pow(10, accuracy)))) / Math.pow(10, accuracy);
	}

	/**
	 * @param r
	 *            - the radius of the cylinder
	 * @param h
	 *            - the height of the cylinder
	 * @return - the surface area of the cylinder
	 */
	public static double cylinderSurface(double r, double h) {
		return ((double) ((int) (Math.pow(10, accuracy) * 2.0 * Math.PI * r * h + 2.0 * Math.PI * Math.pow(r, 2))))
				/ Math.pow(10, accuracy);
	}

	/**
	 * @param r
	 *            - the radius of the cone
	 * @param h
	 *            - the height of the cone
	 * @return - the volume of the cone
	 */
	public static double coneVolume(double r, double h) {
		return ((double) ((int) (Math.pow(10, accuracy) * Math.PI * Math.pow(r, 2) * (h / 3.0))))
				/ Math.pow(10, accuracy);
	}

	/**
	 * @param r
	 *            - the radius of the cone
	 * @param h
	 *            - the height of the cone
	 * @return - the surface area of the cone
	 */
	public static double coneSurface(double r, double h) {
		return ((double) (int) (Math.pow(10, accuracy)
				* (Math.PI * r * (r + Math.pow(Math.pow(h, 2) + Math.pow(r, 2), 0.5))))) / Math.pow(10, accuracy);
	}
}

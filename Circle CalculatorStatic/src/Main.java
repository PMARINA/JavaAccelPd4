import java.util.Scanner;

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
 * results.
 * 
 * @author PMARINA
 * @version 3/20/2016
 */
public class Main {
	private static Scanner sc = new Scanner(System.in); // A universal scanner -
														// I was having trouble
														// with having more than
														// one scanner, even if
														// I closed the old
														// scanner...

	/**
	 * CircleCalculator class Write static methods:
	 * 
	 * public static double sphereVolume(double r) public static double
	 * sphereSurface(double r) public static double cylinderVolume(double r,
	 * double h) public static double cylinderSurface(double r, double h) public
	 * static double coneVolume(double r, double h) public static double
	 * coneSurface(double r, double h)
	 * 
	 * that compute the volume and surface area of a sphere with radius r, a
	 * cylinder with circular base with radius r and height h, and a cone with
	 * circular base with radius r and height h. Place them into an appropriate
	 * class (CircleCalculator).Then write a program, CircleTester that prompts
	 * the user for the values of r and h, calls the six methods, and prints the
	 * results. - the tester/driver
	 * 
	 * @param args
	 *            - Has no purpose
	 */
	public static void main(String[] args) {
		boolean cont = true; // Whether or not the user wishes to continue
		while (cont) {
			double[] input = getInput();
			System.out.println(
					"The VOLUME of a SPHERE of given specifications is: " + CircleCalculator.sphereVolume(input[1]));
			System.out.println("The SURFACE AREA of a SPHERE of given specifications is: "
					+ CircleCalculator.sphereSurface(input[1]));
			System.out.println("The VOLUME of a CYLINDER of given specifications is: "
					+ CircleCalculator.cylinderVolume(input[1], input[0]));
			System.out.println("The SURFACE AREA of a CYLINDER of given specifications is: "
					+ CircleCalculator.cylinderSurface(input[1], input[0]));
			System.out.println("The VOLUME of a CONE of given specifications is: "
					+ CircleCalculator.coneVolume(input[1], input[0]));
			System.out.println("The SURFACE AREA of a CONE of given specifications is: "
					+ CircleCalculator.coneSurface(input[1], input[0]));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			cont = getContinue();
		}
		sc.close(); // Close the scanner at the end of the program to save
					// resources
	}

	/**
	 * A method which gets the input of the height and radius of any given 3d
	 * circular shape
	 * 
	 * @return - an array containing the user's input
	 */
	public static double[] getInput() {
		System.out.println("Please Provide a Height");
		double h = sc.nextDouble();
		System.out.println("Please provide a Radius");
		double r = sc.nextDouble();
		double[] toBeReturned = { h, r };
		return toBeReturned;
	}

	/**
	 * A method which checks whether or not the user wishes to continue getting
	 * stats from the calculator.
	 * 
	 * @return - whether or not the user wishes to continue: true = yes, false =
	 *         no
	 */
	public static boolean getContinue() {
		System.out.println("\n\nContinue?");
		String in = sc.next();
		if (in.equalsIgnoreCase("y") || in.equalsIgnoreCase("yes"))
			return true;
		return false;
	}
}

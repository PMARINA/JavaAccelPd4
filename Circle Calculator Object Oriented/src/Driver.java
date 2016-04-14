import java.util.Scanner;

/**
 * Output: Please Provide a Height 10 Please Provide a Radius 5 Please Provide
 * an accuracy 4 The VOLUME of a SPHERE of given specifications is: 523.5987 The
 * SURFACE AREA of a SPHERE of given specifications is: 314.1592 The VOLUME of a
 * CYLINDER of given specifications is: 785.3981 The SURFACE AREA of a CYLINDER
 * of given specifications is: 314.1749 The VOLUME of a CONE of given
 * specifications is: 261.7993 The SURFACE AREA of a CONE of given
 * specifications is: 254.1601
 * 
 * 
 * Continue? n
 * 
 * Exercise P7.4. Solve the preceding exercise by implementing classes Sphere,
 * Cylinder, and Cone. Which approach is more object-oriented? - this one
 * 
 * @author PMARINA
 * @version 3/21/2016
 */
public class Driver {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * A method which gets the input of the height and radius of any given 3d
	 * circular shape
	 * 
	 * @return - an array containing the user's input
	 */
	public static double[] getInput() {
		System.out.println("Please Provide a Height");
		double h = sc.nextDouble();
		System.out.println("Please Provide a Radius");
		double r = sc.nextDouble();
		System.out.println("Please Provide an accuracy");
		double a = sc.nextDouble();
		double[] toBeReturned = { r, h, a };
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

	/**
	 * See the class documentation
	 * 
	 * @param args
	 *            - has no purpose
	 */
	public static void main(String[] args) {
		boolean cont = true; // Whether or not the user wishes to continue
		while (cont) {
			double[] input = getInput();
			Sphere aSp = new Sphere(input[0]);
			Cylinder aCy = new Cylinder(input[0], input[1]);
			Cone aCo = new Cone(input[0], input[1]);
			System.out.println("The VOLUME of a SPHERE of given specifications is: " + aSp.volume((int) input[2]));
			System.out.println(
					"The SURFACE AREA of a SPHERE of given specifications is: " + aSp.surfaceArea(((int) input[2])));
			System.out.println("The VOLUME of a CYLINDER of given specifications is: " + aCy.volume(((int) input[2])));
			System.out.println(
					"The SURFACE AREA of a CYLINDER of given specifications is: " + aCy.surfaceArea(((int) input[2])));
			System.out.println("The VOLUME of a CONE of given specifications is: " + aCo.volume(((int) input[2])));
			System.out.println(
					"The SURFACE AREA of a CONE of given specifications is: " + aCo.surfaceArea(((int) input[2])));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			cont = getContinue();
		}
		sc.close();
	}
}

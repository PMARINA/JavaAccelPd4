/**
 * Exercise P2.10. Implement a class Car with the following properties. A car
 * has a certain fuel efficiency (measured in miles/gallon or liters/km—pick
 * one) and a certain amount of fuel in the gas tank. The efficiency is
 * specified in the constructor, and the initial fuel level is 0. Supply a
 * method drive that simulates driving the car for a certain distance, reducing
 * the fuel level in the gas tank, and methods getGas, returning the current
 * fuel level, and addGas, to tank up. Sample usage:
 * 
 * @author PMARINA
 * @version Feb 22, 2016
 */
public class CarDriver {
	/**
	 * Exercise P2.10. Implement a class Car with the following properties. A
	 * car has a certain fuel efficiency (measured in miles/gallon or
	 * liters/km—pick one) and a certain amount of fuel in the gas tank. The
	 * efficiency is specified in the constructor, and the initial fuel level is
	 * 0. Supply a method drive that simulates driving the car for a certain
	 * distance, reduc¬ing the fuel level in the gas tank, and methods getGas,
	 * returning the current fuel level, and addGas, to tank up. Sample usage:
	 * 
	 * @params param1 does this
	 * @returns returns stuff
	 * @throws noInputError
	 *             no input given by the user
	 */
	public static void main(String[] args) {
		try {
			Car myBeemer = new Car(11.5); // Create a new Mustang, so I can at
											// least
											// dream about it
			myBeemer.addGas(20); // Add 20 gallons of gas
			myBeemer.drive(100); // Breaking in the clutch
			System.out.println("My Mustang has: " + myBeemer.getGas() + " gallons of gas left."); // See
																									// how
																									// little
																									// I
																									// have
																									// left
																									// so
																									// I
																									// can
																									// think
																									// about
																									// how
																									// I'm
																									// going
																									// to
																									// get
																									// home
		} catch (Throwable exception) {
			exception.printStackTrace(); // If/when bad things happen, let us
											// know what's going on
		}
	}
}

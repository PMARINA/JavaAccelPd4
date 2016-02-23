/**
 * Exercise P2.10. Implement a class Car with the following properties. A car
 * has a certain fuel efficiency (measured in miles/gallon or liters/km—pick
 * one) and a certain amount of fuel in the gas tank. The efficiency is
 * specified in the constructor, and the initial fuel level is 0. Supply a
 * method drive that simulates driving the car for a certain distance, reduc¬ing
 * the fuel level in the gas tank, and methods getGas, returning the current
 * fuel level, and addGas, to tank up. Sample usage:
 * 
 * @author PMARINA
 * @version Feb 22, 2016
 */
public class Car {
	private double efficiency; // In miles/gallon
	private double gas; // In gallons

	/**
	 * Create a new car of the specified efficiency
	 * 
	 * @param efficiency
	 *            - the efficiency of the car, in miles per gallon
	 * @throws Throwable
	 *             - If the efficiency is not valid
	 */
	public Car(double efficiency) throws Throwable {
		if (efficiency > 0)
			setEfficiency(efficiency); // If the efficiency is valid, then set
										// it
		else
			throw new Throwable("Negative efficiency specified");// Cars don't
																	// make gas
	}

	/**
	 * Add gas to the car, almost as if the driver had stopped at a gas station.
	 * 
	 * @param gas
	 *            - Adds the amount of gas specified
	 * @throws Throwable
	 *             - Throws an exception if the gas amount specified is
	 *             negative.
	 */
	public void addGas(double gas) throws Throwable {
		if (gas > 0)
			setGas(getGas() + gas);
		else
			throw new Throwable("Negative Gas Specified");
	}

	/**
	 * Simulates driving a car with the given methods. Note that car accidents
	 * cannot occur...
	 * 
	 * Note: This method accepts negative values, assuming that the user was
	 * only reversing.
	 * 
	 * @param miles
	 *            - the miles driven during the driving session.
	 */
	public void drive(double miles) {
		gas -= Math.abs(miles) / efficiency;
	}

	/**
	 * A method for finding the efficiency of the vehicle. Note that this is not
	 * fully accurate as it does not have a city/highway mileage, nor are its
	 * methods accurate to the real world.
	 * 
	 * @return - The efficiency of the vehicle
	 */
	public double getEfficiency() {
		return efficiency;
	}

	/**
	 * A method for changing the efficiency of the car.
	 * 
	 * @param efficiency
	 *            - the new efficiency of the car
	 * @throws Throwable
	 *             - Throws an exception if the efficiency provided is negative.
	 */
	public void setEfficiency(double efficiency) throws Throwable {
		if (efficiency > 0)
			this.efficiency = efficiency;
		else
			throw new Throwable("Negative Efficiency Specified");
	}

	/**
	 * @return the amount of gas left in the tank, assuming that the gas cannot
	 *         evaporate.
	 */
	public double getGas() {
		return gas;
	}

	/**
	 * Changes the amount of gas in the tank to the amount specified. Assume
	 * that the tank is infinitely large.
	 * 
	 * @param gas
	 *            - the new amount of gas in the tank
	 */
	public void setGas(double gas) {
		this.gas = gas;
	}
}

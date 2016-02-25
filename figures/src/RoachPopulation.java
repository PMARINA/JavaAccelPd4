/**
 * Implement a class roachpopulation that simulates the growth of a roach
 * population. The constructor takes the size of the initial roach population.
 * The wait method simulates a period in which the population doubles. The spray
 * method simulates spraying the roaches with insecticide, which reduces the
 * population by 10%. The getroach population method returns the current number
 * of roaches. Implement the class and a test program that simulates a kitchen
 * that starts out with 10 roaches. Wait, spray, print. Repeat 3 times.
 * 
 * @author PMARINA
 * @version Feb 25, 2016
 */
public class RoachPopulation {
	private int pop; // The population

	/**
	 * Creates a roach population, unless the population specified is negative.
	 * 
	 * @param pop
	 *            - the popultion of roaches
	 * @throws Throwable
	 *             - if pop<0
	 */
	public RoachPopulation(int pop) throws Throwable {
		if (pop >= 0)
			this.pop = pop; // Constructor, set the roach population unless
							// negative.
		else
			throw new Throwable("Negative Roach Population Specified");
	}

	/**
	 * Grows the population of roaches by doubling it.
	 */
	public void grow() {
		pop *= 2;// Double the population
	}

	/**
	 * Reduces the population of roaches by 10% in order to simulate spraying
	 * pesticide.
	 */
	public void spray() {
		pop *= 0.9;// Reduce the population by 10%
	}

	/**
	 * A getter for the variable pop - population of roaches
	 * 
	 * @return - the population of roaches
	 */
	public int getPop() {
		return pop;// just a getter
	}

}

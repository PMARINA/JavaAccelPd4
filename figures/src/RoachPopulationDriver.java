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
public class RoachPopulationDriver {

	/**
	 * Implement a class roachpopulation that simulates the growth of a roach
	 * population. The constructor takes the size of the initial roach
	 * population. The wait method simulates a period in which the population
	 * doubles. The spray method simulates spraying the roaches with
	 * insecticide, which reduces the population by 10%. The getroach population
	 * method returns the current number of roaches. Implement the class and a
	 * test program that simulates a kitchen that starts out with 10 roaches.
	 * Wait, spray, print. Repeat 3 times.
	 * 
	 * @param args
	 *            - unused
	 */
	public static void main(String[] args) {
		RoachPopulation rp;
		try { // If the population is nonnegative, then it works, otherwise, it
				// doesn't.
			rp = new RoachPopulation(10);// Create the new Roach Population
			for (int i = 0; i < 3; i++) {
				rp.grow();// Wait
				rp.spray();// Spray
				System.out.println(rp.getPop() + " is the current roach population."); // Print
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}

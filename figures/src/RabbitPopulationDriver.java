/**
 * Implement a class RabbitPopulation that simulates the growth of a rabbit
 * population. The rules are as follows: Start with one pair of rabbits. Rabbits
 * are able to mate at the age of one month. A month later, each female produces
 * another pair of rabbits. Assume that rabbits never die and that the female
 * produces one new pair (one male, one female) every month from the second
 * month on. Implement a method wait that waits for one month, and a method
 * getPairs that prints the current number of rabbit pairs. Write a test program
 * that shows the growth of the rabbit population for ten months. Hint: Keep one
 * instance field for the newborn rabbit pairs and another one for the rabbit
 * pairs that are at least one month old. ]
 * 
 * @author PMARINA
 * @version Feb 25, 2016
 */
public class RabbitPopulationDriver {

	/**
	 * Implement a class RabbitPopulation that simulates the growth of a rabbit
	 * population. The rules are as follows: Start with one pair of rabbits.
	 * Rabbits are able to mate at the age of one month. A month later, each
	 * female produces another pair of rabbits. Assume that rabbits never die
	 * and that the female produces one new pair (one male, one female) every
	 * month from the second month on. Implement a method wait that waits for
	 * one month, and a method getPairs that prints the current number of rabbit
	 * pairs. Write a test program that shows the growth of the rabbit
	 * population for ten months. Hint: Keep one instance field for the newborn
	 * rabbit pairs and another one for the rabbit pairs that are at least one
	 * month old.
	 * 
	 * @param args
	 *            - not used
	 */
	public static void main(String[] args) {
		RabbitPopulation rp = new RabbitPopulation(1); // create a rabbit
														// population of size 1
		System.out.println("Beginning with: " + rp.getPairs() + " pair(s).");// Print
																				// out
																				// the
																				// beginning
																				// population
		for (int i = 0; i < 10; i++) {// Just reproduce, and then print out the
										// population statistics
			rp.reproduce();
			System.out.println("There are now: " + rp.getPairs() + " pair(s).");
		}
	}
}

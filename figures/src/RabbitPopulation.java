import java.util.ArrayList;

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
 * pairs that are at least one month old.
 * 
 * @author PMARINA
 * @version Feb 25, 2016
 */
public class RabbitPopulation {
	private ArrayList<RabbitPair> allPairs = new ArrayList<RabbitPair>(); // A
																			// storage
																			// space
																			// for
																			// all
																			// rabbit
																			// pairs

	/**
	 * A constructor for a rabbit population
	 * 
	 * @param pairs
	 *            - the number of rabbit pairs to begin with for this population
	 *            of rabbits
	 */
	public RabbitPopulation(int pairs) {
		for (int i = 0; i < pairs; i++) {
			allPairs.add(new RabbitPair());
		}
	}

	/**
	 * Reproduces all reproducible rabbits, and matures those rabbits that
	 * cannot reproduce.
	 */
	public void reproduce() {
		// Creates a copy of the ArrayList of rabbits, to avoid concurrentAccess
		// error
		ArrayList<RabbitPair> copyPairs = new ArrayList<RabbitPair>();
		for (RabbitPair rb : allPairs) {
			copyPairs.add(rb);
		}

		// For every rabbit pair in the population, if a pair can reproduce,
		// then have them reproduce, otherwise make them mature enough to
		// reproduce for the next month
		for (RabbitPair rb : copyPairs) {
			if (rb.reproduceable())
				allPairs.add(rb.reproduce());
			else
				rb.mature();
		}
	}

	/**
	 * A method that returns the number of rabbit pairs in the population
	 * 
	 * @return the number of rabbit <b>pairs</b>
	 */
	public int getPairs() {
		return allPairs.size();
	}
}

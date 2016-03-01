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
public class RabbitPair {
	private int age = 0; // The age of the rabbit - note - all rabbits are 0
							// months old, including the initial population

	/**
	 * Default constructor
	 */
	public RabbitPair() {
		// DoNothing - nothing needs to be done
	}

	/**
	 * @return the new baby rabbit pair
	 */
	public RabbitPair reproduce() {
		age++; // Advance the age before anything is done
		if (age >= 2) {
			RabbitPair a = new RabbitPair(); // Reproduce...
			return a;
		}
		return null; // Shouldn't ever come to this line, unless programs are
						// changed.
	}

	/**
	 * A method for getting the baby rabbits to a reproducible state
	 */
	public void mature() {
		age = 1;// make a baby rabbit mature.
	}

	/**
	 * @return whether or not the rabbit pair is able to reproduce
	 */
	public boolean reproduceable() {
		return age >= 1;// If the rabbit pair is reproducible, it must be more
						// than one month old.
	}

}

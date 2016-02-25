/*
 * [PROMPT]
 * @author PMARINA
 * @version Feb 25, 2016
 */
public class RabbitPair {
	private int age = 0;

	public RabbitPair() {
		// DoNothing - nothing needs to be done
	}

	public RabbitPair reproduce() {
		age++;
		if (age >= 1) {
			RabbitPair a = new RabbitPair();
			return a;
		}
		else return null;
	}

}

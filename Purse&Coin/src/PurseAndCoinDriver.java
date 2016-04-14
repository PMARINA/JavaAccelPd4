
/**
 * Exercise P7.1. Implement the Purse and Coin classes described in Section 7.2.
 * Implement the tester class and create a purse and several coins. Display the
 * purse total. Link:
 * http://phs.princetonk12.org/teachers/gelia/StudentResources/java/BJChapter7.
 * pdf, page = 3 (283 in actual text) - driver class
 * 
 * @author PMARINA
 * @version 2/17/2016
 */
public class PurseAndCoinDriver {
	/**
	 * Exercise P7.1. Implement the Purse and Coin classes described in Section
	 * 7.2. Implement the tester class and create a purse and several coins.
	 * Display the purse total. Link:
	 * http://phs.princetonk12.org/teachers/gelia/StudentResources/java/
	 * BJChapter7. pdf, page = 3 (283 in actual text) - driver main method
	 * 
	 * @param args
	 *            - no significance
	 */
	public static void main(String[] args) {
		Purse ep = new Purse(); // Create a new purse
		ep.setName("Mrs. Elia's Purse"); // Give the purse a name
		for (int i = 0; i < 10; i++) {
			ep.add(new Coin(0.25, "Quarter")); // Add 10 quarters
		}
		System.out.println(ep.getName() + " has $" + ep.getTotal() + "."); // Print
																			// out
																			// the
																			// value
																			// of
																			// the
																			// purse
	}
}

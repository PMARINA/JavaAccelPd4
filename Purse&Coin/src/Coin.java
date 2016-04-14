/**
 * Exercise P7.1. Implement the Purse and Coin classes described in Section 7.2.
 * Implement the tester class and create a purse and several coins. Display the
 * purse total. Link:
 * http://phs.princetonk12.org/teachers/gelia/StudentResources/java/BJChapter7.
 * pdf, page = 3 (283 in actual text) - the coin class.
 * 
 * @author PMARINA
 * @version 3/17/2016
 */
public class Coin {
	private String name;
	private double value;

	/**
	 * A constructor for the coin object. Note that if a negative value is
	 * specified, then a value of 0 will be assigned. In addition, there is
	 * currently a limitation on the various currencies.
	 * 
	 * @param value
	 *            - the value of the coin in whichever currency it is in
	 * @param name
	 *            - the name of the coin
	 */
	public Coin(double value, String name) {
		if (value >= 0) {
			this.value = value;
			this.name = name;
		} else {
			this.value = 0;
			this.name = null;
		}
	}

	/**
	 * An accessor method for the name of the coin.
	 * 
	 * @return - the name of the coin
	 */
	public String getName() {
		return name;
	}

	/**
	 * An accessor method for the value of the coin
	 * 
	 * @return - the value of the coin
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * A mutator method for the name of the coin
	 * 
	 * @param name
	 *            - the new name of the coin
	 */
	public void setName(String name) {
		this.name = name;
	}
}
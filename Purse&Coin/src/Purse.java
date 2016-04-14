import java.util.ArrayList;

/**
 * Exercise P7.1. Implement the Purse and Coin classes described in Section 7.2.
 * Implement the tester class and create a purse and several coins. Display the
 * purse total. Link:
 * http://phs.princetonk12.org/teachers/gelia/StudentResources/java/BJChapter7.
 * pdf, page = 3 (283 in actual text) - purse class
 * 
 * @author PMARINA
 * @version 2/17/2016
 */
public class Purse {
	private String name;
	private ArrayList<Coin> purseContents = new ArrayList<Coin>();
	private double total;

	/**
	 * A default constructor, sets all variables to their default settings.
	 */
	public Purse() {
		this.total = 0;
		this.name = "";

	}

	/**
	 * A constructor for the purse class
	 * 
	 * @param total
	 *            - the total value of the purse
	 * @param name
	 *            - the name of the purse/its owner, depending on usage
	 */
	public Purse(double total, String name) {
		this.total = total;
		this.name = name;
	}

	/**
	 * Adds a coin to the purse
	 * 
	 * @param aCoin
	 *            - the coin being added to the purse
	 */
	public void add(Coin aCoin) {
		total += aCoin.getValue();
		purseContents.add(aCoin);
	}

	/**
	 * An accessor method for the name of the purse
	 * 
	 * @return - the name of the purse/its owner, depending on usage
	 */
	public String getName() {
		return name;
	}

	/**
	 * An accessor method for the value of the purse
	 * 
	 * @return - the total value of the purse
	 */
	public double getTotal() {
		return this.total;
	}

	/**
	 * Removes the specified coin from the purse. If it does not exist, it
	 * prints the error message and makes no modifications. Note that if the
	 * constructor taking a string and double arguments, it is possible to have
	 * an empty purse that still has value
	 * 
	 * @param aCoin
	 *            - the coin being removed from the purse
	 */
	public void remove(Coin aCoin) {
		if (purseContents.contains(aCoin)) {
			total -= aCoin.getValue();
			purseContents.remove(aCoin);
		} else
			System.out.println("The specified coin was not found in the purse");
	}

	/**
	 * A setter for the name of the purse
	 * 
	 * @param name
	 *            - the new name of the purse object
	 */
	public void setName(String name) {
		this.name = name;
	}
}

import java.util.ArrayList;

/**
 * A cash register totals up sales and computes change due.
 */
public class CashRegister {
	public static final double QUARTER_VALUE = 0.25;
	public static final double DIME_VALUE = 0.1;
	public static final double NICKEL_VALUE = 0.05;
	public static final double PENNY_VALUE = 0.01;

	private double purchase;
	private double payment;

	/**
	 * Constructs a cash register with no money in it.
	 */
	public CashRegister() {
		purchase = 0;
		payment = 0;
	}

	/**
	 * Records the purchase price of an item.
	 * 
	 * @param amount
	 *            the price of the purchased item
	 */
	public void recordPurchase(double amount) {
		purchase = purchase + amount;
	}

	/**
	 * Enters the payment received from the customer.
	 * 
	 * @param dollars
	 *            the number of dollars in the payment
	 * @param quarters
	 *            the number of quarters in the payment
	 * @param dimes
	 *            the number of dimes in the payment
	 * @param nickels
	 *            the number of nickels in the payment
	 * @param pennies
	 *            the number of pennies in the payment
	 */
	public void enterPayment(ArrayList<Coin> payCoins) {
		for (Coin i : payCoins) {
			payment += i.getValue();
		}
		payment = ((double)((int)(payment*100.0)))/100.0;
	}

	/**
	 * Computes the change due and resets the machine for the next customer.
	 * 
	 * @return the change due to the customer
	 */
	public ArrayList<Coin> giveChange(Coin type) {
		double change = payment - purchase;
		change = ((double)((int)(change*100.0)))/100.0;
		ArrayList<Coin> daChange = new ArrayList<Coin>();
		for(int i = 0; i<change/type.getValue(); i++){
			daChange.add(new Coin(type.getValue(), type.getName()));
		}
		return daChange;
	}
}

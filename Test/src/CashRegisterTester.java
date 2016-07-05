import java.util.ArrayList;

/**
 * This class tests the CashRegister class.
 */
public class CashRegisterTester {
	public static void main(String[] args) {
		CashRegister register = new CashRegister();
		ArrayList<Coin> theCoins1 = new ArrayList<Coin>();
		ArrayList<Coin> theCoins2 = new ArrayList<Coin>();
		register.recordPurchase(0.75);
		register.recordPurchase(1.50);
		for (int i = 0; i < 100; i++) {
			theCoins1.add(genQuarter());
			theCoins2.add(genQuarter());
		}
		for (int i = 0; i < 10; i++) {
			theCoins1.add(genNickel());
			theCoins2.add(genNickel());
		}
		for (int i = 0; i < 4; i++) {
			theCoins2.add(genPenny());
		}
		register.enterPayment(theCoins1);
		System.out.print("Change: ");
		System.out.println(register.giveChange(genPenny()));
		System.out.println("");
		register.recordPurchase(2.25);
		register.recordPurchase(19.25);
		register.enterPayment(theCoins2);
		System.out.print("Change: ");
		System.out.println(register.giveChange(genPenny()));
		System.out.println("");
	}

	public static Coin genCoin(double value, String name) {
		return new Coin(value, name);
	}

	public static Coin genQuarter() {
		return new Coin(0.25, "Quarter");
	}

	public static Coin genDime() {
		return new Coin(0.10, "Dime");
	}

	public static Coin genNickel() {
		return new Coin(0.05, "Nickel");
	}

	public static Coin genPenny() {
		return new Coin(0.01, "Penny");
	}
}

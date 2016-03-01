/**
 * The following questions refer to calling by reference, by value and side
 * effects:
 * 
 * • Modify your BankAccount class to include a new method, transfer. This
 * method has two input parameters, double amount and double otherBalance from a
 * different BankAccount object. The method takes money from the calling
 * object’s balance and increases the balance from the other object by the
 * “amount” value. The method also includes two print statements to display each
 * object.
 * 
 * System.out.println(“From transfer( ), current object @: ” + _missing
 * parameter??); System.out.println(“From transfer( ), otherAccount @: ” +
 * otherBalance);
 * 
 * Create a test class, BankAccountTest1. In main: 
 * • Create two BankAccount objects. 
 * • Display the balance from both objects. 
 * • Call the transfer method from one object to transfer money to the other object’s
 *  balance. 
 * • Display both accounts’ balance.
 * 
 * @author PMARINA
 * @version Feb 29, 2016
 */
public class theThisOperator4 {
	public static void main(String[] args) {
		try {
			BankAccount pmarina = new BankAccount(50000, 5, "PMARINA");
			BankAccount elia = new BankAccount(5000000, 1, "Mrs. Elia");
			elia.transfer(1000000, pmarina.getBalance());
			System.out.println(pmarina.getName() + " has $" + pmarina.getBalance());
			System.out.println(elia.getName() + " has $" + elia.getBalance());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}

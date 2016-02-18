/*
 * 3. Write a program that constructs a bank account, deposits $1000, withdraws $500, withdraws another $400, and then prints the remaining balance.
 * 4. Add a method
 * void addInterest(double rate)
 * to the BankAccount class that adds interest at the given rate. For example, after the statements.
 * BankAccount momsSavings = new BankAccount(1000);
 * momsSavings.addInterest(10); // 10% interest
 * the balance in momsSavings is $1,100.
 * 
 * 5. Write a class (This isn't savings act, but oh well) SavingsAccount that is similar to the BankAccount class, except that it has an added instance variable interest. Supply a constructor that sets both the initial balance and the interest rate. Supply a method addInterest (with no explicit parameter) that adds interest to the account. Write a program that constructs a savings account with an initial balance of $1,000 and interest rate 10%. Then apply the addInterest method five times and print the resulting balance.
 * 
 * @author PMARINA
 * @version Feb 11, 2016
 */
public class BankAcctPt3 {
	/**
	 * The Main Method for the assignment -- See above header
	 * @throws Throwable No errors should be thrown; however, changing the code may create errors. 
	 * @throws java.lang.error
	 */
	public static void main(String[] args) throws Throwable {
		//Part 3
		//Commented Out Because It's Not Part of the Current Assignment:BankAccount mrsEliasAcct = new BankAccount(0);
		//Commented Out Because It's Not Part of the Current Assignment:mrsEliasAcct.setName("Mrs. Elia");
		//Commented Out Because It's Not Part of the Current Assignment:mrsEliasAcct.deposit(1000);
		//Commented Out Because It's Not Part of the Current Assignment:mrsEliasAcct.withdraw(500);
		//Commented Out Because It's Not Part of the Current Assignment:mrsEliasAcct.withdraw(400);
		//Commented Out Because It's Not Part of the Current Assignment:mrsEliasAcct.printBalance();
		//Part 4
		//Commented Out Because It's Not Part of the Current Assignment:BankAccount momsSavings = new BankAccount(1000);
		//Commented Out Because It's Not Part of the Current Assignment:momsSavings.setName("momsSavings");
		//Commented Out Because It's Not Part of the Current Assignment:momsSavings.addInterest(10); // 10% interest
		//Commented Out Because It's Not Part of the Current Assignment:momsSavings.printBalance(); 
		//Part 5
		//Commented Out Because It's Not Part of the Current Assignment:BankAccount Bobert = new BankAccount(1000,10, "Bobert");
		//Commented Out Because It's Not Part of the Current Assignment:int numberOfTimes4Interest = 5;
		//Commented Out Because It's Not Part of the Current Assignment:for(int i = 0; i<numberOfTimes4Interest; i++){
		//Commented Out Because It's Not Part of the Current Assignment:Bobert.addInterest();
		//Commented Out Because It's Not Part of the Current Assignment:}
		//Commented Out Because It's Not Part of the Current Assignment:Bobert.printBalance();
		try{
			BankAccount driver = new BankAccount(1000, 10, "Bobert");
			driver.addInterest();
			driver.setInterestRate(23);
			driver.addInterest();
			driver.setName("Platon");
			driver.addInterest(11);
			driver.deposit(3);
			driver.withdraw(1);
			System.out.println(driver.getName() + " has a current interest rate of " + driver.getInterestRate()+ "%.");
			driver.printBalance();
		}
		catch(Throwable e){
			System.out.println(e.toString() + " Error Ocurred, please go away");
		}
	}
}


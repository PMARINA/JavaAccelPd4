/**
 * 3. Write a program that constructs a bank account, deposits $1000, withdraws
 * $500, withdraws another $400, and then prints the remaining balance. 4. Add a
 * method void addInterest(double rate) to the BankAccount class that adds
 * interest at the given rate. For example, after the statements. BankAccount
 * momsSavings = new BankAccount(1000); momsSavings.addInterest(10); // 10%
 * interest the balance in momsSavings is $1,100. 5. Write a class (This isn't
 * savings act, but oh well) SavingsAccount that is similar to the BankAccount
 * class, except that it has an added instance variable interest. Supply a
 * constructor that sets both the initial balance and the interest rate. Supply
 * a method addInterest (with no explicit parameter) that adds interest to the
 * account. Write a program that constructs a savings account with an initial
 * balance of $1,000 and interest rate 10%. Then apply the addInterest method
 * five times and print the resulting balance.
 * 
 * @author PMARINA
 * @version Feb 11, 2016
 */
public class BankAccount {
	private double balance;
	private String name;
	private double interestRate;

	/**
	 * This constructor takes in a starting balance and creates a user account
	 * with the given starting balance.
	 * 
	 * @param sBalance
	 *            The starting balance for the user
	 * @throws java.lang.error
	 * @return null
	 */
	public BankAccount(double sBalance) {
		balance = sBalance;
	}

	/**
	 * This constructor takes in a starting balance and interest and creates a
	 * user account with the given starting balance and interest rate.
	 * 
	 * @param sBalance
	 *            The starting balance for the user
	 * @param interest
	 *            The interest rate of the account, where 10 is 10%.
	 * @throws Throwable
	 *             NegativeInterestRateError - Interest Rate Specified is
	 *             negative
	 * @throws Throwable
	 *             impossibleBalance - The given starting balance is negative
	 *             negativeInterestRateError - The interest rate specified is
	 *             negative
	 * @throws java.lang.error
	 * @return null
	 */
	public BankAccount(double sBalance, double interest) throws Throwable {
		Throwable impossibleBalance = new Throwable("Negative Starting Balance Specified");
		if (balance >= 0)
			balance = sBalance;
		else
			throw impossibleBalance;
		Throwable negativeInterestRateError = new Throwable("Negative Interest Rate Specified");
		if (interest >= 0)
			interestRate = interest;
		else
			throw negativeInterestRateError;
	}

	/**
	 * This constructor takes in a starting balance, interest, and name and
	 * creates a user account with the given starting balance, name, and
	 * interest rate.
	 * 
	 * @param sBalance
	 *            The starting balance for the user
	 * @param interest
	 *            The interest rate of the account, where 10 is 10%
	 * @param nom
	 *            The name of the account holder
	 * @throws Throwable
	 *             - impossibleBalance - the balance specified is negative -
	 *             negativeInterestRateError - the interest rate specified is
	 *             negative
	 * @throws java.lang.error
	 * @return null
	 */
	public BankAccount(double sBalance, double interest, String nom) throws Throwable {
		Throwable impossibleBalance = new Throwable("Negative Starting Balance Specified");
		if (balance >= 0)
			balance = sBalance;
		else
			throw impossibleBalance;
		Throwable negativeInterestRateError = new Throwable("Negative Interest Rate Specified");
		if (interest >= 0)
			interestRate = interest;
		else
			throw negativeInterestRateError;
		name = nom;
	}

	/**
	 * This constructor takes in a starting balance, interest, and name and
	 * creates a user account with the given starting balance, name, and
	 * interest rate.
	 * 
	 * @param deposit
	 *            The amount being deposited into the user's account
	 * @throws Throwable
	 * @throws java.lang.error
	 * @return null
	 */
	public void deposit(double deposit) throws Throwable {
		Throwable negativeDepositError = new Throwable("Negative Deposit Amount");
		if (deposit >= 0)
			balance += deposit;
		else
			throw (negativeDepositError);
	}

	/**
	 * This method takes a withdrawal amount and withdraws the amount from the
	 * user's account.
	 * 
	 * @param deposit
	 *            The amount being deposited into the user's account
	 * @throws Throwable
	 * @throws java.lang.error
	 * @return null
	 */
	public void withdraw(double withdrawal) throws Throwable {
		Throwable negativewithdrawalError = new Throwable("Negative withdrawal Amount");
		Throwable insufficientFundsError = new Throwable("Insufficient Funds");
		if (withdrawal < 0)
			throw (negativewithdrawalError);
		else if (balance - withdrawal < 0)
			throw (insufficientFundsError);
		else
			balance -= withdrawal;
	}

	/**
	 * This method adds the specified interest to the account, as a one-time
	 * operation.
	 * 
	 * @param percent
	 *            The percentage to be used as an interest rate
	 * @throws java.lang.error
	 * @return null
	 */
	public void addInterest(double percent) {
		balance += (percent / 100.0) * balance;
	}

	/**
	 * This method adds interest to the account. It assumes the standard
	 * interest rate.
	 * 
	 * @throws java.lang.error
	 * @return null
	 */
	public void addInterest() {
		addInterest(interestRate);
	}

	/**
	 * This method returns the actholder's name
	 * 
	 * @throws java.lang.error
	 * @return name the name of the account holder
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the actholder's name to the specified name.
	 * 
	 * @param AcctName
	 *            new actholder name
	 * @throws java.lang.error
	 * @return null
	 */
	public void setName(String AcctName) {
		name = AcctName;
	}

	/**
	 * This method adds interest to the account, as a one-time operation.
	 * 
	 * @param percent
	 *            The percentage to be used as an interest rate
	 * @throws java.lang.error
	 * @throws Throwable
	 * @return null
	 */
	public void setInterestRate(double newInterestRate) throws Throwable {
		Throwable negativeInterestRateError = new Throwable("Negative Interest Rate Specified");
		if (newInterestRate >= 0)
			interestRate = newInterestRate;
		else
			throw negativeInterestRateError;
	}

	/**
	 * This method returns the current interest rate set for the account
	 * 
	 * @throws java.lang.error
	 * @return interestRate the current interest rate set for the actholder
	 */
	public double getInterestRate() {
		return interestRate;
	}

	/**
	 * This method prints out the account's balance, with the account's name.
	 * 
	 * @throws java.lang.error
	 * @return null
	 */
	public void printBalance() {
		double roundedBalDbl = Math.round(balance * 100.00) / 100.00;
		String roundedBalStr = Double.toString(roundedBalDbl);
		System.out.println("The balance in " + getName() + "'s account is: " + roundedBalStr);
	}
}

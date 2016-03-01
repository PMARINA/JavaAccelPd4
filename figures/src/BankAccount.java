/**
 * 1. Make the following changes to the BankAccount class:
 * 
 * a. Include a print statement in the getBalance() method to show the reference
 * to the implicit * parameter. Include “from method getBalance”
 * 
 * b. Include a print statement in both constructors, “from method default
 * constructor” and “from constructor with parameter”.
 * 
 * 2. Implement a test class, ThisOperatorTest. In this test, create an object
 * of the class BankAccount and print it.
 * 
 * 3. Include a commented paragraph at the end of the test class making a
 * conclusion on the output. Make sure you explain what the this operator does
 * in the AST and the driver and compare them. *
 * 
 * @author PMARINA
 * @version Feb 11, 2016
 */
public class BankAccount {
	private double balance;
	private String name;
	private double interestRate;

	/**
	 * Default constructor of the object bank account. Sets the balance and
	 * interest rates to 0. It also sets the name to "".
	 */
	public BankAccount() {
		System.out.println("From default constructor @" + this);
		this.balance = 0;
		this.name = "";
		this.interestRate = 0;
	}

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
		System.out.println("From BankAccount constructor with one parameter: @" + this);
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
		System.out.println("From constructor with string, double constructor @" + this);
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
		System.out.println("From BankAccount constructor taking a double, a double, and a string @" + this);
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

	public double getBalance() {
		System.out.println("From method: getBalance() @" + this);
		return balance;
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
		System.out.println("The balance in " + getName() + "'s account is: " + roundedBalStr + " @" + this);
	}

	/**
	 * This method transfers money from one bank account to another.
	 * 
	 * @param funds
	 *            - the funds to be transfered
	 * @param otherAcct
	 *            - the acct to which the funds will be transfered
	 * @throws Throwable
	 *             - in the event that the funds cannot be transfered
	 */
	public void transfer(double funds, double otherBalance) throws Throwable {
		if (funds >= 0 && this.balance >= funds) { // if the funds can be
													// transfered...
			this.balance -= funds;
			otherBalance += funds;
		} else {
			if (funds < 0) // just for throwing the right exception
				throw new Throwable("Negative Transfer Amount Specified");
			else
				throw new Throwable("Not Enough Funds in Original BankAccount to be Transferred");
		}
		System.out.println("From transfer( ), current object @: " + this); // the
																			// print
																			// statements
																			// you
																			// requested
		System.out.println("From transfer( ), otherAccount @: " + otherBalance);
	}
}

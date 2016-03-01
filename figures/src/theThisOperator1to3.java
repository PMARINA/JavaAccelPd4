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
 * in the AST and the driver and compare them.
 * 
 * @author PMARINA
 * @version Mar 1, 2016
 */
public class theThisOperator1to3 {
	public static void main(String[] args) {
		try {
			BankAccount testing = new BankAccount(1000, 10, "testing BankAccount");
			testing.printBalance();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
/*
 * The this operator refers to the location of the object and all its fields.
 * The this operator, if used in conjunction with a parameter or nonstatic
 * method, refers to the parameter of the object, and not the local instance of
 * the variable/method.
 */

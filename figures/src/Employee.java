/**
 * Exercise P2.8. Implement a class Employee. An employee has a name (a string)
 * and a salary (a double). Write a default constructor, a constructor with two
 * parameters (name and salary), and methods to return the name and salary.
 * Write a small program that tests your class. Exercise P2.9. Enhance the class
 * in the preceding exercise by adding a method raiseSalary (double byPe recent)
 * that raises the employee's salary by a certain percentage. Sample usage:
 * Employee harry = new Employee("Hacker, Harry", 55000); harry. raiseSalary(10)
 * ; // Harry gets a 10% raise
 * 
 * 
 * @author PMARINA
 * @version Feb 16, 2016
 */
public class Employee {
	private String name;
	private double salary;

	/**
	 * Creates an employee object, using a default constructor
	 */
	public Employee() { // Default constructor...
		// Do nothing
	}

	/**
	 * Creates an employee object with the given parameters
	 * 
	 * @param givenName
	 *            The name attributed to the employee
	 * @param sSalary
	 *            The starting salary for the employee
	 * @throws Throwable
	 *             - a negative salary is specified
	 */
	public Employee(String givenName, double sSalary) throws Throwable {
		name = givenName;
		Throwable negativeSalary = new Throwable("Negative Salary Specified");
		if (sSalary >= 0) {
			salary = ((double) Math.round(100.00 * sSalary)) / 100.00;
		} else
			throw (negativeSalary);
	}

	/**
	 * A getter for the name of the employee
	 * 
	 * @return name of the employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * A setter for the name of the employee
	 * 
	 * @param givenName
	 *            The new name of the employee
	 */
	public void setName(String givenName) {
		name = givenName;
	}

	/**
	 * A getter for the salary of the worker.
	 * 
	 * @return salary of the worker
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * A setter for the salary of an employee.
	 * 
	 * @param givenSalary
	 *            The new salary of the worker
	 * @throws Throwable
	 *             - For a negative salary
	 */
	public void setSalary(double givenSalary) throws Throwable {
		Throwable negativeSalary = new Throwable("Negative Salary Specified"); // Make
																				// a
																				// throwable
																				// Object,
																				// just
																				// in
																				// case
		if (givenSalary >= 0) { // Check if the salary is valid
			givenSalary = (double) (Math.round(givenSalary * 100.00) / 100.00); // Round
																				// the
																				// number
																				// accordingly
			salary = givenSalary; // Set the salary
		} else
			throw (negativeSalary); // Throw the error
	}

	/**
	 * A salary raise for the employee!
	 * 
	 * @param percent
	 *            - The percent increase in the given employee's income, out of
	 *            100
	 * @throws Throwable
	 *             - In the event of a negative percent, the system will throw
	 *             an error - Negative Raise specified
	 */
	public void raiseSalary(double percent) throws Throwable {
		if (percent > 0) { // If the raise is actually a raise,
			salary += salary * percent / 100; // Increase the salary by the
												// percent. Since percent is out
												// of 100, instead of 1, divide
												// percent by 100.
		} else // If the raise is negative...
			throw new Throwable("Negative Raise specified"); // throw an error.
	}
}

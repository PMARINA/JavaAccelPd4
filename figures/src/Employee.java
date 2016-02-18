/**
 * 6. Implement a class Employee. An employee has a name (a string) and a salary
 * (a double). Write a default constructor, a constructor with two parameters
 * (name and salary), and methods to return the name and salary. Write a small
 * program that tests your class.
 * 
 * @author PMARINA
 * @version Feb 16, 2016
 */
public class Employee {
	private String name;
	private double salary;

	/**
	 * Creates an employee object
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
	 * 
	 * @return name of the employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param givenName
	 *            The new name of the employee
	 */
	public void setName(String givenName) {
		name = givenName;
	}

	/**
	 * 
	 * @return salary of the worker
	 */
	public double getSalary() {
		return salary;
	}

	/**
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
}

/**
 * 6. Implement a class Employee. An employee has a name (a string) and a salary
 * (a double). Write a default constructor, a constructor with two parameters
 * (name and salary), and methods to return the name and salary. Write a small
 * program that tests your class.
 * 
 * @author PMARINA
 * @version Feb 16, 2016
 */
public class EmployeeTest {
	/**
	 * 6. Implement a class Employee. An employee has a name (a string) and a
	 * salary (a double). Write a default constructor, a constructor with two
	 * parameters (name and salary), and methods to return the name and salary.
	 * Write a small program that tests your class.
	 * 
	 * @throws Throwable
	 *             - Should not throw an error; however, changing the parameters
	 *             in ln15 can cause problems
	 * @throws java.lang.error
	 */
	public static void main(String[] args) throws Throwable {
		// Part 1
		Employee bobert = new Employee(); // Create a new employee
		bobert.setName("Bobert"); // Set his name to bobert
		bobert.setSalary(8.59); // Set the salary to the minimum wage for nj
		System.out.println(bobert.getName() + " earns: $" + bobert.getSalary() + " an hour."); // Print
		// out
		// the
		// salary

		// Part 2
		Employee kqorg = new Employee(); // Make another employee
		kqorg.setName("Potato"); // Name it potato
		kqorg.setSalary(0.015);// Set the potato's salary to 1.5 cents
		System.out.println(kqorg.getName() + " earns: $" + kqorg.getSalary() + " an hour."); // Print
		// stats

	}
}

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
 * @author PMARINA
 * @version Feb 16, 2016
 */
public class EmployeeTest {
	/**
	 * Exercise P2.8. Implement a class Employee. An employee has a name (a
	 * string) and a salary (a double). Write a default constructor, a
	 * constructor with two parameters (name and salary), and methods to return
	 * the name and salary. Write a small program that tests your class.
	 * Exercise P2.9. Enhance the class in the preceding exercise by adding a
	 * method raiseSalary (double byPe recent) that raises the employee's salary
	 * by a certain percentage. Sample usage: Employee harry = new
	 * Employee("Hacker, Harry", 55000); harry. raiseSalary(10) ; // Harry gets
	 * a 10% raise
	 * 
	 * @throws Throwable
	 *             - Should not throw an error
	 * @throws java.lang.error
	 */
	public static void main(String[] args) {
		/*
		 * // Part 1 Employee bobert = new Employee(); // Create a new employee
		 * bobert.setName("Bobert"); // Set his name to bobert
		 * bobert.setSalary(8.59); // Set the salary to the minimum wage for nj
		 * System.out.println(bobert.getName() + " earns: $" +
		 * bobert.getSalary() + " an hour."); // Print // out // the // salary
		 * 
		 * // Part 2 Employee kqorg = new Employee(); // Make another employee
		 * kqorg.setName("Potato"); // Name it potato kqorg.setSalary(0.015);//
		 * Set the potato's salary to 1.5 cents
		 * System.out.println(kqorg.getName() + " earns: $" + kqorg.getSalary()
		 * + " an hour."); // Print // stats
		 * 
		 * -- This is old stuff - from the old employee test
		 */
		try {
			Employee harry = new Employee("Hacker, Harry", 55000); // Make a new
																	// employee
																	// with the
																	// given
																	// name
																	// Hacker,
																	// Harry,
																	// and the
																	// annual
																	// salary of
																	// 55000.
			harry.raiseSalary(10); // Raise Harry's salary by 10%
			System.out.println(harry.getName() + " makes $" + harry.getSalary() + " annually."); // Print
																									// out
																									// harry's
																									// stats
		} catch (Throwable e) {
			e.printStackTrace(); // In the event of an error, print the stack
									// trace so we know what happened.
		}
	}
}

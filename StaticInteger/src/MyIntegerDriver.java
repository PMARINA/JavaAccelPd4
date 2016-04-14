/**
 * (The Driver class) Design a class named MyInteger. The class contains: *
 * An int data field named value that stores the int value represented by this
 * object. * A constructor that creates a MyInteger object for the specified int
 * value. * A get method that returns the int value. * The methods isEven(),
 * isOdd(), and isPrime() that return true if the value in this object is even,
 * odd, or prime, respectively. * The static methods isEven(int), isOdd(int),
 * and isPrime(int) that return true if the specified value is even, odd, or
 * prime, respectively. * The static methods isEven(MyInteger),
 * isOdd(MyInteger), and isPrime(MyInteger) that return true if the specified
 * value is even, odd, or prime, respectively. * The methods equals(int) and
 * equals(MyInteger) that return true if the value in this object is equal to
 * the specified value. * A static method parseInt(char[]) that converts an
 * array of numeric characters to an int value. * A static method
 * parseInt(String) that converts a string into an int value. Draw the UML
 * diagram for the class and then implement the class. Write a client program
 * that tests all methods in the class.
 * 
 * @author PMARINA
 * @version April 4, 2016
 */
public class MyIntegerDriver {
	/**
	 * @param argsj - no purpose -- IM STILL DONE!!! WOOOOT!
	 */
	public static void main(String[] args){
		MyInteger a = new MyInteger(4);
		System.out.println("This value of the MyInteger object is: " + a.getValue());
		System.out.println("Is the number even?:                   " + a.isEven());
		System.out.println("Is the number odd?:                    " + a.isOdd());
		System.out.println("Is the number prime?                   " + a.isPrime());
		System.out.println("Is 3 even?:                            " + MyInteger.isEven(3));
		System.out.println("Is 3 odd?:                             " + MyInteger.isOdd(3));
		System.out.println("Is 3 prime?:                           " + MyInteger.isPrime(3));
		MyInteger b = new MyInteger(3);
		System.out.println("This value of the MyInteger object is: " + b.getValue());
		System.out.println("Is the number even?:                   " + b.isEven());
		System.out.println("Is the number odd?:                    " + b.isOdd());
		System.out.println("Is the number prime?                   " + b.isPrime());
		System.out.println("Are the MyIntegers same?:              " + a.equals(b));
		char[] ac = {51,55};  
		System.out.println("The ascii array of values:\n51\n55\n has value: " + MyInteger.parseInt(ac));
		System.out.println("So far, " + MyInteger.getCount() + " MyIntegers have been created.");
	}
}

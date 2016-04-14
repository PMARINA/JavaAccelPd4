import java.util.ArrayList;

/**
 * (The MyInteger class) Design a class named MyInteger. The class contains: *
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
public class MyInteger {
	private int value;
	private static int created = 0;

	/**
	 * @param value
	 *            - the desired value of the MyInteger object
	 */
	public MyInteger(int value) {
		this.value = value;
		created++;
	}

	/**
	 * @return - the value of the MyInteger object
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * @param value
	 *            - the value of the number
	 * @return - whether or not the number is even
	 */
	public static boolean isEven(int value) {
		return value % 2 == 0;
	}

	/**
	 * @return - the number of MyIntegers created so far.
	 */
	public static int getCount() {
		return created;
	}

	/**
	 * @param value
	 *            - the value of the number
	 * @return - whether or not the number is odd
	 */
	public static boolean isOdd(int value) {
		return !isEven(value);
	}

	/**
	 * @param value
	 *            - the value of the number which the user wants to find whether
	 *            or not it is prime
	 * @return
	 */
	public static boolean isPrime(int value) {
		boolean isPrime = true;
		for (int i = 2; i <= (int) 0.5 + Math.sqrt(value); i++) {
			if (value % i == 0)
				isPrime = false;
		}
		return isPrime;
	}

	/**
	 * @return - whether or not the instance is even
	 */
	public boolean isEven() {
		return isEven(this.value);
	}

	/**
	 * @return - whether or not the instance is odd
	 */
	public boolean isOdd() {
		return isOdd(this.value);
	}

	/**
	 * @return - whether or not the instance is prime
	 */
	public boolean isPrime() {
		return isPrime(this.value);
	}

	/**
	 * @param x
	 *            - the myInteger object which will be evaluated
	 * @return - whether or not the object is even
	 */
	public static boolean isEven(MyInteger x) {
		return isEven(x.getValue());
	}

	/**
	 * @param x
	 *            - the object to be evaluated
	 * @return - whether or not the object is odd
	 */
	public static boolean isOdd(MyInteger x) {
		return isOdd(x.getValue());
	}

	/**
	 * @param x
	 *            - the object to be evaluated
	 * @return - whether or not the object is prime
	 */
	public static boolean isPrime(MyInteger x) {
		return isPrime(x.getValue());
	}

	/**
	 * @param a
	 *            - the integer being compared to
	 * @return - whether or not the object has the same value as the integer
	 */
	public boolean equals(int a) {
		return this.value == a;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object a) {
		try {
			MyInteger bol = (MyInteger) a;
			return this.value == bol.value;
		} catch (ClassCastException e) {
			return false;
		}
	}

	/**
	 * @param a
	 *            - the char array
	 * @return - the value of the number represented by the characters
	 */
	public static int parseInt(char[] a) {
		ArrayList<String> nums = new ArrayList<String>();
		for (char b : a) {
			if ((b >= 46 && b <= 57) && b != 47) {
				nums.add(new String(String.valueOf(b)));
			} else
				return 0;
		}
		String s = "";
		for (String c : nums)
			s += c;
		return Integer.parseInt(s);

	}

	/**
	 * Note: Does not support numbers combined with text
	 * 
	 * @param s
	 *            - the string being parsed
	 * @return - the value of the number in the string.
	 */
	public static int parseInt(String s) {
		return Integer.parseInt(s);
	}
}

import java.util.ArrayList; //Import ArrayLists for use in inputing method. 

/**
 * @author PMARINA
 * @version 2/2/16
 * Exercise 2:
 * Modify your program from the exercise 1 to insist that the integers must be positive (by prompting the user to enter positive integers whenever the value entered is not positive).
 * 
 * Exercise 1:
 * Write a program MaxMin.java that reads in integers (as many as the user enters) from standard input and prints out the maximum and minimum values.
 */
public class PM_Exercise2 {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = getInput(); //Gets the input into the method
		numbers.trimToSize(); //Gets rid of null values, in case the number of values inputed is less than 10
		int min = (int) (Math.pow(2, 31)-1); //Set the min to the largest value possible for comparison
		int max = (int) (-1*Math.pow(2, 31)); //Set the max to the smallest possible value for comparison. Note that this could just be set to 0 because we are only accepting positive numbers
		for(int i = 0; i<numbers.size();i++){ //Parse through all the numbers
			int currentNum = numbers.get(i); //Set a variable to the number being compared so resources aren't wasted accessing the same element over and over again
			if(currentNum >max)max = currentNum; //If the current number is larger than the max, then reset it.
			else if(currentNum<min) min = currentNum; //If the current number is smaller than the max, then reset it. 
		}
		StdOut.println("The maximum is " + max + " and the minimum is " + min + ".\n"); //Output the max and min values
	}
	
	public static ArrayList<Integer> getInput(){
		ArrayList<Integer> nums = new ArrayList<Integer>(); //Make a new arrayList
		String NotPositiveErrorMessage = "Please Enter A Positive Integer!"; //Error Message for non-positive values being inputed
		while(!StdIn.isEmpty()){ //Check if the user is done
			int num = StdIn.readInt();//Get the number from the console
			if(!(num>0))StdOut.println(NotPositiveErrorMessage);//If the number is not positive, then output the error message
			else nums.add(new Integer(num)); //If it is positive, then put it into the arrayList
		}
		return nums;//Return the arrayList
	}
}

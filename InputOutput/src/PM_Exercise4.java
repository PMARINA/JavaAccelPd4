/**
 * Exercise 4:
 * Extend your program from the exercise 3 to create a filter that prints all the values that are further than 1.5 standard deviations from the mean.
 * 
 * Exercise 3:
 * Write a program Stats.java that takes an integer N from the command line, reads N double values from standard input, and prints their mean (average value) and sample standard deviation (square root of the sum of the squares of their differences from the average, divided by N - 1).
 * @author PMARINA
 * @version Feb 2, 2016
 */
public class PM_Exercise4 {
	private static double userInputStdDeviations = 0; //This is the deviation required for omitting extraneous values
	
	
	public static void main(String[] args) {
		double[] input = getInput(); //Get the input from the user
		boolean[] omit = filter(input, userInputStdDeviations); //Get the array of items to be omitted
		StdOut.println("\nThe outliers are/is:"); 
		for(int i = 0; i<input.length;i++){
			if(!omit[i])StdOut.println(input[i]);//If omit[i] is true, then the item that corresponds in numbers is not to be printed
		}
	}
	
	
	public static double[] getInput(){ //get 
		StdOut.println("How many doubles would you like to process?");
		int N = StdIn.readInt();
		StdOut.println("What is the standard deviation threshold for outliers?");
		userInputStdDeviations = StdIn.readDouble();
		double[] nums = new double[N];
		StdOut.println("Please enter the data values.");
		for(int i = 0;i<N; i++){
			nums[i] = StdIn.readDouble(); //Read those N doubles
		}
		return nums; //Return the input
	}
	
	
	public static boolean[] filter(double[] numbers, double stdDeviationLimit){
		double stdDeviation = StdDeviation(numbers); //Calculate the standard deviation for the data
		double average = average(numbers); //Compute the average of the numbers
		double upperLimit = average+stdDeviationLimit*stdDeviation; //Find the maximum threshold for values to not be counted as extraneous
		double lowerLimit = average-stdDeviationLimit*stdDeviation; //Find the minimum threshold for values to not be counted as extraneous
		boolean[] omit = new boolean[numbers.length]; //Every true value corresponds to a value that should not be printed
		for(int i = 0; i<numbers.length;i++){
			if(!(numbers[i]>upperLimit || numbers[i]<lowerLimit))omit[i] = true; //If the number is not in the non-extraneous range, then it should be printed 
		}
		
		return omit;
	}
	
	
	public static double StdDeviation(double[] numbers){ //Calculate the standard deviation of the numbers
		double stdDeviation = Math.pow(variation(numbers),0.5);
		return stdDeviation;
	}
	
	
	public static double variation(double[] numbers){ //Calculate the variation within the data
		double average = average(numbers); //Find the average
		double[] differenceSquared = new double[numbers.length];
		for(int i = 0; i<numbers.length; i++){
			differenceSquared[i] = Math.pow(numbers[i] - average,2); //This is the difference between each value and the mean, squared
		}
		double variance = average(differenceSquared); //The average of the differences squared is the definition of variance 
		return variance;
	}
	
	
	public static double average(double[] numbers){ //A basic method to find the average of a data set. 
		double average = 0;
		for(int i = 0; i<numbers.length;i++){
			average+=numbers[i];
		}
		return (average/numbers.length);
	}
	
	
}

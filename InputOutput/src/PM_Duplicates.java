
/**
 * Web Ex 3: Remove duplicates. Write a program Duplicates.java that reads in a sequence of integers and prints back out the integers, except that it removes repeated values if they appear consecutively. For example, if the input is 1 2 2 1 5 1 1 7 7 7 7 1 1, your program should print out 1 2 1 5 1 7 1.
 * 
 * @author PMARINA 
 * @version 01/04/2016
 */
public class PM_Duplicates
{
    public static void main(String[] args){
        String someString = ""; //We have a string 
        while(!StdIn.isEmpty()){
            someString += (StdIn.readDouble() + ","); //for every number, append the number and a comma to the string
        }
        String[] numbers = someString.split(","); //Split the string based on the commas
        System.out.print(numbers[0] + " ");//Print out the first number because it will not be printed in the for loop below
        for(int i = 1; i<numbers.length; i++){
            if(!(Double.parseDouble(numbers[i]) == Double.parseDouble((numbers[i-1])))){ //if the current number is the same as the previous number then don't print.
                System.out.print(numbers[i] + " ");
            }
        }
    }
}
/*
Input:
12
12
10
5
3
3
10
10
output:
12.0 10.0 5.0 3.0 10.0 
Is this the shortest right method?
 */
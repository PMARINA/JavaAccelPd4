import java.util.ArrayList;import java.lang.StringBuilder;
/**
 * <h1>Write a program that does the following:</h1><ol>
 * <li>It creates an ArrayList, anAList of 100 random integers between the values of 1 and 1000 and find the two consecutive integers with the smallest difference between the two of them.</li>
 * <li>It finds and prints with a message the largest value in anAList.</li?=>
 * <li>It finds and prints with a message the average value in anAList.</li>
 * <li>It prints all the numbers from anAList separated with a space and in one line.</li>
 * <li>It prints the numbers from anAlist separated by 3 spaces in 10 columns by 10 rows format. </li></ol>
 * <em><p>Note: Use printf to keep all your numbers tab properly.</p></em>
 * 
 * @author PMARINA 
 * @version 01/15/2016
 */
public class PM_ArrayListBasics
{
    //static long startTime = System.currentTimeMillis(); -- a timer
    /**
     * <p><u>A method for formating the numbers, which are then put into a table to be printed</u></p>
     * <ul><li>Translates the number into a string in order to append spaces to it.</li>
     * <li>Adds the correct number of spaces before and after the number</li></ul>
     * @param num the number being formatted
     * @return the number in string format with the correct string buffer on either side
     */
    public static String format(int num){
        String number = Integer.toString(num);
        int spaceLength = 10-number.length();
        int before = (int) spaceLength/2;
        int after = spaceLength-before;
        String returnString = "";
        for(int i = 0; i<before; i++)returnString += " ";
        returnString += number;
        for(int i = 0; i<after; i++)returnString += " ";
        return returnString;
    }
    /**
     * <p><u>See program header for full details</u></p>
     * <small>The note was ignored in order to maximize efficiency</small>
     * @param args expects no input
     * @returns none
     */
    public static void main(String[] args){
        ArrayList<Integer> anAList = new ArrayList<Integer>();
        for(int i = 0; i<100; i++){
            Integer x = new Integer ((int) (Math.random()*999+1));
            anAList.add(x);
        }
        int difference = 1001; int pos1 = -1; int max = 0; int avg = 0; StringBuilder allNums = new StringBuilder(); StringBuilder formattedNums = new StringBuilder();
        for(int i = 0; i<anAList.size(); i++){
            int currentNumber = anAList.get(i);
            if(!(anAList.size() <= i+2)){
                int curDif = currentNumber - anAList.get(i+1);
                if(curDif <0) curDif = -curDif;
                if(curDif < difference){difference = curDif; pos1 = i;}
            }
            if(currentNumber > max)max = currentNumber;
            avg += currentNumber;
            allNums.append(currentNumber + " ");
            if(i%10 == 0 && i>0)formattedNums.append("\n");
            formattedNums.append(format(currentNumber));
        }
        avg = avg/anAList.size();  
        System.out.println("The closest numbers in the ArrayList were: " + Integer.toString(anAList.get(pos1)) + " and " + Integer.toString(anAList.get(pos1 + 1)) + " with a difference of " + Integer.toString(difference));
        System.out.println("The maximum was: " + max);
        System.out.println("The average was: " + avg);
        System.out.println(allNums);
        System.out.println(formattedNums);
        //long endTime = System.currentTimeMillis();
        //double time = (double) endTime-startTime;
        //System.out.println();
        //System.out.println("It took " + time+ " milliseconds, with an average of " + time/10000 + " milliseconds per number"); - the end of the timer
    }
}

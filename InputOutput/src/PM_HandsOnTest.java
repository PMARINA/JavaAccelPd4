/**
 * Given the hours for the employees of EliaMart per day, provide the number of hours worked in the week, per employee, and the number of hours worked in every day of the week.
 * 
 * @author PMARINA
 * @version today
 */
public class PM_HandsOnTest
{
    public static void pmPrintf(String part1, String part2, int length){ //My own print formatting method!
        length -= part1.length() +part2.length(); //Length is the total length of the string being printed. Subtract the number of characters from whitespaces
        String dots = ""; //An empty string.
        for(int i = 0; i<length; i++){
            dots += "."; //For every empty space in between the strings, put a dot
        }
        System.out.println(part1 + dots + part2);//Now print the first string, followed by the dots, and the second string. 
    }
    public static String pmReturnf(String part1, String part2, int length){ //Does the same exact thing as the print formatter, but now it returns the string in question, to be used in the extra credit methods
        length -= part1.length() +part2.length();
        String dots = "";
        for(int i = 0; i<length; i++){
            dots += ".";
        }
        return (part1 + dots + part2);
    }
    public static int[][] getInput(){ //A method to get the input. Usually, this would come from the user; however, in this case, the hours are being inputted directly into the program. 
        int[][] input = {
            {2,4,3,4,5,8,8}, //If I were to get user input, I would use a double for loop and set each value individually
            {7,3,4,3,3,4,4}, //Alternatively, I could use stdin.readalldoubles to get the hours for each individiual. 
            {3,3,4,3,3,2,2},
            {9,3,4,7,3,4,1},
            {3,5,4,3,6,3,8},
            {3,4,4,6,3,4,4},
            {3,7,4,8,3,8,4},
            {6,3,5,9,2,7,9}
        };
        return input;
    }
    public static void output1(int[][] input){
        System.out.println("1."); //Label the output
        pmPrintf("Employee", "# Hours", 17);
        //printing out the sums of each row, which is the total hours for each employee
        for(int i = 0; i<input.length; i++){
            int sum = 0;
            for(int j = 0; j<input[i].length; j++){
                sum+= input[i][j];
            }
            String part1 = "Employee " + i;
            pmPrintf(part1, Integer.toString(sum), 17); //PmPrintf takes care of 
        }
    }
    public static void ExCredOutput1(int[][] input){
        System.out.println("1.");
        pmPrintf("Employee", "# Hours", 17);

        //printing out the sums of each row
        for(int i = 0; i<input.length; i++){
            int sum = 0;
            for(int j = 0; j<input[i].length; j++){
                sum+= input[i][j];
            }
            String part1 = "Employee " + i;
        }
    }
    public static void output2(int[][] input){
        System.out.println("2.");
        for(int i = 0; i<input[i].length; i++){
            int sum = 0;
            for(int j = 0; j<input.length; j++){
                sum += input[j][i];
            }
            String day = "";
            if(i == 0) day = "Sunday";
            if(i==1) day = "Monday";
            if(i == 2) day = "Tuesday";
            if(i == 3) day = "Wednesday";
            if(i ==4) day = "Thursday";
            if(i == 5) day = "Friday";
            if(i == 6)day = "Saturday";
            pmPrintf(day, Integer.toString(sum), 17);
        }
    }
    public static void main(String[] args){
        int[][] input = getInput();

        //System.out.println();
        //output2(input);
    }
}

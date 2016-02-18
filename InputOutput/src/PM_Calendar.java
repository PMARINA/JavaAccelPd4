import java.util.Scanner;
/* Input Month and year
 * Output: Simple calendar with days and numbers
 * @Author: PMARINA
 * @Version: 10/13 (header daate)
 */
public class PM_Calendar{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Month (1-12)");
        int month = sc.nextInt();
        System.out.println("Please enter the year (yyyy)");
        int year = sc.nextInt();
        sc.close();
        int[] returnValue = dayOfTheWeek(month, year);
        int dayOfWeek = returnValue[0];dayOfWeek -=1;
        if(dayOfWeek<0) dayOfWeek = 6;
        int leapYearNum = returnValue[1];
        System.out.println("S  M  T  W  T  F  S");
        int[] DAYS_OF_MONTHS = new int[] {31,28 + leapYearNum,31,30,31,30,31,31,30,31,30,31};
        int numDays = DAYS_OF_MONTHS[month-1];
        boolean doneOnce = false;
        for (int a = 1; a <= numDays;){
            for (int b = 0; b <7; b++){
                if ((! doneOnce) && (b<dayOfWeek)){
                    for (int c = 0; c< 3 * (dayOfWeek); c++){
                        System.out.print(" ");
                    }
                    doneOnce = true;
                    b=dayOfWeek;
                }
                @SuppressWarnings("unused")
				String spacer;
				if (a<10) {
                    //System.out.print(" ");
                    spacer = " ";
                }
                else spacer = "";
                if (a>numDays)break;

                System.out.print(a++);
                if (a<10) System.out.print("  ");
                else System.out.print(" ");
            }
            System.out.println();
        }
        
    }
    static int[] dayOfTheWeek(int inMonth, int inYear){
        int inDay = 1;// initialize the variable
        //Checking whether or not the date exists
        if((inMonth <1) || (inMonth >12)){
            System.out.println("We're sorry, but that month doesn't seem to exist yet.");
            System.exit(1);
        }
        if (inYear<0){ // I dont believe that dates in the BC time period (-dates) work. It would be impossible to check since the gregorian calendar & internet were created a while later.
            System.out.println("We're sorry, but we don't support dates before the death of Christ");
            System.exit(1);
        }
        // Calculations: The link provided was outdated - using wiki how link
        int jan =0, feb =3, mar =3, apr = 6, may = 1, jun = 4, jul = 6, aug = 2, sep = 5, oct = 0, nov = 3, dec = 5 ; //These are the month values as shown in the wikihow
        int month = 0; //The variable is declared only to allow the debugger to read through successfully. 
        if(inMonth ==1){month = jan;} //The month is not being set to january, but rather the month code that corresponds with it
        if(inMonth ==2){month = feb;}//Same applies for the other months
        if(inMonth ==3){month = mar;}
        if(inMonth ==4){month = apr;}
        if(inMonth ==5){month = may;}
        if(inMonth ==6){month = jun;}
        if(inMonth ==7){month = jul;}
        if(inMonth ==8){month = aug;}
        if(inMonth ==9){month = sep;}
        if(inMonth ==10){month = oct;}
        if(inMonth ==11){month = nov;}
        if(inMonth ==12){month = dec;}
        int sumOfDayAndMonthCode = inDay + month; // This is a the step 1 of the wikihow. 
        while (sumOfDayAndMonthCode>6){ //subtracting the largest multiple of 7..
            sumOfDayAndMonthCode-=7;
        }
        int inYearLastTwoDigits = inYear%100; //This dinds the last two digits of the year
        int inYearLastTwoDigitsCopy = inYear%100; // Just a copy of the above var
        int inCentury = inYear - inYearLastTwoDigits; //This is the century, for producing the century code (centuryAdd)
        int centuryAdd = 0; //Just declared to make the debugger to read through sucessfully
        if ( (inCentury == 1600) || (inCentury == 1700) || (inCentury == 1800) || (inCentury == 1900) || (inCentury == 2000)){ //Defining the century codes
            if (inCentury == 1600){centuryAdd = 0;}
            if (inCentury == 1700){centuryAdd = 5;}
            if (inCentury == 1800){centuryAdd = 3;}
            if (inCentury == 1900){centuryAdd = 1;}
            if (inCentury == 2000){centuryAdd = 0;}
        }
        else{
            System.out.println("We are very sorry; however, the year you entered is not supported");
            System.exit(1);
        }
        while(inYearLastTwoDigitsCopy > 27){ //Subtracting the largest multiple of 28 from the last two digits of the year
            inYearLastTwoDigitsCopy -=28;
        }
        boolean leapYear; //Leap Years make a difference
        if(inYear%4 == 0){ //This is from microsoft's page on finding out whether or not a year is a leap year
            if(inYear%100 == 0){
                if(inYear%400 == 0){
                    leapYear = true;
                }
                else{
                    leapYear = false;
                }
            }
            else{
                leapYear = true;
            }
        }
        else{
            leapYear = false;
        }
        int leapYearSubtract  = 0; int leapYearNum = 0;//If the year was a leap year and the month was jan or feb, then we need to subtract 1
        if ((leapYear == true) && ((inMonth == 1) || (inMonth == 2))){
            leapYearSubtract  = 1;
            leapYearNum = 1;
        }
        double y = ((long) (inYearLastTwoDigits/4)); //long is used in order to allow round DOWN
        double tempSum = inYearLastTwoDigits + y + centuryAdd - leapYearSubtract; //See step 3(?)
        double dayOfWeek = tempSum + sumOfDayAndMonthCode; //We needed to find the sum of this and the sum found in step 1
        while(dayOfWeek > 6){ //before subtracting the largest multiple of 7 from it
            dayOfWeek -=7;
        }
        int[] returnList = new int[] {(int) dayOfWeek, leapYearNum};
        return returnList;
    }
}
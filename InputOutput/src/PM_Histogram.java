import java.util.Arrays; 
/**
 * Write a description of class PM_Histogram here.
 * 
 * @author PMARINA
 * @version 12/9/2015
 */
public class PM_Histogram
{
    public static double findMax(double[] nums){
        double max = nums[0];
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>max)max = nums[i];
        }
        return max;
    }
    public static double findMin(double[] nums){
        double min = nums[0];
        for(int i = 0; i <nums.length; i++){
            if(nums[i]<min)min = nums[i];
        }
        return min;
    }
    public static int findYscale(double[] nums, double min, double intervalLength, int roundedNumberOfIntervals){
        int modeNumber = 0;
        int counter = 0;
        int possibleMode = 0;
        double[] intervals = setIntervalArray(min, intervalLength, roundedNumberOfIntervals);
        for(int i = 0; i<nums.length; i++){
            double theNumber = nums[i];
            double intervalMin = intervals[counter];
            double intervalMax = intervalMin + intervalLength;
            if((theNumber >= intervalMin) && (theNumber < intervalMax)){
                possibleMode ++;
            }
            else{
                while(theNumber>intervalMax){
                    counter++;
                    intervalMin = intervals[counter];
                    intervalMax = intervalMin + intervalLength;
                }
                if(possibleMode > modeNumber) modeNumber = possibleMode;
                possibleMode = 0;
            }
        }
        return modeNumber;
    }
    public static void drawUncenteredRectangles(double x, double y, double width, double height){
        double[] xCoords = {x, x, x+width, x+width};
        double[] yCoords = {y, y+height, y+height, y};
        StdDraw.filledPolygon(xCoords, yCoords);
    }
    public static void labelXaxis(double xmin, double xmax, double intervalLength){
        StdDraw.setPenColor(StdDraw.RED);
        int x = 0;
        if(intervalLength == 1) x = 0;
        else x =1;
        for(double i = xmin-1; i<=xmax; i+= intervalLength){
            String text = String.valueOf((int)(i+x)) + "-" + String.valueOf((int)(i+intervalLength+x));
            StdDraw.text(i + 1+0.1,-0.1, text);
        }
        StdDraw.setPenColor(StdDraw.BLACK);
    }
    public static void labelYaxis(double yMin, double yMax, double xMin){
        StdDraw.setPenColor(StdDraw.RED);
        for(double i = yMin; i<=yMax+1; i++){
            StdDraw.text(xMin-0.1, i, String.valueOf((int)(i)));
        }
        StdDraw.setPenColor(StdDraw.BLACK);
    }
    public static double round(double x){
        if(x - ((int)(x)) >=0.5) x = 1+ ((int) (x));
        else x = (int) (x);
        return x;
    }
    public static double[] setIntervalArray(double min, double interval, int roundedNumberOfIntervals){
        double[] intervalArray = new double[roundedNumberOfIntervals];
        for(int i = 0; i<roundedNumberOfIntervals; i++){
            intervalArray[i] = i*interval + min;
        }
        return intervalArray;
    }
    public static double bruteForceMin(double min, double intervalLength){
        int i = 0;
        while(i*intervalLength<min){
            i++;
        }
        if(i*intervalLength>min)i--;
        min = i*intervalLength;
        min = roundDown(min);
        return min;
    }
    public static double roundDown(double min){
        int i = 0;
        while(Math.pow(10, i)<min){
            i++;
        }
        if(min<Math.pow(10,i))i--;
        return min-min%Math.pow(10,i);
    }
    public static void main(String[] args){
        StdOut.println("Please enter your interval for the histogram");
        double intervalLength = StdIn.readDouble();
        StdOut.println("Please enter all of your numbers");
        double[] nums = StdIn.readAllDoubles();
        double max = findMax(nums);
        double min = findMin(nums);
        min = bruteForceMin(min, intervalLength);
        double range = max-min+1;
        double numberOfIntervals = range/intervalLength;
        StdDraw.setCanvasSize(1000,1000);
        int roundedInterval = (int)  (round(intervalLength));
        int roundedNumberOfIntervals = 1 + (int) (numberOfIntervals);
        if(numberOfIntervals - (int)(numberOfIntervals) == 0) roundedNumberOfIntervals -=1;
        StdDraw.setXscale(min-1, max+2+1);
        Arrays.sort(nums);     
        int y = 0; int x = 1;
        double[] intervalArray = new double[roundedNumberOfIntervals];
        int intervalCounter = 0;
        intervalArray = setIntervalArray(min,intervalLength, roundedNumberOfIntervals);
        double yMax = findYscale(nums, min, intervalLength, roundedNumberOfIntervals);
        StdDraw.setYscale(-1, yMax+1+1);
        for(int i = 0; i<nums.length; i++){
            double intervalMin = intervalArray[intervalCounter];
            double intervalMax = intervalMin + intervalLength;
            x = intervalCounter;
            double oldIntervalMin = intervalMin;
            double oldIntervalMax = intervalMax;
            if((nums[i] >= intervalMin) && (nums[i] <intervalMax)){
                y+=1;
            }
            else {
                while(nums[i] > intervalMax) {
                    intervalCounter++;
                    intervalMin = intervalArray[intervalCounter];
                    intervalMax = intervalMin + intervalLength;
                }
                if((nums[i] >= oldIntervalMax)){
                    drawUncenteredRectangles(intervalArray[x],0,1,y);
                    y = 1;
                    if(nums[i]>=intervalMax){
                        intervalCounter +=1;         
                    }
                }
            }
        }
        // draw the last interval
        drawUncenteredRectangles(intervalArray[intervalCounter],0,1,y);
        labelYaxis(0, yMax, min);
        labelXaxis( min,  max, intervalLength);
    }
}
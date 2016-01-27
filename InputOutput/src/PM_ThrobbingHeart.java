
/**
 * Simulate a beating heart, given the beats per minute of the heart. 
 * 
 * @author PMARINA 
 * @version 01/09/2016
 */
public class PM_ThrobbingHeart
{
    public static void heart(double size){
        

        // draw diamond
        double[] xs = { -size,  0, size, 0 };
        double[] ys = {  0, -size, 0, size };
        StdDraw.filledPolygon(xs, ys);

        // circles
        StdDraw.filledCircle(+0.5, 0.5, size / Math.sqrt(2));
        StdDraw.filledCircle(-0.5, 0.5, size / Math.sqrt(2));
    }
    public static void main(String[] args){
        double beatsPerMinute = Double.parseDouble(args[0]); //Get the beats per minute
        //Set the Screen
        StdDraw.setXscale(-1.5, +1.5);
        StdDraw.setYscale(-1.5, +1.5);
        //Set pen color
        StdDraw.setPenColor(StdDraw.PINK);
        //Get the total amount of time per cycle (in miliseconds)
        double pauseTime = 60000/beatsPerMinute;
        while(true){
            heart(0.9); //The size of the small heart
            StdDraw.show((int) (pauseTime*0.75)); //I think the heart remains in the contracted position for longer than the other position
            heart(1.2);//The size of the large heart
            StdDraw.show((int) (0.25*pauseTime));//Same as above
            StdDraw.clear(StdDraw.WHITE);//Clear the screen, so that it is possible to tell that the heart has contracted and/or expanded.
        }
    }
    //Input: 120 bpm
}


/**
 * Write a program Circles.java that draws filled circles of random size at random positions in the unit square, producing images like those below. Your program should take four command-line arguments: the number of circles, the probability that each circle is black, the minimum radius, and the maximum radius.Check the book site for images.
 * 
 * @author PMARINA 
 * @version 01/08/2016
 */
public class PM_Circles
{
    private static double genRand(double min, double max){ //Generate random numbers between the min and the max.
        return Math.random()*(max-min)+min;
    }
    public static void main(String[] args){
        //The input converted into ints and doubles as necessary
        int N = Integer.parseInt(args[0]);
        double probBlack = Double.parseDouble(args[1])/100.0;
        double minRad =  Double.parseDouble(args[2]) /100.0;
        double maxRad = Double.parseDouble(args[3])/100.0;
        double range = maxRad-minRad;
        //Draw Circles until the number of circles left to draw is 0.
        while(N>0){
            double x = 2; double y = 2;
            double radius = Math.random()*range + minRad;
            //It was the fact that i was using radius over 2, instead of radius, which is already half the diameter
            while(x+radius >=1 || x-radius<=0){
                x = Math.random();
            }
            while(y + radius >= 1 || y-radius <=0){
                y = Math.random();
            }
            if(Math.random()<=probBlack)StdDraw.setPenColor(StdDraw.BLACK); //black circle
            else {
                //Make the color, only if we need to
                int r = (int) genRand(0,255);
                int g = (int) genRand(0,255);
                int b = (int) genRand(0,255);
                StdDraw.setPenColor(r,g,b); // colored circle
            }
            StdDraw.filledCircle(x,y,radius); //draw 
            N--;//Number -- so we dont go on forever. 
        }
    }
}

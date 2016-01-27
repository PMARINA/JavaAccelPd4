/******************************************************************************
 *  Compilation:  javac BouncingBall.java
 *  Execution:    java BouncingBall
 *  Dependencies: StdDraw.java
 *
 *  Implementation of a 2-d bouncing ball in the box from (-1, -1) to (1, 1).
 *
 *  % java BouncingBall
 *
 ******************************************************************************/

public class PM_CrossingBalls { 
    public static double random(){
        return Math.random()*2-0.99999;
    }
    public static void main(String[] args) {

        // set the scale of the coordinate system
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);

        // initial values
        double rx1 = random(), ry1 = random();     // position
        double vx1 = 0.015, vy1 = 0.023;     // velocity
        double radius = 0.05;              // radius
        double rx2 = random(), ry2 = random();     // position
        double vx2 = 0.015, vy2 = 0.023;     // velocity

        // main animation loop
        while (true)  { 

            // bounce off wall according to law of elastic collision
            if (Math.abs(rx1 + vx1) > 1.0 - radius) vx1 = -vx1;
            if (Math.abs(ry1 + vy1) > 1.0 - radius) vy1 = -vy1;
            if (Math.abs(rx2 + vx2) > 1.0 - radius) vx2 = -vx2;
            if (Math.abs(ry2 + vy2) > 1.0 - radius) vy2 = -vy2;

            // update position
            rx1 = rx1 + vx1; 
            ry1 = ry1 + vy1; 
            rx2 = rx2 + vx2; 
            ry2 = ry2 + vy2; 
            // clear the background
            StdDraw.clear(StdDraw.GRAY);

            // draw ball on the screen
            if (!(rx1<=rx2-2*radius || rx1>= rx2+2*radius) && !(ry1>=ry2+2*radius || ry1 <=ry2-2*radius)){
                StdDraw.setPenColor(StdDraw.RED);
                vx1 = -vx1;
                vy1 = -vy1;
                vy2 = -vy2;
                vx2 = -vy2;
            }
            else StdDraw.setPenColor(StdDraw.BLACK); 
            StdDraw.filledCircle(rx1, ry1, radius); 
            StdDraw.filledCircle(rx2,ry2,radius);

            // display and pause for 20 ms
            StdDraw.show(20); 
        } 
    } 
} 
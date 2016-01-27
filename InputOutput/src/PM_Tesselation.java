import java.awt.Color;
/**
 * This program draws a tessellation.
 * 
 * @author PMARINA
 * @version 12/8/2015
 */
public class PM_Tesselation
{
    public static void drawTriangle(double[] coords){ //Draw a right side up triangle
        //Sort the coordinates by x and y
        double[] xList = {coords[0], coords[1], coords[2]};
        double[] yList = {coords[3], coords[4], coords[3]};
        //Draw the triangle
        StdDraw.filledPolygon(xList, yList);
        //get ready to draw the outline of the triangle
        StdDraw.setPenColor(StdDraw.BLACK);
        //Draw the triangle's outline
        StdDraw.polygon(xList, yList);
    }
    public static void drawInvertedTriangle(double[] coords){ //draw an upside down triangle
        //Sort out the input into x and y coordinates
        double[] xList = {coords[0], coords[1], coords[2]}; 
        double[] yList = {coords[4],coords[3], coords[4]};
        //Draw the triangle
        StdDraw.filledPolygon(xList, yList);
        StdDraw.setPenColor(StdDraw.BLACK); //Prepare the pen for the triangle border
        StdDraw.polygon(xList,yList); //Draw the outline of the triangle, as drawn in your image
    }
    public static void main(String[] args){
        //Make it big!
        StdDraw.setCanvasSize(1000,1000);
        //Set the scales (I wasn't sure if you were using independant scales or not, so I played it safe)
        StdDraw.setXscale(0,18);
        StdDraw.setYscale(0,18);
        //There are 3 x coordinates, but only 2 heights for the triangle, the top, and the bottom
        double[] coords = new double[5]; //There are only 2 heights
        //The inverter is to toggle between the upside-down and right-side-up triangles
        boolean inverter = false;
        //Define the colors
        Color color1 = new Color(0,255,255);
        Color color2 = new Color(0,0,255);
        Color color3 = new Color(0,0,128);
        //The array of colors, me trying to replicate the image exactly
        Color[] mode = {color1, color2, color3, color3, color2, color1}; //Yes, I need better names
        //The color number from the array mode
        int theColor = 2;
        int prevColor = 0;
        coords[0] = -1.5; //We will begin off the screen, as your image does
        coords[3] = 0; //The height is the base of the canvas, similar to yours
        while(coords[3]<=18){ //Height
            while(coords[2] <=18){ //Length
                if(theColor >=6)theColor = 0; //If the color is higher to the number of elements of mode
                StdDraw.setPenColor(mode[theColor]); //Set the color
                coords[1] = coords[0] + 1.5; //Define the rest of the coordinates based on the first x and the first y
                coords[2] = coords[0]+3;
                coords[4] = coords[3]+3;
                //Invert if not already, flip back to normal, if already inverted
                if(!inverter){drawTriangle(coords); inverter = true;}
                else {drawInvertedTriangle(coords); inverter = false;}
                //Redefine the x basic x coordinate for the next drawings
                coords[0] +=1.5;
                prevColor = theColor;
                theColor++;
            }
            //Reset the coordinates to be ready to draw. We reset the ones already being reset above so that the inner while loop is accurate
            if(prevColor == 0 || prevColor ==5) theColor = 2;
            else theColor = 5;
            coords[0] = -1.5;
            coords[3] += 3;
            coords[1] = coords[0] + 1.5;
            coords[2] = coords[0]+3;
            coords[4] = coords[3]+3;
        }
    }
}

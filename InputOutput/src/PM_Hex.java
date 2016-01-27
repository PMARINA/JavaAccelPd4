
/**
 * Draws hexagons in the shape of an oblong diamond
 * 
 * @author PMARINA 
 * @version 01/10/2016
 */
public class PM_Hex
{
    private static void drawHexagon(double x, double y){
        double[]  xCoords = {x,x+0.333,x+0.666,x+1,x+0.666,x+0.333};
        double[] yCoords = {y,y+0.5,y+0.5,y,y-0.5,y-0.5};
        StdDraw.polygon(xCoords, yCoords);
    }
    public static void main(String[] args){
        StdDraw.setCanvasSize(1000,1000);
        StdDraw.setScale(0,20);
        double y = 10; double x = 1; int counter = 0;
        while(counter<11){
            x = 1+counter*0.666;
            y = 10-counter*0.5; 
            while(x<7.666+ counter*0.666){
                drawHexagon(x,y);
                x+=0.666; y+=0.5;
            }
            counter++;
        }
    }
}
//No Input. NOTE: My hexagons are 1x1, unlike the ones drawn on edmodo.
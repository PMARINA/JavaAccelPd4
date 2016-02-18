import java.util.Scanner;
/**
 * Creates graph paper of the specified size and the right number of graph squares (4 or 1).
 * 
 * @author PMARINA
 * @version 12/4/2015
 */
public class PM_Ex18
{
    /* @param   xStart    Double x starting coordinate
     * @param   yStart    Double y starting coordinate
     * @param   xEnd      Double x ending coordinate
     * @param   yEnd      Double y ending coordinate
     * @return  void      It draws the squares
     * @throws stdErrors
     */
    public static void createSquares(double xStart, double yStart, double xEnd, double yEnd){
        double y = yStart; // the coordinate of the bottom left
        while(y<=yEnd){
            double x = xStart; //Set the x coordinate back to the original coord
            while (x<=xEnd){
                StdDraw.square((x+0.5), (y+0.5), 0.5); //Draw each individual square
                x++; //Increment x by one so that it can draw the next square on the right side of the previous square
            }
            y++; //Increment the y coord so that the inner while loop moves up 1 unit
        }
    }
    /*
     * @param mode - the mode
     * @param N - The width
     * @return none - The window
     * @throws stdErrors
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("What mode would you like:\n1)1 graph per screen\nor\n2)4 graphs per screen");
        int mode = sc.nextInt();
        System.out.println("What is the length of a graph?");
        int N = sc.nextInt();
        sc.close();
        StdDraw.setCanvasSize(1000,1000); // Make the screen size large enough that the graph is a high-res graph
        if (mode == 1){//Making a 1 graph canvas
            StdDraw.setScale(0,N+2); //Set the scale because the drawing is as follows: _[]_ , where the _ are spaces and the [] is the graph. The +2 is for the 2 _'s
            createSquares(1,1,N,N); // Use the creatae squares method to create the graph. The 1,1 instead of 0,0, is to make a border of width, 1 square
        }
        else{
            //The following two lines are unnecessary, but were used for debugging purposes. They are for both the x and y axees. 
            double min = 0;
            double max = 2*N + 3;
            StdDraw.setScale((min),(max)); // Set the scale
            //Bottom-left graph
            createSquares(1,1,N,N); // Begin at 1 and end at N so that there is a border on the bottom and left, and N because there should be N squares. 
            //Bottom-Right graph
            createSquares(max-N-1,1, max-2,N); // Counting from the left, count back N boxes. Since we give the left bottom coord of the square, we need to subtract 1.
            //The 1 is to create a border at the bottom. The max-2 is to leave a small border of 1 (since the coord is the bottom left coord) -- so -1-1 = -2. N is the height, so instead of N-1, it becomes N
            //Top-Left graph
            createSquares(1,max-N-1,N,max-2); // 1 and max-N are for the border. The max-N-1 is because of the bottom right positioning system. The max-2 is because it is N-1, due to coordSys and then -1 for a border
            //Top-Right graph
            createSquares(max-N-1,max-N-1,max-2,max-2);
            //This is the top right, so it is only natural that the coords are repeated. max-N-1 for the coordSys/ max-2 for the coordSys and spacer.
        }
    }
}

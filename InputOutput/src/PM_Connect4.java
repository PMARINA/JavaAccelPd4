import java.util.Scanner;
/**
 * Connect4 - try to get 4 pieces in a row. Gravity counts. 2 players
 * 
 * @author PMARINA
 * @version 12/14/2015
 */
public class PM_Connect4
{
    private static void printBoard(int[][] gameBoard){
        for(int i = 0; i<6; i++){
            System.out.print("\t");
            for(int j = 0; j<7; j++){
                int position = gameBoard[5-i][j];
                if(position == 0){
                    System.out.printf("%3s","[_]");
                }
                if(position == 1){
                    System.out.printf("%3s"," X ");
                }
                if(position == 2){
                    System.out.printf("%3s"," O ");
                }
            }
            System.out.println();
        }
    }
    private static int getDiagLength(int j){
        return 7-j;
    }
    private static boolean instructions(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Connect 4");
        System.out.println("\tThe game begins with the first player choosing the column in which they wish to place their piece");
        System.out.println("\tAs the game progresses, players alternate choosing squares, until a player gets four pieces in a row");
        System.out.println("\tGood luck and have fun!!");
        
        System.out.println("a)continue\nb)quit");
        if(sc.next().equals("b")){System.out.println("Thanks for playing"); return false;}
        for (int i = 0; i<3; i++){
            System.out.println("...");
        }
        return true;
    }
    private static int getMove(){
        System.out.println("In which column would you like to place your tile?");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    private static boolean fourInArow(int[] row){
        if(row.length<4) return false;
        for(int i = 3; i<row.length; i++){
            if(row[i] == row[i-1] && row[i-1] == row[i-2] && row[i-2] == row[i-3] && row[i-3] !=0) return true;
        }
        return false;
    }
    private static boolean hasAnyoneWonYet(int[][] gameBoard, int height, int move){
        if(height >=4){
            int[] column = new int[4];
            for(int i = 0; i<4; i++){
                column[i] = gameBoard[height-i-1][move];
            }
            if(fourInArow(column)) return false;
        }
        int checkCounter = 0;
        for(int i = 0; i<6; i++){
            int[] row = new int[7];
            for(int j = 0; j<7; j++){
                row[j] = gameBoard[i][j];
            }
            if(fourInArow(row))return false;
        }
        int[] diag = new int[7];
        int[] otherDiag = new int[7];
        boolean notDone; boolean stillNotDone;
        for(int jFake = 0; jFake<(gameBoard.length-1) * 2; jFake++){
            int j = jFake;
            if(jFake >= gameBoard.length)j = jFake - gameBoard.length;
            int[] vert; int[] hor; int counter = 0; int diagLength = getDiagLength(j); vert = new int[diagLength]; hor = new int[diagLength];int[] vertOther = new int[diagLength]; int[] horOther = new int[diagLength];
            for(int k = 0; k< diagLength -1;k++){
                int otherK = diagLength - k-1;
                vert[k] = gameBoard[counter+j+k][j+k];
                hor[k] = gameBoard[k+j][counter + j+k];
                vertOther[k] = gameBoard[counter + j + otherK][j+k];
                horOther[k] = gameBoard[k+j][counter+j+otherK];
                counter++;
            }
            if(fourInArow(vert))return true;
            if(fourInArow(hor))return true;
            if(fourInArow(horOther))return true;
            if(fourInArow(vertOther)) return true;
        }
        //for(int i = 0; i<gameBoard.length; i++){
            //for(int k = 0; k<gameBoard[i].length; k++){
                //diag[k] = gameBoard[j][a];
          //  }
            //if(fourInArow(diag)) return false;
            //if(fourInArow(otherDiag))return false;
        //}
        return true;
    }
    public static void main(String[] args){
        int[][] gameBoard = new int[6][7];
        System.out.println(gameBoard.length);
        int[] height = new int[7];
        boolean gameNotWon = instructions();
        int symbol = 2;
        printBoard(gameBoard);
        int moveCounter = 0; boolean staleMate = false;
        if(gameNotWon){
            while(gameNotWon){
                if(moveCounter >= 42) {staleMate = true; gameNotWon = false;}
                int move = -10;
                boolean moveNotValid = true;
                while(moveNotValid){
                    move = getMove();
                    if((move<=6 && move>=0)){
                        if(!(height[move] >= 6))moveNotValid = false;
                    }
                }
                gameBoard[height[move]][move] = symbol;
                height[move] +=1;
                gameNotWon = hasAnyoneWonYet(gameBoard, height[move], move);
                if(symbol == 1)symbol = 2;
                else symbol = 1;
                System.out.println("\n\n\n\n\n");
                printBoard(gameBoard);
                moveCounter++;
            }
        }
        String symbolString = "Nobody won, I am the dictator of the world";
        if(staleMate) System.out.print("Nobody Won this Round :-<");
        else{
            if(symbol == 2){ symbolString = "X";}
            if(symbol ==1){symbolString = "O";}
            System.out.println("The Winner is: " + symbolString + "!");
        }
    }
}
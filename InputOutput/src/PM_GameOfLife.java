/**
 * The Rules
 * For a space that is 'populated'
 * Each cell with one or no neighbors dies, as if by solitude.
 * Each cell with four or more neighbors dies, as if by over-population.
 * Each cell with three neighbors survives.
 * For a space that is 'empty' or 'under-populated'
 * Each cell with three neighbors becomes populated.
 * The Controls
 * 
 * @author PMARINA 
 * @version 01/18/2016
 */
public class PM_GameOfLife
{
    public static boolean[][] getCoords()
    {
        int[][] board = {{30,30},{30,31},{30,32}};
        boolean[][] gBoard = new boolean[102][102];
        for(int i = 0; i<board.length; i++){
            for(int j = 0 ; j<board[i].length; j++){
                board[i][j] +=1;
            }
        }
        for(int i = 0; i<board.length; i++){
            gBoard[board[i][0]][board[i][1]] = true;
        }
        return gBoard;
    }
    public static void printBoard(boolean[][] board){
    	StdDraw.clear(StdDraw.WHITE);
        for(int i = 1; i<board.length-1; i++){
            for(int j = 1; j<board[i].length-1; j++){
                if(board[i][j])StdDraw.filledSquare(i-1,j-1,0.5);
            }
        }
    }
    public static boolean checkIfDead(boolean[][] board, int i, int j){
        boolean[] conditions = {board[i+1][j], board[i-1][j],board[i][j+1], board[i][j-1], board[i+1][j+1], board[i-1][j-1], board[i+1][j-1], board[i-1][j+1]};
        int counter = 0;
        for (boolean condition : conditions) if(condition) counter++;
            if(counter ==3 && board[i][j] == false){
            	return true;
            }
            else if(board[i][j] == true && (counter == 2 || counter ==3)) return true;
            else return false;
    }
    public static boolean[][] refreshBoard(boolean[][] board){
    	boolean[][] boardCopy = new boolean[board.length][board[0].length];
    	for(int i = 0; i<boardCopy.length; i++){
    		for(int j = 0; j<boardCopy[i].length; j++){
    			boardCopy[i][j] = board[i][j];
    		}
    	}
    	for(int i = 1; i<board.length-2; i++){
            for(int j = 1; j<board.length-2; j++){
                boardCopy[i][j] = checkIfDead(board,i,j);
            }
        }
        return boardCopy;
    }
    public static void getMouseClickCoords(){
    	//do something
    }
    public static void main(String[] args){
        StdDraw.setCanvasSize(1000,1000);
        StdDraw.setScale(0,100);
        boolean[][] board = getCoords();//new boolean[102][102];
        printBoard(board);
        StdDraw.show(1000);
        while(true){
        	board = refreshBoard(board);
            printBoard(board);
            StdDraw.show(1000);
        }
    }
}
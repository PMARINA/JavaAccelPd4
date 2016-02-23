
public class VN_GameOfLife {

	public static void main(String[] args) {
		System.out.println("Welcome to Conway's Game of Life");
		StdDraw.setScale(0, 20);
		boolean[][] board = new boolean[20][20];
		board = init(board);
		boardPrint(board);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(true){
			board = switchOrNo(board);
			boardPrint(board);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		

	}
	public static boolean[][] init(boolean[][] board){
		board[10][9] = true;
		board[10][10] = true;
		board[10][11] = true;
		board[11][11] = true;
		board[12][10] = true;
		
		return board;
	}
	
	public static boolean[][] switchOrNo (boolean[][] board){
		boolean boardCopy[][] = new boolean[board.length][board[0].length];
		for(int i = 0; i<boardCopy.length;i++){
			for(int j = 0; j<boardCopy.length;j++){
				boardCopy[i][j] = board[i][j];
			}
		}
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){
				int counter = 0;
				if ((((i != board.length-1) && (j != board.length-1)) && (i != 0)) && (j != 0)){
					//Check for all neighbors and their values
					if (board[i+1][j] == true){
						counter++;
					}
					if (board[i][j+1] == true){
						counter++;
					}
					if (board[i+1][j+1] == true){
						counter++;
					}
					if (board[i][j-1] == true){
						counter++;
					}
					if (board[i-1][j] == true){
						counter++;
					}
					if (board[i-1][j-1] == true){
						counter++;
					}
					if(board[i-1][j+1] == true){
						counter++;
					}
					if(board[i+1][j-1] == true){
						counter++;
					}
					
					
					
					
				}
				
				else if (i == 0 && j == 0){
					
					if (board[i+1][j] == true){
						counter++;
					}
					if (board[i][j+1] == true){
						counter++;
					}
					if (board[i+1][j+1] == true){
						counter++;
					}
					
				}
				
				else if (i == board.length-1 && j == 0){
					
					if (board[i-1][j] == true){
						counter++;
					}
					if (board[i][j+1] == true){
						counter++;
					}
					if (board[i-1][j+1] == true){
						counter++;
					}
					
				}
				
				else if (i == board.length-1 && j == board.length-1){
					
					if (board[i-1][j] == true){
						counter++;
					}
					if (board[i][j-1] == true){
						counter++;
					}
					if (board[i-1][j-1] == true){
						counter++;
					}
					
				}
				
				else if (i == 0 && j == board.length-1){
					
					if (board[i+1][j] == true){
						counter++;
					}
					if (board[i][j-1] == true){
						counter++;
					}
					if (board[i+1][j-1] == true){
						counter++;
					}
					
				}
				
				//Change values
				if (counter < 2){
					boardCopy[i][j] = false;
				}
				if (((counter == 2) ||(counter ==3)) && (board[i][j] == true)){
					boardCopy[i][j] = true;
				}
				if (counter > 3){
					boardCopy[i][j] = false;
				}
				if (counter == 3 && !board[i][j]){
					boardCopy[i][j] = true;
				}
				
				
				
			}
		}
		return boardCopy;
	}
	
	public static void boardPrint(boolean board[][]){
		StdDraw.clear(StdDraw.GRAY);
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){
				
				if (board[i][j]){
					StdDraw.setPenColor(StdDraw.YELLOW);
					StdDraw.filledRectangle(i, j, 0.5, 0.5);
				}
			}
		}
	}
}


import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackDriver {
	static ArrayList<Hand> players = new ArrayList<Hand>();

	public static void main(String[] args) {
		boolean gameNotWon = true;
		int numPlayers = Integer.parseInt(getInfo("How many players?"));
		for (int i = 0; i < numPlayers; i++)
			players.add(new Hand(getInfo("What is your name player " + i + "?")));
		while(gameNotWon){
			gameNotWon = !checkGameWon();
		}
	}
	public static boolean checkGameWon(){
		int counter = 0;
		String lost = "lost";
		String won = "won";
		String hold = "hold";
		for(Hand h : players){
			if(h.getStatus.equals(lost) || h.getStatus.equals(won) || h.getStatus.equals(hold))
			counter++;
		}
	}
	public static String getInfo(String prompt) {
		Scanner sc = new Scanner(System.in);
		System.out.println(prompt);
		String output = sc.nextLine();
		sc.close();
		return output;
	}
}

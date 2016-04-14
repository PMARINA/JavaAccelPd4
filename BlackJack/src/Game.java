import java.util.ArrayList;
import java.util.Scanner;
public class Game {
	private ArrayList<Player> players = new ArrayList<Player>();
	public Game(int players){
		for(int i = 0; i<players; i++)
			addPlayer();
	}
	private void addPlayer() {
		Scanner sc = new Scanner(System.in);
		players.add(new Player(sc.next()));
		sc.close();
	}
	private void removePlayer(String name){
		for(int i = 0; i<players.size(); i++){
			if(players.get(i).equals(name)){
				players.remove(i);
				return;
			}
		}
	}
	
}

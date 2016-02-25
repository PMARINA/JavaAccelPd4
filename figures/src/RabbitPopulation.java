import java.util.ArrayList;

/*
 * [PROMPT]
 * @author PMARINA
 * @version Feb 25, 2016
 */
public class RabbitPopulation {
	private ArrayList<RabbitPair> allPairs = new ArrayList<RabbitPair>();
	public RabbitPopulation(int pairs){
		for(int i = 0; i<pairs; i++){
			allPairs.add(new RabbitPair());
		}
	}
	public void reproduce(){
		for(RabbitPair rb : allPairs){
			if(rb!=null)allPairs.add(rb);
		}
	}
}

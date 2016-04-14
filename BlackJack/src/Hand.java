import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards = new ArrayList<Card>();

	public boolean addCard(Card c) {
		if (c != null)
			this.cards.add(c);
		else
			return false;
		return true;
	}

	public void resetHand() {
		this.cards.clear();
	}

	public int getValue() {
		int sum = 0;
		for (Card c : cards) {
			sum += c.getValue();
		}
		return sum;
	}
}

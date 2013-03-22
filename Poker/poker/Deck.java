package poker;

import java.util.Stack;

public interface Deck {
	
	public Stack<Card> getDeck();
	
	public Card[] dealHand();

}

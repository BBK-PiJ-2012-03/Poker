package poker;

import java.util.Stack;

public interface Deck {
	/**
	* Getter for the deck
	* @return the deck as a Stack of Cards
	*/
	public Stack<Card> getDeck();
	
	/**
	* Creates an array of 5 Cards
	* @return the 5 card array
	*/
	public Card[] dealHand();
	
	/**
	 * Deals one card by popping the card on top of the stack.
	 * @return the card on top of the Stack
	 */
	public Card dealCard();

	/*public void prettyPrint();*/
}

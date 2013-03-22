package poker;

import java.util.Stack;

public class DeckImpl implements Deck {
	private Stack<Card> myDeck;
	
	//A constructor will create a deck with all the cards, and then shuffle the deck to make the order random
	public DeckImpl() {
		
		 myDeck = new Stack<Card>();
		 
		 //Initialize all cards
		 for(Rank r : Rank.values()) {
			 
			 for(Suit s: Suit.values()) {
				
				 Card myCard = new CardImpl(r,s);
				 
				 //Now add them to the stack
				 myDeck.push(myCard);
			 }
			  
		 }
		 	
	}
	
	public Stack<Card> getDeck(){
		return myDeck;
	}
	
	

}

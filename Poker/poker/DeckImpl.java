package poker;

import java.util.Collections;
import java.util.Stack;

public class DeckImpl implements Deck {
	private Stack<Card> myDeck;
	
	//A constructor will create a deck with all the cards, and then shuffle the deck to make the order random
	public DeckImpl() {
		
		 myDeck = new Stack<Card>();
		 
		 //Initialise all cards
		 for(Rank r : Rank.values()) {
			 
			 for(Suit s: Suit.values()) {
				
				 Card myCard = new CardImpl(r,s);
				 
				 //Now add them to the stack
				 myDeck.push(myCard);
			 }
			  
		 }
		 
		 Collections.shuffle(myDeck);
		 	
	}
	
	public Stack<Card> getDeck(){
		return myDeck;
	}
	
	public Card[] dealHand() {
		
		Card[] cards = new Card[5];
		
		//No need to check for nullPointerException, the deck will never become empty
		for(int i = 0 ; i < 5; i++) {
			cards[i] = myDeck.pop();
		}
		return cards;
	}
	
	public Card dealCard() {
		return myDeck.pop();
	}
	
	/*public void prettyPrint() {
		int counter = 0;
		while ( !myDeck.empty() )
        {
                System.out.print ( myDeck.peek().getRank().getRankValue() + " of " + myDeck.pop().getSuit() );
                System.out.print ( ',' );
                counter++;
        }
		
		System.out.println(counter);
	}*/
	
	

}

package poker;

public class GameImpl implements Game {
	
	Deck deck = new DeckImpl();
	
	Hand playerHand = new HandImpl(deck.dealHand());
	Hand computerHand = new HandImpl(deck.dealHand());
	

}

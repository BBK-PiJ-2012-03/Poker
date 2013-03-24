package poker;

import java.util.Scanner;

public class GameImpl implements Game {
	
	//Game starts
	//Deck is initialized, (dealt and shuffled)
	Deck deck = new DeckImpl();
	
	//Hands are dealt
	Hand playerHand = new HandImpl(deck.dealHand());
	Hand computerHand = new HandImpl(deck.dealHand());
	
	//An array of card is created for its hand containing the cards of each hand
	//This is done so that we can change some cards and then create a new hand which will be ordered and evaluated by HandImpl constructor
	Card[] playerHandCards = playerHand.getHand();
	Card[] computerHandCards = computerHand.getHand();
	
	
	
	//Game begins!
	public static void main(String[] args) {
		
		GameImpl game = new GameImpl();
		game.launch();
		
	}
	
	public void launch() {
	
		//Dealer's changes come here TODO	
	
		//Player's changes
		System.out.println("Your hand is " + playerHand.toString()); //TODO Overwrite the toString method of Hand to print e.x. ACE of SPADES
		int cardsToChange = howManyCardsToChange();
		
		for(int i=0; i < cardsToChange; i++) {
			
		}
		
		
	
	}
	
	public int howManyCardsToChange() {
		System.out.println("How many cards you want to change?");
		
		Scanner scanner = new Scanner(System.in);
		
		int cardsToChange = 6; //It is initialized to a wrong input number. This way exception will be thrown later if the user input is wrong
		try {
			cardsToChange = Integer.parseInt(scanner.nextLine());
		}
		catch (NumberFormatException e) {
			System.out.println("Not a valid number");
		}
		
		if (cardsToChange > 5) { //TODO CHECK IF its 5 or 3
			throw new IllegalArgumentException ("Wrong, you can only change 0 to 5 cards");
		}
		
		return cardsToChange;
	}
}

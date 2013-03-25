package poker;

import java.util.Scanner;

public class GameImpl implements Game {
	
	//Game starts
	//Deck is initialized, (dealt and shuffled)
	Deck deck = new DeckImpl();
	
	//Hands are dealt
	Hand playerInitialHand = new HandImpl(deck.dealHand());
	Hand computerInitialHand = new HandImpl(deck.dealHand());
	
	//An array of card is created for its hand containing the cards of each hand
	//This is done so that we can change some cards and then create a new hand which will be ordered and evaluated by HandImpl constructor
	Card[] playerHandCards = playerInitialHand.getHand();
	Card[] computerHandCards = computerInitialHand.getHand();
	
	
	
	//Game begins!
	public static void main(String[] args) {
		
		GameImpl game = new GameImpl();
		game.launch();
		
	}
	
	public void launch() {
	
		//Dealer's changes come here TODO
		int dealerCardsToChange = DealerAI.cardsToChange(computerInitialHand);
		
		while(dealerCardsToChange > 0) {
			computerHandCards[5-dealerCardsToChange] = deck.dealCard();
			dealerCardsToChange--;	
		}
		
		//Finally I recreate the dealer's hand after the changes using the computerHandCards array
		Hand computerFinalHand = new HandImpl(computerHandCards);
		
		//deck.prettyPrint(); WTF WHY WHY WHY WHY
	
		//Player's changes
		System.out.println("Your hand is " + playerInitialHand.toString());
		
		System.out.println("Computer's hand is " + computerInitialHand.toString());
		
		
		
		
		//int playerCardsToChange = howManyCards();
		
		//Calculate winner!
		Comparator comparator = new ComparatorImpl();
		int result = comparator.calculateWinner(playerInitialHand, computerFinalHand);
		if (result == 1) {
			System.out.println("PLAYER wins!");
		}
		else if(result == 2) {
			System.out.println("COMPUTER wins!");
		}
		else {
			System.out.println("We have a tie, please play again");
		}
		
		System.out.println("Computer's final hand is " + computerFinalHand.toString());
		
	
	}
	
	public int howManyCards() {
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

package poker;

import java.util.Scanner;

public class GameImpl {
	
	Deck deck;
	Hand playerHand;
	Hand computerHand;	
	
	//Game begins!
	public static void main(String[] args) {
		
		GameImpl game = new GameImpl();
		game.launch();
		
	}
	
	public void launch() {
	
		//Deck is initialized, (dealt and shuffled)
		deck = new DeckImpl();
		
		//Hands are dealt
		playerHand = new HandImpl(deck.dealHand());
		computerHand = new HandImpl(deck.dealHand());	
		
			
		//Player's changes
		System.out.println("Your initial hand is " + playerHand.toString() +". You have " + playerHand.getCategory());		
		
		int[] cardList = whichCards();
		if(cardList[0] != 0){
			playerHand.setCards(cardList,getNewCards(cardList.length));
		}
		
		//Dealer's changes come here 
		int dealerCardsToChange = DealerAI.cardsToChange(computerHand);		
						
		if(dealerCardsToChange > 0) {
			Card[] newCards = getNewCards(dealerCardsToChange);
			computerHand.setCards(newCards);
			System.out.println("\nComputer has changed " + dealerCardsToChange + " cards.\n");
		} else {
			System.out.println("\nComputer has not changed any card\n");
		}
		
		//Calculate winner!
		System.out.println("Computer's final hand is " + computerHand.toString() + ". It has " + computerHand.getCategory());
		System.out.println("Your final hand is " + playerHand.toString() + ". You have " + playerHand.getCategory());

		
		int result = Comparator.calculateWinner(playerHand, computerHand);
		if (result == 1) {
			System.out.println("PLAYER wins!");
		}
		else if(result == 2) {
			System.out.println("COMPUTER wins!");
		}
		else {
			System.out.println("We have a tie, please play again");
		}

	}
	/**
	 * This method creates an array of cards by dealing a number of cards equal to cardsToChange
	 * @param cardsToChange is an integer indicating the number of the cards that need to be changed
	 * @return an array of Cards that are the new changed cards.
	 */
	private Card[] getNewCards(int cardsToChange){
		Card[] newCards = new Card[cardsToChange];
		for(int i=0;i<cardsToChange;i++){
			newCards[i]=deck.dealCard();
		}
		return newCards;
	}
	
	/**
	 * This method asks the user which cards he wants to change.
	 * The user enters the position of the cards he want to change (separated by ',').
	 * Then the method returns an array of integers with the positions
	 * @return an array of integers with the positions of the cards that the user wants to change
	 */
	private int[] whichCards() {
		
		boolean notFinished = true;
		int[] cardsToChange = null;
		while(notFinished){
			System.out.println("Which cards do you want to change? If you don't want to change any card, type 0.");
			System.out.print("Introduce the numbers separated by ',':");
					
			Scanner scanner = new Scanner(System.in);
			String readCards = scanner.nextLine();
			
			if(readCards.equals("0")){
				scanner.close();
				cardsToChange = new int[1];
				cardsToChange[0] = 0;
				return cardsToChange;
			} else {
				String[] cardsString = readCards.split(",");
				cardsToChange = new int[cardsString.length];	
				
				if (cardsString.length > 5){
					System.out.println("The amount of cards selected is invalid, as there can only be from 0 to 5");
				} else {
					try {
						
						for(int i=0;i<cardsString.length;i++){
							cardsToChange[i] = Integer.parseInt(cardsString[i]);
							// This detects that the position of the card is correct
							if(cardsToChange[i] > 5 || cardsToChange[i] < 1){
								throw new NumberFormatException();
							}
							// This detects if the card wanted to be changed has already been introduced
							for(int j=0;j<i;j++){								
								if(cardsToChange[j]==cardsToChange[i]){
									throw new NumberFormatException();
								}
							}
						}
						notFinished=false;
						scanner.close();						
					}
					catch (NumberFormatException e) {
						System.out.println("Some of the data introduced is not a valid number, is not between 1 and 5, or a card is repeated");
					}					
				}
			}			
		}
		return cardsToChange;
		
			
	}
}

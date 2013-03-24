package poker;

public class DealerAI {
	
	/**
	 * Returns the number of the cards the dealer will change. This number is calculated using very simple probabilities.
	 * There are certainly better strategies of playing the game, but these are enough to make the dealer take rational decisions for the cards change.
	 * @param hand the original hand of the dealer before the changes.
	 * @return the number of the cards that the dealer will change
	 * The cards will always be from the end of the Card[] of the dealer's hand.
	 */
	public static int cardsToChange(Hand hand){
		
		//First of all if the dealer has either a Straight-flush, a Straight, a Flush or a full-house he wont change any cards
		if (hand.getCategory().ordinal() == 9 || hand.getCategory().ordinal() == 7 || hand.getCategory().ordinal() == 6 || hand.getCategory().ordinal() == 5 ) {
			return 0;
		}
		
		//If the dealer has a Four_Of_A_Kind or Two_Pairs he will check the last card and if its smaller than 8, he will change it. 
		if (hand.getCategory().ordinal() == 8 || hand.getCategory().ordinal() == 3) {
			if (Integer.parseInt(hand.getHand()[5].getRank().getRankValue()) < 7) {
				return 1;
			} else {
				return 0;
			}	
		}
		
		//If the dealer has Three_Of_A_Kind he changes only the last card. (It is slightly better than changing the last 2 cards.
		if (hand.getCategory().ordinal() == 4) {
			return 1;
		}
		
		//If the dealer has one Pair he will keep the highest spare card and change the last two.
		if (hand.getCategory().ordinal() == 1) {
			return 2;
		}
		
		//If the dealer has only High_Card he will check his 2 higher cards, if they are ACE, KING, QUEEN or JACK he will keep them, and change all the others.
		//If not he will change all of his cards
				if (hand.getCategory().ordinal() == 0) {
					//Two good cards, so he changes only 3
					if(hand.getHand()[0].getRank().ordinal() > 8 && hand.getHand()[1].getRank().ordinal() > 8) {
						return 3;
					}
					//One good card, so he changes 4
					else if(hand.getHand()[0].getRank().ordinal() > 8){
						return 4;
					} else {
						return 5;
					  }	
				}
		
		return 0;
	}

}

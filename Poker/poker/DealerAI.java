package poker;
/**
 * This is a class with only one static method that calculates how many cards the dealer will change based on his hand.
 * The cards will always be from the end of the Card[] of the dealer's hand, because the way a hand is sorted, its "always" for the best to change cards from the end of the hand
 * Sometimes (very rarely) one should change some cards that are not on the end of his hand, but we decided not to deal with this possibility for the dealer because it will make things complex.
 * This is based on the fact that flush and straight are rare in a game between only 2 people. So even if the dealer has 4 cards of the same suit which is rare, its not a bad choise to change them and focus on higher cards.
 */
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
		if (hand.getCategory() == Category.Straight_Flush || hand.getCategory() == Category.Full_House || hand.getCategory() == Category.Flush || hand.getCategory() == Category.Straight ) {
			return 0;
		}
		
		//If the dealer has a Four_Of_A_Kind or Two_Pairs he will check the last card and if its smaller than 8, he will change it. 
		if (hand.getCategory() == Category.Four_Of_A_Kind || hand.getCategory() == Category.Two_Pairs) {
			if (Integer.parseInt(hand.getHand()[4].getRank().getRankValue()) < 7) {
				return 1;
			} else {
				return 0;
			}	
		}
		
		//If the dealer has Three_Of_A_Kind he changes only the last card. (It is slightly better than changing the last 2 cards.
		if (hand.getCategory() == Category.Three_Of_A_Kind) {
			return 1;
		}
		
		//If the dealer has one Pair he will keep the highest spare card and change the last two.
		if (hand.getCategory() == Category.Pair) {
			return 2;
		}
		
		//If the dealer has only High_Card he will check his 2 higher cards, if they are ACE, KING, QUEEN or JACK he will keep them, and change all the others.
		//If not he will change all of his cards
				if (hand.getCategory() == Category.High_Card) {
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

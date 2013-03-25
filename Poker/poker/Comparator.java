package poker;
/** This is the Comparator, that can get 2 hands and calculate which one is better
*
*/
public class Comparator{
	/**
	 * This method gets 2 hands and calculates which one is better
	 * @param hand1 the player's hand
	 * @param hand2 the computer's hand
	 * @return 1 if the player wins, 2 if the computer wins and 0 if we have a tie.
	 */
	public static int calculateWinner(Hand hand1,Hand hand2) {
		
		if (hand1.getCategory().ordinal() < hand2.getCategory().ordinal()) {
			return 2;
		}
		
		else if (hand1.getCategory().ordinal() > hand2.getCategory().ordinal()) {
			return 1;
		}
		else {	
			for(int i=0; i < 5; i++) {
				
				if (hand1.getHand()[i].getRank().ordinal() < hand2.getHand()[i].getRank().ordinal() ) {
					return 2;
				} else 	if (hand1.getHand()[i].getRank().ordinal() > hand2.getHand()[i].getRank().ordinal() ) {
					return 1;
				}
			}
			return 0;
		}
	}	
}

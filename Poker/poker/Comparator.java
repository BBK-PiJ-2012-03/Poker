package poker;

public interface Comparator {
	/**
	* Given 2 Hands, calculates the winner
	*
	* @param hand1 the player hand
	* @param hand2 the computer hand
	* @return 1 if player's hand wins, 2 if computer's hand wins, 0 if we have a tie.
	*/
	public int calculateWinner(Hand hand1, Hand hand2);
}

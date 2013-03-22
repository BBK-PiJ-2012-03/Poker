package poker;

public interface Hand {

	/**
	 * Returns the category of the hand
	 * 
	 * @return Category of the hand
	 */
	public Category handCategory();
	
	/**
	 * Returns an array with the cards in the hand
	 * 
	 * @return Card[] array with the cards in Hand
	 */
	public Card[] cardsInHand();
}

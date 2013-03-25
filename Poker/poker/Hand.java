package poker;

public interface Hand {

	/**
	 * Returns the category of the hand
	 * 
	 * @return Category of the hand
	 */
	public Category getCategory();
	
	/**
	 * Returns an array with the cards in the hand
	 * 
	 * @return Card[] array with the cards in Hand
	 */
	public Card[] getHand();
	
	/*
	 * Return an String with the hand
	 * 
	 * @return String with the hand
	 */
	public String toString();

	/*
	 * Set an undefined number of cards in the hand. It will start changing the cards from the end to the beginning 
	 * 
	 * @param Card[] used to set an undefined number of cards 
	 */
	public void setCards(Card... cards);
	
	/*
	 * Set an undefined number of cards in the hand. It will change the cards in the positions stated in the cardList
	 * 
	 * @param Card[] used to set an undefined number of cards 
	 */
	public void setCards(int[] cardList,Card[] cards);
}

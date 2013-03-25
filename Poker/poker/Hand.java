package poker;
 /**
 * Hand is a poker hand. It consists of an array of 5 cards and a Category of the hand.
 * Hand is evaluated and sorted at construction time (evaluateHand) is called by the constructor.
 * It is sorted in a way that puts all the cards that make the Category of the hand at the beginning of the Card array. (for example Pairs or Three_of_a_Kind)
 * and the rest cards are sorted from higher to lower.
 * This way its easy for the hand to be evaluated and compared with other hands
 * It also makes changing card easy because most of the times the cards that should be changed are at the end of the hand.
 */
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

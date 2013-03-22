package poker;

public class HandImpl implements Hand {

	Category category;
	Card card[];
	
	HandImpl(Card[] card){
		evaluateHand(card);
		
	}
	
	private void evaluateHand(Card[] card) {
		// TODO Auto-generated method stub
		
	}

	public Category handCategory() {
		
		return category;
	}

	public Card[] cardsInHand() {
		return card;
	}

}

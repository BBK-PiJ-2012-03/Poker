package poker;

public class HardImpl implements Hand {

	Category category;
	Card card[];
	
	HardImpl(Card[] card){
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

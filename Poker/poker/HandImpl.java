package poker;

public class HandImpl implements Hand {

	Category category;
	Card[] hand = new Card[5];
	
	public HandImpl(Card[] cards){
		evaluateHand(cards);		
	}
	
	private void evaluateHand(Card[] initialCards) {
		// This booleans will keep control of the hand.
		// As soon as the different categories are discarded, 
		// the respective boolean turns false
		boolean straightFlush = true;
		boolean poker = true;
		boolean fullHouse =true;
		boolean flush = true;
		boolean straight = true;
		boolean threeKind = true;
		boolean twoPairs = true;
		boolean pair = true;
		boolean allDifferentRank=true;
		
		// The cards are ordered from highest value to lowest
		// This makes easier the evaluation of the hand category
		// Also, it will find if there is an straight or straight flush
		// as it will find whether two cards are equal at least,
		// and will allow the system to check which kind of equality there is
		
		for(int i=0;i<initialCards.length;i++){
			for(int j=(i+1);j<initialCards.length;j++){
				if(initialCards[i].getRank().compareTo(initialCards[j].getRank()) < 0 ){
					Card tempCard = initialCards[i];
					initialCards[i] = initialCards[j];
					initialCards[j] = tempCard;
				} else if(initialCards[i].getRank().compareTo(initialCards[j].getRank())==0){
					straight=false;
					straightFlush=false;
					allDifferentRank=false;
				}
			}
		}
		

			

	
		// This will look if all the suits are the same 
		// for the flush and the straightFlush.
		// If it finds a different suit it will stop doing the loop
		for(int i=0;i<initialCards.length-1;i++){
			if(initialCards[i].getSuit().compareTo(initialCards[i+1].getSuit())!=0){
				flush = false;
				straightFlush = false;
				break;
			}
		}
		
		
		hand = initialCards;
		return;
		/*
		// Checking if it is a straight or straight flush
		for(int i=0;i<initialCards.length-1;i++){
			if(initialCards[i].getRank().ordinal()+1!=initialCards[i+1].getRank().ordinal()){
				straight=false;
				straightFlush=false;
			}
		}
		
		if(straightFlush){
			category = Category.Straight_Flush;
			hand = initialCards;
			return;			
		}
		
		*/
	}

	public Category getCategory() {
		
		return category;
	}

	public Card[] getHand() {
		return hand;
	}
	


}

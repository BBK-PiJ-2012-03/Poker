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
		boolean poker = false;
		boolean flush = true;
		boolean straight = true;
		boolean threeKind = true;
		boolean twoPairs = true;
		boolean pair = true;
		//When this is true, the program does not check for categories with two or more similar ranks
		boolean allDifferentRank=true; 
		
		// The cards are ordered from highest value to lowest
		// This makes easier the evaluation of the hand category
		// Also, it will find if there is an straight or straight flush
		// as it will find whether two cards are equal at least,
		// and will allow the system to check which kind of equality there is
		
		for(int i=0;i<initialCards.length;i++){
			for(int j=(i+1);j<initialCards.length;j++){
				if(initialCards[i].getRank().ordinal() < initialCards[j].getRank().ordinal()){
					Card tempCard = initialCards[i];
					initialCards[i] = initialCards[j];
					initialCards[j] = tempCard;
				} else if(initialCards[i].getRank().ordinal() == initialCards[j].getRank().ordinal()){
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

		
		
		// Checking if it is a straight or straight flush
		for(int i=0;i<initialCards.length-1;i++){
			if(initialCards[i].getRank().ordinal()-1!=initialCards[i+1].getRank().ordinal()){
				straight=false;
				straightFlush=false;					
				break;
			}
		}
		
		

		if(straightFlush){
			category = Category.Straight_Flush;
			hand = initialCards;
			return;			
		}
		
		// Checking if there is a poker
		if(!allDifferentRank){
			int numberOfCoincidences = 0;
			for(int i=0;i<=1;i++){
				for(int j=(i+1);j<5;j++){
					if(initialCards[i].getRank().compareTo(initialCards[j].getRank())==0){
						numberOfCoincidences++;						
					}
				}
				if (numberOfCoincidences==3){
					poker=true;
					break;
				} else {
					poker = false;
					numberOfCoincidences=0;
				}
				
			}
		}
		
		if(poker){
			if(initialCards[2].getRank().ordinal()<initialCards[0].getRank().ordinal()){
				Card temp = initialCards[4];
				initialCards[4] = initialCards[0];
				initialCards[0] = temp;
			}
			hand = initialCards;
			category = Category.Four_Of_A_Kind;
			return;
		}
		
		//Checking if there is a full house
		if(!allDifferentRank){
			if(initialCards[0].getRank()==initialCards[1].getRank() && 
					initialCards[1].getRank() == initialCards[2].getRank() 
					&& initialCards[3].getRank() == initialCards[4].getRank()){
				hand = initialCards;
				category = Category.Full_House;
				return;
			} else if (initialCards[0].getRank()==initialCards[1].getRank() && 
					initialCards[2].getRank() == initialCards[3].getRank() 
					&& initialCards[3].getRank() == initialCards[4].getRank()){
				Card temp = initialCards[0];
				initialCards[0] = initialCards[4];
				initialCards[4] = temp;
				temp = initialCards[1];
				initialCards[1] = initialCards[3];
				initialCards[3] = temp;	
				hand = initialCards;
				category = Category.Full_House;
				return;
			}			
		}
		
		//Checking if there is a flush
		if(flush){
			category = Category.Flush;
			hand = initialCards;
			return;
		}
		
		//Checking if there is a straight
		
		if(straight){
			category = Category.Straight;
			hand = initialCards;
			return;
		}
		
		// Checking if there are three of a kind
		if(threeKind){
			if(initialCards[0].getRank() == initialCards[1].getRank() && 
					initialCards[1].getRank() == initialCards[2].getRank()){
				category = Category.Three_Of_A_Kind;
				hand = initialCards;
				return;
			} else if (initialCards[2].getRank() == initialCards[3].getRank() && 
					initialCards[1].getRank() == initialCards[2].getRank()){
				Card temp = initialCards[0];
				initialCards[0] = initialCards[3];
				initialCards[3] = temp;
				category = Category.Three_Of_A_Kind;
				hand = initialCards;
				return;
			} else if (initialCards[2].getRank() == initialCards[3].getRank() && 
					initialCards[3].getRank() == initialCards[4].getRank()){
				Card temp = initialCards[0];
				initialCards[0] = initialCards[3];
				initialCards[3] = temp;
				temp = initialCards[1];
				initialCards[1] = initialCards[4];
				initialCards[4] = temp;
				category = Category.Three_Of_A_Kind;
				hand = initialCards;
				return;
			}
		}
		
		// Checking if there are two pairs
		if(twoPairs){
			if(initialCards[0].getRank() == initialCards[1].getRank() && 
					initialCards[2].getRank() == initialCards[3].getRank()){
				category = Category.Two_Pairs;
				hand = initialCards;
				return;
			} else if(initialCards[0].getRank() == initialCards[1].getRank() && 
					initialCards[3].getRank() == initialCards[4].getRank()){
				Card temp = initialCards[2];
				initialCards[2] = initialCards[4];
				initialCards[4] = temp;
				category = Category.Two_Pairs;
				hand = initialCards;
				return;
			} else if(initialCards[1].getRank() == initialCards[2].getRank() && 
					initialCards[3].getRank() == initialCards[4].getRank()){
				Card temp = initialCards[0];
				initialCards[0] = initialCards[2];
				initialCards[2] = initialCards[4];
				initialCards[4] = temp;
				category = Category.Two_Pairs;
				hand = initialCards;
				return;
			}
		}
		
		if(pair){
			if(initialCards[0].getRank() == initialCards[1].getRank()){
				category = Category.Pair;
				hand = initialCards;
				return;
			} else if (initialCards[1].getRank() == initialCards[2].getRank()){
				Card temp = initialCards[0];
				initialCards[0] = initialCards[2];
				initialCards[2] = temp;
				category = Category.Pair;
				hand = initialCards;
				return;
			} else if (initialCards[2].getRank() == initialCards[3].getRank()){
				Card temp = initialCards[0];
				initialCards[0] = initialCards[2];
				initialCards[2] = temp;
				temp = initialCards[1];
				initialCards[1] = initialCards[3];
				initialCards[3] = temp;
				category = Category.Pair;
				hand = initialCards;
				return;
			} else if (initialCards[3].getRank() == initialCards[4].getRank()){
				Card temp = initialCards[3];
				Card temp2 = initialCards[4];
				initialCards[4] = initialCards[2];
				initialCards[3] = initialCards[1];
				initialCards[2] = initialCards[0];
				initialCards[0]=temp;
				initialCards[1]=temp2;
				category = Category.Pair;
				hand = initialCards;
				return;
			}
		}
		
		category = Category.High_Card;
		hand = initialCards;
	}

	public Category getCategory() {
		
		return category;
	}

	public Card[] getHand() {
		return hand;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		for(int i=0 ; i < hand.length; i++) {
			result +=  i+1 + ")-[" + hand[i].getRank().getRankValue() + " of " + hand[i].getSuit() + "] ";
		}
		return result; 
	}
	
	public void setCards(Card... cards) {
		for(int i=0;i<cards.length;i++){
			hand[4-i] = cards[i];
		}
		evaluateHand(hand);
	}
	
	public void setCards(int[] cardList,Card[] cards){
		for(int i=0;i<cards.length;i++){
			hand[cardList[i]-1] = cards[i];
		}
		evaluateHand(hand);		
	}
}

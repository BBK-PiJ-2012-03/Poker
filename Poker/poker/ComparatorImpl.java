package poker;

public class ComparatorImpl implements Comparator{


	int winner;
	//if winner == 1; user wins
	//if winner == 2; computer wins
	//if winner == 0; tie
	
	public ComparatorImpl () {
		
		
	}
	
	public int calculateWinner(Hand hand1,Hand hand2) {
		
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

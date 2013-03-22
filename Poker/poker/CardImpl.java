package poker;

public class CardImpl implements Card{
	
	Rank rank;
	Suit suit;
	
	public CardImpl(Rank rank, Suit suit){ 
		this.rank=rank;
		this.suit=suit;
	}
	
	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

}

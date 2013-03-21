package poker;

public interface Card {
	
	public Rank getRank();
	
	public void setRank(Rank rank);
	
	public Suit getSuit();
	
	public void setSuit(Suit suit);
}

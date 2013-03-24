package poker;

public interface Game {
	/**
	* @return the number of cards that the user wants to change.
	* @throws IllegalArgumentException if the user input is not a number between 0 and 5 
	*/
	public int howManyCardsToChange();
	
}

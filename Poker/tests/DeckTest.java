package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;

import poker.Deck;
import poker.DeckImpl;


public class DeckTest {

	Deck firstTry;
	Deck secondTry;
	
	
	
	Card tryCard;
	@Before
	public void setUp()  throws Exception {	
		firstTry = new DeckImpl();
		secondTry = new DeckImpl();
		
	}
	
	
	/**Because of the randomness of the Deck shuffling I am not able to know which card is not top.
	 * So I will set up to Decks and assume that the card on top of them is different
	 * There is 1/52 for each test that the card is randomly the same and therefore the test will fail.
	 */
	
	
	@Test
	public void testGetDeck() {
		assertNotSame(firstTry.getDeck().pop(), secondTry.getDeck().pop());
	
	}
	
	@Test
	public void testDealCard() {
		assertNotSame(firstTry.dealCard(), secondTry.dealCard());
	
	}
	
	//This test should "never" fail, because the chances of dealing the same 5 cards are insane.
	@Test
	public void testDealHand() {
		assertNotSame(firstTry.dealHand(), secondTry.dealHand());
	
	}
	
	
	
	
	



	

}

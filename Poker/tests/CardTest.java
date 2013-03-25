/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.CardImpl;
import poker.Rank;
import poker.Suit;


public class CardTest {

	Card card;
	
	@Before
	public void setUp()  throws Exception {	
		card = new CardImpl(Rank.TWO,Suit.DIAMONDS);
		
	}
	
	@Test
	public void testRank() {
		String expectedResult = "2";
		assertEquals(expectedResult , card.getRank().getRankValue());
	}
	
	@Test
	public void testSuit() {
		String expectedResult = "DIAMONDS";
		assertEquals(expectedResult , card.getSuit().name());
	}

}

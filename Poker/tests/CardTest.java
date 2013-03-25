/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.CardImpl;
import poker.DeckImpl;


public class CardTest {

	Card card;
	
	@Before
	public void setUp()  throws Exception {	
		card = new CardImpl();
		
		
	}
	
	
	@Test
	//Testing that when dealing two decks the card on top of the decks is not the same
	//There is 1/52 that this test fails
	public void testCard() {
		assertNotSame(firstTry.getDeck().pop(), secondTry.getDeck().pop());
		
		
	}

}

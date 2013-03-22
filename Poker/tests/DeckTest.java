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
	
	
	@Test
	public void testSuit() {
		assertEquals(firstTry.getDeck().pop().getSuit().name(), secondTry.getDeck().pop().getSuit().name());	
	}
	
	@Test
	public void testRank() {
		assertEquals(firstTry.getDeck().peek().getRank().name(), secondTry.getDeck().peek().getRank().name());
	}



	

}

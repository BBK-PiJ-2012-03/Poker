package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Comparator;
import poker.ComparatorImpl;
import poker.Deck;
import poker.DeckImpl;
import poker.Hand;
import poker.HandImpl;

public class ComparatorTest {

	Comparator comparator;
	Hand hand1;
	Hand hand2;
	Deck deck;
	
	
	@Before
	public void setUp()  throws Exception {	
		
		deck = new DeckImpl();
		
		hand1 = new HandImpl(deck.dealHand());
		hand2 = new HandImpl(deck.dealHand());
		
		comparator = new ComparatorImpl();
		
		
		
		
		
	}
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

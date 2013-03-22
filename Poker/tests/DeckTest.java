package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Deck;
import poker.DeckImpl;

public class DeckTest {

	Deck firstTry;
	@Before
	public void setUp()  throws Exception {	
		firstTry = new DeckImpl();
		Card
	}
	
	
	
	@Test
	public void test() {
		AssertEquals(firstTry.getDeck().peek(),"whatever");
	}

}

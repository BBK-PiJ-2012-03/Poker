package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.CardImpl;
import poker.DealerAI;
import poker.Hand;
import poker.HandImpl;
import poker.Rank;
import poker.Suit;

public class DealerAITest {

	Hand hand;
	Card[] cards;
	
	
	@Before
	public void setUp()  throws Exception {	
		
		//Creating an arrays of cards
		cards = new Card[5];
	
	}
	
	
	@Test
	public void testDealerAI() {
		
		//This hand will have Three_Of_A_Kind
		cards[0] = new CardImpl(Rank.TWO,Suit.DIAMONDS);
		cards[1] = new CardImpl(Rank.THREE,Suit.CLUBS);
		cards[2] = new CardImpl(Rank.FOUR,Suit.HEARTS);
		cards[3] = new CardImpl(Rank.FOUR,Suit.SPADES);
		cards[4] = new CardImpl(Rank.FOUR,Suit.DIAMONDS);
		hand = new HandImpl(cards);
		
		int expectedResult = 1;
		assertEquals(expectedResult, DealerAI.cardsToChange(hand));
	}

}

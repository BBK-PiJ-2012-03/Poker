package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;
import poker.CardImpl;
import poker.Category;
import poker.Hand;
import poker.HandImpl;
import poker.Rank;
import poker.Suit;

public class HandImplTest {

	@Test
	public void testStraightFlush() {
		Hand hand;
		Card[] card = new Card[5];
		card[0] = new CardImpl(Rank.TWO,Suit.DIAMONDS);
		card[1] = new CardImpl(Rank.THREE,Suit.DIAMONDS);
		card[2] = new CardImpl(Rank.FOUR,Suit.DIAMONDS);
		card[3] = new CardImpl(Rank.FIVE,Suit.DIAMONDS);
		card[4] = new CardImpl(Rank.SIX,Suit.DIAMONDS);
		hand = new HandImpl(card);	
		for(int i=0;i<5;i++){
			System.out.println(hand.getHand()[i].getRank());
		}
		assertEquals(Category.Straight_Flush,hand.getCategory());
		
	}

}

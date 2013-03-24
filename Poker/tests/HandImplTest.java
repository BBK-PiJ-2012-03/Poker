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
		assertEquals(Category.Straight_Flush,hand.getCategory());
		
	}

	@Test
	public void testFourOfAKind() {
		Hand hand;	
		Card[] card = new Card[5];
		card[0] = new CardImpl(Rank.TWO,Suit.DIAMONDS);
		card[1] = new CardImpl(Rank.TWO,Suit.CLUBS);
		card[2] = new CardImpl(Rank.TWO,Suit.HEARTS);
		card[3] = new CardImpl(Rank.TWO,Suit.SPADES);
		card[4] = new CardImpl(Rank.SIX,Suit.DIAMONDS);
		hand = new HandImpl(card);
		assertEquals(Category.Four_Of_A_Kind,hand.getCategory());		
	}
	
	@Test
	public void testFullHouse() {
		Hand hand;	
		Card[] card = new Card[5];
		card[0] = new CardImpl(Rank.TWO,Suit.DIAMONDS);
		card[1] = new CardImpl(Rank.TWO,Suit.CLUBS);
		card[2] = new CardImpl(Rank.TWO,Suit.HEARTS);
		card[3] = new CardImpl(Rank.THREE,Suit.SPADES);
		card[4] = new CardImpl(Rank.THREE,Suit.DIAMONDS);
		hand = new HandImpl(card);
		assertEquals(Category.Full_House,hand.getCategory());		
	}
	
	@Test
	public void testFlush() {
		Hand hand;	
		Card[] card = new Card[5];
		card[0] = new CardImpl(Rank.TWO,Suit.DIAMONDS);
		card[1] = new CardImpl(Rank.FOUR,Suit.DIAMONDS);
		card[2] = new CardImpl(Rank.SIX,Suit.DIAMONDS);
		card[3] = new CardImpl(Rank.THREE,Suit.DIAMONDS);
		card[4] = new CardImpl(Rank.ACE,Suit.DIAMONDS);
		hand = new HandImpl(card);
		assertEquals(Category.Flush,hand.getCategory());		
	}
	
	@Test
	public void testStraight(){
		Hand hand;	
		Card[] card = new Card[5];
		card[0] = new CardImpl(Rank.KING,Suit.DIAMONDS);
		card[1] = new CardImpl(Rank.NINE,Suit.CLUBS);
		card[2] = new CardImpl(Rank.QUEEN,Suit.DIAMONDS);
		card[3] = new CardImpl(Rank.TEN,Suit.DIAMONDS);
		card[4] = new CardImpl(Rank.JACK,Suit.DIAMONDS);
		hand = new HandImpl(card);
		assertEquals(Category.Straight,hand.getCategory());		
	}
	
	@Test
	public void testThreeKind1() {
		Hand hand;	
		Card[] card = new Card[5];
		card[0] = new CardImpl(Rank.TWO,Suit.DIAMONDS);
		card[1] = new CardImpl(Rank.THREE,Suit.CLUBS);
		card[2] = new CardImpl(Rank.FOUR,Suit.HEARTS);
		card[3] = new CardImpl(Rank.FOUR,Suit.SPADES);
		card[4] = new CardImpl(Rank.FOUR,Suit.DIAMONDS);
		hand = new HandImpl(card);
		assertEquals(Category.Three_Of_A_Kind,hand.getCategory());		
	}
	
	@Test
	public void testTwoPairs() {
		Hand hand;	
		Card[] card = new Card[5];
		card[0] = new CardImpl(Rank.TWO,Suit.DIAMONDS);
		card[1] = new CardImpl(Rank.TWO,Suit.CLUBS);
		card[2] = new CardImpl(Rank.THREE,Suit.HEARTS);
		card[3] = new CardImpl(Rank.THREE,Suit.SPADES);
		card[4] = new CardImpl(Rank.FOUR,Suit.DIAMONDS);
		hand = new HandImpl(card);
		for(int i=0;i<5;i++){
			System.out.println(hand.getHand()[i].getRank());
		}
		assertEquals(Category.Two_Pairs,hand.getCategory());		
	}
	
	


}

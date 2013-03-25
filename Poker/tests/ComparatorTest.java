package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.CardImpl;
import poker.Comparator;

import poker.Hand;
import poker.HandImpl;
import poker.Rank;
import poker.Suit;

//Class testing Comparator
public class ComparatorTest {

	Hand hand1;
	Hand hand2;
	Card[] cards1;
	Card[] cards2;
	
	@Before
	public void setUp()  throws Exception {	
		
		//Creating two arrays of cards
		cards1 = new Card[5];
		cards2 = new Card[5];	
	}
	
	
	@Test
	public void testDifferentCategoryHands() {
		
		//This hand will have Three_Of_A_Kind
		cards1[0] = new CardImpl(Rank.TWO,Suit.DIAMONDS);
		cards1[1] = new CardImpl(Rank.THREE,Suit.CLUBS);
		cards1[2] = new CardImpl(Rank.FOUR,Suit.HEARTS);
		cards1[3] = new CardImpl(Rank.FOUR,Suit.SPADES);
		cards1[4] = new CardImpl(Rank.FOUR,Suit.DIAMONDS);
		hand1 = new HandImpl(cards1);
		
		//This hand will have Two_Pairs
		cards2[0] = new CardImpl(Rank.TWO,Suit.DIAMONDS);
		cards2[1] = new CardImpl(Rank.TWO,Suit.CLUBS);
		cards2[2] = new CardImpl(Rank.THREE,Suit.HEARTS);
		cards2[3] = new CardImpl(Rank.THREE,Suit.SPADES);
		cards2[4] = new CardImpl(Rank.FOUR,Suit.DIAMONDS);
		hand2 = new HandImpl(cards2);
		
		int expectedResult = 1;
		assertEquals(expectedResult, Comparator.calculateWinner(hand1, hand2));
	}
	
	@Test
	public void testSameCategoryHands() {

		//This hand will have Two_Pairs with High Card JACK
		cards1[0] = new CardImpl(Rank.JACK,Suit.DIAMONDS);
		cards1[1] = new CardImpl(Rank.THREE,Suit.CLUBS);
		cards1[2] = new CardImpl(Rank.FOUR,Suit.HEARTS);
		cards1[3] = new CardImpl(Rank.FOUR,Suit.SPADES);
		cards1[4] = new CardImpl(Rank.THREE,Suit.DIAMONDS);
		hand1 = new HandImpl(cards1);

		//This hand will have the same Two_Pairs with High Card ACE
		cards2[0] = new CardImpl(Rank.ACE,Suit.DIAMONDS);
		cards2[1] = new CardImpl(Rank.FOUR,Suit.DIAMONDS);
		cards2[2] = new CardImpl(Rank.THREE,Suit.HEARTS);
		cards2[3] = new CardImpl(Rank.THREE,Suit.SPADES);
		cards2[4] = new CardImpl(Rank.FOUR,Suit.CLUBS);
		hand2 = new HandImpl(cards2);

		int expectedResult = 2;
		assertEquals(expectedResult, Comparator.calculateWinner(hand1, hand2));
	}
	
	@Test
	public void testHighCard() {

		//This hand will have High Card ACE and then JACK
		cards1[0] = new CardImpl(Rank.JACK,Suit.DIAMONDS);
		cards1[1] = new CardImpl(Rank.THREE,Suit.CLUBS);
		cards1[2] = new CardImpl(Rank.FIVE,Suit.HEARTS);
		cards1[3] = new CardImpl(Rank.ACE,Suit.SPADES);
		cards1[4] = new CardImpl(Rank.TEN,Suit.DIAMONDS);
		hand1 = new HandImpl(cards1);

		//This hand will have High Card ACE and then NINE
		cards2[0] = new CardImpl(Rank.ACE,Suit.DIAMONDS);
		cards2[1] = new CardImpl(Rank.NINE,Suit.DIAMONDS);
		cards2[2] = new CardImpl(Rank.TWO,Suit.HEARTS);
		cards2[3] = new CardImpl(Rank.THREE,Suit.SPADES);
		cards2[4] = new CardImpl(Rank.FOUR,Suit.CLUBS);
		hand2 = new HandImpl(cards2);

		int expectedResult = 1;
		assertEquals(expectedResult, Comparator.calculateWinner(hand1, hand2));
	}
	
	@Test
	public void testTie() {

		//This hand will have Two_Pairs with High Card JACK
		cards1[0] = new CardImpl(Rank.JACK,Suit.DIAMONDS);
		cards1[1] = new CardImpl(Rank.THREE,Suit.CLUBS);
		cards1[2] = new CardImpl(Rank.FOUR,Suit.HEARTS);
		cards1[3] = new CardImpl(Rank.FOUR,Suit.SPADES);
		cards1[4] = new CardImpl(Rank.THREE,Suit.DIAMONDS);
		hand1 = new HandImpl(cards1);

		//This hand will have the same Two_Pairs with High Card JACK
		cards2[0] = new CardImpl(Rank.JACK,Suit.CLUBS);
		cards2[1] = new CardImpl(Rank.FOUR,Suit.DIAMONDS);
		cards2[2] = new CardImpl(Rank.THREE,Suit.HEARTS);
		cards2[3] = new CardImpl(Rank.THREE,Suit.SPADES);
		cards2[4] = new CardImpl(Rank.FOUR,Suit.CLUBS);
		hand2 = new HandImpl(cards2);

		int expectedResult = 0;
		assertEquals(expectedResult, Comparator.calculateWinner(hand1, hand2));
	}
	

}

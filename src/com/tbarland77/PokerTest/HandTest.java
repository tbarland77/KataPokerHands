package com.tbarland77.PokerTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.tbarland77.Poker.Card;
import com.tbarland77.Poker.CardValue;
import com.tbarland77.Poker.Hand;
import com.tbarland77.Poker.Suit;

public class HandTest {

	private Hand testHand;
	
	@Before
	public void Test() {
		//
		testHand = new Hand();
	}
	
	public static void ProvideSortedHand(Hand hand)
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		
		Card card = new Card();
		card.setSuit(Suit.DIAMONDS);
		card.setValue(CardValue.TEN);
		for (int i = 0; i < 5; i++) 
		{
			cards.add(card);
			
			if (i == 0) 
			{
				card = new Card();
				card.setSuit(Suit.HEARTS);
				card.setValue(CardValue.TWO);
			} else if (i == 1)
			{
				card = new Card();
				card.setSuit(Suit.CLUBS);
				card.setValue(CardValue.FOUR);
			} else if (i == 2)
			{
				card = new Card();
				card.setSuit(Suit.CLUBS);
				card.setValue(CardValue.THREE);
			} else if (i == 3)
			{
				card = new Card();
				card.setSuit(Suit.CLUBS);
				card.setValue(CardValue.ACE);
			} 
		}
		
		hand.sortCards(cards);
		hand.setPokerHand(cards.toArray(new Card[cards.size()]));
	}
	
	public static void ProvideHighCard(Hand hand)
	{
		Card card = new Card();
		card.setSuit(Suit.DIAMONDS);
		card.setValue(CardValue.TEN);
		Card cards [] = new Card [5];
		for (int i = 0; i < 5; i++) 
		{
			cards[i] = card;
			
			if (i == 0) 
			{
				card = new Card();
				card.setSuit(Suit.HEARTS);
				card.setValue(CardValue.TWO);
			} else if (i == 1)
			{
				card = new Card();
				card.setSuit(Suit.CLUBS);
				card.setValue(CardValue.FOUR);
			} else if (i == 2)
			{
				card = new Card();
				card.setSuit(Suit.CLUBS);
				card.setValue(CardValue.NINE);
			} else if (i == 3)
			{
				card = new Card();
				card.setSuit(Suit.CLUBS);
				card.setValue(CardValue.ACE);
			} 
		}
		hand.setPokerHand(cards);
	}
	
	public static void ProvidePair(Hand hand)
	{
		Card card = new Card();
		card.setSuit(Suit.DIAMONDS);
		card.setValue(CardValue.ACE);
		Card cards [] = new Card [5];
		for (int i = 0; i < 5; i++) 
		{
			cards[i] = card;
			
			if (i == 1) 
			{
				card = new Card();
				card.setSuit(Suit.HEARTS);
				card.setValue(CardValue.QUEEN);
			} else if (i == 2)
			{
				card = new Card();
				card.setSuit(Suit.CLUBS);
				card.setValue(CardValue.TWO);
			} else if (i == 3)
			{
				card = new Card();
				card.setSuit(Suit.CLUBS);
				card.setValue(CardValue.THREE);
			} 
		}
		hand.setPokerHand(cards);
	}
	
	public static void ProvideTwoPair(Hand hand)
	{
		Card card = new Card();
		card.setSuit(Suit.DIAMONDS);
		card.setValue(CardValue.ACE);
		Card cards [] = new Card [5];
		for (int i = 0; i < 5; i++) 
		{
			cards[i] = card;
			if (i > 1 && i < 4) 
			{
				card = new Card();
				card.setSuit(Suit.HEARTS);
				card.setValue(CardValue.QUEEN);
			} 
		}
		hand.setPokerHand(cards);
	}
	
	public static void ProvideThreeOfAKind(Hand hand)
	{
		Card card = new Card();
		card.setSuit(Suit.DIAMONDS);
		card.setValue(CardValue.ACE);
		Card cards [] = new Card [5];
		for (int i = 0; i < 5; i++) 
		{
			cards[i] = card;
			if (i >= 2) 
			{
				card = new Card();
				card.setSuit(Suit.HEARTS);
				card.setValue(CardValue.QUEEN);
			} 
		}
		hand.setPokerHand(cards);
	}
	
	public static void ProvideStraight(Hand hand)
	{
		Card card = new Card();
		card.setSuit(Suit.DIAMONDS);
		card.setValue(CardValue.TEN);
		Card cards [] = new Card [5];
		for (int i = 0; i < 5; i++) 
		{
			cards[i] = card;
			
			if (i == 0) 
			{
				card = new Card();
				card.setSuit(Suit.HEARTS);
				card.setValue(CardValue.JACK);
			} else if (i == 1)
			{
				card = new Card();
				card.setSuit(Suit.CLUBS);
				card.setValue(CardValue.QUEEN);
			} else if (i == 2)
			{
				card = new Card();
				card.setSuit(Suit.CLUBS);
				card.setValue(CardValue.KING);
			} else if (i == 3)
			{
				card = new Card();
				card.setSuit(Suit.CLUBS);
				card.setValue(CardValue.ACE);
			} 
		}
		hand.setPokerHand(cards);
	}
	
	public static void ProvideFlush(Hand hand)
	{
		Card card = new Card();
		card.setSuit(Suit.DIAMONDS);
		card.setValue(CardValue.ACE);
		Card cards [] = new Card [5];
		for (int i = 0; i < 5; i++) 
		{
			cards[i] = card;
		}
		hand.setPokerHand(cards);
	}
	
	public static void ProvideFullHouse(Hand hand)
	{
		Card card = new Card();
		card.setSuit(Suit.DIAMONDS);
		card.setValue(CardValue.ACE);
		Card cards [] = new Card [5];
		for (int i = 0; i < 5; i++) 
		{
			cards[i] = card;
			if (i >= 2) 
			{
				card = new Card();
				card.setSuit(Suit.HEARTS);
				card.setValue(CardValue.QUEEN);
			} 
		}
		hand.setPokerHand(cards);
	}
	
	public static void ProvideFourOfAKind(Hand hand)
	{
		Card card = new Card();
		card.setSuit(Suit.DIAMONDS);
		card.setValue(CardValue.ACE);
		Card cards [] = new Card [5];
		for (int i = 0; i < 5; i++) 
		{
			cards[i] = card;
			if (i >= 3) 
			{
				card = new Card();
				card.setSuit(Suit.HEARTS);
				card.setValue(CardValue.QUEEN);
			} 
		}
		hand.setPokerHand(cards);
	}
	
	public static void ProvideStraightFlush(Hand hand)
	{
		Card card = new Card();
		card.setSuit(Suit.DIAMONDS);
		card.setValue(CardValue.TEN);
		Card cards [] = new Card [5];
		for (int i = 0; i < 5; i++) 
		{
			cards[i] = card;
			
			if (i == 0) 
			{
				card = new Card();
				card.setSuit(Suit.DIAMONDS);
				card.setValue(CardValue.JACK);
			} else if (i == 1)
			{
				card = new Card();
				card.setSuit(Suit.DIAMONDS);
				card.setValue(CardValue.QUEEN);
			} else if (i == 2)
			{
				card = new Card();
				card.setSuit(Suit.DIAMONDS);
				card.setValue(CardValue.KING);
			} else if (i == 3)
			{
				card = new Card();
				card.setSuit(Suit.DIAMONDS);
				card.setValue(CardValue.ACE);
			} 
		}
		hand.setPokerHand(cards);
	}
	
	@Test
	public void PlayerIsInitializedWithNoRank()
	{
		Hand initialHand = new Hand();
        assertEquals(initialHand.getRank(), testHand.getRank());
    }
	
	@Test
	public void HandContainsSortedCards()
	{
		ProvideSortedHand(testHand);
		Card [] sortedHand = testHand.getPokerHand();
		for (int i=0; i<4; i++)
		{
			assertEquals(true, sortedHand[i].getValue().getIntValue() <  sortedHand[i+1].getValue().getIntValue());
		}
	}
	
	@Test
	public void HandOnlyContainsHighCard()
	{
		ProvideHighCard(testHand);
		assertEquals(false, testHand.HasAPair(testHand.getPokerHand()));
		assertEquals(false, testHand.HasTwoPair(testHand.getPokerHand()));
		assertEquals(false, testHand.HasThreeOfAKind(testHand.getPokerHand()));
		assertEquals(false, testHand.HasStraight(testHand.getPokerHand()));
		assertEquals(false, testHand.HasFlush(testHand.getPokerHand()));
		assertEquals(false, testHand.HasFourOfAKind(testHand.getPokerHand()));
	}
	
	@Test
	public void HandContainsAPair()
	{
		ProvidePair(testHand);
		assertEquals(true, testHand.HasAPair(testHand.getPokerHand()));
	}
	
	
	@Test
	public void HandContainsATwoPair()
	{
		ProvideTwoPair(testHand);
		assertEquals(true, testHand.HasTwoPair(testHand.getPokerHand()));
	}
	
	@Test
	public void HandContainsThreeOfAKind()
	{
		ProvideThreeOfAKind(testHand);
		assertEquals(true, testHand.HasThreeOfAKind(testHand.getPokerHand()));
	}
	
	@Test
	public void HandContainsAStraight()
	{
		ProvideStraight(testHand);
		assertEquals(true, testHand.HasStraight(testHand.getPokerHand()));
	}
	
	@Test
	public void HandContainsAFlush()
	{
		ProvideFlush(testHand);
		assertEquals(true, testHand.HasFlush(testHand.getPokerHand()));
	}
	
	@Test
	public void HandContainsFullHouse()
	{
		ProvideFullHouse(testHand);
		assertEquals(true, testHand.HasThreeOfAKind(testHand.getPokerHand()));
		assertEquals(true, testHand.HasAPair(testHand.getPokerHand()));
	}
	
	@Test
	public void HandContainsFourOfAKind()
	{
		ProvideFourOfAKind(testHand);
		assertEquals(true, testHand.HasThreeOfAKind(testHand.getPokerHand()));
	}
	
	@Test
	public void HandContainsStraightFlush()
	{
		ProvideStraightFlush(testHand);
		assertEquals(true, testHand.HasStraight(testHand.getPokerHand()));
		assertEquals(true, testHand.HasFlush(testHand.getPokerHand()));
	}
	
}

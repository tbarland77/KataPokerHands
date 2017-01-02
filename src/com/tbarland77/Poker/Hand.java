package com.tbarland77.Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand {
	
	private Card [] pokerHand;
	private int Rank; 
	private Card winningCard;
	
	public Hand()
	{
		this.pokerHand = new Card [5];
		this.Rank = 0;
		this.winningCard = new Card();
	}
	
	public Card[] getPokerHand() {
		return pokerHand;
	}

	public void setPokerHand(Card[] pokerHand) {
		this.pokerHand = pokerHand;
	}

	public Hand(ArrayList<Card> playerHand)
	{
		pokerHand = playerHand.toArray(new Card[playerHand.size()]);
				
	}
	
	//sort each card in the players hand by the cards value
	public  ArrayList<Card> sortCards(ArrayList<Card> playerHand)
	{
		
		Collections.sort(playerHand, new Comparator<Card>() {

			@Override
			public int compare(Card c1, Card c2) {
				return c1.getValue().compareTo(c2.getValue());
			}
	    });
		return playerHand;
	}
	
	public void SetHighCard(Card [] cards)
	{
		winningCard = cards[cards.length-1];
	}
	
	public boolean HasFlush(Card [] cards)
	{
		for(int i = 0; i < cards.length - 1; i++)
        {
            Card card = cards[i];
            Card nextCard = cards[i + 1];
            if (card.getSuit() != nextCard.getSuit())
            	{
            	return false;
            	}
        }
		winningCard = cards[cards.length-1];
		this.Rank = 6;
        return true;
	}
	
	public boolean HasStraight(Card [] cards)
    {
		int id = 0;
		int cardValue = 0;
        for (int i = 0; i < cards.length - 1; i++)
        {
            Card card = cards[i];
            Card nextCard = cards[i + 1];
            //gets the integer value of the card and adds 1
            cardValue = card.getValue().getIntValue();
            id = cardValue + 1;
            if (id != nextCard.getValue().getIntValue())
            {
                return false;
            }
        }
        winningCard = cards[cards.length-1];
        this.Rank = 5;
        return true;
    }
	
	public boolean HasStraightFlush(Card [] cards)
    {
		if ((HasFlush(cards) && HasStraight(cards)))
		{
			winningCard = cards[cards.length-1];
			this.Rank = 9;
			return true;
		}
		return false;
       
    }
	
    public boolean HasFourOfAKind(Card [] cards)
    {
    	int [] values = new int [5];
    	int counter = 0;
    	for(int i =0; i<cards.length; i++){
            Card card = cards[i];
            values[i] = card.getValue().getIntValue(); 
        }
    	
        for (int i = 0; i < cards.length; i++)
        {
        	for(int j =i+1; j<cards.length; j++){
        		if(values[i] == values[j]){
                    counter++; 
                    if (counter >= 3)
                    {
                    	winningCard = cards[i];
                    	this.Rank = 8;
						return true;
                    }
                }
                if(j == cards.length-1 && counter!=3)
                	{ 
					counter = 0; //start again
					}
        	}
	   }
		return false;
    }
    

    public boolean HasThreeOfAKind(Card [] cards)
    {
    	int [] value = new int [5];
    	int counter = 0;
    	for(int i =0; i<cards.length; i++){
            Card card = cards[i];
            value[i] = card.getValue().getIntValue(); 
        }
    	
        for (int i = 0; i < cards.length; i++)
        {
        	for(int j =i+1; j<cards.length; j++){
        		if(value[i] == value[j]){
                    counter++; 
                    if (counter >= 2)
                    {
                        winningCard = cards[i];
                        this.Rank = 4;
    					return true;
                    }
                }
                if(j == cards.length-1 && counter!=2)
                	{ 
					counter = 0; //start again
					}
        	}
	   }
		return false;
    }
    
	 public boolean HasAPair(Card [] cards)
     {
		 int [] value = new int [5];
	    	int counter = 0;
	    	for(int i =0; i<cards.length; i++){
	            Card card = cards[i];
	            value[i] = card.getValue().getIntValue(); 
	        }
	    	
	        for (int i = 0; i < cards.length; i++)
	        {
	        	for(int j =i+1; j<cards.length; j++){
	        		if(value[i] == value[j]){
	                    counter++; 
	                }
	        		if (counter == 2)
                    {

    					return false;
                    } else if (j == cards.length-1 && counter!=1)
	                	{ 
						counter = 0; //start again
						} else if (j == cards.length-1 && counter == 1)
	                    {
	                        winningCard = cards[i];
	                        this.Rank = 2;
	    					return true;
	                    }
	        	}
		   }
			return false;

     }
	 
	 public boolean HasTwoPair(Card [] cards)
     {
       
		 int [] value = new int [5];
	    	int counter = 0;
	    	for(int i =0; i<cards.length; i++){
	            Card card = cards[i];
	            value[i] = card.getValue().getIntValue(); 
	        }
	    	
	        for (int i = 0; i < cards.length; i++)
	        {
	        	for(int j =i+1; j<cards.length; j++){
	        		if(value[i] == value[j]){
	                    counter++; 
	                }
	        	}
		   }
	    	//if the array has been looped through and at least two pairs are found
			if(counter == 2){
				winningCard = cards[cards.length-1];
				this.Rank = 3;
				return true;
			} else
			{
				return false;
			}
     }
	
	   public boolean HasFullHouse(Card [] cards)
       {
		   if ((HasAPair(cards) && HasThreeOfAKind(cards)))
		   {
			   this.Rank = 7;
			   return true;
		   }
		   return false;
       }
	
	public Card getWinningCard() {
		return winningCard;
	}

	public void setWinningCard(Card winningCard) {
		this.winningCard = winningCard;
	}

	public int getRank() {
		return Rank;
	}

	public void setRank(int rank) {
		Rank = rank;
	}

}

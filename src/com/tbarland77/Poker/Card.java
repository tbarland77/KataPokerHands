package com.tbarland77.Poker;

public class Card  {
	
	private Suit suit;
	private CardValue Value;
	
	public Card()
	{
		this.suit = null;
		this.Value = null;
	}
	
	public Card(Suit cardSuit, CardValue value)
	{
		this.suit = cardSuit;
		this.Value = value;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public Suit getSuit(char denoteSuit) {
		suit = Suit.getSuitByDenoteSuit(denoteSuit);
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	public CardValue getValue() {
		return Value;
	}
	public CardValue getValue(int id) {
		Value = CardValue.getCardValueById(id);
		return Value;
	}
	public void setValue(CardValue value) {
		Value = value;
	}
	
	
}

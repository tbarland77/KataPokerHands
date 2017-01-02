package com.tbarland77.Poker;

public enum Suit {
 CLUBS('C'),DIAMONDS('D'),HEARTS('H'),SPADES('S');
 
 private char denoteSuit;
 
 private Suit(char denoteSuit)
 {
	 this.denoteSuit = denoteSuit;
 }
 
 public char getDenoteSuit() {
     return denoteSuit;
 }
 // Gets the suit based on the passed in denoted suit
 public static Suit getSuitByDenoteSuit(char denotedSuit) {
	
	 Suit cSuit = null;
	 
	 switch (denotedSuit) {
     case 'C':
    	 cSuit = CLUBS;
         break;
     case 'D':
    	 cSuit = DIAMONDS;
         break;
     case 'H':
    	 cSuit = HEARTS; 
         break;
     case 'S':
    	 cSuit = SPADES;
         break;
         
     default:
         break;
	 }
	 return cSuit;
	 
 }
}



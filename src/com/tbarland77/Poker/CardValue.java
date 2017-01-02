package com.tbarland77.Poker;

public enum CardValue {
TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),JACK(11),QUEEN(12),KING(13),ACE(14);
	
	private int intValue;
	
	private CardValue(int value)
	{
		this.intValue = value;
	}
	
	 public int getIntValue() {
	        return intValue;
	    }
	 // Determines the card value based on the id that gets passed in
	 public static CardValue getCardValueById(int id) {

	        CardValue cValue = null;

	        switch (id) {
	        case 2:
	        	cValue = TWO;
	            break;
	        case 3:
	        	cValue = THREE;
	            break;
	        case 4:
	        	cValue = FOUR; 
	            break;
	        case 5:
	        	cValue = FIVE;
	            break;
	        case 6:
	        	cValue = SIX;
	            break;
	        case 7:
	        	cValue = SEVEN;
	            break;
	        case 8:
	        	cValue = EIGHT;
	            break;
	        case 9:
	        	cValue = NINE;
	            break;
	        case 10:
	        	cValue = TEN;
	            break;    
	        case 11:
	        	cValue = JACK;
	            break;
	        case 12:
	        	cValue = QUEEN;
	            break;
	        case 13:
	        	cValue = KING;
	            break;
	        case 14:
	        	cValue = ACE;
	            break;

	        default:
	            break;
	        }
	        return cValue;
	    }
}

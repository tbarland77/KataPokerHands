package com.tbarland77.Poker;

public enum HandRanking {
HIGHCARD(1),PAIR(2),TWOPAIRS(3),THREEOFAKIND(4),STRAIGHT(5),FLUSH(6),FULLHOUSE(7),FOUROFAKIND(8),STRAIGHTFLUSH(9);
	
	private int ranking;
	
	private HandRanking(int ranking)
	 {
		 this.ranking = ranking;
	 }
	 
	 public int getRanking() {
	     return ranking;
	 }
	 
	 public static HandRanking getHandRankingById(int id) {

		  HandRanking handValue = null;

	        switch (id) {
	        case 1:
	        	handValue = HIGHCARD;
	            break;
	        case 2:
	        	handValue = PAIR;
	            break;
	        case 3:
	        	handValue = TWOPAIRS; 
	            break;
	        case 4:
	        	handValue = THREEOFAKIND;
	            break;
	        case 5:
	        	handValue = STRAIGHT;
	            break;
	        case 6:
	        	handValue = FLUSH;
	            break;
	        case 7:
	        	handValue = FULLHOUSE;
	            break;
	        case 8:
	        	handValue = FOUROFAKIND;
	            break;
	        case 9:
	        	handValue = STRAIGHTFLUSH;
	            break;    
	        default:
	            break;
	        }
	        return handValue;
	    }

}

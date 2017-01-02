package com.tbarland77.Poker;

public class Player {

	private String Name;
	private Hand playerHand;
	
	
	public Player()
	{
		this.Name = null;
		this.playerHand = new Hand();
	}
	
	public Player(String name, Hand hand, String winningcard)
	{
		this.Name = name;
		this.playerHand = hand;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Hand getPlayerHand() {
		return playerHand;
	}
	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}
	
	public String playerRank(Player player)
	{
		if (player.playerHand.getRank() == 2) return HandRanking.getHandRankingById(2).toString();
		if (player.playerHand.getRank() == 3) return HandRanking.getHandRankingById(3).toString();
		if (player.playerHand.getRank() == 4) return HandRanking.getHandRankingById(4).toString();
		if (player.playerHand.getRank() == 5) return HandRanking.getHandRankingById(5).toString();
		if (player.playerHand.getRank() == 6) return HandRanking.getHandRankingById(6).toString();
		if (player.playerHand.getRank() == 7) return HandRanking.getHandRankingById(7).toString();
		if (player.playerHand.getRank() == 8) return HandRanking.getHandRankingById(8).toString();
		if (player.playerHand.getRank() == 9) return HandRanking.getHandRankingById(9).toString();
		else return HandRanking.getHandRankingById(1).toString();
		
	}

}

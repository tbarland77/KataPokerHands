package com.tbarland77.Poker;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean quit = false;
		String currentPlayer = "";
		Player player1 = new Player();
		Player player2 = new Player();
		Scanner scanner = new Scanner( System.in );
		Hand player1Hand = new Hand();
		Hand player2Hand = new Hand();

		System.out.print("Enter a name for player 1:");
		String userInput = scanner.nextLine();
		player1.setName(userInput);
		
		System.out.print("Enter a name for player 2:");
		userInput = scanner.nextLine();
		player2.setName(userInput);
		while (quit == false) 
		{
			currentPlayer = "";
			ArrayList<Card> player1Cards = new ArrayList<Card>();
			ArrayList<Card> player2Cards = new ArrayList<Card>();
			
			currentPlayer = getCurrentPlayer(currentPlayer);
			player1Cards = dealPlayerHand(currentPlayer, scanner);
			currentPlayer = getCurrentPlayer(currentPlayer);
			player2Cards = dealPlayerHand(currentPlayer, scanner);
	
			//sorts each players hand by lowest to highest value
			player1Hand.sortCards(player1Cards);
			player2Hand.sortCards(player2Cards);
			
			player1Hand.setPokerHand(player1Cards.toArray(new Card[player1Cards.size()]));
			player2Hand.setPokerHand(player2Cards.toArray(new Card[player2Cards.size()]));
			
			evalHand(player1Hand);
			evalHand(player2Hand);
			
			player1.setPlayerHand(player1Hand);
			player2.setPlayerHand(player2Hand);
			
			System.out.println(CompareHandRanks(player1, player2));
			quit = PlayAgain(scanner);
		}
		
	}
	
	public static String getCurrentPlayer(String player)
	{
		if (player == "")
		{
			player = "Player 1";
		} else
		{
			player = "Player 2";
		}
		
		return player;
	}
	
	public static boolean isValidCard(Card card){
		int cardLength = 0; 
		try
		{
			 cardLength = String.valueOf(card.getSuit().getDenoteSuit()).length() + String.valueOf(card.getValue().getIntValue()).length();
		
			 if ("HSDC".indexOf(card.getSuit().getDenoteSuit()) != -1 && "234567891011121314".indexOf(Integer.toString(card.getValue().getIntValue())) != -1
					&& cardLength == 3 || cardLength == 2)
			 {
				 return true;
			 }
		} catch (Exception e)
		{
			System.out.println("You entered an invalid card! Please enter only valid cards such as s14 or c2");
			return false;
		}
		return false;
	}
	
	public static ArrayList<Card> dealPlayerHand(String player, Scanner scanner)
	{
		String Input = "";
		char suit = 'z';
		boolean isValid = true;
		ArrayList<Card> Hand = new ArrayList<Card>();
		while (Hand.size() < 5)
		{
			Card card = new Card();
			// gets the players cards and adds them to a dictionary of cards
			System.out.print("Enter a card for " + player + " (Example: d14 -> Ace of Diamonds):");
			Input = scanner.nextLine();
			Input = Input.toUpperCase();
			if (Input.length() > 1)
			{
				suit = Input.charAt(0);
				String [] cardValue = Input.split("([A-Z])");
				card.setSuit(card.getSuit(suit));
				if (cardValue.length > 1 && tryIntParse(cardValue[1]))
				{
					card.setValue(card.getValue(Integer.parseInt(cardValue[1])));
				} else
				{
					card.setValue(null);
				}
			}
			isValid = isValidCard(card);
			if (isValid == true)
			{
				Hand.add(card);
			}
		}
		return Hand;
	}
	
	public static boolean tryIntParse(String input)
	{
		try {  
	         Integer.parseInt(input);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  

	}
	// checks for ranks and sets the rank
	public static void evalHand(Hand playerHand)
	{
		if (playerHand.HasStraightFlush(playerHand.getPokerHand()) == true || playerHand.HasFourOfAKind(playerHand.getPokerHand())  == true || playerHand.HasFullHouse(playerHand.getPokerHand())  == true
				|| playerHand.HasFlush(playerHand.getPokerHand()) == true || playerHand.HasStraight(playerHand.getPokerHand())  == true || playerHand.HasThreeOfAKind(playerHand.getPokerHand())  == true 
				|| playerHand.HasTwoPair(playerHand.getPokerHand()) == true || playerHand.HasAPair(playerHand.getPokerHand()))
		{
			System.out.println("The rank is: " + HandRanking.getHandRankingById(playerHand.getRank()));
		} else
		{
			// sets rank to high card
			playerHand.setRank(1);
			playerHand.SetHighCard(playerHand.getPokerHand());
			System.out.println("The rank is: " + HandRanking.getHandRankingById(playerHand.getRank()));
		}
	}
	
	public static String CompareHandRanks(Player player1, Player player2)
	{
		if (player1.getPlayerHand().getRank() > player2.getPlayerHand().getRank())
		{
			return player1.getName() + " wins! - with " + player1.playerRank(player1);
		} else if (player2.getPlayerHand().getRank() > player1.getPlayerHand().getRank())
		{
			return player2.getName() + " wins! - with " + player2.playerRank(player2);
		} else if (player2.getPlayerHand().getRank() == player1.getPlayerHand().getRank())
		{
			
			if (player1.getPlayerHand().getWinningCard().getValue().getIntValue() > player2.getPlayerHand().getWinningCard().getValue().getIntValue())
			{
				return player1.getName() + " wins! - with: " + player1.getPlayerHand().getWinningCard().getValue();
			} else if (player1.getPlayerHand().getWinningCard().getValue().getIntValue() < player2.getPlayerHand().getWinningCard().getValue().getIntValue())
			{
				return player2.getName() + " wins! - with: " + player2.getPlayerHand().getWinningCard().getValue();
			} else if (player1.getPlayerHand().getRank() == 6 || player1.getPlayerHand().getRank() <= 3)
			{
				return HandleTie(player1, player2);
			} else
			{
				return "This match is a tie!";
			}
		}
		return "This match is a tie!";
	
	}
	
	public static String HandleTie(Player p1, Player p2)
	{
		Card [] p1Hand = p1.getPlayerHand().getPokerHand();
		Card [] p2Hand = p2.getPlayerHand().getPokerHand();
		// handles games that result in both players having high card or flush
		if (p1.getPlayerHand().getRank() == 1 || p1.getPlayerHand().getRank() == 6)
		{
			for (int i=4; i != -1; i--)
			{
				if (p1Hand[i].getValue().getIntValue() > p2Hand[i].getValue().getIntValue())
				{
					return p1.getName() + " wins! - with " + HandRanking.getHandRankingById(p1.getPlayerHand().getRank()) + ": " + p1Hand[i].getValue();
				} else if (p2Hand[i].getValue().getIntValue() > p1Hand[i].getValue().getIntValue())
				{
					return p2.getName() + " wins! - with " + HandRanking.getHandRankingById(p1.getPlayerHand().getRank()) +  ": "+ p2Hand[i].getValue();
				} 
			}
			// handles a tie when both players have the same pair(s)
		} else if (p1.getPlayerHand().getRank() == 2 || p1.getPlayerHand().getRank() == 3)
		{
			for (int i=4; i != -1; i--)
			{
				if (p1Hand[i].getValue().getIntValue() != p1.getPlayerHand().getWinningCard().getValue().getIntValue() && 
						p2Hand[i].getValue().getIntValue() != p2.getPlayerHand().getWinningCard().getValue().getIntValue())
				{
					if (p1Hand[i].getValue().getIntValue() > p2Hand[i].getValue().getIntValue())
					{
						return p1.getName() + " wins! - with card: " + p1Hand[i].getValue();
					} else if (p2Hand[i].getValue().getIntValue() > p1Hand[i].getValue().getIntValue())
					{
						return p2.getName() + " wins! - with card: " + p2Hand[i].getValue();
					} 
				}
			}
		}
		return "This match is a tie!";
	}
	
	public static boolean PlayAgain(Scanner scan)
	{
		System.out.print("Play again? (enter any key to keep playing): ");
		String userInput = scan.nextLine();
		if (userInput.length() >= 1)
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
}

/* Jessica Gary
 * jsg2213 
 * 
 * Game.java
 * 
 * Implements the BlackJack game by faciliating between the other 4 classes.
 * This class is the only access point from the main method, which is the BlackjackTester.java. 
 * 
 * Contains constructor, reset(), checkFunds(), and play() methods, and 4 private variables. 
 * 
 * */


import java.util.Scanner;
public class Game 
{
	private Deck deckOfCards; 
	private Dealer dealer; 
	private Player adam; 
	
	public Game()
	{
		deckOfCards = new Deck(); 
		dealer = new Dealer();
		adam = new Player(); 
		
		//get the FUNDS:
		adam.setFunds();
		dealer.setFunds(1000.00); 							//the standard bet for the computer is $1000.00. 
	}
	public void reset() 									//this is so that all the balances are kept updated, not deleted with creation of a new game. 
	{
		//reset the hands, so everyone starts off at 0 (not the balance) 
		adam.resetHand();
		dealer.resetHand();
	}
	public boolean checkFunds()
	{
		if (adam.getBalance() <= 0 || dealer.getBalance()<=0)
		{
			
			System.out.println("Opps! Somebody ran out of funds. Gotta restart this game again." );
			return false; 									 //return false if either party doesn't have enough money
		}
		return true; 										//return true if the balances checked out.
	}
	public void play()
	{
				
		boolean endgame = false; 							//controls whether the game goes on 
		boolean response = false;	
		
		
		//START GAME: 
		
		while (endgame == false) 
		{
			//Set bet for this hand 
			adam.setBet(); 
			
			//check if have enough cards in the Deck 
			if (deckOfCards.check() == true)				//if .check() returns true == the deck has less than 12 cards or has exactly 52 cards. in which cases, shuffle. 
			{
				deckOfCards.shuffle(); 
			}
			
			
			/*Give 2 cards to the player and 2 cards to the dealer == 4 CARDS DISTRIBUTED WHEN A HAND BEGINS 
			 * 		1) Call deckOfCards.draw(), which returns a card. 
			 * 		2) Add this card to the player/dealer's hand (array). */
			System.out.print("* YOUR STARTING HAND: ");
			
			//TO PLAYER'S HAND
			Card tempcard = deckOfCards.draw();
			adam.accept(tempcard);							//add the card to the hand array 
			tempcard.revealCard(); 							 //reveal card value to the player (but not the one that's added to dealer's hand. 
				
			//TO DEALER'S HAND
			tempcard = deckOfCards.draw();
			dealer.accept(tempcard); 						 //hole card. don't show. 
			
			//TO PLAYER'S HAND
			tempcard = deckOfCards.draw(); 
			tempcard.checkIfAce(adam.getValueHeld()); 		//check if it's an ace and whether it's beneficial
			adam.accept(tempcard);
			tempcard.revealCard(); 							//reveal card value to the player
			
			//TO DEALER'S HAND
			System.out.println();
			tempcard =  deckOfCards.draw();
			tempcard.checkIfAce(adam.getValueHeld()); 		//check if it's an ace and whether it's beneficial
			dealer.accept(tempcard);
			System.out.print("\n* DEALER'S HAND: The dealer has 2 cards but one of them has value ");
			tempcard.revealCard(); 							//reveal the dealer's topcard to the player 
			System.out.println();
					
			
			//PLAYER'S TURN FIRST 
			System.out.println("\nYou currently have "+ adam.getValueHeld()+ " in your hand.");
			System.out.println("Would you like to hit or stand? Enter 1 for (hit) and 0 for (stand).");
			Scanner in = new Scanner(System.in);
			int temp = in.nextInt();
			
			
			while (temp > 1 || temp < 0)					//check if we get the right input. 
			{
				System.out.println("Please either enter 1 to hit again. Or 0 to stand: "); 
				temp = in.nextInt(); 
			}
			
			//CONVERT THE USER'S RESPONSE TO BOOLEAN; 
			if (temp == 1)
				response = true; 
			else if (temp == 0)
				response = false; 
			
			
		
			/****THE PLAYER'S TURN****/
			while (response == true) 
			{
				//The player wants to hit again. 
				//draw another card from the deck 
				
				tempcard = deckOfCards.draw(); 
				tempcard.checkIfAce(adam.getValueHeld()); 	//Check if card drawn is an ace. 
				adam.accept(tempcard);
				
				System.out.print("The card you got has value ");
				tempcard.revealCard(); 						//reveal the card to the player. 
				System.out.println("\nYou currently have "+ adam.getValueHeld()+ " in your hand.");
				 
				if (adam.getValueHeld() < 21)
				{
					//if the valueheld is < 21, then have a choice to hit again. 
					System.out.println("Would you like to hit or stand? Enter 1 for (hit) and 0 for (stand).");
					temp = in.nextInt(); 
					
					while (temp > 1 || temp < 0)
					{
						System.out.println("Please either enter 1 to hit again. Or 0 to stand: "); 
						temp = in.nextInt(); 
					}
					
					if (temp == 1)
						response = true; 
					else if (temp == 0)
						response = false;
					
				}
				else if(adam.getValueHeld() == 21) 			//if you get a BlackJack 
				{
					response = false; 
					endgame = true; 
					System.out.println("You got 21. BlackJack! You won!!");
					adam.winBet(); 
					dealer.lostBet(adam.getBet()*1.5);
					System.out.println("You now have " + adam.getBalance());
					System.out.println("And the dealer has " + dealer.getBalance() + " left");
				}
				else //valueheld > 21 
				{
					response = false; 
					endgame = true;							//end of the game if the player has > 21. 
					System.out.println("You got " + adam.getValueHeld() + ", which is more than 21. So you lost!");
					adam.lostBet();
					dealer.winBet(adam.getBet()); 
					System.out.println("You now only have " + adam.getBalance() + " left.");
					System.out.println("And the dealer has " + dealer.getBalance());
				}
			}
			
			/****THE DEALER'S TURN****/
			while (response == false && endgame == false) 
			{
				//the player wants to stand, 
				//the dealer's turn 
				
				System.out.println("\nIt's the dealer's turn!!");  
				System.out.println("The dealer originally has "+ dealer.getValueHeld());
				
				while (dealer.getValueHeld() <= 21)
				{
					if(dealer.is17() == false) 				//if the valueheld by the dealer is less than 17, run this loop. if it is already >= 17, then don't run this loop. 
					{
						//This loop is only run when the valueheld by the dealer is less than or equal to 16. Not any greater. 
						tempcard = deckOfCards.draw(); 
						tempcard.checkIfAce(dealer.getValueHeld());
						dealer.accept(tempcard); 			//keep hitting if the valueheld is <= 16
						System.out.print("The card the dealer got is ");
						tempcard.revealCard();
						System.out.println(); 
						
					}
					if (dealer.getValueHeld() > 17)
					{
						while(dealer.getValueHeld()<21) 	// keep hitting til he gets 21. 
						{
							tempcard = deckOfCards.draw(); 
							tempcard.checkIfAce(dealer.getValueHeld());
							dealer.accept(tempcard); 		//keep hitting if the valueheld is <= 21
							System.out.print("The card the dealer got is ");
							tempcard.revealCard();
							System.out.println(); 
						}
						if (dealer.getValueHeld() == 21) 	// the dealer wins
						{
							endgame = true; 
							System.out.println("The dealer has 21. BlackJack! You lost!");
							adam.lostBet(); 
							dealer.winBet(adam.getBet());
							System.out.println("You now only have " + adam.getBalance() + " left.");
							System.out.println("And the dealer has " + dealer.getBalance());
						}
					}
				} 
				if (dealer.getValueHeld() > 21) 			// the dealer lost 
				{
					endgame = true; 
					System.out.println("The dealer has " + dealer.getValueHeld() + " which is more than 21! You won!!");
					dealer.lostBet(adam.getBet()*1.5);
					adam.winBet();
					System.out.println("You now have " + adam.getBalance());
					System.out.println("And the dealer has " + dealer.getBalance() + " left");
				}
				
			}
			
				
		}
		
		
		
	}
}

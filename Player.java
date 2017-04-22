/* Jessica Gary
 * jsg2213 
 * Player.java
 * Simulates a player of a card game. 
 * */
import java.util.Scanner; 
public class Player 
{
	private Card [] hand; 
	int count; 
	int valueheld; 
	private double balance; 
	private double bet; 
	
	public Player() //when the player starts, they put in a bet. 
	{
		hand = new Card[30];				//let's say a hand has the maximum of 30 cards. 
		count = 0;  						// player has 0 card in the hand to begin with. 
		valueheld = 0; 						//value of the cards combined
		balance = 0; 
		bet = 0; 
	}
	public void setFunds()
	{
		double money; 
		System.out.println("Enter your buy-in amount in dollars: ");
		Scanner in = new Scanner(System.in);
		money = in.nextDouble(); 
		
		while (money < 100.00) 				//The player must buy-in for at least $100.00.
		{
			System.out.println("The player must buy in for at least $100.00. Please enter another number: ");
			money = in.nextDouble(); 
		}
		balance = money; 
	}
	public void resetHand()
	{
		count = 0; 
		valueheld = 0; 
		bet = 0; 
	}
	public void setBet()
	{
		double m = 0; 
		System.out.println();
		System.out.println("******************************************************************************************");
		System.out.println("How much would you like to bet for this hand? You have " + balance +" in your fund. Enter a whole number.");
		Scanner in = new Scanner(System.in);
		m = in.nextDouble();
		//just a bunch of checks to see if the bet qualifies.... 
		//A player must bet between $10.00 and $1000.00 dollars on any hand in $1.00 increments.
		while (m > balance) //bet placed cannot be more than the player has (i.e. the balance) 
		{
			System.out.println("Sorry! The maximum you can bet is " + balance + ". Please enter a number less than the maximum.");
			m = in.nextDouble();
		}
		while (m <10)						//player has to place a bet between [10, balance]  
		{
			System.out.println("Sorry! You gotta bet something more than 10!"); 
			m = in.nextDouble(); 
		}
		while (m%1 != 0) 					//bet must be a whole number. if the remainder is not == 0 then its not a whole number. 
		{
			System.out.println("You must enter a whole number. Enter bet again: ");
			m = in.nextDouble(); 
		}
		bet = m; 
	}
	public void winBet()
	{
		//Blackjack pays 1.5 to 1
		balance += bet *1.5; 				//if you win, you get 150% of your bet back. 
	}
	public void lostBet()
	{
		balance -= bet; 
	}
	public double getBet()
	{
		return bet; 
	}
	
	public void accept(Card card)
	{
		//method for accepting a hand and add the card to the hand array
		hand[count] = new Card(); 
		hand[count] = card; 
		count++; 
		
		//calculate the value of the card. update valueheld
		valueheld += card.getValue();
		
	}
	public int getValueHeld()
	{
		return valueheld; 
	}
	public double getBalance()
	{
		return balance; 
	}
	
}

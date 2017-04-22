/* Jessica Gary
 * jsg2213 
 * Dealer.java
 * The class is similar to the Player card, but doesn't have as much autonomy. 
 * */
public class Dealer 
{
	private double balance; 
	private Card [] hand; 
	private int count; 
	private int valueheld; 
	
	
	
	public Dealer()
	{
		//constructor 
		hand = new Card[30];
		balance = 0;
		count = 0; 
	}
	public void setFunds(double money)
	{
		//this is for the computer dealer.  
		balance = money; 
	}
	public void resetHand()
	{
		count = 0; 
		valueheld = 0; 
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
	public void winBet(double bet)
	{
		balance += bet; 
	}
	public void lostBet(double bet)
	{
		balance -= bet;  
	}
	

	public boolean is17()
	{
		//This is for the computer 
		//checks if the valueHeld is already 17. . 
		if (valueheld == 17)
		{
			return true; 
		}
		else if (valueheld <= 16)
		{
			return false; 
		}
		 
		return true;  //if valueheld is greater than 17. 
		
	}
}

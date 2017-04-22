/* Jessica Gary
 * jsg2213 
 * Card.java
 * Constructs a Card class, with all the features of a card and its functions
 * */
public class Card 
{
	private String card; 
	private int value; 
	
	public Card()
	{
		card = ""; 
	}
	public void setCard(String name)
	{
		card = name; 
	}
	public void setValue(int num)
	{
		value = num; 
	}
	public void checkIfAce(double sum) 				//accepts the sum of the player/dealer's hand. 
	{
		if (value == 1) 							//if you got an Ace... whether it's 11 or 1 is beneficial to you. 
		{
			if(sum<=10) 							//if the sum of the player/dealer is already == 10 then, it's better if the Ace has value 11. 
				this.setValue(11);					//Anything less than that, it's safe to be 11. Any greater would risk losing.
		}
	}
	public int getValue()
	{
		if(card == "Jack" || card == "Queen" || card == "King")
		{
			value = 10; 
		}
		else if (card == "Ace")
		{
			value = 1; 
		}
		else 		
		{	
			//If the card is just a number card then it's valued according to the face of the card.  
			value = Integer.parseInt(card); 
		}
		return value; 
	}
	public void revealCard()
	{
		System.out.print("  " +this.getValue()); 
	}
}

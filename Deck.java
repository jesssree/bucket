/* Jessica Gary
 * jsg2213 
 * Deck.java
 * Implements a deck of cards. 
 * */
public class Deck 
{
	private Card[] theDeck; 
	private int top; 
	
	public Deck()
	{
		//constructor
		theDeck = new Card[52]; 
		this.instantiate(); 
	}
	public void instantiate()
	{
		
		//loop to instantiate all 52 cards of different values
		//I originally instantiated 13 cards for each of the 4 suits. 
		//but in blackjack the suits don't matter. only the value does. 
		//16 Face Cards: value at 10 each except Ace (11 or 1) 
		for (int i=0; i<4; i++) 
		{
			theDeck[i] = new Card(); 				//got an NullPointerException before doing this b/c each of the 52 references were initialized to null. Each
			theDeck[i].setCard("Jack"); 			//each card needs to be declared separately for each i
		}
		for (int i=4; i<8; i++) 
		{
			theDeck[i] = new Card();
			theDeck[i].setCard("Queen");
		}
		for (int i=8; i<12; i++)
		{
			theDeck[i] = new Card();
			theDeck[i].setCard("King");
		}
		for (int i=12; i<16; i++) 
		{
			theDeck[i] = new Card();
			theDeck[i].setCard("Ace");
		}
		//The Numbered Cards 2-10
		for (int i=16;i<20; i++)
		{
			theDeck[i] = new Card();
			theDeck[i].setCard("2");
		}
		for (int i=20; i<24; i++) 
		{
			theDeck[i] = new Card();
			theDeck[i].setCard("3");
		}
		for (int i=24; i<28; i++) 
		{
			theDeck[i] = new Card();
			theDeck[i].setCard("4");
		}
		for (int i=28; i<32; i++) 
		{
			theDeck[i] = new Card();
			theDeck[i].setCard("5");
		}
		for (int i=32; i<36; i++) 
		{
			theDeck[i] = new Card();
			theDeck[i].setCard("6");
		}
		for (int i=36; i<40; i++) 
		{
			theDeck[i] = new Card();
			theDeck[i].setCard("7");
		}
		for (int i=40; i<44; i++) 
		{
			theDeck[i] = new Card();
			theDeck[i].setCard("8");
		}
		for (int i=44; i<48; i++) 
		{
			theDeck[i] = new Card();
			theDeck[i].setCard("9");
		}
		for (int i=48; i<52; i++) 
		{
			theDeck[i] = new Card();
			theDeck[i].setCard("10");
		}
		
		top = 0; 
	}
	
	public boolean check()
	{
		//check if the deck has less than 12
		//if less than 12, then re-shuffle again. 
		//reset top to index 0; 
		if (top > 40 || top == 0) 				// 52-12 = 40, so if the deck is at index 40, then there are 12 cards left in the stack 
		{
			return true;  
		}
		return false; 
	}
	
	public int getCount()
	{
		//how many cards are left in the stack?
		return top; 
	}
	
	public void shuffle()
	{
		int a = 0, b = 0; 
		for(int i = 0; i<100; i++)				//shuffle the cards 100 times.
		{
			a = (int)(Math.random()*51); 		//assign random number from 0 to 51
			b = (int)(Math.random()*51);
			//exchange the cards
			Card temp = theDeck[a];
			theDeck[a]=theDeck[b];
			theDeck[b]=temp; 
		}
		//reset top (in the case of reshuffling)
		top = 0; 
	}
	
	public Card draw()
	{
		//take the top of the card off the deck 
		//return the card to the Player object (either player or dealer) 
		//==add the card to the Player's hand (array) 
		
		Card topcard = theDeck[top];
		top++; 									//increment top 
		return topcard; 						//return the deck's top-1 
	}
}

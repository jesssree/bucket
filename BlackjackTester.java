/* Jessica Gary
 * jsg2213 
 * BlackjackTester.java 
 * Write a Java application that allows a user to play Blackjack against the computer. 
 * That is, the computer will act as the house, dealing the cards and paying when you win.
 * 
 * General:

 Only one deck is used and it is shuffled whenever there are less than 12 cards remaining after a hand is completed.
An ace may have value 11 or 1, whichever is more beneficial.
All 4 cards are dealt before any action occurs. The dealer's top card is revealed to the player.
The player must buy-in for at least $100.00.
You must keep track of the player’s funds from hand to hand.
A player must bet between $10.00 and $1000.00 dollars on any hand in $1.00 increments.
Blackjack pays 1.5 to 1 unless the dealer also has blackjack in which case it’s a push (tie). 
Dealer:  

Hits 16 or under and stands on all 17s.
Player:

The player may hit on anything or stay on anything.
The player makes their decisions before the dealer.
If the player busts they lose even if the dealer goes on to bust.  

 * */

import java.util.Scanner; 
public class BlackjackTester 
{
	public static void main(String[] args)
	{
		Game g = new Game(); 
		g.play(); 
		
		Scanner in = new Scanner(System.in);
		char next = 'Y'; 
		while(g.checkFunds() && (next == 'Y' || next == 'y') )
		{
			g.reset(); 
			g.play(); 	
			System.out.print("\nWould you like to play again? Enter Y for yes, or N for no: ");
			next = in.next().charAt(0);
			
		}
	}
}

// by not creating a new game, there's only one set of balance, which is the player's funds, we need to keep track of. 
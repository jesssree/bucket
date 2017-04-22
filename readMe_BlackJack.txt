Jessica Gary
jsg2213

JAVA 1004 Fall 2016

BlackJack Game
Project 4 



1) BlackjackTester.java
	-I tried to keep this class as simple as possible. 
	-I instantiate class Game called g, then called the play() method right away. 
	-The other stuff in main() is just so that the player has an option to play again. 
	Each time the user wants to play again, instead of making a new Game object, I 
	use the same Game object, but choosing to reset the game, which means I reset 
	the counter of the hands, the bet value, the value the hand previously held. 
	However, I do not reset the balance. The only balance we’re working with here 
	is the one set at the very beginning of the first game. 
	-Also the while loop checks if there is sufficient funds on either of the parties;
	-it checks whether or not the player and the dealer have enough funds to continue 
	to play. If not, the game terminates, and suggests that the player restart. 

2) Game.java
	- This class facilitates the function of the BlackJack game by being the middleman
	between the main() and the rest of the classes. 
	- This is the only access point between the main() and the other classes.
	- Unfortunately, it is the longest class as well because of the play() method. 
	- I set the funds for the dealer to default to $1000.00. I don’t know whatelse
	to do about the dealer’s initial fund. 
	- the reset() method was explained above as a way to continue playing the game 
	(different hands) while keeping tab of the overall balances of the players.
	- The play() method is the longest because it controls the whole game. Although, 
	it calls to other classes and use their functions, most of play() is conditional
	statements of if-s and while-s. 
	- Start out the play() method by setting two important boolean values, endgame
	and response. The boolean endgame will control when the game ends. 
	- I thought the while loops are very important here because I needed to think
	of a way to keep this method going until one of the parties loses or wins. 
	- When someone loses or wins, the boolean variable endgame is then set to 0, and 
	the outer-most while loop will no longer run. play() will terminate. 
	- Actually, play() was the hardest method because it juggles so much information 
	from other classes. And I had to make sure that everything runs in the right order
	so that I don’t suddenly get the wrong values. 
	- I thought I could have done a better job when I asked the user if they want to 
	hit or stand. The value I accepted was and int, but I later converted this input
	to a boolean, as I thought it’s easier for the rest of the method. But I probably 
	could have done something else as well. 

3) Deck.java
	- I realized earlier on that it doesn’t really matter what suit the cards actually 
	are. The only thing that matters for BlackJack is the value of the card.
	- I instantiate the 52 classes, not according to the suits (like Hearts and 
	Diamonds), but according to the Faces. I notice that all Jacks, Queens, and Kings 
	all have the value 10. The others’ values depend on the number written in the 
	face. So a card that says 2 has value 2, for example. Ace can be 11 or 1, 
	depending on whichever one is beneficial to the card-holder (so need to take
	into account the value this person holds in their hands). 
	- I actually had a NullPointerException error when doing this class. This is due 
	to the fact that I assumed with theDeck = new Card[52], all the cards are already
	instantiated. This is not exactly true. All 52 Card references were set to null. 
	No addresses were assigned yet. So I needed to actually create a new Card object 
	then have the reference in the Card[] point to the new Card object. 
	- shuffle() is self-explanatory. The idea was borrowed from Prof. Cannon in class.
	Two numbers are picked randomly between 0 and 51. I used these numbers to shuffle 
	the array 100 times, which is by then, already pretty shuffled. I reset the top to 
	0 because that’s where my top card is, not 52. I suppose I could have done it the
	other way, too and have top as 52, and decrement everytime, but that’s how I 
	thought to do it, and it works. 

4) Player.java
	- The Player object is instantiated when Game is instantiated. I named him adam, 
	just because I can. In the constructor, I made an array of 30 Cards, called hand. 
	- When I called the .accept(Card card), a new instance of Card is created and the 
	reference from the hand array now will point to the new Card. count, which holds 
	the number of cards in the hand, is incremented. This value will also allow us to 
	access any given card in a hand (array). 
	- If the player wins a bet, 150% of their bet will be added to the balance. 
	- If the player loses, the amount they bet will be subtracted from the balance. 
	- setBet() method has three while-loops, all for conditions to make sure that
	the bet placed are between $10 and $1000 and is a whole number. 
	
5) Dealer.java
	- The Dealer class is very similar to the Player class, but not as complex.
	- The Dealer class accepts(Card), win and lose, just like the Player class
	- However, the winBet() and lostBet() accept a double as a formal parameter 
	because I need a way to know how much from the balance should be subtracted. 
	Whereas in the Player class, the numbers to be added or subtracted are already
	in the object itself. 
	- is17() is a method that checks whether the hand the dealer holds come up to 17.
	If it is 17, then the dealer will not hit anymore. It will continue to hit until
	get to 16.
	- I got a bit confused here, and still don’t know if it is right.
	If the dealer gets more than 17, then it only makes sense that he will continue
	to hit, in hopes of getting a 21. In none of my test cases have I run into an 
	instance where the value the dealer gets (with the first 2 cards) add up to 
	exactly 17, so I don’t know if this part actually works okay or not. From my
	understanding, if the valueHeld is exactly 17, then, it will stand, and turn
	it over to the player again. Again, I haven’t tested out the case where
	the dealer’s hand is exactly 17, so I don’t know if this works. From debugging
	by eyes, it looks like it will work. 
6) Card.java
	- This class doesn’t have a lot to it. 
	- Basic getters and setters. 
	- getValue() translates the Card’s string name to actual numerical values.
	As said before, all the Face cards have the same value of 10. The others are
	self explanatory.
	- checkIfAce() was added later than all of the methods in all of the classes.
	If checks whether or not the Card is an ace. It accepts a double called sum, which
	is the value of a hand (whether it is the dealer or the player depends on where
	I called it). This value is used to determine whether or not 1 or 11 is more 
	beneficial. Obviously, it is the valueHeld is already 10, then the most beneficial 
	choice is 11 because 10+11 = 21. This person would get a blackjack! However, if it
	is more than 10, then an 100 would go over 21, which would be very bad. In this 
	case, it would be more useful to be a 1. The default value is 1, but if need be,
	this method reset the value of the Card to 11. 


	 





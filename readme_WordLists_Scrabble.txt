Jessica Gary
jsg2213
Java Fall 2016
Programming Project 5

*Running the Tester class, the 5 lists of words will be printed to 5 files:
wordlist_1.txt —> contains words of specified length 
wordlist_2.txt —> contains words of specified length but begins with specific letter
wordlist_3.txt -> contains words of specified length and letter. 
wordlist_4.txt -> contains words of specified length and specified number of vowels. 
wordlist_5.txt -> contains words that has a letter repeated in a specified number of times. 


*WordLists.java is a class that implements methods to help the user with a word game called Scrabble. 

Constructor: throws FileNotFoundException. The main program (WordListsTester) will handle the Exception by ending the program with a message that it cannot find the specified file name and to try again with a correct one. The constructor reads in all the word in the file, and store each of the word into an ArrayList called “list.” This ArrayList will be used in all the methods henceof. 


*There are many functions to this class.
• lengthN(int n):  returns an array of words of length n.
	A pretty simple function. 
	Reads in a word from the list (ArrayList of words from the dictionary).
	Then if this word has the length matching the specified length, then put this
	word into the final ArrayList (to be returned to main method) called usefulwords. 
	
	
• startsWith(int n, char firstLetter):  returns an array of words of length n beginning with the letter firstLetter
	Notice the line: usefulwords.clear(); 
		this ArrayList is cleared because we’re using it over and over again from
		one method to the next. I thought it might be smart to clear it of 
		anything in it before using it again in another capacity.
	This method is similar to the first one described, but instead of just checking
	the length of the word, we must also check the first letter of the word using 
	the string function .charAt(0), which returns the first letter of the word 

• containsLetter(int n, char included):  returns an array of words of length n containing the letter included but not beginning with it.
	The trick with this method is to iterate through all the letters that made up 
	the word. When the letter is found in the word, put this word into the arrayList
	to be returned to the main method. 

• vowelHeavy(int n, int m):  returns an array of words of length n containing at least m vowels.
	This method iterates through each letter of the word got from the list.
	While iterating through each letter, compare the letter to a vowel (a,e,i,o,u)
	If the letter matches any of these vowels, increment the vowel counter.
	At the end of the iteration of letters, compare the number of vowels we counted
	in the word to the specified number m. If it matches, put this word into the 
	array list to be returned to the main method. 


Regarding the PrintWriter: It is quite important to close the output because otherwise, the words will be written to one file, but not to the other files that use the same PrintWriter output. So, before pointing output to another PrintWriter(filename), I must close the output first. This was a bug for a while before I figured out I didn’t do “output.close();” 




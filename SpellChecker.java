/* Jessica Gary
 * jsg2213
 * 
 * Columbia Spring 2014 
 * Data Structures 
 * 
 * HW 4 Programming part 1: 
 * 
 * Implement a spelling checker by using a hash table. 
 * Assume that the dictionary comes from two sources: an existing large dictionary
 * and a second file containing a personal dictionary. 
 * Output all misspelled words and the line numbers in which they occur. 
 * Also, for each misspelled word, list any words in the dictionary that are obtainable by applying any of the following rules:
a. Add one character.
b. Remove one character.
c. Exchange adjacent characters.   

implement this problem as described with the exception of the secondary dictionary.  
 * Your program, called SpellChecker.java should take two command line arguments, 
 * the dictionary (provided here as words.txtPreview the documentView in a new window), 
 * and the text that you wish to spellcheck. Provide some sample text.  
 * Your program should be case insensitive (so you can toLower everything).  
 * Numbers and contractions are considered valid words.  You may use the java HashTable, HashMap, or HashSet to implement this program;
 * but it must use some kind of hash table.
 * 
 * NOTE for Wednesday: clean up code + write README 
 * */
import java.util.*;
import java.io.*;
public class SpellChecker 
{ 
	Hashtable<String, String> dict; 
	
	public SpellChecker(String args) //constructor, accepts a string from main method, which is file name 
	{
		//Read in the dictionary into a hash table 
		try
		{
			File inputfile = new File(args); //need to be command line --> input file name 
			Scanner in = new Scanner(inputfile); //FileNotFoundException needs to be caught. 
			
			//create a hash table
			dict = new Hashtable<String,String>(); 
			
			//Read in the dictionary text 
			while(in.hasNextLine())
			{
				String tempString = in.nextLine();  //reading text line by line == word by word 
				tempString = tempString.toLowerCase(); //lowerCase 
				String[] line = tempString.split("\\s+"); //split string with any white spaces: http://stackoverflow.com/questions/225337/how-do-i-split-a-string-with-any-whitespace-chars-as-delimiters
				
				//The Key is the same as the Value in the hash table since it's a dictionary... 
				dict.put(line[0], line[0]);
			}
			in.close(); 
		}
		catch(Exception e)
		{
			//catching the file not found exception... 
			e.printStackTrace();
		}
	
	}
	public void checkTextFile(String textfile)
	{
		try
		{
			File texttocheck = new File(textfile);
			Scanner in = new Scanner(texttocheck);
			
			int linenum = 1; //counter for line number to be displayed with misspelled words 
			
			//read in a line at a time while checking the spelling after each line 
			while(in.hasNextLine())
			{
				//read from file one line at a time 
				String oneline = in.nextLine(); 
				
				//lower case the string + get rid of all punctuations before checking the spelling
				//split the string into words, no white spaces 
				String[] token = oneline.split("\\s"); 

				for(int i=0; i<token.length; i++) 
				{
					//run through the array of words token[] 
					if(!this.check(token[i])) //check each token against the dictionary 
					{
						//if the word is not found, print the word and the line number it occurs in 
						System.out.print(linenum + " -> " + token[i]);
						
						//Print the suggestions here::
						System.out.print("  (do you mean: ");
						this.suggestWords(token[i].toLowerCase().replaceAll("[^a-zA-Z\\s]", "")); 
						System.out.print(")\n");
					}
				
				}
				
				linenum++; //increment the linenum, go to next line 
			}
			in.close(); 
		}
		catch(Exception e)
		{
			//catch file not found exception 
			e.printStackTrace();
		}
		
		
	}
	public boolean check(String word)
	{
		//Check if the word already exists in the dictionary
		if(dict.containsValue(word)) //containsValue method return true if value is found in the hash table, false otherwise. 
		{
			//return true if found. 
			return true; 
		}
		
		//First check comes up empty --> lower case all letters and check again 
		word = word.toLowerCase(); //do this again in case just want to check one word manually sometime 
		if(dict.containsValue(word))
		{
			//return true if found.
			return true; 
		}
		
		//In cases where the string is still NOT found in the dictionary: 
		//May be because of punctuation marks. Get rid of all punctuation marks in the string
		word = word.replaceAll("[^a-zA-Z\\s]", ""); //Regex from: http://stackoverflow.com/questions/23332146/remove-punctuation-preserve-letters-and-white-space-java-regex
		if(dict.containsValue(word))
		{
			//word without the punctuations is found in the hash map 
			//return true if found.
			return true; 
		}
		return false; // word not found in the dictionary 
		
	}
	public void suggestWords(String misspelledword)
	{
		//calls 5 private methods, each of which specialize in suggesting words 
		suggestAddCharFront(misspelledword); //adds a character from alphabet to front of word 
		suggestAddCharBack(misspelledword); //adds a character to the back of word
		suggestRemoveFront(misspelledword); //remove a character from the front of the word
		suggestRemoveBack(misspelledword); //remove a character from the back of the word
		suggestMixUp(misspelledword); //alternative adjacent characters 
		
	}
	
	private void suggestAddCharFront(String misspelledword)
	{
		//Add a character to the front of the misspelledword string + check against the dictionary 
		String possibleword1; //front 
		for(char alphabet = 'a'; alphabet <= 'z'; alphabet++)
		{
			possibleword1 = alphabet + misspelledword; 
			if(dict.contains(possibleword1))
			{
				System.out.print(possibleword1 + " ");  
			}	
		}
	}
	private void suggestAddCharBack(String misspelledword)
	{
		//Add a character to the back of the misspelledword string + check against the dictionary 
		String possibleword2; //back
		
		for(char alphabet = 'a'; alphabet <= 'z'; alphabet++)
		{ 
			possibleword2 = misspelledword + alphabet; 
			
			if(dict.containsKey(possibleword2))
			{
				//suggestion word is found in dictionary 
				System.out.print(possibleword2+ " "); 
			}
				
		}
	}
	private void suggestRemoveFront(String misspelledword)
	{
		//remove the front character of the string + check against the dictionary 
		String newString = misspelledword.substring(1,misspelledword.length()); 
		if(dict.containsKey(newString))
		{
			//suggestion word is found in dictionary 
			System.out.print(newString+ " ");
		}
	}
	private void suggestRemoveBack(String misspelledword)
	{
		//remove the last character of the string + check against the dictionary 
		String newString = misspelledword.substring(0,misspelledword.length()-1);
		if(dict.containsKey(newString))
		{
			//suggestion word is found in dictionary 
			System.out.print(newString+ " "); 
		}
	}
	private void suggestMixUp(String misspelledword) 
	{ 
		//exchange adjacent characters check against the dictionary
		char[] letter = misspelledword.toCharArray(); //convert string into an array of characters 
		String newword = ""; 
		
		for(int i=0; i+1<letter.length; i++) //traverse through the char array 
		{
			//switch the characters at index i and i+1, using char temp 
			char temp = letter[i];
			letter[i]=letter[i+1];
			letter[i+1]=temp;
			
			for(int j=0;j<letter.length; j++)
			{
				newword += letter[j];  //add the rest of the character into an empty string 
			}
			
			if(dict.containsKey(newword)) //check the newword string against the dictionary 
			{
				//suggestion word is found in dictionary 
				System.out.print(newword + " ");
			}
			
			letter = misspelledword.toCharArray(); //reset the char array again before the next loop 
			
			newword = "";  //reset the newword string again before the next loop 
		}
		
	}
	
	public static void main(String[] args)
	{
		SpellChecker checker = new SpellChecker(args[0]); //accepts the dictionary file name from the command line
		checker.checkTextFile(args[1]); //accepts the file to be checked for spelling errors from the command line 
		//checker.checkTextFile("sampletext2.txt");
	} 
}

















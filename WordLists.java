/*
 * Jessica Gary
 * jsg2213
 * Java Fall 2016
 * Programming Project 5
 * 
 * WordLists.java 
 * 
 * This class contains methods to assist playing a word game called "Scrabble" 
 * It can many functions of search.
 * Overview of all the methods: 
- lengthN(int n):  returns an array of words of length n.
- startsWith(int n, char firstLetter):  returns an array of words of length n beginning with the letter firstLetter
- containsLetter(int n, char included):  returns an array of words of length n containing the letter included but not beginning with it.
- vowelHeavy(int n, int m):  returns an array of words of length n containing at least m vowels.
-  multiLetter(int m, char included):  returns an array of words with at least m occurrences of the letter included.

 */
import java.util.*; 
import java.io.*; 
import java.util.Scanner; 
public class WordLists 
{
	public ArrayList<String> list = new ArrayList<String>(); 
	public ArrayList<String> usefulwords = new ArrayList<String>(); 
	
	public WordLists()		
	{
		//default constructor 
	}
	
	public WordLists(String filename) throws FileNotFoundException //FileNotFoundException is dealt with in the main -->outer scope 
	{
		File inFile = new File(filename);
		Scanner input = new Scanner(inFile); 
		String word; 
		while(input.hasNext())
		{
			word = input.nextLine();				//read one word at a time
			list.add(word);							//put this word into an ArrayList
		}	
		/*for (int i= 0; i<list.size(); i++) 		//if want to print the words on the screen. 
		{
			System.out.println(list.get(i));
		}
		*/
	}
	
	public ArrayList<String> lengthN(int n)
	{
		//return an array of words of length n
		usefulwords.clear(); 						//removes all the elements in the ArrayList before putting more in it. 
		String tempword = "";						//instantialize the tempword to an empty string. 
		for(int i=0; i<list.size(); i++)
		{
			tempword = list.get(i); 
			if(n==tempword.length())				//if this word is of the same length n,
			{
				usefulwords.add(tempword);			//put the word into a new ArrayList to be displayed
			}
		}
		return usefulwords; 
	}
	public ArrayList<String> startsWith(int n, char firstLetter)
	{
		//returns an array of words of length n beginning with the letter firstLetter
		usefulwords.clear(); 
		String tempword = "";
		for(int i=0; i<list.size(); i++)
		{
			tempword = list.get(i); 				//get one word from the list. 
			if(tempword.charAt(0) == firstLetter && tempword.length()==n)	//check if the word begins with the firstLetter && of the right length.
			{
				usefulwords.add(tempword); 	
			}
		}
		return usefulwords; 
	}
	public ArrayList<String> containsLetter(int n, char included)
	{
		//returns an array of words of length n containing the letter included but 
		//not beginning with it
		usefulwords.clear(); 
		String tempword = "";
		for(int i=0; i<list.size(); i++)
		{
			tempword = list.get(i); 				//get one word from the list 
			if(tempword.length()==n)				//check if the word is of the right length.
			{
				for(int j = 0; j<tempword.length(); j++)	//iterate through each of the letter in the word 
				{
					if (tempword.charAt(j)==included)
					{
						usefulwords.add(tempword); 			//if the word contains the letter "included", then put this word in the arraylist 
					}
				}
			}
		}
		return usefulwords; 
		
	}
	public ArrayList<String> vowelHeavy(int n, int m)
	{
		//returns an array of words of length n
		//containing at least m vowels
		usefulwords.clear(); 
		String tempword = "";
		 
		for(int i=0; i<list.size(); i++)
		{
			tempword = list.get(i); 				//get one word from the list 
			
			if(tempword.length()==n)				//check if the word is of the right length.
			{
				int vowels =  0; 					//counter for number of vowels in word
				for(int j = 0; j<tempword.length(); j++)	//iterate through each of the letter in the word 
				{
					if (tempword.charAt(j) == 'a' || tempword.charAt(j) == 'e' || tempword.charAt(j) == 'i'|| tempword.charAt(j) == 'o' || tempword.charAt(j) == 'u')
					{
						vowels++;  
					}
				}
				if(vowels>=m)						//if the number of vowels counted in this word equals the specified number m, then 
				{
					usefulwords.add(tempword); 		//put the word into the arraylist 
				}
			}
		}
		return usefulwords;
	}
	public ArrayList<String> multiLetter(int m, char included)
	{
		//returns an array of words with at least m occurrences of the letter included 
		usefulwords.clear(); 
		String tempword = "";
		
		for(int i=0; i<list.size(); i++)
		{
			tempword = list.get(i); 				//get one word from the list 
			int num = 0; 							//counter for number of occurrences of a particular letter in the word
			for(int j=0; j<tempword.length(); j++)	//iterate through the word, letter by letter 
			{
				if(tempword.charAt(j) == included)	//compare each letter to "included" letter. 
				{
					num++; 							//if the letter in the word matches "included" then increment the counter. 
				}
			}
			if(num>=m)								//if the number (num) of occurrences of the letter "included" equals the specified number m, then... 
			{
				usefulwords.add(tempword); 			//put the word into the arraylist 
			}
			
		}
		return usefulwords; 
		
	}
}

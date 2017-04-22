/*
 * Jessica Gary 
 * jsg2213
 * Java Fall 2016
 * Programming Project 5 
 * 
 * WordListsTester.java
 * 
 * This program tests an accompanied class called WordLists.java 
 * 
 */
import java.io.FileNotFoundException;
import java.util.*; 

import java.io.*; 

public class WordListsTester 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		try
		{
			//reads in a text file called "dictionary.text" 
			WordLists newlist = new WordLists("dictionary.txt");		//the constructor will put the list into an ArrayList
		
			Scanner in = new Scanner(System.in); 
			ArrayList<String> templist = new ArrayList<String>(); 		//this ArrayList will be used over and over again to display list of words
			
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("			Scrabble Helper");
			System.out.println("Available Functions: ");
			
			System.out.println("Note: All the lists will be written in their own separate files.");
			System.out.println("-------------------------------------------------------------------------");
			////////////////////////////////////////////////////////////////////////////////////
			PrintWriter output = new PrintWriter("wordlist_1.txt"); 	//points the output to the new PrintWriter that will write to a file called wordlist_1.txt 
			System.out.println("1. Search by length of word."); 
			System.out.print("Input the word length: ");
			int n = in.nextInt(); 		//length n 
			templist = newlist.lengthN(n);
			
			
			
			if(templist.isEmpty())										//check if the list is empty
			{
				System.out.println("Words not found.\n");
			}
			else
			{
				System.out.println("The word list is written in the file called wordlist_1.txt.\n\n");
				for (int i=0; i<templist.size(); i++)					//print the list of words of length n 
				{
					//System.out.println(templist.get(i));
					output.println(templist.get(i));
				}
				templist.clear(); 										//clear the ArrayList before moving on to the next command.
			}
			
			output.close(); 											//very important to do this--> need to close this output first before opening it again 
			
			////////////////////////////////////////////////////////////////////////////////////
			output = new PrintWriter("wordlist_2.txt");					//now the PrintWriter will write to a new file called wordlist_2.txt 
			System.out.println("2. Search by length & first letter of the word."); 
			System.out.print("Input the first letter of the words you'd like to search: ");
			char first = in.next().charAt(0);  							//getting the first letter
			System.out.print("What is the lenght of the word? ");
			n = in.nextInt(); 
			templist = newlist.startsWith(n, first);  					//startsWith returns an arraylist, which will go into the templist to be printed/written to file 
			
			
			if(templist.isEmpty())										//check if the list is empty == no words found that matched the criteria. 
			{
				System.out.println("Words not found.\n"); 				//if empty, print so. and don't put anything in file. 
			}
			else
			{
				System.out.println("The word list is written in the file called wordlist_2.txt.\n\n");
				for (int i=0; i<templist.size(); i++)					//print the list of words of length n with the first letter first 
				{
					//System.out.println(templist.get(i));
					output.println(templist.get(i));
				}
				templist.clear(); 										//clear the templist before ending this part of the program because templist is reused. 
			}
			
			output.close();  
			////////////////////////////////////////////////////////////////////////////////////
			output = new PrintWriter("wordlist_3.txt");
			System.out.println("3. Search by length & includes (but not begins with) a letter."); 
			System.out.print("Input the word length: ");
			n = in.nextInt(); 
			System.out.print("What's one letter you'd like to see in this word?: ");
			char included = in.next().charAt(0); 						//getting the first letter only. 
			templist = newlist.containsLetter(n, included); 			//again, containsLetter returns an arraylist. 
			
			if(templist.isEmpty())										//check if the list is empty 
			{
				System.out.println("Words not found.\n");
			}
			else
			{
				System.out.println("The word list is written in the file called wordlist_3.txt.\n\n");
				for (int i=0; i<templist.size(); i++)					//print the list of words of length n, included a letter "included" 
				{
					//System.out.println(templist.get(i));
					output.println(templist.get(i));
				}
				templist.clear();
			}
			output.close(); 
			////////////////////////////////////////////////////////////////////////////////////
			output = new PrintWriter("wordlist_4.txt"); 
			System.out.println("4. Search by length & contains at least the specified number of vowel."); 
			System.out.print("Input the word length: ");
			n = in.nextInt();
			System.out.print("Number of occurances of any vowels in the word: "); 
			int occur = in.nextInt(); 
			templist = newlist.vowelHeavy(n, occur);
			
			
			if(templist.isEmpty())										//check if the list is empty 
			{
				System.out.println("Words not found.\n");
			}
			else
			{
				System.out.println("The word list is written in the file called wordlist_4.txt.\n\n"); 
				for (int i=0; i<templist.size(); i++)					//print the list of words of length n, that has repeated vowels an amount of time 
				{
					//System.out.println(templist.get(i));
					output.println(templist.get(i));
				}
				templist.clear();
			}
			output.close(); 
			////////////////////////////////////////////////////////////////////////////////////
			output = new PrintWriter("wordlist_5.txt");
			System.out.println("5. Search word with at least specified number of occurrences of the letter included"); 
			System.out.print("Input the letter you'd like to see in the word: ");
			included = in.next().charAt(0); 
			System.out.print("How many times you'd like to see this letter?: ");
			occur = in.nextInt(); 
			templist = newlist.multiLetter(occur, included);
			
			
			if(templist.isEmpty())										//check if the list is empty 
			{
				System.out.println("Words not found.");
			}
			else
			{
				System.out.println("The word list is written in the file called wordlist_5.txt.\n\n"); 
				for (int i=0; i<templist.size(); i++)					//print the list of words of that has the letter an amount of time. 
				{
					//System.out.println(templist.get(i));
					output.println(templist.get(i));
				}
				templist.clear();
			}
			output.close(); 
			////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////
			
			
		}
		catch(FileNotFoundException e)
		{
			//handles the exception in the case that the file is not found in the directory. 
			System.out.println("File is not found. Please try again with a correct file name.");
			System.out.println(e); 										//prints out actually what's wrong.
		}
		
	}
	

}

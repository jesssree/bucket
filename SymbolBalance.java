/*
 * Jessica Gary
 * jsg2213
 * COMS 3134 Columbia Spring 2017
 * Homework 2 
 * 
 * Symbol Balancing class:  

Implement a class called SymbolBalance.java. It should take a the name of a java file as a command line argument. 
Read in the file and check to make sure that all { }'s, ( )'s, [ ]'s, " "'s, and 
s are properly balanced. Make sure to ignore characters within literal strings and comment blocks. 
You do not have to deal with single line comments (those that start with a //).

There are a number of error cases:

1) The file ends with one or more opening symbols missing their corresponding closing symbols.
2) There is a closing symbol without an opening symbol.
3) There is a mismatch between closing and opening symbols (for example: { [ } ] ).

Your program should output whether or not the symbols are all appropriately balanced.  
If they are not, indicate which error condition occurred and what symbol type caused the problem. 
 * 
 * 
 * The plan (from the Weiss textbook pg84-85):
 * 1) Read in the file --> store into a string.
 * 2) Using String.charAt(i), itereate over the whole string, compare each character: 
 * 		2A) IF (opening symbol) --> push() onto stack 
 * 		2B) IF (closing symbol&&stack empty) --> ERROR 
 * 		2C) IF (closing symbol&&stack NOT empty) --> pop() the top 
 * 					IF ( item popped is not the right opening symbol) --> ERROR 
 * 		2D) End of string && Stack NOT empty --> ERROR 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*; 

public class SymbolBalance 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//file io part from stackoverflow.com  http://stackoverflow.com/questions/20107717/trying-to-read-a-java-file-with-a-scanner-class
		File inputfile = new File("Test4.java"); //output for Test2.java: "Unbalanced! Symbol } is mismatched"; 
		//File inputfile = new File(args[0]);
		Scanner in = new Scanner(inputfile);
		//System.out.println(inputfile.exists());
		String lines = ""; 
		
		int j=0; 
		while(in.hasNextLine()) //reading in the whole file and put them into the string. 
		{
			String tempString = in.nextLine();  
			
			//HANDLGING COMMENT BLOCKS: 
			if(tempString.contains("/*")) //if the line read contains beginning of comment, discard this line. move on. 
			{
				continue; //go to the next iteration of the loop. 
			}
			else if (tempString.contains("*\\")) //the line is the end of a comment 
			{
				continue; //don't add this line to the "lines" string because it is a comment 
			}
			else if(tempString.contains("//")) //same reason as above 
			{
				//splitting string from http://stackoverflow.com/questions/3481828/how-to-split-a-string-in-java
				String[] parts = tempString.split("//"); //splits the string to BEFORE // and AFTER // 
				//only using the BEFORE part because the rest is just comment --> index 0 in parts[] array 
				lines=lines.concat(parts[0]);
				continue; 
			}
			
			//HANDING QUOTATION MARKS:
			else if(tempString.contains("\"")) //beginning of a quotation 
			{
				int start = tempString.indexOf("\""); //returns the index of the first occurrence of " 
				//System.out.println("start is "+start);
				int end = tempString.lastIndexOf("\""); //returns the index of the LAST occurrence of the "
				//System.out.println("end is "+end);
				if(start == end) //this means there's only 1 " in the string-->mismatched
				{
					//lastIndexOf counts from the end of the string. if the end index is the same as the begin index of " occurance
					//that means that there's only 1 " in this line, which usually means that it is mismatched.. 
					System.out.println("Unbalanced! Symbol \" is mismatched");
					System.exit(0); 
				}
				else 
				{
					//By replacing the quotations, we ignore the literal string.
					System.out.println("This is before trimming: " + tempString);
					String newstring = tempString.substring(start, end+1); //returns a new string that is a substring of tempString
					tempString = tempString.replace(newstring, "IGNORE"); //replaces each substring with a replacement string 
					System.out.println("This is after trimming: " + tempString); 
				}
			}
			
			
			
			//If the line is not a comment line, then concatenate the line to the whole string
			lines = lines.concat(tempString);
			
		}
		//System.out.print(lines);
		//////////////////////////////////////////////////////////////////////////
		int i=0; //counter as we traverse through the string 
		char temp = ' ';  
		
		MyStack<Character> tempstack = new MyStack<Character>(); //NEED TO DECLARE A STACK HERER!!!!!!!! 
		//System.out.println(lines);
		while(i!=lines.length())
		{
			//READING in one character at a time from the string lines -->handle each char one at a time. 
			temp = lines.charAt(i); 
			//System.out.print(temp); 
			if(temp == '(' || temp=='[' || temp =='{')
			{
				tempstack.push(temp);  //if the char is an opening symbol, then push onto the stack 
			}
			else if ((temp == ')' || temp==']' || temp =='}')&& tempstack.isEmpty()) 
			{
				//if the character is a closing symbol AND the stack is empty -->ERROR 
				System.out.println("Unbalanced! Symbol " + temp + " is mismatched."); 
				System.exit(0); 
			}
			else if((temp == ')' || temp==']' || temp =='}')&& !tempstack.isEmpty()) 
			{
				//if the character is a closing symbol BUT the stack is NOT empty, then pop the top 
				char c = tempstack.pop();
				
				//compare the top (c) to the temp (current character being read from the string) to see if matched. 
				if(temp==')'&&(c!='('))
				{
					//unexpected pairing --> ERROR is reported 
					System.out.println("Unbalanced! Symbol " + temp + " is mismatched."); 
					System.exit(0);  
				}
				else if(temp==']'&&(c!='['))
				{
					System.out.println("Unbalanced! Symbol " + temp + " is mismatched."); 
					System.exit(0); 
				}
				else if(temp=='}'&&(c!='{'))
				{
					System.out.println("Unbalanced! Symbol " + temp + " is mismatched."); 
					System.exit(0); 
				}
			}
			
			i++; 
		}
		
		//End of file (everything in lines string is read) 
		//it needs to ignore the comment!!! System.out.println("Hey! --> " + tempstack.pop()); 
		if(tempstack.isEmpty()) // if the stack is NOT empty
		{
			System.out.println("This file is balanced!"); 
			
		}
		else
		{
			System.out.println("Leftover " + tempstack.pop() + " in the stack");
			System.out.println("File not balanced!"); 
		}
		
		
	}
	
}


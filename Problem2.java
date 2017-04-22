import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/* Jessica Gary
 * jsg2213
 * COMS3134 Columbia 2017
 * 
 * HW3 Programming part 2 
 * 
 *  Problem2.java is a command line application that indexes the words contained in a text file. 
 *  It goes through the input file line by line. For each line, it extracts each word, 
 *  and insert that word, along with it's line number into an AVL tree. 
 *  
 *  Each element of the AVL tree (AvlNode) contains a unique word and a linked list of line numbers where that word occurs. 
 *  
 *  The main method in Problem2.java creates an instance of your AvlTree 
 *  and uses it to indexes the words contained in a text file (provided to the program as a command line argument).
 *  
 *  Ignore case in the input text (insert everything as lower case), and ignore all punctuation. 
 *  
 *  When indexing has finished, the program should call the printIndex method to display a list of 
 *  unique words in the text file and the line numbers in which that word occurs. 

 */

public class Problem2 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		AvlTree<Integer> t = new AvlTree<Integer>();//instantiate an AVL tree 
		
		File inputfile = new File(args[0]);  //command line input file name  
		//File inputfile = new File("TesterFileForHw3.txt");
		
		Scanner in = new Scanner(inputfile); //requires the FileNotFoundException to be thrown. Just in case. 
		
		int line_num = 1;  //starting out the line number count at 1. 
		
		while(in.hasNextLine())
		{
			String tempString = in.nextLine(); //read in from file one line at a time. 

			//System.out.print(line_num+ "	"); 
			//extracts each word 
			tempString = tempString.toLowerCase(); //lowercase the whole string before splitting it 
			//get rid of all punctuation: 
			tempString = tempString.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " "); //from: http://stackoverflow.com/questions/23332146/remove-punctuation-preserve-letters-and-white-space-java-regex
			String[] tokens = tempString.split(" "); //split the line into tokens (words separated by a space) 
			//for(int i=0; i<tokens.length; i++)
			//{
			//	System.out.print(tokens[i] + " ");  
			//}
			//System.out.println(); 
			
			//insert each word, along with the line number into the AVL tree. 
			for(int i=0; i<tokens.length; i++)
			{
				t.insert(tokens[i], line_num);
			}
			
			line_num++; 
		}
		in.close(); 
		 
		t.printIndex(); //display all the unique words contained in the text file, as well as their line numbers 
		
		/*LinkedList<Integer> list = t.getLinesForWord("war"); 
		for(int i=0; i<list.size(); i++)
		{
			System.out.print(list.get(i) + " "); 
		}
		*/
		
		
		
		
	}
	
}

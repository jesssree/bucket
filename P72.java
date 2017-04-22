//****************************************
//  Jessica Gary
//	Java 1004 Fall 2016
//	P 7.2
//  10/27/2016
//
// 	This class, in conjunction with the Die.java class, generates a sequence of 20 random die tosses
//	in an array and prints the values, marking only the longest run, like this:
//  1 2 5 5 3 1 2 4 3 (2 2 2 2) 3 6 5 5 6 3 1
//
//  Horstmann, Cay S. (2015-07-07). Big Java: Early Objects, 6th Edition (Page 366). Wiley. Kindle Edition. 

//  NOTE TO SELF -- should really make another class for finding the longest run, but don't know how to return 2 values (beginning and ending of run)  
//
//****************************************
public class P72 
{
	public static void main(String[] args)
	{
		 			
		Die newdie = new Die();
		int[] array = new int[20];
		
		
		//****populate the array with the sides of cubes 
		for (int i = 0; i<array.length; i++)			
		{
			newdie.roll();									//roll the cube
			array[i]=newdie.getSide(); 					//get the side of the cube and put into the array
			//System.out.print(array[i] + " ");
		}
		
		
		//****this for-loop determines the length of the longest run in the array as well as where it starts and ends. 
		int loc_b = 0;									//marking the beginning of the local run
		int loc_e = 0; 									//marking the ending of the local run
		int max_b = 0;									//holds the final value of the beginning index of the longest run in the array 
		int max_e = 0; 									//holds the final value of the ending index of the longesting run in the array. 
		int loc_count = 0; 								//keeping the local count of the run to be compared to the count of the largest run (so far) 
		int largest_count = 0; 							//largest_count is the longest run. set this to 0 to begin with, but will change as we move through the array
		
		boolean inRun = false;							//helps us keep track of where we are in the array 
		
		for (int i =0; i< array.length; i++)
		{
			if(inRun)									//for when we're in the run, but need to check when the run will end. 
			{
				if(i!=0)								//safeguard against outofbound exception
				{
					if(array[i] != array[i-1])			//when you're different form the num preceding you, you're outside the run
					{
						loc_e = i; 						//when end a run, set local ending to the current index 
						inRun = false; 					//setting inRun to false denotes that we are at the end of the  (...) run 
					}
					
					//check if this is the longest run
					loc_count = loc_e - loc_b; 			//calculate how long this run is by subtracting the ending index from the beginning index of this local run 
					if (loc_count > largest_count)		//determine if this local run is larger than the largest run so far. 
					{
						largest_count = loc_count; 		//if this new run is indeed longer than the preceding runs, then set largest run to this new one. 
						max_b = loc_b;					//set final values for beginning and ending of largest run as well. 
						max_e = loc_e-1; 
					}
				}
			}
			if(!inRun)									//just before a run, need to check if it is going to be a run. 
			{
				if(i != array.length-1)					//this is to make sure that java isn't gonna throw out of bound exception.
				{
					if(array[i] == array[i+1])			//if the current num is the same as the next num, then start run is true. and print ( 
					{
						loc_b = i; 
						inRun = true; 
					}
				}
			}
			
			/*if (i==(array.length-1) && inRun == true)	//taking care of the last digit...if it is still part of the run.  
			{
				loc_e= i; 
				inRun = false; 								//actually this line isn't necessary, but just in case we want to elaborate on this program. it is reset to 0 again.
			}
			*/
			
		}
		//System.out.println();
		//System.out.println("largest count is " + largest_count);
		//System.out.println("it begins from " + max_b + " to " + max_e);
		
		printLongest(max_b, max_e, array);
		
	}
	
	public static void printLongest(int begin, int end, int[] array)
	{
		//**** Print out the final array, marking the longest array 
				for (int i =0; i< array.length; i++)
				{
					if (begin == 0 && i == 0)			//just taking care of the first index, in case this was part of the longest run 
					{ 
						if (end!=0)
							System.out.print("(");
					}
					System.out.print(" "+ array[i]+ " ");		//printing the number of the array out. 
					if (i+1 == begin)		//if the next index is the beginning of the longest run, then first print ( 
					{
						System.out.print("(");
					}
					if (i==end)		//marking the ending of the longest run 
					{
						System.out.print(")");
					}
						
				}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

//****************************************
//  Jessica Gary
//	Java 1004 Fall 2016
//	P 7.1
//  10/27/2016
//
// 	This class, in conjunction with the Die.java class, generates a sequence of 20 random die tosses
//	in an array and prints the die values, marking the runs (a sequence of adjacent repeated values) 
//  by including them in parentheses: 1 2 (5 5) 3 1 2 4 3 (2 2 2 2) 3 6 (5 5) 6 3 1

//  Horstmann, Cay S. (2015-07-07). Big Java: Early Objects, 6th Edition (Page 366). Wiley. Kindle Edition. 
//
//****************************************

public class P71 
{
	public static void main (String[] args)
	{
		 
		Die cube = new Die();								//instantiate object of class Die, borrowed from Cannon
		int [] numtossed = new int[20];						//define an array, set size to 20. 
		for (int i = 0; i<numtossed.length; i++)			//populate the array with the sides of cubes 
		{
			cube.roll();									//roll the cube
			numtossed[i]=cube.getSide(); 					//get the side of the cube and put into the array
		}
	
		printRuns(numtossed);			
		
	}
	
	public static void printRuns(int[] numtossed)			//This method prints all the runs in the array passed to it. 
	{
		boolean inRun = false;
		for (int i =0; i< numtossed.length; i++)
		{
			if(inRun)										//for when we're in the run, but need to check when the run will end. 
			{
				if(i!=0)									//safeguard against outofbound exception
				{
					if(numtossed[i] != numtossed[i-1])		//when you're different form the num preceding you, you're outside the run
					{
						System.out.print(")");				//ending the run by printing (
						inRun = false; 						//setting inRun to false denotes that we are at the end of the  (...) run 
					}
				
				}
			}
			if(!inRun)										//just before a run, need to check if it is going to be a run. 
			{
				if(i != numtossed.length-1)					//this is to make sure that java isn't gonna throw out of bound exception.
				{
					if(numtossed[i] == numtossed[i+1])		//if the current num is the same as the next num, then start run is true. and print ( 
					{
						System.out.print("(");
						inRun = true; 
					}
				}
			}
			System.out.print(" "+ numtossed[i]+ " ");		//printing the number of the array out. 
			
			if (i==(numtossed.length-1) && inRun == true)	//taking care of the last digit. if it is still part of the run, put ) to end it. 
			{
				System.out.print(")");
				inRun = false; 								//actually this line isn't necessary, but just in case we want to elaborate on this program. it is reset to 0 again.
			}
		}
	}
	
	
}

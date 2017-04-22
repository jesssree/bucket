import java.util.LinkedList;

/*
 * Jessica Gary
 * jsg2213
 * COMS 3134 Columbia Spring 2017
 * Homework 2 
 * This class implements a queue using two stacks (needs MyStack.java and the MyQueue.java to compile). 
 * 
 * Implements MyQueue interface: enqueue, dequeue, isEmpty, size; 
 * 
 * The plan:
 * Using two stacks, inStack and outStack 
 * 	- Enqueue into inStack
 * 	- Check if outStack is full --> 
 * 			--> If (!(outStack is full))
 * 					One by One: pop inStack --> push into outStack 
 * 			Once every elements in inStack is pushed into outStack, the outStack's elements are reversed of inStack's 
 * 	- Dequeue from outStack 
 */
public class TwoStackQueue<AnyType> implements MyQueue<AnyType>//generic class 
{
	//TwoStackQueue implements MyQueue interface, so it inherits all the methods from MyQueue, which is implemented below. 
	private LinkedList<AnyType> inStack = new LinkedList<AnyType>(); //stack to enqueue into 
	private LinkedList<AnyType> outStack = new LinkedList<AnyType>(); //stack to dequeue out of
	//Ideally, shouldn't outStack be just a temporary stack? 
		//We should just maintain a queue using one primary stack and a temporary one.
		//This means that when we enqueue everything into the temp stack, we copy over everything into the primary stack
		//again? 
	private int size = 0; //need to keep this since we're working with 2 linkedlists/stacks 
	
	public void enqueue(AnyType x) 
	{
		inStack.push(x);
		size++; //increment the size counter 
		//System.out.println("Added an element in inStack. Size now: " + inStack.size());
	}

	public AnyType dequeue() 
	{
		if (outStack.isEmpty()) //***omg need this condition because in the case where there's stuff in both stacks, want to pop everything from
			//the outStack first (because those were enqueued before) before dipping into the inStack elements 
		{
			while(!inStack.isEmpty()) //keep popping from inStack until it is empty 
			{
				AnyType temp = inStack.pop(); 
				outStack.push(temp);
			}
			//At this end of this loop, elements in outStack is reverse of inStack 
		}
		size--; //decrement the size counter 
		return outStack.pop(); //popping from the outStack 
	}

	public boolean isEmpty() 
	{
		if(size==0)
			return true; 
		else 
			return false; 
	}

	public int size() 
	{
		return size; 
	}
	
}

/*
 * Jessica Gary
 * jsg2213
 * COMS 3134 Columbia Spring 2017
 * Homework 2 
 * 
You will need to write your own stack class for this. 
It should be generic (in this particular case you will be pushing Character objects on it, 
but it should be capable of handling any object reference). Call your stack class: MyStack.java.
You may use java.util.LinkedList as an instance variable in your MyStack class, but in the implementation of your stack methods, 
you are only allowed to use its basic list operations, not the stack operations themselves (that is, do not use LinkedList's native push and pop methods).
 */
import java.util.LinkedList; 

public class MyStack<E> //a generic type E 
{	
	private LinkedList<E> list = new LinkedList<E>();  //generic linked list is instantiated 
	
	public boolean isEmpty()
	{
		return list.isEmpty(); //returns true if the list is empty
	}
	
	//push and pop methods: 
	public void push(E element)
	{
		list.add(element); //add the element to the END of the list/stack 
	}
	public E pop() //removes the TOP element of the stack, so takes no parameter
	{
		//E element = list.get(list.size()-1); //should be getting the LAST element added == the "top" of the stack 
								//since that's the last element added.... --> size()-1 
		E element = list.removeLast(); //removes and returns the last "top" element of this list. 
			//this will throw NoSuchElementException if this list is empty...
		return element; 
	}
	
	
	
	
	
}

 /*Jessica Gary
 * jsg2213
 * COMS 3134 Columbia Spring 2017
 * Homework 2 
 * */

public class TwoStackQueueTester {



    /** This code should output: 
     *  0
     *  Jessica
     *  Michelle
     *  1
     *  2
     *  Bill
     *  1
     *  Michael
     *  0
     *  
     *  0
     *  1
     *  2
     *  3
     *  4
     *  100
     *  3
     *  200
     *  300
     *  400
     *  3000
     *  1
     *  6000
     */
    public static final void main(String[] args) {


	TwoStackQueue<String> q = new TwoStackQueue<String>();
	System.out.println(q.size());

	q.enqueue("Jessica");
	q.enqueue("Michelle");
	q.enqueue("Bill"); 
	
	
	System.out.println(q.dequeue()); //Should print "Jessica" 
	System.out.println(q.dequeue()); //Should print "Michelle" 
	System.out.println(q.size()); //size should be 1 
	
	q.enqueue("Michael"); //now "Micheal" is in inStack and "Bill" is left in outStack 
	System.out.println(q.size()); //size should be 2 
	
	System.out.println(q.dequeue()); //pop from the outStack first (!outStack.isEmpty) --> print "Bill"
	System.out.println(q.size());// size should be 1 ("Michael" is left)
	
	System.out.println(q.dequeue()); //print "Michael"
	System.out.println(q.size()); //zero 
	
	System.out.println("\n");
	/////////////////////////////////////////////
	TwoStackQueue<Integer> r = new TwoStackQueue<Integer>();
	System.out.println(r.size()); //0 
	
	r.enqueue(100);
	System.out.println(r.size());//1
	r.enqueue(200);
	System.out.println(r.size());//2
	r.enqueue(300);
	System.out.println(r.size());//3
	r.enqueue(400);
	System.out.println(r.size());//4
	
	
	System.out.println(r.dequeue());//100
	System.out.println(r.size());//3
	System.out.println(r.dequeue());//200 
	
	r.enqueue(3000); //3000 is in inStack and the rest of the old numbers in the outStack already 
	r.enqueue(6000); //6000 is added into inStack 
	System.out.println(r.dequeue()); //dequeue from the outStack --> printing 300
	System.out.println(r.dequeue()); //400 -->after this, outStack is empty
	System.out.println(r.dequeue()); //because outStack is empty, 3000 and 6000 will be moved into the outStack and popped from there. 
									//this will print: 3000 (now on top of the outStack stack 
	System.out.println(r.size());//1 left (6000)
	System.out.println(r.dequeue()); //6000 
	
	
	/*q.enqueue("Peter");
	q.enqueue("Paul");
	q.enqueue("Mary");
	System.out.println(q.dequeue());
	System.out.println(q.size());
	q.enqueue("Simon");
	q.enqueue("Alvin");
	System.out.println(q.dequeue());
	q.enqueue("Theodore");

	while(!q.isEmpty())
	    System.out.println(q.dequeue());
	    
	*/
	


    }





}
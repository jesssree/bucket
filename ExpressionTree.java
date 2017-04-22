/**
 * /* Jessica Gary
 * jsg2213
 * COMS3134 Columbia 2017
 * 
 * HW3 Programming part 1 
 * 
 * Implement a class called ExpressionTree. 
 * 
 * The constructor to ExpressionTree will take in a String that contains a postfix expression. 
 * The operands will be integers and the binary operators will be restricted to +, -, *, and divide. 
 * Individual tokens, that is the operands and operators, will be delimited by spaces. So for example:
 * 34 2 - 5 *

would mean (34-2)*5.

Contains the following methods:
		eval(); 	 -- evaluates the expression tree
 * 		postfix();	 -- prints the postfix expression of the expression tree
 * 		prefix();	 -- prints the prefix expression of the expression tree
 * 		infix(); 	 -- prints the infix expression of the expression tree
*/
public class ExpressionTree 
{
	MyStack<ExpressionNode> tree = new MyStack<ExpressionNode>();
	ExpressionNode<String> root = null;  //this is set later when the whole tree is finished 
	
	private static class ExpressionNode<T> //nested class within ExpressionTree class, some elements borrowed from Weiss textbook 
	{
		String element; 
		ExpressionNode<String>left; 
		ExpressionNode<String> right; 
		public ExpressionNode(String x)
		{
			element = x; 
			left = null;
			right = null; 
		}
		public ExpressionNode(String x, ExpressionNode<String> lft, ExpressionNode<String> rht)
		{
			element = x; 
			left = lft; 
			right = rht;
		}
		
	}
	public ExpressionTree(String input) //constructor constructs the tree 
	{
		//The constructor takes in an input that is a post-fix expression 
		
		String[] element = input.split(" "); //split the string by spaces
											//individual tokens (operands and operators) are delimited by spaces ... 
	 
		//Populate the tree: 
		/*
		 * Read in each string(char) in the array "element"
		 * If the string is a number (!operator +, -, *, or divide) 
		 * 			--> create an ExpressionNode object and populate the data field with the string(char) which will later be converted to an int when eval() is called. 
		 * 			--> push the newly made ExpressionNode onto the stack
		 * If the string is an operator (else statement below) 
		 * 			--> create an ExpressionNode object and populate the data field with the string(char) which is an operator 
		 * 			--> pop 2 ExpressionNodes off of the stack and put them into temporary "rightchild" and "leftchild" ExpressionNodes 
		 * 			--> create a new ExpressionNode object to hold the operator
		 * 			--> populate the operator node's left and right subtrees with "leftchild" and "rightchild" ExpressionNodes 
		 * 			--> push the new operator ExpressionNode onto the stack/tree --> a new subtree is made 
		 */
		for(int i=0; i<element.length; i++)
		{
			if(!element[i].equals("*") && !element[i].equals("/") && !element[i].equals("+") && !element[i].equals("-"))
			{
				//if the token from the string is NOT an operator, then push the number onto the stack
				
				//create an ExpressionNode 
				ExpressionNode<String> temp = new ExpressionNode<String>(element[i]);
				tree.push(temp);	
				//System.out.println(element[i]); 
			}
			else 
			{
				//if the token is an operator, pop 2 ExpressionNodes off of the stack (tree) 
				
				//System.out.println(element[i]); 
			
				ExpressionNode<String> rightchild = tree.pop();  //pop the top of the stack, became the right child of the operator
				ExpressionNode<String> leftchild = tree.pop(); //pop the next top of the stack, became the left child of the operator
				ExpressionNode<String> newroot_operator = new ExpressionNode<String>(element[i], leftchild, rightchild);  //the operator became the parent of the two numbers 
				
				tree.push(newroot_operator); //push the new node (an single node, or a subtree with all of its attachments) 
			
				//So, the root might be "+", with its left node be "1" and the right node will be "7" 
				
				
				//System.out.println("Root: " + newroot_operator.element + "  --Left = " +  newroot_operator.left.element + " --right = " + newroot_operator.right.element);
				
				//int temp1 = Integer.parseInt(basket.pop());
				//int temp2 = Integer.parseInt(basket.pop()); //the value popped is a String, so convert String-->Integer so that it can be operated on 
				//operate(temp1, temp2, element[i]);
			}
			
		}
		
		
		root = tree.peek(); //set up the root of the tree to the first element in the stack (did not remove it from the stack).
		
	}
	
	public int eval()
	{
		//recursive method 
		//call another private method called eval(root)
		return eval(root);  
	}
	private int eval(ExpressionNode<String> root)
	{
		if(root == null) //it is an empty tree, return 0 (nothing to evaluate)
			return 0;
		
		if(root.left == null && root.right == null) 
			return Integer.parseInt(root.element);  //this means that the root is the only node in the tree 
		
		//evaluates the left subtree first, then the right subtree. Then both of the values will be operated on. 
		int lefttree_value = eval(root.left); //recursive call
		int righttree_value = eval(root.right); //recursive call 
		
		//operation is limited to these 4: +, -, *, and divide / 
		//determine which operator we're dealing with and calculate based on the match 
		if(root.element.equals("+"))
				return (lefttree_value + righttree_value);
		else if(root.element.equals("-"))
				return (lefttree_value - righttree_value);
		else if(root.element.equals("*"))
				return (lefttree_value * righttree_value); 
		else //(root.element.equals("/"))
				return (lefttree_value / righttree_value); 
		
	}
	
	public void postfix()
	{
		post(root); //calling a private recursive method 
		System.out.println();
	}
	public void prefix()
	{
		pre(root); //calling a private recursive method 
		System.out.println();
	}
	public void infix()
	{
		in(root); //calling a private recursive method 
		System.out.println();
	}
	private void post(ExpressionNode<String> root)
	{
		if(root!= null)
		{
			post(root.left);//visit the left subtree
			post(root.right); //visit the right subtree -- and print everything in it 
			System.out.print(root.element+ " "); 
		}
	}
	private void pre(ExpressionNode<String> root)
	{
		if(root!=null)
		{
			System.out.print(root.element+ " ");//print the node first then the left and right subtree 
			pre(root.left);
			pre(root.right); 
		}
	}
	private void in(ExpressionNode<String> root)
	{
		if(root!=null)
		{
			//print left subtree first, print the node, then the right subtree 
			in(root.left); 
			System.out.print(root.element+ " ");
			in(root.right); 
		}
	}
	
	
}





















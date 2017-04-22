/* Jessica Gary
 * jsg2213
 * COMS3134 Columbia 2017
 * 
 * HW3 Programming part 1 
 * 
 * This is a Tester class for ExpressionTree.java class, which is implemented using MyStack.java 
 * 
 * Instantiates an expression tree on a hard coded string representing a postfix expression tree,
 * Demonstrate the following methods:
 * 		eval(); 	 -- evaluates the expression tree
 * 		postfix();	 -- prints the postfix expression of the expression tree
 * 		prefix();	 -- prints the prefix expression of the expression tree
 * 		infix(); 	 -- prints the infix expression of the expression tree
 * */
public class Problem1
{
	public static void main(String[] args) 
	{
		try{
			ExpressionTree newtree = new ExpressionTree("1 2 + 7 *");
			int temp = newtree.eval(); 
			System.out.println("The tree evaluates to: " + temp);
			
			//System.out.println(newtree.postfix()); 
			System.out.print("The postfix expression of the tree is: "); 
			newtree.postfix(); // 1 2 + 7 * 
			System.out.print("The prefix expression of the tree is: "); 
			newtree.prefix(); // * + 1 2 7 
			System.out.print("The infix expression of the tree is: "); 
			newtree.infix(); //1 + 2 * 7 
		}
		catch(NumberFormatException e)
		{
			System.out.println(e.getMessage()); 
			e.printStackTrace();
		}
	}
}

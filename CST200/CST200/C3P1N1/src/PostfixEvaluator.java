/**
 * 
 * @author Doctor Pham
 *
 */
import java.util.Stack;
import java.util.Scanner;

public class PostfixEvaluator
{
	private final static char ADD = '+';
	private final static char SUBTRACT = '-';
	private final static char MULTIPLY = '*';
	private final static char DIVIDE = '/';
	private Stack<Integer> stack; //Declare stack as a Stack of type int
	
	/**
	 * Some more comments
	 */
	
	public PostfixEvaluator() //Constructor
	{
		stack = new Stack<Integer>(); //Instantiates stack object
	}//Close constructor
	
	/**
	 * Some more comments
	 * 
	 */
	
	public int evaluate(String expr) //method evaluate
	{
		int op1, op2, result = 0;
		String token;
		Scanner parser = new Scanner(expr);
		
		/**
		 * The while loop uses .hasNext() to check for tokens
		 * It pops out the 2 integers
		 * and then it uses the operator charactor to operate on them
		 * the result gets pushed back onto the stack
		 */
		while(parser.hasNext()) //examine the tokens of input string
		{
			token = parser.next(); //next parsed is passed into token
			if(isOperator(token)) // If it is an operator...
			{
				op2 = (stack.pop()).intValue();//op2 is popped out as an int
				op1 = (stack.pop()).intValue();//op1 is popped out as an int
				//Together, op1, op2, and token are passed into evaluateS...
				result = evaluateSingleOperator(token.charAt(0),op1,op2);
				//The result comes back and gets pushed into the stack as an int
				stack.push(new Integer(result));						
			}
			else //token is not an operator
				stack.push(new Integer(Integer.parseInt(token)));
				//convert to int while pushing it onto the stack
		}
		return(result); //method is to return an int back to caller
	}//Close method eval....
	
	/**
	 * Some comments
	 * 
	 */
	
	private boolean isOperator(String token)
	{
		//return true/false if token is any of the character
		//of interest
		return(token.equals("+") || token.equals("-") 
				|| token.equals("*") || token.equals("/"));
	}//Close method is...
	
	/**
	 * Some comments
	 * 
	 */
	
	private int evaluateSingleOperator(char operation, int op1, int op2)
	{
		//method to compute operands using input operator
		int result = 0;
		switch(operation)
		{
			case ADD:
			        result = (op1 + op2);
			        break;
			case SUBTRACT:
		                 result = (op1 - op2);
		                 break;
			case MULTIPLY:
		                 result = (op1 * op2);
		                 break;
			case DIVIDE:
		               result = (op1 / op2);
		               break;
		}
		return(result); //The method must return an int back to caller
	}//Close method eval...	
}//Close class

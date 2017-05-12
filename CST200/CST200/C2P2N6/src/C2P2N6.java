/**
 * 
 * 
 * Demonstrate the use of stack to evaluate
 * postfix expressions
 * 
 *  
 * @author Doctor Pham
 *
 */
import java.util.Scanner;


public class C2P2N6
{
	private final static char ADD = '+';
	private final static char SUBTRACT = '-';
	private final static char MULTIPLY = '*';
	private final static char DIVIDE = '/';
	private final static char POWER = '^';
	private final static char LEFT_P = '(';
	private final static char RIGHT_P = ')';
	private final static char LOGARITHM = 'l';
	private static int[] result1 = new int[100];
	private static int[] result2 = new int[100];
	private static int[] result3 = new int[100];
	private static int[] result4 = new int[100];
	/**
	 * Reads and evaluates multiple postfix expressions
	 * 
	 */
	
	public static void main(String[] args)
	{
		String expression, again, lb, ub;
		int result, counter2 = 0;
		
		Scanner in = new Scanner(System.in);
		Scanner lower = new Scanner(System.in);
		Scanner upper = new Scanner(System.in);
		
		for(counter2 = 0; counter2 < 100; counter2++)
		{
			result1[counter2] = 0;
			result2[counter2] = 0;
			result3[counter2] = 0;
			result4[counter2] = 0;
		}
		
		do
		{			
			System.out.println("Enter a valid function f(n), "
					+ "where n is mapped into a valid function.  "
					+ "Use parentheses ( ) to separate multiple functions.  "
					+ "(Example: f(n) = ( 2 ^ n ) * ( log n ))");
			
			System.out.println("f(n)= ");
			expression = in.nextLine();
			System.out.println("from n = ");
			lb = lower.nextLine();
			System.out.println("to n = ");
			ub = upper.nextLine();
			evaluate(expression,ub);
			System.out.println();
			System.out.println("That expression equals: " );
			for(counter2 = 0; counter2 < Integer.parseInt(ub); counter2++)
			{
				System.out.println(result1[counter2]);
			}
			System.out.print("Evaluate another expression [Y/N]? ");
			again = in.nextLine();
			System.out.println();			
		}while(again.equalsIgnoreCase("y"));
		in.close();  //Should close input stream when done
		upper.close(); //Should close input stream when done
	}//Close main()
	
	public static void evaluate(String expr, String ucase) //method evaluate
	{
		int op1 = 0;
		int op2, result = 0;
		int counter = 0;		
		String token,functions;
		Scanner parser = new Scanner(expr);
		
		/**
		 * The while loop uses .hasNext() to check for tokens
		 * It pops out the 2 integers
		 * and then it uses the operator charactor to operate on them
		 * the result gets pushed back onto the stack
		 */
		
		while(parser.hasNext())    //examine the tokens of input string
		{                          //for the entire string.
			token = parser.next(); //next parsed is passed into token
			
			if(isLogarithm(token))
			{
			
			}
			
			if(isLeftParenthesis(token))
			{
				token = parser.next(); //next parsed is passed into token
				while(!isRightParenthesis(token)) // process things in between
				{					
					if(isOperator(token)) // If it is an operator...
					{						
						functions = token;
						token = parser.next();//They always go in pair
						op2 = Integer.parseInt(token);
						//Together, op1, op2, and token are passed into evaluateS...
						for(counter = 0; counter < Integer.parseInt(ucase); counter++)
						{
							result1[counter] = evaluateSingleOperator(functions.charAt(0),op1,counter);
							//The result comes back and gets pushed into the stack as an int
						}
					}
					else //token is not an operator
					{
						op1 = Integer.parseInt(token);						
					}
					token = parser.next(); //Get next char/string/etc...						
				}//right_p detected, get out
			}//Check for left_p
			
			token = parser.next(); //Get next char/string/etc..
			if(isOperator(token)) // If it is an operator...
			{
				
			}
			
		}//Close while (.hasNext())		
	}//Close method eval....
	
	
	
	private static boolean isOperator(String token)
	{
		//return true/false if token is any of the character
		//of interest
		return(token.equals("+") || token.equals("-") 
				|| token.equals("*") || token.equals("/") || token.equals("^"));
	}//Close method is...
	
	private static boolean isLeftParenthesis(String token)
	{
		//return true/false if token is any of the character
		//of interest
		return(token.equals("("));
	}//Close method isLeft...
	
	private static boolean isRightParenthesis(String token)
	{
		//return true/false if token is any of the character
		//of interest
		return(token.equals(")"));
	}//Close method isRight...
	
	private boolean isLogarithm(String token)
	{
		//return true/false if token is any of the character
		//of interest
		return(token.equals("log")); //This is meant to be log base-2
	}//Close method isLog...	
	
	private static int evaluateSingleOperator(char operation, int op1, int op2)
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
			case POWER:
	               result = (int) Math.pow(op1, op2);
	               break;
			case LOGARITHM:
				          result = (int) (Math.log(op1) / Math.log(2));
				          break;
		}
		return(result); //The method must return an int back to caller
	}//Close method eval...	
}//Close class

	
	

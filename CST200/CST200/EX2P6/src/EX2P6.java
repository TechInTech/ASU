import java.util.Scanner;


public class EX2P6
{
	private static double[] result1 = new double[100];
	private static double[] result2 = new double[100];
	private static double[] result3 = new double[100];
	private static double[] result4 = new double[100];
	
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
			result1[counter2] = 0.0;
			result2[counter2] = 0.0;
			result3[counter2] = 0.0;
			result4[counter2] = 0.0;
		}
		
		do
		{			
			System.out.println("****Growth function menu****");
			System.out.println("Enter 1 for function  t(n) = 17");
			System.out.println("Enter 2 for function  t(n) = 3log_base_2(n)");
			System.out.println("Enter 3 for function  t(n) = 20n - 4");
			System.out.println("Enter 4 for function  t(n) = (12n)log_base_2(n) + 100n");
			System.out.println("Enter 5 for function  t(n) = (3n^2) + 5n - 2");
			System.out.println("Enter 6 for function  t(n) = (8n^3) + (3n^2)");
			System.out.println("Enter 7 for function  t(n) = (2^n)+(18n^2)+(3n)");
			System.out.print("Please enter your choice: ");
			expression = in.nextLine();			
			System.out.print("For n = 0 to: ");
			ub = upper.nextLine();
			evaluate(expression,ub);
			System.out.println();
			System.out.println("That expression equals: " );
			System.out.println("n\t  t(n)");
			for(counter2 = 0; counter2 < Integer.parseInt(ub); counter2++)
			{
				System.out.printf("%d\t%.3f%n",(counter2+1),result1[counter2]);
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
		int op2 = 0;
		int op3 = 0;
		int counter = 0;		
		
		
		/**
		 * The while loop uses .hasNext() to check for tokens
		 * It pops out the 2 integers
		 * and then it uses the operator charactor to operate on them
		 * the result gets pushed back onto the stack
		 */
		
		op2 = Integer.parseInt(expr);
		op3 = Integer.parseInt(ucase);
		
		switch(op2)
		{
			case 1:
				   for(counter = 0; counter < op3; counter++)
				   {
					   result1[counter] = 17.0;
				   }
			       break;
			case 2:
				   for(counter = 0; counter < op3; counter++)
				   {
					   result1[counter] = ((3.0) * (Math.log(counter+1) / Math.log(2.0)));
				   }
		           break;
			case 3:
				   for(counter = 0; counter < op3; counter++)
				   {
					   result1[counter] = (((20.0) * (counter+1)) - 4.0);
				   }
		           break;
			case 4:
				   for(counter = 0; counter < op3; counter++)
				   {
					   result1[counter] = (((12.0) * (counter+1)) * (Math.log(counter+1) / Math.log(2.0))) + (100.0 * (counter+1));
				   }
		          break;
			case 5:
				   for(counter = 0; counter < op3; counter++)
				   {
					   result1[counter] = (((3.0) * Math.pow(counter,2.0)) + (5.0 * counter) - 2.0);
				   }
	               break;
			case 6:
				   for(counter = 0; counter < op3; counter++)
				   {
					   result1[counter] = (((8.0) * Math.pow(counter,3.0)) + ((3.0) * Math.pow(counter,2.0)));
				   }
				  break;
			case 7:
				   for(counter = 0; counter < op3; counter++)
				   {
					   result1[counter] = ((Math.pow(2.0,counter)) + ((18.0) * Math.pow(counter,2.0)) + (3.0 * counter));
				   }
				  break;
		}//Close case/switch		
	}//Close evaluate
}//Close class


import java.util.Random;  //Random class is needed

public class RandomNumbers
{
	//------------------------------------------------------
	////Write code to declare and instantiate an object of
	//the Random class (call the object reference variable rand).
	//Then write a list of expressions using the nextInt method
	//that generates random numbers in the following specified
	//ranges, including the endpoints. Use the version of the
	//nextInt method that accepts a single integer parameter.
	//------------------------------------------------------
	
	public static void main(String[] args)
	{
		Random generator = new Random();
		int num1;
		float num2;
		
		num1 = generator.nextInt();
		System.out.println("A random integer: " + num1);
		
		num1 = generator.nextInt(10);
		System.out.println("From 0 to 9: " + num1);
		
		num1 = generator.nextInt(15) + 20;
		System.out.println("From 20 to 34: " + num1);
		
		num1 = generator.nextInt(20) - 10;
		System.out.println("From -10 to 9: " + num1);
		
		num2 = generator.nextFloat();
		System.out.println("A random float (between 0 and 1): " + num2);
		
		num2 = generator.nextFloat() * 6; // 0.0 to 5.999999
		num1 = (int) num2 + 1;
		System.out.println("From 1 to 6: " + num1);
		
		
		
	}
	
	
}
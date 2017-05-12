import java.util.Scanner;       //Needed this class for input
import java.text.DecimalFormat; //Needed to format numbers to pattern


public class Part3
{
	public static void main(String[] args)
	{
		double numb1, numb2; //numb1 is raw data, numb2 is (numb1^4)
							 
		
		Scanner scan = new Scanner(System.in); //Create scan object
											   //to get input
		
		System.out.print("Enter a double precision number: "); //Prompt
		numb1 = scan.nextDouble(); //Get the keyboard input of double type
		
		numb2 = Math.pow(numb1, 4); //Raised to the 4th power and stored in numb2
		
		DecimalFormat fmt1 = new DecimalFormat("0.###");
		//fmt1 is an instance of DecimalFormat class
		//fmt1 created with pattern for 3 decimal places.
		
		System.out.println("The result is: " + fmt1.format(numb2));
		//Prints out the formatted result
	}
	

}
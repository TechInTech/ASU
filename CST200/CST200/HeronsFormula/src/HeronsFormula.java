import java.util.Scanner;		//Needed this class for input
import java.text.DecimalFormat; //Needed to format numbers to pattern

public class HeronsFormula
{
	//------------------------------------------------------
	//Write an application that reads the (x,y) coordinates for
	//two points. Compute the distance between the two points 
	//using the following formula:
	//
	//          Area = srqt(s((s - a)(s - b)(s - c)))
	//
	//------------------------------------------------------
	
	public static void main(String[] args)
	{
		double a=0.0,b=0.0,c=0.0,s=0.0,area=0.0;
		//variables for calculating distance of 2 points
		
		DecimalFormat fmt1 = new DecimalFormat("0.###");
		
		Scanner scan = new Scanner(System.in);//Keyboard input
		
		System.out.print("Enter side a: ");
		a = scan.nextDouble();
		System.out.print("Enter side b: ");
		b = scan.nextDouble();		
		System.out.print("Enter side c: ");
		c = scan.nextDouble();
		
		s = ((a + b + c) / 2.0); //First to find s
		area = Math.sqrt(s*((s-a)*(s-b)*(s-c))); //Apply the Heron's formula
						
		System.out.println("The area is: " + fmt1.format(area) + " units");
		//Prints out		
	}
}
import java.util.Scanner;
import java.text.DecimalFormat;

public class CircleStats
{
	//------------------------------------------------------
	//Demonstrates the use of Scanner class and its methods.
	//Calculate final price using values entered by human.
	//------------------------------------------------------
	
	public static void main(String[] args)
	{
		int radius;
		double area, circumference;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the circle's radius: ");
		radius = scan.nextInt();
		
		area = Math.PI * Math.pow(radius, 2);
		circumference = 2 * Math.PI * radius;
		
		//Round the output to 3 decimal places
		
		DecimalFormat fmt1 = new DecimalFormat("0.###");
				
		System.out.println("The circle's area: " + fmt1.format(area));
		System.out.println("The circle's circumference: " 
				+ fmt1.format(circumference));		
	}
}

import java.util.Scanner;		//Needed this class for input
import java.text.DecimalFormat; //Needed to format numbers to pattern

public class Distance
{
	//------------------------------------------------------
	//Write an application that reads the (x,y) coordinates for
	//two points. Compute the distance between the two points 
	//using the following formula:
	//
	//          Distance = srqt((x2 - x1)^2 + (y2 - y1)^2)
	//
	//------------------------------------------------------
	
	public static void main(String[] args)
	{
		double x1=0.0,x2=0.0,y1=0.0,y2=0.0,distance=0.0;
		//variables for calculating distance of 2 points
		
		DecimalFormat fmt1 = new DecimalFormat("0.###");
		
		Scanner scan = new Scanner(System.in);//Keyboard input
		
		System.out.print("Enter x1: ");
		x1 = scan.nextDouble();
		System.out.print("Enter y1: ");
		y1 = scan.nextDouble();
		
		System.out.print("Enter x2: ");
		x2 = scan.nextDouble();
		System.out.print("Enter y2: ");
		y2 = scan.nextDouble();		
		
				
		distance = Math.sqrt((Math.pow((x2 - x1), 2)) + (Math.pow((y2 - y1), 2)));
		//      Distance = srqt((x2 - x1)^2 + (y2 - y1)^2)
		//      Assuming serious data entries
		
		System.out.println("The distance is: " + fmt1.format(distance) + " units");
				
	}
}
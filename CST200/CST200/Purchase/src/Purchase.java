import java.util.Scanner;
import java.text.NumberFormat;

public class Purchase
{
	//------------------------------------------------------
	//Demonstrates the use of Scanner class and its methods.
	//Calculate final price using values entered by human.
	//------------------------------------------------------
	
	public static void main(String[] args)
	{
		final double TAX_RATE = 0.06;
		int quantity;
		double subtotal, tax, totalCost, unitPrice;
		
		Scanner scan = new Scanner(System.in);
		
		NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
		NumberFormat fmt2 = NumberFormat.getPercentInstance();
		
		System.out.print("Enter the quantity: ");
		quantity = scan.nextInt();
		
		System.out.print("Enter the unit price: ");
		unitPrice = scan.nextDouble();
		
		subtotal = quantity * unitPrice;
		tax = subtotal * TAX_RATE;
		totalCost = subtotal + tax;
		
		
		System.out.println("Subtotal: " + fmt1.format(subtotal));
		System.out.println("Tax: " + fmt1.format(tax) + " at "
				+ fmt2.format(TAX_RATE));
		
		System.out.println("Total: " + fmt1.format(totalCost));
				
	}
}

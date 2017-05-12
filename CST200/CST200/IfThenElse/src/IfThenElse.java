
public class IfThenElse
{
		
	public static void main(String[] args)
	{
		int money, dollars = 0, cents = 0;
		String listing="DumamayAndrew";
		
		//String prefix = listing.front(5);
		//String prefix = listing.front(5);
		String prefix = listing.substring(0,5);
		//String strx = "o";
		int num1, num2;
		char chr3 = 'P';
		boolean onsale;
		
		onsale= false;
		
		num1 = 27;
		num2 = 15;
		
		if (num1 >= 30)
			System.out.println("black");
		
		if(num2 < 17 && num1 >=25)
			System.out.println("blue");
		
		if(chr3 == 'P')
		{
			System.out.println("bluff");
			System.out.println("bleef");
		}
		
		if(num1==27)
		{
			if(onsale == true)
				System.out.println("orange");
		}
		else
			System.out.println("brown");
		
		
	    System.out.println(prefix.toUpperCase());	
	}
}

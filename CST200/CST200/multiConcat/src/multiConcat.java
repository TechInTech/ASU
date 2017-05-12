import com.google.common.base.Strings;
import java.util.*;
import java.lang.*;

public class multiConcat
{
	public static void main(String[] args)
	{
		int[] primes = {2, 3, 4, 5, 7, 11};
		float elapsedTimes[] = {(float) 11.47, (float) 12.04, (float) 11.72, (float) 13.88};
		int[] scores = new int[30];
		int[] primess = {2, 3, 5, 7, 11};
		int[] scoress = new int[30];
		char gradess[] = {'a', 'b', 'c', 'd', 'f'};
		char[] grades = new char[8];
		
		int[] numbers = {3, 2, 3, 6, 9, 10, 12, 32, 3, 12, 6};
		//for (int count = 1; count <= numbers.length; count++)
			//System.out.println (numbers[count]);

		for (int count : numbers)
			System.out.println (count);

		String testit=MultiConcat("Hello",7);
		String testit2=MultiConcat("Java");
		
		System.out.printf("%s\n",testit);
		System.out.printf("%s\n",testit2);
		
	}
	
	public static String MultiConcat(String s, int counts)
	{
		String NewString="";
		if(counts < 2)
		{
			return s;
		}
		else
		{
			NewString = Strings.repeat(s,counts);
			return(NewString);
		}
	}
	
	public static String MultiConcat(String s)
	{
		String NewString="";
		
		NewString = Strings.repeat(s,2);
		return(NewString);		
	}
}


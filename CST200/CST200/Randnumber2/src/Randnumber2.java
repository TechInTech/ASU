import java.util.Random;  //Random class is needed

public class Randnumber2
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
		Random rand = new Random(); //object reference variable rand
		
		int numb1 = 0,numb2 = 0,numb3 = 0; //first 3 digits
		int numb4 = 0,numb5 = 0,numb6 = 0; //second group of 3 digits
		int numb7 = 0,numb8 = 0,numb9 = 0,numb10 = 0;//last group of 4 digits
		int groupsum = 742; //Preset groupsum for while loop
		
		//Generate the first 3 digits separately
		//Each digit goes from 1 to 7 to exclude 8 or 9
		numb1 = rand.nextInt(7) + 1; //First digit
		numb2 = rand.nextInt(7) + 1; //Second digit
		numb3 = rand.nextInt(7) + 1; //Third digit
		
		//Generate the second 3 digits separately
		//Each digit goes from 1 to 9
		//The sum must not exceed 742
		//Right now groupsum is 742. Loop
		//until this condition becomes false
		while(groupsum >= 742)
		{
			numb4 = rand.nextInt(10); //Fourth digit
			numb5 = rand.nextInt(10); //Fifth digit
			numb6 = rand.nextInt(10); //Sixth digit
			
			groupsum = ((numb4 * 100) + (numb5 * 10) + numb6);		
		}
		
		//Generate the last 4 digits separately
		//Each digit goes from 0 to 9 inclusively
		numb7 = rand.nextInt(10); //Seventh digit
		numb8 = rand.nextInt(10); //Eighth digit
		numb9 = rand.nextInt(10); //Ninth digit
		numb10 = rand.nextInt(10); //Tenth digit
				
		System.out.println("The 10-digit phone number is => " + numb1 + numb2 + numb3
				+ "-" + numb4 + numb5 + numb6 + "-"
				+ numb7 + numb8 + numb9 + numb10);	//Print out	
		
	}
	
	
}
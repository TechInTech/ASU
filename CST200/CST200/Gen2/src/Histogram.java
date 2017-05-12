import java.io.File;
import java.util.Scanner;

public class Histogram
{
	
	public int[] readIntArrayFromFile(String fileName) throws Exception
	{
		Scanner fileScan  = new Scanner(new File(fileName));
	    int counter = 0;	    

	    while(fileScan.hasNextInt())// Read the integer input from the file	
	    {							//as long as it still has the next integer	
	    	fileScan.nextInt();     //read that integer	and then
	    	counter++;              //increment the counter	
	    							//Which will be used for the array size
	    }
	    fileScan.close();           // Done with reading the file stream
	    
	    int[] iArray   = new int[counter]; //Now make the integer array
	    Scanner fScan  = new Scanner(new File(fileName));
	    
	    //Now, with the integer elements known, read the file and store
	    //the integer into the array just built.
	    for(int i = 0; i < counter; ++i)
	    {
	    	iArray[i] = fScan.nextInt();
	    }
	    fScan.close();//Close the file stream
	    
	    return(iArray);//Return the array to the caller
	}

}
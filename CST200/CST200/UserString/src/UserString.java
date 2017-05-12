//********************************************************************
//  TestData.java       Author: Lewis/Loftus
//
//  Demonstrates I/O exceptions and the use of a character file
//  output stream.
//********************************************************************

//****************************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 02/16/2015
//
//PP 10.6 Write a program that reads strings from the user and writes them 
//to an output file called userStrings.dat. Terminate pro- cessing when the
//user enters the string "DONE". Do not write the sentinel string to the 
//output file. 
//Most of the work was based on Lewis example.
//****************************************************************
import java.util.Scanner;
import java.io.*;

public class UserString
{
   //-----------------------------------------------------------------
   //  Creates a file of test data that consists of ten lines each
   //  containing ten integer values in the range 10 to 99.
   //-----------------------------------------------------------------
   public static void main (String[] args) throws IOException
   {      
      String file = "userStrings.dat";
      String code;
      Scanner scan = new Scanner (System.in);

      FileWriter fw = new FileWriter(file);//Inherited from the author.
      BufferedWriter bw = new BufferedWriter(fw);//Inherited from the author.
      PrintWriter outFile = new PrintWriter(bw);//Inherited from the author.
      //Basically bw contains fw, and outFile contains bw, hence buffering.

      System.out.print ("Enter product code (DONE to quit): ");
      code = scan.nextLine();
      
      while (!code.equals ("DONE"))
      {
    	  if(!code.equals ("DONE"))//Don't write the sentinel
    	  {
    		  	outFile.print(code); //Store the user string		
    	  		outFile.println();//Adds a new line
    	  }
    	  System.out.print ("Enter product code (DONE to quit): ");
          code = scan.nextLine();   //Continue   		
      }
      outFile.close();//Close the output file
      System.out.println ("Output file has been created: " + file);
   }
}

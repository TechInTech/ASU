//-----------------------------------------------------------------
//  Used Lewis' CountFlips program with minimal modification
//-----------------------------------------------------------------

public class CountFlips
{
	public static void main (String[] args)
	   {
	      final int FLIPS = 1000;
	      int heads = 0, tails = 0;
	      
	      Coin myCoin = new Coin();
	      

	      for (int count=1; count <= FLIPS; count++)
	      {
	         myCoin.flip();

	         if (myCoin.isHeads() == coinstate.head)
	            heads++;
	         else
	            tails++;
	      }

	      System.out.println ("Number of flips: " + FLIPS);
	      System.out.println ("Number of heads: " + heads);
	      System.out.println ("Number of tails: " + tails);
	      //Added println() below to print out myCoin object
	      //and its boolean state, HQP, 01/31/2015
	      
	      System.out.println (myCoin);
	   }
}

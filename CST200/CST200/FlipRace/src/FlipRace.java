//-----------------------------------------------------------------
//  Used Lewis' FlipRace program with minimal modification
//-----------------------------------------------------------------
public class FlipRace
{
	public static void main (String[] args)
	{
	      final int GOAL = 3;
	      int count1 = 0, count2 = 0;
	      Coin coin1 = new Coin(), coin2 = new Coin();

	      while (count1 < GOAL && count2 < GOAL)
	      {
	         coin1.flip();
	         coin2.flip();

	         System.out.println ("Coin 1: " + coin1 + "\tCoin 2: " + coin2);

	         //Increment or reset the counters
	         count1 = (coin1.isHeads() == coinstate.head) ? count1+1 : 0;
	         count2 = (coin2.isHeads() == coinstate.head) ? count2+1 : 0;
	      }

	      if (count1 < GOAL)
	      {
	         System.out.println ("Coin 2 Wins!");
	      }
	      else
	      {
	         if (count2 < GOAL)
	            System.out.println ("Coin 1 Wins!");
	         else
	            System.out.println ("It's a TIE!");
	      }
	      //Revised to group the if/else block  logically
	      //so I can do the println() lines below
	      
	      System.out.println(coin1);
	      System.out.println(coin2);
	}
}

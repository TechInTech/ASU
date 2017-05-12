//*********************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 01/31/2015
//
//Revise the Coin class such that its state is represented
//internally using a boolean variable. Test the new versions
//of the class as part of the CountFlips and FlipRace 
//programs.
//
//**********************************************************

enum coinstate{head, tail}

public class Coin
{
   //private final int HEADS = 0;  // tails is 1
   // HEADS is not used at after the mod,
   //so I commented it out.
   private boolean flips;
   private coinstate face;
   //Revised right here, HQP 01/31/2015
   //Changed from int to boolean type.
   
   //-----------------------------------------------------------------
   //  Sets up this coin by flipping it initially.
   //-----------------------------------------------------------------
   public Coin()
   {
      flip();
   }

   //-----------------------------------------------------------------
   //  Flips this coin by randomly choosing a face value.
   //-----------------------------------------------------------------
   public void flip ()
   {
	   
	   flips = ((int)(Math.random() * 2) != 0);
	   
	   //Forced/type-casting into a boolean evaluation here.
	   //HQP, 01/31/2015
   }

   //-----------------------------------------------------------------
   //  Returns true if the current face of this coin is heads.
   //-----------------------------------------------------------------
   public coinstate isHeads()
   {
      if(flips == true)
      {
    	  face = coinstate.tail;
      }
      else
      {
    	  face = coinstate.head;
      }
	   return(face); //Changed this to return the state
      //the boolean value of face, HQP 01/31/2015
   }

   //-----------------------------------------------------------------
   //  Returns the current face of this coin as a string.
   //-----------------------------------------------------------------
   public String toString()
   {
      return (face == coinstate.head) ? "Heads" : "Tails";
      //Changed to judge face based on its boolean state
      //HEADS = 0, and 0 is not true
      //HQP, 01/21/2015
   }
}
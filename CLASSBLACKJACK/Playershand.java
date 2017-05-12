//These are distributed packages holding exceptions
//and other data structures such as ArraySet, SetADT
//required throughout the game.
import jss2.*;
import jss2.exceptions.*;
import java.util.*;

public class Playershand
{
  protected ArraySet<Card> ThePlayershand;
  protected int Playershandvalue,count;  

/**********************************************************
     Constructor
**********************************************************/
  public Playershand()
  {
    ThePlayershand = new ArraySet<Card>(12);
    Playershandvalue=0;
    count =0;
  }//Close constructor

/**********************************************************
     Adding logic to drawing new card when there was an ace
	in the Playershand.
     @param newCard random card from the set
**********************************************************/
  private void reducePlayershand(Card newCard)
  {
      if((Playershandvalue) > 21)
      {
         if(aceThePlayershand())
           Playershandvalue -= 10;          
      }
  }//Close reducePlayershand()

/**********************************************************
     Checking whether there is an ace in the Playershand.
**********************************************************/
  private boolean aceThePlayershand()
  {
    boolean result = false;
    Card cardchk = null;
    Iterator<Card> scan = ThePlayershand.iterator();

    while (scan.hasNext() && !result)
    {
       cardchk = scan.next();
       if(cardchk.getvalue() == 11)
       {
         cardchk.setvalue(1);
         result = true;
       }
      
    }
    return(result);
  }//Close
 
/**********************************************************
     Adding a new card to the Playershand.
     @param currentdeck the Deck the game is currently playing
	 with
**********************************************************/
  public Card newCard(Deck currentdeck)
  {
     Card result;
     result = currentdeck.getCard();
     ThePlayershand.add(result);  
     Playershandvalue+=result.getvalue(); 
     reducePlayershand(result);
     count++;
       
     return(result);
  }//Close


/**********************************************************
     Returns this Playershand's value.
**********************************************************/
  public int getPlayershandValue()
  {
    return(Playershandvalue);
  }//Close

/**********************************************************
     Iterator over this Playershand.
**********************************************************/
  public Iterator<Card> iterator()
  {
    return(ThePlayershand.iterator());
  }//Close Iterator()

/**********************************************************
     Removes a card from this Playershand.
**********************************************************/
  public Card remove(Card crd) throws ElementNotFoundException
  {
     return(ThePlayershand.remove(crd));
  }//Close remove()

/**********************************************************
     Returns a string representation of this Playershand. 
**********************************************************/
  public String toString()
  {
    String result="";

    Card cardstr = null;
    int i=0;
    Iterator<Card> scan = ThePlayershand.iterator();
    while (scan.hasNext())
    {
       cardstr= scan.next();
       result += "card"+i+": "+cardstr.getvalue()+"\n";
       i++;
    }

    return(result);
  }//Close toString()
}//Close Playershand

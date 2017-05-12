
import jss2.*;
import jss2.exceptions.*;

import java.util.*;

public class Playershand
{
  protected ArraySet<Card> ThePlayershand;
  protected int Playershandvalue,count;  

/**********************************************************
     Constructs a Playershand of Cards.
**********************************************************/
  public Playershand()
  {
    ThePlayershand = new ArraySet<Card>(12);
    Playershandvalue=0;
    count =0;
  }

/**********************************************************
     To reduce Playershand when newcard makes player go over 21
      and there is an ace in the Playershand.
     @param newCard random card from the set
**********************************************************/
  private void reducePlayershand(Card newCard)
  {
      if((Playershandvalue) > 21)
      {
         if(aceThePlayershand())
           Playershandvalue -= 10;           
          
      }
  }//end reducePlayershand

/**********************************************************
     To check if there is an ace in the Playershand.
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
  }
 
/**********************************************************
     Adds a new card to the Playershand.
     @param currentdeck the Deck the game is playing with
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
  }


/**********************************************************
     Returns the value of this Playershand.
**********************************************************/
  public int getPlayershandValue()
  {
    return Playershandvalue;
  }

/**********************************************************
     Returns an iterator over this Playershand.
**********************************************************/
  public Iterator<Card> iterator()
  {
    return ThePlayershand.iterator();
  }

/**********************************************************
     Removes a card from this Playershand.
**********************************************************/
  public Card remove(Card crd) throws ElementNotFoundException
  {
     return(ThePlayershand.remove(crd));
  }

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
  }

}//end Playershand

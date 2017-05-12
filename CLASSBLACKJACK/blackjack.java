//These are distributed packages holding exceptions
//and other data structures such as ArraySet, SetADT
//required throughout the game.
import jss2.exceptions.*;
import java.util.*;

public class blackjack
{
  Playershand dealer;    //dealer's cards
  Playershand player;    //player's cards
  Deck newdeck;          //a deck of cards

  public blackjack(Playershand DLR, Playershand PLR)
  {
    dealer = DLR;
    player = PLR;
    newdeck = new Deck();
  }//blackjack constructor

  /***********************************************************
    deal method - deals the intitial cards to the player
  ***********************************************************/
  public void dealInitialCards()            
  { 
    dealer.newCard(newdeck);
    dealer.newCard(newdeck);
    player.newCard(newdeck);
    player.newCard(newdeck);
    
  }//Close deal()

  /***********************************************************
    hit method - adds the next random card from the deck to 
    the given Playershand
  ***********************************************************/
  public Card hit(Playershand wh)
  {
    Card result = wh.newCard(newdeck);

    return(result);

  }//Close hit()

  /***********************************************************
    PlayershandValue method - returns the value of the given
    Playershand
  ***********************************************************/
  public int PlayershandValue(Playershand whoPlayershand)
  {
    int result = whoPlayershand.getPlayershandValue();

    return(result);

  }// Close PlayershandValue()

  /***********************************************************
    discard method - discards a given card from the given
    player's Playershand or throws an exception if the card is not
    in the Playershand
  ************************************************************/
  public void discard(Playershand plrhnd, Card discrd) throws ElementNotFoundException
  {
    Card card=null;
    boolean found = false;
    Iterator<Card> scan = plrhnd.iterator();
    while (scan.hasNext() && !found)
    {
        card = scan.next();
        if(discrd.equals(card))
        {
          plrhnd.remove(card);
          found = true;
        }
    }
    if(!found)
        throw new ElementNotFoundException("blackjack");

  }//Close discard()

  /***********************************************************
    blackjack method - tests to see if the Playershand has
    a value of 21
  ***********************************************************/
  public boolean blackjack()
  {
    boolean result = false;

    if(player.getPlayershandValue() == 21)
      result = true;

    return(result);

  }//Close blackjack()

  /***********************************************************
    bust method - tests a given player's Playershand to see if they
    have gone over 21, is is a bust call.
  ***********************************************************/
  public boolean bust(Playershand whobust)
  {
    boolean result = false;

    if(whobust.getPlayershandValue() > 21)
      result = true;

    return(result);

  }//Close bust()

  /***********************************************************
     dealerPlays method - adds cards to the dealer's Playershand
     until the value is 16 or larger.
  ***********************************************************/
  public Playershand dealerPlays()
  {
    Playershand result = dealer;

    while(dealer.getPlayershandValue() <= 16)
    {
      dealer.newCard(newdeck);
    }

    return(result);

  }//Close dealerPlays()
  

  /***********************************************************
    winner method - determines the winner of the game
	returns the string status to the caller.
  ***********************************************************/
  public String winner()
  {
    String result = "";
    if((player.getPlayershandValue() < dealer.getPlayershandValue()) && 
                 dealer.getPlayershandValue() <= 21 )                 
      result = "Lose";
    else if ((player.getPlayershandValue() == dealer.getPlayershandValue()) &&
                 dealer.getPlayershandValue() <= 21 )
      result = "Push";
    else
      result = "Win";

    return(result);
 
  }//Close winner()
}//end blackjack

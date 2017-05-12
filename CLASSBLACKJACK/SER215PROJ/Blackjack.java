
import jss2.exceptions.*;
import java.util.*;

public class Blackjack
{
  Playershand dealer;    //to hold the dealer's cards
  Playershand player;    //to hold the player's cards
  Deck newdeck;   //a set of cards

  public Blackjack(Playershand DLR, Playershand PLR)
  {
    dealer = DLR;
    player = PLR;
    newdeck = new Deck();
  }//Blackjack constructor

  /***********************************************************
    deal method - deals the intitial cards to each player
  ***********************************************************/
  public void dealInitialCards()            
  { 
    dealer.newCard(newdeck);
    dealer.newCard(newdeck);
    player.newCard(newdeck);
    player.newCard(newdeck);
    
  }//end deal method

  /***********************************************************
    hit method - adds the next random card from the deck to 
    the given player's Playershand
  ***********************************************************/
  public Card hit(Playershand whohit)
  {
    Card result = whohit.newCard(newdeck);

    return(result);

  }//end hit method

  /***********************************************************
    PlayershandValue method - returns the value of the given player's
    Playershand
  ***********************************************************/
  public int PlayershandValue(Playershand whoPlayershand)
  {
    int result = whoPlayershand.getPlayershandValue();

    return(result);

  }// end PlayershandValue method

  /***********************************************************
    discard method - discards a given card from the given
    player's Playershand or throws an exception if the card is not
    in the Playershand
  ************************************************************/
  public void discard(Playershand whodis, Card discrd) throws ElementNotFoundException
  {
    Card card=null;
    boolean found = false;
    Iterator<Card> scan = whodis.iterator();
    while (scan.hasNext() && !found)
    {
        card = scan.next();
        if(discrd.equals(card))
        {
          whodis.remove(card);
          found = true;
        }
    }
    if(!found)
        throw new ElementNotFoundException("BlackJack");

  }//end discard

  /***********************************************************
    blackj method - tests to see if the player's Playershand has
    a value of 21
  ***********************************************************/
  public boolean blackj()
  {
    boolean result = false;

    if(player.getPlayershandValue() == 21)
      result = true;

    return(result);

  }//end blackj

  /***********************************************************
    bust method - tests a given player's Playershand to see if they
    have gone over 21
  ***********************************************************/
  public boolean bust(Playershand whobust)
  {
    boolean result = false;

    if(whobust.getPlayershandValue() > 21)
      result = true;

    return(result);

  }//end bust

  /***********************************************************
     dealerPlays method - adds cards to the dealer's Playershand
     until the value is >= 16
  ***********************************************************/
  public Playershand dealerPlays()
  {
    Playershand result = dealer;

    while(dealer.getPlayershandValue() <= 16)
    {
      dealer.newCard(newdeck);
    }

    return(result);

  }//end dealerPlays
  

  /***********************************************************
    winner method - determines the winner of the game
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
 
  }//end winner

}//end Blackjack

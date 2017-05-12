//These are distributed packages holding exceptions
//and other data structures such as ArraySet, SetADT
//required throughout the game.
import java.util.Random;
import javax.swing.*;


public class Card 
{

  protected String face;
  protected ImageIcon cardpic;
  protected int value; 
  protected String suit;

  /***********************************************************
     Constructor
  ***********************************************************/
  public Card()
  {
    cardpic = null;
    value = 0;
    suit = null;
    face = null;
  }//Close constructor

  /***********************************************************
     Draws the shape.
     @param x the image of the card
     @param val the value of the card
     @param s the suit of the card
     @param f the type of the card
  ***********************************************************/
  public Card(ImageIcon x, int val, String s, String f)
  {
    cardpic = x;
    value = val;  
    face = f;
    suit = s;
  }//Close parameterized constructor

  /***********************************************************
     Returns the card's image.
  ***********************************************************/
  public ImageIcon getimage()
  {
    return(cardpic);
  }//Close getimage()

  /***********************************************************
     Returns the card's value.
  ***********************************************************/
  public int getvalue()
  {
    return(value);
  }//Close getvalue()

  /***********************************************************
     Allows the user to set the value.
     @param v new value of card
  ***********************************************************/
  public void setvalue(int v)
  {
    value = v;
  }//Close setvalue()

  /***********************************************************
     Returns the suit
  ***********************************************************/
  public String getsuit()
  {
    return(suit);
  }//close getsuit()

  /***********************************************************
     Returs the face
  ***********************************************************/
  public String getface()
  {
    return(face);
  }//Close getface()
  
  /***********************************************************
     Returs a string representing the card
  ***********************************************************/
  public String toString()
  {
    return("Face: "+ face + " Suit"+ suit +" Value: "+ value);
  }//Close toString()
}//end Card

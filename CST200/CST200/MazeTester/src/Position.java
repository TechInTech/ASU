import java.util.*;
import java.io.*;

public class Position
{
	private int x; 
    private int y;
	
	//Constructor, default
	Position(){} 

	//Constructor with user values
	//Added for the modification
	Position(int a,int b) 
	{
		this.x = a;
		this.y = b;
	}
	
	/**
     * Returns the x-coordinate value of this position.
     * @return the x-coordinate of this position
     */
	public int getx()
	{ 
		return x;
	}
	
	/**
     * Returns the y-coordinate value of this position.
     * @return the y-coordinate of this position
     */
	public int gety()
	{ 
		return y;
	}
	
	/**
     * Sets the value of the current position's x-coordinate.
     * @param a value of x-coordinate
     */
	public void setx(int a)
	{ 
		this.x = a; //Changed to use the this pointer
	}
	
	/**
     * Sets the value of the current position's x-coordinate.
     * @param a value of y-coordinate
     */ 
	public void sety(int b)//Changed
	{ 
		this.y = b; //Changed to use the this pointer
	}
}//Close
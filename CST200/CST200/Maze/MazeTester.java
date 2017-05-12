import java.util.*;
import java.io.*;

/**
 * MazeTester uses recursion to determine if a maze can be traversed.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class MazeTester
{
    /**
     * Creates a new maze, prints its original form, attempts to
     * solve it, and prints out its final form.
     */	 
	 
	public static void main(String args[])//Remove the file exception here (HQP)
	{
		int x,y;
		static Scanner u = new Scanner(System.in);
		
		//Prompt for user's input
		System.out.println("Enter the starting point : x followed by y :");

		x = u.nextInt();
		y = u.nextInt();
	
		Position start = new Position(x,y);

		System.out.println("Enter the ending point : x followed by y :");

		x = u.nextInt();
		y = u.nextInt();
		Position end = new Position(x,y);
	
		System.out.println(maze.traverse(start,end));

	}//main    
}

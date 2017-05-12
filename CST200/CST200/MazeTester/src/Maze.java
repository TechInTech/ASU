import java.util.*;
import java.io.*;


//Modified class to enable maze movements according
//to user's definition
//Classes and methods originally from the MazeSolver class
//were combined into this modification. Data files were not
//used. The grid was hard-coded from the data file. The rows 
//and columns integers were eliminated.

public class Maze
{
	private static final int TRIED = 2;
	private static final int PATH = 3;
	
	/**
	*Instead of reading the file, build
	*an array of maze map here.
	*@Modified class Maze.
	*/
	
	private int [][] grid = { 	{1,1,1,0,1,1,0,0,0,1,1,1,1},
								{1,0,0,1,1,0,1,1,1,1,0,0,1},
								{1,1,1,1,1,0,1,0,1,0,1,0,0},
								{0,0,0,0,1,1,1,0,1,0,1,1,1},
								{1,1,1,0,1,1,1,0,1,0,1,1,1},
								{1,0,1,0,0,0,0,1,1,1,0,0,1},
								{1,0,1,1,1,1,1,1,0,1,1,1,1},
								{1,0,0,0,0,0,0,0,0,0,0,0,0},
								{1,1,1,1,1,1,1,1,1,1,1,1,1}   };

  
	
	
	/**
	* Marks the specified position in the maze as TRIED
	*
	* @param row the index of the row to try
	* @param col the index of the column to try
	*/

	public void tryPosition(int row, int col)
	{
		grid[row][col] = TRIED;
	}

	/**
     * Marks the specified position in the maze as TRIED
     *
     * @param row the index of the row to try
     * @param col the index of the column to try 
     */

	public int getRows()
	{
		return grid.length;
	}

	/**
     * Return the number of columns in this maze
     *
     * @return the number of columns in this maze
     */

	public int getColumns()
	{
		return grid[0].length;
	}

	/**
     * Marks a given position in the maze as part of the PATH
     *
     * @param row the index of the row to mark as part of the PATH
     * @param col the index of the column to mark as part of the PATH 
     */

	public void markPath(int row, int col)
	{
		grid[row][col] = PATH;
	}

	/**
     * Determines if a specific location is valid. A valid location
     * is one that is on the grid, is not blocked, and has not been TRIED.
     *
     * @param row the row to be checked
     * @param column the column to be checked
     * @return true if the location is valid    
     */

	public boolean validPosition(int row, int column)
	{
		boolean result = false;
		
		// check if cell is in the bounds of the matrix
		if (row >= 0 && row < grid.length && column >= 0 && 
			column < grid[row].length)
			// check if cell is not blocked and not previously tried
		if (grid[row][column] == 1)
			result = true;

		return result;
	}

	/**
     * Returns the maze as a string.
     * 
     * @return a string representation of the maze
     */

	public String toString()
	{
		String result = "\n";
	
		for (int row=0; row < grid.length; row++)
		{
			for (int column=0; column < grid[row].length; column++)
				result += grid[row][column] + "";
			result += "\n";
		}
		return result;
	}		
	
	/**
     * Simplified program, combined class methods into original Maze class.
     * 
     * @Simplified program.
     */
	
	public boolean traverse(Position starting,Position ending)//Modified here
	{
		boolean done = false;
		Position pos;
		Deque<Position> stack = new LinkedList<Position>();
		stack.push(starting);
		while (!(done) && !stack.isEmpty())
		{
			pos = stack.pop();
			maze.tryPosition(pos.getx(),pos.gety()); // this cell has been tried

			if((pos).getx() == ending.getx() && pos.gety() == ending.gety())//Modified here
			{
				done = true; // the maze is solved
			}
			else
			{

				push_new_pos(pos.getx() - 1,pos.gety(), stack);
				push_new_pos(pos.getx() + 1,pos.gety(), stack);
				push_new_pos(pos.getx(),pos.gety() - 1, stack);
				push_new_pos(pos.getx(),pos.gety() + 1, stack);
			}
			if (done)
				maze.markPath(pos.getx(),pos.gety());
		}
		return done;
	}

	private void push_new_pos(int x, int y, Deque<Position> stack)
	{

		Position npos = new Position();
		npos.setx(x);
		npos.sety(y);
	
		if(maze.validPosition(x,y))
			stack.push(npos);

	}
	
	private static Maze maze = new Maze(); 		//Instatiate object maze of type Maze here instead.
	static Scanner in = new Scanner(System.in);	//Getting user inputs

	public static void main(String args[])
	{
		int x,y;
	
		System.out.print("Enter the starting point x, separated by a space, followed by point y: ");

		x = in.nextInt();
		y = in.nextInt();
	
		Position starting = new Position(x,y);

		System.out.print("Enter the ending point x, separated by a space, followed by point y: ");

		x = in.nextInt();
		y = in.nextInt();
		Position ending = new Position(x,y);
	
		if(maze.traverse(starting,ending))
		{
			System.out.println("Maze had been solved...");
		}
		else
		{
			System.out.println("Maze had not been solved...");
		}

	}//main
}
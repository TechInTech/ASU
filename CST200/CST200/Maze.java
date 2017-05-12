import java.util.*;
import java.io.*;


public class Position
{
	private int x; 
    private int y;
	
	//Constructor, default
	Position(){} 

	//Constructor with user values
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
		this.x = a;
	}
	
	/**
     * Sets the value of the current position's x-coordinate.
     * @param a value of y-coordinate
     */ 
	public void sety(int b)
	{ 
		this.y = b;
	}
}

//Modified class to enable movements according
//to user's definition
public class Maze
{
	private static final int TRIED = 2;
	private static final int PATH = 3;
	
	private int numberRows, numberColumns;
	
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
								{1,1,1,1,1,1,1,1,1,1,1,1,1} };

  



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

	private static Maze maze = new Maze();

	/**
	* Constructor for the MazeSolver class.
	* @return
	*/

	public void MazeSearch(Maze maze)
	{
		this.maze = maze;
	}
	
	public boolean traverse(Position start,Position end)
	{
		boolean done = false;
		Position pos;
		Deque<Position> stack = new LinkedList<Position>();
		stack.push(start);
		while (!(done) && !stack.isEmpty())
		{
			pos = stack.pop();
			maze.tryPosition(pos.getx(),pos.gety()); // this cell has been tried

			if((pos).getx() == end.getx() && pos.gety() == end.gety())
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

	static Scanner in = new Scanner(System.in);

	public static void main(String args[])
	{
		int x,y;
	
		System.out.println("Enter the starting point : x followed by y :");

		x = in.nextInt();
		y = in.nextInt();
	
		Position start = new Position(x,y);

		System.out.println("Enter the ending point : x followed by y :");

		x = in.nextInt();
		y = in.nextInt();
		Position end = new Position(x,y);
	
		System.out.println(maze.traverse(start,end));

	}//main
}












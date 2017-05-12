import java.util.*;
	
/**
 * MazeSolver attempts to recursively traverse a Maze. The goal is to get from the
 * given starting position to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class MazeSolver
{
	//Modified (HQP)
	private static Maze maze = new Maze();

	/**
	* Constructor for the MazeSolver class.
	* @return
	*/

	public void MazeSolver(Maze maze)
	{
		this.maze = maze;
	}
	
	 /**
     * Attempts to recursively traverse the maze. Inserts special
     * characters indicating locations that have been TRIED and that
     * eventually become part of the solution PATH.
     * Modified to have start and end positions(HQP)
     * @param row row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */
	public boolean traverse(Position start,Position end)//Modified method (HQP)
	{
		boolean done = false;
		int row, column;
		
		Position pos;
		//Position pos = new Position();		
        	
		Deque<Position> stack = new LinkedList<Position>();
		//stack.push(pos);
		stack.push(start);
		
		while (!(done) && !stack.isEmpty())
		{
			pos = stack.pop();
			maze.tryPosition(pos.getx(),pos.gety()); // this cell has been tried

			//Modified if block (HQP)
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

	/**
	 * (No change)
     * Push a new attempted move onto the stack
     * @param x represents x coordinate
     * @param y represents y coordinate
     * @param stack the working stack of moves within the grid
     * @return stack of moves within the grid
     */	 
	private void push_new_pos(int x, int y, Deque<Position> stack)
	{
		Position npos = new Position();
		npos.setx(x);
		npos.sety(y);
	
		if(maze.validPosition(x,y))
			stack.push(npos);
	}
}//Close
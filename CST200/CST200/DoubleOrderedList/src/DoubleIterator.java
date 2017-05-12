import java.util.*;

/**
*DoubleIterator class
*@The DoubleIterator class
*
*/

public class DoubleIterator<T> 
{

	private DoubleList<T> doublelist;
	private int indx;

	public DoubleIterator(DoubleList<T> doublelist) 
	{
		this.doublelist = doublelist;
		indx = -1;
	}
	
	public boolean hasNext()
	{
		if(indx < doublelist.size() - 1) 
		{
			return(true);
		} 
		else 
		{
			return(false);
		}
	}
	
	public T next() 
	{
		if(!hasNext()) 
		{
			throw new NoSuchElementException();
		}
		indx++;
		return(doublelist.get(indx));
	}
}

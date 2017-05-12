import java.util.*;

public class DoubleReverseIterator<T> 
{
	
	private DoubleList<T> doubleList;
	private int index;

	public DoubleReverseIterator(DoubleList<T> doubleList) 
	{
		this.doubleList = doubleList;
		index = doubleList.size();
	}
	public boolean hasPrevious() 
	{
		if (index > 0) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	public T previous() 
	{
		if (!hasPrevious()) 
		{
			throw new NoSuchElementException();
		}
		index--;
		return doubleList.get(index);
	}
}
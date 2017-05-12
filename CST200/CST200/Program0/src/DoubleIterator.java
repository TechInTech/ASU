import java.util.*;

public class DoubleIterator<E> 
{

	private DoubleList<E> doubleList;
	private int index;

	public DoubleIterator(DoubleList<E> doubleList) 
	{
		this.doubleList = doubleList;
		index = -1;
	}
	public boolean hasNext() {
		if (index < doubleList.size()-1) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	public E next() 
	{
		if (!hasNext()) 
		{
			throw new NoSuchElementException();
		}
		index++;
		return doubleList.get(index);
	}
}

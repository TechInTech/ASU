import java.util.*;

public class DoubleIterator<T> 
{

	private DoubleList<T> doubleList;
	private int index;

	public DoubleIterator(DoubleList<T> doubleList) 
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
	public T next() 
	{
		if (!hasNext()) 
		{
			throw new NoSuchElementException();
		}
		index++;
		return doubleList.get(index);
	}
}

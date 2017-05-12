//********************************************************************
//  DoubleOrderedList.java       Authors: Hieu Pham
//                                   
//  Represents a doubly linked implementation of an ordered list.
//********************************************************************
public class DoubleOrderedList<T>
{
	
	private DoubleNode<T> blanks;
	private int length = 0;
	
	
	//-----------------------------------------------------------------
	//  Creates a blank list.
	//-----------------------------------------------------------------
	public DoubleOrderedList()
	{		
		blanks = new DoubleNode<T>(null);
		blanks.setNext(blanks);
		blanks.setPrevious(blanks);
	}
	
	
	public void add(T element)
	{
		DoubleNode<T> dblnode = new DoubleNode<T>(element);
		dblnode.setNext(blanks.getNext());
		blanks.setNext(dblnode);
		length++;
	}	
	
	public T removeFirst()
	{
		length--;
		DoubleNode<T> dblnode = blanks.getNext();
		if (dblnode == blanks) 
		{
			return(null);
		}
		dblnode.getNext().setPrevious(dblnode.getPrevious());
		dblnode.getPrevious().setNext(dblnode.getNext());
		return(dblnode.getElement());
	}
	
	
	public T removeLast() 
	{
		length--;
		DoubleNode<T> dblnode = blanks.getPrevious();
		if (dblnode == blanks) 
		{
			return(null);
		}
		dblnode.getPrevious().setNext(dblnode.getNext());
		dblnode.getNext().setPrevious(dblnode.getPrevious());
		return(dblnode.getElement());
	}
	
	
	public T remove(int index) 
	{
		length--;
		DoubleNode<T> dblnode = blanks.getNext();
		if (dblnode == blanks) 
		{
			return(null);
		}
		for (int i = 0; i < index; i++) 
		{
			dblnode = dblnode.getNext();
		}
		dblnode.getNext().setPrevious(dblnode.getPrevious());
		dblnode.getPrevious().setNext(dblnode.getNext());
		return(dblnode.getElement());
	}
	
	
	public T getFirst() 
	{
		DoubleNode<T> dblnode = blanks.getNext();
		if (dblnode == blanks) 
		{
			return(null);
		}
		return(dblnode.getElement());
	}
	
	
	public T getLast() 
	{
		DoubleNode<T> dblnode = blanks.getPrevious();
		if (dblnode == blanks) 
		{
			return(null);
		}
		return(dblnode.getElement());
	}
	
	
	public T get(int index)
	{
		DoubleNode<T> dblnode = blanks.getNext();
		for (int i = 0; i < index; i++) 
		{
			if (dblnode == blanks) 
			{
				return(null);
			}
			dblnode = dblnode.getNext();
		}
		return(dblnode.getElement());
	}
	
	
	public String toString() 
	{
		StringBuilder sbdr = new StringBuilder("{");
		for (DoubleNode<T> dblnode = blanks.getNext(); dblnode != blanks; dblnode = dblnode.getNext()) 
		{
			sbdr.append(dblnode.getElement()); 
			if (dblnode.getNext() != blanks) 
			{
				sbdr.append(", ");
			}
		}
		sbdr.append("}");
		return(sbdr.toString());
	}
	
	
	public int size() 
	{
		return(length);
	}
	
	
	public boolean isEmpty() 
	{
		return(length == 0);
	}
}
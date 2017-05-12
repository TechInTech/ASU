public class DoubleOrderedList<T>
{
	
	private DoubleNode<T> dummy;
	private int length = 0;
	
	// Constructor
	public DoubleOrderedList()
	{
		// Creates a dummy cell and sets next and previous to itself
		dummy = new DoubleNode<T>(null);
		dummy.setNext(dummy);
		dummy.setPrevious(dummy);
	}	
	// Adds an element
	public void add(T elem)
	{
		DoubleNode<T> dnode = new DoubleNode<T>(Elem);
		dnode.setNext(dummy.getNext());
		dummy.setNext(dnode);
		length++;
	}
	// Removes first node, if empty, returns null
	public T removeFirst()
	{
		length--;
		DoubleNode<T> dnode = dummy.getNext();
		if (dnode == dummy) 
		{
			return null;
		}
		dnode.getNext().setPrevious(dnode.getPrevious());
		dnode.getPrevious().setNext(dnode.getNext());
		return dnode.getElement();
	}
	// Removes last node, if empty, returns null
	public T removeLast() 
	{
		length--;
		DoubleNode<T> dnode = dummy.getPrevious();
		if (dnode == dummy) 
		{
			return null;
		}
		dnode.getPrevious().setNext(dnode.getNext());
		dnode.getNext().setPrevious(dnode.getPrevious());
		return dnode.getElement();
	}
	// Removes an element at specified index
	public T remove(int index) 
	{
		length--;
		DoubleNode<T> dnode = dummy.getNext();
		if (dnode == dummy) 
		{
			return null;
		}
		for (int i = 0; i < index; i++) 
		{
			dnode = dnode.getNext();
		}
		dnode.getNext().setPrevious(dnode.getPrevious());
		dnode.getPrevious().setNext(dnode.getNext());
		return dnode.getElement();
	}
	// Returns first element, if empty, returns null
	public T getFirst() 
	{
		DoubleNode<T> dnode = dummy.getNext();
		if (dnode == dummy) 
		{
			return null;
		}
		return dnode.getElement();
	}
	// Returns last element, if empty, returns null
	public T getLast() 
	{
		DoubleNode<T> dnode = dummy.getPrevious();
		if (dnode == dummy) 
		{
			return null;
		}
		return dnode.getElement();
	}
	// Gets an element at specified index
	public T get(int index)
	{
		DoubleNode<T> dnode = dummy.getNext();
		for (int i = 0; i < index; i++) 
		{
			if (dnode == dummy) 
			{
				return null;
			}
			dnode = dnode.getNext();
		}
		return dnode.getElement();
	}
	// toString
	public String toString() 
	{
		StringBuilder sb = new StringBuilder("[");
		for (DoubleNode<T> dnode = dummy.getNext(); dnode != dummy; dnode = dnode.getNext()) 
		{
			sb.append(dnode.getElement()); // Adds a string to sb
			if (dnode.getNext() != dummy) 
			{
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	// Returns size of list
	public int size() 
	{
		return length;
	}	
	// Checks list empty or not
	public boolean isEmpty() 
	{
		return length == 0;
	}
}
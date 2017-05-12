public class DoubleList<E>
{
	
	private DoubleNode<E> dummy;
	private int length = 0;
	
	// Constructor
	public DoubleList()
	{
		// Creates a dummy cell and sets next and previous to itself
		dummy = new DoubleNode<E>(null);
		dummy.setNext(dummy);
		dummy.setPrevious(dummy);
	}
	// Adds an element to front	
	public void addFirst(E elem)
	{
		DoubleNode<E> dnode = new DoubleNode<E>(elem);
		dnode.setPrevious(dummy);
		dnode.setNext(dummy.getNext());
		dummy.getNext().setPrevious(dnode);
		dummy.setNext(dnode);
		length++;
	}
	// Adds an element to rear
	public void addLast(E elem)
	{
		DoubleNode<E> dnode = new DoubleNode<E>(elem);
		dnode.setNext(dummy);
		dnode.setPrevious(dummy.getPrevious());
		dummy.getPrevious().setNext(dnode);
		dummy.setPrevious(dnode);
		length++;
	}
	// Removes first node, if empty, returns null
	public E removeFirst()
	{
		length--;
		DoubleNode<E> dnode = dummy.getNext();
		if (dnode == dummy)
		{
			return null;
		}
		dnode.getNext().setPrevious(dnode.getPrevious());
		dnode.getPrevious().setNext(dnode.getNext());
		return dnode.getElement();
	}
	// Removes last node, if empty, returns null
	public E removeLast()
	{
		length--;
		DoubleNode<E> dnode = dummy.getPrevious();
		if (dnode == dummy) {
			return null;
		}
		dnode.getPrevious().setNext(dnode.getNext());
		dnode.getNext().setPrevious(dnode.getPrevious());
		return dnode.getElement();
	}
	// Removes an element at specified index
	public E remove(int index)
	{
		length--;
		DoubleNode<E> dnode = dummy.getNext();
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
	public E getFirst()
	{
		DoubleNode<E> dnode = dummy.getNext();
		if (dnode == dummy)
		{
			return null;
		}
		return dnode.getElement();
	}
	// Returns last element, if empty, returns null
	public E getLast()
	{
		DoubleNode<E> dnode = dummy.getPrevious();
		if (dnode == dummy)
		{
			return null;
		}
		return dnode.getElement();
	}
	// Gets an element at specified index
	public E get(int index)
	{
		DoubleNode<E> dnode = dummy.getNext();
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
		for (DoubleNode<E> dnode = dummy.getNext(); dnode != dummy; dnode = dnode.getNext())
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
	// Forward iteration
	public DoubleIterator<E> forwardIterator()
	{
		return new DoubleIterator<E>(this);
	}
	// Backward iteration
	public DoubleReverseIterator<E> backwardIterator()
	{
		return new DoubleReverseIterator<E>(this);
	}	
}

//-----------------------------------------------------------------
//  Create the DoubleList, which is based on the DoubleNode
//  and the DoubleIterator classes. Implemented with generic type.
//-----------------------------------------------------------------
public class DoubleList<T>
{
	
	private DoubleNode<T> blanks;
	private int length = 0;  //Initialed to 0 length
	
	
	public DoubleList()  //Constructor
	{		
		blanks = new DoubleNode<T>(null);
		blanks.setNext(blanks);
		blanks.setPrevious(blanks);
	}
	
	
	public void addFirst(T element)
	{
		DoubleNode<T> dblnode = new DoubleNode<T>(element);
		dblnode.setPrevious(blanks);
		dblnode.setNext(blanks.getNext());
		blanks.getNext().setPrevious(dblnode);
		blanks.setNext(dblnode);
		length++;
	}
	
	
	public void addLast(T element)
	{
		DoubleNode<T> dblnode = new DoubleNode<T>(element);
		dblnode.setNext(blanks);
		dblnode.setPrevious(blanks.getPrevious());
		blanks.getPrevious().setNext(dblnode);
		blanks.setPrevious(dblnode);
		length++;
	}
	
	
	public T removeFirst()
	{
		length--;
		DoubleNode<T> dblnode = blanks.getNext();
		if(dblnode == blanks)
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
		if(dblnode == blanks)
		{
			return(null);
		}
		dblnode.getPrevious().setNext(dblnode.getNext());
		dblnode.getNext().setPrevious(dblnode.getPrevious());
		return(dblnode.getElement());
	}
	
	
	public T remove(int indx)
	{
		length--;
		DoubleNode<T> dblnode = blanks.getNext();
		if(dblnode == blanks)
		{
			return(null);
		}
		for(int i = 0; i < indx; i++)
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
		if(dblnode == blanks)
		{
			return(null);
		}
		return(dblnode.getElement());
	}
	
	
	public T getLast()
	{
		DoubleNode<T> dblnode = blanks.getPrevious();
		if(dblnode == blanks)
		{
			return(null);
		}
		return(dblnode.getElement());
	}
	
	
	public T get(int indx)
	{
		DoubleNode<T> dblnode = blanks.getNext();
		for(int i = 0; i < indx; i++)
		{
			if(dblnode == blanks)
			{
				return(null);
			}
			dblnode = dblnode.getNext();
		}
		return(dblnode.getElement());
	}
	
	
	public String toString()  //Utilizes the StringBuilder class from java.lang.StringBuilder
	{
		StringBuilder sbdr = new StringBuilder("{");
		for(DoubleNode<T> dblnode = blanks.getNext(); dblnode != blanks; dblnode = dblnode.getNext())
		{
			sbdr.append(dblnode.getElement()); 
			if(dblnode.getNext() != blanks)
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
	
	
	public DoubleIterator<T> FwdIterator()
	{
		return(new DoubleIterator<T>(this));
	}	
}

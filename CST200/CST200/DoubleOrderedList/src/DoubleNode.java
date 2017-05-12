//-----------------------------------------------------------------
//  Create the DoubleNode, which is a doubly linked list node.
//  Implemented with generic type.
//-----------------------------------------------------------------
public class DoubleNode<T> 
{
	
	private T element;		
	private DoubleNode<T> previous;
	private DoubleNode<T> next;
	
	
	public DoubleNode() //Constructor, default
	{
		previous = null;
		next = null;
		element = null;
	}
	
	
	public DoubleNode(T elem) //Constructor, with generic element
	{
		next = null;		
		previous = null;
		element = elem;
	}
	
	
	public DoubleNode<T> getNext() //getNext() method
	{
		return(next);
	}
	
	
	public DoubleNode<T> getPrevious() //getPrevious() method
	{
		return(previous);
	}
	
	
	public void setNext(DoubleNode<T> dblnode) //setNext() method
	{
		next = dblnode;
	}
	
	
	public void setPrevious(DoubleNode<T> dblnode) //setPrevious() method
	{
		previous = dblnode;
	}
	
	
	public T getElement() //getElement() method
	{
		return(element);
	}
	
	
	public void setElement(T elem) //setElement() method
	{
		element = elem;
	}
}
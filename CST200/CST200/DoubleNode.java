public class DoubleNode<T> 
{
	
	private DoubleNode<T> next;
	private T element;
	private DoubleNode<T> previous;
	
	// Create an empty node.
	public DoubleNode() 
	{
		next = null;
		element = null;
		previous = null;
	}
	
	// Create a node storing the specified element.
	// @param elem the element to be stored into the new node
	public DoubleNode(T elem) 
	{
		next = null;
		element = elem;
		previous = null;
	}
	
	// Returns the node that follows this one.
	// @return the node that follows the current one
	public DoubleNode<T> getNext() 
	{
		return next;
	}
	
	// Returns the node that precedes this one.
	// @return the node that precedes the current one
	public DoubleNode<T> getPrevious() 
	{
		return previous;
	}
	
	// Sets the node that follows this one.
	// @param dnode the node to be set as the one to follow the current one
	public void setNext(DoubleNode<T> dnode) 
	{
		next = dnode;
	}
	
	// Sets the node that precedes this one.
	// @param dnode the node to be set as the one to precedes the current one
	public void setPrevious(DoubleNode<T> dnode) 
	{
		previous = dnode;
	}
	
	// Returns the element stored in this node.
	// @return the element stored in this one
	public T getElement() 
	{
		return element;
	}
	
	// Sets the element stored in this node.
	// @param elem the element to be stored in this node
	public void setElement(T elem) 
	{
		element = elem;
	}
}

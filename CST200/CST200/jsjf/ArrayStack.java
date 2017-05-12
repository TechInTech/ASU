package jsjf;

import jsjf.exceptions.*;
import java.util.Arrays;

/**
 * An array implementation of a stack in which the bottom of the
 * stack is fixed at index 0.
 * 
 * @author Java Foundations
 * @version 4.0
 */
public class ArrayStack<T> implements StackADT<T>
{
    private final static int DEFAULT_CAPACITY = 100;

    private int top;  
    private T[] stack;
  
    /**
     * Creates an empty stack using the default capacity.
     */
    public ArrayStack() //Constructor
    {
    	//Using "this" pointer to pass DEFAULT_CAPACITY
    	//to another constructor right below. Clever
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty stack using the specified capacity.
     * @param initialCapacity the initial size of the array 
     */
    public ArrayStack(int initialCapacity) //Another constructor
    {
        top = 0;
        stack = (T[])(new Object[initialCapacity]);
    }

    /**
     * Adds the specified element to the top of this stack, expanding
     * the capacity of the array if necessary.
     * @param element generic element to be pushed onto stack
     */
    public void push(T element)
    {
        if (size() == stack.length) 
            expandCapacity();

        stack[top] = element; //Set top of stack element to 
                              //currently max out element
        top++; //Increments top
    }

    /**
     * Creates a new array to store the contents of this stack with
     * twice the capacity of the old one.
     */
    private void expandCapacity()
    {
        //array[].copyOf(original array, new size)
    	stack = Arrays.copyOf(stack, stack.length * 2);   
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it. 
     * @return element removed from top of stack
     * @throws EmptyCollectionException if stack is empty 
     */
    public T pop() throws EmptyCollectionException
    {
    	//A couple things here: keyword - throws
    	//What to throw: EmptyCollectionException
    	//User must know the Error/Exception structure
    	//Also, method isEmpty()
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        top--;
        T result = stack[top];
        stack[top] = null; 

        return result;
    }
   
    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.  
     * @return element on top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public int peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        
      //Force this return value to int, HQP, 02/21/2015
        return(stack[top-1]); 
    }

    /**
     * Returns true if this stack is empty and false otherwise. 
     * @return true if this stack is empty
     */
    public boolean isEmpty()
    {
        // If top is beyond 0, it is empty, Hieu, 02/21/2015
    	if(top==-1)
            return(true);
        else
            return(false);
    }
 
    /**
     * Returns the number of elements in this stack.
     * @return the number of elements in the stack
     */
    public int size()
    {
        return(top); //Return the size, Hieu, 02/21/2015
    }

    /**
     * Returns a string representation of this stack. 
     * @return a string representation of the stack
     */
    public String toString()
    {
        // To be completed as a Programming Project
    	return("Size = " + stack.length + "\n"
    			+ "top = " + this.top + "\n"
    			+ "Capacity = " + ((this.isEmpty()) ? "Empty" : "Still good") + "\n"
    			+ "First element is: " + stack[0] + "\n"
    			+ "Last element is: " + stack[top-1]);
    }
}


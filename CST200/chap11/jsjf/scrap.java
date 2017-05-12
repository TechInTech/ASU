public boolean contains( (Comparable<T>) targetElement )
{
	boolean found = false;
	BinaryTreeNode<T> current = root;

	// Keep looking until we find the element or fall off the tree
	while( !found && current != null )
	{
		int compare = targetElement.compareTo( current.getElement());

		if( compare < 0 )
		{
			// The target is smaller - look left
			current = current.getLeft();
		}
		else if ( compare > 0 )
		{
			// The target is greater - look right
			current = cur.getRight();
		}
		else
		{
			// Target found
			found = true;
		}
	}
	return(found);
}

public class TestDoubleOrderedList
{
	public static void main(String[] args)
	{

		System.out.println("^^^ Instantiating an object of DoubleList ^^^");
		
		DoubleList<Integer> dlinkedlist = new DoubleList<Integer>();
		
		// print out the list size
		System.out.println("List size: " + dlinkedlist.size());
		// print out true if the list is empty.
		System.out.println("isEmpty(): " + dlinkedlist.isEmpty());
		
		// Adding elements
		System.out.println("Adding elements to the front:");
		dlinkedlist.addFirst(14);
		System.out.println(dlinkedlist);
		dlinkedlist.addFirst(37);
		System.out.println(dlinkedlist);
		dlinkedlist.addFirst(49);
		System.out.println(dlinkedlist);
		System.out.println("Adding elements to the rear:");
		dlinkedlist.addLast(35);
		System.out.println(dlinkedlist);
		dlinkedlist.addLast(79);
		System.out.println(dlinkedlist);
		dlinkedlist.addLast(81);
		System.out.println(dlinkedlist);
		
		// print out the list size
		System.out.println("List size: " + dlinkedlist.size());
		// print out true if the list is empty.
		System.out.println("isEmpty(): " + dlinkedlist.isEmpty());

		// Iterating forward
		System.out.println("Iterating elements in ascending order:");
		DoubleIterator<Integer> fwditeration = dlinkedlist.FwdIterator();
		while(fwditeration.hasNext())
		{
			int item = fwditeration.next();
			System.out.print(item + " ");
		}
		System.out.println();		
				
		// print out elements from list
		// Get the second element (zeroeth index)
		System.out.println("result of get(1): " + dlinkedlist.get(1));
		System.out.println("result of getFirst : " + dlinkedlist.getFirst());
		System.out.println("result of getLast: " + dlinkedlist.getLast());

		// Delete elements
		System.out.println("result of removeFirst(): " + dlinkedlist.removeFirst());
		System.out.println(dlinkedlist);
		System.out.println("result of removeLast(): " + dlinkedlist.removeLast());
		System.out.println(dlinkedlist);
		System.out.println("result of remove(1): " + dlinkedlist.remove(1));
		System.out.println(dlinkedlist);
		System.out.println();
		
		System.out.println("^^^ Instantiating an object of DoubleOrderedList ^^^");
		
		DoubleOrderedList<Integer> doubleorderedlist = new DoubleOrderedList<Integer>();
		
		// print out the list size
		System.out.println("List size: " + doubleorderedlist.size());
		// print out true if the list is empty.
		System.out.println("isEmpty(): " + doubleorderedlist.isEmpty());
		
		// Adding elements to the double ordered list
		doubleorderedlist.add(22);
		System.out.println(doubleorderedlist);
		doubleorderedlist.add(17);
		System.out.println(doubleorderedlist);
		doubleorderedlist.add(95);
		System.out.println(doubleorderedlist);
		doubleorderedlist.add(83);
		System.out.println(doubleorderedlist);
		doubleorderedlist.add(51);
		System.out.println(doubleorderedlist);
		doubleorderedlist.add(68);
		System.out.println(doubleorderedlist);
		
		// print out the double ordered list size
		System.out.println("List size: " + doubleorderedlist.size());
		// print out true if the double ordered list is empty.
		System.out.println("isEmpty(): " + doubleorderedlist.isEmpty());
		System.out.println();
		System.out.println("=== That's it ===");
	}
}

public class TestDoubleOrderedList
{
	public static void main(String[] args)
	{

		System.out.println("*** DoubleList *** ");
		// Instantiates a DoubleList object
		DoubleList<Integer> dlist = new DoubleList<Integer>();
		
		// Shows the list size
		System.out.println("List size: " + dlist.size());
		// Returns true if the list size is 0.
		System.out.println("isEmpty(): " + dlist.isEmpty());
		
		// Adds elements to the list
		System.out.println("Adds elements to front:");
		dlist.addFirst(3);
		System.out.println(dlist);
		dlist.addFirst(20);
		System.out.println(dlist);
		dlist.addFirst(15);
		System.out.println(dlist);
		System.out.println("Adds elements to rear:");
		dlist.addLast(5);
		System.out.println(dlist);
		dlist.addLast(50);
		System.out.println(dlist);
		dlist.addLast(1);
		System.out.println(dlist);
		
		// Shows the list size
		System.out.println("List size: " + dlist.size());
		// Returns true if the list size is 0.
		System.out.println("isEmpty(): " + dlist.isEmpty());

		// Forward iteration
		System.out.println("Elements in order:");
		DoubleIterator<Integer> fit = dlist.forwardIterator();
		while(fit.hasNext()) {
			int item = fit.next();
			System.out.print(item + " ");
		}
		System.out.println();

		// Backward iteration
		System.out.println("Elements in reverse order:");
		DoubleReverseIterator<Integer> bit = dlist.backwardIterator();
		while(bit.hasPrevious()) {
			int item = bit.previous();
			System.out.print(item + " ");
		}
		System.out.println();
				
		// Gets elements
		System.out.println("get(2) result: " + dlist.get(2));
		System.out.println("getFirst result: " + dlist.getFirst());
		System.out.println("getLast result: " + dlist.getLast());

		// Removes elements
		System.out.println("removeFirst() result: " + dlist.removeFirst());
		System.out.println(dlist);
		System.out.println("removeLast() result: " + dlist.removeLast());
		System.out.println(dlist);
		System.out.println("remove(2) result: " + dlist.remove(2));
		System.out.println(dlist);
		System.out.println();
		
		System.out.println("*** DoubleOrderedList *** ");
		// Instantiates a DoubleOrderedList object
		DoubleOrderedList<Integer> dolist = new DoubleOrderedList<Integer>();
		
		// Shows the list size
		System.out.println("List size: " + dolist.size());
		// Returns true if the list size is 0.
		System.out.println("isEmpty(): " + dolist.isEmpty());
		
		// Adds elements to the list
		dolist.add(15);
		System.out.println(dolist);
		dolist.add(20);
		System.out.println(dolist);
		dolist.add(3);
		System.out.println(dolist);
		dolist.add(5);
		System.out.println(dolist);
		dolist.add(50);
		System.out.println(dolist);
		dolist.add(1);
		System.out.println(dolist);
		
		// Shows the list size
		System.out.println("List size: " + dolist.size());
		// Returns true if the list size is 0.
		System.out.println("isEmpty(): " + dolist.isEmpty());
	}
}

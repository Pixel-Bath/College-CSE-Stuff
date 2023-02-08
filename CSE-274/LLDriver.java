// Kevin, CSE 274

public class LLDriver {
	
	public static void main(String[] args) {
		
		// As we test our methods, make sure the method works as expected...
		// ...with an empty list
		// ...with a non-empty list
		// **** YOU CAN MAKE ANY CHANGES YOU WANT TO THE CODE IN THIS METHOD ****
		// It is your tester.  Test thoroughly.
		// As we test our methods, make sure the method works as expected...
		// ...with an empty list
		// ...with a non-empty list
		
		LinkedList list = new LinkedList();
		System.out.println("?" + list.toString());
		
		list.insertFirst(17);
		list.insertFirst(20);	
		System.out.println("20 17? " + list.toString());
		
		list.insertLast(50);
		list.insertLast(51);
		System.out.println("20 17 50 51? " + list.toString());
		
		// add test of removeFirst
		list.removeFirst();
		System.out.println("20 is gone: " + list.toString());
		
		// add test of removeLast
		list.removeLast();
        System.out.println("51 is gone: " + list.toString());

		// add test of getSize()
		System.out.println("current list size: " + list.getSize());
		
		// add test of getFirst() and getLast() - these
		//methods should not change the list
		list.insertFirst(20);
		list.insertLast(51);
		System.out.println("\nRe-insert 20 and 51: " + list.toString());
		
		System.out.println("\nget First: " + list.getFirst());
		System.out.println("get Last: " + list.getLast());
		
		// Test getAt:
		System.out.println("Element at index 2: " + list.getAt(2));
		
		// Test exception:
		System.out.println("Testing exception: " + list.getAt(-1));
		// System.out.println("Testing exception: " + list.getAt(5));
		
	}
	
}

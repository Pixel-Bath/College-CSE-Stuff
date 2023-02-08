// Kevin Koepp, CSE 274

import java.util.NoSuchElementException;

public class LinkedList {
	
	private Node head;
	private Node tail;
	private int size;	
	
	/*
	 * Creates an empty list.
	 */
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/*
	 * Returns a space-separated list of the elements in the list.
	 * If the list contains no elements, return an empty string ""
	 */
	public String toString() {
		String result = "";
		Node current = head;
		
		while (current != null) {
		    result = result + current.data + " ";
		    current = current.next;
		    
		}
		
		return result;
	}
	
	
	/*
	 * Returns the first item in the list. If the list is empty,
	 * throw a NoSuchElementException.
	 */
	public int getFirst() {
		return head.data;
	}
	
	/*
	 * Returns the last item in the list. If the list is empty,
	 * throw a NoSuchElementException.
	 */
	public int getLast() {
		return tail.data;
	}
	
	/*
	 * Returns the item at the specified index. If the index
	 * is not valid, throw an IndexOutOfBoundsException.
	 */
	public int getAt(int index) {
	    
	    // Indices start at 0 and end at size - 1:
		Node current = head;
		int counter = 0;
		
		if (index < 0 || index >= size) {
		    throw new IndexOutOfBoundsException();
		}
		
		while (current.next != null) {
		    if (index == counter) {
		        return current.data;
		    }
		    
		    counter++;
		    current = current.next;
		}
		
		return -1;
		
	}
	
	/*
	 * Inserts an item at the beginning of the list.
	 */
	public void insertFirst(int num) {
	    Node f = new Node(num);
	    
	    if (this.isEmpty()) {
	        head = f;
	        tail = f;
	        
	    } else {
	        Node current = head;
	        head = f;
	        head.next = current;
	        
	        while (current.next != null) {
	            current = current.next;
	            
	        }
	        
	    }
		size++;
	}
	
	/*
	 * Inserts an item at the end of the list.
	 */
	public void insertLast(int num) {
	    Node f = new Node(num);
	    
	    if (this.isEmpty()) {
	        head = f;
	        tail = f;
	        
	    } else {
	        
	        Node current = head;
	        
	        while (current.next != null) {
	            current = current.next;
	            
	        }
	        tail = f;         
	        current.next = tail;
	        
	    }
		size++;
		
	}
	
	/*
	 * Removes and returns the first element from the list.  If the 
	 * list is empty, throw a NoSuchElementException.
	 */
	public int removeFirst() {
	    
	    int returnValue = head.data;
	    
	    if (head == tail) {
	        head = null;
	        tail = null;
	        
	    } else {
	        Node current = head;
	        head = null;
	        current = current.next;
	        head = current;
	        
	        while(current.next != null) {
	            current = current.next;
	            
	        }
	  
	    }   
	    size--;
		return returnValue;
		
	}
	
	/*
	 * Removes and returns the last element from the list.  If the 
	 * list is empty, throw a NoSuchElementException.
	 */
	public int removeLast() {
	    
	    if (this.isEmpty()) {
	        throw new NoSuchElementException();
	        
	    }
	    
	    int returnValue = tail.data;
	    
	    if (head == tail) {
	        head = null;
	        tail = null;
	        
	    } else {
	        Node current = head;
	        while(current.next != tail) {
	            current = current.next;
	            
	        }
	   
	        current.next = null;
	        tail = current;
	    }
	    
	    size--;
		return returnValue;
	}
	
	
	
	/*
	 * Returns the number of elements in the list.
	 */
	public int getSize() {
		return size;
	}
	
	/*
	 * Returns true if the list is empty, and false otherwise.
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	
	// A private Node class.  By making it an inner class, 
	// the outer class can access it easily, but the client cannot.	
	private class Node {
		private int data;
		private Node next;

		// Constructs a new node with the specified data
		private Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}

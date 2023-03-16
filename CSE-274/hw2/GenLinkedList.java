// Kevin Koepp, CSE 274

/**
 * Class for creating a Linked List to store media.
 * Adds, removes, and sorts elements of the Linked List. 
 * @author koeppkm2
 *
 * @param <T>
 */
public class GenLinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;
    
    /**
     * Constructor for creating an empty linked list.
     */
    public GenLinkedList() {
        first = null;
        last = null;
        size = 0;
        
    } // end GetLinkedList constructor.
    
    /**
     * Method to return number of elements in the list.
     * @return the size of the linked list
     */
    public int size() {
        return size;
        
    } // end size method.
    
    /**
     * Helper method checks if the linked list is empty.
     * @return true if the head does not contain data
     */
    public boolean isEmpty() {
        return first == null;
        
    } // end isEmpty() method.
   
    /**
     * Method to add a value to the end of the linked list.
     * @param value the value to be added.
     * @return true if value was added
     */
    public boolean add(T value) {
        Node<T> f = new Node<T>(value);
        
        if (this.isEmpty()) {
            first = f;
            last = f;
            
        } else {
            Node<T> current = first;
            
            while (current.next != null) {
                current = current.next;
                
            }
            last = f;
            current.next = last;
        }
        size++;
        return true;
        
    } // end add method.
    
    /**
     * Method removes the first item in the linked list
     * @return the value that was removed.
     * @throws IndexOutOfBoundsException if the size is 0.
     */
    public T remove() {
        
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
            
        } 
        
        T removeValue = (T)first.data;
        if (size == 1) {
            first = null;
            last = null;
            
        } else {
            Node<T> current = first;
            first = null;
            current = current.next;
            first = current;
            
            while(current.next != null) {
                current = current.next;
                
            }
        }
        
        size--;
        return removeValue;
        
    } // end remove method.
     
    /**
     * Method prints all elements of the LinkedList, separated by lines.
     * @return the list printed in String format.
     */
    public String toString() {
        
        String result = "";
        if (isEmpty()) {
            return "";
        } else {
            Node<T> current = first;
            while (current != null) {
                result += (current.data.toString() + "\n");
                current = current.next;
            }
            return result;
        }
        
    } // end toString method.
    
    /**
     * Method to clear the linked list.
     * 
     */
    public void clear() {
        while (!isEmpty()) {
            this.remove();
        }
        
    } // end clear method.
    
    /**
     * Method to implement the sort method in Interface.
     * It calls a separate method to perform merge sort.
     */
    public void sort() {
        mergeSort(first);
        
    } // end sort method.
    
    /**
     * Method sorts compareTo values of linked list using Merge Sort.
     * 
     * code inspired by Geeks4Geeks.org/merge-sort-for-linked-list
     */
    Node<T> mergeSort(Node<T> head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        Node<T> split = getMiddle(head);
        Node<T> splitNext = split.next;
        split.next = null;
        
        // Recursively split the linked list:
        Node split1 = mergeSort(head);
        Node split2 = mergeSort(splitNext);
        
        // Merge both sides and sort:
        Node result = merge(split1, split2);
        return result;
        
    } // end mergeSort method.
    
    /**
     * Method for finding the middle of a linked list.
     * @param x starting node pointer
     * @return the middle index of the pointer
     * 
     * code inspired by Geeks4Geeks.org/merge-sort-for-linked-list
     */
    public Node<T> getMiddle(Node<T> x) {
        
        // Null case for methods using recursion:
        if (x == null) {
            return x;
        }
        
        // Declare pointers:
        Node<T> point1 = x;
        Node<T> point2 = x;
        
        // Use pointers to check for the middle:
        while(point2.next != null && point2.next.next != null) {
            point1 = point1.next;
            point2 = point2.next.next;
        }
        return point1;
        
    } // end getMiddle method.
    
    /**
     * Helper method to merge two linked lists together, sorted.
     * @param link1 the first linked list
     * @param link2 the second linked list
     * 
     * code inspired by Geeks4Geeks.org/merge-sort-for-linked-list
     */
    Node<T> merge(Node<T> side1, Node<T> side2) {
        Node<T> result = null;
        
        // Base cases, return either side if the other is null:
        if (side1 == null) {
            return side2;
        } 
        
        if (side2 == null) {
            return side1;
        }
        
        // Sort from least to greatest:
        if (side1.data.compareTo(side2.data) <= 0) {
            result = side1;
            
            // Use recursion to check the next nodes:
            result.next = merge(side1.next, side2);
            
        } else {
            result = side2;
            result.next = merge(side1, side2.next);
        }
        
        // If the current head is moved, change the current head:
        if (result.next == first) {
            first = result;
        }
        
        return result;
        
    } // end merge method.
    
    /**
     * Private class for creating LinkedList nodes. Set inside
     * inner class for use only by this file.
     * @author koeppkm2
     *
     * @param <T>
     */
    private class Node<S extends Comparable<S>> {
        private S data;
        private Node next;
        
        /**
         * Simple constructor for creating nodes and linking the nodes.
         * @param data
         */
        private Node(S data) {
            this.data = data;
            this.next = null;
        } // end Node constructor.
    }  // end Node class.
    
} // end class.
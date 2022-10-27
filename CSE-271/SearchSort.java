import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Methods to apply some of the concepts of searching and sorting for
 * problem-solving. These problems are commonly asked on Job-interviews and
 * hence also included in exams.
 */
public class SearchSort {
    /**
     * Complete the following insert method that must create a new list that
     * contains all the elements in list and the given item inserted
     * appropriately into the new list. Assume that the original list is
     * initially sorted in ascending order (i.e., from smallest to largest).
     * For example insert({2,3,5,6}, 4) should return new list containing the
     * values {2,3,4,5,6}.
     * 
     * @see Arrays.binarySearch
     * @see System.arraycopy
     * 
     * @param list Sorted (in ascending order) list of values. Do not modify
     *             this list.
     * @param item The item to be inserted into the newly created list.
     * @return A new sorted list (in ascending order) with the item inserted at
     *         the appropriate location.
     */
    public static int[] insert(int[] list, int item) {
        
        // Create a new Array list with 1 extra index:
        int[] newList = new int[list.length + 1];
        
        // Recover the index through binarySearch:
        int idx = Arrays.binarySearch(list, item);
        
        // If there are no duplicates of the item, change the index:
        if (idx < 0) {
            idx = (idx * -1) - 1;
        }
        
        // Insert the new element at the proper index:
        System.arraycopy(list, 0, newList, 0, idx);
        newList[idx] = item;
        System.arraycopy(list, idx, newList, idx + 1, list.length - idx);
        
        return newList;
    }
    

    /**
     * Implement this method to use Collections.sort to sort a list of
     * numbers (in descending order) based on their last digit value only.
     * For example, given the list {50, 11, 109} this method should sort
     * the numbers into {109, 11, 50} (based on the value of just the last
     * digit)
     * 
     * @see Collections.sort
     * 
     * @note You will need to write a suitable lambda for the sorting
     *     comparator to appropriately sort based on the last digit only.
     * 
     * @param list The list to be sorted.
     */
    public static void sortLastDigit(ArrayList<Integer> list) {
        
        // (y % 10) - (x % 10) = sort by descending last digit:
        Collections.sort(list, (x, y) -> (y % 10) - (x % 10));
    }
    
    /**
     * Implement this method to counts how many value occur in both list1 and
     * list2. Assume both lists are sorted in ascending order. Also assume that
     * neither list1 nor list2 has any duplicates in itself. For example
     * countDuplicates({1,2,4,5}, {2,3,5,6}) should return 2 (since both lists
     * contain the numbers 2 and 5). You are expected to achieve this task
     * without making multiple passes over either list (your code should only
     * have a single loop)
     *  
     * @param list1 The first sorted list. Do not modify this list.
     * @param list2 The second sorted list. Do not modify this list.
     * @return The number of values that occur in both lists.
     */
    public static int countDuplicates(int[] list1, int[] list2) {
        
        // Initialize index and count:
        int count = 0;
        int index1 = 0;
        int index2 = 0;
        
        // While the indices are less than lists, check for dupes:
        while ((index1 < list1.length) && (index2 < list2.length)) {
            
            // if a dupe exists:
            if (list1[index1] == list2[index2]) {
                count++;
                index1++;
                index2++;
            } else if (list1[index1] > list2[index2]) {
                index2++;
            } else {
                index1++;
            }
        }
        
        return count;
    }
}

import java.util.ArrayList;

/**
 * A standard implementation of merge sort algorithm. The merge sort
 * is designed to sort ArrayList of objects.
 * 
 * @author raodm
 *
 */
public class MergeSort {
    /**
     * The merge method that is used to combine two merged lists into a single
     * sorted merged list.
     * 
     * @note This  method creates an intermediate list that takes a bit more
     *     memory.
     * 
     * @param <X> The generic data type that is used for comparisons.
     * @param data The list of values to be sorted.
     * @param first The starting index in data to be merged.
     * @param mid The middle index in data to be merged.
     * @param last The last index in the data to be merged.
     */
    static <X extends Comparable<X>> 
        void merge(ArrayList<X> data, int first, int mid, int last) {
        
        // Create temporary ArrayList:
        ArrayList<X> temp = new ArrayList<X>();
        
        // Initialize pointers:
        int first1 = first, last1 = mid;
        int first2 = mid + 1, last2 = last;
        
        // While first1 and first2 are before their last pointers:
        while (first1 <= last1 || first2 <= last2) {
            if ((first2 > last2) 
                    || ((first1 <= last1) 
                            && (data.get(first1).compareTo(data.get(first2)) 
                                    < 0))) {
                
                // Add to the temporary ArrayList:
                temp.add(data.get(first1));
                first1++;
                
            } else {
                temp.add(data.get(first2));
                first2++;
            }

        }
        
        
        for (int i = first; (i <= last); i++) {
            
            // Replace data's elements with temp's:
            data.set(i, temp.get(i - first));
        }
        
    }

    /**
     * A simple implementation of the merge sort algorithm. This method
     * uses the merge method and then recursively merge sorts each
     * sublist.
     * 
     * @param <X>  Class that implement the Comparable interface
     * @param data The list of objects to be sorted. The compareTo method is
     *             used to sort the objects.
     * @param min  The starting index for partitioning. This value is also
     *             assumed to be the pivot.
     * @param max  The ending index value for partitioning.
     */
    public static <X extends Comparable<X>> 
        void mergeSort(ArrayList<X> data, int min, int max) {
        final int mid = (min + max) / 2;
        if (min < max - 1) {
            mergeSort(data, min, mid);
            mergeSort(data, mid + 1, max);
        }
        merge(data, min, mid, max);
    }
}

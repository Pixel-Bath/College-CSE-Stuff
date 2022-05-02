// Kevin
// CSE 174
// Lab 13
// April 29, 2022
// This Lab is a series of methods that manipulate points.
import java.awt.Point;

public class PointArray {
  
  // main method for testing.
  public static void main(String[] args) {    
  } // end main

  // This method prints arrays.
  // @param arr a point array.
  // no return value.
  public static void print(Point[] arr) {
    
    System.out.print("[");
    int n = 0;
    for (n = 0; n < arr.length - 1; n++) {
      System.out.print("(" + arr[n].getX() + ", "
          + arr[n].getY() + "), ");
    }
    System.out.print("(" + arr[n].getX() + ", "
          + arr[n].getY() + ")");
    System.out.print("]\n");
    
  } // end print method
  
  /* This method takes a point and inserts it into a given
   * point array.
   * @param arr a Point[] array.
   * @param pos an int for index.
   * @param newPoint the point inserted into the array.
   * return an array with inserted point.
   */
  public static Point[] insert(Point[] arr, int pos, Point newPoint) {
    
    // make a new point:
    Point[] newArr = new Point[arr.length + 1];
    
    // insert the point:
    for (int i = 0; i < pos; i++) {
      newArr[i] = arr[i];
    }
    
    newArr[pos] = newPoint;
    
    for (int i = pos; i < arr.length; i++) {
      newArr[i + 1] = arr[i];
    }
    return newArr;
  } // end insert method
  
  /* This method removes a point froma  given array.
   * @param arr a Point[] array.
   * @param pos an index int.
   * return an array with removed point at pos.
   */
  public static Point[] remove(Point[] arr, int pos) {
    
    // Create a new "small point":
    Point[] smallPoint = new Point[arr.length - 1];
    
    // remove the index by skipping over it:
    for (int i = 0; i < pos; i++) {
      smallPoint[i] = arr[i];
    }
    for (int i = pos + 1; i < arr.length; i++) {
      smallPoint[i - 1] = arr[i];
    }
    return smallPoint;
  } // end remove method
  
  /* This method will search by counting each element
   * in an array.
   * @param arr a Point[] array.
   * @param key a Point that is being searched.
   * return the index of key.
   */
  public static int linearSearch(Point[] arr, Point key) {
    
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals(key)) {
        return i;
      }
    }
    return -1;
  } // end linearSearch method
  
  /* This method performs binary search and finds the first point
   * named key and returns the index.
   * @param Point[] arr a Point array.
   * @param key a Point value being searched.
   * return the index of key.
   */
  public static int binarySearch(Point[] arr, Point key) {
    int min = 0;
    int max = arr.length - 1;
    
    // Start the search in the middle:
    while (max >= min) {
      int mid = (max + min) / 2;
      
      // if the middle = key, return the index of the middle point:
      if (arr[mid].getX() == key.getX()) {
        return mid;
      // If the middle is smaller than the key, increase:
      } else if (arr[mid].getX() < key.getX()) {
        min = mid + 1;
      // Otherwise, decrease:
      } else {
        max = mid - 1;
      }
    }
    return -1;
  } // end binarySearch method
  
} // end class
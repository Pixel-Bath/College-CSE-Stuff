// Kevin
// CSE 174
// May 6, 2022
// Lab 14 - A Place for Everything, Everything in its Place

// This program sorts an array of Points by X values (and then Y values if
// X values are the same).

// import necessary tools:
import java.util.Scanner;
import java.awt.Point;

public class PointSorter {
  public static void main(String[] args) {
    
    // create a scanner and allow to user to create a point array:
    Scanner ip = new Scanner(System.in);
    System.out.print("How many points would you like to sort? ");
    int arrayLength = ip.nextInt();
    
    Point[] pointArr = new Point[arrayLength];
    
    // create number of points based on how many points user wants to sort:
    for (int i = 0; i < arrayLength; i++) {
      System.out.print("Enter X value for your point: ");
      int pointA = ip.nextInt();
      System.out.print("Enter Y value for your point: ");
      int pointB = ip.nextInt();
      System.out.println();
      
      pointArr[i] = new Point(pointA, pointB);
    }
    
    // call both methods:
    System.out.print("Unsorted: ");
    printArray(pointArr);
    System.out.print("Sorted  : ");
    printArray(sortArray(pointArr));
   
  } // end main method
  
  /* This method prints an Array in the required format.
   * @param pointArr a Point[] array
   * no return value.
   */
  public static void printArray(Point[] pointArr) {
    
    System.out.print("[");
    int n = 0;
    for (n = 0; n < pointArr.length - 1; n++) {
      System.out.print("(" + pointArr[n].getX() + ", "
          + pointArr[n].getY() + "), ");
    }
    
    System.out.print("(" + pointArr[n].getX() + ", "
          + pointArr[n].getY() + ")");
    System.out.print("]\n");
    
  } // end printArray method
  
  /* This method performs selection sort on the point array.
   * @param arr the Point array to be sorted.
   * return the sorted point array.
   */ 
  public static Point[] sortArray(Point[] arr) {
    
    // start the selection sort, prioritize the X coordinate:
    for (int i = 0; i < arr.length - 1; i++) {
    
      int iMin = i;
      
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j].getX() < arr[iMin].getX()) {
          iMin = j;
        
        // if x coordinates are the same, move to the Y values:
        } else if (arr[j].getX() == arr[iMin].getX()) {
          if (arr[j].getY() < arr[iMin].getY()) {
            iMin = j;
          }
        }
      }
      
      // swap point values:
      Point temp = new Point((int)arr[iMin].getX(), (int)arr[iMin].getY());
      arr[iMin] = arr[i];
      arr[i] = temp;
    }
    return arr;
    
  } // end sortArray method
} // end class
    
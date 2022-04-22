// Kevin Koepp
// CSE 174
// 4-22-2022
// Lab 12

// This program prints an array based on given size and value.
import java.util.Scanner;

public class Arrays {
  public static void main(String[] args) {
    
    // Prompt for size/value inputs:
    Scanner ip = new Scanner(System.in);
    System.out.print("How many rows for your table? ");
    int valueOne = ip.nextInt();
    System.out.print("How many cols for your table? ");
    int valueTwo = ip.nextInt();
    System.out.print("What value should fill your table? ");
    int valueThree = ip.nextInt();
    
    // Create a new array by calling the makeArray method:
    int[][] newArray = makeArray(valueOne, valueTwo, valueThree);
    
    // Print the array:
    printArray(newArray);
    
  } // end main method
  
  /* This method creates an array with the inputs from the main method
   * @param makeRow an int for the row
   * @param makeColumn an int for the column
   * @param setValue an int to set the value which prints in the array
   * return the new array's memory location.
   */
  public static int[][] makeArray(int makeRow, int makeColumn, int setValue) {
    
    // For every row, set the value for each column:
    int[][] anArray = new int[makeRow][makeColumn];
    for (int i = 0; i < makeRow; i++) {
      for (int j = 0; j < makeColumn; j++) {
        anArray[i][j] = setValue;
      }
    }
    return anArray;
    
  } // end makeArray method
  
  /* This method prints out the created array
   * @param array the Array value created in the previous method.
   * no return value.
   */
  public static void printArray(int[][] array) {
    
    //Print the current row/column with 1 space in between each:
    for (int i = 0; i < array.length; i++) {
      System.out.println();
      for (int j = 0; j < array[i].length; j++) {
        System.out.print(array[i][j] + " ");
      }
    }
    System.out.println();
    
  } // end printArray method
} // end class

      
  

    
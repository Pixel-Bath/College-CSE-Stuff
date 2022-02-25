// Kevin
// CSE 174
// 2-25-2022
// Lab 5
// This program makes a multiplication table based upon inputs
// for the table's columns and rows.


// import scanner
import java.util.Scanner;

public class NumberTable {
  public static void main(String[] args) {
  
    Scanner ip = new Scanner(System.in);
    
    // The number MUST be less than or equal to 20 for BOTH
    // columns and rows.
    int column;
    do {
      System.out.print("How many columns should be in the table: ");
      column = ip.nextInt();
    } while (column > 20);
    
    int row;
    do {
      System.out.print("How many rows should be in the table: ");
      row = ip.nextInt();
    } while (row > 20);
    
    System.out.println();
    
    // Print new lines to the length of the column number
    for (int i = 1; i <= row; i++) {
    
      // Print an entire row of numbers counting to the length
      // of the row number, starting at 1.
      for (int j = 1; j <= column; j++) {
      
        // Multiply both counters to make the multiplication table
        int product = i * j;
        System.out.printf("%4d", product);
      }
      // print a new line for the table.
      System.out.printf("%n");
    }  
  }
} // end class

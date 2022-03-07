// Name: Kevin
// Date: 3-4-2022
// Lab 6
// This program collects integers from a file and outputs the sum, min, max, 
// and average of the integers. The program will skip over all non-integers.

// import Scanner, files, and errors:
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class TryCatch {
  public static void main(String[] args) throws FileNotFoundException {
    
    // Create new scanner and declare fileNames and input
    Scanner ip = new Scanner(System.in);
    String fileName;
    Scanner input;
    
    // "Exists" determines if a file exists. If yes, the loop is broken.
    // "invalid" prompts to input a file that exists if an error is caught.
    boolean exists = false;
    boolean invalid = false;
    
    do {
      
      if (!invalid) {
        System.out.print("Please enter the name of the file: ");
      } else {
        System.out.print("Please enter a valid file name: ");
      }
      fileName = ip.next();
      
      // Try and make a new file using the input. Otherwise, loop back:
      try {
        input = new Scanner(new File(fileName));
        exists = true;
      } catch (FileNotFoundException err) {
        System.out.println(err.getMessage());
        invalid = true;
      }
    } while (!exists);
    
    input = new Scanner(new File(fileName));
    
    // Declare/Initialize number variables:
    int num = 0;
    int sum = 0;
    float average;
    int counter = 0;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    
    // Scan for integers and skip over anything else:
    while (input.hasNext()) {
      try {
        num = input.nextInt();
        counter++;
      } catch (InputMismatchException eee) {
        System.out.println("Skipping over invalid input: " + input.next());
      }
      
      // Add ints in file together and count the amount of ints:
      sum += num;
      
      // Find the min and max:
      if (num < min) {
        min = num;
      }
      if (num > max) {
        max = num;
      } 
    }
    
    // Print that there was no data found if there were no ints in file.
    // Otherwise, calculate average and print:
    if (counter == 0) {
      System.out.println("\nNo valid data found. No stats available.");
    } else {
      average = sum / counter;
      System.out.println("\nTotal  : " + sum);
      System.out.println("Min    : " + min);
      System.out.println("Max    : " + max);
      System.out.printf("Average: %.1f%n", average);   
    }
  }
} // end class

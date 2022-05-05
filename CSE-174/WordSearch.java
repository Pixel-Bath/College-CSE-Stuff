// Kevin
// CSE 174
// May 3, 2022
// Assignment 4
// This program searches for a word in a file, and returns
// its state of existence, as well as the number of times
// it performed linear and binary comparisions.

// import tools:
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordSearch {
  public static void main(String[] args) {
    
    // Create two null scanners:
    Scanner ip = new Scanner(System.in);
    Scanner scanSize = null;
    Scanner scanFill = null;
    
    // prompt user for a fileName:
    System.out.print("Enter a file name: ");
    String fileName = ip.next();
    
    String[] fileArr = arrayMaker(scanSize, scanFill, fileName);
    
    // if the "dummy" array is not returned, call the prompt method:
    if (!fileArr[0].equals("nope")) {
      prompt(ip, fileArr, fileName);
    }
  } // end main method
  
  /* This method prompts the user for searching words in a file, and
   * prints the search results.
   * @param ip the Scanner input object
   * @param fileArr a String[] array
   * @param file a String value (filename)
   * no return value. 
   */
  public static void prompt(Scanner ip, String[] fileArr, String file) {
  
    String reply = "";
    
    // loop will stop if user types "n":
    while (!reply.equalsIgnoreCase("n")) {
      
      while (!reply.equalsIgnoreCase("n") && !reply.equalsIgnoreCase("y")) {   
        System.out.print("Would you like to search for a word? (y/n): ");
        reply = ip.next();
        
        if (reply.equalsIgnoreCase("y")) {
          System.out.print("Which word would you like to find? ");
          String key = ip.next();
          
          // save search integers and print them:
          int linearInt = linearSearch(fileArr, key);
          System.out.println("Linear Search for " + key + ": " 
              + linearInt + " comparisions");
          int binaryInt = binarySearch(fileArr, key);
          System.out.println("Binary Search for " + key + ": "
              + binaryInt + " comparisions");
          System.out.println();
          
          // reset the reply value to exit the nested loop:
          reply = "";     
        }
      }
    }
  } // end prompt method
  
  /* This method creates an Array using file contents.
   * @param size a Scanner object
   * @param fill a Scanner object
   * @param file a String object (filename)
   * return an Array made from the file's strings.
   */
  public static String[] arrayMaker(Scanner size, Scanner fill, String file) {
    
    // create a "dummy" array that prevents the code from continuing:
    String[] dummy = new String[] {"nope"};
    
    // validate file existence:
    try {
      size = new Scanner(new File(file));
      fill = new Scanner(new File(file));
    } catch (FileNotFoundException err) {
      System.out.println("Invalid file name.");
      return dummy;
    }
    
    // "count" will be the length of the array:
    int count = 0;
    while (size.hasNext()) {
      count++;
      size.next();
    }
    
    size.close();
    String[] fileArr = new String[count];
    count = 0;
    
    // fill the array with file contents:
    while (fill.hasNext()) {
      fileArr[count] = fill.next();
      count++;
    }
    
    fill.close();
    return fileArr;
  } // end linearSearch method
  
  /* This method performs a linear search using an Array and a keyword.
   * @param fileArr the array of the searched file.
   * @param word the word intended to be searched.
   * return number of linear comparisions.
   */
  public static int linearSearch(String[] fileArr, String word) {
    
    // start counter at 0:
    int count = 0;
    for (int i = 0; i < fileArr.length; i++) {
      count++;
      if (fileArr[i].compareTo(word) == 0) {
        System.out.println("File contains the word " + word);
        return count;
      }
    }
    // if the word is not in the file, return count anyway:
    System.out.println("File does not contain the word " + word);
    return count;
    
  }
  
  /* This method performs a binary search using an Array and a keyword.
   * @param fileArr the array of the searched file.
   * @param word the word intended to be searched.
   * return number of binary comparisions.
   */
  public static int binarySearch(String[] fileArr, String word) {
    
    int max = fileArr.length - 1;
    int min = 0;
    
    // start counter at 0:
    int count = 0;
    while (max >= min) {
      int mid = (max + min) / 2;
      count++;
      if (fileArr[mid].compareTo(word) == 0) {
        return count;
      } else if (fileArr[mid].compareTo(word) < 0) {
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }
    
    // return count even if the word is not in the file:
    return count;
    
  } // end binarySearch method
}

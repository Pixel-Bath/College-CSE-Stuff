// Name: Kevin
// CSE 174
// Date: 3-15-2022
// Assignment 2: Palindrome Machine

// The "Palindrome Machine" has three options: Check if a typed word 
// is a palindrome, Check if an entire file is a palindrome, 
// or exit. It will loop until the program is exited.

// Import required files
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Palindrome {
  public static void main(String[] args) throws FileNotFoundException {
  
    // Create the Input Scanner:
    Scanner ip = new Scanner(System.in);
  
    // Start the loop for the machine. Always true:
    while (true) {
  
      System.out.println("Welcome to the Palindrome Machine!");
      System.out.println("-----------------------------------");
      System.out.println("1. Read one word from the keyboard");
      System.out.println("2. Read one or more words from a file");
      System.out.println("3. Exit");
      System.out.print("Enter your selection: ");
      int selection = ip.nextInt();
      
      // Break out of the loop if the user enters 3:
      if (selection == 3) {
        break;
       
      } else if (selection == 1) {
        
        // Prompt the user with the word they'd like to check:
        System.out.print("Enter the word you would like to check: ");
        String word = ip.next();
        
        // Create a "mirror" string that saves each letter of the
        // "word" variable backwards.
        String mirror = "";
        for (int j = word.length() - 1; j >= 0; j--) {
          mirror += word.charAt(j);
        }
        
        // Check if the word is the same backwards as it is forwards:
        if (word.equals(mirror)) {
          System.out.println(word + ": this word is a palindrome\n");
        } else {
          System.out.println(word + ": this word is not a palindrome\n");
        }
      
      } else if (selection == 2) {
        
        // Prompt the user for a file they'd like to check:
        System.out.print("Enter the file you would like to check: ");
        String fileName = ip.next();
        Scanner in;
        
        // Check to see if the file exists. If not, loop back to menu:
        try {
          in = new Scanner(new File(fileName));
        } catch (FileNotFoundException err) {
          System.out.println("Invalid file\n");
          continue;
        }
        
        // Create "content" variable:
        String content = "";
        
        // Assume the contents of the file are either a palindrome
        // or not. Scan each line:
        if (in.hasNext()) {
          while (in.hasNextLine()) {
            content += in.nextLine();
          }
        }
        
        // Same as the "mirror" string, just scan every letter
        // in the file's contents in reverse:
        String backwards = "";
        for (int j = content.length() - 1; j >= 0; j--) {
          backwards += content.charAt(j);
        }
        
        // If the content going forward is the same as backwards:
        if (content.equals(backwards)) {
          System.out.println(content + ": this file is a palindrome\n");
        } else {
          System.out.println(content + ": this file is not a palindrome\n");
        }
      
      // If the selection is anything except 1, 2, or 3:
      } else {
        System.out.println("Invalid menu option\n");
      }
    }
  }
} // end class
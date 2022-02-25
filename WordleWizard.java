// Name: Kevin
// CSE 174
// 2-25-2022
// This program scans other files inputted by the user and sends back
// all 5-letter words (valid for the game Wordle) found within that
// file.

// Import three required scanners:
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordleWizard {
  public static void main(String[] args) throws FileNotFoundException {
  
    Scanner kb = new Scanner(System.in);
    
    // Input the file to read:
    System.out.print("Please enter the name of your Wordle file: ");
    String fileName = kb.next();
    
    Scanner file = new Scanner(new File(fileName));
    
    System.out.println("");
    
    // Scan the file one word each for 5-Letter words:
    int validWordle = 0;
    while (file.hasNext()) {
      String input = file.next();
      
      if (input.length() == 5) {
        System.out.println(input);
        validWordle++;
      }      
    }
    
    // Print out all words found and total number of words found.
    System.out.printf("%n%s contained %d valid Wordle words.%n", fileName, validWordle);
        
  }
} // end class
  
  

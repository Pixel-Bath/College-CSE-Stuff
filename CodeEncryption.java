// Kevin Koepp
// CSE 174
// Assignment 1: Secret Code Encryption

// Scanner required for reading input
import java.util.Scanner;

// This code takes a 5-letter word and outputs an encrypted word using a
// key between 1 and 1000.
public class CodeEncryption {
  public static void main(String[] args) { 
    Scanner ip = new Scanner(System.in);
    
    // enter inputs
    System.out.print("Please enter a 5-letter word: ");
    String word = ip.next();
    
    System.out.print("Please enter a key value between 1 and 1000: ");
    int key = ip.nextInt();

    // Turn encryption key into a shift value between 0 and 42
    // output the shift value (optional)
    float shiftValue = key % 43;
    System.out.println("Shift value: " + (int)shiftValue);
    System.out.println("");
    
    // Shift characters indicated by shift value
    int firstLetter = word.charAt(0);
    int secondLetter = word.charAt(1);
    int thirdLetter = word.charAt(2);
    int fourthLetter = word.charAt(3);
    int fifthLetter = word.charAt(4);
    
    int firstShift = firstLetter - (int)shiftValue;
    int secondShift = secondLetter - (int)shiftValue;
    int thirdShift = thirdLetter - (int)shiftValue;
    int fourthShift = fourthLetter - (int)shiftValue;
    int fifthShift = fifthLetter - (int)shiftValue;   
          
    // Print the encrypted word and cast char:
    System.out.print("Your encrypted word is: " + (char)firstShift
        + (char)secondShift + (char)thirdShift + (char) fourthShift
            + (char)fifthShift);
  }
} // end class



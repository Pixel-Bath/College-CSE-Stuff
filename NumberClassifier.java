// Kevin Koepp
// CSE 174
// 2-18-22
// Lab 4: Number Converter

// This program takes an integer at 0 or greater, and checks if the number is
// even or odd, divisible by 3 or 5, divisible by 4 or 6, or 0. It then checks
// if the number is greater than 1000 or not.

// import the scanner for inputs:
import java.util.Scanner;

public class NumberClassifier {
  public static void main(String[] args) {
  
    // New scanner and enter inputs:
    Scanner ip = new Scanner(System.in);
    System.out.println("Please provide an integer (0 or greater) to classify:"
         + " ");
    int num = ip.nextInt();
  
    // Nested if statements:
    // Is the number > zero and even?
    if (num > 0 && num % 2 == 0) {
      if (num % 4 == 0 || num % 6 == 0) {
        System.out.println("Your number is even and also divisible by 4 or 6.");
      } else {
        System.out.println("Your number is even but not divisible by 4 or 6."); 
      }    
      
    // Is the number odd?
    } else if (num % 2 == 1) {
      if (num % 3 == 0 || num % 5 == 0) {
        System.out.println("Your number is odd and is also divisible by 3"
            + " or 5.");
      } else {
        System.out.println("Your number is odd but not divisible by 3 or 5.");
      }
      
    // Is the number 0?
    } else if (num == 0) {
      System.out.println("Your number is 0.");
    }
    
    // Check whether the number is larger than 1000 or not
    // Using a ternary operator:
    String large = num >= 1000 ? "is a" : "is not a";
    System.out.println("Further, this " + large + " large number.");  
  }
} // end class
  
  
  
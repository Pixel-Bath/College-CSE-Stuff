// Kevin
// CSE 174
// April 8, 2022
// Lab 10
// This lab is a series of overloading methods, which add numbers
// and determine if numbers are prime/breakable.

public class Lab10 {
  
  /* This method adds two integers.
   * @ param n1 the first int to add
   * @ param n2 the second int to add
   * return the sum of n1 and n2
   */
  public static int add(int n1, int n2) {
    return n1 + n2;
  } // end add method
  
  /* This method adds three integers.
   * @ param n1 the first int to add
   * @ param n2 the second int to add
   * @ param n3 the third int to add
   * return the sum of n1, n2, and n3
   */
  public static int add(int n1, int n2, int n3) {
    return n1 + n2 + n3;
  } // end add method
  
  /* This method adds four integers.
   * @ param n1 the first int to add
   * @ param n2 the second int to add
   * @ param n3 the third int to add
   * @ param n4 the fourth int to add
   * return the sum of n1 + n2 and n3 + n4
   */
  public static int add(int n1, int n2, int n3, int n4) {
    int result = Lab10.add(n1, n2) + Lab10.add(n3, n4);
    return result;
  } // end add method
  
  /* This method adds five integers.
   * @ param n1 the first int to add
   * @ param n2 the second int to add
   * @ param n3 the third int to add
   * @ param n4 the fourth int to add
   * @ param n5 the fifth int to add
   * return the sum of n1 + n2 + n3 and n4 + n5
   */
  public static int add(int n1, int n2, int n3, int n4, int n5) {
    int result = Lab10.add(n1, n2, n3) + Lab10.add(n4, n5);
    return result;
  } // end add method
  
  /* This method checks if a number is prime
   * @ param num an int to check if prime
   * return whether the number is prime or not
   */
  public static boolean isPrime(int num) {
    if (num <= 1) {
      return false;
    } else {
    
      // Divide each number counting up to "num"
      // starting at 2:
      for (int j = 2; j < num; j++) {
        if (num % j == 0) {
          return false;
        }
      }
      return true;
    }
  } // end isPrime method
  
  /* This method checks to see if an integer is "breakable"
   * @ param num the Int to check if breakable
   * return true if at least one digit within the number entered is prime
   */
  public static boolean isBreakable(int num) {
    String numStr = Integer.toString(num);
    int primeCheck = 0;
    
    // Check each digit to look for a prime number:
    for (int j = 0; j < numStr.length(); j++) {
      primeCheck = Integer.parseInt(numStr.substring(j, j + 1));
      if (Lab10.isPrime(primeCheck)) {
        return true;
      }
    }
    return false;
  } // end isBreakable method
  
  /* This method checks to see if an double is "breakable".
   * @ param num the double to check if breakable
   * return whether the double is breakable or not
   */
  public static boolean isBreakable(double num) {
    
    // Turn the double into a string:
    String breakStr = Double.toString(num);
    String firstNum = "";
    String secondNum = "";
    
    // Split the string into two ints from the decimal:
    for (int j = 0; j < breakStr.length(); j++) {
      if (breakStr.charAt(j) == '.') {
        firstNum = breakStr.substring(0, j);
        secondNum = breakStr.substring(j + 1, breakStr.length());
      }
    }
    
    // Turn both number strings into ints:
    int firstInt = Integer.parseInt(firstNum);
    int secondInt = Integer.parseInt(secondNum);
    
    // Check both ints for if they're breakable. If both ints are
    // breakable, return false. Else, return true:
    if (Lab10.isBreakable(firstInt) && Lab10.isBreakable(secondInt)) {
      return false;
    } else if (Lab10.isBreakable(firstInt) || Lab10.isBreakable(secondInt)) {
      return true;
    } else {
      return false;
    }
  } // end isBreakable method
} // end class
// CSE 274

import java.util.Scanner;
import java.util.Stack;

/**
 * This class takes a number and returns an equivalent
 * binary sequence.
 * @author koeppkm2
 *
 */
public class BinaryStack {
    
    public static void main(String[] args) {
        
        // Initialize exit bool and scanner for user input:
        boolean exit = false;
        Scanner ip = new Scanner(System.in);
        
        // Loop until user prompts -1:
        while (!exit) {
            System.out.print("Please enter a positive integer "
                    + "(or -1 to exit): ");
            int num = ip.nextInt();
            
            if (num == -1) {
                exit = true;
            
            // Loop back if the user enters a negative int that isn't -1:
            } else if (num < 0) {
                System.out.println("Please enter a positive number!\n");
            
            // Otherwise, convert the int to a binary sequence:
            } else {
                binaryConvert(num);
            }
        }
        
        // Close scanner:
        ip.close();
        
    } // end main method.
    
    /**
     * Method converts an integer to binary.
     * @param x the integer to be converted.
     */
    public static void binaryConvert(int x) {
        
        // Create a new Stack:
        Stack<Integer> binary = new Stack<Integer>();
        
        // Push the remainder of x / 2 until x is 0:
        while (x != 0) {
            binary.push(x % 2);
            x = x / 2;
        }
        
        // String for storing binary sequence:
        String seq = "";
        
        // Add each bit from the stack to seq:
        while (!binary.isEmpty()) {
            seq += binary.pop();
        }
        
        // Print the binary sequence:
        System.out.println("Binary sequence is " + seq + ".\n");
        
    } // end binaryConvert method.
} // end class
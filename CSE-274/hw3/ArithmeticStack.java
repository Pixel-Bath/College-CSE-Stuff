// CSE 274

import java.util.Scanner;
import java.util.Stack;

/**
 * Class is designed to evaluate an arithmetic equation
 * using a stack.
 * @author koeppkm2
 *
 */
public class ArithmeticStack {
    
    public static void main(String[] args) {
        
        // Initialize an exit boolean and a Scanner for user input:
        boolean exit = false;
        Scanner ip = new Scanner(System.in);
        
        // Prompt for user input:
        while (!exit) {
            System.out.print("Please enter an equation (Or -1 to exit): ");
            String equation = ip.next();
            
            // Exit the loop if the input is -1:
            if (equation.equals("-1")) {
                exit = true;
                
            } else {
                
                // Check for proper parenthesis format in the equation:
                if (checkParentheses(equation)) {
                    System.out.println("This equation is valid.");
                } else {
                    System.out.println("This equation is NOT valid.");
                }

            }
        }
        
        // Close the scanner:
        ip.close();
    } // end main method.
    
    /**
     * Method checks for proper structure of parenthesis.
     * @param x input from user to be checked
     * @return true if equation is valid.
     */
    public static boolean checkParentheses(String x) {
        
        // Initialize counters and Stack:
        int countOne = 0;
        int countTwo = 0;
        Stack<String> eqStack = new Stack<String>();
        
        // Push all the characters onto the stack:
        for (int i = 0; i < x.length(); i++) {
            eqStack.push(x.substring(i, i + 1));
        }
        
        // Pop and check each character until the stack is empty:
        while (!eqStack.isEmpty()) {
            String chr = eqStack.pop();
            
            // Add to specific counters for any parentheses:
            if (chr.equals(")")) {
                countOne++;
            } else if (chr.equals("(")) {
                countTwo++;
            }
            
            // If there are more "(" than ")" found, return false:
            if (countTwo > countOne) {
                return false;
            }
        }
        
        // Return whether the parentheses count is equal or not:
        if (countOne == countTwo) {
            return true;  
        } else {
            return false;  
        }
    } // end checkParentheses method.
} // end class
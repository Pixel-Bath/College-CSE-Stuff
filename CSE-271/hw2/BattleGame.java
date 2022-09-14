// Kevin Koepp, CSE 271


/**
 * This program helps BattleGrid.java run a simple Battleship game 
 * by using several methods.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class BattleGame {

    // Message to display at the start of the game:
    private static final String GRID_SIZE_MSG =
            "Welcome to exceptional Battleship game.%n"
            + "The battle grid size is %d rows and columns.%n"
            + "Guess the row and column of the ship.%n";

    /**
     * Message to display when user enters a value that
     * is out of the grid's boundaries.
     */
    private static final String ILLEGAL_LOCATION =
            "The row and column must be in the range 0 to %d%n";

    /**
     * A message to be displayed to the player when the correct row
     * and column were correctly guessed.
     */
    private static final String SUCCESS_MSG =
            "You guessed the correct location of the battleship!";

    /**
     * A simple prompt that is displayed to the user to enable them to play
     * the game.
     */
    private static final String INPUT_PROMPT =
            "Enter input [r<num>, c<num>, grid, quit]: ";

    /**
     * A simple message that is displayed to the user to show that the column
     * value guessed is valid.
     */
    private static final String COL_CORRECT_MSG =
            "The column value of %d is correct%n";

    /**
     * A simple message that is displayed to the user to show that the row
     * value guessed is valid.
     */
    private static final String ROW_CORRECT_MSG =
            "The row value of %d is correct%n";

    // The size of the BattleGrid: 
    private static int gridSize = 0;
    
    // The row value previously guessed by the user:
    private static int guessRow = 0;
    
    // The column value previously guessed by the user:
    private static int guessCol = 0;
    
    // A boolean to determine when the game is done:
    private static boolean isDone = false;
    
    // The ArrayList used for the grid feature:
    private static ArrayList<String> gridMap = new ArrayList<String>();
    
    /**
     * This is the top-level method that is called by the BattleGrid to enable
     * the user to play the game of guessing the correct row & column where
     * a battleship has been randomly hidden.
     * 
     * @param bg The battle grid (typically randomly generated) being used
     *     to play the game.
     */
    public static void play(BattleGrid bg) {
        
        // Create a Scanner for input:
        Scanner ip = new Scanner(System.in);
        
        // Find the grid size and create an ArrayList:
        findDimensions(bg);
        createGrid();
        
        // Start input loop:
        while (!isDone) {
            
            System.out.print(INPUT_PROMPT);
            String input = ip.nextLine();
            
            // Close the scanner and exit the loop when the user types "quit":
            if (input.equalsIgnoreCase("quit")) {
                ip.close();
                isDone = true;
            
            // Print the ArrayList if the user types "grid":
            } else if (input.equalsIgnoreCase("grid")) {
                System.out.println("Battle grid (previous "
                        + "guess marked with X)");
                
                // Print each element by line:
                for (int i = 0; i < gridMap.size(); i++) {
                    System.out.println(gridMap.get(i));
                }
                
            // Any other input is assumed to be a row/column guess:
            } else {
                
                // Convert the user input to separate integers:
                parseGuess(input);
                
                // Use the integers to guess the battleship's location:
                guessLocation(bg, guessRow, guessCol, ip);
                
                // Update the grid by marking the guessed location:
                editGrid(guessCol, guessRow);
            }
        }      
    } // end play method.
    
    /**
     * This method repeatedly calls the guess method to
     * determine the dimensions of the grid.
     * @param bg the Battle Grid being measured.
     */
    public static void findDimensions(BattleGrid bg) {
        
        // Loop until the guesses go off the grid:
        while (true) {
            try {
                bg.guess(gridSize,  gridSize);
                
                // If the "guess" is correct, increase grid size anyway:
                gridSize++;
            
            // For when the grid goes out of bounds:
            } catch (BattleGrid.IllegalLocationException e) {
                break;
                
            // Increase grid size for every other "guess":
            } catch (BattleGrid.InvalidRowException f) {
                gridSize++;
                continue;
            } catch (BattleGrid.InvalidColException g) {
                gridSize++;
                continue;
            } catch (BattleGrid.InvalidLocationException h) {
                gridSize++;
                continue;
            }
        }
        
        // Use new gridSize to print the first message of the program:
        System.out.printf(GRID_SIZE_MSG, gridSize);
        
    } // end findDimensions method.
    
    /**
     * This helper method simply fills the global ArrayList
     * by using the determined size of the grid.
     */
    public static void createGrid() {
        
        // Repeatedly create new rows of "." to add to the ArrayList:
        for (int i = 0; i < gridSize; i++) {
            
            // Reset the string every loop around:
            String mapRow = "";
            for (int j = 0; j < gridSize; j++) {
                mapRow += ".";
            }
            
            // Add each row to the ArrayList:
            gridMap.add(mapRow);
        }
        
    } // end createGrid method
    
    /**
     * This method updates the values of the grid feature 
     * after a user guesses incorrectly.
     * @param col the column's guess value
     * @param row the row's guess value
     */
    public static void editGrid(int col, int row) {
        
        // Scan each row of the grid first:
        for (int i = 0; i < gridMap.size(); i++) {
            
            // If the row is the guessed value:
            if (row == i) {
                
                // Replace the target location with an X:
                String targetRow = gridMap.get(i);
                String newRow = "";
                for (int j = 0; j < targetRow.length(); j++) {
                    if (col == j) {
                        newRow += "X";
                    } else {
                        newRow += targetRow.substring(j, j + 1);
                    }
                }
                
                // Update the grid:
                gridMap.remove(i);
                gridMap.add(i, newRow);
            }
        }
        
    } // end editGrid method
    
    /**
     * This method takes the user's input and interprets it
     * as a guess. It parses the row and column values into
     * their own integers and are saved as global variables.
     * @param in the guess provided by the user.
     */
    public static void parseGuess(String in) {
        
        // Strings to be updated:
        String row = "";
        String column = "";
        
        // Loop the entire length of the input:
        for (int i = 0; i < in.length(); i++) {
            
            // If the scanned character is "r", assume it's a row:
            if (in.substring(i, i + 1).equals("r")) {
                
                // Always use most recent row guess:
                row = "";
                row = findInt(in, row, i);
            
            // If the current character is "c", assume it's a column:
            } else if (in.substring(i, i + 1).equals("c")) {
                
                // Always use most recent column guess:
                column = "";
                column = findInt(in, column, i);
                
            }
        }
        
        // Parse the target row and/or column if the number was updated:
        if (!row.equals("")) {
            guessRow = Integer.parseInt(row);
        }
        
        if (!column.equals("")) {
            guessCol = Integer.parseInt(column);
        }
        
    } // end parseGuess method.
    
    /**
     * This method takes the inputs and returns
     * row and column values as separate Strings.
     * @param input the input provided by the user.
     * @param type the String being updated.
     * @param x the location of the current substring.
     * @return the integer of the row or column as a
     *      String.
     */
    public static String findInt(String input, String type, int x) {
        
        // Counter prevents out-of-bounds exceptions:
        int counter = x + 1;
        
        // While the substring isn't a whitespace:
        while (!input.substring(x + 1, x + 2).equals(" ")) {
            counter++;
            
            // Move a substring ahead of x to avoid printing the "r" or "c":
            type += input.substring(x + 1, x + 2);
            
            // If the counter is the same length as the input, exit loop:
            if (counter == input.length()) {
                break;
            }
            
            x++;
        }
        
        return type;
        
    } // end findInt method.
    
    /**
     * This method determines if the user has guessed correctly by
     * handling all exceptions generated by BattleGrid.java.
     * @param bg the BattleGrid being used in the game.
     * @param row the user's row guess.
     * @param col the user's column guess.
     */
    public static void guessLocation(BattleGrid bg, int r, int c, Scanner in) {
        
        // If no exceptions are caught, user guessed correctly:
        try {
            bg.guess(r, c);
            System.out.println(SUCCESS_MSG);
            
            // Close the scanner and exit:
            in.close();
            isDone = true;
        
        // User's guess was off the grid:
        } catch (BattleGrid.IllegalLocationException e) {
            System.out.printf(ILLEGAL_LOCATION, gridSize);
        
        // User's guess was the correct column, but the wrong row:
        } catch (BattleGrid.InvalidRowException f) {
            System.out.printf(COL_CORRECT_MSG, guessCol);
            System.out.println(f.getMessage());
            
        // User's guess was the correct row, but the wrong column:
        } catch (BattleGrid.InvalidColException g) {
            System.out.printf(ROW_CORRECT_MSG, guessRow);
            System.out.println(g.getMessage());
            
        // User's guess was the wrong row and column:
        } catch (BattleGrid.InvalidLocationException h) {
            System.out.println(h.getMessage());
        }
        
    } // end guessLocation method.
}

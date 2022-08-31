// Kevin Koepp, CSE 271, Homework 1

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a class that has helper methods to enable a simple search
 * functionality. The methods in this class are called by the SimpleSearch class
 * based on user's input choices. The methods in this class are to be
 * implemented and documented by students. NOTE: Ensure you add Javadoc for each
 * method in the starter code and for any methods you may add.
 */
public class SearchHelper {

    /**
     * This method loads lines from a specified file given a user-prompted
     * string.
     * 
     * @param fileName the name of the file given by the user.
     * @return an ArrayList with each line of the file as an index.
     * @throws FileNotFoundException if the scanner cannot find the specified
     *                               file.
     */
    public static ArrayList<String> loadLines(final String fileName)
            throws FileNotFoundException {
        
        // Create new scanner and ArrayList:
        Scanner file = new Scanner(new File(fileName));
        ArrayList<String> arr = new ArrayList<>();

        // create the ArrayList using lines from the file:
        while (file.hasNextLine()) {
            arr.add(file.nextLine());
        }
        return arr;
    } // end loadLines method

    /**
     * This method prints the specified lines of the ArrayList, indices
     * separated at each line.
     * 
     * @param lines the lines of indices to be printed, separated by the
     *              ArrayList
     */
    public static void print(final ArrayList<String> lines) {
        
        // If there are no resulting lines, print "Empty list":
        if (lines.size() == 0) {
            System.out.println("Empty list");
        
        // Print resulting lines in order of index number:
        } else {
            for (int i = 0; i < lines.size(); i++) {
                System.out.println("[" + i + "]: " + lines.get(i));
            }
        }
    } // end print method

    /**
     * This method searches for a specified phrase in the file, and returns a
     * new ArrayList containing all lines with the given phrase.
     * 
     * @param srchList the file ArrayList being searched.
     * @param phrase   the phrase to look for in each indices of the file.
     * @return an ArrayList of only lines containing the given phrase.
     */
    public static ArrayList<String> search(final ArrayList<String> srchList,
            String phrase) {

        ArrayList<String> result = new ArrayList<>();
        
        // Search through each line in the file first:
        for (int i = 0; i < srchList.size(); i++) {
            String srchLine = srchList.get(i);
            
            // Within the current line, compare the phrase with a substring:
            for (int j = 0; j < srchLine.length() - phrase.length(); j++) {
                
                // Update the substring as it goes through the line:
                String fromList = srchLine.substring(j, phrase.length() + j);
                
                // Call the wild card method to accommodate wild card phrases:
                String newPhrase = wildCard(fromList, phrase);
                
                // Add the line to the ArrayList if the prompt is found in it:
                if (phrase.equals(newPhrase)) {
                    result.add(srchLine);
                    break;
                }
            }
        }
        return result;
    } // end search method

    /**
     * This helper method creates a new String to use when searching with a wild
     * card phrase.
     * 
     * @param list the substring being copied into the new String
     * @param prompt the phrase given by the user for the search method
     * @return the new String being created
     */
    public static String wildCard(String list, String prompt) {
        
        // Create new String entity:
        String newString = "";
        for (int i = 0; i < prompt.length(); i++) {
            
            // Replace all "?" instances with "?" in the new String:
            if (prompt.substring(i, i + 1).equals("?")) {
                newString += "?";
            // Otherwise, copy the list String:
            } else {
                newString += list.substring(i, i + 1);
            }

        }
        return newString;
    } // end wildCard method

} // end class

// Kevin
// CSE 174
// April 8, 2022
// This program is a series of methods designed to manipulate vowels in strings,
// and determine their "percentage". Using this "percentage", strings are
// measured by values of madness.

public class MyMethods {
  
  /* Method 1: This method returns true / false statement
   * for whether a character is a vowel or not.
   * @param chr a character input to check if vowel
   * return whether chr is a vowel or not.
   */
  public static boolean isVowel(char chr) {
    
    // convert chr to a String variable to reduce code:
    String str = Character.toString(chr);
  
    // return true if vowel
    if (str.equalsIgnoreCase("a") || str.equalsIgnoreCase("e")) {
      return true;
    } else if (str.equalsIgnoreCase("i") || str.equalsIgnoreCase("o")) {
      return true;
    } else if (str.equalsIgnoreCase("u")) {
      return true;
    }
    return false;
  } // end method
  
  /* Method 2: This method determines the percentage
   * of vowels in a String and saving it as a "mad score"
   * @ param str a String value to calculate
   * return percentage of vowels in String in decimal
   */
  public static double madScore(String str) {
  
    float counter = 0;
    
    // count the number of vowels in the String:
    for (int j = 0; j < str.length(); j++) {
      if (MyMethods.isVowel(str.charAt(j))) {
        counter++;
      }
    } // end method
    
    // Calculate percentage and return the result:
    float score = counter / str.length() * 100;
    return score * .01;
  } // end method
  
  /* Method 3: This method returns a true/false
   * statement by determining if 1/4 of the string consists
   * of vowels.
   * @ param str a String input to calculate
   * return true if 1/4 or greater of the string is vowels.
   */
  public static boolean madString(String str) {
    
    String word = "";
    
    //Fill in the word with the String:
    for (int j = 0; j < str.length(); j++) {
      
      // Replace spaces with commas to "count" the spaces:
      if (str.substring(j, j + 1).equals(" ")) {
        word += ",";
      } else {
        // if no space, keep going:
        word += str.substring(j, j + 1);
      }
    }
    
    // Check if the String (including spaces) is 1/4 vowels:
    if (MyMethods.madScore(word) >= 0.25) {
      return true;
    } 
    return false;
  } // end method
  
  /* Method 4: This method takes a String and "unmadifies" it
   * by adding spaces to the beginning of the String.
   * @ param str a String value to unmadify
   * return the unmadified String
   */
  public static String unmadify(String str) {
    
    String word = str;
    
    // While the String is "mad", add a space until it isn't:
    while (MyMethods.madString(word) == true) {
      word = " " + word;
    }
    return word;
  } // end method
  
  /* Method 5: This string takes any "mad" String
   * and makes all vowels uppercase, and all other
   * characters lowercase.
   * @ param str a String value to be changed
   * print String with modified letters.
   */
  public static void goCrazy(String str) {
  
    String word = "";
    
    if (MyMethods.madString(str) == true) {
      
      for (int j = 0; j < str.length(); j++) {
        
        // If the letter j loops to is a vowel, make it uppercase:
        if (MyMethods.isVowel(str.charAt(j)) == true) {
          word += str.substring(j, j + 1).toUpperCase(); 
        
        // Otherwise, make it lowercase:  
        } else {
          word += str.substring(j, j + 1).toLowerCase();
        }
      }
      System.out.println(word);
      
    // If the string wasn't mad, print the following message:
    } else {
      System.out.println("I'm sad that string was not mad :(");
    }
  } // end method
  
} // end class

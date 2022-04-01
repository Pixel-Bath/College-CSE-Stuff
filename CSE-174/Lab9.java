// Kevin
// CSE 174
// April 1, 2022

/* This lab is a series of methods designed to be handled with the
 * interactions pane. These methods determine the capabilities of
 * a computer and its network connection through boolean values.
 */

public class Lab9 {
  public static void main(String[] args) {
  
  } // end main method
  
  /* this method returns a true/false statement
   * based on wifi signal and mbps
   * @param signal String for wifi connection
   * @param mbps int for download speed
   * return whether the wifi works or not
   */
  public static boolean wifiIsWorking(String signal, int mbps) {
    
    if (signal.equalsIgnoreCase("good")) {
      if (mbps >= 25) {
        return true;
      }
    } else if (signal.equalsIgnoreCase("fair")) {
      if (mbps >= 50) {
        return true;
      }
    }
    return false;
    
  } // end wifiIsWorking method
  
  /* This method checks if a computer is plugged
   * in, the fps is running, and the lag percentage
   * to determine if the computer runs well.
   * @param plug boolean for whether computer's plugged in
   * @param fps integer for computer frames
   * @param lag for lag percentage
   * return whether the computer runs well or not.
   */
  public static boolean computerIsWorking(boolean plug, int fps, double lag) {
    
    if (plug) {
      if (fps < 25 && lag < .1)  {
        return true;
      } else if (fps >= 25 && lag < .5) {
        return true;
      } else if (fps >= 25 && lag >= .5) {
        if (fps * lag > 20) {
          return true;
        }
      }
    }
    return false;
    
  } // end computerIsWorking method
  
  /* This method checks if both the computer and wifi are working
   * @param wifi for if the wifi works or not
   * @param computer for if the computer works or not
   * return if the computer is capable of running games or not
   */
  public static boolean canPlayGames(boolean wifi, boolean computer) {
  
    if (wifi && computer) {
      return true;
    }
    return false;
    
  } // end canPlayGames method
  
} // end class
  
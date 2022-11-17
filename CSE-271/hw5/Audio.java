
import java.io.Serializable;
import java.util.Scanner;

/**
 * An audio class that extends media and implements comparable objects.
 * @author koeppkm2
 *
 */
public class Audio extends Media implements Serializable, Comparable<Audio> {

    // Serial UID for binary use:
    private static final long serialVersionUID = 800279455696126848L;
    
    private int billboardRank;
    
    private boolean operatic;
    
    private String audioFormat = "Audio\t%s\t%s\t%d\t%.2f\t%d\t%b";
    
    /**
     * Simple constructor method, uses Media constructor.
     * @param upc the UPC
     * @param title the Title
     * @param year the year
     */
    public Audio(String upc, String title, int year) {
        super(upc, title, year);
        
    } // end constructor.
    
    /**
     * Gets the billboard rank.
     * @return billboard rank of invoked audio.
     */
    public int getBillboardRank() {
        return billboardRank;
        
    } // end getBillboardRank method.
    
    /**
     * Sets the billboardrank.
     * @param bbr the new billboard rank to be set.
     */
    public void setBillboardRank(int bbr) {
        billboardRank = bbr;
        
    } // end setBillboard rank method.
    
    /**
     * Checks if Operatic is true or false.
     * @return the value of operatic.
     */
    public boolean isOperatic() {
        return operatic;
        
    } // end isOperatic method.
    
    /**
     * Sets the operatic value.
     * @param opera the operatic value to be set.
     */
    public void setOperatic(boolean opera) {
        operatic = opera;
        
    } // end setOperatic method.
    
    /**
     * Compares an invoked audio object to another
     * audio object, overrides java.Object() method.
     * @param o Audio object to be compared with invoked Audio.
     * @return the compare value as an integer.
     */
    @Override 
    public int compareTo(Audio o) {
        
        // Check billboard rank:
        if (this.billboardRank != o.billboardRank) {
            return ((Integer)billboardRank).compareTo((Integer)o.billboardRank);
        
        // Otherwise, check price:
        } else if (this.getPrice() != o.getPrice()) {
            return ((Float)this.getPrice()).compareTo((Float)o.getPrice());
        
        // Otherwise, check titles:
        } else {
            return ((String)this.getTitle()).compareTo((String)o.getTitle());
            
        }
        
    } // end compareTo method.
    
    /**
     * Returns Audio in the format of a String.
     * @return the String containing Audio info.
     */
    @Override 
    public String toString() {
        return String.format(audioFormat, this.getUpc(), this.getTitle(), 
                this.getYear(), this.getPrice(), billboardRank, operatic);
        
    } // end toString method.
    
    /**
     * Loads the audio from a file using a scanner.
     * @param info the name of the file.
     * @return the new Audio created from scanner.
     */
    public static Audio load(String info) {
        
        // Create scanner and Delimiter:
        Scanner ip = new Scanner(info);
        ip.useDelimiter("\t");
        ip.next();
        
        // Create a new Audio object and set its other attributes:
        Audio a = new Audio(ip.next(), ip.next(), ip.nextInt());
        a.setPrice(ip.nextFloat());
        a.setBillboardRank(ip.nextInt());
        a.setOperatic(ip.nextBoolean());
        
        // close scanner and return new Audio:
        ip.close();
        return a;
        
    } // end load method.
    
} // end class.
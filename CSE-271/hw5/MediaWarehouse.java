import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class acts as a warehouse that maintains the list of media items
 * Media items can be added, searched, and priced.
 */
public class MediaWarehouse {
    
    /**
     * The list of media currently available in this warehouse. This list is
     * initialized to an empty list in the constructor. 
     */
    private ArrayList<Media> mediaList;
    
    /**
     * The default constructor merely initializes the instance variables.
     */
    public MediaWarehouse() {
        mediaList  = new ArrayList<>();
    }

    /**
     * Helper method to find the media object associated with a given upc
     *     in the mediaList.
     * 
     * @param upc The UPC to search for in the current mediaList.
     * @return This method returns the media item if it is found. Otherwise,
     *     this method returns null.
     */
    public Media findMedia(String upc) {
        for (Media m : mediaList) {     
            if (m.getUpc().equals(upc)) {
                return m;
                
            }
        }
        
        return null;  // when media with given upc not found.
    }

    /**
     * Print the list of media in the mediaList.
     */
    public void printMedia() {
        System.out.println("Currently loaded media:\n");
        for (Media m : mediaList) {
            System.out.println(m);
            
        } 
    }
        
    
    /**
     * Searches for the given phrase in each media's UPC and title. The method 
     * prints the media objects that contain the phrase. This method also
     * prints a summary message of the form -- 
     * "Found 5 matches, out of 17 media items." at the end. See sample outputs
     * in project document for more examples.
     * 
     * @note The search is case-insensitive. So all strings must be first
     *     converted to lower case prior to using them.
     * 
     * @param phrase The substring to search for.
     */
    public void search(String phrase) {
        System.out.println("Media with the phrase are:");
        String key = phrase.toLowerCase();
        int count = 0;
        
        for (Media m : mediaList) {
            for (int i = 0; i < m.toString().length() - key.length(); i++) {
                
                // Set lines to lower case:
                String line = m.toString().toLowerCase();
                if (key.equals(line.substring(i, i + key.length()))) {
                    count++;
                    System.out.println(m.toString());
                    break;
                    
                }
            }
        }
        
        System.out.println("Found " + count + " matches, out of " 
                + mediaList.size() + " media items.");
        
    }
        
    /**
     * This method is called to load data from either a text file or a binary
     * file. For text file formats see 90s_media.txt for example. The binary 
     * file is read as a single object (using an ObjectInputStream) of 
     * ArrayList type. The media loaded is added to the mediaList 
     * instance variable in this class. This method does not add duplicate 
     * media items -- i.e. media with the same UPC are duplicates. If a 
     * duplicate media item is found it prints an message stating with the 
     * duplicate upc in the form -- "Duplicate media with upc m_90_2 ignored".
     * 
     * @see Video.load
     * @see Audio.load
     * 
     * @note It may be best to create a helper method that checks and adds
     *     non-duplicate media.
     * 
     * @param filePath Path (relative or absolute) to the file from where the
     *                 media is to be added to the current
     * @param isText   If this flag is true, then the file is a text file.
     *                 Otherwise the file is a binary file (created via prior
     *                 call to the writeMedia method in this class.
     * 
     * @return This method returns the number of new media items added 
     *     from the file.
     *     
     * @throws IOException When I/O errors occur
     * @throws ClassNotFoundException When loading binary media object fails
     */
    public int addMediaFrom(String filePath, boolean isText) 
            throws IOException, ClassNotFoundException {
        
        // Initialize counter:
        int count = 0;
        
        // If file is text file:
        if (isText) {
            
            // Create scanner and media:
            Scanner sc = new Scanner(new File(filePath));
            Media m = null;
            
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                
                // Check if the media is an audio or video file:
                m = (line.substring(0,5).equals("Audio")) 
                        ? Audio.load(line) : Video.load(line);
                
                // Check for duplicates:
                count = checkDupes(m, mediaList, count);
                
            }
            
            // Close the scanner:
            sc.close();
            
        } else {
            
            // Read the file as Binary:
            try (ObjectInputStream ois = 
                        new ObjectInputStream(new FileInputStream(filePath))) {
                
                // Check dupes while reading the bin:
                Object temp = null;
                while ((temp = ois.readObject()) != null) {
                    count = checkDupes((Media)temp, mediaList, count);
                }
            } catch (Exception e) {
                System.out.print("");
            }
        }
        return count;
        
    }
    
    /**
     * Checks for duplicate media inserted to the Media list.
     * @param list the media List to be checked.
     * @param m the media to be checked.
     */
    public int checkDupes(Media m, ArrayList<Media> list, int counter) {
        
        // Search for media by UPC with findMedia method:
        Media j = findMedia(m.getUpc());
        
        // If the media doesn't exist, add it to the list:
        if (j == null) {
            mediaList.add(m);
            counter++;
            
        // Otherwise, ignore duplicate:
        } else {
            System.out.println("Duplicate media with upc " 
                    + m.getUpc() + " ignored.");
        }
        
        // Return number of times media was added to the list:
        return counter;
        
    } // end checkDupes method.
   
    /**
     * This method is called to write each entry in the mediaList to a given
     * file in text or binary format. The text format is generated by simply
     * printing each media entry. The binary format is generated by writing
     * the whole mediaList ArrayList as a single object using an 
     * ObjectOutputStream.
     * 
     * @param filePath The path to the output file. If the file exists, then the
     *     contents is overwritten.
     * @param isText If this flag is true, then the output is written as text.
     *     Otherwise the output is written in binary format.
     *     
     * @throws IOException This exception is exposed if any I/O error occurs.
     */
    public void writeMedia(String filePath, boolean isText) throws IOException {
        
        // Print media to a text file if .txt:
        if (isText) {
            PrintWriter f = new PrintWriter(new File(filePath));
            for (Media m : mediaList) {
                f.println(m.toString());
            }
            f.close();
        
        // Print media as Binary otherwise:
        } else {
            ObjectOutputStream oos = 
                   new ObjectOutputStream(new FileOutputStream(filePath));
            
            for (Media m : mediaList) {
                oos.writeObject(m);
                
            }
            oos.close();
        }
    }
    
    /**
     * <p>Computes the total price of a set of media items to be purchased as a
     * bundle. Note that a totalPrice is computed by adding the price for each
     * media item. After that, the following formula is used to adjust the price
     * of the bundle:
     * </p>
     * <p>
     * finalPrice = totalPrice + (hdcpCount * 0.10) - (operaCount * 0.05)
     * </p>
     * where, hdcpCount is number of Video objects for which isHdcp returns true
     * and operaCount is number of Audio objects for which isOperatic is true
     * 
     * @param upcList The list of items whose total price is to be computed.
     * @return The total price of the list of items.
     */
    public float computeTotalPrice(ArrayList<String> upcList) {
        
        // Initialize counters:
        int hdcpCount = 0;
        int operaCount = 0;
        float totalPrice = 0;
        
        // Search through the upc list:
        for (String s : upcList) {
            Media m = findMedia(s);
            
            // If m is null, check instances and load:
            if (m != null && m instanceof Video) {
                Video v = Video.load(m.toString());
                
                // Check for hdcp:
                if (v.isHdcp()) {
                    hdcpCount++;
                }
                totalPrice += v.getPrice();
                
            // Check instances and load as audio if not video:
            } else if (m != null) {
                Audio a = Audio.load(m.toString());
                
                // Check for operatic:
                if (a.isOperatic()) {
                    operaCount++;
                }
                totalPrice += a.getPrice();
            }
        }
        
        // Compute with given formula and return:
        float finalPrice = totalPrice 
                + (hdcpCount * 0.10f) - (operaCount * 0.05f);
        return finalPrice;
    }
}

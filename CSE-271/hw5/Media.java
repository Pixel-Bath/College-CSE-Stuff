
import java.io.Serializable;

/**
 * This class is a parent of Media and houses
 * their general properties.
 * @author koeppkm2
 *
 */
public class Media implements Serializable {

    // Serial UID for Binary files:
    private static final long serialVersionUID = -6347361628047857239L;
    
    private String upc;
    
    private String title;
    
    private int year;
    
    private float price;
    
    /**
     * Simple constructor method for media objects.
     * @param u the upc.
     * @param t the title.
     * @param y the year.
     */
    public Media(String u, String t, int y) {
        upc = u;
        title = t;
        year = y;
        
    } // end Media constructor.
    
    /**
     * Other simple constructor method for media objects.
     * @param u the upc.
     * @param t the title.
     * @param y the year. 
     * @param p the price.
     */
    public Media(String u, String t, int y, float p) { 
        this(u, t, y);
        price = p;
        
    } // end Media constructor.
    
    /**
     * Gets the upc of a media object.
     * @return the upc
     */
    public String getUpc() {
        return upc;
        
    } // end getUpc method.
    
    /**
     * Gets the title of a media object.
     * @return the title
     */
    public String getTitle() {
        return title;
        
    } // end getTitle method.
    
    /**
     * Gets the year of a media object.
     * @return the year
     */
    public int getYear() {
        return year;
        
    } // end getYear method.
    
    /**
     * Gets the price of a media object.
     * @return
     */
    public float getPrice() {
        return price;
        
    } // end getPrice method.
    
    /**
     * Sets the price of a media object.
     * @param p the price of the object.
     */
    public void setPrice(float p) {
        price = p;
        
    } // end setPrice method.
    
} // end class.
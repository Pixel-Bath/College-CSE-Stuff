
// Kevin, CSE 274

/**
 * Parent class designed for holding arraylists
 * of books and videos.
 *
 */
public class Media {
    
    public String uid;
    public String title;
    public String kind; 
    
    /**
     * Simple constructor for Books and Videos
     * @param x the uid.
     * @param y the title.
     * @param z the kind.
     */
    public Media(String x, String y, String z) {
        uid = x;
        title = y;
        kind = z;
        
    } // end Media constructor.
    
    /**
     * This method sets the media's UID.
     * @param x the uid to be changed.
     */
    public void setUid(String x) {
        this.uid = x;
        
    } // end setUid method.
    
    /**
     * This method gets a media's UID.
     * @return the invoked media's UID.
     */
    public String getUid() {
        return this.uid;
        
    } // end getUid method.
    
    /**
     * This method sets the title of a media.
     * @param x the title to be changed.
     */
    public void setTitle(String x) {
        this.title = x;
        
    } // end setTitle method.
    
    /**
     * This method gets the title of a media.
     * @return the invoked media's title.
     */
    public String getTitle() {
        return this.title;
        
    } // end getTitle method.
    
    /**
     * This method sets the type of media.
     * @param x the type to be changed.
     */
    public void setKind(String x) {
        this.kind = x;
        
    } // end setKind method.
    
    /**
     * This method gets the type of media.
     * @return the invoked media's type.
     */
    public String getKind() {
        return this.kind;
        
    }  // end getKind method.
} // end class.
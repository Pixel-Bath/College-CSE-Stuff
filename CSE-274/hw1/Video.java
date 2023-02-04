
// Kevin, CSE 274

/**
 * Child method for creating video objects.
 *
 */
public class Video extends Media {
    
    protected String type = "";
    protected String director = "";
    
    /**
     * Constructor method for videos.
     * @param v the video's uid.
     * @param w the video's title.
     * @param x the video's type "video".
     * @param y the video's director(s).
     * @param z the video's format.
     */
    public Video(String v, String w, String x, String y, String z) {
        super(v, w, x);
        type = y;
        director = z;
    } // end Video constructor.
    
    /**
     * This method sets a video's format.
     * @param x the format of video to be set.
     */
    public void setType(String x) {
        this.type = x;
        
    } // end setType method.
    
    /**
     * This method gets a video's format.
     * @return the invoked video's format.
     */
    public String getType() {
       return this.type;
       
    }// end getType method.
    
    /**
     * This method sets a video's director.
     * @param x the director to be set.
     */
    public void setDirector(String x) {
        this.director = x;
        
    } // end setDirector method.
    
    /**
     * This method gets a video's director.
     * @return the invoked video's director.
     */
    public String getDirector() {
        return this.director;
        
    } // end getDirector method.
    
    /**
     * This method writes a video in String format,
     * overriding the toString class.
     */
    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s", 
                uid, title, kind, type, director);
    }
}
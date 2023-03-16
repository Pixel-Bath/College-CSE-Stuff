
// Kevin, CSE 274

/**
 * Child class for creating Book objects.
 * @author koeppkm2
 * 
 */
public class Book extends Media {
    
    protected String author = "";
    protected String publisher = "";
    
    /**
     * Constructor method for Books.
     * @param v the book's uid.
     * @param w the book's title.
     * @param x the book's type "book".
     * @param y the book's author(s).
     * @param z the book's publisher.
     */
    public Book(String v, String w, String x, String y, String z) {
        super(v, w, x);
        author = y;
        publisher = z;
    } // end Book constructor.
    
    /**
     * This method gets the author of a book
     * @return the invoked book's author.
     */
    public String getAuthor() {
        return this.author;
        
    }
    
    /**
     * This method sets a book to an author.
     * @param x the author to be changed.
     */
    public void setAuthor(String x) {
        this.author = x;
        
    } // end setAuthor method.
    
    /**
     * this method gets the book's publisher.
     * @return the invoked book's publisher.
     */
    public String getPublisher() {
        return this.publisher;
        
    } // end getPublisher method.
    
    /**
     * This method sets a book to a publisher.
     * @param x the publisher to be changed.
     */
    public void setPublisher(String x) {
        this.publisher = x;
        
    } // end setPublisher method.
    
    /**
     * This method writes a book in String format,
     * overriding the toString class.
     */
    @Override
    public String toString() {
        return String.format("[%s\t%s\t%s\t%s\t%s]", 
                uid, title, kind, author, publisher);
        
    } // end toString method.
} // end class.
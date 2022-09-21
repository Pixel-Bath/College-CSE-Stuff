
/**
 * This class creates a new Fish object and gives it
 * specified attributes.
 * @author koeppkm2
 *
 */
public class Fish extends Pet {
    
    /**
     * This constructor creates a new Fish object.
     * @param k the kind of Fish.
     * @param p the price of the Fish.
     * @param fpd the food the Fish needs per day.
     */
    public Fish(String k, float p, float fpd) {
        super(k, p, fpd);
        
    } // end Fish constructor.
    
    /**
     * This method overrides the Thing class and
     * returns the Fish's kind.
     * @return the kind of Fish.
     */
    @Override
    public String getKind() {
        return "Fish: " + kind;
        
    } // end getKind method.
    
    /**
     * This method formats the Fish's attributes
     * to a string and overrides the java Object class.
     * @return a String of attributes.
     */
    @Override
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f",
                "Fish", kind, price, foodPerDay);
        
    } // end toString method.
    
    /**
     * This method overrides the Thing class and 
     * returns a true boolean since the Fish is
     * an aquatic animal.
     * @return Is aquatic.
     */
    @Override
    public boolean isAquatic() {
        return true;
        
    } // end isAquatic method.
} // end Fish class.
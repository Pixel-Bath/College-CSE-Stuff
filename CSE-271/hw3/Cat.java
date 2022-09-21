
/**
 * This class creates a new Cat object and gives it
 * specified attributes.
 * @author koeppkm2
 *
 */
public class Cat extends Pet {
    
    /**
     * This constructor creates a new Cat object.
     * @param k the kind of Cat.
     * @param p the price of the Cat.
     * @param fpd the food the Cat needs per day.
     */
    public Cat(String k, float p, float fpd) {
        super(k, p, fpd);
        
    } // end Cat constructor.
    
    /**
     * This method overrides the Thing class and
     * returns the Cat's kind.
     * @return the kind of Cat.
     */
    @Override
    public String getKind() {
        return "Cat: " + kind;
        
    } // end getKind method.
    
    /**
     * This method formats the Cat's attributes
     * to a string and overrides the java Object class.
     * @return a String of attributes.
     */
    @Override
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f",
                "Cat", kind, price, foodPerDay);
        
    } // end toString method.
    
    /**
     * This method overrides the Thing class and 
     * returns a false boolean since the Cat is not
     * an aquatic animal.
     * @return Not aquatic.
     */
    @Override
    public boolean isAquatic() {
        return false;
        
    } // end isAquatic method.
} // end Cat class.
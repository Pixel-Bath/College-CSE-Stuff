
/**
 * This class creates a new Dog object and gives it
 * specified attributes.
 *
 */
public class Dog extends Pet {
    
    /**
     * This constructor creates a new Dog object.
     * @param k the kind of Dog.
     * @param p the price of the Dog.
     * @param fpd the food the Dog needs per day.
     */
    public Dog(String k, float p, float fpd) {
        super(k, p, fpd);
        
    } // end Dog constructor.
    
    /**
     * This method overrides the Thing class and
     * returns the Dog's kind.
     * @return the kind of Dog.
     */
    @Override
    public String getKind() {
        return "Dog: " + kind;
        
    } // end getKind method.
    
    /**
     * This method formats the Dog's attributes
     * to a string and overrides the java Object class.
     * @return a String of attributes.
     */
    @Override
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f", 
                "Dog", kind, price, foodPerDay);
        
    } // end toString method.
    
    /**
     * This method overrides the Thing class and 
     * returns a false boolean since the Dog is not
     * an aquatic animal.
     * @return Not aquatic.
     */
    @Override
    public boolean isAquatic() {
        return false;
        
    } // end isAquatic method.
} // end Dog class.

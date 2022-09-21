
/**
 * This class creates a new Octopus object and gives it
 * specified attributes.
 * @author koeppkm2
 *
 */
public class Octopus extends Pet {
    
    /**
     * This constructor creates a new Octopus object.
     * @param k the kind of Octopus.
     * @param p the price of the Octopus.
     * @param fpd the food the Octopus needs per day.
     */
    public Octopus(String k, float p, float fpd) {
        super(k, p, fpd);
        
    } // end Octopus constructor.
    
    /**
     * This method overrides the Thing class and
     * returns the Octopus' kind.
     * @return the kind of Octopus.
     */
    @Override
    public String getKind() {
        return "Octopus: " + kind;
        
    } // end getKind method.
    
    /**
     * This method formats the Octopus' attributes
     * to a string and overrides the java Object class.
     * @return a String of attributes.
     */
    @Override
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f",
                "Octopus", kind, price, foodPerDay);
        
    } // end toString method.
    
    /**
     * This method overrides the Thing class and 
     * returns a true boolean since the Octopus is
     * an aquatic animal.
     * @return Is aquatic.
     */
    @Override
    public boolean isAquatic() {
        return true;
        
    } // end isAquatic method.
} // end Octopus class.
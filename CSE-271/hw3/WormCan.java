
/**
 * This class creates a new WormCan object and
 * gives it specified attributes.
 *
 */
public class WormCan extends Food {
    
    /**
     * This constructor creates a new WormCan object.
     * @param p the price of the WormCan.
     * @param w the weight of the WormCan.
     */
    public WormCan(float p, float w) {
        super(p, w);
        
    } // end WormCan method.
    
    /**
     * This method overrides the Thing class
     * and gives the kind of food.
     * @return WormCan.
     */
    @Override 
    public String getKind() {
        return "WormCan";
        
    } // end getKind method.
    
    /**
     * This method formats the WormCan's attributes
     * to a String and overrides the java Object class.
     * @return WormCan and its attributes.
     */
    @Override
    public String toString() {
        return String.format("%s\t%.2f\t%.2f",
                "WormCan", price, weight);
        
    } // end toString method.
    
    /**
     * This method overrides the Thing class and returns a
     * true boolean since WormCan is for aquatic animals.
     */
    @Override 
    public boolean isAquatic() {
        return true;
        
    } // end isAquatic method.
} // end WormCan class.

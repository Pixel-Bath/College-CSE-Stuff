
/**
 * This class creates a new ChowBag object and
 * gives it specified attributes.
 * @author koeppkm2
 *
 */
public class ChowBag extends Food {
    
    /**
     * This constructor creates a new ChowBag object.
     * @param p the price of the ChowBag.
     * @param w the weight of the ChowBag.
     */
    public ChowBag(float p, float w) {
        super(p, w);
        
    } // end ChowBag method.
    
    /**
     * This method overrides the Thing class
     * and gives the kind of food.
     * @return ChowBag.
     */
    @Override 
    public String getKind() {
        return "ChowBag";
        
    } // end getKind method.
    
    /**
     * This method formats the ChowBag's attributes
     * to a String and overrides the java Object class.
     * @return ChowBag and its attributes.
     */
    @Override 
    public String toString() {
        return String.format("%s\t%.2f\t%.2f",
                "ChowBag", price, weight);
        
    } // end toString method.
    
    /**
     * This method overrides the Thing class and returns a
     * false boolean since ChowBag is not for aquatic animals.
     */
    @Override
    public boolean isAquatic() {
        return false;
        
    } // end isAquatic method.
} // end ChowBag class.
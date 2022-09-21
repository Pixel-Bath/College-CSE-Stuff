/**
 * This class is used to gather attributes about pets and return
 * values such as the price and food per day.
 * @author koeppkm2
 *
 */
public abstract class Pet extends Thing {
    
    // The kind of pet:
    protected String kind;
    
    // The price of the pet:
    protected float price;
    
    // The amount of food per day the pet needs:
    protected float foodPerDay;
    
    /**
     * This method constructs a Pet given specific information
     * about it.
     * @param k the kind of pet.
     * @param p the price of the pet.
     * @param fpd the pet's daily requirement of food.
     */
    public Pet(String k, float p, float fpd) {
        
        kind = k;
        price = p;
        foodPerDay = fpd;
        
    } // end Pet constructor.
    
    
    /**
     * This method overrides the Thing class by returning a price.
     * @return price.
     */
    @Override
    public float getPrice() {
        return price;
        
    } // end getPrice method.
    
    /**
     * This method outputs food a pet needs per day.
     * @return food per day.
     */
    public float getFoodPerDay() {
        return foodPerDay;
        
    } // end getFoodPerDay method.
    
    /**
     * This method overrides the java Object class to compare two
     * pets by their class and their kind.
     * @param x a pet being compared.
     * @return whether two objects are equal.
     */
    @Override
    public boolean equals(Object x) {
        
        // return false if x is null:
        if (x == null) {
            return false;
        }
        
        // return false if two objects aren't from the same class:
        if (x.getClass() != this.getClass()) {
            return false;
        }
        
        // downcast x and compare the kind of pet:
        Pet comparison = (Pet) x;
        return (this.kind.equals(comparison.kind));
        
    } // end equals method.
    
} // end Pet class.
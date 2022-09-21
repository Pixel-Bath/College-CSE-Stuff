
/**
 * This class is used to gather attributes about food and return
 * values such as price and weight.
 * @author koeppkm2
 *
 */
public abstract class Food extends Thing {
    
    // The price of food:
    protected float price;
    
    // The weight of food:
    protected float weight;
    
    /**
     * This constructor takes in two floats and 
     * defines them as a food's price and weight.
     * @param p the price of food.
     * @param w the weight of food.
     */
    public Food(float p, float w) {
        price = p;
        weight = w;
        
    } // end Food constructor.
    
    /**
     * This method overrides the Thing class 
     * and gives the price of a food item.
     * @return the price.
     */
    @Override
    public float getPrice() {
        return price;
        
    } // end getPrice method.
    
    /**
     * This method gives the weight of an object.
     * @return weight.
     */
    public float getWeight() {
        return weight;
        
    } // end getWeight method.
    
    /**
     * This method overrides the java Object class and 
     * compares two objects by class, price, and weight.
     * @return whether two food items are equal.
     */
    @Override
    public boolean equals(Object x) {
        
        // if x is null, return false:
        if (x == null) {
            return false;
        }
        
        // if the objects aren't from the same class, return false:
        if (x.getClass() != this.getClass()) {
            return false;
        }
        
        // Downcast x and compare the price and weight:
        Food comparison = (Food) x;
        return (this.price == comparison.price 
                && this.weight == comparison.weight);
        
    } // end equals method.
} // end Food class.
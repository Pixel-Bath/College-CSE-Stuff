// Kevin Koepp, CSE 271

/**
 * This class acts as an abstract, default "thing" for all store items. Most
 * methods in this class are abstract and overridden by child and grandchild
 * classes.
 * 
 *
 */
public abstract class Thing {

    /**
     * This constructor is empty since food and pet items are sorted and
     * constructed differently.
     */
    public Thing() {
        
    }

    public abstract String getKind();

    public abstract boolean isAquatic();

    public abstract float getPrice();
}

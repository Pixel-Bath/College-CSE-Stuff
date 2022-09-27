// Kevin, CSE271

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple pet store that has pets and food things.
 *
 */
public class PetShop {
    /**
     * The items available for sale in this pet shop. The items are added to
     * this list via the addItemsFromFile method.
     */
    private ArrayList<Thing> things;

    /**
     * This is an intermediate summary string that has been used to generate the
     * full summary format below. Don't use this one. Instead, use the
     * SUMMARY_FORMAT string below.
     */
    private static final String SUMMARY_SUB_FORMAT = 
            "    Number of pets      : %d%n"
            + "    Total price pets    : $%.2f%n"
            + "    Number of food items: %d%n"
            + "    Total price of food : $%.2f%n";

    /**
     * Format string to print summary of pets and food items in the pet store.
     */
    private static final String SUMMARY_FORMAT = 
            "Summary of items in Pet Shop%n"
            + "Aquatic pets & food summary%n"
            + SUMMARY_SUB_FORMAT
            + "Non-aquatic pets & food summary%n"
            + SUMMARY_SUB_FORMAT;

    /**
     * Format string to print food status for the pet store.
     */
    private static final String FOOD_STATUS = "Pet Shop food status:%n"
            + "    Daily aquatic food needed      : %.2f lb%n"
            + "    Daily non-aquatic food needed  : %.2f lb%n"
            + "    Aquatic food stock in store    : %.2f lb%n"
            + "    Non-aquatic food stock in store: %.2f lb%n";

    /**
     * Creates an empty shop without any items.
     */
    public PetShop() {
        things = new ArrayList<>();
        
    } // end PetShop constructor.

    /**
     * Returns the number of food objects in the list of things in this pet
     * store.
     * 
     * @return The number of food things currently in the list of things in this
     *         pet store.
     */
    public int getFoodCount() {
        
        // Initialize a counter:
        int counter = 0;
        for (Thing i : things) {
            
            // If the Thing is a subclass of Food, increase the counter:
            if (i instanceof Food) {
                counter++;
            }
        }
        return counter;
        
    } // end getFoodCount method.

    /**
     * Returns the number of pet objects in the list of things in this pet
     * store.
     * 
     * @return The number of pets currently in the list of things in this pet
     *         store.
     */
    public int getPetCount() {
        
        // Initialize a counter:
        int counter = 0;
        for (Thing i : things) {
            
            // If the Thing is a subclass of Pet, increase the counter:
            if (i instanceof Pet) {
                counter++;
            }
        }
        return counter;
        
    } // end getPetCount method.

    /**
     * Adds items loaded from a given text file to the list of items in the
     * store. The items are stored line-by-line in the text file. Each line
     * contains values separated by a tab character. The data in the lines are
     * with: 3-columns for Food: FoodName Price Weight 4-columns for Pet :
     * PetNamme PetKind Price FoodPerDay
     * 
     * @param fileName The text file from where Things are to be added to the
     *                 list of items for sale in the pet store.
     */
    public void addItemsFromFile(String fileName) throws FileNotFoundException {
        
        // Create a new Scanner for the prompted file:
        Scanner ip = null;
        try {      
            ip = new Scanner(new File(fileName));
                
            // Check every String in the file:
            while (ip.hasNext()) {
                String name = ip.next();
            
                // Initialize a new Thing every loop cycle:
                Thing a = null;
                
                // Sort names in the helper method:
                a = sortNames(name, a, ip);
            
                // Once the object is created, add it to the global ArrayList:
                things.add(a);
            }
            
        // Catch Exception if no file's found:
        } catch (FileNotFoundException e) {
            System.out.print(e.getMessage());
        }
        
        // Close the scanner:
        ip.close();

    } // end addItemsFromFile method.
    
    /**
     * This helper method identifies which object to create based on the
     * String parameter.
     * @param name the name of the object to create.
     * @param x the "Thing" object being manipulated.
     * @param ip the scanner inside the file being read.
     * @return the new Thing as a proper object.
     */
    public Thing sortNames(String name, Thing x, Scanner ip) {
        
        // Match the name string with each subclass of Thing:
        if (name.equals("Cat")) {
        
            // Create a new object of the respective subclass:
            x = new Cat(ip.next(), ip.nextFloat(), ip.nextFloat());
        } else if (name.equals("Dog")) {
            x = new Dog(ip.next(), ip.nextFloat(), ip.nextFloat());
        } else if (name.equals("Octopus")) {
            x = new Octopus(ip.next(), ip.nextFloat(), ip.nextFloat());
        } else if (name.equals("Fish")) {
            x = new Fish(ip.next(), ip.nextFloat(), ip.nextFloat());
        } else if (name.equals("WormCan")) {
            x = new WormCan(ip.nextFloat(), ip.nextFloat());
        } else if (name.equals("ChowBag")) {
            x = new ChowBag(ip.nextFloat(), ip.nextFloat());
        }
        
        // Return the new Thing:
        return x;
        
    } // end sortNames class.

    /**
     * Interface method to print a summary of the items in the pet store. The
     * summary is computed and printed using the supplied SUMMARY_FORMAT string.
     * 
     * @see SUMMARY_FORMAT
     */
    public void printSummary() {
        
        // Declare and initialize the statistics:
        int countPetsA = 0;
        float pricePetsA = 0;
        int countPets = 0;
        float pricePets = 0;
        int countFood = 0;
        float priceFood = 0;
        int countFoodA = 0;
        float priceFoodA = 0;
        
        // Call into a helper method to reduce method lines:
        sortStats(countPetsA, pricePetsA, countPets, pricePets,
                countFoodA, priceFoodA, countFood, priceFood);
        
    } // end printSummary method.
    
    /**
     * This helper method finishes the printSummary method using
     * its declared variables, and helps reduce the number of
     * lines in that method. It properly sorts, calculates, and
     * prints all counts and prices.
     * @param a the number of aquatic pets.
     * @param b the price of the aquatic pets.
     * @param c the number of nonaquatic pets.
     * @param d the price of the nonaquatic pets.
     * @param e the number of aquatic food items.
     * @param f the price of the aquatic food items.
     * @param g the number of nonaquatic food items.
     * @param h the price of the nonaquatic food items.
     */
    public void sortStats(int a, float b, int c, float d, 
            int e, float f, int g, float h) {
        
        for (Thing i : things) {
            
            // If the index Thing is a pet:
            if (i instanceof Pet) {
                
                // Check if it's aquatic:
                if (i.isAquatic()) {
                    
                    // Add +1 to the Aquatic pet counter and add to price total:
                    a++;
                    b += i.getPrice();
                } else {
                    
                    // Add +1 to the pet counter and add to the price total:
                    c++;
                    d += i.getPrice();
                }
            
            // Repeat the same organization process with the Food subclasses:
            } else {
                if (i.isAquatic()) {
                    e++;
                    f += i.getPrice();
                } else {
                    g++;
                    h += i.getPrice();
                }
            }
        }
        
        // One-letter variables were used to reduce this print line:
        System.out.printf(SUMMARY_FORMAT, a, b, e, f, c, d, g, h);
        
    } // end sortStats method.

    /**
     * A simple method that prints all of the things in the store.
     */
    public void printAllThings() {
        
        System.out.println("List of all items:");
        
        // Enhanced for loop used for the "things" ArrayList:
        for (Thing i : things) {
            
            // Print every element of the Arraylist on a separate line:
            System.out.println(i);
        }
        
    } // end printAllThings method.

    /**
     * Computes and prints the amount of aquatic and non-aquatic food needed to
     * feed all of the pets in the store along with the amount of food currently
     * available. The food needed by pets is computed by adding the daily food
     * needs of all the pets. The food available is computed by adding the
     * weight of all the food things.
     * 
     * @see FOOD_STATUS
     */
    public void reportFoodStatus() {
        
        // The aquatic food needed:
        float foodNeededA = 0;
        
        // The normal food needed:
        float foodNeeded = 0;
        
        // The aquatic food in the store:
        float foodStockA = 0;
        
        // The normal food in the store:
        float foodStock = 0;
        
        for (Thing i : things) {
            
            // Check if the object is a pet:
            if (i instanceof Pet) {
                
                // Downcast to allow use of the getFoodPerDay() method:
                Pet j = (Pet) i;
                
                // Check if Pet is aquatic and add to the proper total:
                if (i.isAquatic()) {
                    foodNeededA += j.getFoodPerDay();
                } else {
                    foodNeeded += j.getFoodPerDay();
                }
            
            // Assume the object is Food if not a Pet:
            } else {
                
                // Downcast to allow use of the getFoodPerDay() method:
                Food j = (Food) i;
                
                // Check if Food is aquatic and add to the proper total:
                if (j.isAquatic()) {
                    foodStockA += j.getWeight();
                } else {
                    foodStock += j.getWeight();
                }
            }
        }
        
        // Print FOOD_STATUS with all calculated variables:
        System.out.printf(FOOD_STATUS, foodNeededA, foodNeeded, 
                foodStockA, foodStock);
        
    } // end reportFoodStatus method.
    
} // end class.

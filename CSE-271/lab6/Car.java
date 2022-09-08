// Kevin, CSE 271

/*
 * This class is designed to allow for the creation of a car, followed by
 * several ways in which the "car" can be interacted with.
 */
public class Car {
    
    // Add instance variables for the car:
    private String make;
    private int mileage;
    
    /*
     * this method is a constructor method to identify both the make
     * and mileage of the car, if it has mileage.
     * @param theMake the make of the car.
     * @param theMileage the mileage of the car.
     */
    public Car(String theMake, int theMileage) {
        make = theMake;
        mileage = theMileage;
    } // end Car constructor.
    
    /*
     * This method is a constructor method to identify the make
     * of the car, while setting the mileage to 0.
     * @param theMake the make of the car.
     */
    public Car(String theMake) {
        make = theMake;
        mileage = 0;
    } // end Car constructor.
    
    /*
     * This method returns the make of the car as a String.
     * @return the make of the car as a String.
     */
    public String getMake() {
        return this.make;
    } // end getMake method.
    
    /*
     * This method returns the mileage of the car as a String.
     * @return the mileage of the car as a String.
     */
    public int getMileage() {
        return this.mileage;
    } // end getMileage method.
    
    /*
     * This method adds a certain distance to the current mileage
     * of a car.
     * @param distance the amount to add to the mileage
     * no return value.
     */
    public void drive(int distance) {
        this.mileage += Math.abs(distance);
    } // end drive method.
    
    /*
     * This method prints a string to the end of a car's make
     * to make it "beep".
     * no return value.
     */
    public void honkHorn() {
        System.out.println(this.make + ": beep");
    } // end honkHorn method.
    
    /*
     * This method returns the make and the mileage of a car as
     * a String.
     */
    public String toString() {
        String description = this.make + ": " + this.mileage;
        return description;
    } // end toString method.
    
} // end Car class
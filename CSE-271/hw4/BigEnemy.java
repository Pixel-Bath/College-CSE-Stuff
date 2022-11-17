// Kevin, CSE 271
import java.awt.Color;
import java.util.ArrayList;

/**
 * This class extends on Enemy, and creates Big enemies
 * as well as their properties.
 * 
 *
 */
public class BigEnemy extends Enemy {
    
    /**
     * This constructs a Big enemy.
     * @param panelWidth the width of the panel
     * @param panelHeight the height of the panel.
     */
    public BigEnemy(int panelWidth, int panelHeight) {
        
        super((int)(Math.floor(Math.random() * panelWidth / 2)), 
                (int)(Math.floor(Math.random() * panelHeight / 2)), 56, 56, 4);
        setColor();
        
    } // end BigEnemy constructor.
    
    /**
     * This method sets the enemy color to
     * a random color and overrides setColor().
     */
    @Override 
    public void setColor() {
        
        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);
        setEnemyColor(new Color(r, g, b));
        
    } // end setColor method.
    
    /**
     * This method updates the bounds of the enemy.
     * @param frWidth the width of the frame
     * @param frHeight the height of the frame
     */
    public void move(int frWidth, int frHeight) {
        
        // Declare current position and height:
        int currPos = this.getX();
        int currHeight = this.getY();
        
        // Declare the enemy speed as the current speed:
        double currSpeed = this.getEnemySpeed();
        
        // Change direction if the enemy moves out of the border:
        if (currPos + currSpeed >= frWidth - (this.getWidth() + 10)
                || currPos + currSpeed < 0) {
            this.setEnemySpeed(currSpeed * -1);
        }
        
        // Update the bounds:
        this.setBounds((int)(currPos + currSpeed), currHeight, 
                this.getWidth(), this.getHeight());
    } // end move method.
    
    /**
     * This method is called upon collision with a missile.
     * @param list an array list of Enemies
     * @param smallEnemy the index of the enemy in the enemy list.
     */
    public void processCollision(ArrayList<Enemy> list, int bigEnemy) {
        
        // Shrink the size by 20:
        int newWidth = this.getWidth() - 20;
        int newHeight = this.getHeight() - 20;
        
        // If the size becomes 0 or less, remove the enemy:
        if (newWidth <= 0 || newHeight <= 0) {
            list.remove(bigEnemy);
        }
        
        // Set the new size:
        this.setBounds(this.getX(), this.getY(), newWidth, newHeight);
    } // end processCollision method.
    
} // end class

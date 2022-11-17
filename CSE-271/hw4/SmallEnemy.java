// Kevin, CSE 271
import java.awt.Color;
import java.util.ArrayList;

/**
 * This class extends on Enemy, and creates Small enemies
 * as well as their properties.
 * 
 *
 */
public class SmallEnemy extends Enemy {
    
    /**
     * This constructs a Small enemy.
     * @param panelWidth the width of the game panel.
     * @param panelHeight the height of the game panel.
     */
    public SmallEnemy(int panelWidth, int panelHeight) {
        
        // Call back to the Enemy constructor:
        super((int)(Math.floor(Math.random() * panelWidth / 2)), 
                (int)(Math.floor(Math.random() * panelHeight / 2)), 30, 30, 6);
        
        // Set the enemy's color:
        this.setColor();
    } // end SmallEnemy constructor.
    
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
        
        // Declare the enemy speed as current speed:
        double currSpeed = this.getEnemySpeed();
        
        // Change direction if the enemy moves out of the border:
        if (currPos + currSpeed > frWidth - (this.getWidth() + 10)
                || currPos + currSpeed < 0) {
            currSpeed *= -1;
        }
        
        // Update the bounds:
        this.setBounds((int)(currPos + currSpeed), currHeight, 
                this.getWidth(), this.getHeight());
        
        // Every time this method is called, increase speed by 0.05:
        if (currSpeed > 0) {
            this.setEnemySpeed(currSpeed + 0.05);  
            
        } else {
            this.setEnemySpeed(currSpeed - 0.05);
            
        }
        
    } // end move method.
    
    /**
     * This method is called upon collision with a missile.
     * @param list an array list of Enemies
     * @param smallEnemy the index of the enemy in the enemy list.
     */
    public void processCollision(ArrayList<Enemy> list, int smallEnemy) {
        
        // Shrink the size by 10:
        int newWidth = this.getWidth() - 10;
        int newHeight = this.getHeight() - 10;
        
        // If the size becomes 0 or less, remove the enemy:
        if (newWidth <= 0 || newHeight <= 0) {
            list.remove(smallEnemy);
            
        }
        
        // Set the new size:
        this.setBounds(this.getX(), this.getY(), newWidth, newHeight);
        
    } // end processCollision method.
    
} // end class.

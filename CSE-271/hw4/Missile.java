// Kevin Koepp, CSE 271
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * This class extends on JComponent, and creates
 * Missiles and their properties.
 * @author koeppkm2
 *
 */
public class Missile extends JComponent {
    
    // The speed of the missile:
    private int missileSpeed = 5;
    
    // The color of the missile:
    private Color missileColor;
    
    /**
     * This constructs a missile.
     * @param x the horizontal location of the missile.
     * @param y the vertical location of the missile.
     */
    public Missile(int x, int y) {
        this.setBounds(x, y, 15, 15);
        this.setMissileColor();
        
    } // end Missile constructor
    
    /**
     * This method paints the missile on the GUI.
     * @param g the Graphics.
     */
    @Override
    public void paintComponent(Graphics g) {
        
        // Declare the bounds of the missile as a new Rectangle:
        final Rectangle bounds = this.getBounds();
        
        // Set the color and draw the missile:
        g.setColor(missileColor);
        g.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
        
    } // end paintComponent method
    
    /**
     * This method randomly generates
     * a color for the missile.
     */
    public void setMissileColor() {
        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);
        missileColor = new Color(r, g, b);
        
    } // end setMissileColor method
    
    /**
     * This method gets the missile speed.
     * @return the missile speed.
     */
    public int getMissileSpeed() {
        return missileSpeed;
        
    } // end getMissileSpeed method
    
    /**
     * This method moves the missile according to its speed.
     * @param panWidth the width of the panel.
     * @param panHeight the height of the panel.
     * @param list the list of Missles.
     * @param missile the missile at the index of the list.
     */
    public void move(int panWidth, int panHeight, 
            ArrayList<Missile> list, int missile) {
        
        // Decalre the X and Y location of the missile:
        int currX = this.getX();
        int currY = this.getY();
        
        // Remove the missile if it goes off the panel:
        if (currY - missileSpeed < 0) {
            list.remove(missile);
        }
        
        // Update the location of the missile:
        this.setLocation(currX, currY - missileSpeed);
        
    } // end move method
    
}
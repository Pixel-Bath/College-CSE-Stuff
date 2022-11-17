// Kevin Koepp, CSE 271

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
 * This class creates a Turret for the game panel.
 * @author koeppkm2
 *
 */
public class Turret extends JComponent {
    
    private Rectangle base;
    private Rectangle turret;
    private Color turretColor;
    
    /**
     * This constructor initializes the base, turret barrel, and color.
     */
    public Turret() {
        base = new Rectangle(290, 410, 80, 20);
        turret = new Rectangle(320, 375, 20, 50);
        turretColor = new Color(150, 150, 150);
    } // end Turret constructor.
    
    /**
     * This method paints the Turret on the GUI.
     * @param g the Graphics to display.
     */
    public void paintComponent(Graphics g) {
        
        // Set the bounds for the base and the turret:
        Rectangle baseBounds = base.getBounds();
        Rectangle turretBounds = turret.getBounds();
        
        // Set the turret's color:
        g.setColor(turretColor);
        
        // Paint the turret using the bounds:
        g.fillRect(baseBounds.x, baseBounds.y, 
                baseBounds.width, baseBounds.height);
        g.fillRect(turretBounds.x, turretBounds.y, 
                turretBounds.width, turretBounds.height);
        
    } // end paintComponent method.
    
}
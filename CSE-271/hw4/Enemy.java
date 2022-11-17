// Kevin Koepp, CSE 271
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * This is an abstract parent class for
 * BigEnemy and SmallEnemy.
 * @author koeppkm2
 *
 */
public abstract class Enemy extends JComponent {
    
    // The speed of the enemy:
    private double enemySpeed;
    
    // The color of the enemy:
    private Color enemyColor;
    
    /**
     * This constructs an Enemy.
     * @param x The horizontal location of the enemy.
     * @param y The vertical location of the enemy.
     * @param height The height of the enemy.
     * @param width The width of the enemy.
     * @param es The enemy's speed.
     */
    public Enemy(int x, int y, int height, int width, double es) {
        this.setBounds(x, y, width, height);
        enemySpeed = es;
        
    } // end Enemy constructor.
    
    public abstract void processCollision(ArrayList<Enemy> list, int enemy);
    
    public abstract void setColor();
    
    public abstract void move(int frWidth, int frHeight);
    
    /**
     * This method paints the enemies on the GUI.
     * @param g the Graphics.
     */
    @Override
    public void paintComponent(Graphics g) {
        
        // Declare the enemy size as a Rectangle:
        final Rectangle circ = this.getBounds();
        
        // Set to the enemy's color and draw it:
        g.setColor(enemyColor);
        g.fillOval(circ.x, circ.y, circ.width, circ.height);
        g.setColor(new Color(0, 0, 0, 0));
       
    } // end paintComponent method.
    
    /**
     * This method gets the enemy's speed.
     * @return the enemy speed
     */
    public double getEnemySpeed() {
        return enemySpeed;
        
    } // end getEnemySpeed method.
    
    /**
     * This method sets the enemy speed.
     * @param es The speed to set the enemy to
     */
    public void setEnemySpeed(double es) {
        enemySpeed = es;
        
    } // end setEnemySpeed method.
    
    /**
     * This method gets the color of the enemy.
     * @return the enemy's color
     */
    public Color getEnemyColor() {
        return enemyColor;
        
    } // end getEnemyColor method.
    
    /**
     * This method sets the color of the enemy.
     * @param c The color to set the enemy to
     */
    public void setEnemyColor(Color c) {
        enemyColor = c;
        
    } // end setEnemyColor method.
    
} // end class
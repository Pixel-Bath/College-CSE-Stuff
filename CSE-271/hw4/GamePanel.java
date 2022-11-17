// Kevin, CSE 271

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * This class contains the paintable objects such as the enemies, turret, and
 * missile. It also keeps track of the total score.
 * 
 * 
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {

    private int totalScore = 0;
    
    private boolean isNextEnemyBig = true;
    
    private Turret turret;
    
    private ArrayList<Enemy> enemyList;
    
    private ArrayList<Missile> missileList;
    
    /**
     * This constructor initializes most game components for the panel.
     * It also spawns two enemies to be displayed at the start of the game.
     */
    public GamePanel() {
        turret = new Turret();
        enemyList = new ArrayList<Enemy>();
        missileList = new ArrayList<Missile>();
        Enemy e = new BigEnemy(600, 200);
        Enemy f = new SmallEnemy(600, 200);
        enemyList.add(e);
        enemyList.add(f);
        
    } // end GamePanel constructor.
    
    /**
     * This method paints the background and calls all other
     * paint methods to paint each component.
     * @param g the Graphics displayed on the GUI.
     * 
     */
    public void paintComponent(Graphics g) {
        
        // paint the background whenever this method is called:
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        // Paint every enemy on the screen:
        for (Enemy e : enemyList) {
            e.paintComponent(g);
        }
        
        // Paint every missile on the screen:
        for (Missile m : missileList) {
            m.paintComponent(g);
        }
        
        // Paint the turret:
        turret.paintComponent(g);
        
    } // end paintComponent method.
    
    /**
     * This method moves the enemies and missiles.
     */
    public void move() {
        
        // Move each enemy on the screen:
        for (Enemy e : enemyList) {
            e.move(700, 500);
        }
        
        // Move each missile on the screen:
        for (int i = 0; i < missileList.size(); i++) {
            Missile m = missileList.get(i);
            m.move(700,  500, missileList, i);
        }
        
    } // end move method.
    
    /**
     * This method spawns a new missile in the Turret
     * and adds it to the ArrayList.
     */
    public void addMissile() {
        Missile m = new Missile(322, 375);
        missileList.add(m);
    }
    
    /**
     * This method retrieves the total score the
     * player has earned.
     * @return the total score.
     */
    public int getTotalScore() {
        return totalScore;
        
    } // end getTotalScore method.
    
    /**
     * This method adds an Enemy to the game, depending on the
     * state of the isNextEnemyBig boolean.
     */
    public void addEnemy() {
        
        // Add a big enemy if true:
        if (isNextEnemyBig) {
            BigEnemy b = new BigEnemy(600, 200);
            enemyList.add(b);
            
            // Toggle the boolean:
            isNextEnemyBig = false;
        
        // Otherwise, add a Small Enemy:
        } else {
            SmallEnemy s = new SmallEnemy(600, 200);
            enemyList.add(s);
            
            // Toggle the boolean:
            isNextEnemyBig = true;
            
        } // end addEnemy method.
        
    } // end class
    
    /**
     * Method detects the collision of the missile and all the enemies. This is
     * done by drawing invisible rectangles around the enemies and missiles, if
     * they intersect, then they collide.
     */
    public void detectCollision() {
        // Uses bounds for enemies and missiles to detect intersection.
        for (int i = 0; i < enemyList.size(); i++) {
            Rectangle enemyRec = enemyList.get(i).getBounds();
            for (int j = 0; j < missileList.size(); j++) {
                Rectangle missileRec = missileList.get(j).getBounds();
                if (missileRec.intersects(enemyRec)) {
                    // Missile has hit an enemy!
                    enemyList.get(i).processCollision(enemyList, i);
                    missileList.remove(j);
                    if (enemyList.get(i) instanceof BigEnemy) {
                        totalScore += 100;
                    } else {
                        totalScore += 150;
                    }
                }
            }
        }
    } // end detectCollision method.
} // end class

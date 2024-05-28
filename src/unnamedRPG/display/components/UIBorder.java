package unnamedRPG.display.components;

import java.awt.BasicStroke;
import unnamedRPG.model.Map;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import unnamedRPG.display.Limits;
import static unnamedRPG.UnnamedRPG.DISPLAY_SIZE;
import static unnamedRPG.UnnamedRPG.FRAME_HEIGHT;
import static unnamedRPG.UnnamedRPG.FRAME_WIDTH;
import static unnamedRPG.UnnamedRPG.MAP_LENGTH;
import static unnamedRPG.UnnamedRPG.MAP_WIDTH;
import static unnamedRPG.UnnamedRPG.RANDOM;

/**
 *
 * @author seb
 */
    public class UIBorder extends JComponent {
        Map map;
        
        Color brownBush = new Color(108, 80, 7);
        Color greenBush = new Color(34, 139, 34);
        Color brownTree = new Color(74, 61, 29);
        Color greenTree = new Color(0, 128, 0);
        Color blackFissure = new Color(0, 0, 0);
        
        Font textFont;
        Color fontColor = new Color (48, 116, 42);
        
        String charString;
        
        Limits boardLimits;
        Limits frameLimits;


        public UIBorder(Map map, Limits boardLimits, Limits frameLimits) {
            this.map = map;
            
            this.boardLimits = boardLimits;
            this.frameLimits = frameLimits;
            
            this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        }


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            Graphics2D g2d = (Graphics2D) g;
            
            
            g.setColor(BLACK);
            g.fillRect(0, boardLimits.endY, frameLimits.lengthX, frameLimits.lengthY - boardLimits.lengthY);
            
            g2d.setColor(RED);
            g2d.setStroke(new BasicStroke(10));
            
            g2d.drawRect(frameLimits.startX, frameLimits.startY, frameLimits.lengthX, boardLimits.lengthY);
            
            
            textFont =  new Font("Arial", Font.PLAIN, (50));
            

        }

}

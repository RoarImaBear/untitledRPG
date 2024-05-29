package unnamedRPG.display.components;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import static unnamedRPG.UnnamedRPG.DECORATOR;
import unnamedRPG.display.Limits;
import static unnamedRPG.UnnamedRPG.FRAME_HEIGHT;
import static unnamedRPG.UnnamedRPG.FRAME_WIDTH;

/**
 *
 * @author seb
 */
    public class Border extends JComponent {
        Limits boardLimits;
        Limits frameLimits;

        public Border(Limits boardLimits, Limits frameLimits) {
            this.boardLimits = boardLimits;
            this.frameLimits = frameLimits;         
            this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g; 
            
            g.setColor(DECORATOR.interfaceBGColors(0));
            g.fillRect(0, boardLimits.endY, frameLimits.lengthX, frameLimits.lengthY - boardLimits.lengthY);
            
            g2d.setColor(DECORATOR.interfaceBGColors(0));
            g2d.setStroke(new BasicStroke(10));  
            g2d.drawRect(frameLimits.startX, frameLimits.startY, frameLimits.lengthX, boardLimits.lengthY);
        }

}

package unnamedRPG.display.components;

import java.awt.BasicStroke;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.RED;
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
    public class PlayerDashboard extends JComponent {
        Font textFont;
        Limits boardLimits;
        Limits frameLimits;


        public PlayerDashboard(Limits boardLimits, Limits frameLimits) {
            
            this.boardLimits = boardLimits;
            this.frameLimits = frameLimits;
            
            this.setBounds(0+10, boardLimits.endY + 8, frameLimits.lengthX-20, frameLimits.lengthY - boardLimits.lengthY);
            System.out.println(boardLimits.endY );
        }


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);  
            paintBackground(g);
            paintTextPanel(g);
            
            
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(RED);
            g2d.setStroke(new BasicStroke(10));

            
            
            textFont =  new Font("Arial", Font.PLAIN, (50));
            

        }
        
        private void paintBackground(Graphics g){
            g.setColor(DECORATOR.menuColorSwitch(1));
            g.fillRect(0, 0, 1920, 1000);
            g.setColor(DECORATOR.menuColorSwitch(2));
            g.drawRect(0, 0, 1898, 1000);
            g.setColor(DECORATOR.menuColorSwitch(4));
            g.fillRect(3, 3, 1894, 1000);
        }
        private void paintTextPanel(Graphics g){
            g.setColor(DECORATOR.menuColorSwitch(0));
            g.fillRect(frameLimits.endX - 424, 4, 400, 1000);
        }

}

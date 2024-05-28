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
import unnamedRPG.model.entities.Player;

/**
 *
 * @author seb
 */
    public class PlayerDashboard extends JComponent {
        Font textFont;
        Limits boardLimits;
        Limits frameLimits;
        
        Player player;


        public PlayerDashboard(Player player, Limits boardLimits, Limits frameLimits) {       
            this.player = player;
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
            paintHPBar(g);
            
            
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(RED);
            g2d.setStroke(new BasicStroke(10));

            
            
            textFont =  new Font("Arial", Font.PLAIN, (50));
            System.out.println(player.currentHP +"/"+ player.maxHP);

        }
        
        private void paintBackground(Graphics g){
            g.setColor(DECORATOR.interfaceBGColors(1));
            g.fillRect(0, 0, 1920, 400);
            g.setColor(DECORATOR.interfaceBGColors(2));
            g.drawRect(0, 0, 1898, 400);
            g.setColor(DECORATOR.interfaceBGColors(3));
            g.fillRect(3, 3, 1894, 400);
            g.setColor(DECORATOR.interfaceBGColors(2));
            g.fillRect(frameLimits.startX + frameLimits.lengthX/3 - 20, 4, frameLimits.lengthX/3 + 40, 400);
            g.setColor(DECORATOR.interfaceBGColors(0));
            g.drawRect(frameLimits.startX + frameLimits.lengthX/3 - 20, 4, frameLimits.lengthX/3 + 40, 400);
            
        }
        
        private void paintTextPanel(Graphics g){
            g.setColor(DECORATOR.interfaceBGColors(0));
            g.fillRect(frameLimits.endX - 424, 4, 400, 1000);
        }
        
        private void paintHPBar(Graphics g){
            int maxHPLength = frameLimits.lengthX/3;
            int currentHPLength = player.currentHP* (maxHPLength/player.maxHP); 
            
            g.setColor(DECORATOR.interfaceBGColors(0));
            g.fillRect(frameLimits.startX + maxHPLength - 3, 19, maxHPLength + 6, 10);
            g.drawString((player.currentHP +"/"+ player.maxHP), frameLimits.lengthX/2 - 20, 18);
            
            g.setColor(DECORATOR.playerInfoColors(1));
            g.fillRect(frameLimits.startX + maxHPLength - 2, 20, maxHPLength + 4, 8);
            
            g.setColor(DECORATOR.playerInfoColors(0));
            g.fillRect(frameLimits.startX + maxHPLength, 22, currentHPLength, 4);
        }

}

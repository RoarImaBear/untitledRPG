package unnamedRPG.display.components;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;
import static unnamedRPG.UnnamedRPG.DECORATOR;
import unnamedRPG.display.Limits;
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
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);  
            paintBackground(g);
            paintConsoleBackground(g);
            paintHPBar(g);
            paintStaminaBar(g);
            paintScore(g);
            paintPlayerIcon(g);
            paintWeapon(g);
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
        
        private void paintConsoleBackground(Graphics g){
            g.setColor(DECORATOR.interfaceBGColors(0));
            g.fillRect(frameLimits.endX - 424, 4, 400, 1000);
        }
        
        private void paintPlayerIcon(Graphics g){
            int yMargin = 20;
            int yMarginImg = 25;
            int xMarginImg = 75;
            int xMaringAura = 70;
            int imgSize = 150;
            int auraSize = 160;
            
            g.setColor(DECORATOR.interfaceBGColors(2));
            g.fillOval(frameLimits.startX + xMaringAura, yMargin, auraSize, auraSize);
            g.setColor(DECORATOR.interfaceBGColors(0));
            g.drawOval(frameLimits.startX + xMaringAura, yMargin, auraSize, auraSize);
            g.drawImage(player.token, frameLimits.startX + xMarginImg, yMarginImg, imgSize, imgSize, null);
        }
        
        private void paintWeapon(Graphics g){
            int yMargin = 20;
            int yMarginImg = 25;
            int xMarginImg = frameLimits.startX + frameLimits.lengthX/5;
            int xMaringAura = frameLimits.startX + frameLimits.lengthX/5 - 5;
            int imgSize = 150;
            int auraSize = 160;
            
            g.setColor(DECORATOR.interfaceBGColors(2));
            g.fillRect(frameLimits.startX + xMaringAura, yMargin, auraSize, auraSize);
            g.setColor(DECORATOR.interfaceBGColors(0));
            g.drawRect(frameLimits.startX + xMaringAura, yMargin, auraSize, auraSize);
            g.drawImage(player.equippedWeapon.image, xMarginImg, yMarginImg, imgSize, imgSize, null);

        }
        
        private void paintHPBar(Graphics g){
            int maxHPLength = frameLimits.lengthX/3;
            int currentHPLength = (int) ((double) player.currentHP * ((double) maxHPLength / player.maxHP));
            int yMargin = 20;
            
            g.setColor(DECORATOR.interfaceBGColors(0));
            g.fillRect(frameLimits.startX + maxHPLength - 3, yMargin, maxHPLength + 6, 10);
            g.drawString((player.currentHP +"/"+ player.maxHP), frameLimits.lengthX/2 - 20, 18);
            
            g.setColor(DECORATOR.playerInfoColors(1));
            g.fillRect(frameLimits.startX + maxHPLength - 2, yMargin + 1, maxHPLength + 4, 8);
            
            g.setColor(DECORATOR.playerInfoColors(0));
            g.fillRect(frameLimits.startX + maxHPLength, yMargin + 3, currentHPLength, 4);
        }
        private void paintStaminaBar(Graphics g){
            int maxStaminaLength = frameLimits.lengthX/3;
            int currentStaminaLength = (int) ((double)player.currentStamina* ((double)maxStaminaLength/player.maxStamina));
            int yMargin = 60;
            
            g.setColor(DECORATOR.interfaceBGColors(0));
            g.fillRect(frameLimits.startX + maxStaminaLength - 3, yMargin, maxStaminaLength + 6, 10);
            
            g.drawString((player.currentStamina +"/"+ player.maxStamina), frameLimits.lengthX/2 - 20, yMargin-2);
            
            g.setColor(DECORATOR.playerInfoColors(3));
            g.fillRect(frameLimits.startX + maxStaminaLength - 2, yMargin + 1, maxStaminaLength + 4, 8);
            
            g.setColor(DECORATOR.playerInfoColors(2));
            g.fillRect(frameLimits.startX + maxStaminaLength, yMargin + 3, currentStaminaLength, 4);
        }
        
        private void paintScore(Graphics g){
            int maxStaminaLength = frameLimits.lengthX/3;
            int currentStaminaLength = (int) ((double)player.currentScore* ((double)maxStaminaLength/player.maxScore));
            int yMargin = 100;
            
            g.setColor(DECORATOR.interfaceBGColors(0));
            g.fillRect(frameLimits.startX + maxStaminaLength - 3, yMargin, maxStaminaLength + 6, 10);
            
            g.drawString((player.currentScore+""), frameLimits.lengthX/2 - 9, yMargin-2);
            
            g.setColor(DECORATOR.playerInfoColors(5));
            g.fillRect(frameLimits.startX + maxStaminaLength - 2, yMargin + 1, maxStaminaLength + 4, 8);
            
            g.setColor(DECORATOR.playerInfoColors(4));
            g.fillRect(frameLimits.startX + maxStaminaLength, yMargin + 3, currentStaminaLength, 4);
        }

}

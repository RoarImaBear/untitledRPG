package unnamedRPG.display;

import java.awt.BasicStroke;
import unnamedRPG.Map;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import static unnamedRPG.UnnamedRPG.DISPLAY_SIZE;
import static unnamedRPG.UnnamedRPG.FRAME_HEIGHT;
import static unnamedRPG.UnnamedRPG.FRAME_WIDTH;
import static unnamedRPG.UnnamedRPG.MAP_LENGTH;
import static unnamedRPG.UnnamedRPG.MAP_WIDTH;
import static unnamedRPG.UnnamedRPG.random;

/**
 *
 * @author seb
 */
    public class UIBorderComponent extends JComponent {
        Map map;
        Camera camera;
        
        Color brownBush = new Color(108, 80, 7);
        Color greenBush = new Color(34, 139, 34);
        Color brownTree = new Color(74, 61, 29);
        Color greenTree = new Color(0, 128, 0);
        Color blackFissure = new Color(0, 0, 0);
        
        Font textFont;
        Color fontColor = new Color (48, 116, 42);
        
        String charString;
        int[][] boardXYLimits;
        int[][] frameXYLimits;


        public UIBorderComponent(Map map, Camera camera, int[][] boardXYLimits, int[][] frameXYLimits) {
            this.map = map;
            this.camera = camera;
            this.boardXYLimits = boardXYLimits;
            this.frameXYLimits = frameXYLimits;
            
            this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        }


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            Graphics2D g2d = (Graphics2D) g;
            
            
            g.setColor(BLACK);
            g.fillRect(0, boardXYLimits[1][1], frameXYLimits[0][1], frameXYLimits[1][1]);
            
            g2d.setColor(BLACK);
            g2d.setStroke(new BasicStroke(10));
            
            g2d.drawRect(boardXYLimits[0][0], boardXYLimits[1][0], boardXYLimits[0][1], boardXYLimits[1][1]);
            
            
            textFont =  new Font("Arial", Font.PLAIN, (50 / camera.zoomOutModifier));
            

        }
    
    Color[] createPallette(int numberOfColors, int[] anchorValue, int variance) {
        Color[] pallette = new Color[numberOfColors];
        for (int i = 0; i < pallette.length; i++) {
            pallette[i] = new Color(anchorValue[0] + random.nextInt(variance), 
                anchorValue[1] + random.nextInt(variance), anchorValue[2] + 
                random.nextInt(variance));
        }
        return pallette;
    }
    

}

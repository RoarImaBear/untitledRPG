package unnamedRPG.display;

import unnamedRPG.Map;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.WHITE;
import java.awt.Graphics;
import javax.swing.JComponent;
import static unnamedRPG.UnnamedRPG.FRAME_HEIGHT;
import static unnamedRPG.UnnamedRPG.FRAME_WIDTH;
import static unnamedRPG.UnnamedRPG.MAP_LENGTH;
import static unnamedRPG.UnnamedRPG.MAP_WIDTH;
import static unnamedRPG.UnnamedRPG.random;

/**
 *
 * @author seb
 */
    public class TerrainLayerBackup extends JComponent {
        private int x, y;
        
        Map map;
        int mapScale;
        
        Color[] grassGreens;
        int[] grassAnchor = {73, 156, 77};
        Color[] waterBlues;
        int[] waterAnchor = {25, 109, 150};
        
        
        Color greenBush = new Color(34, 139, 34);
        Color greenTree = new Color(0, 128, 0);
        Color blackFissure = new Color(0, 0, 0);



        public TerrainLayerBackup(Map map) {
            this.map = map;
            this.mapScale = 10;
            
            this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
            this.grassGreens = createPallette(10, grassAnchor, 5);
            this.waterBlues = createPallette(10, waterAnchor, 30);
        }


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            
            
            // what area of map are we painting???  4xzoom max???
            
            
            
            
            
            for (int y = 0, mapY = 0; mapY < MAP_LENGTH; y += mapScale, mapY++) {
                for (int x = 0, mapX = 0; mapX < MAP_WIDTH; x += mapScale, mapX++) {
                    char currentTile = map.terrain[mapX][mapY];
                        g.setColor(colorSwitch(currentTile));
                        g.fillRect(x, y, mapScale, mapScale);
                }
            }
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
    
    Color colorSwitch(char subject) {

        switch (subject) {
            case ('„'):
                return grassGreens[random.nextInt(10)];
            case ('ϫ'):
                return greenBush;
            case ('ϒ'):
                return greenTree;
            case ('|'):
                return blackFissure;
            case ('~'):
                return waterBlues[random.nextInt(10)];
        }
        return BLUE;
    }
    


}
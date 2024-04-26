package unnamedRPG.display;

import unnamedRPG.Map;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.WHITE;
import java.awt.Graphics;
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
    public class TerrainLayer extends JComponent {
        private int x, y;
        
        Map map;
        Camera camera;
        
        int mapStartX;
        int mapStartY;
        int displayX;
        int displayY;
        
        
        Color[] grassGreens;
        int[] grassAnchor = {73, 156, 77};
        Color[] waterBlues;
        int[] waterAnchor = {25, 109, 150};
        
        
        Color greenBush = new Color(34, 139, 34);
        Color greenTree = new Color(0, 128, 0);
        Color blackFissure = new Color(0, 0, 0);



        public TerrainLayer(Map map, Camera camera) {
            this.map = map;
            this.camera = camera;
            
            this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
            this.grassGreens = createPallette(10, grassAnchor, 5);
            this.waterBlues = createPallette(10, waterAnchor, 30);
        }


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            double displayWidth = DISPLAY_SIZE.width;
            double displayHeight = DISPLAY_SIZE.height;
            int baseNumYTiles = camera.baseNumYTiles;
            double aspectRatio = (displayWidth / displayHeight);
            int zoomOutModifier = camera.zoomOutModifier;
            
            mapStartX = camera.mapStartX;
            
            mapStartY = camera.mapStartY;
            
            int numXTiles = (int) (baseNumYTiles * aspectRatio * zoomOutModifier);
            int numYTiles = baseNumYTiles * zoomOutModifier;
            int tileSize = (int) (displayHeight/numYTiles);
            int displayStartX = camera.displayStartX;
            int displayStartY = camera.displayStartY;
            
            int mapXLimit = mapStartX + numXTiles + 5;
            int mapYLimit = mapStartY + numYTiles + 5;
            if (mapXLimit > MAP_WIDTH){
                mapXLimit = MAP_WIDTH;
            }
            if (mapYLimit > MAP_LENGTH){
                mapYLimit = MAP_LENGTH;
            }
            
            
                for (int mY = mapStartY, dY = displayStartY; mY < mapYLimit; mY++, dY += tileSize) {
                    for (int mX = mapStartX, dX = displayStartX; mX < mapXLimit; mX++, dX += tileSize) {
                        char currentTile = map.terrain[mX][mY];
                        g.setColor(colorSwitch(currentTile));
                        g.fillRect(dX, dY, tileSize, tileSize);
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
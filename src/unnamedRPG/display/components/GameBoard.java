package unnamedRPG.display.components;

import unnamedRPG.Map;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.WHITE;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;
import unnamedRPG.display.Camera;
import unnamedRPG.display.Limits;
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
    public class GameBoard extends JComponent {
        Map map;
        Camera camera;
        
        Color[] grassGreens;
        int[] grassAnchor = {73, 156, 77};
        Color[] waterBlues;
        int[] waterAnchor = {25, 109, 150};
        
        
        Color brownBush = new Color(108, 80, 7);
        Color greenBush = new Color(34, 139, 34);
        Color brownTree = new Color(74, 61, 29);
        Color greenTree = new Color(0, 128, 0);
        Color blackFissure = new Color(0, 0, 0);
        
        Font textFont;
        Color fontColor = new Color (48, 116, 42);
        
        String charString;
        
        Limits boardLimits;
        
        Limits tilesToRender;
        
        int tileSize;
        int baseTileSize = 16;
        int tileCountX;
        int tileCountY;


        public GameBoard(Map map, Camera camera, Limits boardLimits) {
            this.map = map;
            this.camera = camera;
            this.boardLimits = boardLimits;
            
            this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
            
            updateTilesToRender(1);
        }


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            g.setColor(BLUE);
            
//            g.fillRect(boardLimits.startX, boardLimits.startY, boardLimits.lengthX, boardLimits.lengthY);       
//            textFont =  new Font("Arial", Font.PLAIN, 50);
            
            for (int y = 0, startY = boardLimits.startY; y < tileCountY; y++, startY += tileSize) {
                for (int x = 0, startX = boardLimits.startX; x < tileCountX; x++) {
                    
                }
                
            }
            
            
            

        }
        
        
        void updateTilesToRender(int magnification) {
            this.boardLimits = new Limits(5, 5, FRAME_WIDTH, FRAME_HEIGHT-200);
            
            tileSize = baseTileSize * magnification; 
                    
            tileCountX = boardLimits.lengthX/baseTileSize;
            tileCountY = boardLimits.lengthY/baseTileSize;
            System.out.println("XFrames: " + tileCountX + " YFrames: " + tileCountY);
            
        }
        
        
}


//            for (int mapY = mapStartY, displayY = displayStartY; mapY < mapEndY; mapY++, displayY += tileSize) {
//                for (int mapX = mapStartX, displayX = displayStartX; mapX < mapEndX; mapX++, displayX += tileSize) {
//                    char currentTile = map.terrain[mapX][mapY];
//                    g.setColor(colorSwitch(currentTile));
//                    g.fillRect(displayX, displayY, tileSize-1, tileSize-1);
//                    g.setColor(fontColor);
//                    g.setFont(fontSwitch(currentTile));
//                    charString = currentTile + "";
//                    g.drawString(charString, (displayX + tileSize/5), (displayY + tileSize/2 ));
//                }   
//            }

  
//    Color colorSwitch(char subject) {
//
//        switch (subject) {
//            case ('„'):
//                return grassGreens[random.nextInt(10)];
//            case ('ϫ'):
//                return brownBush;
//            case ('ϒ'):
//                return brownTree;
//            case ('|'):
//                return blackFissure;
//            case ('~'):
//                return waterBlues[random.nextInt(10)];
//        }
//        return BLUE;
//    }
//    
//    Font fontSwitch (char subject) {
//
//        switch (subject) {
//            case ('„'):
//                return new Font("Arial", Font.PLAIN, (50));
//            case ('ϫ'):
//                return new Font("Arial", Font.PLAIN, (80));
//            case ('ϒ'):
//                return new Font("Arial", Font.PLAIN, (12));
//            case ('|'):
//                return new Font("Arial", Font.PLAIN, 50);
//            case ('~'):
//                return new Font("Arial", Font.PLAIN, 50);
//        }
//        return new Font("Arial", Font.PLAIN, (50));
//    }
//    
    
//    Color[] createPallette(int numberOfColors, int[] anchorValue, int variance) {
//        Color[] pallette = new Color[numberOfColors];
//        for (int i = 0; i < pallette.length; i++) {
//            pallette[i] = new Color(anchorValue[0] + random.nextInt(variance), 
//                anchorValue[1] + random.nextInt(variance), anchorValue[2] + 
//                random.nextInt(variance));
//        }
//        return pallette;
//    }
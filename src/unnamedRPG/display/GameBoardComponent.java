package unnamedRPG.display;

import unnamedRPG.Map;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.WHITE;
import java.awt.Font;
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
    public class GameBoardComponent extends JComponent {
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
        
        int[][] boardLimits;



        public GameBoardComponent(Map map, Camera camera, int[][] boardLimits) {
            this.map = map;
            this.camera = camera;
            this.boardLimits = boardLimits;
            
            this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
            this.grassGreens = createPallette(10, grassAnchor, 3);
            this.waterBlues = createPallette(10, waterAnchor, 30);
        }


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            
            int tileSize = camera.tileSize;
                        
            int mapStartX = camera.mapStartX;
            int mapStartY = camera.mapStartY;
            
            int displayStartX = camera.displayStartX;
            int displayStartY = camera.displayStartY;
            
            int mapEndX = camera.mapEndX;
            int mapEndY = camera.mapEndY;
            
            g.setColor(BLUE);
            
            g.fillRect(boardLimits[0][0], boardLimits[1][0], boardLimits[0][1], boardLimits[1][1]);
            
            
//            System.out.println(boardXYLimits[0][0] +" "+ boardXYLimits[0][1] + " "+ boardXYLimits[1][0] + " " + boardXYLimits[1][1]);
            
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
    
    Color colorSwitch(char subject) {

        switch (subject) {
            case ('„'):
                return grassGreens[random.nextInt(10)];
            case ('ϫ'):
                return brownBush;
            case ('ϒ'):
                return brownTree;
            case ('|'):
                return blackFissure;
            case ('~'):
                return waterBlues[random.nextInt(10)];
        }
        return BLUE;
    }
    
    Font fontSwitch (char subject) {

        switch (subject) {
            case ('„'):
                return new Font("Arial", Font.PLAIN, (50 / camera.zoomOutModifier));
            case ('ϫ'):
                return new Font("Arial", Font.PLAIN, (80 / camera.zoomOutModifier));
            case ('ϒ'):
                return new Font("Arial", Font.PLAIN, (120 / camera.zoomOutModifier));
            case ('|'):
                return new Font("Arial", Font.PLAIN, (50 / camera.zoomOutModifier));
            case ('~'):
                return new Font("Arial", Font.PLAIN, (50 / camera.zoomOutModifier));
        }
        return new Font("Arial", Font.PLAIN, (50 / camera.zoomOutModifier));
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
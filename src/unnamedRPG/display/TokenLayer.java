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
import unnamedRPG.entities.Entity;

/**
 *
 * @author seb
 */
public class TokenLayer extends JComponent {

    Map map;
    Camera camera;

    Font textFont;
    Color fontColor = new Color(0, 0, 0);

    String charString;

    public TokenLayer(Map map, Camera camera) {
        this.map = map;
        this.camera = camera;

        this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        int tileSize = camera.tileSize;
//
//        int mapStartX = camera.mapStartX;
//        int mapStartY = camera.mapStartY;
//
//        int displayStartX = camera.displayStartX;
//        int displayStartY = camera.displayStartY;
//
//        int mapEndX = camera.mapEndX;
//        int mapEndY = camera.mapEndY;
//
//        textFont = new Font("Arial", Font.PLAIN, (50 / camera.zoomOutModifier));
//        g.setFont(textFont);
//
//        for (int mapY = mapStartY, displayY = displayStartY; mapY < mapEndY; mapY++, displayY += tileSize) {
//            for (int mapX = mapStartX, displayX = displayStartX; mapX < mapEndX; mapX++, displayX += tileSize) {
//                if ( map.entities[mapX][mapY]!= null){
//                    Entity currentEntity = map.entities[mapX][mapY];
//                    String tokenString = currentEntity.tokenString;
//                    g.setColor(currentEntity.tokenColor);
//                    g.fillOval(displayX, displayY, tileSize - 1, tileSize - 1);
//                    g.setColor(fontColor);
//                    g.drawString(tokenString, (displayX + tileSize / 4), displayY + tileSize/2);
//                }
//
//            }
//        }
    }
}

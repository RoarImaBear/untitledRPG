/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.display;

import static unnamedRPG.UnnamedRPG.DISPLAY_SIZE;
import static unnamedRPG.UnnamedRPG.FRAME_CENTER;

/**
 *
 * @author seb
 */
public class Camera {
    
    // TOP LEFT CORNER
    public int mapStartX;
    public int mapStartY;
    public int mapX;
    public int mapY;
    public int displayX;
    public int displayY;
    public int displayStartX;
    public int displayStartY;
    
    int baseNumYTiles = 10;

    public int zoomOutModifier = 1;
    
    public int frameCenterX = FRAME_CENTER[0];
    public int frameCenterY = FRAME_CENTER[1];

    public Camera() {
        double displayWidth = DISPLAY_SIZE.width;
        double displayHeight = DISPLAY_SIZE.height;
        double aspectRatio = (displayWidth / displayHeight);
        
        
        this.mapStartX = 0;
        this.mapStartY = 0;
        this.displayStartX = 0;
        this.displayStartY = 0;
        this.zoomOutModifier = 1;
        this.mapX = (int) (mapStartX + (baseNumYTiles * aspectRatio));
        this.mapY = mapStartY + baseNumYTiles;
    }
    
    
    
    
    
    public void zoomIn(){
        if(zoomOutModifier > 1)
            zoomOutModifier--;
    }
    
    public void zoomOut(){
        if(zoomOutModifier < 4)
            zoomOutModifier++;
    }
    
    void updatePosition(int changeDisplayX, int changeDisplayY){
        
        // will give us change in terms of display values
        // display values adapt in terms of map. this depends on zoomRatio
        // game is made of map tiles.
        
        
    }
}

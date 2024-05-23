package unusedClasses;

import static unnamedRPG.UnnamedRPG.DISPLAY_SIZE;
import static unnamedRPG.UnnamedRPG.FRAME_CENTER;
import static unnamedRPG.UnnamedRPG.MAP_LENGTH;
import static unnamedRPG.UnnamedRPG.MAP_WIDTH;

/**
 *
 * @author seb
 */
public class CameraBackup {
    
    
    double displayWidth = DISPLAY_SIZE.width;
    double displayHeight = DISPLAY_SIZE.height;
    double aspectRatio = (displayWidth / displayHeight);
    
    // TOP LEFT CORNER
    public int mapX;
    public int mapY;
    public int mapStartX;
    public int mapStartY;
    public int mapEndX;
    public int mapEndY;
    
    public int displayX;
    public int displayY;
    public int displayStartX;
    public int displayStartY;
    public int displayEndX;
    public int displayEndY;
    public int zoomOutMax;
    
    int baseNumYTiles;

    public int zoomOutModifier ;
    
    public int frameCenterX = FRAME_CENTER[0];
    public int frameCenterY = FRAME_CENTER[1];

    int numXTiles;
    int numYTiles;
    int tileSize;
    
    public CameraBackup() {
        this.zoomOutModifier = 1;
        this.zoomOutMax = 8;
        this.baseNumYTiles = 10;
        
        this.mapStartX = 0;
        this.mapStartY = 0;
        this.displayStartX = 0;
        this.displayStartY = 0;
        
        
        this.mapX = MAP_WIDTH/2;
        this.mapY = MAP_LENGTH/2;
        
        this.displayX = mapX * tileSize;
        this.displayY = mapY * tileSize;
        
        this.mapEndX = mapStartX + numXTiles;
        this.mapEndY = mapStartY + numXTiles;
        this.displayEndX = displayStartX + numXTiles;
        this.displayEndY = displayStartY + numXTiles;
        fullRefresh();
    }
    
    
    private void updateNumberOfTiles(){
        
        numXTiles = (int) (baseNumYTiles * aspectRatio * zoomOutModifier);
        numYTiles = baseNumYTiles * zoomOutModifier;
        tileSize = (int) (displayHeight/numYTiles);
    }
    
    
    private void fullRefresh(){
        updateNumberOfTiles();
        refreshCoordinates();
    }
    
    private void refreshCoordinates(){
        
        
        System.out.println("("+ mapX + ", "+mapY+")");
        System.out.println("Tilesize " + tileSize);
        
        
        int boundCheck;
        int margin = 10;
        
        boundCheck = mapX - numXTiles/2;
        if ( boundCheck > 0){
            mapStartX = boundCheck;
            displayStartX = 0;
            
        }
        
        boundCheck = mapX + numXTiles/2;
        if (boundCheck < MAP_WIDTH ) {
            mapEndX = boundCheck + margin;
            displayEndX = numXTiles * tileSize;
        }
        
        boundCheck = mapY - numYTiles/2;
        if ( boundCheck > 0) {
            mapStartY = boundCheck;
            displayStartY = 0;
        }
        
        boundCheck = mapY + numYTiles/2;
        if (boundCheck < MAP_LENGTH) {
            mapEndY = boundCheck + margin;
            displayEndY = numYTiles * tileSize;
        }
    }
    
    
    
    public void zoomIn(){
        if(zoomOutModifier > 1){
            zoomOutModifier--;
            fullRefresh();
        }
    }
    
    public void zoomOut(){
        if(zoomOutModifier < zoomOutMax) {
            zoomOutModifier++;
            fullRefresh();
            
        }
    }
    
    void changePosition(int magnitude, char direction){
        
        // will give us change in terms of display values
        // display values adapt in terms of map. this depends on zoomRatio
        // game is made of map tiles.
        
        switch(direction){
            case('w'):
                this.mapY -= magnitude;
                refreshCoordinates();
                break;
            case('s'):
                this.mapY += magnitude;
                refreshCoordinates();
                break;
            case('a'):
                this.mapX -= magnitude;
                refreshCoordinates();
                break;
            case('d'):
                this.mapX += magnitude;
                refreshCoordinates();
                break;
        }
        
    }
}

package unnamedRPG.display.components;

import unnamedRPG.model.Map;
import static java.awt.Color.BLACK;
import java.awt.Graphics;
import javax.swing.JComponent;
import unnamedRPG.model.Tile;
import unnamedRPG.display.Limits;
import static unnamedRPG.UnnamedRPG.FRAME_HEIGHT;
import static unnamedRPG.UnnamedRPG.FRAME_WIDTH;

/**
 *
 * @author seb
 */
public class GameBoard extends JComponent {

    Map map;

    Limits boardDisplayLimits;

    Limits boardTileLimits;

    int tileSize;
    int baseTileSize = 16;

    int tileCountX;
    int tileCountY;
    int tileScale = 8;

    public GameBoard(Map map, Limits boardLimits) {
        this.map = map;
        this.boardDisplayLimits = boardLimits;
        
        tileCountX = boardDisplayLimits.lengthX/ (tileScale*baseTileSize);
        tileCountY = boardDisplayLimits.lengthY/ (tileScale*baseTileSize) + 1;
        
        this.boardTileLimits = new Limits(0, 0, tileCountX, tileCountY);

        this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        updateBoardScale(tileScale);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(BLACK);

        g.fillRect(boardDisplayLimits.startX, boardDisplayLimits.startY, boardDisplayLimits.lengthX, boardDisplayLimits.lengthY);

        for (int y = boardTileLimits.startY, displayY = boardDisplayLimits.startY; y < boardTileLimits.endY; y++, displayY += tileSize) {
            for (int x = boardTileLimits.startX, displayX = boardDisplayLimits.startX; x < boardTileLimits.endX; x++, displayX += tileSize) {
                map.tiles[x][y].paint(g, displayX, displayY, tileScale);
            }
        }
    }

    public void changeScale(int value) {
        tileScale += value;
        if (tileScale < 1) {
            tileScale = 1;
            System.out.println("Can't zoom out any further.");
        }
        updateBoardScale(tileScale);
    }

    void updateBoardScale(int tileScale) {
        tileSize = baseTileSize * tileScale;
        
        int newLengthX = boardDisplayLimits.lengthX / tileSize;
        int newLengthY = boardDisplayLimits.lengthX / tileSize;
        
        boardTileLimits.resizeLimits(newLengthX, newLengthY);
    }
    
    public void changePosition(char direction, int magnitude){
        
        switch (direction){
            case 'w':
                boardTileLimits.shiftDimension('y', -1);
                break;
            case 's':
                boardTileLimits.shiftDimension('y', 1);
                break;       
            case 'a':
                boardTileLimits.shiftDimension('x', -1);
                break;    
            case 'd':
                boardTileLimits.shiftDimension('x', 1);              
                break;               
        } 
    }

    // get it to return  absolute tileID
    public void handleClick(int pointerX, int pointerY) {
        System.out.println("Tilesize: " + tileSize);
        System.out.println("X: " + pointerX + " Y: " + pointerY);
        int tileX;
        int tileY;
        System.out.println("Scaling: " + tileScale);

        tileX = (pointerX) / tileSize;
        tileY = (pointerY) / tileSize;
        System.out.println("tileX: " + tileX + " tileY: " + tileY);

        Tile currentTile = map.tiles[boardTileLimits.startX + tileX][boardTileLimits.startY + tileY];
        if (currentTile.terrainType != 'ϒ') {
            currentTile.terrainType = 'ϒ';
        } else {
            currentTile.terrainType = '~';
        }
    }
}

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

    private  Map map;

    private Limits boardDisplayLimits;

    private Limits boardTileLimits;

    private int tileSize;
    private int baseTileSize = 16;

    private int tileCountX;
    private int tileCountY;
    private int tileScale = 8;
    
    private int zoomOutLimit = 4;
    private int zoomInLimit = 8;

    public GameBoard(Limits boardLimits) {
        this.map = new Map();
        this.boardDisplayLimits = boardLimits;
        
        tileCountX = boardDisplayLimits.getLengthX() / (tileScale*baseTileSize);
        tileCountY = boardDisplayLimits.getLengthY()/ (tileScale*baseTileSize) + 1;
        
        this.boardTileLimits = new Limits(0, 0, tileCountX, tileCountY);

        this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        updateBoardScale(tileScale);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(BLACK);

        g.fillRect(boardDisplayLimits.getStartX(), boardDisplayLimits.getStartY(), boardDisplayLimits.getLengthX(), boardDisplayLimits.getLengthY());

        for (int y = boardTileLimits.getStartY(), displayY = boardDisplayLimits.getStartY(); y < boardTileLimits.getEndY(); y++, displayY += tileSize) {
            for (int x = boardTileLimits.getStartX(), displayX = boardDisplayLimits.getStartX(); x < boardTileLimits.getEndX(); x++, displayX += tileSize) {
                map.tiles[x][y].paint(g, displayX, displayY, tileScale);
            }
        }
    }

    public Map getMap() {
        return map;
    }

    
    
    public void changeScale(int value) {
        tileScale += value;
        if (tileScale < zoomOutLimit) {
            tileScale = zoomOutLimit;
            System.out.println("Can't zoom out any further.");
        } else if (tileScale > zoomInLimit){
            tileScale = zoomInLimit;
            System.out.println("Can't zoom in any closer.");
        }
        updateBoardScale(tileScale);
    }

    void updateBoardScale(int tileScale) {
        tileSize = baseTileSize * tileScale;
        
        int newLengthX = boardDisplayLimits.getLengthX() / tileSize;
        int newLengthY = boardDisplayLimits.getLengthX() / tileSize;
        
        boardTileLimits.resizeLimits(newLengthX, newLengthY);
    }
    
    public void shiftPosition(char direction, int magnitude){        
        switch (direction){
            case 'w':
                boardTileLimits.shiftPosition('y', -1);
                break;
            case 's':
                boardTileLimits.shiftPosition('y', 1);
                break;       
            case 'a':
                boardTileLimits.shiftPosition('x', -1);
                break;    
            case 'd':
                boardTileLimits.shiftPosition('x', 1);              
                break;               
        } 
    }
    
    public void goTo (int centerX, int centerY){
        boardTileLimits.goTo(centerX, centerY);
    }

    public void handleClick(int pointerX, int pointerY) {
        int tileX;
        int tileY;
        tileX = (pointerX) / tileSize;
        tileY = (pointerY) / tileSize;

        Tile currentTile = map.tiles[boardTileLimits.getStartX() + tileX][boardTileLimits.getStartY() + tileY];
        if (currentTile.terrainType != 'ϒ') {
            currentTile.terrainType = 'ϒ';
        } else {
            currentTile.terrainType = '~';
        }
    }
    public int[] getTrueXY(int pointerX, int pointerY) {
        int tileX;
        int tileY;
        tileX = (pointerX) / tileSize;
        tileY = (pointerY) / tileSize;
        return new int[]{boardTileLimits.getStartX() + tileX, boardTileLimits.getStartY() + tileY};
    }
}

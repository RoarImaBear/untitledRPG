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
    int scaling = 8;

    public GameBoard(Map map, Limits boardLimits) {
        this.map = map;
        this.boardDisplayLimits = boardLimits;
        this.boardTileLimits = new Limits(0, 0, 0, 0);

        this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        updateBoardTileLimits(scaling);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(BLACK);

        g.fillRect(boardDisplayLimits.startX, boardDisplayLimits.startY, boardDisplayLimits.lengthX, boardDisplayLimits.lengthY);

        for (int y = boardTileLimits.startY, displayY = boardDisplayLimits.startY; y < boardTileLimits.lengthY; y++, displayY += tileSize) {
            for (int x = boardTileLimits.startX, displayX = boardDisplayLimits.startX; x < boardTileLimits.lengthX; x++, displayX += tileSize) {
                map.tiles[x][y].paint(g, displayX, displayY, scaling);
            }
        }
    }

    public void updateScaling(int value) {
        scaling += value;
        if (scaling < 1) {
            scaling = 1;
            System.out.println("Can't zoom out any further.");
        }

        updateBoardTileLimits(scaling);
    }

    void updateBoardTileLimits(int scaling) {
        tileSize = baseTileSize * scaling;

        boardTileLimits.lengthX = boardDisplayLimits.lengthX / tileSize + 1;
        boardTileLimits.lengthY = boardDisplayLimits.lengthY / tileSize + 1;
    }

    public void handleClick(int pointerX, int pointerY) {
        System.out.println("Tilesize: " + tileSize);
        System.out.println("X: " + pointerX + " Y: " + pointerY);
        int tileX;
        int tileY;
        System.out.println("Scaling: " + scaling);

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

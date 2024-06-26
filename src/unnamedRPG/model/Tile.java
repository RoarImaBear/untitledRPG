package unnamedRPG.model;

import java.awt.Graphics;
import unnamedRPG.model.entities.Entity;
import static unnamedRPG.UnnamedRPG.DECORATOR;

/**
 *
 * @author seb
 */
public class Tile {

    // Left public as it's accessed frequently to render
    public char terrainType;
    public int baseTileSize = 16;
    public boolean occupied;
    public Entity occupant;

    public Tile() {
    }

    public void paint(Graphics g, int startX, int startY, int tileScale) {
        g.setColor(DECORATOR.colorSwitch(terrainType));
        g.fillRect(startX, startY, ((baseTileSize - 1) * tileScale), ((baseTileSize - 1) * tileScale));

        if (occupied) {
            paintOccupant(g, startX, startY, tileScale);
        }
    }
    
    
    
    private void paintOccupant(Graphics g, int startX, int startY, int tileScale){
            int offset = tileScale * 2;
            int auraOffset = tileScale * 1;
            g.setColor(occupant.auraColor);
            g.fillOval(startX + auraOffset, startY + auraOffset, ((baseTileSize - 3) * tileScale), ((baseTileSize - 3) * tileScale));
            g.drawImage(occupant.token, startX + offset, startY + offset, ((baseTileSize - 5) * tileScale), ((baseTileSize - 5) * tileScale), null);
    }

}

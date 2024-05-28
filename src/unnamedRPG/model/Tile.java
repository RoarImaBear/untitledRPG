/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.model;

import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static java.awt.Color.YELLOW;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;
import unnamedRPG.model.entities.Entity;
import unnamedRPG.model.entities.Player;
import static unnamedRPG.UnnamedRPG.DECORATOR;
import static unnamedRPG.UnnamedRPG.RANDOM;

/**
 *
 * @author seb
 */
public class Tile {

    public char terrainType;

    int altitude;
    int baseTileSize = 16;
    boolean containsEntity;
    Entity occupant;

    public Tile() {
//        this.containsEntity = RANDOM.nextBoolean();
//        this.occupant = new Player();
    }

    public void paint(Graphics g, int startX, int startY, int tileScale) {
        g.setColor(DECORATOR.colorSwitch(terrainType));
        g.fillRect(startX, startY, ((baseTileSize - 1) * tileScale), ((baseTileSize - 1) * tileScale));

        if (containsEntity) {
            paintOccupant(g, startX, startY, tileScale);
        }

    }
    
    private void paintOccupant(Graphics g, int startX, int startY, int tileScale){
            int offset = tileScale * 2;
            int auraOffset = tileScale * 1;
            g.setColor(DECORATOR.colorSwitch('p'));
            g.fillOval(startX + auraOffset, startY + auraOffset, ((baseTileSize - 3) * tileScale), ((baseTileSize - 3) * tileScale));
            g.drawImage(occupant.token, startX + offset, startY + offset, ((baseTileSize - 5) * tileScale), ((baseTileSize - 5) * tileScale), null);
    }

}

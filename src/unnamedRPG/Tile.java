/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG;

import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;
import static unnamedRPG.UnnamedRPG.decorator;
import static unnamedRPG.UnnamedRPG.random;

/**
 *
 * @author seb
 */
public class Tile {

    public char terrainType;

    int altitude;
    int baseTileSize = 16;

    public Tile() {
        
    }
    

    public void paint(Graphics g, int startX, int startY, int scaling) {

        g.setColor(decorator.colorSwitch(terrainType));

        g.fillRect(startX, startY, (baseTileSize * scaling - 1), (baseTileSize * scaling - 1));

    }



}

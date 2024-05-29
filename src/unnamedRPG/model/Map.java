/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.model;

import static unnamedRPG.UnnamedRPG.MAP_LENGTH;
import static unnamedRPG.UnnamedRPG.MAP_WIDTH;
import unnamedRPG.model.entities.Entity;

/**
 *
 * @author seb
 */
public class Map {

    int width, length;

    public int[][] topography; // 0 - 4, depending on difficulty
    public Tile[][] tiles;
    public Entity[][] entities;
    private FloraGod floraGod;
    private FaunaGod faunaGod;


    
    public Map() {

        this.width = MAP_WIDTH;
        this.length = MAP_LENGTH;
        this.topography = new int[width][length];
        this.tiles = new Tile[width][length];
        this.entities = new Entity[width][length];
        this.floraGod = new FloraGod(width, length);
        this.faunaGod = new FaunaGod(width, length);
        
        
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = new Tile();
            }
        }
        floraGod.floraSpawn(tiles);
        faunaGod.spawnEnemies(tiles);
    }
    
    public void insertEntity(Entity entity, int x, int y) {
        tiles[x][y].occupant = entity;
        tiles[x][y].occupied = true;
        entities[x][y] = entity;
    }
    
}

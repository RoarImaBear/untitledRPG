/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.model;

import static unnamedRPG.UnnamedRPG.RANDOM;
import unnamedRPG.model.entities.Entity;
import unnamedRPG.model.entities.Ghoul;

/**
 *
 * @author sdyma
 */
public class FaunaGod {
    
    private final Entity[][] entitiesMap;
    private final int mapWidth;
    private final int mapLength;
    
    public FaunaGod (int mapWidth, int mapLength, Entity[][] entitiesMap) {
        this.entitiesMap = entitiesMap;
        this.mapWidth = mapWidth;
        this.mapLength = mapLength;
    }
    
    public void spawnEnemies(Tile[][] tiles){
        for (int y = 0; y < mapLength-10; y += RANDOM.nextInt(10)) {
            for (int x = 0; x < mapWidth-10; x += RANDOM.nextInt(10)) {
                Entity ghoul = new Ghoul("");
                ghoul.currentXY[0] = x;
                ghoul.currentXY[1] = y;
                entitiesMap[x][y] = ghoul;
                tiles[x][y].occupant = new Ghoul("");
                tiles[x][y].occupied = true;
                
            }
        }
        
        if(RANDOM.nextInt(10)%10 == 0){
            
        }
        
    }
    
}

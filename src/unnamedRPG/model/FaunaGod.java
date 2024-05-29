/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.model;

import static unnamedRPG.UnnamedRPG.RANDOM;
import unnamedRPG.model.entities.Ghoul;

/**
 *
 * @author sdyma
 */
public class FaunaGod {
    
    int mapWidth;
    int mapLength;
    
    public FaunaGod (int mapWidth, int mapLength) {
        this.mapWidth = mapWidth;
        this.mapLength = mapLength;
    }
    
    public void spawnEnemies(Tile[][] tiles){
        for (int y = 0; y < mapLength; y += RANDOM.nextInt(10)) {
            for (int x = 0; x < mapWidth; x += RANDOM.nextInt(10)) {
                tiles[x][y].occupant = new Ghoul("");
                tiles[x][y].occupied = true;
            }
        }
        
        if(RANDOM.nextInt(10)%10 == 0){
            
        }
        
    }
    
}

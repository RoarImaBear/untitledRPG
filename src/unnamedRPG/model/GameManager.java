/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.model;

import unnamedRPG.controller.ControlUnit;
import unnamedRPG.model.entities.Player;

/**
 *
 * @author sdyma
 */
public class GameManager {

    Player player;
    Map map;
    ControlUnit controlUnit;
    
    
    
    public GameManager( Player player, Map map, ControlUnit controlUnit) {
        this.controlUnit = controlUnit;
        this.map = map;
        this.player = player;
        spawnPlayer(player);
    }
    
    
    public void spawnPlayer(Player player){
       map.insertEntity(player, 206, 203);
       controlUnit.mapGoTo(200, 200);
    }
    
    // Insert Player Method
    
    
}

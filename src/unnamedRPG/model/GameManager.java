/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.model;

import java.awt.event.ActionEvent;
import javax.swing.Timer;
import unnamedRPG.controller.ControlUnit;
import unnamedRPG.display.Display;
import unnamedRPG.display.components.GameBoard;
import unnamedRPG.model.entities.Entity;
import unnamedRPG.model.entities.Player;

/**
 *
 * @author sdyma
 */
public class GameManager implements Runnable {

    Timer gameClock;
    int clockCounter;
    int gamePace = 60;

    public Player player;
    public GameBoard gameBoard;
    Map map;
    Display display;

    public GameManager(Player player, GameBoard gameBoard, Display display) {
        this.player = player;
        this.gameBoard = gameBoard;
        this.map = gameBoard.map;
        this.display = display;
    }

    @Override
    public void run() {
        clockCounter = 0;
        gameClock = new Timer(1000 / 60, (ActionEvent e) -> {
            handleEntities();
            clockCounter++;
        });
        gameClock.start();
    }
    
    public void handleEntities() {
        if (clockCounter%gamePace == 0){
            player.staminaRegen();
        }
        
    }
    
    public void spawnPlayer(Player player, GameBoard gameBoard) {
        int x = 200;
        int y = 200;
        map.insertEntity(player, x, y);
        gameBoard.goTo(x - 6, y - 3);
        player.currentXY[0] = x;
        player.currentXY[1] = y;
        display.appendConsole("Player spawned.\n");
    }


    public void handleClick(int displayX, int displayY) {
        int[] trueXY;
        trueXY = gameBoard.getTrueXY(displayX, displayY);
        System.out.println("TrueXY: " + trueXY[0] + " " + trueXY[1]);
        System.out.println("currentXY: " + player.currentXY[0] + " " + player.currentXY[1]);
        if (trueXY[0] == player.currentXY[0] && trueXY[1] == player.currentXY[1]) {
            display.appendConsole("This is you. Never cold. Never alone.\n");
        } else {
            handleTile(trueXY[0], trueXY[1]);
        }
    }


    private void handleTile(int x, int y) {
        Tile currentTile = map.tiles[x][y];
        if (!currentTile.containsEntity) {
            moveEntity(player, x, y);
        }
    }

    private void moveEntity(Entity entity, int targetX, int targetY) {
        int entityX = entity.currentXY[0];
        int entityY = entity.currentXY[1];
        int checkX = targetX - entityX;
        int checkY = targetY - entityY;
        int staminaCostMultiplier = 1;
        // Check if adjecent
        if (checkX < -1 || checkX > 1 || checkY < -1 || checkY > 1) {
            display.appendConsole("Your stride's too wide.\nOne tile at a time\n");
            return;
        }
        Tile targetTile = map.tiles[targetX][targetY];
        Tile entityTile = map.tiles[entityX][entityY];
        if(targetTile.terrainType == 'ϒ' || targetTile.terrainType == '|'){
            display.appendConsole("Mortal flesh has its limitations.\nYou cannot walk through that.\n");
            return;
        }
        if(targetTile.terrainType =='~'){
            staminaCostMultiplier = 2;
            display.appendConsole("Water slows you.\n");
        }
        // Stamina checks
        if (checkX != 0 && checkY != 0){
            if (entity.currentStamina >= 7*staminaCostMultiplier){
            entity.currentStamina -= 7*staminaCostMultiplier;                
            } else{
                display.appendConsole("You're too tired for that.\n");
                return;
            }
        } else {
            if (entity.currentStamina >= 5*staminaCostMultiplier){
            entity.currentStamina -= 5*staminaCostMultiplier;                
            } else{
                display.appendConsole("You're too tired for that.\n");
                return;
            }
        }
        // Check if terrain is passable
        map.tiles[entityX][entityY].occupant = null;
        map.tiles[entityX][entityY].containsEntity = false;
        map.tiles[targetX][targetY].occupant = entity;
        map.tiles[targetX][targetY].containsEntity = true;
        entity.currentXY[0] = targetX;
        entity.currentXY[1] = targetY;
        // Deduct stamina
    }

}


//
//    public void handleKeyboardMove(boolean[] keyComboWSAD) {
//        int inputCount = 0;
//        for (int i = 0; i < keyComboWSAD.length; i++) {
//            if (keyComboWSAD[i])
//                inputCount++;
//        }
//
//        if(inputCount == 1){
//            if(keyComboWSAD[0]){
//                //MOVE UP
//            }
//            if(keyComboWSAD[1]){
//                // MOVE DOWN
//            }
//            if(keyComboWSAD[2]){
//                //MOVE LEFT
//            }
//            if(keyComboWSAD[3]){
//                // MOVE RIGHT
//            }
//        }
//        
//        if(inputCount == 1){
//            if(keyComboWSAD[0]){
//                //MOVE UP
//            }
//            if(keyComboWSAD[1]){
//                // MOVE DOWN
//            }
//            if(keyComboWSAD[2]){
//                //MOVE LEFT
//            }
//            if(keyComboWSAD[3]){
//                // MOVE RIGHT
//            }
//        }
//    }
package unnamedRPG.model;

import java.awt.event.ActionEvent;
import javax.swing.Timer;
import static unnamedRPG.UnnamedRPG.RANDOM;
import unnamedRPG.display.Display;
import unnamedRPG.display.components.GameBoard;
import unnamedRPG.model.entities.Entity;
import unnamedRPG.model.entities.Player;

/**
 *
 * @author sdyma
 */
public class GameMaster implements Runnable {

    Timer gameClock;
    int clockCounter;
    int gamePace = 60;
    char[] xy = {'x','y'};
    int[] plusMinusOne = {1, -1};

    public Player player;
    public GameBoard gameBoard;
    Map map;
    Display display;
    
    Arena arena;

    public GameMaster(Player player, GameBoard gameBoard, Display display) {
        this.player = player;
        this.gameBoard = gameBoard;
        this.map = gameBoard.map;
        this.display = display;
        
        this.arena = new Arena(display);
        arena.run();
    }

    @Override
    public void run() {
        clockCounter = 0;
        gameClock = new Timer(1000 / 60, (ActionEvent e) -> {
            if(clockCounter%gamePace == 0){
                gameTick();
            }
            entitiesMove(player);
            clockCounter++;
        });

        gameClock.start();
    }
    
    public void gameTick() {        
        int startX = player.currentXY[0] - 30;
        int endX = player.currentXY[0] + 20;
        int startY = player.currentXY[1] - 30;
        int endY = player.currentXY[1] + 20;
        for (int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                if(map.entitiesMap[x][y] != null){   
                    map.entitiesMap[x][y].staminaRegen();
                }
            }
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
    
    private void entitiesMove(Player player){
        int startX = player.currentXY[0]-30;
        int endX = player.currentXY[0]+20;
        int startY = player.currentXY[1]-30;
        int endY = player.currentXY[1] + 20;
        for (int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                if(map.entitiesMap[x][y] != null && !map.entitiesMap[x][y].inCombat && map.entitiesMap[x][y] != player && !map.entitiesMap[x][y].dead){
                    if(RANDOM.nextInt(150)%150 == 0){
                        requestMoveEntity(map.entitiesMap[x][y], xy[RANDOM.nextInt(2)], plusMinusOne[RANDOM.nextInt(2)]);  
                    }       
                    map.entitiesMap[x][y].staminaRegen();
                }
            }
        }
    }
    
    private void enterCombat (Entity attacker, Entity defender){  
        Entity[]pairing = {attacker, defender};
        arena.addCombatants(pairing);
    }

    public void handleClick(int displayX, int displayY) {
        int[] trueXY;
        trueXY = gameBoard.getTrueXY(displayX, displayY);
        if (trueXY[0] == player.currentXY[0] && trueXY[1] == player.currentXY[1]) {
            display.appendConsole("This is you. Never cold. Never alone.\n");
        } else {
            handleTile(trueXY[0], trueXY[1]);
        }
    }


    private void handleTile(int x, int y) {
        Tile targetTile = map.tiles[x][y];
        if (!targetTile.occupied) {
            moveEntity(player, x, y);
        } else {
            enterCombat (player, targetTile.occupant);
        }
    }
    
    public void requestMoveEntity(Entity entity, char axis, int magnitude) {
        int entityX = entity.currentXY[0];
        int entityY = entity.currentXY[1];
        
        int targetX = entityX;
        int targetY = entityY;
        
                // Check if in bounds
        if (targetX < 0 || targetX >= map.width || targetY < 0 || targetY >= map.length){
            return;
        }
        
        switch(axis){
            case('x'):
                targetX += magnitude;
                break;
            case('y'):
                targetY += magnitude;
                break;
        }
        Tile targetTile = map.tiles[targetX][targetY];
        if (targetTile.occupied){
            enterCombat (entity, targetTile.occupant);
        } else {
        moveEntity(entity, targetX, targetY);            
        }
    }
    
    private void moveEntity(Entity entity, int targetX, int targetY){
        int entityX = entity.currentXY[0];
        int entityY = entity.currentXY[1];  
        int checkX = targetX - entityX;
        int checkY = targetY - entityY;
        int staminaCostMultiplier = 1;
        
        boolean playerCheck = entity instanceof Player;
        
        Tile targetTile = map.tiles[targetX][targetY];
        Tile entityTile = map.tiles[entityX][entityY];
        
        // Check if adjecent
        if (checkX < -1 || checkX > 1 || checkY < -1 || checkY > 1) {
            if (playerCheck) 
                display.appendConsole("Your stride's too wide.\nOne tile at a time\n");
            return;
        }
        
        
        if(targetTile.terrainType == 'ϒ' || targetTile.terrainType == '|'){
            if (playerCheck) 
                display.appendConsole("Mortal flesh has its limitations.\nYou cannot walk through that.\n");
            return;
        }
        if(targetTile.terrainType =='~'){
            staminaCostMultiplier = 2;
            if (playerCheck) 
                display.appendConsole("Water slows you.\n");
        }
        // Stamina checks
        if (checkX != 0 && checkY != 0){
            if (entity.currentStamina >= 7*staminaCostMultiplier){
            entity.currentStamina -= 7*staminaCostMultiplier;                
            } else{
                if (playerCheck) 
                    display.appendConsole("You're too tired for that.\n");
                return;
            }
        } else {
            if (entity.currentStamina >= 5*staminaCostMultiplier){
            entity.currentStamina -= 5*staminaCostMultiplier;                
            } else{
                if (playerCheck) 
                    display.appendConsole("You're too tired for that.\n");
                return;
            }
        }
        entityTile.occupant = null;
        entityTile.occupied = false;
        targetTile.occupant = entity;
        targetTile.occupied = true;
        entity.currentXY[0] = targetX;
        entity.currentXY[1] = targetY;
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
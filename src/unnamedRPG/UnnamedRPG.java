package unnamedRPG;

import unnamedRPG.model.Map;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import unnamedRPG.controller.ControlUnit;
import unnamedRPG.display.Display;
import unnamedRPG.display.Limits;
import unnamedRPG.display.components.GameBoard;
import unnamedRPG.model.GameMaster;
import unnamedRPG.model.entities.Player;
import unnamedRPG.utilities.Decorator;
import unnamedRPG.utilities.ImageAssets;

/**
 *
 * @author seb
 * 
 * 
 */
public class UnnamedRPG {
    
    public int[] PLAYER_POSITION = new int [2];
    
    public static Dimension DISPLAY_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    
    public static Random RANDOM = new Random();
    public static Decorator DECORATOR = new Decorator();
    
    
    public static final int MAP_WIDTH = 1440;
    public static final int MAP_LENGTH = 900;
    
    public static final int FRAME_WIDTH = DISPLAY_SIZE.width;
    public static final int FRAME_HEIGHT = DISPLAY_SIZE.height;
    public static final int[] FRAME_CENTER = {FRAME_WIDTH/2, FRAME_HEIGHT/2};
    public static final int UI_HEIGHT = 256;
    
    
    public static ImageAssets IMAGE_ASSETS;
   


    public static void main(String[] args) {
        IMAGE_ASSETS = new ImageAssets();
        
        Limits boardLimits = new Limits(0, 0, FRAME_WIDTH, FRAME_HEIGHT - UI_HEIGHT);
        Limits frameLimits = new Limits(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        GameBoard gameBoard = new GameBoard(boardLimits);
        Player player = new Player("Creature");
        
        ControlUnit controlUnit = new ControlUnit(gameBoard, boardLimits, frameLimits);    
        Display display = new Display(player, controlUnit, gameBoard, boardLimits, frameLimits);   
        GameMaster gameManager = new GameMaster( player, gameBoard, display);
        
        controlUnit.connectGameManager(gameManager);
        controlUnit.connectDisplay(display);

        
        Thread displayThread = new Thread(display);
        Thread gameManagerThread = new Thread(gameManager);
        displayThread.start();
        gameManagerThread.start();
        
        gameManager.spawnPlayer(player, gameBoard);
        
        System.out.println("Display: " + DISPLAY_SIZE.height + "x" + DISPLAY_SIZE.width);
    }

}


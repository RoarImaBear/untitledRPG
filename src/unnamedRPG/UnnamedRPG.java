package unnamedRPG;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Random;
import unnamedRPG.controller.ControlUnit;
import unnamedRPG.display.Display;
import unnamedRPG.display.Limits;
import unnamedRPG.display.components.GameBoard;
import unnamedRPG.loginModule.LoginViewer;
import unnamedRPG.loginModule.LoginManager;
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
    
    public static Dimension DISPLAY_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    
    public static Random RANDOM = new Random();
    public static Decorator DECORATOR = new Decorator();
    public static ImageAssets IMAGE_ASSETS = new ImageAssets();   
    
    public static final int MAP_WIDTH = 1440;
    public static final int MAP_LENGTH = 900;
    
    public static final int FRAME_WIDTH = DISPLAY_SIZE.width;
    public static final int FRAME_HEIGHT = DISPLAY_SIZE.height;
    public static final int UI_HEIGHT = 256;
    public static DBManager DATABASE;

    public static void main(String[] args) throws SQLException {
        // Instantiate DB
        DATABASE = new DBManager();
        System.out.println("Connection: " + DATABASE.getConnection());

        LoginManager loginManager = new LoginManager();        
        loginManager.login();
        Player player = DATABASE.getPlayerChar();

        Limits boardLimits = new Limits(0, 0, FRAME_WIDTH, FRAME_HEIGHT - UI_HEIGHT);
        Limits frameLimits = new Limits(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        GameBoard gameBoard = new GameBoard(boardLimits);
        
        ControlUnit controlUnit = new ControlUnit(gameBoard, boardLimits);    
        Display display = new Display(player, controlUnit, gameBoard, boardLimits, frameLimits);   
        GameMaster gameMaster = new GameMaster( player, gameBoard, display);
        
        controlUnit.connectGameMaster(gameMaster);
 
        Thread displayThread = new Thread(display);
        Thread gameManagerThread = new Thread(gameMaster);
        displayThread.start();
        gameManagerThread.start();
        
        gameMaster.spawnPlayer(player, gameBoard);
    }

}


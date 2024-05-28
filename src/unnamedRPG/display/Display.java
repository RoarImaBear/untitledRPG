package unnamedRPG.display;

import unnamedRPG.controller.ControlUnit;
import unnamedRPG.display.panes.UIPane;
import unnamedRPG.display.components.GameBoard;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.Timer;
import unnamedRPG.model.Map;
import static unnamedRPG.UnnamedRPG.DISPLAY_SIZE;
import static unnamedRPG.UnnamedRPG.FRAME_HEIGHT;
import static unnamedRPG.UnnamedRPG.FRAME_WIDTH;
import unnamedRPG.model.entities.Player;

/**
 *
 * @author seb
 */

// Add fog of war -- discovered [][]


public class Display implements Runnable {
    Map map;
    UIPane UIPane;
    GameBoard gameBoard;
    
    JFrame frame;
    
    Timer displayClock;
    ControlUnit controlUnit;
    Limits boardLimits;
    Limits frameLimits;
    
    
    public Display(Player player, Map map, Limits boardLimits, Limits frameLimits, ControlUnit controlUnit){
        this.map = map;
        
        this.boardLimits = boardLimits;
        this.frameLimits = frameLimits;
        
        this.frame = new JFrame("Game");
        this.frame.setSize(frameLimits.lengthX, frameLimits.lengthY);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.UIPane = new UIPane(player, boardLimits, frameLimits);
        this.frame.add(UIPane);
        
        this.gameBoard = new GameBoard(map, boardLimits);
        this.frame.add(gameBoard);
        
        this.controlUnit = controlUnit;
        this.controlUnit.connectToGameBoard(gameBoard);
        this.frame.addKeyListener(controlUnit);
        this.frame.addComponentListener(controlUnit);
        this.frame.addMouseListener(controlUnit);
        this.frame.addMouseWheelListener(controlUnit);
    }
    
    @Override
    public void run() {
        this.frame.requestFocus();
        displayClock = new Timer(1000/10, (ActionEvent e) -> {
            this.frame.requestFocus();
            UIPane.refresh();
            gameBoard.repaint();
        });
        displayClock.start();
    }  
}

//    void updateBoardLimits(){
//        
//    }
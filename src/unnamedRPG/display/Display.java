package unnamedRPG.display;

import unnamedRPG.display.panes.UIPane;
import unnamedRPG.display.components.GameBoard;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.Timer;
import unnamedRPG.Map;
import static unnamedRPG.UnnamedRPG.DISPLAY_SIZE;
import static unnamedRPG.UnnamedRPG.FRAME_HEIGHT;
import static unnamedRPG.UnnamedRPG.FRAME_WIDTH;

/**
 *
 * @author seb
 */

// Add fog of war -- discovered [][]


public class Display implements Runnable {
    Map map;
    //MainPane mainPane;
    UIPane UIPane;
    GameBoard gameBoard;
    
    JFrame frame;
    
    Timer displayClock;
    
    Camera camera;
    ControlUnit controlUnit;
    final int frameWidth = DISPLAY_SIZE.width;
    final int frameHeight = DISPLAY_SIZE.height;
    final int[] frameCenter = {FRAME_WIDTH/2, FRAME_HEIGHT/2};
    
    Limits boardLimits;
    Limits frameLimits;
    
    
    public Display(Map map){
        this.map = map;
        
        this.boardLimits = new Limits(0, 0, frameWidth, frameHeight-200);
        this.frameLimits = new Limits(0, 0, frameWidth, frameHeight);
        
        this.frame = new JFrame("Game");
        this.frame.setSize(frameWidth, frameHeight);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.camera = new Camera();
        
        this.UIPane = new UIPane(map, camera, boardLimits, frameLimits);
        this.frame.add(UIPane);
        
        this.gameBoard = new GameBoard(map, camera, boardLimits);
        this.frame.add(gameBoard);
        
        this.controlUnit = new ControlUnit(camera, gameBoard);
        this.frame.addKeyListener(controlUnit);
        this.frame.addComponentListener(controlUnit);
        this.frame.addMouseListener(controlUnit);

    }
    
    
    
    @Override
    public void run() {
        this.frame.requestFocus();
        displayClock = new Timer(1000/6, (ActionEvent e) -> {
            this.frame.requestFocus();
            UIPane.refresh();
            gameBoard.repaint();
        });
        displayClock.start();
    }
    
    
    
    void updateBoardLimits(){
        
    }
    
    
}

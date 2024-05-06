package unnamedRPG.display;

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
    UIPane userInterface;
    GameBoardComponent gameBoard;
    
    JFrame frame;
    
    Timer displayClock;
    
    Camera camera;
    ControlUnit controlUnit;
    int[][] boardXYLimits;
    int[][] frameXYLimits;
    
    final int frameWidth = DISPLAY_SIZE.width;
    final int frameHeight = DISPLAY_SIZE.height;
    final int[] frameCenter = {FRAME_WIDTH/2, FRAME_HEIGHT/2};
    
    
    public Display(Map map){
        this.map = map;
        this.boardXYLimits = new int[][] {{5, frameWidth-10}, {5, frameHeight-200}};
        this.frameXYLimits = new int[][] {{0, frameWidth}, {0, frameHeight}};
        
        this.frame = new JFrame("Game");
        this.frame.setSize(frameWidth, frameHeight);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.camera = new Camera();
        this.controlUnit = new ControlUnit(camera);
        
        this.userInterface = new UIPane(map, camera, boardXYLimits, frameXYLimits);
        this.frame.add(userInterface);
        
        this.gameBoard = new GameBoardComponent(map, camera, boardXYLimits);
        this.frame.add(gameBoard);
        
        this.frame.addKeyListener(controlUnit);
        this.frame.addComponentListener(controlUnit);
        this.frame.addMouseListener(controlUnit);

    }
    
    
    
    @Override
    public void run() {
        this.frame.requestFocus();
        displayClock = new Timer(1000/60, (ActionEvent e) -> {
            userInterface.refresh();
            gameBoard.repaint();
        });
        displayClock.start();
    }
    
    
    
    
}

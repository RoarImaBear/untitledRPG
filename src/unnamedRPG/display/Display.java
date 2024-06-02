package unnamedRPG.display;

import unnamedRPG.controller.ControlUnit;
import unnamedRPG.display.components.GameBoard;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.Timer;
import unnamedRPG.model.entities.Player;

/**
 *
 * @author seb
 */

// Add fog of war -- discovered [][]


public class Display implements Runnable {
    
    private Timer displayClock;
    
    private JFrame frame;
    private UIPane UIPane;
    private GameBoard gameBoard;
    private ControlUnit controlUnit;
    private Limits boardLimits;
    private Limits frameLimits;
    
    public int frameCounter = 0;

    public Display(Player player, ControlUnit controlUnit, GameBoard gameBoard, Limits boardLimits, Limits frameLimits){
        this.boardLimits = boardLimits;
        this.frameLimits = frameLimits;
        this.controlUnit = controlUnit;
        
        this.frame = new JFrame("Game");
        this.frame.setSize(frameLimits.getLengthX(), frameLimits.getLengthY());
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.UIPane = new UIPane(player, boardLimits, frameLimits);
        this.frame.add(UIPane);
        
        this.gameBoard = gameBoard;
        
        this.frame.add(gameBoard);
        this.frame.addKeyListener(controlUnit);
        this.frame.addComponentListener(controlUnit);
        this.frame.addMouseListener(controlUnit);
        this.frame.addMouseWheelListener(controlUnit);
        this.frame.addMouseMotionListener(controlUnit);
    }
    
    @Override
    public void run() {
        this.frame.requestFocus();
        displayClock = new Timer(1000/10, (ActionEvent e) -> {
            this.frame.requestFocus();
            UIPane.refresh();
            gameBoard.repaint();
            frameCounter++;
        });
        displayClock.start();
    }
    
    public void appendConsole(String text){
        UIPane.appendConsole(text);
    }
    
}

package unnamedRPG.display;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.Timer;
import unnamedRPG.Map;
import static unnamedRPG.UnnamedRPG.FRAME_HEIGHT;
import static unnamedRPG.UnnamedRPG.FRAME_WIDTH;

/**
 *
 * @author seb
 */

// Add fog of war -- discovered [][]


public class Display implements Runnable {
    Map map;
    MainPane mainPane;
    JFrame frame;
    
    Timer displayClock;
    
    Camera camera;
    ControlUnit controlUnit;
    
    
    public Display(Map map){
        this.map = map;
        this.frame = new JFrame("Battle Simulator");
        this.frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.camera = new Camera();
        this.controlUnit = new ControlUnit(camera);
        
        this.mainPane = new MainPane(frame, map, camera);
        this.frame.add(mainPane);
        
        this.frame.addKeyListener(controlUnit);
        this.frame.addComponentListener(controlUnit);
        this.frame.addMouseListener(controlUnit);

    }
    

    @Override
    public void run() {
        
        displayClock = new Timer(1000/60, (ActionEvent e) -> {
            mainPane.refresh();
        });
        displayClock.start();
    }
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import unnamedRPG.Map;
import static unnamedRPG.UnnamedRPG.FRAME_HEIGHT;
import static unnamedRPG.UnnamedRPG.FRAME_WIDTH;

/**
 *
 * @author seb
 */
public class Display implements Runnable {
    Map map;
    BackgroundLayer background;
    JFrame frame;
    
    Timer displayClock;
    
    Camera camera;
    
    
    public Display(Map map){
        this.map = map;
        this.frame = new JFrame("Battle Simulator");
        this.frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.camera = new Camera();
        
        this.background = new BackgroundLayer(frame, map, camera);
        this.frame.add(background);
        
        
    }
    

    @Override
    public void run() {
        
        displayClock = new Timer(1000/60, (ActionEvent e) -> {
            
            
            
            
            background.refresh();
        });
        displayClock.start();
    }
    
    
    
    
}

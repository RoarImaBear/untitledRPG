package unnamedRPG.display;

import static com.sun.java.accessibility.util.AWTEventMonitor.addComponentListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static unnamedRPG.UnnamedRPG.FRAME_CENTER;

/**
 *
 * @author seb
 */
public class ControlUnit implements KeyListener, ComponentListener, MouseListener{

    
    Camera camera;
    
    public ControlUnit(Camera camera) {
        this.camera = camera;
        
        addKeyListener(this);
        addComponentListener(this);
        addMouseListener(this);
        
    }
    
    
    
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
//        int cameraSpeed = 1;
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.out.println("esc");
            System.exit(0);
        }
//        if (ke.getKeyCode() == KeyEvent.VK_PERIOD) {
//            camera.zoomIn();
//            System.out.println("Zoom In");
//        }
//        if (ke.getKeyCode() == KeyEvent.VK_COMMA) {
//            camera.zoomOut();
//            System.out.println("Zoom Out");
//        }
//        if (ke.getKeyCode() == KeyEvent.VK_UP) {
//            camera.changePosition(cameraSpeed, 'w');
//            System.out.println("UP");
//        }
//        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
//            camera.changePosition(cameraSpeed, 's');
//            System.out.println("DOWN");
//        }
//        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
//            camera.changePosition(cameraSpeed, 'a');
//            System.out.println("LEFT");
//        }
//        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
//            camera.changePosition(cameraSpeed, 'd');
//            System.out.println("RIGHT");
//        }
//        
//        
//        

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    @Override
    public void componentResized(ComponentEvent ce) {
    }

    @Override
    public void componentMoved(ComponentEvent ce) {

    }

    @Override
    public void componentShown(ComponentEvent ce) {

    }

    @Override
    public void componentHidden(ComponentEvent ce) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        int mouseX = e.getX();
        int mouseY = e.getY();
        int centerX = FRAME_CENTER[0];
        int centerY = FRAME_CENTER[1];
        
        int changeX = mouseX - centerX;
        int changeY = mouseY - centerY;
        
        
        
        
        System.out.println("MousePosition: " + changeX + " " + changeY );
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    
}

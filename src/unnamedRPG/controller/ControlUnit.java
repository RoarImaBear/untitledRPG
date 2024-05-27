package unnamedRPG.controller;

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
import unnamedRPG.display.Limits;
import unnamedRPG.display.components.GameBoard;

/**
 *
 * @author seb
 */
public class ControlUnit implements KeyListener, ComponentListener, MouseListener{
    GameBoard gameBoard;
    Limits boardLimits;
    
    public ControlUnit(Limits boardLimits, Limits frameLimits, GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.boardLimits = boardLimits;
        addKeyListener(this);
        addComponentListener(this);
        addMouseListener(this);        
    }
    
    
    
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.out.println("esc");
            System.exit(0);
        }
        if (ke.getKeyCode() == KeyEvent.VK_X) {
            gameBoard.changeScale(1);
            System.out.println("Zoom In");
        }
        if (ke.getKeyCode() == KeyEvent.VK_Z) {
            gameBoard.changeScale(-1);
            System.out.println("Zoom Out");
        }
        if (ke.getKeyCode() == KeyEvent.VK_W) {
            gameBoard.changePosition('w', 1);
            System.out.println("UP");
        }
        if (ke.getKeyCode() == KeyEvent.VK_S) {
            gameBoard.changePosition('s', 1);
            System.out.println("DOWN");
        }
        if (ke.getKeyCode() == KeyEvent.VK_A) {
            gameBoard.changePosition('a', 1);
            System.out.println("LEFT");
        }
        if (ke.getKeyCode() == KeyEvent.VK_D) {
            gameBoard.changePosition('d', 1);
            System.out.println("RIGHT");
        }
        
        
        

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
        System.out.println("CLICK");
        int mouseX = e.getX() - 7;
        int mouseY = e.getY() - 24;
        int centerX = FRAME_CENTER[0];
        int centerY = FRAME_CENTER[1];
        
        int changeX = mouseX - centerX;
        int changeY = mouseY - centerY;
        
        if(mouseY < boardLimits.endY){
            gameBoard.handleClick(mouseX, mouseY);             
        } else {
            System.out.println("Not map");
        }
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
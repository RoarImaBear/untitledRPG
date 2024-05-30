package unnamedRPG.controller;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import unnamedRPG.display.Display;
import unnamedRPG.display.Limits;
import unnamedRPG.display.components.GameBoard;
import unnamedRPG.model.GameMaster;

/**
 *
 * @author seb
 */
public class ControlUnit implements KeyListener, ComponentListener, MouseListener, MouseWheelListener, MouseMotionListener {

    GameBoard gameBoard;
    Display display;
    Limits boardLimits;
    Limits frameLimits;
    GameMaster gameMaster;

    public ControlUnit(GameBoard gameBoard, Limits boardLimits, Limits frameLimits) {
        this.gameBoard = gameBoard;
        this.boardLimits = boardLimits;
        this.frameLimits = frameLimits;
    }

    // Required for console connectivity
    public void connectDisplay(Display display) {
        this.display = display;
    }

    public void connectGameManager(GameMaster gameManager) {
        this.gameMaster = gameManager;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        
        if (keyCode == KeyEvent.VK_ESCAPE) {
            System.out.println("esc");
            try {
                gameMaster.saveGame();
            } catch (SQLException ex) {
                System.out.println("Couldn't save game. SQL error: " + ex);
            }
            System.exit(0);
        }
        if (keyCode == KeyEvent.VK_X) {
            gameBoard.changeScale(1);
            System.out.println("Zoom In");
        }
        if (keyCode == KeyEvent.VK_Z) {
            gameBoard.changeScale(-1);
            System.out.println("Zoom Out");
        }
        if (keyCode == KeyEvent.VK_W) {
            gameBoard.shiftPosition('w', 1);
            System.out.println("UP");
        }
        if (keyCode == KeyEvent.VK_S) {
            gameBoard.shiftPosition('s', 1);
            System.out.println("DOWN");
        }
        if (keyCode == KeyEvent.VK_A) {
            gameBoard.shiftPosition('a', 1);
            System.out.println("LEFT");
        }
        if (keyCode == KeyEvent.VK_D) {
            gameBoard.shiftPosition('d', 1);
            System.out.println("RIGHT");
        }

        if (keyCode == KeyEvent.VK_SPACE) {
            int x = gameMaster.player.currentXY[0];
            int y = gameMaster.player.currentXY[1];
            gameBoard.goTo(x, y);
            System.out.println("GO TO PLAYER");
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
        int mouseX = e.getX() - 7;
        int mouseY = e.getY() - 24;
     
        if (mouseY < boardLimits.endY) {
            gameMaster.handleClick(mouseX, mouseY);
        } else {
            System.out.println("Not on map");
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

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int wheelInput = e.getWheelRotation();
        gameBoard.changeScale(-wheelInput);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}


//        if (keyCode == KeyEvent.VK_W) {
//            keyComboWSAD[0] = true;
//        }
//        if (keyCode == KeyEvent.VK_S) {
//            keyComboWSAD[1] = true;
//        }
//        if (keyCode == KeyEvent.VK_A) {
//            keyComboWSAD[2] = true;
//        }
//        if (keyCode == KeyEvent.VK_D) {
//            keyComboWSAD[3] = true;
//        }
//        gameManager.handleKeyboardMove(keyComboWSAD);
//        
//
//    @Override
//    public void keyReleased(KeyEvent ke) {
//        int keyCode = ke.getKeyCode();
//        if (keyCode == KeyEvent.VK_W) {
//            keyComboWSAD[0] = false;
//        }
//        if (keyCode == KeyEvent.VK_S) {
//            keyComboWSAD[1] = false;
//        }
//        if (ke.getKeyCode() == KeyEvent.VK_A) {
//            keyComboWSAD[2] = false;
//        }
//        if (ke.getKeyCode() == KeyEvent.VK_D) {
//            keyComboWSAD[3] = false;
//        }
//    }
//    @Override
//    public void mouseMoved(MouseEvent e) {
//        int mouseX = e.getX();
//        int mouseY = e.getY();
//        int margin = 20;
//
//        if (display.frameCounter % 2  == 0) {
//            if (mouseY - margin*4 < boardLimits.startY) {
//                gameBoard.shiftPosition('w', 1);
//            }
//            if (mouseY + margin > boardLimits.endY) {
//                gameBoard.shiftPosition('s', 1);
//            }
//            if (mouseX - margin*2 < boardLimits.startX) {
//                gameBoard.shiftPosition('a', 1);
//            }
//            if (mouseX + margin > boardLimits.endX) {
//                gameBoard.shiftPosition('d', 1);
//            }
//        }

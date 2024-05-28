package unnamedRPG.controller;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import unnamedRPG.display.Limits;
import unnamedRPG.display.components.Console;
import unnamedRPG.display.components.GameBoard;

/**
 *
 * @author seb
 */
public class ControlUnit implements KeyListener, ComponentListener, MouseListener, MouseWheelListener {
    GameBoard gameBoard;
    Console console;
    Limits boardLimits;
    Limits frameLimits;
    
    public ControlUnit(Limits boardLimits, Limits frameLimits) {

        this.boardLimits = boardLimits;  
        this.frameLimits = frameLimits;
    }
    
    public void connectToGameBoard(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }
    
    public void connectConsole (Console console){
        this.console = console;
    }
    
    public void mapGoTo(int x, int y){
        gameBoard.goTo(x, y);
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
            gameBoard.shiftPosition('w', 1);
            System.out.println("UP");
        }
        if (ke.getKeyCode() == KeyEvent.VK_S) {
            gameBoard.shiftPosition('s', 1);
            System.out.println("DOWN");
        }
        if (ke.getKeyCode() == KeyEvent.VK_A) {
            gameBoard.shiftPosition('a', 1);
            System.out.println("LEFT");
        }
        if (ke.getKeyCode() == KeyEvent.VK_D) {
            gameBoard.shiftPosition('d', 1);
            System.out.println("RIGHT");
        }
        
        if (ke.getKeyCode() == KeyEvent.VK_M) {
            gameBoard.goTo(0, 0);
            System.out.println("GO TO 0,0");
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
        int centerX = frameLimits.centerX;
        int centerY = frameLimits.centerY;
        
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

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int wheelInput = e.getWheelRotation();
        gameBoard.changeScale(-wheelInput);
    }
    
}

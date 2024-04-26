
package unnamedRPG.display;

import static unnamedRPG.UnnamedRPG.FRAME_HEIGHT;
import static unnamedRPG.UnnamedRPG.FRAME_WIDTH;
import static unnamedRPG.UnnamedRPG.MAP_LENGTH;
import static unnamedRPG.UnnamedRPG.MAP_WIDTH;
import static unnamedRPG.UnnamedRPG.random;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.GRAY;
import static java.awt.Color.GREEN;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
import javax.swing.Timer;
import unnamedRPG.Map;
import static unnamedRPG.UnnamedRPG.FRAME_CENTER;

/**
 * @author Sebastian Dymanski
 * @id 14850975
 */
public class BackgroundLayerBackup extends JLayeredPane implements KeyListener, ComponentListener, MouseListener {

    Color color;
    Map map;
    JFrame frame;
    Timer timer;
    TerrainLayer terrainLayer;
    
    int frameTracker = 0;
    public BackgroundLayerBackup(JFrame frame, Map map, Camera camera) {
        this.frame = frame;
        this.map = map;
        this.setFocusable(true);
        this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        
        this.terrainLayer  = new TerrainLayer(map, new Camera());
        terrainLayer.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        this.add(terrainLayer, 100);
        
        addKeyListener(this);
        addComponentListener(this);
        addMouseListener(this);
        
    }
    
    public void refresh() {
        if(frameTracker%10==0) {
            terrainLayer.repaint();
        }
        frameTracker++;
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

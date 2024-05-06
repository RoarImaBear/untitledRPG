
package unnamedRPG.display.panes;

import unnamedRPG.display.components.UIBorder;
import static unnamedRPG.UnnamedRPG.FRAME_HEIGHT;
import static unnamedRPG.UnnamedRPG.FRAME_WIDTH;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.Timer;
import unnamedRPG.Map;
import unnamedRPG.display.Camera;
import unnamedRPG.display.Limits;

/**
 * @author Sebastian Dymanski
 * @id 14850975
 */
public class UIPane extends JLayeredPane  {

    Color color;
    Map map;
    Camera camera;
    JFrame frame;
    Timer timer;
    
    
    UIBorder border;
    
    Limits boardLimits;
    Limits frameLimits;
    
    int frameTracker = 0;
    public UIPane(Map map, Camera camera, Limits boardLimits, Limits frameLimits) {
        this.map = map;
        this.camera = camera;
        
        this.boardLimits = boardLimits;
        this.frameLimits = frameLimits;
        
        this.setFocusable(true);
        this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        
        this.border = new UIBorder(map, camera, boardLimits, frameLimits);
        
        border.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        this.add(border, 100);


    }
    
    public void refresh() {
        if(frameTracker%10 == 0) {
            //terrainLayer.repaint();
            border.repaint();
        }
        frameTracker++;
    }
}

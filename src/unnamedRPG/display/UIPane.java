
package unnamedRPG.display;

import static unnamedRPG.UnnamedRPG.FRAME_HEIGHT;
import static unnamedRPG.UnnamedRPG.FRAME_WIDTH;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.Timer;
import unnamedRPG.Map;

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
    
    
    UIBorderComponent border;
    
    int frameTracker = 0;
    public UIPane(Map map, Camera camera, int boardXYLimits[][], int frameXYLimits[][]) {
        this.map = map;
        this.camera = camera;
        
        this.setFocusable(true);
        this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        
        this.border = new UIBorderComponent(map, camera, boardXYLimits, frameXYLimits);
        
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


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
public class BackgroundLayer extends JLayeredPane  {

    Color color;
    Map map;
    Camera camera;
    JFrame frame;
    Timer timer;
    TerrainLayer terrainLayer;
    
    
    int frameTracker = 0;
    public BackgroundLayer(JFrame frame, Map map, Camera camera) {
        this.frame = frame;
        this.map = map;
        this.camera = camera;
        
        this.setFocusable(true);
        this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        
        this.terrainLayer  = new TerrainLayer(map, camera);
        terrainLayer.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        this.add(terrainLayer, 100);

    }
    
    public void refresh() {
        if(frameTracker%10 == 0) {
            terrainLayer.repaint();
        }
        frameTracker++;
    }
}

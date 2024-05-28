
package unnamedRPG.display.panes;

import unnamedRPG.display.components.Border;
import static unnamedRPG.UnnamedRPG.FRAME_HEIGHT;
import static unnamedRPG.UnnamedRPG.FRAME_WIDTH;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import unnamedRPG.model.Map;
import unnamedRPG.display.Limits;
import unnamedRPG.display.components.Console;
import unnamedRPG.display.components.PlayerDashboard;

/**
 * @author Sebastian Dymanski
 * @id 14850975
 */
public class UIPane extends JLayeredPane  {

    Color color;
    Map map;
    JFrame frame;
    Timer timer;
    
    
    Border border;
    PlayerDashboard playerDashboard;
    
    Limits boardLimits;
    Limits frameLimits;
    JTextArea textArea;
    JScrollPane scrollPane;
    Console console;
    
    int frameTracker = 0;
    public UIPane(Map map, Limits boardLimits, Limits frameLimits) {
        this.map = map;
        this.boardLimits = boardLimits;
        this.frameLimits = frameLimits;
        
        this.setFocusable(true);
        this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        this.playerDashboard = new PlayerDashboard(boardLimits, frameLimits);
        this.border = new Border(boardLimits, frameLimits);
        this.textArea = new JTextArea(10, 20);
        this.scrollPane = new JScrollPane(textArea);
        this.console = new Console(boardLimits, frameLimits);
        
        this.add(console);
        this.add(playerDashboard);
        this.add(border);
    }
    
    public void refresh() {
        if(frameTracker%2 == 0) {
            border.repaint();
            playerDashboard.repaint();
            console.repaint();
            console.appendText("FUCK\n");
        }
        frameTracker++;
    }
}

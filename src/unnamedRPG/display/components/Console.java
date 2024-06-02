package unnamedRPG.display.components;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import static unnamedRPG.UnnamedRPG.DECORATOR;
import unnamedRPG.display.Limits;


/**
 *
 * @author seb
 */
    public class Console extends JScrollPane {

    private JTextArea textArea;
    private JScrollBar scrollBar;
        
    public Console(Limits boardLimits, Limits frameLimits)  {
        this.setBounds(frameLimits.getEndX() - 411, boardLimits.getEndY() + 15, 395, 180);
        this.textArea = new JTextArea(10, 20);
        this.scrollBar = this.getVerticalScrollBar();
        setViewportView(textArea);
        
        textArea.setEditable(false);  
        textArea.setBackground(DECORATOR.interfaceBGColors(3));
        textArea.setForeground(DECORATOR.interfaceBGColors(0));
    }
    
    public void appendText(String text) {
        textArea.append(text);
        scrollBar.setValue(scrollBar.getMaximum());
    } 
}

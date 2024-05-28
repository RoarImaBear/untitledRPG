package unnamedRPG.display.components;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static unnamedRPG.UnnamedRPG.DECORATOR;
import unnamedRPG.display.Limits;


/**
 *
 * @author seb
 */
    public class Console extends JScrollPane {

    JTextArea textArea;
        
    public Console(Limits boardLimits, Limits frameLimits)  {
        this.setBounds(frameLimits.endX - 411, boardLimits.endY + 15, 395, 190);
        this.textArea = new JTextArea(10, 20);
        setViewportView(textArea);
        
        textArea.setEditable(false);  
        textArea.setBackground(DECORATOR.interfaceBGColors(3)); // Set background color
        textArea.setForeground(DECORATOR.interfaceBGColors(0));
    }
    
    public void appendText(String text) {
        textArea.append(text);
    } 

    


}

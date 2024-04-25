/*  SYNCHRONIZATION: I decided to apply synchronize to a method in VirusSimulation
    -- requestShopBooking(). Since the method is static, it's able to use itself as 
    the lock object for synchronization.

    This method acts as a "booking manager", only allowing phones to move to the
    repair shop when it's not busy. With this method synchronized, only one phone
    can go to the repair shop at a time.

    It made sense to me to prevent a race condition from occuring at the earliest
    possible moment -- before the phone starts moving towards the repair shop.
 */
package combatarena;

import static combatarena.CombatArena.FRAME_HEIGHT;
import static combatarena.CombatArena.FRAME_WIDTH;
import static combatarena.CombatArena.MAP_LENGTH;
import static combatarena.CombatArena.MAP_WIDTH;
import static combatarena.CombatArena.random;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.GRAY;
import static java.awt.Color.GREEN;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Sebastian Dymanski
 * @id 14850975
 */
public class Panel extends javax.swing.JPanel implements KeyListener, ComponentListener {

    Color color;
    Battlefield map;

    Color[] grassGreens;
    int[] grassAnchor = {73, 156, 77};
    Color greenBush = new Color(34, 139, 34);
    Color greenTree = new Color(0, 128, 0);
    Color blackFissure = new Color(0, 0, 0);
    Color blueWater = new Color(65, 105, 225);

    JFrame frame;

    public Panel(JFrame frame, Battlefield map) {
        this.frame = frame;
        this.map = map;
        this.addKeyListener(this);
        this.addComponentListener(this);
        this.setFocusable(true);
        this.grassGreens = createPallette(10, grassAnchor, 10);
    }

    Color[] createPallette(int numberOfColors, int[] anchorValue, int variance) {
        Color[] pallette = new Color[numberOfColors];
        for (int i = 0; i < pallette.length; i++) {
            pallette[i] = new Color(anchorValue[0] + random.nextInt(variance), 
                anchorValue[1] + random.nextInt(variance), anchorValue[2] + 
                random.nextInt(variance));
        }
        return pallette;
    }

    Color colorSwitch(char subject) {

        switch (subject) {
            case ('„'):
                return grassGreens[random.nextInt(10)];
            case ('ϫ'):
                return greenBush;
            case ('ϒ'):
                return greenTree;
            case ('|'):
                return blackFissure;
            case ('~'):
                return blueWater;
        }
        return BLUE;
    }

//    char grass = '„'; 
//    char bush = 'ϫ';
//    char tree = 'ϒ';
//    char fissure = '|';
//    char water = '~';
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(BLACK);
        renderFrame(g);

        for (int y = 0, mapY = 0; y < FRAME_HEIGHT; y += 10, mapY++) {
            for (int x = 0, mapX = 0; x < FRAME_WIDTH; x += 10, mapX++) {
                char currentTile = map.terrain[mapX][mapY];

                g.setColor(colorSwitch(currentTile));
                g.fillRect(x, y, 8, 8);
            }
        }

//        g.setColor(GRAY);
//        for (int y = 0, mapY = 0; y < FRAME_HEIGHT; y+=10, mapY++) {
//            for (int x = 0, mapX = 0; x < FRAME_WIDTH; x+=10, mapX++) {
//                g.drawString(map.terrain[mapX][mapY], x, y);
//            }
//        }
        repaint();
    }

//    private void renderPhone(Phone currentPhone, Graphics g){
//        color = currentPhone.color;
//        currentPhone.run();
//        g.setColor(color);
//        g.fillRect(currentPhone.x, currentPhone.y, currentPhone.spriteWidth, currentPhone.spriteHeight);
//    }
//    
//    private void renderShop (RepairShop shop, Graphics g){
//        g.setColor(shop.color);
//        g.fillRect(shop.x, shop.y, shop.spriteWidth, shop.spriteHeight);
//        g.setColor(shop.textColor);
//        g.drawString("REPAIR SHOP", shop.x + 4, 15);  
//    }
    private void renderFrame(Graphics g) {
        g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
//        char keyChar = ke.getKeyChar();
//        
//        if (keyChar == 'v'){
//            infectPhone();
//        }
//        System.out.println("Key typed: " + keyChar);
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
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
}

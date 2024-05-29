package unnamedRPG.utilities;

import java.awt.Color;
import static java.awt.Color.BLUE;
import static unnamedRPG.UnnamedRPG.RANDOM;

/**
 *
 * @author seb
 */
public class Decorator {
    
    Color[] grassGreens;
    int[] grassAnchor = {73, 156, 77};
    Color[] waterBlues;
    int[] waterAnchor = {25, 109, 150};

    Color brownBush = new Color(108, 80, 7);
    Color greenBush = new Color(34, 139, 34);
    Color brownTree = new Color(74, 61, 29);
    Color greenTree = new Color(0, 128, 0);
    Color blackFissure = new Color(0, 0, 0);
    
    Color playerAura = new Color(255,250,250, 200);
    Color friendlyAura = new Color(73, 222, 25, 200);
    Color hostileAura = new Color(225, 19, 19, 200);
    
    Color menuColor0 = new Color(30, 30, 30);
    Color menuColor1 = new Color(80, 80, 80);
    Color menuColor2 = new Color(130, 130, 130);
    Color menuColor3 = new Color(180, 180, 180);
    Color menuColor4 = new Color(230, 230, 230);
    
    Color statusColor0 = new Color(167, 13, 13);
    Color statusColor1 = new Color(167, 13, 13, 128);
    Color statusColor2 = new Color(213, 196, 50);
    Color statusColor3 = new Color(213, 196, 50, 128);
    Color statusColor4 = new Color(11, 235, 231);
    Color statusColor5 = new Color(11, 235, 231, 128);
    Color statusColor6 = new Color(230, 230, 230);
    
    
    

    public Decorator() {
        this.grassGreens = createPallette(10, grassAnchor, 5);
        this.waterBlues = createPallette(10, waterAnchor, 20);
    }
    
    

    public Color colorSwitch(char subject) {

        switch (subject) {
            case ('„'):
                return grassGreens[RANDOM.nextInt(10)];
            case ('ϫ'):
                return brownBush;
            case ('ϒ'):
                return brownTree;
            case ('|'):
                return blackFissure;
            case ('~'):
                return waterBlues[RANDOM.nextInt(10)];
            case ('p'):
                return playerAura;
            case ('f'):
                return friendlyAura;
            case ('h'):
                return hostileAura;
        }
        return BLUE;
    }
    
        public Color interfaceBGColors(int index) {
        switch (index) {
            case (0):
                return menuColor0;
            case (1):
                return menuColor1;
            case (2):
                return menuColor2;
            case (3):
                return menuColor3;
            case (4):
                return menuColor4;
        }

        return BLUE;
    }
        
    public Color playerInfoColors (int index) {

        switch (index) {
            case (0):
                return statusColor0;
            case (1):
                return statusColor1;
            case (2):
                return statusColor2;
            case (3):
                return statusColor3;
            case (4):
                return statusColor4;
            case (5):
                return statusColor5;
            case (6):
                return statusColor6;
        }
        return BLUE;
    }
    
    Color[] createPallette(int numberOfColors, int[] anchorValue, int variance) {
        Color[] pallette = new Color[numberOfColors];
        for (int i = 0; i < pallette.length; i++) {
            pallette[i] = new Color(anchorValue[0] + RANDOM.nextInt(variance), 
                anchorValue[1] + RANDOM.nextInt(variance), anchorValue[2] + 
                RANDOM.nextInt(variance));
        }
        return pallette;
    }
    
}
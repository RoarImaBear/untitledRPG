/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.utilities;

import java.awt.Color;
import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static unnamedRPG.UnnamedRPG.random;

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

    public Decorator() {
        this.grassGreens = createPallette(10, grassAnchor, 5);
        this.waterBlues = createPallette(10, waterAnchor, 20);;
    }
    
    

    public Color colorSwitch(char subject) {

        switch (subject) {
            case ('„'):
                return grassGreens[random.nextInt(10)];
            case ('ϫ'):
                return brownBush;
            case ('ϒ'):
                return brownTree;
            case ('|'):
                return blackFissure;
            case ('~'):
                return waterBlues[random.nextInt(10)];
        }
        return BLUE;
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
    
}


//    Font fontSwitch (char subject) {
//
//        switch (subject) {
//            case ('„'):
//                return new Font("Arial", Font.PLAIN, (50));
//            case ('ϫ'):
//                return new Font("Arial", Font.PLAIN, (80));
//            case ('ϒ'):
//                return new Font("Arial", Font.PLAIN, (12));
//            case ('|'):
//                return new Font("Arial", Font.PLAIN, 50);
//            case ('~'):
//                return new Font("Arial", Font.PLAIN, 50);
//        }
//        return new Font("Arial", Font.PLAIN, (50));
//    }
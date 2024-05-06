package unnamedRPG;

import java.awt.Dimension;
import java.awt.Toolkit;
import unnamedRPG.entities.Army;
import unnamedRPG.entities.Soldier;
import unnamedRPG.display.MainPane;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import unnamedRPG.display.Display;

/**
 *
 * @author seb
 * 
 * Use it as a widget.
 * Invade your friends phones.
 * Have their village defend itself from your attacks.
 * 
 */
public class UnnamedRPG {
    
    public int[] PLAYER_POSITION = new int [2];
    
    public static Dimension DISPLAY_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    
    public static Random random = new Random();
    
    
    public static final int MAP_WIDTH = 1440;
    public static final int MAP_LENGTH = 900;
    
    public static final int FRAME_WIDTH = DISPLAY_SIZE.width;
    public static final int FRAME_HEIGHT = DISPLAY_SIZE.height;
    public static final int[] FRAME_CENTER = {FRAME_WIDTH/2, FRAME_HEIGHT/2};
    

    public static void main(String[] args) {
        
        Map map = new Map();

        
        System.out.println("MAP MADE");
        Display display = new Display(map);
        Thread displayThread = new Thread(display);
        displayThread.start();
        
        System.out.println("Display: " + DISPLAY_SIZE.height + "x" + DISPLAY_SIZE.width);
  

    }
    
    public static void battleRound (Army attackingArmy, Army defendingArmy){
        ArrayList<Soldier> attackers = attackingArmy.activeSoldiers;
        ArrayList<Soldier> defenders = defendingArmy.activeSoldiers;
        
        int attackerCount = attackers.size();
        int defenderCount = defenders.size();
        int sizeDifference = attackerCount - defenderCount;
        
        Soldier attacker;
        Soldier defender;
        
        
        if ( sizeDifference >= 0){
            
            for (int i = 0; i < defenderCount; i++){
                attacker = attackers.get(i);
                defender = defenders.get(i);

                fight(attacker, defender);
            }
        } else if (sizeDifference < 0 ) {
        
            for (int i = 0; i < attackerCount; i++){
                attacker = attackers.get(i);
                defender = defenders.get(i);

                fight(attacker, defender);
            }
        }
        
        attackingArmy.filterCasualties();
        defendingArmy.filterCasualties();
        
        
    }
    
    
    public static int fight (Soldier attacker, Soldier defender) {
        while(true){    
            if(attacker.healthPool > 0 && defender.healthPool > 0)
                attacker.attack(defender);
            else
                return attacker.healthPool - defender.healthPool;
            
            if(attacker.healthPool > 0 && defender.healthPool > 0)
                defender.attack(attacker);
            else
                return attacker.healthPool - defender.healthPool;
            
        }
    }
       
    
    
}
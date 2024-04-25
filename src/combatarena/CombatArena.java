package combatarena;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author seb
 * 
 * Use it as a widget.
 * Invade your friends phones.
 * Have their village defend itself from your attacks.
 * 
 */
public class CombatArena {
    
    public static Random random = new Random();
    
    public static final int MAP_WIDTH = 100;
    public static final int MAP_LENGTH = 100;
    
    public static final int FRAME_WIDTH = MAP_WIDTH * 10;
    public static final int FRAME_HEIGHT = MAP_LENGTH * 10;
    

    public static void main(String[] args) {
        
        
//        Army armyOne = new Army();
//        Army armyTwo = new Army();
//        
//        armyOne.rollCall();
//        armyTwo.rollCall();
//        
//        System.out.println("Round one");
//        battleRound(armyOne, armyTwo);
//        
//        armyOne.rollCall();
//        armyTwo.rollCall();

        

        
        int markWins = 0;
        int steveWins = 0;

        for (int i = 0; i < 1000; i++) {
            Soldier steve = new Soldier("Steve");
            Soldier mark = new Soldier("Mark");

            steve.agility = 16;
            mark.agility = 14;

            steve.protection = 0;
            mark.protection = 1;
  
            steve.proficiency = 0;
            mark.proficiency = 1;
 
            
            if(fight(steve, mark) > 0){
                steveWins++;
            }
            else{
                markWins++;
            }
        }
       
        System.out.println("Attacker victories: " + steveWins);
        
        System.out.println("Defender victories: " + markWins);
       
        
        //Attacker has advantage.
        
        Battlefield map = new Battlefield();
        
        
        
        JFrame frame = new JFrame("Battle Simulator");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Panel panel = new Panel(frame, map);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
  

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

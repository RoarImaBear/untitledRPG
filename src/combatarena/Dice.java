/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combatarena;

import java.util.Random;

/**
 *
 * @author seb
 */
public class Dice {
    
    static Random random = new Random();
    
    
    // Simulates table top dice roll
    public static int rollDice(int count, int limit) {
        
        int output = count;
        
        for(int i = 0; i < count; i++ ){
            output += random.nextInt(limit);
        }
        return output;
    }
    
}

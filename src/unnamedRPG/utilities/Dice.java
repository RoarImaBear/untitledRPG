/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.utilities;

import static unnamedRPG.UnnamedRPG.RANDOM;

/**
 *
 * @author seb
 */
public class Dice {
    // Simulates table top dice roll
    public static int rollDice(int count, int limit) {
        
        int output = count;
        
        for(int i = 0; i < count; i++ ){
            output += RANDOM.nextInt(limit);
        }
        return output;
    }
    
}

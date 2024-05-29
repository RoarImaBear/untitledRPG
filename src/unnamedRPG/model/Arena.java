/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.model;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.Timer;
import unnamedRPG.model.entities.Entity;

/**
 *
 * @author sdyma
 */
public class Arena implements Runnable{
    
    Timer arenaClock;
    
    ArrayList<Entity[]> arenaRooms = new ArrayList();
    Entity[] fighters = new Entity[2];
    Entity attacker;
    Entity defender;
    
    
    @Override
    public void run() {
        arenaClock = new Timer(2000, (ActionEvent e) -> {                
            performRound();
        });
    }
    
    public void addCombatants(Entity[] pairing){
        arenaRooms.add(pairing);
    }

    public void performRound(){
        
        for(Entity[] room : arenaRooms){
            attacker = room[0];
            defender = room[1];
            if(attacker.currentHP > 0 && defender.currentHP > 0){
                attacker.attack(defender);
            } else{
                int winnerCheck = attacker.currentHP - defender.currentHP;
                if( winnerCheck > 0){
                    defender.dead = true;
                    defender.token = null;
                } else if (winnerCheck < 0){
                    attacker.dead = true;
                    attacker.token = null;               
                }  
            }
                       
            if(attacker.currentHP > 0 && defender.currentHP > 0){
                defender.attack(attacker);
            } else {
                int winnerCheck = attacker.currentHP-defender.currentHP;
                if( winnerCheck > 0){
                    defender.dead = true;
                    defender.token = null;
                } else if (winnerCheck < 0){
                    attacker.dead = true;
                    attacker.token = null;
                }  
            }    
        }
    }


    
    
    
}

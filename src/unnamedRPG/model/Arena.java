/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.model;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.Timer;
import unnamedRPG.display.Display;
import unnamedRPG.model.entities.Entity;
import unnamedRPG.model.entities.Player;

/**
 *
 * @author sdyma
 */
public class Arena implements Runnable{
    
    Timer arenaClock;
    Display display;
    
    ArrayList<Entity[]> arenaRooms = new ArrayList();
    Entity[] fighters = new Entity[2];
    Entity attacker;
    Entity defender;

    public Arena(Display display) {
        this.display = display;
    }
    
    
    
    @Override
    public void run() {
        arenaClock = new Timer(800, (ActionEvent e) -> {                
            performRound();
        });
        arenaClock.start();
    }
    
    public void addCombatants(Entity[] pairing){
        pairing[0].inCombat = true;
        pairing[1].inCombat = true;
        arenaRooms.add(pairing);
    }

    public void performRound(){
        String outcome;
        for(Entity[] room : arenaRooms){
            attacker = room[0];
            defender = room[1];
            if(attacker.currentHP > 0 && defender.currentHP > 0){
                outcome = attacker.attack(defender);
                if (attacker instanceof Player) {
                    display.appendConsole("You attack " + defender.name + "\n" + outcome);
                } else if (defender instanceof Player) {
                    display.appendConsole(attacker.name + " attacks you.\n" + outcome);
                }
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
                outcome = defender.attack(attacker);
                if (attacker instanceof Player) {
                    display.appendConsole("\n"+defender.name + " attacks you.\n" + outcome + "\n");
                } else if (defender instanceof Player) {
                    display.appendConsole("You attack " + attacker.name + "\n" + outcome + "\n");
                }
            } else {
                int winnerCheck = attacker.currentHP-defender.currentHP;
                if( winnerCheck > 0){
                    defender.dead = true;
                    defender.token = null;
                } else if (winnerCheck < 0){
                    attacker.dead = true;
                    attacker.token = null;
                }
                if (defender instanceof Player) {
                    display.appendConsole("You've been slain \n.");
                } else if (attacker instanceof Player) {
                    display.appendConsole("You've slain " + defender.name + "\n");
                }
            }    
        }
        cleanRooms();
    }
    
    private void cleanRooms(){
        ArrayList<Entity[]> cleanedRooms = new ArrayList();
        for(Entity[] room : arenaRooms){
            if(room[0].dead || room[1].dead){
                
            } else {
                cleanedRooms.add(room);
            }
        }
        arenaRooms = cleanedRooms;
    }
}

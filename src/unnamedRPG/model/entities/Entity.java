package unnamedRPG.model.entities;

import java.awt.Color;
import static java.awt.Color.YELLOW;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import unnamedRPG.items.Armour;
import unnamedRPG.items.Weapon;
import static unnamedRPG.utilities.Dice.rollDice;
import static unnamedRPG.UnnamedRPG.DECORATOR;

/**
 *
 * @author seb
 */
public class Entity {
    
    public String name;
    public BufferedImage token;
    public int[] currentXY = new int[2];
    
    public int soldierID;
    public int maxHP;
    public int currentHP;
    public int maxStamina;
    public int currentStamina;
    public int staminaRegen;
    
    public int proficiency;
    
    public int agility;
    public int protection;
    
    public int experience;
    public int weaponExpertise;
    
    public int damageDiceCount;
    public int damageDiceLimit;
    
    public int attackDiceCount;
    public int attackDiceLimit;
    
    public boolean dead;
    public boolean wounded;
    
    public Weapon equippedWeapon;
    public Armour equippedArmour;
    
    public Color tokenColor;
    public String tokenString;
    

    public Entity(String name) {
        this.name = name;
    }
    
    
    public void attack(Entity enemy) {
        int attackValue = proficiency + rollDice(attackDiceCount, attackDiceLimit);
        int enemyAgility = enemy.agility;
       
        if (attackValue > enemyAgility){
            int damageValue = proficiency + rollDice(damageDiceCount, damageDiceLimit); 
            damageValue -= enemy.protection;
            
            
            if (damageValue > 0){
                enemy.maxHP -= damageValue;
            }
            else {
            }
        }
        
        if ( enemyAgility > (attackValue * 3) ){
            enemy.attack(this); // Triggers enemy to get an extra attack.
        }
        
    }
    
    public void staminaRegen(){   
        currentStamina += staminaRegen;
        if (currentStamina > maxStamina){
            currentStamina = maxStamina;
        }
    }
    
    
    public void equipWeapon(Weapon weapon) {
        equippedWeapon = weapon;
        this.weaponExpertise = 0; // May need to create an array for weapon type expertise.
        
        this.attackDiceCount = weapon.attackDiceCount;
        this.attackDiceLimit = weapon.attackDiceLimit;
        this.damageDiceCount = weapon.damageDiceCount;
        this.damageDiceLimit = weapon.damageDiceLimit;
    }
    
    public void equipArmour(Armour armour) {
        this.agility += armour.agilityBonus;
        this.protection += armour.protectionBonus;
    }
    
    
    public void printStatus(){
        System.out.println("Soldier " + name);
        System.out.print("    HP: " + maxHP);
        System.out.print("    Agility: " + agility);
        System.out.print("    Protection: " + protection);
        System.out.print("    Proficiency: "+ proficiency);
        System.out.println("");
    }
    
    
}

package unnamedRPG.model.entities;

import java.awt.Color;
import java.awt.image.BufferedImage;
import unnamedRPG.items.Armour;
import unnamedRPG.items.Weapon;
import static unnamedRPG.utilities.Dice.rollDice;

/**
 *
 * @author seb
 */
public class Entity {
    
    public String name;
    public BufferedImage token;
    public Color auraColor;
    public int[] currentXY = new int[2];
    public int scoreValue;
    public int currentScore = 0;
    public int maxScore;
    
    
    public int maxHP;
    public int currentHP;
    public int maxStamina;
    public int currentStamina;
    public int staminaRegen;
    
    public int proficiency;
    
    public int agility;
    public int protection;
    
    public int weaponExpertise;
    
    public int damageDiceCount;
    public int damageDiceLimit;
    
    public int attackDiceCount;
    public int attackDiceLimit;
    
    public boolean inCombat = false;
    public boolean dead;
    public boolean looted;
    
    public Weapon equippedWeapon;
    public Armour equippedArmour;
    
    public Color tokenColor;
    public String tokenString;
    

    public Entity(String name) {
        this.name = name;
    }
    
    public int[] getXY() {
       return currentXY;
    } 
    
    public void staminaRegen(){   
        currentStamina += staminaRegen;
        if (currentStamina > maxStamina){
            currentStamina = maxStamina;
        }
    }
    
    public String attack(Entity enemy) {
        String outcome = "";
        int attackValue = proficiency + rollDice(attackDiceCount, attackDiceLimit);
        int enemyAgility = enemy.agility;
       
        if (attackValue > enemyAgility){
            outcome += "It's a HIT ";
            int damageValue = proficiency + rollDice(damageDiceCount, damageDiceLimit); 
            damageValue -= enemy.protection;
            
            if (damageValue > 0){
                enemy.currentHP -= damageValue;
                outcome+= "dealing " + damageValue + "damage.";
            }
        } else if ( enemyAgility > (attackValue * 3) ){
            String counterOutcome = enemy.attack(this); // Triggers enemy to get an extra attack.
            outcome = "but it was a miss, prompting the enemy to... \n" + "COUNTER!\n" + counterOutcome + "\n";
        } else {
            outcome = "but it was a miss.\n";
        }
        return outcome;
    }
    
    public String loot(Entity targetEntity){
        int lootScore = targetEntity.scoreValue;
        this.currentScore += lootScore;
        targetEntity.looted = true;
        return "" + lootScore + "shards";
    }
    
    public void equipWeapon(Weapon weapon) {
        equippedWeapon = weapon;
        this.weaponExpertise = 0; // May need to create an array for weapon type expertise.
        
        this.attackDiceCount = weapon.getAttackDiceCount();
        this.attackDiceLimit = weapon.getAttackDiceLimit();
        this.damageDiceCount = weapon.getDamageDiceCount();
        this.damageDiceLimit = weapon.getDamageDiceLimit();
    }
    
    public void equipArmour(Armour armour) {
        this.agility += armour.getAgilityBonus();
        this.protection += armour.getProtectionBonus();
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

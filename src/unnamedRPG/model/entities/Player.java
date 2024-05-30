package unnamedRPG.model.entities;

import static unnamedRPG.UnnamedRPG.DECORATOR;
import unnamedRPG.items.Armour;
import unnamedRPG.items.BronzeSpear;
import unnamedRPG.items.Weapon;
import unnamedRPG.utilities.ImageAssets;

/**
 *
 * @author seb
 */
public class Player extends Entity{
    
    boolean deserter;
    
    public Weapon equippedWeapon = new BronzeSpear();
    public Armour equippedArmour;

    public Player(String name) {
        super(name);
        this.name = "Player";
        this.token = ImageAssets.playerIcon;
        this.auraColor = DECORATOR.colorSwitch('p');
        
        this.maxHP = 50;
        this.currentHP = maxHP;
        this.maxStamina = 35;
        this.currentStamina = maxStamina;
        this.staminaRegen = 5;
        this.maxScore = 100;
        
        this.dead = false;
        
        this.proficiency = 3; 
        this.agility = 3;
        this.protection = 2;
        
        equipWeapon(new BronzeSpear());
    }

    public void setStats(int hp, int stamina, int score, int maxScore){
        this.maxHP = hp;
        this.currentHP = maxHP;
        this.maxStamina = stamina;
        this.currentStamina = maxStamina;
        this.currentScore = score; 
    }
    
    public String levelCheck(){
        if(currentScore >= maxScore){
            return levelUp();
        }
        return"";
    }
    private String levelUp(){
        this.maxHP +=5;
        this.currentHP = maxHP;
        this.maxStamina +=5;
        this.currentStamina = maxStamina;
        this.maxScore *= 1.5;
        this.currentScore = 0;
        return "You've leveled up!";
    }
    
}

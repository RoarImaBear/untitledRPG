package unnamedRPG.model.entities;

import java.awt.Color;
import unnamedRPG.items.Armour;
import unnamedRPG.items.BronzeSpear;
import unnamedRPG.items.Weapon;
import unnamedRPG.model.entities.Entity;
import static unnamedRPG.utilities.Dice.rollDice;
import unnamedRPG.utilities.ImageAssets;
import static unnamedRPG.UnnamedRPG.RANDOM;

/**
 *
 * @author seb
 */
public class Player extends Entity{
    
    boolean deserter;
    
    public Weapon equippedWeapon = new BronzeSpear();
    public Armour equippedArmour;

    public Player() {
        super();
        this.name = "Player";
        this.token = ImageAssets.playerIcon;
        
        this.tokenColor = new Color(200, 200, 200);
        this.tokenString = "@";
        
        
        this.maxHP = 50;
        this.currentHP = 35;
        this.maxStamina = 35;
        this.currentStamina = 14;
        this.dead = false;
        
        this.proficiency = rollDice(1, 3);
        
        this.agility = rollDice(1, 3);
   
        this.protection = 1;
    }

}

package unnamedRPG.model.entities;

import java.awt.Color;
import static unnamedRPG.UnnamedRPG.DECORATOR;
import unnamedRPG.items.Armour;
import unnamedRPG.items.BronzeSpear;
import unnamedRPG.items.Unarmed;
import unnamedRPG.items.Weapon;
import static unnamedRPG.utilities.Dice.rollDice;
import unnamedRPG.utilities.ImageAssets;

/**
 *
 * @author seb
 */
public class Ghoul extends Entity{
    
    boolean deserter;
    
    public Weapon equippedWeapon = new Unarmed();
    public Armour equippedArmour;

    public Ghoul(String name) {
        super(name);
        this.name = "Ghoul" + name;
        this.token = ImageAssets.ghoul;
        this.auraColor = DECORATOR.colorSwitch('h');       
        
        this.maxHP = 50;
        this.currentHP = maxHP;
        this.maxStamina = 25;
        this.currentStamina = maxStamina;
        this.staminaRegen = 5;
        this.dead = false;
        
        this.proficiency = 1;
        
        this.agility = 1;
   
        this.protection = 0;
        equipWeapon(new Unarmed());
    }

}

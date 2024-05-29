package unnamedRPG.model.entities;

import java.awt.Color;
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
        this.tokenColor = new Color(200, 200, 200);
        this.tokenString = "G";        
        
        this.maxHP = 20;
        this.currentHP = maxHP;
        this.maxStamina = 25;
        this.currentStamina = maxStamina;
        this.staminaRegen = 5;
        this.dead = false;
        
        this.proficiency = 1;
        
        this.agility = 1;
   
        this.protection = 0;
    }

}

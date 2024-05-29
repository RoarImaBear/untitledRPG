package unnamedRPG.model.entities;

import static unnamedRPG.UnnamedRPG.DECORATOR;
import static unnamedRPG.UnnamedRPG.RANDOM;
import unnamedRPG.items.Unarmed;
import unnamedRPG.utilities.ImageAssets;

/**
 *
 * @author seb
 */
public class Ghoul extends Entity{

    public Ghoul(String name) {
        super(name);
        this.name = "Ghoul" + name;
        this.token = ImageAssets.ghoul;
        this.auraColor = DECORATOR.colorSwitch('h');       
        this.scoreValue = 5 + RANDOM.nextInt(8);
        
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

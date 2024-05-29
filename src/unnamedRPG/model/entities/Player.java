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
        this.dead = false;
        
        this.proficiency = 3;
        
        this.agility = 3;
   
        this.protection = 2;
        
        equipWeapon(new BronzeSpear());
    }

}

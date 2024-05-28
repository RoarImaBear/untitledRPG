package unnamedRPG.model.entities;

import unnamedRPG.items.Armour;
import unnamedRPG.items.BronzeSpear;
import unnamedRPG.items.Weapon;
import unnamedRPG.model.entities.Entity;
import static unnamedRPG.utilities.Dice.rollDice;
import static unnamedRPG.UnnamedRPG.RANDOM;

/**
 *
 * @author seb
 */
public class Soldier extends Entity{
    
    boolean deserter;
    
    Weapon equippedWeapon;
    Armour equippedArmour;

    public Soldier(String name) {
        this.name = name;
        this.healthPool = 50;
        this.dead = false;
        
        this.proficiency = rollDice(1, 3);;
        
        this.agility = rollDice(1, 3);

        
        
        this.protection = 1;
        
        equipWeapon(new BronzeSpear());
    }
}

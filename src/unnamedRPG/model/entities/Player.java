package unnamedRPG.model.entities;

import java.awt.Color;
import unnamedRPG.items.Armour;
import unnamedRPG.items.BronzeSpear;
import unnamedRPG.items.Weapon;
import unnamedRPG.model.entities.Entity;
import static unnamedRPG.UnnamedRPG.random;
import static unnamedRPG.utilities.Dice.rollDice;

/**
 *
 * @author seb
 */
public class Player extends Entity{
    
    boolean deserter;
    
    Weapon equippedWeapon;
    Armour equippedArmour;

    public Player() {
        super();
        this.name = name;
        this.tokenColor = new Color(200, 200, 200);
        this.tokenString = "@";
        
        
        this.healthPool = 50;
        this.dead = false;
        
        this.proficiency = rollDice(1, 3);;
        
        this.agility = rollDice(1, 3);
        
        
        
        
        this.protection = 1;
        
        equipWeapon(new BronzeSpear());
    }

}

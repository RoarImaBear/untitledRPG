package combatarena;

import static combatarena.CombatArena.random;
import static combatarena.Dice.rollDice;

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

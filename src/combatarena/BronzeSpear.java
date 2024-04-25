package combatarena;

/**
 *
 * @author seb
 */
public class BronzeSpear extends Weapon {
    
    public BronzeSpear() {
        this.name = "Bronze Spear";
        
        this.ranged = false;
        
        this.attackDiceCount = 2;
        this.attackDiceLimit = 10;
        
        this.damageDiceCount = 1;
        this.damageDiceLimit = 8;
    }
    
}

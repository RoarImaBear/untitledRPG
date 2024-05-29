package unnamedRPG.items;


/**
 *
 * @author seb
 */
public class Unarmed extends Weapon {
    
    public Unarmed() {
        this.name = "Unarmed";
        this.ranged = false;
        
        this.attackDiceCount = 2;
        this.attackDiceLimit = 10;
        
        this.damageDiceCount = 1;
        this.damageDiceLimit = 6;
    }
    
}

package unnamedRPG.items;


/**
 *
 * @author seb
 */
public class Unarmed extends Weapon {
    
    public Unarmed() {
        setName("Unarmed");
        
        setAttackDiceCount(2);
        setAttackDiceLimit(10);
        
        setDamageDiceCount(1);
        setDamageDiceLimit(4);
        
    }
    
}

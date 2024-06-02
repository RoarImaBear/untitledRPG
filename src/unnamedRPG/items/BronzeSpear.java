package unnamedRPG.items;

import unnamedRPG.utilities.ImageAssets;

/**
 *
 * @author seb
 */
public class BronzeSpear extends Weapon {
    
    public BronzeSpear() {
        setName("Bronze Spear");
        setImage(ImageAssets.spear);
        
        setAttackDiceCount(2);
        setAttackDiceLimit(10);
        
        setDamageDiceCount(1);
        setDamageDiceLimit(8);
    }
    
}

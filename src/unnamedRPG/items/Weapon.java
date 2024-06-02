package unnamedRPG.items;

import java.awt.image.BufferedImage;

/**
 *
 * @author seb
 */
public class Weapon {
    
    private String name;
    private BufferedImage image;
    
    private int damageDiceCount;
    private int damageDiceLimit;
    
    private int attackDiceCount;
    private int attackDiceLimit;
    
    public Weapon (){
        
    }

    public String getName() {
        return name;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getDamageDiceCount() {
        return damageDiceCount;
    }

    public int getDamageDiceLimit() {
        return damageDiceLimit;
    }

    public int getAttackDiceCount() {
        return attackDiceCount;
    }

    public int getAttackDiceLimit() {
        return attackDiceLimit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setDamageDiceCount(int damageDiceCount) {
        this.damageDiceCount = damageDiceCount;
    }

    public void setDamageDiceLimit(int damageDiceLimit) {
        this.damageDiceLimit = damageDiceLimit;
    }

    public void setAttackDiceCount(int attackDiceCount) {
        this.attackDiceCount = attackDiceCount;
    }

    public void setAttackDiceLimit(int attackDiceLimit) {
        this.attackDiceLimit = attackDiceLimit;
    }
    
    
}

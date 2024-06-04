/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package unnamedRPG.model.entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import unnamedRPG.items.BronzeSpear;
import unnamedRPG.items.Weapon;

/**
 *
 * @author sdyma
 */
public class EntityTest {
    
    
    public EntityTest() {
        
    }
    Entity entity;
    Entity enemy;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        entity = new Ghoul("");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of staminaRegen method, of class Entity.
     */
    @Test
    public void testStaminaRegen() {
        System.out.println("Testing: void staminaRegen()");
        
        entity.maxStamina = 50;
        entity.currentStamina = 30;
        entity.staminaRegen = 5;
        
        entity.staminaRegen();
        assertEquals(35, entity.currentStamina);
        entity.staminaRegen();
        assertEquals(40, entity.currentStamina);
        entity.staminaRegen = 10;
        entity.staminaRegen();
        assertEquals(50, entity.currentStamina);
        entity.staminaRegen();
        assertEquals(50, entity.currentStamina);
        

    }
    
    /**
     * Test of attack method, of class Entity.
     */
    @Test
    public void testAttack() {
        System.out.println("Testing: String attack(Entity entity)");
        enemy = new Ghoul("");
        int startingHP = enemy.currentHP;
        for (int i = 0; i < 1000; i++) {
            entity.attack(enemy);
        }
        assertTrue("Enemy HP is lower than when started", enemy.currentHP < startingHP);
    }
    @Test
    public void testAttackOutputString() {
        System.out.println("Testing: String attack(Entity entity) output string");
        enemy = new Ghoul("");
        int messageCounter = 0;
                
        for (int i = 0; i < 10; i++) {
            String message = entity.attack(enemy);
            if (message.length() > 0)
                messageCounter++;
        }
        assertEquals(10, messageCounter);
    }
    
    /**
     * Test of equipWeapon method, of class Entity.
     */
    @Test
    public void testEquipWeapon() {
        System.out.println("Testing: void equipWeapon(Weapon weapon)");
        Weapon spear = new BronzeSpear();
        entity = new Ghoul("");
        entity.equipWeapon(spear);
        assertEquals(2, entity.attackDiceCount);
        assertEquals(10, entity.attackDiceLimit);
        assertEquals(1, entity.damageDiceCount);
        assertEquals(8, entity.damageDiceLimit);
        
        
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package unnamedRPG.display;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sdyma
 */
public class LimitsTest {

    private Limits limits;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    public void testVariablesOnInstantiation () {
        System.out.println("Testing: Variables on Instantiation.");
        limits = new Limits(0, 0, 10, 10);
        assertEquals(0, limits.getStartX());
        assertEquals(0, limits.getStartY());
        assertEquals(10, limits.getEndX());
        assertEquals(10, limits.getEndY());
        assertEquals(10, limits.getLengthX());
        assertEquals(10, limits.getLengthY());
        assertEquals(5, limits.getCenterX());
        assertEquals(5, limits.getCenterY());
    }
    
    /**
     * Test of shiftPosition method, of class Limits.
     */
    @Test
    public void testShiftPosition() {
        System.out.println("Testing: shiftPosition(char axis, magnitude)");
        limits = new Limits(0, 0, 10, 10);
        char axis = 'x';
        int amount = 5;
        limits.shiftPosition(axis, amount);
        assertEquals(5, limits.getStartX());
        assertEquals(15, limits. getEndX());
        assertEquals(0, limits.getStartY());
        assertEquals(10, limits. getEndY());
        assertEquals(15, limits. getLengthX());
        assertEquals(10, limits. getLengthY());
    }

    /**
     * Test of goTo method, of class Limits.
     */
    @Test
    public void testGoToInBounds() {
        System.out.println("goTo");
        limits = new Limits(0, 0, 10, 10);
        int x = 0;
        int y = 0;
        limits.goTo(x, y);
        assertEquals(0, limits.getStartX());
        assertEquals(0, limits.getStartY());
        assertEquals(10, limits.getEndX());
        assertEquals(10, limits.getEndY());
        assertEquals(10, limits.getLengthX());
        assertEquals(10, limits.getLengthY());
        assertEquals(5, limits.getCenterX());
        assertEquals(5, limits.getCenterY());
    }
    
    @Test
    public void testGoToOutOfBounds() {
        System.out.println("goTo");
        limits = new Limits(0, 0, 10, 10);
        int x = -5;
        int y = -10;
        limits.goTo(x, y);
        assertEquals(0, limits.getStartX());
        assertEquals(0, limits.getStartY());
        assertEquals(10, limits.getEndX());
        assertEquals(10, limits.getEndY());
        assertEquals(10, limits.getLengthX());
        assertEquals(10, limits.getLengthY());
        assertEquals(5, limits.getCenterX());
        assertEquals(5, limits.getCenterY());
    }
    
    /**
     * Test of resizeLimits method, of class Limits.
     */
    @Test
    public void testResizeLimits() {
        System.out.println("Testing: resizeLimits(int newLengthX, int newLengthY)");
        limits = new Limits(100, 100, 110, 110);
        
        int newLengthX = 20;
        int newLengthY = 20;
        limits.resizeLimits(newLengthX, newLengthY);
        
        assertEquals(95, limits.getStartX());
        assertEquals(95, limits.getStartY());   
        assertEquals(116, limits.getEndX());
        assertEquals(116, limits.getEndY());
    }
    
    public void testResizeLimitsOutOfBounds() {
        System.out.println("Testing: resizeLimits(int newLengthX, int newLengthY)");
        limits = new Limits(-5, -5, 5, 5);
        
        int newLengthX = 20;
        int newLengthY = 20;
        limits.resizeLimits(newLengthX, newLengthY);
        
        assertEquals(0, limits.getStartX());
        assertEquals(0, limits.getStartY());   
        assertEquals(21, limits.getEndX());
        assertEquals(21, limits.getEndY());
    }
    
}

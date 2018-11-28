/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop.Models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ChongJH
 */
public class AccessoryTest {
    
    Accessory instance = new Accessory();
    String name = "Decorative Red Gems";
    double price = 8.0;
            
    public AccessoryTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getAccessory method, of class Accessory.
     */
    @Test
    public void testGetAccessory() {
        System.out.println("getAccessory");
        instance.setAccessory(name);
        String expResult = name;
        String result = instance.getAccessory();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCost method, of class Accessory.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        instance.setCost(price);
        double expResult = price;
        double result = instance.getCost();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setAccessory method, of class Accessory.
     */
    @Test
    public void testSetAccessory() {
        System.out.println("setAccessory");
        String accessory = name;
        instance.setAccessory(accessory);
    }

    /**
     * Test of setCost method, of class Accessory.
     */
    @Test
    public void testSetCost() {
        System.out.println("setCost");
        double cost = price;
        instance.setCost(cost);
    }
    
}

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
public class FlowerTest {
    
    //test instances
    Flower instance = new Flower();
    String id = "FL001";
    String name = "Rose";
    int quantity = 100;
    double price = 7.0;
    
    
    public FlowerTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of setFlowerID method, of class Flower.
     */
    @Test
    public void testSetFlowerID() {
        System.out.println("setFlowerID");
        String flowerID = id;
        instance.setFlowerID(flowerID);
    }

    /**
     * Test of setFlowerName method, of class Flower.
     */
    @Test
    public void testSetFlowerName() {
        System.out.println("setFlowerName");
        String flowerName = name;
        instance.setFlowerName(flowerName);
    }

    /**
     * Test of setFlowerQty method, of class Flower.
     */
    @Test
    public void testSetFlowerQty() {
        System.out.println("setFlowerQty");
        int flowerQty = quantity;
        instance.setFlowerQty(flowerQty);
    }

    /**
     * Test of setFlowerPrice method, of class Flower.
     */
    @Test
    public void testSetFlowerPrice() {
        System.out.println("setFlowerPrice");
        double flowerPrice = price;
        instance.setFlowerPrice(flowerPrice);
    }
    
    /**
     * Test of getFlowerID method, of class Flower.
     */
    @Test
    public void testGetFlowerID() {
        System.out.println("getFlowerID");
        instance.setFlowerID(id);
        String result = instance.getFlowerID();
//
//        try {
//            assertNotNull(result);
//            assertTrue(result instanceof String);
//        } catch (Exception e) {
//            fail("Exception - result not String");
//        }

        String expResult = id;
        assertEquals(expResult, result);
    }

    /**
     * Test of getFlowerName method, of class Flower.
     */
    @Test
    public void testGetFlowerName() {
        System.out.println("getFlowerName");
        instance.setFlowerName(name);
        String result = instance.getFlowerName();
//        
//        try {
//            assertNotNull(result);
//            assertTrue(result instanceof String);
//        } catch (Exception e) {
//            fail("Exception - result not String");
//        }

        String expResult = name;
        assertEquals(expResult, result);
    }

    /**
     * Test of getFlowerQty method, of class Flower.
     */
    @Test
    public void testGetFlowerQty() {
        System.out.println("getFlowerQty");
        int expResult = quantity;
        instance.setFlowerQty(quantity);
        int result = instance.getFlowerQty();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getFlowerPrice method, of class Flower.
     */
    @Test
    public void testGetFlowerPrice() {
        System.out.println("getFlowerPrice");
        double expResult = price;
        instance.setFlowerPrice(price);
        double result = instance.getFlowerPrice();
        assertEquals(expResult, result, 0.1);
    }
}

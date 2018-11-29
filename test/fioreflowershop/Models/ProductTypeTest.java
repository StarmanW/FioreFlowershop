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
public class ProductTypeTest {
    
    ProductType instance = new ProductType();
    String id = "PT001";
    String name = "Fresh Flower";
    boolean hasAccessory = true;
    int minFlowerQty = 25;
    int maxFlowerQty = 50;
    
    public ProductTypeTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getProductTypeID method, of class ProductType.
     */
    @Test
    public void testGetProductTypeID() {
        System.out.println("getProductTypeID");
        instance.setProductTypeID(id);
        String expResult = id;
        String result = instance.getProductTypeID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductTypeID method, of class ProductType.
     */
    @Test
    public void testSetProductTypeID() {
        System.out.println("setProductTypeID");
        String productTypeID = id;
        instance.setProductTypeID(productTypeID);
    }

    /**
     * Test of getProductTypeName method, of class ProductType.
     */
    @Test
    public void testGetProductTypeName() {
        System.out.println("getProductTypeName");
        instance.setProductTypeName(name);
        String expResult = name;
        String result = instance.getProductTypeName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductTypeName method, of class ProductType.
     */
    @Test
    public void testSetProductTypeName() {
        System.out.println("setProductTypeName");
        String productTypeName = name;
        instance.setProductTypeName(productTypeName);
    }

    /**
     * Test of hasAccessory method, of class ProductType.
     */
    @Test
    public void testHasAccessory() {
        System.out.println("hasAccessory");
        instance.setHasAccessory(hasAccessory);
        boolean expResult = hasAccessory;
        boolean result = instance.hasAccessory();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHasAccessory method, of class ProductType.
     */
    @Test
    public void testSetHasAccessory() {
        System.out.println("setHasAccessory");
        boolean hasAccessory = this.hasAccessory;
        instance.setHasAccessory(hasAccessory);
    }

}

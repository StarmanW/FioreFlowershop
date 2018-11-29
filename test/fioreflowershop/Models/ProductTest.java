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
public class ProductTest {
    String id = "PD001";
    String name = "Wax Flower Bouquet";
    double price = 234.0;
    int quantity = 5;
    ProductType productType = new ProductType();
    Flower flowerType = new Flower();
    Accessory productAccessory = new Accessory();
    String productDescription = "A buquet of fresh Wax Flowers.";
    boolean inStock = true;
    FlowerArrangementStyle arrangementStyle = new FlowerArrangementStyle();
        
    Product instance = new Product();
    
    public ProductTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getProductID method, of class Product.
     */ 
    @Test
    public void testGetProductID() {
        System.out.println("getProductID");
        instance.setProductID(id);
        String expResult = id;
        String result = instance.getProductID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductID method, of class Product.
     */
    @Test
    public void testSetProductID() {
        System.out.println("setProductID");
        String productID = id;
        instance.setProductID(productID);
    }

    /**
     * Test of getProductName method, of class Product.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        instance.setProductName(name);
        String expResult = name;
        String result = instance.getProductName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductName method, of class Product.
     */
    @Test
    public void testSetProductName() {
        System.out.println("setProductName");
        String productName = name;
        instance.setProductName(productName);
    }

    /**
     * Test of getProductPrice method, of class Product.
     */
    @Test
    public void testGetProductPrice() {
        System.out.println("getProductPrice");
        instance.setProductPrice(price);
        double expResult = price;
        double result = instance.getProductPrice();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setProductPrice method, of class Product.
     */
    @Test
    public void testSetProductPrice() {
        System.out.println("setProductPrice");
        double productPrice = price;
        instance.setProductPrice(productPrice);
    }

    /**
     * Test of getProductQty method, of class Product.
     */
    @Test
    public void testGetProductQty() {
        System.out.println("getProductQty");
        instance.setProductQty(quantity);
        int expResult = quantity;
        int result = instance.getProductQty();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductQty method, of class Product.
     */
    @Test
    public void testSetProductQty() {
        System.out.println("setProductQty");
        int productQty = quantity;
        instance.setProductQty(productQty);
    }

    /**
     * Test of getProductType method, of class Product.
     */
    @Test
    public void testGetProductType() {
        System.out.println("getProductType");
        instance.setProductType(productType);
        ProductType expResult = productType;
        ProductType result = instance.getProductType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductType method, of class Product.
     */
    @Test
    public void testSetProductType() {
        System.out.println("setProductType");
        ProductType productType = this.productType;
        instance.setProductType(productType);
    }

    /**
     * Test of getFlowerType method, of class Product.
     */
    @Test
    public void testGetFlowerType() {
        System.out.println("getFlowerType");
        instance.setFlowerType(flowerType);
        Flower expResult = flowerType;
        Flower result = instance.getFlowerType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFlowerType method, of class Product.
     */
    @Test
    public void testSetFlowerType() {
        System.out.println("setFlowerType");
        Flower flowerType = this.flowerType;
        instance.setFlowerType(flowerType);
    }

    /**
     * Test of getproductAccessory method, of class Product.
     */
    @Test
    public void testGetProductAccessory() {
        System.out.println("getproductAccessory");
        instance.setProductAccessory(productAccessory);
        Accessory expResult = productAccessory;
        Accessory result = instance.getProductAccessory();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductAccessory method, of class Product.
     */
    @Test
    public void testsetProductAccessory() {
        System.out.println("setProductAccessory");
        Accessory productAccessory = this.productAccessory;
        instance.setProductAccessory(productAccessory);
    }
    
    /**
     * Test of getproductDescription method, of class Product.
     */
    @Test
    public void testGetProductDescription() {
        System.out.println("getproductDescription");
        instance.setProductDescription(productDescription);
        String expResult = productDescription;
        String result = instance.getProductDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductAccessory method, of class Product.
     */
    @Test
    public void testsetProductDescription() {
        System.out.println("setProductDescription");
        String productDescription = this.productDescription;
        instance.setProductDescription(productDescription);
    }

    /**
     * Test of isInStock method, of class Product.
     */
    @Test
    public void testIsInStock() {
        System.out.println("isInStock");
        instance.setInStock(inStock);
        boolean expResult = inStock;
        boolean result = instance.isInStock();
        assertEquals(expResult, result);
    }

    /**
     * Test of isInStockToString method, of class Product.
     */
    @Test
    public void testIsInStockToString() {
        System.out.println("isInStockToString");
        instance.setInStock(inStock);
        String expResult = "Yes";
        String result = instance.isInStockToString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInStock method, of class Product.
     */
    @Test
    public void testSetInStock() {
        System.out.println("setInStock");
        boolean inStock = this.inStock;
        instance.setInStock(inStock);
    }
    
}

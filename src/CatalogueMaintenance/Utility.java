/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatalogueMaintenance;

import fioreflowershop.Models.Flower;
import fioreflowershop.Models.Product;
import fioreflowershop.Models.ProductType;
import fioreflowershop.Models.Catalogue;
import fioreflowershop.Models.PromotionCatalogue;
import fioreflowershop.Models.ItemList;

import java.util.Scanner;
/**
 *
 * @author ChongJH
 */
public class Utility {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static ItemList<Flower> generateFlowerList() {
        ItemList<Flower> flowerList = new ItemList<>();
        
        flowerList.add(new Flower("F001", "Rose", 100, 7.0));
        flowerList.add(new Flower("F002", "Baby's Breath", 0, 7.8));
        flowerList.add(new Flower("F003", "Wax Flower", 50, 7.8));
        flowerList.add(new Flower("F004", "Lily Asiatic", 67, 7.2));
        flowerList.add(new Flower("F005", "Dahlia", 20, 21.0));
        
        return flowerList;
    }
    
    public static ItemList<ProductType> generateProductTypeList() {
        ItemList<ProductType> productTypeList = new ItemList<>();
        
        productTypeList.add(new ProductType(productTypeID, productTypeName, 0, 0));
        productTypeList.add(new ProductType(productTypeID, productTypeName, 0, 0));
        productTypeList.add(new ProductType(productTypeID, productTypeName, 0, 0));
        
        return null;
    }   
    
    public static ItemList<Product> generateCatalogue() {
        ItemList<Product> catalogue = new ItemList<>();
        
        catalogue.add(new Product(productID, productName, 0, 0, productType, true, arrangementStyle));
        catalogue.add(new Product(productID, productName, 0, 0, productType, true, arrangementStyle));
        catalogue.add(new Product(productID, productName, 0, 0, productType, true, arrangementStyle));
        
        return null;
    }
}

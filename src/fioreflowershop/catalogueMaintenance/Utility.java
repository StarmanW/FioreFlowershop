/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop.CatalogueMaintenance;

import fioreflowershop.Models.Flower;
import fioreflowershop.Models.Product;
import fioreflowershop.Models.ProductType;
import fioreflowershop.Models.Catalogue;
import fioreflowershop.Models.PromotionCatalogue;
import fioreflowershop.Models.ArrayList;
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
        
        flowerList.add(new Flower("FL001", "Rose", 100, 7.0));
        flowerList.add(new Flower("FL002", "Baby's Breath", 0, 7.8));
        flowerList.add(new Flower("FL003", "Wax Flower", 50, 7.8));
        flowerList.add(new Flower("FL004", "Lily Asiatic", 67, 7.2));
        flowerList.add(new Flower("FL005", "Dahlia", 20, 21.0));
        
        return flowerList;
    }
    
    public static ArrayList<ProductType> generateProductTypeList() {
        ArrayList<ProductType> productTypeList = new ArrayList<>();
        
        productTypeList.add(new ProductType("PT001", "Fresh Flower", 1, 1));
        productTypeList.add(new ProductType("PT002", "Flower Bouquet", 25, 50));
        productTypeList.add(new ProductType("PT003", "Flower Arrangement", 50, 100));
        
        return productTypeList;
    }   
    
    public static ArrayList<Product> generateCatalogue() {
        ArrayList<Product> catalogue = new ArrayList<>();
        
        catalogue.add(new Product("PD001", "Fresh Rose", 7.0, 10, new ProductType("PT001", "Fresh Flower", 1, 1), new Flower("FL001", "Rose", 100, 7.0), true, null));
        catalogue.add(new Product("PD002", "Wax Flower Bouquet", 234.0, 5, new ProductType("PT002", "Flower Bouquet", 25, 50), new Flower("FL003", "Wax Flower", 50, 7.8), true, null));
        
        return catalogue;
    }
    
    public static boolean mainMenu() {
        String selection = "";
        boolean choice = false;
        
        while (true) {
            System.out.print("Add a product? (y/n): ");
            
            selection = sc.nextLine().toLowerCase();
            if (selection.matches("^[y/n]$")) {
                
                if (selection.equals("y")) 
                    choice = true;
                
                break;
            }
            
            System.out.println("Please enter a valid choice.(y/n)\n");
        }
         
        return choice;
    }
    
    public static String enterProductName() {
        String productName = "";
        
        while(true) {
            System.out.print("Enter product name: ");
            productName = sc.nextLine();
            
            if(!productName.equals(""))
                break;
                
            System.out.println("Product name cannot be empty.\nPlease enter a product name.\n");
        }
        
        return productName;
    }
    
    public static double enterProductPrice() {
        String productPrice = "";
        
        while (true) {            
            System.out.print("Enter product price: ");
            productPrice = sc.nextLine();
            
            if (productPrice.matches("^\\d+(,\\d{3})*(\\.\\d{1,2})?$")) 
                break;
            
            System.out.println("Please enter a valid product price. (E.g - 123.00)\n");
        }
        
        return Double.parseDouble(productPrice);
    }
    
    public static int enterProductQty() {
        String productQty = "";
        
        while (true) {            
            System.out.print("Enter product quantity: ");
            productQty = sc.nextLine();
            
            if (productQty.matches("^([\\d])+$"))
                break;
            
            System.out.println("Please enter a valid product quantity. (E.g. - 10)\n");
        }
        
        return Integer.parseInt(productQty);
    }
    
    public static ProductType enterProductType(ArrayList<ProductType> producTypeList) {
        ProductType selectedProductType = null;
        String selection = "";
        int selectionNumber = 0;
        int totalEntries = producTypeList.getTotalEntries();
        
        while (true) {            
            System.out.println("=== Product Type ===");
            for (int i = 0; i < producTypeList.getTotalEntries(); i++){
                ProductType tmpProductType = producTypeList.get(i);
                System.out.println(String.format("%d. %s", i + 1, tmpProductType.getProductTypeName()));
            }
            System.out.print("\nChoose a product type: ");
            selection = sc.nextLine();
            
            selectionNumber = stringToInt(selection);
            if(selectionNumber != -1 && selectionNumber <= totalEntries){
                selectedProductType = producTypeList.get(selectionNumber - 1);
                break;
            }

            System.out.println("Please enter a valid number. (1 to " + totalEntries + ")\n");
        }
        
        return selectedProductType;
    }
    
    public static Flower enterFlowerType(ItemList<Flower> flowerList) {
        Flower selectedFlowerType = null;
        String selection = "";
        int selectionNumber = 0;
        int totalEntries = flowerList.getTotalEntries();
        
        while (true) {            
            System.out.println("=== Flower Type ===");
            for (int i = 0; i < flowerList.getTotalEntries(); i++){
                Flower tmpFlowertype = (Flower) flowerList.get(i);
                System.out.println(String.format("%d. %s", i + 1, tmpFlowertype.getFlowerName()));
            }
            System.out.print("\nChoose a flower type: ");
            selection = sc.nextLine();

            selectionNumber = stringToInt(selection);
            if(selectionNumber != -1 && selectionNumber <= totalEntries){
                selectedFlowerType = (Flower) flowerList.get(selectionNumber - 1);
                break;
            }
    
            System.out.println("Please enter a valid number. (1 to " + totalEntries + ")\n");
        }
        
        return selectedFlowerType;
    }
    
    public static String generateProductID(int productListEntries) {
        String productID = "";
        
        productID = "PD" + String.format("%03d", productListEntries + 1);
        
        return productID;
    }
    
    public static int stringToInt(String str) {
        int i = 0;
        
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return- 1;
        }
        
        return i;
    }
}

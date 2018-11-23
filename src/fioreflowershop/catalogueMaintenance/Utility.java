/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop.CatalogueMaintenance;

import fioreflowershop.Models.Flower;
import fioreflowershop.Models.Product;
import fioreflowershop.Models.ProductType;
import fioreflowershop.Models.Accessory;
import fioreflowershop.Models.ItemList;
import fioreflowershop.ADT.ArrayLList;
import fioreflowershop.ADT.ListInterface;

import java.util.Scanner;
/**
 *
 * @author ChongJH
 */
public class Utility {
    
    private static Scanner sc = new Scanner(System.in);
    
    //create and initialize flower list with dummy values
    public static ItemList<Flower> generateFlowerList() {
        ItemList<Flower> flowerList = new ItemList<>();
        
        flowerList.add(new Flower("FL001", "Rose", 100, 7.0));
        flowerList.add(new Flower("FL002", "Baby's Breath", 0, 7.8));
        flowerList.add(new Flower("FL003", "Wax Flower", 50, 7.8));
        flowerList.add(new Flower("FL004", "Lily Asiatic", 67, 7.2));
        flowerList.add(new Flower("FL005", "Dahlia", 20, 21.0));
        
        return flowerList;
    }
    
    //create and initialize product type list with dummy values
    public static ListInterface<ProductType> generateProductTypeList() {
        ListInterface<ProductType> productTypeList = new ArrayLList<>();
        
        productTypeList.add(new ProductType("PT001", "Fresh Flower", false, 1, 1));
        productTypeList.add(new ProductType("PT002", "Flower Bouquet", true, 25, 50));
        productTypeList.add(new ProductType("PT003", "Flower Arrangement", true, 50, 100));
        
        return productTypeList;
    }   
    
    //create and initialize catalogue(list of products) with dummy values
    public static ListInterface<Product> generateCatalogue() {
        ListInterface<Product> catalogue = new ArrayLList<>();
        
        catalogue.add(new Product("PD001", "Fresh Rose", 7.0, 10, new ProductType("PT001", "Fresh Flower", false, 1, 1), new Flower("FL001", "Rose", 100, 7.0), null, true, null));
        catalogue.add(new Product("PD002", "Wax Flower Bouquet", 234.0, 5, new ProductType("PT002", "Flower Bouquet", true, 25, 50), new Flower("FL003", "Wax Flower", 50, 7.8), null, true, null));
        
        return catalogue;
    }
    
    //create and initialize accessory list with dummy values
    public static ListInterface<Accessory> generateAccessoryList() {
        ListInterface<Accessory> accessoryList = new ArrayLList<>();
        
        accessoryList.add(new Accessory("Decorative Red Gems", 8.0));
        accessoryList.add(new Accessory("Red Stones", 5.0));
        accessoryList.add(new Accessory("Wrapping Paper", 5.0));
        
        return accessoryList;
    }
    
    public static boolean mainMenu() {
        String selection = "";
        boolean choice = false;
        
        //repeat while entered value is invalid
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
        
        //repeat while entered value is invalid
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
        
        //repeat while entered value is invalid
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
        
        //repeat while entered value is invalid
        while (true) {            
            System.out.print("Enter product quantity: ");
            productQty = sc.nextLine();
            
            if (productQty.matches("^([\\d])+$"))
                break;
            
            System.out.println("Please enter a valid product quantity. (E.g. - 10)\n");
        }
        
        return Integer.parseInt(productQty);
    }
    
    public static ProductType enterProductType(ListInterface<ProductType> producTypeList) {
        ProductType selectedProductType = null;
        String selection = "";
        int selectionInt = 0;
        int totalEntries = producTypeList.size();
        
        //repeat while entered value is invalid
        while (true) {            
            //display list of available product types
            System.out.println("=== Product Type ===");
            for (int i = 0; i < totalEntries; i++){
                ProductType tmpProductType = producTypeList.get(i);
                System.out.println(String.format("%d. %s", i + 1, tmpProductType.getProductTypeName()));
            }
            
            System.out.print("\nChoose a product type: ");
            selection = sc.nextLine();
            
            //try parse entered value into int
            selectionInt = stringToInt(selection);
            
            if(selectionInt != -1 && selectionInt <= totalEntries){
                selectedProductType = producTypeList.get(selectionInt - 1);
                break;
            }

            System.out.println("Please enter a valid number. (1 to " + totalEntries + ")\n");
        }
        
        return selectedProductType;
    }
    
    public static Flower enterFlowerType(ItemList<Flower> flowerList) {
        Flower selectedFlowerType = null;
        String selection = "";
        int selectionInt = 0;
        int totalEntries = flowerList.size();
        
        //repeat while entered value is invalid
        while (true) {            
            //display list of available flower types
            System.out.println("=== Flower Type ===");
            for (int i = 0; i < totalEntries; i++){
                Flower tmpFlowertype = (Flower) flowerList.get(i);
                System.out.println(String.format("%d. %s", i + 1, tmpFlowertype.getFlowerName()));
            }
            
            System.out.print("\nChoose a flower type: ");
            selection = sc.nextLine();

            //try parse entered value into int
            selectionInt = stringToInt(selection);
            if(selectionInt != -1 && selectionInt <= totalEntries){
                selectedFlowerType = (Flower) flowerList.get(selectionInt - 1);
                break;
            }
    
            System.out.println("Please enter a valid number. (1 to " + totalEntries + ")\n");
        }
        
        return selectedFlowerType;
    }
    
    public static ListInterface<Accessory> enterProductAccessory(ProductType productType, ListInterface<Accessory> accessoryList) {
        ListInterface<Accessory> selectedAccessoryList = new ArrayLList<>();
        String selection = "";
        int selectionInt = 0;
        int totalEntries = accessoryList.size();
        
        if (productType.hasAccessory() == true) {
            //repeat while entered value is invalid
            while (true) {
                //display list of available accessory types
                System.out.println("=== Product Accessory ===");
                for (int i = 0; i < totalEntries; i++) {
                    Accessory tmpProductAccessory = accessoryList.get(i);
                    System.out.println(String.format("%d. %s", i + 1, tmpProductAccessory.getAccessory()));
                }

                System.out.print("\nChoose a flower type: ");
                selection = sc.nextLine();

                //try parse entered value into int
                selectionInt = stringToInt(selection);
                if (selectionInt != -1 && selectionInt <= totalEntries) {
                    selectedAccessoryList.add(accessoryList.get(selectionInt - 1));
                    break;
                }

                System.out.println("Please enter a valid number. (1 to " + totalEntries + ")\n");
            }
        } 
            
        return selectedAccessoryList;
    }
    
    //auto generate product ID
    public static String generateProductID(int productListEntries) {
        String productID = "";
        
        productID = "PD" + String.format("%03d", productListEntries + 1);
        
        return productID;
    }
    
    //try parse string into int. Returns -1 if not parseble
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

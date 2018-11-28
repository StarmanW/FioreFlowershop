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
import fioreflowershop.ADT.ItemList;
import fioreflowershop.ADT.ArrayLList;
import fioreflowershop.ADT.ListInterface;
import fioreflowershop.Models.FlowerArrangementStyle;

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
        
//        repeat while entered value is invalid
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
    
    public static void mainMenuNew(
            ItemList<Flower> flowerList, ListInterface<ProductType> productTypeList, 
            ListInterface<Accessory> accessoryList, ListInterface<Product> catalogue,
            boolean INITIAL_STOCK_STATUS, FlowerArrangementStyle INITIAL_FLOWER_ARRANGEMENT_STYLE
    ) {
        String selection = "";
            
            System.out.println(
                    "=== Catalogue Maintenance ===\n" + 
                    "1. Display Catalogue\n" + 
                    "2. Edit Catalogue\n" + 
                    "3. Display Promotion Catalogue\n" + 
                    "4. Edit Promotion Catalogue\n"
            );
            System.out.print("Please enter a choice: ");
            
            selection = sc.nextLine();
            
            switch (selection) {
                case "1":
                    displayCatalogue(catalogue);
                    break;
                case "2":
                    editCatalogueMenu(
                            flowerList, productTypeList, accessoryList, catalogue,
                            INITIAL_STOCK_STATUS, INITIAL_FLOWER_ARRANGEMENT_STYLE
                    );
                    break;
                case "3":
                    //display Promotional Catalogue
                    break;
                case "4":
                    //Display edit promo catalogue menu
                    break;
                default:
                    System.out.println("\n\nPlease enter a valid choice.\n");
                    mainMenuNew(
                            flowerList, productTypeList, accessoryList, catalogue,
                            INITIAL_STOCK_STATUS, INITIAL_FLOWER_ARRANGEMENT_STYLE
                    );
                    break;
            }
    }
    
    public static void editCatalogueMenu(
            ItemList<Flower> flowerList, ListInterface<ProductType> productTypeList, 
            ListInterface<Accessory> accessoryList, ListInterface<Product> catalogue,
            boolean INITIAL_STOCK_STATUS, FlowerArrangementStyle INITIAL_FLOWER_ARRANGEMENT_STYLE
    ) {
        String selection = "";
        
        System.out.println(
                "\n=== Edit Catalogue ===\n" +
                "1. Add Product\n" +
                "2. Delete Product\n" +
                "3. Mark Product Out Of Stock\n"
        );
        System.out.print("Please enter a choice: ");
        
        selection = sc.nextLine();
        
        switch (selection) {
            case "1":
                addProduct(
                        flowerList, productTypeList, accessoryList, catalogue,
                        INITIAL_STOCK_STATUS, INITIAL_FLOWER_ARRANGEMENT_STYLE
                );
                break;
            case "2":
                //remove product
                break;
            case "3":
                //mark product
                break;
            default:
                System.out.println("\n\nPlease enter a valid choice.\n");
                editCatalogueMenu(
                        flowerList, productTypeList, accessoryList, catalogue,
                        INITIAL_STOCK_STATUS, INITIAL_FLOWER_ARRANGEMENT_STYLE
                );
                break;
        }
    }
    
    public static void displayCatalogue(ListInterface<Product> catalogue) {
        System.out.println(
                "\n===================================\n" +
                "=== Fiore Flower Shop Catalogue ===\n" +
                "===================================\n" + 
                String.format(
                        "| %3s | %-6s | %-30s | %-30s | %-30s | %-30s | %9s | %6s | %3s |", 
                        "No.", "ID", "Product Type", "Product Name", "Flower Type", "Product Accessorry", "Price", "Quantity Left", "In Stock"
                )
        );
        
        for (int i = 0; i < catalogue.size(); i++) {
            Product tmpProduct = catalogue.get(i);
            
            int productNumber = i + 1;
            String productID = tmpProduct.getProductID();
            String productName = tmpProduct.getProductName();
            String productType = tmpProduct.getProductType().getProductTypeName();
            String productFlower = tmpProduct.getFlowerType().getFlowerName();
            boolean productHasStock = tmpProduct.isInStock();
            String productHasStockText = tmpProduct.isInStockToString();
            
            //SWITCH TO SINGLE OBJECT INSTEAD OF LIST?
            ListInterface<Accessory> productAccessoryList = tmpProduct.getProductAccessoryList();
            //TEMPORARY. NEED TO MAKE ITERATOR
            String productAccessoryText = "";
            try {
                productAccessoryText = productAccessoryList.get(0).getAccessory();
            } catch (NullPointerException e) {
                productAccessoryText = "None";
            }
            
            double productPrice = tmpProduct.getProductPrice();
            int productQuantity = tmpProduct.getProductQty();
            
            System.out.println(
                    String.format(
                            "| %3d | %-6s | %-30.30s | %-30.30s | %-30.30s | %-30.30s | %9.2f | %13d | %-8s |", 
                            productNumber, productID, productName, productType,
                            productFlower, productAccessoryText, productPrice, 
                            productQuantity, productHasStockText
                    )
            );
            
        }
    }
    
    public static void addProduct(
            ItemList<Flower> flowerList, ListInterface<ProductType> productTypeList, 
            ListInterface<Accessory> accessoryList, ListInterface<Product> catalogue,
            boolean INITIAL_STOCK_STATUS, FlowerArrangementStyle INITIAL_FLOWER_ARRANGEMENT_STYLE
    ) {
        String viewCatalogueSelection = "";
        String productID = "";
        String productName = "";
        double productPrice = 0.0;
        int productQty = 0;
        ProductType productType = null;
        ListInterface<Accessory> productAccessoryList = null;
        Flower productFlower = null;
        boolean productInStock = INITIAL_STOCK_STATUS;
        FlowerArrangementStyle flowerArrangementStyle = INITIAL_FLOWER_ARRANGEMENT_STYLE;
        
        productID = Utility.generateProductID(catalogue.size());
        productName = Utility.enterProductName();
        productPrice = Utility.enterProductPrice();
        productQty = Utility.enterProductQty();
        productType = Utility.enterProductType(productTypeList);
        productAccessoryList = Utility.enterProductAccessory(productType, accessoryList);
        productFlower = Utility.enterFlowerType(flowerList);
        catalogue.add(new Product(productID, productName, productPrice, productQty, productType, productFlower, productAccessoryList, productInStock, flowerArrangementStyle));
    
        System.out.print("Would you like to display catalogue? (y/n)");
        viewCatalogueSelection = sc.nextLine().toLowerCase();
        
        if (viewCatalogueSelection.equals("y")) {
            displayCatalogue(catalogue);
        }
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
            System.out.println("\n=== Product Type ===");
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

                System.out.print("\nChoose a product accessory: ");
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

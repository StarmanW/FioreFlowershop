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
import fioreflowershop.ADT.LList;
import fioreflowershop.ADT.ListInterface;

import java.util.Scanner;

/**
 *
 * @author ChongJH
 */
public class Utility {

    private static Scanner sc = new Scanner(System.in);

    //create and initialize flower list with dummy values
    public static ListInterface<Flower> generateFlowerList() {
        ListInterface<Flower> flowerList = new LList<>();

        flowerList.add(new Flower("FL001", "Rose", 100, 7.0));
        flowerList.add(new Flower("FL002", "Baby's Breath", 0, 7.8));
        flowerList.add(new Flower("FL003", "Wax Flower", 50, 7.8));
        flowerList.add(new Flower("FL004", "Lily Asiatic", 67, 7.2));
        flowerList.add(new Flower("FL005", "Dahlia", 20, 21.0));

        return flowerList;
    }

    //create and initialize product type list with dummy values
    public static ListInterface<ProductType> generateProductTypeList() {
        ListInterface<ProductType> productTypeList = new LList<>();

        productTypeList.add(new ProductType("PT001", "Fresh Flower", false));
        productTypeList.add(new ProductType("PT002", "Flower Bouquet", true));
        productTypeList.add(new ProductType("PT003", "Flower Arrangement", true));

        return productTypeList;
    }

    //create and initialize accessory list with dummy values
    public static ListInterface<Accessory> generateAccessoryList() {
        ListInterface<Accessory> accessoryList = new LList<>();

        accessoryList.add(new Accessory("Decorative Red Gems", 8.0));
        accessoryList.add(new Accessory("Red Stones", 5.0));
        accessoryList.add(new Accessory("Wrapping Paper", 5.0));

        return accessoryList;
    }

    //create and initialize catalogue(list of products) with dummy values
    public static ListInterface<Product> generateCatalogue(
            ListInterface<Flower> flowerList, ListInterface<ProductType> productTypeList,
            ListInterface<Accessory> accessoryList
    ) {
        ListInterface<Product> catalogue = new LList<>();

        catalogue.add(new Product("PD001", "Fresh Rose", 7.0, 10, productTypeList.get(0), flowerList.get(0), null, "Fresh red rose sourced locally.", true));
        catalogue.add(new Product("PD002", "Wax Flower Bouquet", 234.0, 5, productTypeList.get(1), flowerList.get(1), accessoryList.get(1), "A bouquet of fresh wax flowers.", true));

        return catalogue;
    }

    public static void mainMenu(
            ListInterface<Flower> flowerList, ListInterface<ProductType> productTypeList,
            ListInterface<Accessory> accessoryList, ListInterface<Product> catalogue,
            boolean INITIAL_STOCK_STATUS
    ) {
//        for (String tryAgain = ""; !tryAgain.equals("n");) {
//            tryAgain = "y";
//
//            for (boolean endLoop = false; !endLoop;) {
                chooseMainMenuOption(catalogue, flowerList, productTypeList, accessoryList, INITIAL_STOCK_STATUS);

//                System.out.print("\nWould you like to do anything else? (y/n) ");
//                tryAgain = sc.nextLine().toLowerCase();
//
//                if (tryAgain.matches("([yn])")) {
//                    endLoop = true;
//                } else {
//                    System.out.println("\nPlease enter a valid option.");
//                }
//            }
//        }

    }

    private static void chooseMainMenuOption(
            ListInterface<Product> catalogue, ListInterface<Flower> flowerList,
            ListInterface<ProductType> productTypeList, ListInterface<Accessory> accessoryList,
            boolean INITIAL_STOCK_STATUS) {
        for (boolean endLoop = false; !endLoop;) {
            String selection = "";

            System.out.println(
                    "\n=============================\n"
                    + "=== Catalogue Maintenance ===\n"
                    + "=============================\n"
                    + "1. Display Catalogue\n"
                    + "2. Edit Catalogue\n"
                    + "3. Display Promotion Catalogue\n"
                    + "4. Edit Promotion Catalogue\n"
                    + "x. Exit system.\n"
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
                            INITIAL_STOCK_STATUS
                    );
                    break;
                case "3":
                    //display Promotional Catalogue
                    break;
                case "4":
                    //Display edit promo catalogue menu
                    break;
                case "x":
                    endLoop = true;
                    break;
                default:
                    System.out.println("\n\nPlease enter a valid choice.\n");
                    break;
            }
        }
    }

    public static void editCatalogueMenu(
            ListInterface<Flower> flowerList, ListInterface<ProductType> productTypeList,
            ListInterface<Accessory> accessoryList, ListInterface<Product> catalogue,
            boolean INITIAL_STOCK_STATUS
    ) {
//        for (String cont = ""; !cont.equals("x");) {
//            cont = "c";

//            for (boolean endLoop = false; !endLoop;) {
                chooseEditCatalogueOption(flowerList, productTypeList, accessoryList, catalogue, INITIAL_STOCK_STATUS);

//                System.out.print("\nc - continue\nx - back");
//                cont = sc.nextLine().toLowerCase();
//
//                if (cont.matches("([xn])")) {
//                    endLoop = true;
//                } else {
//                    System.out.println("\nPlease enter a valid option.");
//                }
//            }
//        }
    }

    private static void chooseEditCatalogueOption(
            ListInterface<Flower> flowerList, ListInterface<ProductType> productTypeList,
            ListInterface<Accessory> accessoryList, ListInterface<Product> catalogue,
            boolean INITIAL_STOCK_STATUS) {
        for (boolean endLoop = false; !endLoop;) {
            String selection = "";

            System.out.println(
                    "\n=== Edit Catalogue ===\n"
                    + "1. Add Product\n"
                    + "2. Delete Product\n"
                    + "x. Back\n"
            );
            System.out.print("Please enter a choice: ");

            selection = sc.nextLine();

            switch (selection) {
                case "1":
                    addProduct(
                            flowerList, productTypeList, accessoryList, catalogue,
                            INITIAL_STOCK_STATUS
                    );
                    break;
                case "2":
                    removeProduct(catalogue);
                    break;
                case "x":
                    endLoop = true;
                    break;
                default:
                    System.out.println("\n\nPlease enter a valid choice.\n");
                    break;
            }
        }
    }

    public static void displayCatalogue(ListInterface<Product> catalogue) {
        System.out.println(
                "\n===================================\n"
                + "=== Fiore Flower Shop Catalogue ===\n"
                + "==================================="
        );

        displayProductList(catalogue);
        promptEnterToContinue();
    }

    private static void promptEnterToContinue() {
        System.out.println("\nPress Enter to continue.");
        sc.nextLine();
    }

    private static void displayProductList(ListInterface<Product> catalogue) {
        if (catalogue.isEmpty()) {
            System.out.println("\nNo products available currently.");
        } else {
            System.out.println(
                    String.format(
                            "\n| %3s | %-25s | %-30s | %-25s | %-25s | %9s | %-10s | %-80s |",
                            "No.", "Product Type", "Product Name", "Flower Type", "Product Accessorry", "Price", "In Stock", "Description"
                    )
            );

            for (int i = 0; i < catalogue.size(); i++) {
                Product tmpProduct = catalogue.get(i);

                int productNumber = i + 1;
                String productName = tmpProduct.getProductName();
                String productType = tmpProduct.getProductType().getProductTypeName();
                String productFlower = tmpProduct.getFlowerType().getFlowerName();
                String productHasStockText = tmpProduct.isInStockToString();
                int productStockNum = tmpProduct.getProductQty();
                double productPrice = tmpProduct.getProductPrice();
                String productDescription = tmpProduct.getProductDescription();

                Accessory productAccessory = tmpProduct.getProductAccessory();
                //TEMPORARY. NEED TO MAKE ITERATOR
                String productAccessoryText = "";
                try {
                    productAccessoryText = productAccessory.getAccessory();
                } catch (NullPointerException e) {
                    productAccessoryText = "None";
                }

                System.out.println(
                        String.format(
                                "| %3d | %-25.25s | %-30.30s | %-25.25s | %-25.25s | %9.2f | %s - %-4s | %-80s |",
                                productNumber, productName, productType,
                                productFlower, productAccessoryText, productPrice,
                                productHasStockText, productStockNum, productDescription
                        )
                );
            }
        }
    }

    public static void displayProductListShort(ListInterface<Product> catalogue) {
        if (catalogue.isEmpty()) {
            System.out.println("\nNo products available currently.");
        } else {
            System.out.println(
                    "\n=====================\n"
                    + "=== Product Stock ===\n"
                    + "=====================\n"
                    + String.format(
                            "\n| %3s | %-25s | %-30s | %-25s | %-10s |",
                            "No.", "Product Type", "Product Name", "Flower Type", "In Stock"
                    )
            );

            for (int i = 0; i < catalogue.size(); i++) {
                Product tmpProduct = catalogue.get(i);

                int productNumber = i + 1;
                String productName = tmpProduct.getProductName();
                String productType = tmpProduct.getProductType().getProductTypeName();
                String productFlower = tmpProduct.getFlowerType().getFlowerName();
                String productHasStockText = tmpProduct.isInStockToString();
                int productStockNum = tmpProduct.getProductQty();

                System.out.println(
                        String.format(
                                "| %3d | %-25.25s | %-30.30s | %-25.25s | %s - %-4s |",
                                productNumber, productType, productName,
                                productFlower, productHasStockText, productStockNum
                        )
                );
            }
        }
    }

    public static boolean addProduct(
            ListInterface<Flower> flowerList, ListInterface<ProductType> productTypeList,
            ListInterface<Accessory> accessoryList, ListInterface<Product> catalogue,
            boolean INITIAL_STOCK_STATUS
    ) {
        String productID = "";
        String productName = "";
        double productPrice = 0.0;
        int productQty = 0;
        ProductType productType = null;
        Accessory productAccessory = null;
        String productDescription = "";
        Flower productFlower = null;
        boolean productInStock = INITIAL_STOCK_STATUS;
        boolean addStatus = false;

        productID = Utility.generateProductID(catalogue.size());
        productName = Utility.enterProductName();
        productPrice = Utility.enterProductPrice();
        productQty = Utility.enterProductQty();
        productType = Utility.enterProductType(productTypeList);
        productAccessory = Utility.enterProductAccessory(productType, accessoryList);
        productFlower = Utility.enterFlowerType(flowerList);
        productDescription = Utility.enterProductDescription();
        addStatus = catalogue.add(new Product(productID, productName, productPrice, productQty, productType, productFlower, productAccessory, productDescription, productInStock));

        promptDisplayCatalogue(catalogue);

        return addStatus;
    }

    private static void promptDisplayCatalogue(ListInterface<Product> catalogue) {
        String viewCatalogueSelection = "";

        System.out.print("Would you like to display product list? (y/n)");
        viewCatalogueSelection = sc.nextLine().toLowerCase();
        if (viewCatalogueSelection.equals("y")) {
            displayCatalogue(catalogue);
        }
    }

    public static boolean removeProduct(ListInterface<Product> catalogue) {
        boolean removeStatus = false;

        if (!catalogue.isEmpty()) {
            String selection = "";
            int selectionIndex = -1;

            for (boolean endLoop = false; !endLoop;) {
                displayProductList(catalogue);
                System.out.print("\nSelect a product to remove: ");
                selection = sc.nextLine();

                selectionIndex = stringToInt(selection) - 1;
                if (selectionIndex >= 0) {
                    removeStatus = catalogue.remove(selectionIndex);
                    endLoop = true;
                } else {
                    System.out.println("\nPlease enter a valid selection (1 - " + catalogue.size() + ")");
                }
            }

            promptDisplayCatalogue(catalogue);
        }

        return removeStatus;
    }

    public static String enterProductName() {
        String productName = "";

        //repeat while entered value is invalid
        while (true) {
            System.out.print("Enter product name: ");
            productName = sc.nextLine();

            if (!productName.equals("")) {
                break;
            }

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

            if (productPrice.matches("^\\d+(,\\d{3})*(\\.\\d{1,2})?$")) {
                break;
            }

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

            if (productQty.matches("^([\\d])+$")) {
                break;
            }

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
            for (int i = 0; i < totalEntries; i++) {
                ProductType tmpProductType = producTypeList.get(i);
                System.out.println(String.format("%d. %s", i + 1, tmpProductType.getProductTypeName()));
            }

            System.out.print("\nChoose a product type: ");
            selection = sc.nextLine();

            //try parse entered value into int
            selectionInt = stringToInt(selection);

            if (selectionInt != -1 && selectionInt <= totalEntries) {
                selectedProductType = producTypeList.get(selectionInt - 1);
                break;
            }

            System.out.println("Please enter a valid number. (1 to " + totalEntries + ")\n");
        }

        return selectedProductType;
    }

    public static Flower enterFlowerType(ListInterface<Flower> flowerList) {
        Flower selectedFlowerType = null;
        String selection = "";
        int selectionInt = 0;
        int totalEntries = flowerList.size();

        //repeat while entered value is invalid
        while (true) {
            //display list of available flower types
            System.out.println("=== Flower Type ===");
            for (int i = 0; i < totalEntries; i++) {
                Flower tmpFlowertype = (Flower) flowerList.get(i);
                System.out.println(String.format("%d. %s", i + 1, tmpFlowertype.getFlowerName()));
            }

            System.out.print("\nChoose a flower type: ");
            selection = sc.nextLine();

            //try parse entered value into int
            selectionInt = stringToInt(selection);
            if (selectionInt != -1 && selectionInt <= totalEntries) {
                selectedFlowerType = (Flower) flowerList.get(selectionInt - 1);
                break;
            }

            System.out.println("Please enter a valid number. (1 to " + totalEntries + ")\n");
        }

        return selectedFlowerType;
    }

    public static Accessory enterProductAccessory(
            ProductType productType, ListInterface<Accessory> accessoryList
    ) {
        Accessory selectedAccessory = null;
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
                    selectedAccessory = accessoryList.get(selectionInt - 1);
                    break;
                }

                System.out.println("Please enter a valid number. (1 to " + totalEntries + ")\n");
            }
        }

        return selectedAccessory;
    }

    public static String enterProductDescription() {
        String productDescription = "";

        System.out.print("\nEnter product description: ");
        productDescription = sc.nextLine();

        return productDescription;
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
            return - 1;
        }

        return i;
    }
}

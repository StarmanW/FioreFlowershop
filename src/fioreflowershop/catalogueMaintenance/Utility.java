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
import fioreflowershop.Models.PromotionCatalogue;
import java.time.Month;
import java.util.Scanner;

/**
 *
 * @author ChongJH
 */
public class Utility {

    public static Scanner sc = new Scanner(System.in);

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

        catalogue.add(
                new Product(
                        "PD001", "Fresh Rose", 7.0, 10, productTypeList.get(2),
                        flowerList.get(3), null, "Fresh red rose sourced locally.",
                        true, false
                )
        );
        catalogue.add(
                new Product(
                        "PD002", "Wax Flower Bouquet", 234.0, 5, productTypeList.get(1),
                        flowerList.get(4), accessoryList.get(1), "A bouquet of fresh wax flowers.",
                        true, false
                )
        );
        catalogue.add(
                new Product(
                        "PD003", "Rose Bouquet", 20.0, 5, productTypeList.get(1),
                        flowerList.get(3), accessoryList.get(1), "A bouquet of fresh rose.",
                        true, false)
        );

        return catalogue;
    }

    public static PromotionCatalogue generatePromoCatalogue(ListInterface<Product> catalogue) {
        PromotionCatalogue promoCatalogue = new PromotionCatalogue();

        promoCatalogue.setPromotionName("Winter Sales");
        promoCatalogue.setPromotionMonth(Month.DECEMBER);
        promoCatalogue.setPromotionDiscount(50);
        promoCatalogue.addPromoProduct(catalogue.get(1));
        catalogue.get(1).setInPromotion(true);
        promoCatalogue.addPromoProduct(catalogue.get(2));
        catalogue.get(2).setInPromotion(true);
        promoCatalogue.setIsInitialized(true);

        return promoCatalogue;
    }

    public static void mainMenu(
            ListInterface<Flower> flowerList, ListInterface<ProductType> productTypeList,
            ListInterface<Accessory> accessoryList, ListInterface<Product> catalogue,
            PromotionCatalogue promoCatalogue, boolean INITIAL_STOCK_STATUS,
            boolean INITIAL_PROMOTION_STATUS
    ) {
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
                    + "5. Display Product Stock\n"
                    + "x. Exit system.\n"
            );
            System.out.print("Please enter a choice: ");
            selection = sc.nextLine();

            switch (selection) {
                case "1":
                    displayCatalogue(catalogue);
                    promptEnterToContinue();
                    break;
                case "2":
                    editCatalogueMenu(
                            flowerList, productTypeList, accessoryList, catalogue,
                            INITIAL_STOCK_STATUS, INITIAL_PROMOTION_STATUS
                    );
                    break;
                case "3":
                    displayPromoCatalogue(promoCatalogue);
                    promptEnterToContinue();
                    break;
                case "4":
                    editPromoCatalogue(catalogue, promoCatalogue);
                    break;
                case "5":
                    displayProductStock(catalogue);
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
    }

    public static void editCatalogueMenu(
            ListInterface<Flower> flowerList, ListInterface<ProductType> productTypeList,
            ListInterface<Accessory> accessoryList, ListInterface<Product> catalogue,
            boolean INITIAL_STOCK_STATUS, boolean INITIAL_PROMOTION_STATUS
    ) {
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
                            INITIAL_STOCK_STATUS, INITIAL_PROMOTION_STATUS
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

    public static boolean addProduct(
            ListInterface<Flower> flowerList, ListInterface<ProductType> productTypeList,
            ListInterface<Accessory> accessoryList, ListInterface<Product> catalogue,
            boolean INITIAL_STOCK_STATUS, boolean INITIAL_PROMOTION_STATUS
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
        boolean productInPromotion = INITIAL_PROMOTION_STATUS;
        boolean addStatus = false;

        productID = Utility.generateProductID(catalogue.size());
        productName = Utility.enterProductName();
        productPrice = Utility.enterProductPrice();
        productQty = Utility.enterProductQty();
        productType = Utility.enterProductType(productTypeList);
        productAccessory = Utility.enterProductAccessory(productType, accessoryList);
        productFlower = Utility.enterFlowerType(flowerList);
        productDescription = Utility.enterProductDescription();
        addStatus = addEnteredProduct(
                catalogue, productID, productName, productPrice, productQty,
                productType, productFlower, productAccessory, productDescription,
                productInStock, productInPromotion
        );

        promptDisplayCatalogue(catalogue);

        return addStatus;
    }

    public static boolean addEnteredProduct(
            ListInterface<Product> catalogue, String productID, String productName,
            double productPrice, int productQty, ProductType productType,
            Flower productFlower, Accessory productAccessory,
            String productDescription, boolean productInStock,
            boolean productInPromotion
    ) {
        boolean addStatus;
        addStatus = catalogue.add(
                new Product(
                        productID, productName, productPrice,
                        productQty, productType, productFlower,
                        productAccessory, productDescription,
                        productInStock, productInPromotion
                )
        );
        return addStatus;
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
                    removeStatus = removeEnteredProduct(catalogue, selectionIndex);
                    endLoop = true;
                } else {
                    System.out.println("\nPlease enter a valid selection (1 - " + catalogue.size() + ")");
                }
            }

            promptDisplayCatalogue(catalogue);
        }

        return removeStatus;
    }

    public static boolean removeEnteredProduct(ListInterface<Product> catalogue, int selectionIndex) {
        boolean removeStatus;

        removeStatus = catalogue.remove(selectionIndex);

        return removeStatus;
    }

    public static void displayPromoCatalogue(PromotionCatalogue promoCatalogue) {
        if (promoCatalogue.isInitialized()) {
            System.out.println(
                    "\n=== " + promoCatalogue.getPromotionName() + " Catalogue (" + promoCatalogue.getPromotionMonth().toString().toLowerCase() + ") ==="
                    + "\n=== " + promoCatalogue.getPromotionDiscount() + "% Discount ==="
            );

            ListInterface<Product> tmpPromotionProductList = promoCatalogue.getPromotionProductList();

            System.out.println(
                    String.format(
                            "\n| %3s | %-25s | %-30s | %-25s | %-25s | %9s | %-10s | %-80s |",
                            "No.", "Product Type", "Product Name", "Flower Type", "Product Accessorry", "Price", "In Stock", "Description"
                    )
            );

            for (int i = 0; i < tmpPromotionProductList.size(); i++) {
                Product tmpProduct = tmpPromotionProductList.get(i);

                int productNumber = i + 1;
                String productName = tmpProduct.getProductName();
                String productType = tmpProduct.getProductType().getProductTypeName();
                String productFlower = tmpProduct.getFlowerType().getFlowerName();
                String productHasStockText = tmpProduct.isInStockToString();
                int productStockNum = tmpProduct.getProductQty();
                double productPrice = promoCatalogue.calcDiscountPrice(tmpProduct.getProductPrice());
                String productDescription = tmpProduct.getProductDescription();

                Accessory productAccessory = tmpProduct.getProductAccessory();
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
        } else {
            System.out.println("\nNo promotional catalogue is set.");
        }
    }

    public static void editPromoCatalogue(
            ListInterface<Product> catalogue, PromotionCatalogue promoCatalogue
    ) {
        String selection = "";

        for (boolean endLoop = false; !endLoop;) {
            System.out.println(
                    "\n=== Edit Promotion Catalogue ===\n"
                    + "1. Add New Promotion Catalogue\n"
                    + "2. Remove Current Promotion Catalogue\n"
                    + "3. Add Promotion Product\n"
                    + "4. Remove Promotion Product\n"
                    + "x. Back"
            );
            System.out.print("\nPlease enter a choice: ");

            selection = sc.nextLine();

            switch (selection) {
                case "1":
                    addPromoCatalogue(promoCatalogue);
                    break;
                case "2":
                    removePromoCatalogue(promoCatalogue);
                    break;
                case "3":
                    if (promoCatalogue.isInitialized()) {
                        System.out.println("\n=== Current Promotion Catalogue ===");
                        displayProductList(promoCatalogue.getPromotionProductList());

                        System.out.println("\n=== Products Avaliable For Promotion ===");
                        addPromoProduct(catalogue, promoCatalogue);
                    } else {
                        System.out.println("\nPlease add a promotion catalogue first.");
                    }
                    break;
                case "4":
                    if (promoCatalogue.isInitialized()) {
                        System.out.println("\n=== Current Promotion Catalogue ===");
                        displayProductList(promoCatalogue.getPromotionProductList());
                        removePromoProduct(promoCatalogue);
                    } else {
                        System.out.println("\nPlease add a promotion catalogue first.");
                    }
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

    public static void addPromoCatalogue(PromotionCatalogue promoCatalogue) {
        if (promoCatalogue.isInitialized()) {
            String selection = "";

            for (boolean endLoop = false; !endLoop;) {
                System.out.print(
                        "\nA promotion catalogue already exist.\n"
                        + "Proceed and replace with new promotion catalogue? (y/n) "
                );
                selection = sc.nextLine();

                switch (selection) {
                    case "y":
                        addPromoCatalogueDetails(promoCatalogue);
                        endLoop = true;
                        break;
                    case "n":
                        endLoop = true;
                        break;
                    default:
                        System.out.println("\nPlease enter a valid selection.");
                        break;
                }
            }
        } else {
            addPromoCatalogueDetails(promoCatalogue);
        }
    }

    public static void addPromoCatalogueDetails(PromotionCatalogue promoCatalogue) {
        String promotionName = "";
        int promotionDiscount = 0;
        Month promotionMonth = Month.JANUARY;
        ListInterface<Product> promotionCatalogue = new LList<>();
        boolean isInitialized = false;

        promotionName = enterPromotionName();
        promotionDiscount = enterPromotionDiscount();
        promotionMonth = enterPromotionMonth();
        isInitialized = true;

        addEnteredPromoCatalogue(
                promoCatalogue, promotionName, promotionDiscount, promotionMonth,
                promotionCatalogue, isInitialized
        );
    }

    public static void addEnteredPromoCatalogue(
            PromotionCatalogue promoCatalogue, String promotionName,
            int promotionDiscount, Month promotionMonth,
            ListInterface<Product> promotionCatalogue, boolean isInitialized
    ) {
        promoCatalogue.setPromotionName(promotionName);
        promoCatalogue.setPromotionDiscount(promotionDiscount);
        promoCatalogue.setPromotionMonth(promotionMonth);
        promoCatalogue.setPromotionProductList(promotionCatalogue);
        promoCatalogue.setIsInitialized(isInitialized);
    }

    public static String enterPromotionName() {
        String promotionName = "";

        System.out.print("\nPlease enter promotion name: ");

        for (boolean endLoop = false; !endLoop;) {
            promotionName = sc.nextLine();

            if (!promotionName.isEmpty()) {
                endLoop = true;
            } else {
                System.out.println("\nPlease enter a promotion name.");
            }
        }

        return promotionName;
    }

    public static int enterPromotionDiscount() {
        String promotionDiscount = "";

        for (boolean endLoop = false; !endLoop;) {
            System.out.print("\nPlease enter promotion discount percentage: ");
            promotionDiscount = sc.nextLine();

            if (promotionDiscount.matches("^[1-9][0-9]?$|^100$")) {
                endLoop = true;
            } else {
                System.out.println("\nPlease enter promotion discount percentage. (1 - 100)");
            }
        }

        return Integer.parseInt(promotionDiscount);
    }

    public static Month enterPromotionMonth() {
        String promotionMonth = "";

        for (boolean endLoop = false; !endLoop;) {
            System.out.print("\nPlease enter promotion month: ");
            promotionMonth = sc.nextLine();

            if (promotionMonth.matches("^[2-9]|1[0-2]?$")) {
                endLoop = true;
            } else {
                System.out.println("\nPlease enter a valid promotion month. (1 - 12)");
            }
        }

        return Month.of(Integer.parseInt(promotionMonth));
    }

    public static void removePromoCatalogue(PromotionCatalogue promoCatalogue) {
        promoCatalogue.setPromotionName("");
        promoCatalogue.setPromotionDiscount(0);
        promoCatalogue.setPromotionMonth(null);

        ListInterface<Product> tmpPromotionProductList = promoCatalogue.getPromotionProductList();
        for (int i = 0; i < tmpPromotionProductList.size(); i++) {
            tmpPromotionProductList.get(i).setInPromotion(false);
        }
        promoCatalogue.setPromotionProductList(null);
        promoCatalogue.setIsInitialized(false);
    }

    public static void addPromoProduct(
            ListInterface<Product> catalogue, PromotionCatalogue promoCatalogue
    ) {
        ListInterface<Product> tmpPromoProductList = new LList<>();

        for (boolean endLoop = false; !endLoop;) {
            String selection = "";
            int selectionValue = 0;
            Product tmpPromoProduct = null;

            for (int i = 0; i < catalogue.size(); i++) {
                tmpPromoProduct = catalogue.get(i);

                if (!tmpPromoProduct.isInPromotion()) {
                    tmpPromoProductList.add(tmpPromoProduct);
                }
            }

            displayProductList(tmpPromoProductList);

            if (!tmpPromoProductList.isEmpty()) {
                System.out.print("\nPlease enter a selection: ");
                selection = sc.nextLine();
                selectionValue = stringToInt(selection);

                if (selectionValue < 0 || selectionValue > tmpPromoProductList.size()) {
                    System.out.println("\nPlease enter a valid selection");
                } else {
                    Product selectedProduct = tmpPromoProductList.get(selectionValue - 1);
                    int selectedProductIndex = 0;

                    selectedProductIndex = catalogue.contains(selectedProduct);
                    if (selectedProductIndex != -1) {
                        catalogue.get(selectedProductIndex).setInPromotion(true);
                    }

                    addEnteredPromoProduct(promoCatalogue, selectedProduct);
                    endLoop = true;
                }
            } else {
                endLoop = true;
            }
        }

        promptDisplayPromoCatalogue(promoCatalogue);
    }

    public static void addEnteredPromoProduct(PromotionCatalogue promoCatalogue, Product selectedProduct) {
        promoCatalogue.getPromotionProductList().add(selectedProduct);
    }

    public static void removePromoProduct(PromotionCatalogue promoCatalogue) {
        int selection = 0;
        int promotionCatalogueSize = promoCatalogue.getPromotionProductList().size();

        for (boolean endLoop = false; !endLoop;) {
            System.out.print("\nPlease select a promotion product to remove: ");
            selection = stringToInt(sc.nextLine());

            if (selection > 0 || selection < promotionCatalogueSize) {
                removeEnteredPromoProduct(promoCatalogue, selection);
                endLoop = true;
            } else {
                System.out.println(
                        "\nPlease enter a valid selection. (1 - "
                        + promotionCatalogueSize + ")");
            }
        }

        promptDisplayPromoCatalogue(promoCatalogue);
    }

    public static void removeEnteredPromoProduct(PromotionCatalogue promoCatalogue, int selection) {
        promoCatalogue.getPromotionProductList().remove(selection - 1);
    }

    public static void promptEnterToContinue() {
        System.out.println("\nPress Enter to continue.");
        sc.nextLine();
    }

    public static void displayProductList(ListInterface<Product> catalogue) {
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
                            "No.", "Product Name", "Product Type", "Flower Type", "In Stock"
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
                                productNumber, productName, productType,
                                productFlower, productHasStockText, productStockNum
                        )
                );
            }
        }
    }

    public static void promptDisplayCatalogue(ListInterface<Product> catalogue) {
        String viewCatalogueSelection = "";

        System.out.print("\nWould you like to display catalogue? (y/n)");
        viewCatalogueSelection = sc.nextLine().toLowerCase();
        if (viewCatalogueSelection.equals("y")) {
            displayCatalogue(catalogue);
            promptEnterToContinue();
        }
    }

    public static void promptDisplayPromoCatalogue(PromotionCatalogue promotionCatalogue) {
        String viewCatalogueSelection = "";

        System.out.print("\nWould you like to display promotion catalogue? (y/n)");
        viewCatalogueSelection = sc.nextLine().toLowerCase();
        if (viewCatalogueSelection.equals("y")) {
            displayPromoCatalogue(promotionCatalogue);
        }
    }

    public static void displayProductStock(ListInterface<Product> catalogue) {
        String selection = "";
        int selectionNumber = 0;
        Product tmpProduct = null;
        ListInterface<Product> tmpProductList = new LList<>();

        System.out.print("\nShow products with stock less than: ");
        selection = sc.nextLine();
        selectionNumber = stringToInt(selection);

        if (selectionNumber > -1) {
            for (int i = 0; i < catalogue.size(); i++) {
                tmpProduct = catalogue.get(i);
                
                if (tmpProduct.getProductQty() < selectionNumber) {
                    tmpProductList.add(tmpProduct);
                }
            } 
        }
        
        displayProductListShort(tmpProductList);
        promptEnterToContinue();
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

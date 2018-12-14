package fioreflowershop.catalogueorder;

import fioreflowershop.ADT.LList;
import fioreflowershop.ADT.ListInterface;
import fioreflowershop.Models.Accessory;
import fioreflowershop.Models.Flower;
import fioreflowershop.Models.ProductType;
import fioreflowershop.Models.Product;
import fioreflowershop.Models.CatalogOrder;
import fioreflowershop.Models.CorcustOrder;
import fioreflowershop.Models.Corporate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

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
    public static ListInterface<Product> generateCatalogue() {
        ListInterface<Flower> flowerList;
        ListInterface<ProductType> productTypeList;
        ListInterface<Accessory> accessoryList;
        flowerList = generateFlowerList();
        productTypeList = generateProductTypeList();
        accessoryList = generateAccessoryList();

        ListInterface<Product> catalogue = new LList<>();

        catalogue.add(new Product("PD001", "Fresh Rose", 7.0, 20, productTypeList.get(0), flowerList.get(0), null, "Fresh red rose sourced locally.", true));
        catalogue.add(new Product("PD002", "Wax Flower Bouquet", 234.0, 20, productTypeList.get(1), flowerList.get(1), accessoryList.get(1), "A bouquet of fresh wax flowers.", true));

        return catalogue;
    }

    //corporate customer
    public static ListInterface<Corporate> generateCorporateList() {
        ListInterface<Corporate> corps = new LList<>();

        corps.add(new Corporate("CO0001", "Apple Arts Sdn. Bhd.", "144 Lrg Zamrud 3/1 Taman Pekan Baru 08000 Sungai Petani 08000, Malaysia", "03745625", 1000.00, 1400.00));
        corps.add(new Corporate("CO0002", "Alpinetime Sdn. Bhd.", "288 Lt Avenue, Jalan Petagas, WP, Kuala Lumpur, Malaysia", "03954622", 1700.00, 1800.00));
        corps.add(new Corporate("CO0003", "Robin Corporation", "350, Jalan Tun Fuad, 82000, WP, Kuala Lumpur, Malaysia", "034557895", 1000.00, 1200.00));
        corps.add(new Corporate("CO0004", "Moonlit Ltd.", "6812 Murphy Dale, Jalan Penampang, 82000, Wangsa Maju, WP, Kuala Lumpur, Malaysia", "03455688", 1000.00, 1500.00));
        corps.add(new Corporate("CO0005", "Pixycloud Ltd.", "Lt 280, Jalan Luyang, 25000, WP, Kuala Lumpur, Malaysia", "03467855", 1500.00, 2000.00));

        return corps;
    }

    //Main menu 
    public static void Menu() {
        ListInterface<Flower> flowerList = new LList<>();
        ListInterface<ProductType> productTypeList = new LList<>();
        ListInterface<Product> catalogue = new LList<>();
        ListInterface<Corporate> corps = new LList<>();

        ListInterface<CatalogOrder> cl1 = new LList<>(), co = new LList<>();
        ListInterface<CorcustOrder> cc = new LList<>(), ccl = new LList<>();

        CatalogOrder co1;
        CorcustOrder co2;

        catalogue = generateCatalogue();
        corps = generateCorporateList();

        String select = " ";
        String rpo = "";

        System.out.print("\n===================================");
        System.out.print("===== WELCOME TO FIORE FLOWERSHOP ====="
                + "=====================================\n"
                + "1. Place Your Order Here\n"
                + "2. Check Credit Limit for Corporate Customer \n"
                + "\n3. Back\n"
                + "\nEnter your choice (0 to exit): ");

        select = sc.nextLine();

        switch (select) {
            case "1":
                String id = "";
                boolean ok = false;
                do {
                    displayCatalogue();
                    displayProductList(catalogue);

                    int countPlace = 0;

                    Product p1, p2 = new Product();

                    p1 = enterProductType(catalogue);
                    int qty = enterttlQty();

                    //new object to add order
                    if (ok == false) {
                        id = generateCatalogOrderID(co.size());
                        ok = true;
                    }

                    co1 = new CatalogOrder(id, qty, p1);
                    co.add(co1);
                    cl1.add(co1);

                    while (countPlace < catalogue.size()) {

                        p2 = catalogue.get(countPlace);

                        if (p1.getProductID().equals(p2.getProductID())) {
                            catalogue.get(countPlace).setProductQty(p2.getProductQty() - qty);
                        }
                        countPlace++;
                    }
                    System.out.print("\n\tWould you like to add more order? (y/n) : ");
                    rpo = sc.nextLine().toUpperCase();

                } while ("YES".equals(rpo.toUpperCase()) || "Y".equals(rpo.toUpperCase()));

                displaySummaryOfOrder(cl1, catalogue);
                promptEnterToContinue();
                showOrderSummary(id, cl1, catalogue);

                break;

            case "2":
                Corporate corporate = showCerditLimit(corps);
                id = "";
                ok = false;

                do {
                    displayCatalogue();
                    displayProductList(catalogue);

                    int countPlace = 0;
                    Product p1 = new Product(), p2 = new Product();

                    p1 = enterProductType(catalogue);
                    int qty = enterttlQty();

                    if (ok == false) {
                        id = generateCatalogOrderID(co.size());
                        ok = true;
                    }

                    co2 = new CorcustOrder(id, qty, p1, corporate);
                    cc.add(co2);
                    ccl.add(co2);

                    while (countPlace < catalogue.size()) {
                        p2 = catalogue.get(countPlace);

                        if (p1.getProductID().equals(p2.getProductID())) {
                            catalogue.get(countPlace).setProductQty(p2.getProductQty() - qty);
                        }
                        countPlace++;
                    }
                    System.out.print("\n\tWould you like to add more order? (y/n) : ");
                    rpo = sc.nextLine().toUpperCase();

                } while ("YES".equals(rpo.toUpperCase()) || "Y".equals(rpo.toUpperCase()));
                displaySummaryOfOrderCorporate(ccl, catalogue);
                promptEnterToContinue();
                showOrderCorporateSummary(id, ccl, catalogue);

                break;
            case "0":
                System.exit(0);
                break;
            default:
                System.out.println("\n\nOops your choice are invalid...Please try again\n");
                break;
        }
    }

    //Catalogue list start from here 
    public static void displayCatalogue() {
        System.out.println(
                "\n\t\t\t\t\t\t\t\t\t===================================\n"
                + "\t\t\t\t\t\t\t\t\t=== Fiore Flower Shop Catalogue ===\n"
                + "\t\t\t\t\t\t\t\t\t===================================\n"
        );
    }

    //Display catalogue list
    private static void displayProductList(ListInterface<Product> catalogue) {

        if (catalogue.isEmpty()) {
            System.out.println("\nNo products available currently.");
        } else {
            System.out.println(
                    String.format(
                            "\n %3s \t %-25s \t %-30s \t %-25s \t %-25s \t %9s \t %-10s \t %-80s",
                            "No.", "Product Type", "Product Name", "Flower Type", "Product Accessorry", "Price", "In Stock", "Description"
                    )
            );

            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
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
                                "%3d \t %-25.25s \t %-30.30s \t %-25.25s \t %-25.25s \t %9.2f \t %s - %-4s \t %-80s \n",
                                productNumber, productName, productType,
                                productFlower, productAccessoryText, productPrice,
                                productHasStockText, productStockNum, productDescription
                        )
                );
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }

    //prompt user to select product type
    public static Product enterProductType(ListInterface<Product> catalogue) {
        String selection = "";
        int selectionNumber = 0;
        int totalEntries = catalogue.size();
        Product selectedProductType = null;

        while (true) {
            System.out.print("\nChoose your product type [1/2] : ");
            selection = sc.nextLine();

            selectionNumber = stringToInt(selection);
            if (selectionNumber != -1 && selectionNumber <= totalEntries) {
                selectedProductType = catalogue.get(selectionNumber - 1);
                break;
            }
            System.out.println("Oops your choice are invalid...Please try again (1 to " + totalEntries + ") : \n");
        }
        return selectedProductType;
    }

    //prompt user to enter quantity
    public static int enterttlQty() {
        String Qty = "";

        while (true) {
            System.out.print("\nEnter Quantity : ");
            Qty = sc.nextLine();

            if (Qty.matches("^([\\d])+$")) {
                break;
            }
            System.out.println("\nPlease enter a valid product quantity. (E.g. - 10) : \n");
        }
        return Integer.parseInt(Qty);
    }

    private static void promptEnterToContinue() {
        System.out.println("\nPlease confirm your order item by press ENTER.");
        sc.nextLine();
    }

    private static void pressEnterToContinue() {
        System.out.println("\nPress ENTER to proceed.");
        sc.nextLine();
    }

    //to show a quick summary of ordered item
    private static void displaySummaryOfOrder(ListInterface<CatalogOrder> cl, ListInterface<Product> p1) {
        System.out.println("\n===================================================");
        System.out.println("\tYOUR ORDER HAVE ADDED TO CART");
        System.out.println("===================================================\n");
        System.out.println(String.format("%-30s \t %-10s", "Product Name", "Quantity"));
        System.out.print("---------------------------------------------------\n");
        for (int i = 0; i < cl.size(); ++i) {
            System.out.println(
                    String.format("\n%-30s \t %-10s\n",
                            cl.get(i).getProduct().getProductName(),
                            cl.get(i).getQty()));
        }
        System.out.print("---------------------------------------------------\n");
        System.out.println("===================================================\n");
    }

    private static void displaySummaryOfOrderCorporate(ListInterface<CorcustOrder> coc, ListInterface<Product> p1) {
        System.out.println("\n===================================================");
        System.out.println("\tYOUR ORDER HAVE ADDED TO CART");
        System.out.println("===================================================\n");
        System.out.println(String.format("%-30s \t %-10s", "Product Name", "Quantity"));
        System.out.print("---------------------------------------------------\n");
        for (int i = 0; i < coc.size(); ++i) {
            System.out.println(
                    String.format("\n%-30s \t %-10s\n",
                            coc.get(i).getProduct().getProductName(),
                            coc.get(i).getQty()));
        }
        System.out.print("---------------------------------------------------\n");
        System.out.println("===================================================\n");
    }

    //order report will shown after customer finish order
    private static void showOrderSummary(
            String id,
            ListInterface<CatalogOrder> cl,
            ListInterface<Product> p1
    ) {
        if (cl.isEmpty()) {
            System.out.println("\nYou dont have any Orders in your cart now.");
        } else {
            double totalPrice = 0;

            System.out.print("\n\n===========================FIORE FLOWER SHOP==============================");
            System.out.print("\n\n\t\t\tFIORE FLOWER SHOP SALES ORDER");
            System.out.print("\n--------------------------------------------------------------------------");
            System.out.println("\nORDER ID : " + id);
            System.out.print("--------------------------------------------------------------------------\n");
            System.out.println(String.format("%-30s \t %-10s \t %-10s\n", "Product Name", "Quantity", "Per Unit(Price)"));
            System.out.print("--------------------------------------------------------------------------\n");
            for (int i = 0; i < cl.size(); i++) {
                System.out.println(
                        String.format("\n%-30s \t %-10s \t RM%.2f\n",
                                cl.get(i).getProduct().getProductName(),
                                cl.get(i).getQty(),
                                (cl.get(i).getProduct().getProductPrice() * cl.get(i).getQty())));
                totalPrice += (cl.get(i).getProduct().getProductPrice() * cl.get(i).getQty());
            }
            System.out.print("--------------------------------------------------------------------------\n");
            System.out.print("***********************************\n");
            System.out.println("\tTOTAL AMOUNT TO BE PAID\n");
            System.out.println(String.format("\tTotal Price : RM %.2f\n", totalPrice));
            System.out.print("***********************************\n");
            DisplyTimeDate();
            System.out.print("===========================================================================");
            System.out.print("\n\t\tThank you for using our system...Have a nice day\n");
            System.out.print("===========================================================================\n");
        }
    }

    //order report will shown after corporate customer finish order
    private static void showOrderCorporateSummary(
            String id,
            ListInterface<CorcustOrder> coc,
            ListInterface<Product> p1
    ) {
        if (coc.isEmpty()) {
            System.out.println("\nYou dont have any Orders in your cart now.");
        } else {
            double totalOtyPrice = 0, creditLimit = 0.0;

            System.out.print("\n\n===========================FIORE FLOWER SHOP==============================");
            System.out.print("\n\n\t\t\tFIORE FLOWER SHOP SALES ORDER");
            System.out.print("\n--------------------------------------------------------------------------");
            System.out.println("\nORDER ID : " + id);
            System.out.print("--------------------------------------------------------------------------\n");
            System.out.println(String.format("%-30s \t %-10s \t %-10s\n", "Product Name", "Quantity", "Per Unit(Price)"));
            System.out.print("--------------------------------------------------------------------------\n");
            for (int i = 0; i < coc.size(); i++) {
                System.out.println(
                        String.format("\n %s \t %d \t RM%.2f\n",
                                coc.get(i).getProduct().getProductName(),
                                coc.get(i).getQty(),
                                (coc.get(i).getProduct().getProductPrice() * coc.get(i).getQty())));

                totalOtyPrice += (coc.get(i).getProduct().getProductPrice() * coc.get(i).getQty());
                creditLimit = coc.get(i).getCorporate().getCurrentCreditLimit();

                if (totalOtyPrice > coc.get(i).getCorporate().getCurrentCreditLimit()) {
                    System.out.print("\nINSUFFICIENT BALANCE...PLEASE CONTACT YOUR MANAGEMENT FOR MORE INFO\n\n");
                    System.exit(0);
                }
            }
            System.out.print("--------------------------------------------------------------------------\n");
            System.out.print("***********************************\n");
            System.out.println("\tTOTAL AMOUNT TO BE PAID\n");
            System.out.println(String.format("Total Price : RM %.2f\n ", totalOtyPrice));
            System.out.print("***********************************\n");
            System.out.print("--------------------------------------------------------------------------\n");
            System.out.println("\n\t\tSUCCESFULLY PAIDED...");
            System.out.print(String.format("\nCredit Balance : RM%.2f\n ", creditLimit - totalOtyPrice));
            System.out.print("--------------------------------------------------------------------------\n");
            DisplyTimeDate();
            System.out.print("===========================================================================");
            System.out.print("\n\t\tThank you for using our system...Have a nice day\n");
            System.out.print("===========================================================================");

        }
    }

    //check credit limit for corporate customer
    public static Corporate showCerditLimit(ListInterface<Corporate> corps) {
        String corporateId = " ";
        String selection = " ";
        boolean custFound = false;
        Corporate creditlimit = null;

        do {
            System.out.print("\n===== CORPORATE CUSTOMER ====\n\n");
            System.out.print("\nEnter ID : ");
            corporateId = sc.nextLine();

            for (int i = 0; i < corps.size(); i++) {

                if (corporateId.equals(corps.get(i).getCorporateId())) {
                    creditlimit = (Corporate) corps.get(i);
                    System.out.println(String.format("\n %d. %s", i, creditlimit.getCorporateName()
                            + "\nTOTAL CREDIT LIMIT : " + creditlimit.getCurrentCreditLimit()));
                    custFound = true;
                    pressEnterToContinue();
                }
            }
            if (!custFound) {
                System.out.println("No customer found.");
            }
        } while (!custFound);
        return creditlimit;
    }

    //to generate id for each catalog order that ordered
    public static String generateCatalogOrderID(int productListEntries) {
        String catalogOrderID = "";

        catalogOrderID = "Co-" + String.format("%03d", productListEntries + 1);

        return catalogOrderID;
    }

    //display date and time to be pick up for orders
    public static void DisplyTimeDate() {
        int day, month, year;
        int minute, hour;

        GregorianCalendar gc = new GregorianCalendar();
        day = gc.get(Calendar.DAY_OF_MONTH);
        month = gc.get(Calendar.MONTH);
        year = gc.get(Calendar.YEAR);

        minute = gc.get(Calendar.MINUTE);
        hour = gc.get(Calendar.HOUR);

        System.out.println("\nPLEASE PICK UP YOUR ORDER AS DATE AND TIME SHOWN " + "\nTime : " + hour + ":" + minute
                + "\nDate : " + day + "-" + month + "-" + year + "\n");
    }

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

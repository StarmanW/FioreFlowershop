package fioreflowershop.catalogueOrder;

import fioreflowershop.ADT.LList;
import fioreflowershop.ADT.ListInterface;
import fioreflowershop.Models.PromotionCatalogue;
import fioreflowershop.Models.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Thiban Kumar
 */
public class Utility {

    private static Scanner sc = new Scanner(System.in);
    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
//  private final static SimpleDateFormat DELIVERY_DATETIME = new SimpleDateFormat("dd-MM-yyyy hh:mm");

    //Order added and sent to module B to generate invoice
    public static ListInterface<Order> generateOrder(ListInterface<Product> productList,
            ListInterface<Corporate> corporateList) {

        // Create product order list for corporate 1
        ListInterface<ProductOrder> productOrderList = new LList<>();
        ListInterface<ProductOrder> productOrderList1 = new LList<>();

        // Create product order list for corporate 2
        ListInterface<ProductOrder> productOrderList2 = new LList<>();
        ListInterface<ProductOrder> productOrderList3 = new LList<>();

        // Create new order list
        ListInterface<Order> orderList = new LList<>();

        // Product Order List for first order of corporate 1
        productOrderList.add(new ProductOrder(productList.get(0), 1));
        productOrderList.add(new ProductOrder(productList.get(1), 2));

        // Product Order List for second order of corporate 1
        productOrderList1.add(new ProductOrder(productList.get(0), 3));
        productOrderList1.add(new ProductOrder(productList.get(1), 2));

        // Product Order List for first order of corporate 2
        productOrderList2.add(new ProductOrder(productList.get(0), 4));
        productOrderList2.add(new ProductOrder(productList.get(1), 5));

        // Product Order List for second order of corporate 2
        productOrderList3.add(new ProductOrder(productList.get(0), 5));
        productOrderList3.add(new ProductOrder(productList.get(1), 10));

        try {
            // Order List for corporate 1
            orderList.add(new Order("OD0001", corporateList.get(0), productOrderList, SIMPLE_DATE_FORMAT.parse("11-12-2018"), SIMPLE_DATE_FORMAT.parse("20-12-2018"), corporateList.get(0).getAddress(), 475.00));
            orderList.add(new Order("OD0002", corporateList.get(0), productOrderList1, SIMPLE_DATE_FORMAT.parse("15-12-2018"), SIMPLE_DATE_FORMAT.parse("20-12-2018"), corporateList.get(0).getAddress(), 489.00));

            // Order List for corporate 2
            orderList.add(new Order("OD0003", corporateList.get(2), productOrderList2, SIMPLE_DATE_FORMAT.parse("04-11-2018"), SIMPLE_DATE_FORMAT.parse("10-12-2018"), corporateList.get(2).getAddress(), 1198.00));
            orderList.add(new Order("OD0004", corporateList.get(2), productOrderList3, SIMPLE_DATE_FORMAT.parse("08-11-2018"), SIMPLE_DATE_FORMAT.parse("15-12-2018"), corporateList.get(2).getAddress(), 2375.00));
        } catch (ParseException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }

        return orderList;
    }

    //Main Menu
    public static int mainMenu() {
        String choice = "";
        while (true) {
            System.out.print("\n=== WELCOME TO FIORE FLOWERSHOP ===\n\n"
                    + "1. Fiore Flower Shop Catalogue\n"
                    + "0. Exit\n"
                    + "\nPlease select : ");
            choice = sc.nextLine();
            if (choice.matches("^[0-1]$")) {
                break;
            }
            System.out.println("\n\n\tPlease enter a valid choice...\n");
        }
        return Integer.parseInt(choice);
    }

//    public static void generateOrderReport(ListInterface<Order> orderList) {
//
//        for (int i = 0; i < orderList.size(); ++i) {
//            System.out.print(String.format("\n%-15s \n %-15s ", orderList.get(i).getOrderID() , orderList.get(i).getTotalPayment()));
//        }
//
//    }
    //Order page will start from here
    public static void makeOrder(
            ListInterface<Consumer> consumerList,
            ListInterface<Corporate> corporateList,
            ListInterface<Invoice> invoiceList,
            ListInterface<Product> productList,
            ListInterface<Order> orderList,
            PromotionCatalogue promotionCatalogue) {

        //To get customer and corporate list from module B
        int custType = fioreflowershop.custMaintenanceAndIP.Utility.showCustomerList(consumerList, corporateList);

        // Variables declaration
        double totalPayment = 0.0;
        String prodListChoice = "", custIndex = "", continueChoice = "", deliveryAddress = "", deliveryDateTime = "";

        // Create product order list
        ListInterface<ProductOrder> productOrderList = new LList<>();

        Order order = null;
        Customer customer = null;

        // Get customer index umber
        while (true) {
            System.out.print("\nEnter customer no : ");
            custIndex = sc.nextLine();
            if (custIndex.matches("^[1-5]$")) {
                break;
            }
            System.out.println("\n\t\tPlease enter a valid choice...");
        }

        //do while loop
        do {
            while (true) {
                System.out.print("\n\n\n\t===================================\n"
                        + "\t=== Fiore Flower Shop Catalogue ===\n"
                        + "\t===================================\n\n"
                        + "1. Product Catalogue\n");

                //if this month got promotion it will show second option(depends on module A to check promotion) 
                if (promotionCatalogue.getPromotionProductList().size() != 0) {
                    System.out.print("2. Promotion Catalogue\n");
                }

                System.out.print("\nEnter your choice: ");
                prodListChoice = sc.nextLine();

                if (prodListChoice.matches("^[1-2]$")) {
                    break;
                }
                System.out.println("\n\t\tPlease enter a valid choice...try again with only choice [1-2]");
            }

            // Create new product order object
            ProductOrder productOrder = new ProductOrder();

            // If choice is 1 display products, else display promotion products
            if (prodListChoice.equals("1")) {
                productOrder = purchaseProducts(productList, promotionCatalogue);
            } else if (prodListChoice.equals("2")) {
                productOrder = purchasePromotionProducts(promotionCatalogue);
            }

            if (productOrder != null) {
                // Add to product order list
                productOrderList.add(productOrder);
            }

            //to Add more order
            while (true) {
                System.out.print("\n\tDo you wish to purchase more products? (Y/N): ");
                continueChoice = sc.nextLine();
                if (continueChoice.matches("^[YyNn]$")) {
                    break;
                }
                System.out.println("\n\t\tPlease enter a valid choice...try again with Y or N only.");
            }
        } while (continueChoice.matches("^[Yy]$"));

        try {
            // Get customer who made the order
            if (custType == 1) {
                customer = consumerList.get(Integer.parseInt(custIndex) - 1);
            } else if (custType == 2) {
                customer = corporateList.get(Integer.parseInt(custIndex) - 1);
            }

            // Create new order object 
            order = new Order(
                    String.format("OD%04d", orderList.size() + 1),
                    customer,
                    productOrderList,
                    new Date(),
                    SIMPLE_DATE_FORMAT.parse(deliveryDateTime),
                    (deliveryAddress.matches("") ? customer.getAddress() : deliveryAddress),
                    totalPayment
            );

            orderList.add(order);

            // Calculate total promotion product price
            if (prodListChoice.equals("2")) {
                // Calculate total payment for the promotion catalogue
                for (int i = 0; i < productOrderList.size(); i++) {
                    totalPayment += productOrderList.get(i).getQuantity() * (productOrderList.get(i).getProduct().getProductPrice() * (100 - promotionCatalogue.getPromotionDiscount()));
                }
            } else {
                // Calculate total payment for the order made
                for (int i = 0; i < productOrderList.size(); i++) {
                    totalPayment += productOrderList.get(i).getQuantity() * productOrderList.get(i).getProduct().getProductPrice();
                }
            }

            // Create new Invoice object for corporate + sales order 
            if (custType == 2) {

                boolean invoiceFound = false;
                //new object for add order for corporate customer
                ListInterface<Order> orders = new LList<>();

                //order added and sent to module B then prepare invoice
                if (!invoiceFound) {
                    orders.add(order);
                    invoiceList.add(new Invoice(String.format("INV%04d",
                            invoiceList.size()),
                            customer,
                            new Date(),
                            SIMPLE_DATE_FORMAT.parse(LocalDate.now().plusMonths(1).toString()),
                            orders));
                }
                for (int i = 0; i < invoiceList.size(); i++) {
                    if (invoiceList.get(i).getCorporate().getCorporateId().equals(corporateList.get(Integer.parseInt(custIndex) - 1).getCorporateId())) {
                        invoiceList.get(i).getOrders().add(order);
                        invoiceFound = true;
                        break;
                    }
                }

                Corporate corporate = corporateList.get(Integer.parseInt(custIndex) - 1);

                displaySummaryOfOrder(productOrderList);
                promptEnterToContinue();

                if (totalPayment > corporate.getCurrentCreditLimit()) {
                    System.out.print("\n\t\tINSUFFICIENT BALANCE...PLEASE CONTACT YOUR MANAGEMENT FOR MORE INFO\n\n");
                    System.exit(0);
                } else {
                    //Sales Order will Generate for each catalog order here
                    System.out.print("\n\n===========================FIORE FLOWER SHOP==============================");
                    System.out.print("\n\n\t\t\tFIORE FLOWER SHOP SALES ORDER");
                    System.out.print("\n--------------------------------------------------------------------------");
                    System.out.print("\nORDER ID : " + order.getOrderID());
                    System.out.print(String.format("\nORDED DATE : %s", SIMPLE_DATE_FORMAT.format(order.getOrderedOn())));
                    System.out.print("\nCORPORATE NAME : " + corporate.getCorporateName());
                    System.out.print("\nADDRESS : " + order.getDeliveryAddress());
                    System.out.print("\n--------------------------------------------------------------------------\n\n");
                    System.out.println(String.format("%-15s \t %-15s \t %-10s\n", "Product Name", "Quantity", "Price"));
                    System.out.print("--------------------------------------------------------------------------\n");
                    for (int i = 0; i < productOrderList.size(); i++) {
                        System.out.println(
                                String.format("%s \t\t %d \t\t RM%.2f\n",
                                        productOrderList.get(i).getProduct().getProductName(),
                                        productOrderList.get(i).getQuantity(),
                                        productOrderList.get(i).getProduct().getProductPrice() * productOrderList.get(i).getQuantity()
                                ));
                    }

                    System.out.print("--------------------------------------------------------------------------\n");
                    System.out.print("***********************************\n");
                    System.out.println("\tTOTAL AMOUNT TO BE PAID\n");
                    System.out.println(String.format("\tTotal Price : RM %.2f\n ", totalPayment));
                    System.out.print("***********************************\n");
                    System.out.print("--------------------------------------------------------------------------\n");
                    System.out.println("\n\t\tSUCCESFULLY PAIDED...");
                    System.out.print(String.format("\nCredit Balance : RM%.2f\n ", corporate.getCurrentCreditLimit() - totalPayment));
                    System.out.print("--------------------------------------------------------------------------\n");
                    DisplyTimeDate();
                    System.out.print("===========================================================================");
                    System.out.print("\n\tPLEASE PICK UP YOUR ORDER ON TIME,Thank you...Have a nice day\n");
                    System.out.print("===========================================================================\n");
                    System.exit(0);
                }
            }

            //Sales Order will Generate for each catalog order here for consumer
            displaySummaryOfOrder(productOrderList);
            promptEnterToContinue();

            System.out.print("\n\n===========================FIORE FLOWER SHOP==============================");
            System.out.print("\n\n\t\t\tFIORE FLOWER SHOP SALES ORDER");
            System.out.print("\n--------------------------------------------------------------------------");
            System.out.print("\nORDER ID : " + order.getOrderID());
            System.out.print(String.format("\nORDED DATE : %s", SIMPLE_DATE_FORMAT.format(order.getOrderedOn())));
            System.out.print("\n===========================================================================");
            System.out.print("\nConatact NO : " + order.getCustomer().getContactNo());
            System.out.print("\nADDRESS : " + order.getCustomer().getAddress());
            System.out.print("\n===========================================================================\n\n");
            System.out.println(String.format("%-15s \t %-15s \t %-10s\n", "Product Name", "Quantity", "Price"));
            System.out.print("--------------------------------------------------------------------------\n");
            for (int i = 0; i < productOrderList.size(); i++) {
                System.out.println(
                        String.format("%s \t\t %d \t\t RM%.2f\n",
                                productOrderList.get(i).getProduct().getProductName(),
                                productOrderList.get(i).getQuantity(),
                                productOrderList.get(i).getProduct().getProductPrice() * productOrderList.get(i).getQuantity()
                        ));
            }

            System.out.print("--------------------------------------------------------------------------\n");
            System.out.print("***********************************\n");
            System.out.println("\tTOTAL AMOUNT TO BE PAID\n");
            System.out.println(String.format("\tTotal Price : RM %.2f\n ", totalPayment));
            System.out.print("***********************************\n");
            System.out.print("--------------------------------------------------------------------------\n");
            DisplyTimeDate();
            System.out.print("===========================================================================");
            System.out.print("\n\tPLEASE PICK UP YOUR ORDER ON TIME,Thank you...Have a nice day\n");
            System.out.print("===========================================================================\n");
//            System.exit(0);

        } catch (ParseException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void displaySummaryOfOrder(ListInterface<ProductOrder> productOrderList) {
        System.out.println("\n===================================================");
        System.out.println("\tORDER HAVE ADDED TO CART");
        System.out.println("===================================================\n");
        System.out.println(String.format("%-15s \t %-15s", "Product Name", "Quantity"));
        System.out.print("---------------------------------------------------\n");
        for (int i = 0; i < productOrderList.size(); i++) {
            System.out.println(
                    String.format("%s \t\t %d",
                            productOrderList.get(i).getProduct().getProductName(),
                            productOrderList.get(i).getQuantity()
                    ));
        }
        System.out.print("---------------------------------------------------\n");
        System.out.println("===================================================\n");
    }

    //Product Catalogue list
    private static ProductOrder purchaseProducts(ListInterface<Product> productList, PromotionCatalogue promotionCatalogue) {
        String productChoice = "", productQty = "";
        ProductOrder productOrder = null;

        // to display product list
        System.out.println("\n\t\t\t\t\t\t======= Fiore Flower Shop Catalogue ===========\n");
        System.out.println(
                String.format(
                        "%3s \t %-10s \t %-20s \t %-10s \t %-32s \t %9s \t %-8s \t %s",
                        "No", "Product ID", "Product Name", "Flower Type", "Description", "Price", "Ouantity", "Stock Available"
                )
        );
        System.out.println("----------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < productList.size(); i++) {
            System.out.println(
                    String.format("%-4d \t %-10s \t %-20s \t %-10s \t %-30s \t RM %5.2f \t\t %-10d \t %s ",
                            i + 1,
                            productList.get(i).getProductID(),
                            productList.get(i).getProductName(),
                            productList.get(i).getFlowerType().getFlowerName(),
                            productList.get(i).getProductDescription(),
                            productList.get(i).getProductPrice(),
                            productList.get(i).getProductQty(),
                            productList.get(i).isInStock()
                    )
            );
        }

        while (true) {
            System.out.print("\nEnter product number : ");
            productChoice = sc.nextLine();
            if (productChoice.matches("^[1-3]$")) {
                break;
            }
            System.out.println("\n\t\tPlease enter a valid choice...");
        }

        while (true) {
            System.out.print("\nEnter the product quantity to purchase: ");
            productQty = sc.nextLine();

            //check for the product stock 
            if (productQty.matches("^\\d+$")) {
                Product prod = productList.get(Integer.parseInt(productChoice) - 1);

                if (prod.getProductQty() >= Integer.parseInt(productQty)) {
                    prod.setProductQty(prod.getProductQty() - Integer.parseInt(productQty));
                    productOrder = new ProductOrder(productList.get(Integer.parseInt(productChoice) - 1), Integer.parseInt(productQty));
                    break;
                } else {
                    System.out.print("\n\t\tSorry...The selected product are currently Out of Stock...\n\n");
                    break;
                }
            } else {
                System.out.println("\n\t\tPLEASE ENTER THE QUANTITY WITH ONLY NUMBERS...");
            }
        }

        return productOrder;
    }
//        return productOrder;

    //promotion catalogue
    private static ProductOrder purchasePromotionProducts(PromotionCatalogue promotionCatalogue) {

        String productChoice = "", productQty = "";

        System.out.println("\n\t\t===Promotion product available this month !!!===\n" + "\t\t\t" + promotionCatalogue.getPromotionName() + "\n");

        //object for promotion
        ProductOrder productOrder = null;
        ListInterface<Product> promotionProduct = promotionCatalogue.getPromotionProductList();

        //to display promotion catalogue if any
        System.out.println("\n\t\t\t\t======= Fiore Flower Shop Promotion Catalogue ===========\n");
        System.out.println(String.format(
                "%3s \t %-10s \t %-20s \t %-10s \t %-32s \t %9s \t %-8s \t %s",
                "No", "Product ID", "Product Name", "Flower Type", "Description", "Price", "Ouantity", "Stock Available"
        ));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < promotionProduct.size(); i++) {
            System.out.println(
                    String.format("%-4d \t %-10s \t %-20s \t %-10s \t %-30s \t RM %5.2f \t\t %-10d \t %s",
                            i + 1,
                            promotionProduct.get(i).getProductID(),
                            promotionProduct.get(i).getProductName(),
                            promotionProduct.get(i).getFlowerType().getFlowerName(),
                            promotionProduct.get(i).getProductDescription(),
                            promotionProduct.get(i).getProductPrice(),
                            promotionProduct.get(i).getProductQty(),
                            promotionProduct.get(i).isInStock()));
        }

        // Enter product index no.
        while (true) {
            System.out.print("\n\nEnter the product no to order: ");
            productChoice = sc.nextLine();
            if (productChoice.matches("^[1-3]$")) {
                break;
            }
            System.out.println("\n\tPlease enter a valid choice...");
        }

        // Enter quantity for a product
        while (true) {
            System.out.print("\nEnter the product quantity to purchase: ");
            productQty = sc.nextLine();
            if (productQty.matches("^\\d+$")) {

                Product prod = promotionProduct.get(Integer.parseInt(productChoice) - 1);
                if (prod.getProductQty() >= Integer.parseInt(productQty)) {
                    prod.setProductQty(prod.getProductQty() - Integer.parseInt(productQty));
                    productOrder = new ProductOrder(promotionProduct.get(Integer.parseInt(productChoice) - 1), Integer.parseInt(productQty));
                    break;
                } else {
                    System.out.print("\n\t\tSorry...The selected product are currently Out of Stock...\n\n");
                    break;
                }
            } else {

                System.out.println("\n\t\tPLEASE ENTER THE QUANTITY WITH ONLY NUMBERS...");
            }

        }
        return productOrder;
    }

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

    private static void promptEnterToContinue() {
        System.out.println("\nPlease confirm order item by press ENTER.");
        sc.nextLine();
    }
}

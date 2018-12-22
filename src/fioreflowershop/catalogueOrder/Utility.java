package fioreflowershop.catalogueOrder;

import fioreflowershop.ADT.LList;
import fioreflowershop.ADT.ListInterface;
import fioreflowershop.ADT.PromotionCatalogue;
import fioreflowershop.Models.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Thiban
 */
public class Utility {

    private static Scanner sc = new Scanner(System.in);
    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    private final static SimpleDateFormat DELIVERY_DATETIME = new SimpleDateFormat("dd-MM-yyyy hh:mm");

    public static ListInterface<Order> generateOrder(ListInterface<Product> productList, ListInterface<Corporate> corporateList) {
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

    public static int mainMenu() {
        String choice = "";
        while (true) {
            System.out.print("==== Catalogue Order ====\n"
                    + "1. Make Order\n"
                    + "2. Back\n"
                    + "Enter choice: ");
            choice = sc.nextLine();
            if (choice.matches("^[1-2]$")) {
                break;
            }
            System.out.println("Invalid choice entered, please try again with only choice 1-2.\n");
        }
        return Integer.parseInt(choice);
    }

    public static void makeOrder(
            ListInterface<Consumer> consumerList,
            ListInterface<Corporate> corporateList,
            ListInterface<Invoice> invoiceList,
            ListInterface<Product> productList,
            ListInterface<Order> orderList,
            PromotionCatalogue promotionCatalogue
    ) {
        // Variables declaration
        int custType = fioreflowershop.custMaintenanceAndIP.Utility.showCustomerList(consumerList, corporateList);
        double totalPayment = 0.0;
        String prodListChoice = "", custIndex = "", continueChoice = "", deliveryAddress = "", deliveryDateTime = "";
        ListInterface<ProductOrder> productOrderList = new LList<>();
        Order order = null;
        Customer customer = null;

        // Get customer index umber
        while (true) {
            System.out.print("\nEnter customer no.: ");
            custIndex = sc.nextLine();
            if (custIndex.matches("^\\d+$")) {
                break;
            }
            System.out.println("Invalid choice entered, please try again with digits only.");
        }

        do {
            while (true) {
                System.out.println("\n==== Product List ===\n"
                        + "1. Display products");
                // Product promotion
                if (promotionCatalogue.getPromotionProductList().size() != 0) {
                    System.out.println("2. Diplay promotion products");
                }

                System.out.print("Enter choice: ");
                prodListChoice = sc.nextLine();
                if (prodListChoice.matches("^[1-2]$")) {
                    break;
                }
                System.out.println("Invalid choice entered, please try again with range 1 to 2 only.");
            }

            // Create new product order object
            ProductOrder productOrder = new ProductOrder();

            // If choice is 1 display products, else display promotion products
            if (prodListChoice.equals("1")) {
                productOrder = purchaseProducts(productList);
            } else if (prodListChoice.equals("2")) {
                productOrder = purchasePromotionProducts(promotionCatalogue);
            }

            if (productOrder != null) {
                // Add to product order list
                productOrderList.add(productOrder);
            }

            // Prompt customer to continue
            while (true) {
                System.out.print("Do you wish to purchase more products? (Y/N): ");
                continueChoice = sc.nextLine();
                if (continueChoice.matches("^[YyNn]$")) {
                    break;
                }

                System.out.println("Invalid choice entered, please try again with Y or N only.");
            }
        } while (continueChoice.matches("^[Yy]$"));

        // Prompt delivery date and time
        System.out.print("Enter delivery date/time (dd-mm-yyyy hh:mm): ");
        deliveryDateTime = sc.nextLine();

        // Prompt delivery address (Will use the customer default address if empty)
        System.out.print("Enter delivery address (Empty for default address): ");
        deliveryAddress = sc.nextLine();

        try {

            // Get customer who made the order
            if (custType == 1) {
                customer = consumerList.get(Integer.parseInt(custIndex) - 1);
            } else if (custType == 2) {
                customer = corporateList.get(Integer.parseInt(custIndex) - 1);
            }

            // Calculate total payment for the order made
            for (int i = 0; i < productOrderList.size(); i++) {
                totalPayment += productOrderList.get(i).getQuantity() * productOrderList.get(i).getProduct().getProductPrice();
            }

            // Create new order object 
            order = new Order(String.format("OD%04d", orderList.size() + 1), customer, productOrderList, new Date(), SIMPLE_DATE_FORMAT.parse(deliveryDateTime), (deliveryAddress.matches("") ? customer.getAddress() : deliveryAddress), totalPayment);
            orderList.add(order);

            // Create new Invoice object for corporate
            if (custType == 2) {
                boolean invoiceFound = false;
                ListInterface<Order> orders = new LList<>();

                for (int i = 0; i < invoiceList.size(); i++) {
                    if (invoiceList.get(i).getCorporate().getCorporateId().equals(corporateList.get(Integer.parseInt(custIndex) - 1).getCorporateId())) {
                        invoiceList.get(i).getOrders().add(order);
                        invoiceFound = true;
                        break;
                    }
                }

                if (!invoiceFound) {
                    orders.add(order);
                    invoiceList.add(
                            new Invoice(String.format("INV%04d",
                                    invoiceList.size()),
                                    customer,
                                    new Date(),
                                    SIMPLE_DATE_FORMAT.parse(LocalDate.now().plusMonths(1).toString()),
                                    orders
                            )
                    );
                }
            }

            System.out.println(
                    String.format("\n\nOrder ID: %s\n"
                            + "Ordered On: %s\n"
                            + "Delivery Address: %s\n"
                            + "Delivery Time: %s\n",
                            order.getOrderID(),
                            SIMPLE_DATE_FORMAT.format(order.getOrderedOn()),
                            order.getDeliveryAddress(),
                            DELIVERY_DATETIME.format(order.getDeliveryDateTime())
                    )
            );

            for (int i = 0; i < productOrderList.size(); i++) {
                System.out.print(
                        String.format("%-20s \t %-5d \t RM %4.2f \t RM %4.2f\n",
                                productOrderList.get(i).getProduct().getProductName(),
                                productOrderList.get(i).getQuantity(),
                                productOrderList.get(i).getProduct().getProductPrice(),
                                productOrderList.get(i).getProduct().getProductPrice() * productOrderList.get(i).getQuantity()
                        )
                );
            }
            
            System.out.println(String.format("Total Payment: RM %4.2f", totalPayment));

        } catch (ParseException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static ProductOrder purchaseProducts(ListInterface<Product> productList) {
        String productChoice = "", productQty = "";
        ProductOrder productOrder = null;

        // For loop display product
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

        // Enter product index no.
        while (true) {
            System.out.print("Enter the product no. to order: ");
            productChoice = sc.nextLine();
            if (productChoice.matches("^\\d+$")) {
                break;
            }
            System.out.println("Invalid choice entered, please try again with digits only.");
        }

        // Enter quantity for a product
        while (true) {
            System.out.print("Enter the product quantity to purchase: ");
            productQty = sc.nextLine();
            if (productQty.matches("^\\d+$")) {
                break;
            }
            System.out.println("Invalid choice entered, please try again with digits only.");
        }

        Product prod = productList.get(Integer.parseInt(productChoice) - 1);
        if (prod.getProductQty() > Integer.parseInt(productQty)) {
            prod.setProductQty(prod.getProductQty() - Integer.parseInt(productQty));
            productOrder = new ProductOrder(productList.get(Integer.parseInt(productChoice) - 1), Integer.parseInt(productQty));
        }

        return productOrder;
    }

    private static ProductOrder purchasePromotionProducts(PromotionCatalogue promotionCatalogue) {
        String productChoice = "", productQty = "";
        System.out.print("Promotion product available this month!\n"
                + promotionCatalogue.getPromotionName());

        ProductOrder productOrder = null;
        ListInterface<Product> promotionProduct = promotionCatalogue.getPromotionProductList();

        for (int i = 0; i < promotionProduct.size(); i++) {
            System.out.println(
                    String.format("%-4d \t %-10s \t %-20s \t %-10s \t %-30s \t RM %5.2f \t\t %-10d \t %s ",
                            i + 1,
                            promotionProduct.get(i).getProductID(),
                            promotionProduct.get(i).getProductName(),
                            promotionProduct.get(i).getFlowerType().getFlowerName(),
                            promotionProduct.get(i).getProductDescription(),
                            promotionProduct.get(i).getProductPrice(),
                            promotionProduct.get(i).getProductQty(),
                            promotionProduct.get(i).isInStock()
                    )
            );
        }

        // Enter product index no.
        while (true) {
            System.out.print("Enter the product no. to order: ");
            productChoice = sc.nextLine();
            if (productChoice.matches("^\\d+$")) {
                break;
            }
            System.out.println("Invalid choice entered, please try again with digits only.");
        }

        // Enter quantity for a product
        while (true) {
            System.out.print("Enter the product quantity to purchase: ");
            productQty = sc.nextLine();
            if (productQty.matches("^\\d+$")) {
                break;
            }
            System.out.println("Invalid choice entered, please try again with digits only.");
        }

        Product prod = promotionProduct.get(Integer.parseInt(productChoice) - 1);
        if (prod.getProductQty() > Integer.parseInt(productQty)) {
            prod.setProductQty(prod.getProductQty() - Integer.parseInt(productQty));
            productOrder = new ProductOrder(promotionProduct.get(Integer.parseInt(productChoice) - 1), Integer.parseInt(productQty));
        }

        return productOrder;
    }

}

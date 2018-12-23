package CustomerAndInvoice_SamuelWKF;

import adt.LList;
import adt.ListInterface;
import model.Consumer;
import model.Corporate;
import model.Invoice;
import model.Order;
import model.ProductOrder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Samuel Wong Kim Foong
 */
public class Utility {

    private static Scanner sc = new Scanner(System.in);
    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    private final static SimpleDateFormat SIMPLE_DATE_TIME_FORMAT = new SimpleDateFormat("dd-MM-yyyy hh:mm");

    // Method to display module's main menu
    public static int mainMenu() {
        String choice = "";
        while (true) {
            System.out.print("==== Customer Maintenance & Invoice Payment ====\n"
                    + "1. Show customer list\n"
                    + "2. Register new customer\n"
                    + "3. Update customer details\n"
                    + "4. Generate Invoice\n"
                    + "5. Back\n"
                    + "Enter your choice: ");
            choice = sc.nextLine();
            if (choice.matches("^[1-5]$")) {
                break;
            }
            System.out.println("Invalid choice entered, please try again with only choice 1-5.\n");
        }
        return Integer.parseInt(choice);
    }

    // Method to show customer list
    public static int showCustomerList(ListInterface<Consumer> consumerList, ListInterface<Corporate> corporateList) {
        String choice = "";

        while (true) {
            System.out.print("\n==== Display customer list ====\n"
                    + "1. Consumer List\n"
                    + "2. Corporate List\n"
                    + "3. Back\n"
                    + "Enter your choice: ");
            choice = sc.nextLine();

            if (choice.matches("^[1-3]$")) {
                break;
            }

            System.out.println("Invalid choice entered, please try again with only choice 1-3.\n");
        }

        if (choice.equals("1")) {
            displayConsumerList(consumerList);
        } else if (choice.equals("2")) {
            displayCorporateList(corporateList);
        }

        return Integer.parseInt(choice);
    }

    // Method to display register new customer menu
    public static void registerNewCustomerMenu(ListInterface<Consumer> consumerList, ListInterface<Corporate> corporateList) {
        String choice = "";
        while (true) {
            System.out.print("\n==== Register New Customer ====\n"
                    + "1. Register new consumer\n"
                    + "2. Register new corporate\n"
                    + "3. Back\n"
                    + "Enter your choice: ");
            choice = sc.nextLine();
            if (choice.matches("^[1-5]$")) {
                break;
            }
            System.out.println("Invalid choice entered, please try again with only choice 1-5.\n");
        }

        // Register new consumer
        if (choice.equals("1")) {
            Utility.registerNewConsumer(consumerList);
        } else if (choice.equals("2")) {
            Utility.registerNewCorporate(corporateList);
        }
    }

    // Method to perform registration of new consumerList
    public static void registerNewConsumer(ListInterface<Consumer> consumerList) {
        String consumerName = "", icNum = "", address = "", contactNo = "";
        boolean existingConsumer = false;

        System.out.println("\n==== Register New Consumer ====");
        // Get consumer name
        while (true) {
            System.out.print("Enter consumer name: ");
            consumerName = sc.nextLine();
            if (consumerName.matches("^[A-z\\-\\@ ]+$")) {
                break;
            }
            System.out.println("Invalid name format entered, please try again with alphabetic only.\n");
        }

        // Get IC number
        while (true) {
            System.out.print("Enter IC number: ");
            icNum = sc.nextLine();
            if (icNum.matches("^\\d{12}$")) {
                break;
            }
            System.out.println("Invalid IC number format entered, please try again with 12 digit only.\n");
        }

        // Get home address
        while (true) {
            System.out.print("Enter address: ");
            address = sc.nextLine();
            if (address.matches("^[A-z0-9\\,\\@\\-\\. ]+$")) {
                break;
            }
            System.out.println("Invalid address format entered, please try again with alphabetic and symbols only.\n");
        }

        // Get contact number
        while (true) {
            System.out.print("Enter contact number: ");
            contactNo = sc.nextLine();
            if (contactNo.matches("^\\d{8,20}$")) {
                break;
            }
            System.out.println("Invalid contact number format entered, please try again with digits only.\n");
        }

        // Creating new consumer object for the new consumer
        Consumer newCon = new Consumer(String.format("CN%04d", consumerList.size() + 1), consumerName, icNum, address, contactNo);

        // For loop to check for existing consumer
        for (int i = 0; i < consumerList.size(); i++) {
            if (consumerList.get(i).getConsumerName().equals(newCon.getConsumerName()) && consumerList.get(i).getIcNum().equals(newCon.getIcNum())) {
                existingConsumer = true;
                break;
            }
        }

        if (!existingConsumer) {
            consumerList.add(newCon);
            System.out.println("New consumer has been successfully registered!\n");
        } else {
            System.out.println("Uh oh! The consumer has already exist in the system.\n");
        }
    }

    // Method to perform registration of new corporate
    public static void registerNewCorporate(ListInterface<Corporate> corporateList) {
        String corporateName = "", creditLimit = "", address = "", contactNo = "";
        boolean existingCorporate = false;

        System.out.println("\n==== Register New Corporate ====");
        // Get corporates name
        while (true) {
            System.out.print("Enter corporate name: ");
            corporateName = sc.nextLine();
            if (corporateName.matches("^[A-z0-9\\-\\@\\. ]+$")) {
                break;
            }
            System.out.println("Invalid name format entered, please try again with alphabetic only.\n");
        }

        // Get corporate address
        while (true) {
            System.out.print("Enter address: ");
            address = sc.nextLine();
            if (address.matches("^[A-z0-9\\,\\@\\-\\. ]+$")) {
                break;
            }
            System.out.println("Invalid address format entered, please try again with alphabetic and symbols only.\n");
        }

        // Get contact number
        while (true) {
            System.out.print("Enter contact number: ");
            contactNo = sc.nextLine();
            if (contactNo.matches("^\\d{8,20}$")) {
                break;
            }
            System.out.println("Invalid contact number format entered, please try again with digits only.\n");
        }

        // Set the corporate credit limit
        while (true) {
            System.out.print("Enter credit limit: ");
            creditLimit = sc.nextLine();
            if (creditLimit.matches("^\\d+\\.?\\d+$")) {
                break;
            }
            System.out.println("Invalid credit limit format entered, please try again with floating digits only.\n");
        }

        // Creating new corporate object for the new corporate
        Corporate newCorp = new Corporate(String.format("CO%04d", corporateList.size() + 1), corporateName, address, contactNo, Double.parseDouble(creditLimit), Double.parseDouble(creditLimit));

        // For loop to check for existing corporate
        for (int i = 0; i < corporateList.size(); i++) {
            if (corporateList.get(i).getCorporateName().equals(newCorp.getCorporateName()) && corporateList.get(i).getAddress().equals(newCorp.getAddress())) {
                existingCorporate = true;
                break;
            }
        }

        if (!existingCorporate) {
            corporateList.add(newCorp);
            System.out.println("New corporate has been successfully registered!\n");
        } else {
            System.out.println("Uh oh! The corporate has already exist in the system.\n");
        }
    }

    // Method to display update customer menu
    public static void updateCustomer(ListInterface<Consumer> consumerList, ListInterface<Corporate> corporateList) {
        int custType = Utility.showCustomerList(consumerList, corporateList);

        // Check if user input is "Back"
        if (custType == 3) {
            return;
        }

        String choice = "";

        while (true) {
            System.out.print("Enter customer number: ");
            choice = sc.nextLine();
            if (choice.matches("^[0-9]+$")) {
                break;
            }
            System.out.println("Invalid choice entered, please try again with only digits.\n");
        }

        if (custType == 1) {
            Utility.updateConsumer(Integer.parseInt(choice), consumerList);
        } else if (custType == 2) {
            Utility.updateCorporate(Integer.parseInt(choice), corporateList);
        }
    }

    // Method to perform update details of existing consumer
    public static void updateConsumer(int custIndex, ListInterface<Consumer> consumerList) {
        String choice = "", cont = "";

        do {
            System.out.print(String.format("\n==== Update Consumer (%s) Details ====\n"
                    + "1. Update consumer name\n"
                    + "2. Update consumer IC number\n"
                    + "3. Update consumer home address\n"
                    + "4. Update conusmer contact number\n"
                    + "Enter your choice: ", consumerList.get(custIndex - 1).getConsumerId()));
            choice = sc.nextLine();

            // Input validation
            while (!choice.matches("^[1-4]$")) {
                System.out.println("Invalid choice entered, please try again with only choice 1-4.\n");
                System.out.print("Enter your choice: ");
                choice = sc.nextLine();
            }

            switch (choice) {
                case "1":
                    // Update consumer name
                    String consumerName = "";
                    while (true) {
                        System.out.print("Enter updated name: ");
                        consumerName = sc.nextLine();
                        if (consumerName.matches("^[A-z\\-\\@ ]+$")) {
                            consumerList.get(custIndex - 1).setConsumerName(consumerName);
                            break;
                        }
                        System.out.println("Invalid name format entered, please try again with alphabetic only.\n");
                    }
                    break;
                case "2":
                    // Update consumer IC number
                    String icNum = "";
                    while (true) {
                        System.out.print("Enter updated IC number: ");
                        icNum = sc.nextLine();
                        if (icNum.matches("^\\d{12}$")) {
                            consumerList.get(custIndex - 1).setIcNum(icNum);
                            break;
                        }
                        System.out.println("Invalid IC number format entered, please try again with 12 digit only.\n");
                    }
                    break;
                case "3":
                    // Update consumer home address
                    String address = "";
                    while (true) {
                        System.out.print("Enter updated home address: ");
                        address = sc.nextLine();
                        if (address.matches("^[A-z0-9\\,\\@\\-\\. ]+$")) {
                            consumerList.get(custIndex - 1).setAddress(address);
                            break;
                        }
                        System.out.println("Invalid address format entered, please try again with alphabetic and symbols only.\n");
                    }
                    break;
                case "4":
                    // Update consumer contact number
                    String contactNo = "";
                    while (true) {
                        System.out.print("Enter updated contact number: ");
                        contactNo = sc.nextLine();
                        if (contactNo.matches("^\\d{8,20}$")) {
                            consumerList.get(custIndex - 1).setContactNo(contactNo);
                            break;
                        }
                        System.out.println("Invalid contact number format entered, please try again with digits only.\n");
                    }
                    break;
                default:
                    break;
            }
            System.out.println("The consumer details has been successfully updated!");

            // Prompt for continue to update consumer details
            while (true) {
                System.out.print(String.format("Continue to update other details for customer %s? (Y/N): ", consumerList.get(custIndex - 1).getConsumerId()));
                cont = sc.nextLine();
                if (cont.matches("^[YyNn]$")) {
                    break;
                }
                System.out.println("Invalid choice entered, please enter only \"Y\" or \"N\" case insensitive.\n");
            }
        } while (cont.matches("^(Y|y)$"));
    }

    // Method to perform update details of existing corporate
    public static void updateCorporate(int corpIndex, ListInterface<Corporate> corporateList) {
        String choice = "", cont = "";

        do {
            System.out.print(String.format("\n==== Update Consumer (%s) Details ====\n"
                    + "1. Update corporate name\n"
                    + "2. Update corporate contact number\n"
                    + "3. Update corporate address\n"
                    + "4. Update corporate credit limit\n"
                    + "Enter your choice: ", corporateList.get(corpIndex - 1).getCorporateId()));
            choice = sc.nextLine();

            // Input validation
            while (!choice.matches("^[1-4]$")) {
                System.out.println("Invalid choice entered, please try again with only choice 1-4.\n");
                System.out.print("Enter your choice: ");
                choice = sc.nextLine();
            }

            switch (choice) {
                case "1":
                    // Update corporate name
                    String corporateName = "";
                    while (true) {
                        System.out.print("Enter updated corporate name: ");
                        corporateName = sc.nextLine();
                        if (corporateName.matches("^[A-z\\-\\@ ]+$")) {
                            corporateList.get(corpIndex - 1).setCorporateName(corporateName);
                            break;
                        }
                        System.out.println("Invalid corporate name format entered, please try again with alphabetic only.\n");
                    }
                    break;
                case "2":
                    // Update corporate contact number
                    String contactNo = "";
                    while (true) {
                        System.out.print("Enter updated corporate contact number: ");
                        contactNo = sc.nextLine();
                        if (contactNo.matches("^\\d{8,20}$")) {
                            corporateList.get(corpIndex - 1).setContactNo(contactNo);
                            break;
                        }
                        System.out.println("Invalid contact number format entered, please try again with digits only.\n");
                    }
                    break;
                case "3":
                    // Update corporate address
                    String address = "";
                    while (true) {
                        System.out.print("Enter updated corporate address: ");
                        address = sc.nextLine();
                        if (address.matches("^[A-z0-9\\,\\@\\-\\. ]+$")) {
                            corporateList.get(corpIndex - 1).setAddress(address);
                            break;
                        }
                        System.out.println("Invalid address format entered, please try again with alphabetic and symbols only.\n");
                    }
                    break;
                case "4":
                    // Update corporate credit limit
                    String creditLimit = "";
                    while (true) {
                        System.out.print("Enter updated credit limit: ");
                        creditLimit = sc.nextLine();
                        if (creditLimit.matches("^\\d+\\.?\\d+$")) {
                            if (corporateList.get(corpIndex - 1).getCreditLimit() == corporateList.get(corpIndex - 1).getCurrentCreditLimit()) {
                                corporateList.get(corpIndex - 1).setCurrentCreditLimit(Double.parseDouble(creditLimit));
                            }
                            corporateList.get(corpIndex - 1).setCreditLimit(Double.parseDouble(creditLimit));
                            break;
                        }
                        System.out.println("Invalid credit limit format entered, please try again with floating digits only.\n");
                    }
                    break;
                default:
                    break;
            }
            System.out.println("The corporate details has been successfully updated!");

            while (true) {
                System.out.print(String.format("Continue to update other details for corporate %s? (Y/N): ", corporateList.get(corpIndex - 1).getCorporateId()));
                cont = sc.nextLine();
                if (cont.matches("^[YyNn]$")) {
                    break;
                }
                System.out.println("Invalid choice entered, please enter only \"Y\" or \"N\" case insensitive.\n");
            }
        } while (cont.matches("^(Y|y)$"));
    }

    // Method to perform generate invoice
    public static void generateInvoice(ListInterface<Invoice> invoiceList) {

        // Variable declaration
        String choice = "";
        double totalPrice = 0.0;

        // Display corporates with invoice
        displayCorporateInvoiceList(invoiceList);

        // Get user input
        while (true) {
            System.out.print("Enter corporate number: ");
            choice = sc.nextLine();
            if (choice.matches("^([0-9])+$") && Integer.parseInt(choice) <= invoiceList.size()) {
                break;
            }
            System.out.println("Invalid choice entered, please try again with only digits and within the range.\n");
        }

        // Parse user input to int
        int i = Integer.parseInt(choice) - 1;

        System.out.println(
                String.format("\nInvoice ID: %s\n"
                        + "Issued On: %s\n"
                        + "Due Date: %s\n"
                        + "Corporate Name: %s (%s)\n"
                        + "Billing Address: %s",
                        invoiceList.get(i).getInvoiceID(),
                        SIMPLE_DATE_FORMAT.format(invoiceList.get(i).getIssuedOn()),
                        SIMPLE_DATE_FORMAT.format(invoiceList.get(i).getDueDate()),
                        invoiceList.get(i).getCorporate().getCorporateName(),
                        invoiceList.get(i).getCorporate().getCorporateId(),
                        invoiceList.get(i).getCorporate().getAddress())
        );

        // Top level loop for displaying the orders
        // for a specific corporate
        ListInterface<Order> orderList = invoiceList.get(i).getOrders();
        for (int j = 0; j < orderList.size(); j++) {
            System.out.println(
                    String.format("\nOrder ID: %s \t Ordered On: %s",
                            orderList.get(j).getOrderID(),
                            SIMPLE_DATE_FORMAT.format(orderList.get(j).getOrderedOn()))
            );

            // First level loop for displaying the individual
            // product for a specific order
            ListInterface<ProductOrder> poList = orderList.get(j).getProductOrders();
            invoiceHeader(1);
            for (int k = 0; k < poList.size(); k++) {
                System.out.println(
                        String.format("%-10s \t %-25s \t %-10d \t %10.2f \t %10.2f",
                                poList.get(k).getProduct().getProductID(),
                                poList.get(k).getProduct().getProductName(),
                                poList.get(k).getQuantity(),
                                poList.get(k).getProduct().getProductPrice(),
                                poList.get(k).getProduct().getProductPrice() * poList.get(k).getQuantity())
                );

                // Add total price
                totalPrice += poList.get(k).getProduct().getProductPrice() * poList.get(k).getQuantity();
            }
            invoiceHeader(2);
        }

        // Display the total payment for an invoice
        System.out.println(String.format("%74s TOTAL: RM %.2f", " ", totalPrice));
        System.out.println(String.format("** PLEASE pay this amount by %s", SIMPLE_DATE_FORMAT.format(invoiceList.get(i).getDueDate())));

        // Check invoice due date already passed
        if (new Date().after(invoiceList.get(i).getDueDate())) {
            System.out.println(
                    String.format("Invoice Due Date: %s\nToday's Date: %s\nInvoice already passed the due date, please pay the amount before any order on credits can be made.\n",
                            SIMPLE_DATE_FORMAT.format(invoiceList.get(i).getDueDate()),
                            SIMPLE_DATE_FORMAT.format(new Date())
                    )
            );
        }

        while (true) {
            System.out.print("Mark this invoice as paid? (Y/N): ");
            choice = sc.nextLine();
            if (choice.matches("^[YynN]$")) {
                break;
            }
            System.out.println("Invalid choice entered, please try again with only 'Y' or 'N'.\n");
        }

        if (choice.matches("^[Yy]$")) {
            Corporate corporate = invoiceList.get(i).getCorporate();
            corporate.setCurrentCreditLimit(corporate.getCurrentCreditLimit() + totalPrice);
            invoiceList.get(i).setStatus(1);
            System.out.println("Invoice has been successfully paid, thank you!\n");
        }
    }

    /**
     * Private methods
     */
    // Private method to display corporate list for invoice list
    private static void displayCorporateInvoiceList(ListInterface<Invoice> invoiceList) {
        int i = 0;
        System.out.println("==================================================================================================================================");
        System.out.println(
                String.format("%s %-8s \t %-20s \t %-20s \t %-30s \t %-10s",
                        "No.", "Invoice ID", "Issued On", "Due Date",
                        "Corporate Name (ID)", "Invoice Status")
        );
        System.out.println("==================================================================================================================================");

        for (i = 0; i < invoiceList.size(); i++) {
            if (!invoiceList.get(i).getStatus().equals("Paid")) {
                System.out.println(
                        String.format("%d. %-8s \t %-10s \t %-10s \t %-20s (%-6s) \t\t %-10s",
                                i + 1,
                                invoiceList.get(i).getInvoiceID(),
                                SIMPLE_DATE_TIME_FORMAT.format(invoiceList.get(i).getIssuedOn()),
                                SIMPLE_DATE_TIME_FORMAT.format(invoiceList.get(i).getDueDate()),
                                invoiceList.get(i).getCorporate().getCorporateName(),
                                invoiceList.get(i).getCorporate().getCorporateId(),
                                invoiceList.get(i).getStatus()
                        )
                );
            }
        }
        System.out.println("==================================================================================================================================");

        System.out.println(String.format("Total %d invoice(s)", i));
    }

    // Private method to display consumer list
    private static void displayConsumerList(ListInterface<Consumer> consumerList) {
        int i = 0;
        displayCustomerHeaderFooter(1);
        for (i = 0; i < consumerList.size(); i++) {
            System.out.println(String.format("%d. %-15s \t %-30s \t %-15s \t %-12s \t %-40s", i + 1,
                    consumerList.get(i).getConsumerId(),
                    consumerList.get(i).getConsumerName(),
                    consumerList.get(i).getContactNo(),
                    consumerList.get(i).getIcNum(),
                    consumerList.get(i).getAddress())
            );
        }
        displayCustomerHeaderFooter(2);
        System.out.println(String.format("Total %d consumer(s).", i));
    }

    // Private method to display corporate list
    private static void displayCorporateList(ListInterface<Corporate> corporateList) {
        int i = 0;
        displayCustomerHeaderFooter(3);
        for (i = 0; i < corporateList.size(); i++) {
            System.out.println(String.format("%d. %-15s \t %-20s \t %-12s \t %-80s \t %10.2f \t %10.2f",
                    i + 1,
                    corporateList.get(i).getCorporateId(),
                    corporateList.get(i).getCorporateName(),
                    corporateList.get(i).getContactNo(),
                    corporateList.get(i).getAddress(),
                    corporateList.get(i).getCreditLimit(),
                    corporateList.get(i).getCurrentCreditLimit())
            );
        }
        displayCustomerHeaderFooter(4);
        System.out.println(String.format("Total %d corporate customer(s).", i));
    }

    /**
     * Menu Header/Footer Section
     */
    // Private method to display invoice list's header/footer
    private static void invoiceHeader(int choice) {
        switch (choice) {
            case 1:
                System.out.println("===============================================================================================");
                System.out.println(String.format("Product ID \t Product Name \t\t Quantity Ordered \t Price/unit %-10s Total", " "));
                System.out.println("===============================================================================================");
                break;
            case 2:
                System.out.println("===============================================================================================");
        }
    }

    // Private method to display customer list's header/footer
    private static void displayCustomerHeaderFooter(int choice) {
        switch (choice) {
            case 1:
                System.out.println("\n========== Consumer List ==========");
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println(String.format("No. %-12s \t %-30s \t %-12s \t %-12s \t %-40s", "Consumer ID", "Consumer Name", "Contact Number", "IC Number", "Home Address"));
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;
            case 2:
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;
            case 3:
                System.out.println("\n========== Corporate List ==========");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println(String.format("No. %-10s \t %-5s \t %-30s \t %-60s \t %-10s \t %-10s", "Corporate ID", "Corporate Name", "Contact Number", "Address", "Credit Limit", "Current Credit Limit"));
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;
            case 4:
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;
        }
    }

}

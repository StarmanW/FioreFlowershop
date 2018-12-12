package fioreflowershop.custMaintenanceAndIP;

import fioreflowershop.ADT.LList;
import fioreflowershop.ADT.ListInterface;
import fioreflowershop.Models.Consumer;
import fioreflowershop.Models.Corporate;
import fioreflowershop.Models.Invoice;
import fioreflowershop.Models.Order;
import fioreflowershop.Models.ProductOrder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel Wong Kim Foong
 */
public class Utility {

    private static Scanner sc = new Scanner(System.in);
    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Generate sample data section
     */
    // Method to get hardcoded Consumers
    public static ListInterface<Consumer> generateConsumerList() {
        ListInterface<Consumer> consumerListumers = new LList<>();

        consumerListumers.add(new Consumer("CN0001", "John Starling", "658874123356", "1590 W San Marcos Blvd #UNT 145, San Marcos, CA, 92078", "0214446598"));
        consumerListumers.add(new Consumer("CN0002", "Derek Bernas", "985546213598", "Cardinal, Climax Springs, MO, 65324", "0153226854"));
        consumerListumers.add(new Consumer("CN0003", "Kim Mary", "789952123364", "19 Sheppard Ln, Lee, NH, 03861", "01123265649"));
        consumerListumers.add(new Consumer("CN0004", "Hank Anderson", "895512302548", "809 W 2nd Ave, Flandreau, SD, 57028", "0015589796"));
        consumerListumers.add(new Consumer("CN0005", "Michelle Jane", "924456215597", "50 Watertown St, Watertown, MA, 02472", "0125568753"));

        return consumerListumers;
    }

    // Method to get hardcoded Corporates
    public static ListInterface<Corporate> generateCorporateList() {
        ListInterface<Corporate> corporateList = new LList<>();

        corporateList.add(new Corporate("CO0001", "Apple Arts Sdn. Bhd.", "144 Lrg Zamrud 3/1 Taman Pekan Baru 08000 Sungai Petani 08000, Malaysia", "03745625", 12500.00, 1200.00));
        corporateList.add(new Corporate("CO0002", "Alpinetime Sdn. Bhd.", "288 Lt Avenue, Jalan Petagas, WP, Kuala Lumpur, Malaysia", "03954622", 6500.00, 2000.00));
        corporateList.add(new Corporate("CO0003", "Robin Corporation", "350, Jalan Tun Fuad, 82000, WP, Kuala Lumpur, Malaysia", "03455895", 7000.00, 400.00));
        corporateList.add(new Corporate("CO0004", "Moonlit Ltd.", "6812 Murphy Dale, Jalan Penampang, 82000, Wangsa Maju, WP, Kuala Lumpur, Malaysia", "03455688", 15000.00, 200.00));
        corporateList.add(new Corporate("CO0005", "Pixycloud Ltd.", "Lt 280, Jalan Luyang, 25000, WP, Kuala Lumpur, Malaysia", "03467855", 8500.00, 1400.00));

        return corporateList;
    }

    // Method to get hardcoded Invoice
    public static ListInterface<Invoice> generateInvoiceList(ListInterface<Order> orderList) {
        ListInterface<Invoice> invoiceList = new LList<>();

        ListInterface<Order> corporateOrderList1 = new LList<>();
        corporateOrderList1.add(orderList.get(0));
        corporateOrderList1.add(orderList.get(1));

        ListInterface<Order> corporateOrderList2 = new LList<>();
        corporateOrderList2.add(orderList.get(2));
        corporateOrderList2.add(orderList.get(3));

        try {
            invoiceList.add(new Invoice("INV0001", orderList.get(0).getCustomer(), SIMPLE_DATE_FORMAT.parse("30-11-2018"), SIMPLE_DATE_FORMAT.parse("7-12-2018"), corporateOrderList1));
            invoiceList.add(new Invoice("INV0002", orderList.get(2).getCustomer(), SIMPLE_DATE_FORMAT.parse("30-12-2018"), SIMPLE_DATE_FORMAT.parse("7-01-2019"), corporateOrderList2));
        } catch (ParseException ex) {
            Logger.getLogger(fioreflowershop.catalogueOrder.Utility.class.getName()).log(Level.SEVERE, null, ex);
        }

        return invoiceList;
    }

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
                    + "1. Register new consumerListumer\n"
                    + "2. Register new corporate\n"
                    + "3. Back\n"
                    + "Enter your choice: ");
            choice = sc.nextLine();
            if (choice.matches("^[1-5]$")) {
                break;
            }
            System.out.println("Invalid choice entered, please try again with only choice 1-5.\n");
        }

        // Register new consumerListumer
        if (choice.equals("1")) {
            Utility.registerNewConsumer(consumerList);
        } else if (choice.equals("2")) {
            Utility.registerNewCorporate(corporateList);
        }
    }

    // Method to perform registration of new consumerListumer
    public static void registerNewConsumer(ListInterface<Consumer> consumerListumers) {
        String consumerListumerName = "", icNum = "", address = "", contactNo = "";
        boolean existingConsumer = false;

        System.out.println("\n==== Register New Consumer ====");
        // Get consumerListumer name
        while (true) {
            System.out.print("Enter consumerListumer name: ");
            consumerListumerName = sc.nextLine();
            if (consumerListumerName.matches("^[A-z\\-\\@ ]+$")) {
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

        // Creating new consumerListumer object for the new consumerListumer
        Consumer newCon = new Consumer(String.format("CN%04d", consumerListumers.size() + 1), consumerListumerName, icNum, address, contactNo);

        // For loop to check for existing consumerListumer
        for (int i = 0; i < consumerListumers.size(); i++) {
            if (consumerListumers.get(i).getConsumerName().equals(newCon.getConsumerName()) && consumerListumers.get(i).getIcNum().equals(newCon.getIcNum())) {
                existingConsumer = true;
                break;
            }
        }

        if (!existingConsumer) {
            consumerListumers.add(newCon);
            System.out.println("New consumerListumers has been successfully registered!\n");
        } else {
            System.out.println("Uh oh! The consumerListumers has already exist in the system.\n");
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

    // Method to perform update details of existing consumerListumer
    public static void updateConsumer(int custIndex, ListInterface<Consumer> consumerList) {
        String choice = "", cont = "";

        do {
            System.out.print(String.format("\n==== Update Consumer (%s) Details ====\n"
                    + "1. Update consumerListumer name\n"
                    + "2. Update consumerListumer IC number\n"
                    + "3. Update consumerListumer home address\n"
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
                    // Update consumerListumer name
                    String consumerListumerName = "";
                    while (true) {
                        System.out.print("Enter updated name: ");
                        consumerListumerName = sc.nextLine();
                        if (consumerListumerName.matches("^[A-z\\-\\@ ]+$")) {
                            consumerList.get(custIndex - 1).setConsumerName(consumerListumerName);
                            break;
                        }
                        System.out.println("Invalid name format entered, please try again with alphabetic only.\n");
                    }
                    break;
                case "2":
                    // Update consumerListumer IC number
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
                    // Update consumerListumer home address
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
                    // Update consumerListumer contact number
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
            System.out.println("The consumerListumer details has been successfully updated!");

            // Prompt for continue to update consumerListumer details
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
        displayCorporateList(filterCorporateInvoiceList(invoiceList));

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
            invoiceList.remove(i);
            System.out.println("Invoice has been successfully paid, thank you!\n");
        }
    }

    /**
     * Private methods
     */
    // Private method to filter corporate list for invoice list
    private static ListInterface<Corporate> filterCorporateInvoiceList(ListInterface<Invoice> invoiceList) {
        // Add corporate object into list of corporates with invoice
        ListInterface<Corporate> corporateInvoiceList = new LList<>();
        for (int i = 0; i < invoiceList.size(); i++) {
            if (corporateInvoiceList.contains(invoiceList.get(i).getCorporate()) == -1) {
                corporateInvoiceList.add(invoiceList.get(i).getCorporate());
            }
        }
        return corporateInvoiceList;
    }

    // Private method to display consumerListumer list
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
        System.out.println(String.format("Total %d consumerListumer customer(s).", i));
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

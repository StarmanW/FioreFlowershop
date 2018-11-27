package fioreflowershop.custMaintenanceAndIP;

import fioreflowershop.ADT.ArrayLList;
import fioreflowershop.ADT.ListInterface;
import fioreflowershop.Models.Consumer;
import fioreflowershop.Models.Corporate;
import java.util.Scanner;

/**
 *
 * @author Samuel Wong Kim Foong
 */
public class Utility {

    private static Scanner sc = new Scanner(System.in);

    // Method to get hardcoded Consumers
    public static ListInterface<Consumer> generateConsumerList() {
        ListInterface<Consumer> consumers = new ArrayLList<>();

        consumers.add(new Consumer("CN0001", "John Starling", "658874123356", "1590 W San Marcos Blvd #UNT 145, San Marcos, CA, 92078", "0214446598"));
        consumers.add(new Consumer("CN0002", "Derek Bernas", "985546213598", "Cardinal, Climax Springs, MO, 65324", "0153226854"));
        consumers.add(new Consumer("CN0003", "Kim Mary", "789952123364", "19 Sheppard Ln, Lee, NH, 03861", "01123265649"));
        consumers.add(new Consumer("CN0004", "Hank Anderson", "895512302548", "809 W 2nd Ave, Flandreau, SD, 57028", "0015589796"));
        consumers.add(new Consumer("CN0005", "Michelle Jane", "924456215597", "50 Watertown St, Watertown, MA, 02472", "0125568753"));

        return consumers;
    }

    // Method to get hardcoded Corporates
    public static ListInterface<Corporate> generateCorporateList() {
        ListInterface<Corporate> corps = new ArrayLList<>();

        corps.add(new Corporate("CO0001", "Apple Arts Sdn. Bhd.", "144 Lrg Zamrud 3/1 Taman Pekan Baru 08000 Sungai Petani 08000, Malaysia", "03745625", 1400.00));
        corps.add(new Corporate("CO0002", "Alpinetime Sdn. Bhd.", "288 Lt Avenue, Jalan Petagas, WP, Kuala Lumpur, Malaysia", "03954622", 1800.00));
        corps.add(new Corporate("CO0003", "Robin Corporation", "350, Jalan Tun Fuad, 82000, WP, Kuala Lumpur, Malaysia", "034557895", 1200.00));
        corps.add(new Corporate("CO0004", "Moonlit Ltd.", "6812 Murphy Dale, Jalan Penampang, 82000, Wangsa Maju, WP, Kuala Lumpur, Malaysia", "03455688", 1500.00));
        corps.add(new Corporate("CO0005", "Pixycloud Ltd.", "Lt 280, Jalan Luyang, 25000, WP, Kuala Lumpur, Malaysia", "03467855", 2000.00));

        return corps;
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
    public static int showCustomerList(ListInterface<Consumer> cons, ListInterface<Corporate> corps) {
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
            int i = 0;

            System.out.println("\n========== Consumer List ==========");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(String.format("No. %-12s \t %-30s \t %-12s \t %-12s \t %-40s", "Consumer ID", "Consumer Name", "Contact Number", "IC Number", "Home Address"));
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (i = 0; i < cons.size(); i++) {
                System.out.println(String.format("%d. %-15s \t %-30s \t %-15s \t %-12s \t %-40s", i + 1, cons.get(i).getConsumerId(), cons.get(i).getConsumerName(), cons.get(i).getContactNo(), cons.get(i).getIcNum(), cons.get(i).getAddress()));
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

            System.out.println(String.format("Total %d consumer customer(s).", i));
        } else if (choice.equals("2")) {
            int i = 0;

            System.out.println("\n========== Corporate List ==========");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(String.format("No. %-10s \t %-5s \t %-30s \t %-60s \t %-10s \t %-10s", "Corporate ID", "Corporate Name", "Contact Number", "Address", "Credit Limit", "Current Available Credit Limit"));
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (i = 0; i < corps.size(); i++) {
                System.out.println(String.format("%d. %-15s \t %-20s \t %-12s \t %-80s \t %-6.2f", i + 1, corps.get(i).getCorporateId(), corps.get(i).getCorporateName(), corps.get(i).getContactNo(), corps.get(i).getAddress(), corps.get(i).getCreditLimit()));
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            System.out.println(String.format("Total %d corporate customer(s).", i));
        }

        return Integer.parseInt(choice);
    }

    // Method to display register new customer menu
    public static void registerNewCustomerMenu(ListInterface<Consumer> cons, ListInterface<Corporate> corps) {
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
            Utility.registerNewConsumer(cons);
        } else if (choice.equals("2")) {
            Utility.registerNewCorporate(corps);
        }
    }

    // Method to perform registration of new consumer
    public static void registerNewConsumer(ListInterface<Consumer> consumers) {
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
        Consumer newCon = new Consumer(String.format("CN%04d", consumers.size() + 1), consumerName, icNum, address, contactNo);

        // For loop to check for existing consumer
        for (int i = 0; i < consumers.size(); i++) {
            if (consumers.get(i).getConsumerName().equals(newCon.getConsumerName()) && consumers.get(i).getIcNum().equals(newCon.getIcNum())) {
                existingConsumer = true;
                break;
            }
        }

        if (!existingConsumer) {
            consumers.add(newCon);
            System.out.println("New consumers has been successfully registered!\n");
        } else {
            System.out.println("Uh oh! The consumers has already exist in the system.\n");
        }
    }

    // Method to perform registration of new corporate
    public static void registerNewCorporate(ListInterface<Corporate> corps) {
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
        Corporate newCorp = new Corporate(String.format("CO%04d", corps.size() + 1), corporateName, address, contactNo, Double.parseDouble(creditLimit));

        // For loop to check for existing corporate
        for (int i = 0; i < corps.size(); i++) {
            if (corps.get(i).getCorporateName().equals(newCorp.getCorporateName()) && corps.get(i).getAddress().equals(newCorp.getAddress())) {
                existingCorporate = true;
                break;
            }
        }

        if (!existingCorporate) {
            corps.add(newCorp);
            System.out.println("New corporate has been successfully registered!\n");
        } else {
            System.out.println("Uh oh! The corporate has already exist in the system.\n");
        }
    }

    // Method to display update customer menu
    public static void updateCustomer(ListInterface<Consumer> cons, ListInterface<Corporate> corps) {
        int custType = Utility.showCustomerList(cons, corps);

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
            Utility.updateConsumer(Integer.parseInt(choice), cons);
        } else if (custType == 2) {
            Utility.updateCorporate(Integer.parseInt(choice), corps);
        }
    }

    // Method to perform update details of existing consumer
    public static void updateConsumer(int custIndex, ListInterface<Consumer> cons) {
        String choice = "", cont = "";

        do {
            System.out.print(String.format("\n==== Update Consumer (%s) Details ====\n"
                    + "1. Update consumer name\n"
                    + "2. Update consumer IC number\n"
                    + "3. Update consumer home address\n"
                    + "4. Update conusmer contact number\n"
                    + "Enter your choice: ", cons.get(custIndex - 1).getConsumerId()));
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
                            cons.get(custIndex - 1).setConsumerName(consumerName);
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
                            cons.get(custIndex - 1).setIcNum(icNum);
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
                            cons.get(custIndex - 1).setAddress(address);
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
                            cons.get(custIndex - 1).setContactNo(contactNo);
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
                System.out.print(String.format("Continue to update other details for customer %s? (Y/N): ", cons.get(custIndex - 1).getConsumerId()));
                cont = sc.nextLine();
                if (cont.matches("^[YyNn]$")) {
                    break;
                }
                System.out.println("Invalid choice entered, please enter only \"Y\" or \"N\" case insensitive.\n");
            }
        } while (cont.matches("^(Y|y)$"));
    }

    // Method to perform update details of existing corporate
    public static void updateCorporate(int corpIndex, ListInterface<Corporate> corps) {
        String choice = "", cont = "";

        do {
            System.out.print(String.format("\n==== Update Consumer (%s) Details ====\n"
                    + "1. Update corporate name\n"
                    + "2. Update corporate contact number\n"
                    + "3. Update corporate address\n"
                    + "4. Update corporate credit limit\n"
                    + "Enter your choice: ", corps.get(corpIndex - 1).getCorporateId()));
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
                            corps.get(corpIndex - 1).setCorporateName(corporateName);
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
                            corps.get(corpIndex - 1).setContactNo(contactNo);
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
                            corps.get(corpIndex - 1).setAddress(address);
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
                            corps.get(corpIndex - 1).setCreditLimit(Double.parseDouble(creditLimit));
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
                System.out.print(String.format("Continue to update other details for corporate %s? (Y/N): ", corps.get(corpIndex - 1).getCorporateId()));
                cont = sc.nextLine();
                if (cont.matches("^[YyNn]$")) {
                    break;
                }
                System.out.println("Invalid choice entered, please enter only \"Y\" or \"N\" case insensitive.\n");
            }
        } while (cont.matches("^(Y|y)$"));
    }
}

package fioreflowershop.custMaintenanceAndIP;

import fioreflowershop.Models.ArrayList;
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
    public static ArrayList<Consumer> generateConsumerList() {
        ArrayList<Consumer> consumers = new ArrayList<>();

        consumers.add(new Consumer("CN0001", "John Starling", "658874123356", "1590 W San Marcos Blvd #UNT 145, San Marcos, CA, 92078", "0214446598"));
        consumers.add(new Consumer("CN0002", "Derek Bernas", "985546213598", "Cardinal, Climax Springs, MO, 65324", "0153226854"));
        consumers.add(new Consumer("CN0003", "Kim Mary", "789952123364", "19 Sheppard Ln, Lee, NH, 03861", "01123265649"));
        consumers.add(new Consumer("CN0004", "Hank Anderson", "895512302548", "809 W 2nd Ave, Flandreau, SD, 57028", "0015589796"));
        consumers.add(new Consumer("CN0005", "Michelle Jane", "924456215597", "50 Watertown St, Watertown, MA, 02472", "0125568753"));

        return consumers;
    }

    // Method to get hardcoded Corporates
    public static ArrayList<Corporate> generateCorporateList() {
        ArrayList<Corporate> corps = new ArrayList<>();

        corps.add(new Corporate("CO0006", "Apple Arts Sdn. Bhd.", "144 Lrg Zamrud 3/1 Taman Pekan Baru 08000 Sungai Petani 08000, Malaysia", "03745625", 1400.00));
        corps.add(new Corporate("CO0007", "Alpinetime Sdn. Bhd.", "288 Lt Avenue, Jalan Petagas, WP, Kuala Lumpur, Malaysia", "03954622", 1800.00));
        corps.add(new Corporate("CO0008", "Robin Corporation", "350, Jalan Tun Fuad, 82000, WP, Kuala Lumpur, Malaysia", "034557895", 1200.00));
        corps.add(new Corporate("CO0009", "Moonlit Ltd.", "6812 Murphy Dale, Jalan Penampang, 82000, Wangsa Maju, WP, Kuala Lumpur, Malaysia", "03455688", 1500.00));
        corps.add(new Corporate("CO0010", "Pixycloud Ltd.", "Lt 280, Jalan Luyang, 25000, WP, Kuala Lumpur, Malaysia", "03467855", 2000.00));

        return corps;
    }

    // Method to display module's main menu
    public static int mainMenu() {
        String choice = "";
        while (true) {
            System.out.print("==== Customer Maintenance & Invoice Payment ====\n"
                    + "1. Register new customer\n"
                    + "2. Show customer list\n"
                    + "3. Remove a customer\n"
                    + "4. Invoice\n"
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

    // Method to display register new customer menu
    public static void registerNewCustomerMenu(ArrayList<Consumer> cons, ArrayList<Corporate> corps) {
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
    public static void registerNewConsumer(ArrayList<Consumer> consumers) {
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
    public static void registerNewCorporate(ArrayList<Corporate> corps) {

    }

    // Method to show customer list
    public static void showCustomerList(ArrayList<Consumer> cons, ArrayList<Corporate> corps) {
        System.out.println("========== Consumer List ==========");
        for (int i = 0; i < cons.size(); i++) {
            System.out.println(String.format("%d. %-6s \t %-20s \t %-12s \t %-12s \t %-40s", i + 1, cons.get(i).getConsumerId(), cons.get(i).getConsumerName(), cons.get(i).getContactNo(), cons.get(i).getIcNum(), cons.get(i).getAddress()));
        }

        System.out.println("\n");
    }
}

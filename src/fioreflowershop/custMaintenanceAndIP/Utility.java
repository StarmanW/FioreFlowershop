package fioreflowershop.custMaintenanceAndIP;

import fioreflowershop.Models.ArrayList;
import fioreflowershop.Models.Consumer;
import fioreflowershop.Models.Corporate;
import fioreflowershop.Models.Customer;
import java.util.Scanner;

/**
 *
 * @author Samuel Wong Kim Foong
 */
public class Utility {

    private static Scanner sc = new Scanner(System.in);

    public static ArrayList<Customer> generateFlowerArrangementStyles() {
        ArrayList<Customer> custs = new ArrayList<>();

        custs.add(new Consumer("CN0001", "John Starling", "658874123356", "1590 W San Marcos Blvd #UNT 145, San Marcos, CA, 92078", "0214446598"));
        custs.add(new Consumer("CN0002", "Derek Bernas", "9855462135598", "Cardinal, Climax Springs, MO, 65324", "0153226854"));
        custs.add(new Consumer("CN0003", "Kim Mary", "789952123364", "19 Sheppard Ln, Lee, NH, 03861", "01123265649"));
        custs.add(new Consumer("CN0004", "Hank Anderson", "895512302548", "809 W 2nd Ave, Flandreau, SD, 57028", "0015589796"));
        custs.add(new Consumer("CN0005", "Michelle Jane", "924456215597", "50 Watertown St, Watertown, MA, 02472", "0125568753"));
        custs.add(new Corporate("CO0006", "Apple Arts Sdn. Bhd.", "144 Lrg Zamrud 3/1 Taman Pekan Baru 08000 Sungai Petani 08000, Malaysia", "03745625", 1400.00));
        custs.add(new Corporate("CO0007", "Alpinetime Sdn. Bhd.", "288 Lt Avenue, Jalan Petagas, WP, Kuala Lumpur, Malaysia", "03954622", 1800.00));
        custs.add(new Corporate("CO0008", "Robin Corporation", "350, Jalan Tun Fuad, 82000, WP, Kuala Lumpur, Malaysia", "034557895", 1200.00));
        custs.add(new Corporate("CO0009", "Moonlit Ltd.", "6812 Murphy Dale, Jalan Penampang, 82000, Wangsa Maju, WP, Kuala Lumpur, Malaysia", "03455688", 1500.00));
        custs.add(new Corporate("CO0010", "Pixycloud Ltd.", "Lt 280, Jalan Luyang, 25000, WP, Kuala Lumpur, Malaysia", "03467855", 2000.00));

        return custs;
    }

    public static int mainMenu() {
        String choice = "";
        while (true) {
            System.out.print("===== Customer Maintenance & Invoice Payment ====\n"
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

}

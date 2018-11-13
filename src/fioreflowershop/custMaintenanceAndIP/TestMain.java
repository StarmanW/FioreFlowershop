package fioreflowershop.custMaintenanceAndIP;

import fioreflowershop.Models.ArrayList;
import fioreflowershop.Models.Consumer;
import fioreflowershop.Models.Corporate;

/**
 * @author Samuel Wong Kim Foong
 */
public class TestMain {

    public static void main(String[] args) {
        ArrayList<Consumer> cons = Utility.generateConsumerList();
        ArrayList<Corporate> corps = Utility.generateCorporateList();

        while (true) {
            // Start main menu
            int choice = Utility.mainMenu();

            if (choice == 1) {
                Utility.registerNewCustomerMenu(cons, corps);
            } else if (choice == 2) {
                Utility.showCustomerList(cons, corps);
            } else if (choice == 5) {
                System.out.println("System shutting down now...");
                break;
            }
        }
    }
}

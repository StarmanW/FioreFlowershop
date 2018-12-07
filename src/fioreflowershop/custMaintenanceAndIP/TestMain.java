package fioreflowershop.custMaintenanceAndIP;

import fioreflowershop.ADT.ListInterface;
import fioreflowershop.Models.Consumer;
import fioreflowershop.Models.Corporate;

/**
 * @author Samuel Wong Kim Foong
 */
public class TestMain {

    public static void main(String[] args) {
        ListInterface<Consumer> cons = Utility.generateConsumerList();
        ListInterface<Corporate> corps = Utility.generateCorporateList();

        OUTER:
        while (true) {
            int choice = Utility.mainMenu();

            switch (choice) {
                case 1:
                    Utility.showCustomerList(cons, corps);
                    System.out.println("\n");
                    break;
                case 2:
                    Utility.registerNewCustomerMenu(cons, corps);
                    break;
                case 3:
                    Utility.updateCustomer(cons, corps);
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("Stub. Generate Invoice coming soon...\n");
                    break;
                case 5:
                    System.out.println("System shutting down now...");
                    break OUTER;
                default:
                    break;
            }
        }
    }
}

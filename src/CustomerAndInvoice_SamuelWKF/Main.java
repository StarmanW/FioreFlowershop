package CustomerAndInvoice_SamuelWKF;

import adt.ListInterface;
import model.Consumer;
import model.Corporate;
import model.Invoice;
import model.Order;
import model.Product;

/**
 * @author Samuel Wong Kim Foong
 */
public class Main {

    public static void mainMethod(
            ListInterface<Product> productList,
            ListInterface<Consumer> consumerList,
            ListInterface<Corporate> corporateList,
            ListInterface<Order> orderList,
            ListInterface<Invoice> invoiceList
    ) {

        // Run module
        while (true) {
            int choice = Utility.mainMenu();

            switch (choice) {
                case 1:
                    Utility.showCustomerList(consumerList, corporateList);
                    System.out.println("\n");
                    break;
                case 2:
                    Utility.registerNewCustomerMenu(consumerList, corporateList);
                    System.out.println("\n");
                    break;
                case 3:
                    Utility.updateCustomer(consumerList, corporateList);
                    System.out.println("\n");
                    break;
                case 4:
                    Utility.generateInvoice(invoiceList);
                    break;
                case 5:
                    return;
            }
        }
    }
}

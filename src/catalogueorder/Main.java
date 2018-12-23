package catalogueorder;

import adt.ListInterface;
import model.PromotionCatalogue;
import model.Consumer;
import model.Corporate;
import model.Invoice;
import model.Order;
import model.Product;

/**
 *
 * @author Thiban Kumar
 */
public class Main {

    public static void mainMethod(
            ListInterface<Product> productList,
            ListInterface<Consumer> consumerList,
            ListInterface<Corporate> corporateList,
            ListInterface<Order> orderList,
            ListInterface<Invoice> invoiceList,
            PromotionCatalogue promotionCatalogue){

        while (true) {
            int choice = Utility.mainMenu();

            switch (choice) {
                case 1:
                    Utility.makeOrder(consumerList, corporateList, invoiceList, productList, orderList, promotionCatalogue);
                    System.out.println("\n");
                    break;
                case 2:
                    Utility.generateOrderReport(orderList);
                    break;
                case 3:
                    return;
            }
        }
    }
}

package fioreflowershop.catalogueorder;

import fioreflowershop.ADT.ListInterface;
import fioreflowershop.Models.PromotionCatalogue;
import fioreflowershop.Models.Consumer;
import fioreflowershop.Models.Corporate;
import fioreflowershop.Models.Invoice;
import fioreflowershop.Models.Order;
import fioreflowershop.Models.Product;
import fioreflowershop.catalogueOrder.Utility;

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
            PromotionCatalogue promotionCatalogue
    ) {

        while (true) {
            int choice = Utility.mainMenu();

            switch (choice) {
                case 1:
                    Utility.makeOrder(consumerList, corporateList, invoiceList, productList, orderList, promotionCatalogue);
                    System.out.println("\n");
                    break;

                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}

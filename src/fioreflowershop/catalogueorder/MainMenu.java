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
 * @author Thiban
 */
public class MainMenu {

    public static void main(String[] args) {
        
        // Generate sample data
        ListInterface<Product> productList
                = fioreflowershop.CatalogueMaintenance.Utility.generateCatalogue(
                        fioreflowershop.CatalogueMaintenance.Utility.generateFlowerList(),
                        fioreflowershop.CatalogueMaintenance.Utility.generateProductTypeList(),
                        fioreflowershop.CatalogueMaintenance.Utility.generateAccessoryList()
                );
        ListInterface<Consumer> consumerList = fioreflowershop.custMaintenanceAndIP.Utility.generateConsumerList();
        ListInterface<Corporate> corporateList = fioreflowershop.custMaintenanceAndIP.Utility.generateCorporateList();
        ListInterface<Order> orderList = Utility.generateOrder(productList, corporateList);
        ListInterface<Invoice> invoiceList = fioreflowershop.custMaintenanceAndIP.Utility.generateInvoiceList(orderList);
        PromotionCatalogue promotionCatalogue = fioreflowershop.CatalogueMaintenance.Utility.generatePromoCatalogue(productList);
        
        // Run module
        while (true) {
            int choice = Utility.mainMenu();

            switch (choice) {
                case 1:
                    Utility.makeOrder(consumerList, corporateList, invoiceList, productList, orderList, promotionCatalogue);
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("System shutting down now...");
                    System.exit(0);
            }
        }
    }
}

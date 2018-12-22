package fioreflowershop.catalogueorder;

import fioreflowershop.ADT.ListInterface;
import fioreflowershop.ADT.PromotionCatalogue;
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
public class MainMenu {

    public static void main(String[] args) {

        // Generate data from module A - get flowers etc
        ListInterface<Product> productList = fioreflowershop.CatalogueMaintenance.Utility.generateCatalogue(
                fioreflowershop.CatalogueMaintenance.Utility.generateFlowerList(),
                fioreflowershop.CatalogueMaintenance.Utility.generateProductTypeList(),
                fioreflowershop.CatalogueMaintenance.Utility.generateAccessoryList());

        
        // Get customer and consumer details from module B
        ListInterface<Consumer> consumerList = fioreflowershop.custMaintenanceAndIP.Utility.generateConsumerList();
        ListInterface<Corporate> corporateList = fioreflowershop.custMaintenanceAndIP.Utility.generateCorporateList();
        //New order created
        ListInterface<Order> orderList = Utility.generateOrder(productList, corporateList);
        //generate invoice based on corporate customer order - module B
        ListInterface<Invoice> invoiceList = fioreflowershop.custMaintenanceAndIP.Utility.generateInvoiceList(orderList);
        //get promotion catalogue from module A
        PromotionCatalogue promotionCatalogue = fioreflowershop.CatalogueMaintenance.Utility.generatePromoCatalogue(productList);

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

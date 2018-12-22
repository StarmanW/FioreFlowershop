package fioreflowershop.custMaintenanceAndIP;

import fioreflowershop.ADT.ListInterface;
import fioreflowershop.Models.Consumer;
import fioreflowershop.Models.Corporate;
import fioreflowershop.Models.Invoice;
import fioreflowershop.Models.Order;
import fioreflowershop.Models.Product;

/**
 * @author Samuel Wong Kim Foong
 */
public class TestMain {

    public static void main(String[] args) {
        
        // Generate sample data
        ListInterface<Product> productList
                = fioreflowershop.CatalogueMaintenance.Utility.generateCatalogue(
                        fioreflowershop.CatalogueMaintenance.Utility.generateFlowerList(),
                        fioreflowershop.CatalogueMaintenance.Utility.generateProductTypeList(),
                        fioreflowershop.CatalogueMaintenance.Utility.generateAccessoryList()
                );
        ListInterface<Consumer> consumerList = Utility.generateConsumerList();
        ListInterface<Corporate> corporateList = Utility.generateCorporateList();
        ListInterface<Order> orderList = fioreflowershop.catalogueOrder.Utility.generateOrder(productList, corporateList);
        ListInterface<Invoice> invoiceList = Utility.generateInvoiceList(orderList);

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
                    break;
                case 3:
                    Utility.updateCustomer(consumerList, corporateList);
                    System.out.println("\n");
                    break;
                case 4:
                    Utility.generateInvoice(invoiceList);
                    break;
                case 5:
                    System.out.println("System shutting down now...");
                    System.exit(0);
            }
        }
    }
}

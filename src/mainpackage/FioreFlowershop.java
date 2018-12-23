package mainpackage;

import model.Flower;
import model.Invoice;
import model.Order;
import model.Product;
import model.Consumer;
import model.PromotionCatalogue;
import model.Corporate;
import model.ProductType;
import model.Accessory;
import adt.ListInterface;
import java.util.Scanner;

/**
 * @author Samuel Wong Kim Foong
 */
public class FioreFlowershop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String choice = "";

        // Generate sample data
        ListInterface<Accessory> accessoryList = SampleData.generateAccessoryList();
        ListInterface<Consumer> consumerList = SampleData.generateConsumerList();
        ListInterface<Corporate> corporateList = SampleData.generateCorporateList();
        ListInterface<Flower> flowerList = SampleData.generateFlowerList();
        ListInterface<ProductType> productTypeList = SampleData.generateProductTypeList();
        ListInterface<Product> productList = SampleData.generateCatalogue(flowerList, productTypeList, accessoryList);
        ListInterface<Order> orderList = SampleData.generateOrder(productList, corporateList);
        ListInterface<Invoice> invoiceList = SampleData.generateInvoiceList(orderList);
        PromotionCatalogue promotionCatalogue = SampleData.generatePromoCatalogue(productList);

        while (true) {
            System.out.print("===== Fiore Flowershop =====\n"
                    + "1. Catalogue Maintenance\n"
                    + "2. Customer Maintenance & Invoice Payment\n"
                    + "3. Catalogue Order\n"
                    + "4. Order Pickup\n"
                    + "5. Exit\n"
                    + "Enter your choice: ");
            choice = sc.nextLine();

            if (choice.matches("^[1-5]$")) {

                switch (choice) {
                    case "1":
                        cataloguemaintenance.Main.mainMethod(
                                flowerList, productTypeList, accessoryList, 
                                productList, promotionCatalogue
                        );
                        break;
                    case "2":
                        custandinvoice.Main.mainMethod(
                                productList, consumerList, corporateList, 
                                orderList, invoiceList
                        );
                        break;
                    case "3":
                        catalogueorder.Main.mainMethod(
                                productList, consumerList, corporateList, orderList, 
                                invoiceList, promotionCatalogue
                        );
                        break;
                    case "4":
                        orderpickup.Main.mainMethod();
                        break;
                    case "5":
                        System.out.println("System closing down...");
                        System.exit(0);
                }
            } else {
                System.out.println("Invalid choice entered, please try again with only choice 1 to 5.\n");

            }
        }
    }
}

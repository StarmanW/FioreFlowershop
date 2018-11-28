package fioreflowershop.catalogueorder;

import fioreFlowershop.ADT.OrderList;
import fioreflowershop.Models.CatalogOrder;
import fioreflowershop.Models.ProductType;
import fioreflowershop.Models.ArrayList;
import fioreflowershop.Models.Corporate;
import fioreflowershop.Models.Flower;
import fioreflowershop.Models.ItemList;

import fioreflowershop.Models.ProductType;

/**
 *
 * @author Thiban
 */
public class MainMenu {

    private static final boolean INITIAL_STOCK_STATUS = true;

    public static void main(String[] args) {

        String catalogOrderID = "";
        ProductType productType = null;
        Flower flowerType = null;
        int Qty = 0;
        boolean productInStock = INITIAL_STOCK_STATUS;

        int flowerQty = 0;
        
        ArrayList<ProductType> productTypeList = Utility.generateProductTypeList();
        ItemList<Flower> flowerList = Utility.generateFlowerList();
        ArrayList<CatalogOrder> catalogue = Utility.generateCatalogue();

        ArrayList<Corporate> corps = CreditLimitCorporate.generateCorporateList();

        while (true) {
            // Start main menu
            int choice = Utility.Menu();

            if (choice == 1){
                productType = Utility.enterProductType(productTypeList);
                flowerType = Utility.enterFlowerType(flowerList);
                Qty = Utility.enterttlQty();
                catalogOrderID = Utility.generateCatalogOrderID(catalogue.getTotalEntries());

                catalogue.add(new CatalogOrder(catalogOrderID, productType, flowerType, Qty, productInStock));

                System.out.print("\n=====YOUR ORDER HAVE BEEN ADDED TO CART====\n");
                for (int i = 0; i < catalogue.getTotalEntries(); i++) {
                    CatalogOrder co = catalogue.get(i);
                    System.out.println(
                            co.getCatalogOrderID() + "\t"
                            + "\t" + co.getProductType().getProductTypeName()                                  
                            + "\t" + co.getFlowerType().getFlowerName()
                            + "\t" + co.getQty()
                            + "\t" + co.isInStock() + "\n\n");
                }
            }
            
            //to show corporate credit limit
            else if (choice == 2) {
                CreditLimitCorporate.showCerditLimit(corps);
            }
            
            //shutdown the system
            else if (choice == 4) {
                System.out.println("\n===Thank You for using our system.===\nSystem shut"
                        + "ting down now...\n");
                break;
            }
        }
    }

}

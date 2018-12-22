package fioreflowershop.CatalogueMaintenance;

import fioreflowershop.Models.Flower;
import fioreflowershop.Models.Product;
import fioreflowershop.Models.ProductType;
import fioreflowershop.Models.Accessory;
import fioreflowershop.ADT.ListInterface;
import fioreflowershop.Models.PromotionCatalogue;

/**
 *
 * @author ChongJH
 */
public class Main {

    private static final boolean INITIAL_STOCK_STATUS = true;
    private static final boolean INITIAL_PROMOTION_STATUS = false;

    public static void mainMethod(
            ListInterface<Flower> flowerList,
            ListInterface<ProductType> productTypeList,
            ListInterface<Accessory> accessoryList,
            ListInterface<Product> catalogue,
            PromotionCatalogue promoCatalogue
    ) {

        Utility.displayProductListShort(catalogue);
        Utility.mainMenu(
                flowerList, productTypeList, accessoryList, catalogue, promoCatalogue,
                INITIAL_STOCK_STATUS, INITIAL_PROMOTION_STATUS
        );
    }
}

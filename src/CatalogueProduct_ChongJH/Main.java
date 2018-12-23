package CatalogueProduct_ChongJH;

import model.Flower;
import model.Product;
import model.ProductType;
import model.Accessory;
import adt.ListInterface;
import model.PromotionCatalogue;

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop.CatalogueMaintenance;

import fioreflowershop.Models.Flower;
import fioreflowershop.ADT.ItemList;
import fioreflowershop.Models.Product;
import fioreflowershop.Models.ProductType;
import fioreflowershop.Models.Accessory;
import fioreflowershop.ADT.ListInterface;
import fioreflowershop.ADT.ArrayLList;
import fioreflowershop.Models.FlowerArrangementStyle;

/**
 *
 * @author ChongJH
 */
public class CatalogMaintenanceTestMain {
    private static final boolean INITIAL_STOCK_STATUS = true;
    private static final FlowerArrangementStyle INITIAL_FLOWER_ARRANGEMENT_STYLE = null;
    
    public static void main(String[] args) {
        ItemList<Flower> flowerList = Utility.generateFlowerList();
        ListInterface<ProductType> productTypeList = Utility.generateProductTypeList();
        ListInterface<Accessory> accessoryList = Utility.generateAccessoryList();
        ListInterface<Product> catalogue = Utility.generateCatalogue();
        
//        String productID = "";
//        String productName = "";
//        double productPrice = 0.0;
//        int productQty = 0;
//        ProductType productType = null;
//        ListInterface<Accessory> productAccessoryList = null;
//        Flower productFlower = null;
//        boolean productInStock = INITIAL_STOCK_STATUS;
//        FlowerArrangementStyle flowerArrangementStyle = INITIAL_FLOWER_ARRANGEMENT_STYLE;
        
//        while (Utility.mainMenu()) {
//            productID = Utility.generateProductID(catalogue.size());
//            productName = Utility.enterProductName();
//            productPrice = Utility.enterProductPrice();
//            productQty = Utility.enterProductQty();
//            productType = Utility.enterProductType(productTypeList);
//            productAccessoryList = Utility.enterProductAccessory(productType, accessoryList);
//            productFlower = Utility.enterFlowerType(flowerList);
//            catalogue.add(new Product(productID, productName, productPrice, productQty, productType, productFlower, productAccessoryList, productInStock, flowerArrangementStyle));
//            
//            //=====================================================
//            //=====FOR DEBUGGING ONLY, DELETE LATER======
//            //=====================================================
//            for(int i = 0; i < catalogue.size(); i++){
//                Product tmpProduct = catalogue.get(i);
//                System.out.println(
//                        tmpProduct.getProductID() + "\t" + tmpProduct.getProductName() + "\t" + tmpProduct.getProductPrice() + "\t" + tmpProduct.getProductQty() +
//                        "\t" + tmpProduct.getProductType().getProductTypeName() + "\t" + tmpProduct.getFlowerType().getFlowerName() + "\t" +
//                        tmpProduct.getProductAccessoryList().get(0) + "\t" + tmpProduct.isInStock() + "\n\n"
//                );
//            }
//        }

        Utility.mainMenuNew(
                flowerList, productTypeList, accessoryList, catalogue,
                INITIAL_STOCK_STATUS, INITIAL_FLOWER_ARRANGEMENT_STYLE
        );
    }
}

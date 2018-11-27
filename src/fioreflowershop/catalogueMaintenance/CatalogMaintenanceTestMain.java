/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop.CatalogueMaintenance;

import fioreflowershop.Models.Flower;
import fioreflowershop.Models.ItemList;
import fioreflowershop.Models.Product;
import fioreflowershop.Models.ProductType;
import fioreflowershop.Models.ArrayList;
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
        ArrayList<ProductType> productTypeList = Utility.generateProductTypeList();
        ArrayList<Product> catalogue = Utility.generateCatalogue();
        
        String productID = "";
        String productName = "";
        double productPrice = 0.0;
        int productQty = 0;
        ProductType productType = null;
        Flower productFlower = null;
        boolean productInStock = INITIAL_STOCK_STATUS;
        FlowerArrangementStyle flowerArrangementStyle = INITIAL_FLOWER_ARRANGEMENT_STYLE;
        
        while (Utility.mainMenu()) {
            productID = Utility.generateProductID(catalogue.getTotalEntries());
            productName = Utility.enterProductName();
            productPrice = Utility.enterProductPrice();
            productQty = Utility.enterProductQty();
            productType = Utility.enterProductType(productTypeList);
            productFlower = Utility.enterFlowerType(flowerList);
            catalogue.add(new Product(productID, productName, productPrice, productQty, productType, productFlower, productInStock, flowerArrangementStyle));
            
            for(int i = 0; i < catalogue.getTotalEntries(); i++){
                Product tmpProduct = catalogue.get(i);
                System.out.println(
                        tmpProduct.getProductID() + "\t" + tmpProduct.getProductName() + "\t" + tmpProduct.getProductPrice() + "\t" + tmpProduct.getProductQty() +
                        "\t" + tmpProduct.getProductType().getProductTypeName() + "\t" + tmpProduct.getFlowerType().getFlowerName() + "\t" + tmpProduct.isInStock() + "\n\n"
                );
            }
        }
    
        System.out.println("System will now exit");
    }
}

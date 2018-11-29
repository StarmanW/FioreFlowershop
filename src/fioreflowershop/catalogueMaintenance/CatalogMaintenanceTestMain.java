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

/**
 *
 * @author ChongJH
 */
public class CatalogMaintenanceTestMain {
    private static final boolean INITIAL_STOCK_STATUS = true;
    
    public static void main(String[] args) {
        ItemList<Flower> flowerList = Utility.generateFlowerList();
        ListInterface<ProductType> productTypeList = Utility.generateProductTypeList();
        ListInterface<Accessory> accessoryList = Utility.generateAccessoryList();
        ListInterface<Product> catalogue = Utility.generateCatalogue(flowerList, productTypeList, accessoryList);

        Utility.mainMenu(flowerList, productTypeList, accessoryList, catalogue, INITIAL_STOCK_STATUS);
    }
}

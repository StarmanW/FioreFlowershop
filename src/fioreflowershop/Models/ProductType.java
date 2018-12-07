/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop.Models;

/**
 *
 * @author ChongJH
 */
public class ProductType {
    private String productTypeID;
    private String productTypeName;
    private boolean hasAccessory;

    public ProductType() {
    }

    public ProductType(String productTypeID, String productTypeName, boolean hasAccessory) {
        this.productTypeID = productTypeID;
        this.productTypeName = productTypeName;
        this.hasAccessory = hasAccessory;
    }

    public String getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(String productTypeID) {
        this.productTypeID = productTypeID;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public boolean hasAccessory() {
        return hasAccessory;
    }

    public void setHasAccessory(boolean hasAccessory) {
        this.hasAccessory = hasAccessory;
    }

}

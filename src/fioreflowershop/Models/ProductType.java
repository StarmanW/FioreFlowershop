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
    private int minFlowerQty;
    private int maxFlowerQty;

    public ProductType() {
        this("", "", 0, 0);
    }

    public ProductType(String productTypeID, String productTypeName, int minFlowerQty, int maxFlowerQty) {
        this.productTypeID = productTypeID;
        this.productTypeName = productTypeName;
        this.minFlowerQty = minFlowerQty;
        this.maxFlowerQty = maxFlowerQty;
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

    public int getMinFlowerQty() {
        return minFlowerQty;
    }

    public void setMinFlowerQty(int minFlowerQty) {
        this.minFlowerQty = minFlowerQty;
    }

    public int getMaxFlowerQty() {
        return maxFlowerQty;
    }

    public void setMaxFlowerQty(int maxFlowerQty) {
        this.maxFlowerQty = maxFlowerQty;
    }
    
}

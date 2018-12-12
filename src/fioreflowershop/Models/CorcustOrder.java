/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop.Models;

/**
 *
 * @author User
 */
public class CorcustOrder implements Comparable<CorcustOrder> {

    private String catalogOrderID;
    private Product product;  
    private Corporate corporate;
//private String productID;
    private int Qty;

    public CorcustOrder() {

    }

    public CorcustOrder(String catalogOrderID, Product product,Corporate corporate, int Qty) {

        this.catalogOrderID = catalogOrderID;
        this.product = product;
        this.corporate = corporate;
        this.Qty = Qty;

    }

    //getter
    public String getCatalogOrderID() {
        return catalogOrderID;
    }

    public int getQty() {
        return Qty;
    }

    public Product getProduct() {
        return product;
    }

    public Corporate getCorporate() {
        return corporate;
    }
    
    

    //setter
    public void setCatalogOrderID(String catalogOrderID) {
        this.catalogOrderID = catalogOrderID;
    }
    
    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCorporate(Corporate corporate) {
        this.corporate = corporate;
    }
    
    

    
    @Override
    public int compareTo(CorcustOrder o) {
        return this.getCatalogOrderID().compareTo(o.getCatalogOrderID());
    }

}

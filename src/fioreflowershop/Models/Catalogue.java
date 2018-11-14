/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop.Models;

/**
 *
 * @author ChongJH
 * @param <T>
 */
public class Catalogue<T> extends ArrayList<Object>{
    private String catalogueID;
    private Product productArray[];

    public Catalogue() {
        this("", null);
    }

    public Catalogue(String catalogueID, Product[] productArray) {
        this.catalogueID = catalogueID;
        this.productArray = productArray;
    }

    public String getCatalogueID() {
        return catalogueID;
    }

    public void setCatalogueID(String catalogueID) {
        this.catalogueID = catalogueID;
    }

    public Product[] getProductArray() {
        return productArray;
    }

    public void setProductArray(Product[] productArray) {
        this.productArray = productArray;
    }
}

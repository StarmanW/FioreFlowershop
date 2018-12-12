package fioreflowershop.Models;

import fioreflowershop.Models.ProductType;
import fioreflowershop.Models.Product;

/**
 *
 * @author Thiban
 */
public class CatalogOrder implements Comparable<CatalogOrder> {

    private String catalogOrderID;
    private int Qty;
    private Product product;
    private boolean inStock;

    public CatalogOrder() {

    }

    public CatalogOrder(String catalogOrderID, Product product, int Qty) {

        this.catalogOrderID = catalogOrderID;

        this.product = product;
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

    


    //setter
    public void setCatalogOrderID(String catalogOrderID) {
        this.catalogOrderID = catalogOrderID;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    

    @Override
    public int compareTo(CatalogOrder o) {
       return this.getCatalogOrderID().compareTo(o.getCatalogOrderID());
    }

}

package fioreflowershop.Models;
import fioreflowershop.Models.ProductType;
import fioreflowershop.Models.Flower;

/**
 *
 * @author Thiban
 */
public class CatalogOrder {
   
    private String catalogOrderID;
    private int Qty;
    private ProductType productType;
    private Flower flowerType; 
    private boolean inStock;
 
    public CatalogOrder() {
        this("", null,null,0,false);
    }

    public CatalogOrder(String catalogOrderID, ProductType productType, Flower flowerType, int Qty, boolean inStock) {
     
        this.catalogOrderID = catalogOrderID ; 
        this.productType = productType ; 
        this.flowerType = flowerType ;
        this.Qty = Qty;
        this.inStock = inStock;
    }

    //getter
    public String getCatalogOrderID() {
        return catalogOrderID;
    }

    public ProductType getProductType() {
        return productType;
    }

    public Flower getFlowerType() {
        return flowerType;
    }

    public int getQty() {
        return Qty;
    }

    //setter
    public void setCatalogOrderID(String catalogOrderID) {
        this.catalogOrderID = catalogOrderID;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setFlowerType(Flower flowerType) {
        this.flowerType = flowerType;
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
    
    
    
}

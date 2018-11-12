package fioreflowershop.Models;

/**
 *
 * @author ChongJH
 */
public class Product {
    private String productID;
    private String productName;
    private double productPrice;
    private int productQty;
    private int productType;
    private int minFlowerQty;
    private int maxFlowerQty;
    private FlowerArrangementStyle arrangementStyle;

    public Product() {
        this("", "", 0.0, 0, 0, 0, 0, null);
    }

    public Product(String productID, String productName, double productPrice, int productQty, int productType, int minFlowerQty, int maxFlowerQty, FlowerArrangementStyle arrangementStyle) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQty = productQty;
        this.productType = productType;
        this.minFlowerQty = minFlowerQty;
        this.maxFlowerQty = maxFlowerQty;
        this.arrangementStyle = arrangementStyle;
    }

        public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
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

    public FlowerArrangementStyle getArrangementStyle() {
        return arrangementStyle;
    }

    public void setArrangementStyle(FlowerArrangementStyle arrangementStyle) {
        this.arrangementStyle = arrangementStyle;
    }
        
}

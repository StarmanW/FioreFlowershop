package fioreflowershop.Models;

/**
 *
 * @author ChongJH
 */
public class Product implements Comparable<Product>{
    private String productID;
    private String productName;
    private double productPrice;
    private int productQty;
    private ProductType productType;
    private Flower flowerType;
    private Accessory productAccessory;
    private String productDescription;
    private boolean inStock;

    public Product() {
        this("", "", 0.0, 0, null, null, null, "", false);
    }
    
    public Product(Product originalProduct) {
        this(
                originalProduct.getProductID(), originalProduct.getProductName(), 
                originalProduct.getProductPrice(), originalProduct.getProductQty(), 
                originalProduct.getProductType(), originalProduct.getFlowerType(),
                originalProduct.getProductAccessory(), originalProduct.getProductDescription(), 
                originalProduct.isInStock()
        );
    }

    public Product(
            String productID, String productName, double productPrice, int productQty, 
            ProductType productType, Flower flowerType, Accessory productAccessory, 
            String productDescription, boolean inStock
    ) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQty = productQty;
        this.productType = productType;
        this.flowerType = flowerType;
        this.productAccessory = productAccessory;
        this.productDescription = productDescription;
        this.inStock = inStock;
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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Flower getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(Flower flowerType) {
        this.flowerType = flowerType;
    }

    public Accessory getProductAccessory() {
        return productAccessory;
    }

    public void setProductAccessory(Accessory productAccessory) {
        this.productAccessory = productAccessory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public boolean isInStock() {
        return inStock;
    }

    public String isInStockToString() {
        String isInStockString = "No";
        
        if (isInStock())
            isInStockString = "Yes";
        
        return isInStockString;
    }
    
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public int compareTo(Product other) {
        return this.getProductType().compareTo(other.getProductType());
    }

}

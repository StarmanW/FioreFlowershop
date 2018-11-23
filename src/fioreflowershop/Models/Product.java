package fioreflowershop.Models;

import fioreflowershop.ADT.ListInterface;

/**
 *
 * @author ChongJH
 */
public class Product {
    private String productID;
    private String productName;
    private double productPrice;
    private int productQty;
    private ProductType productType;
    private Flower flowerType;
    private ListInterface<Accessory> productAccessoryList;
    private boolean inStock;
    private FlowerArrangementStyle arrangementStyle;

    public Product() {
        this("", "", 0.0, 0, null, null, null, false, null);
    }

    public Product(String productID, String productName, double productPrice, int productQty, ProductType productType, Flower flowerType, ListInterface<Accessory> productAccessoryList, boolean inStock, FlowerArrangementStyle arrangementStyle) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQty = productQty;
        this.productType = productType;
        this.flowerType = flowerType;
        this.productAccessoryList = productAccessoryList;
        this.inStock = inStock;
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

    public ListInterface<Accessory> getProductAccessoryList() {
        return productAccessoryList;
    }

    public void setProductAccessoryList(ListInterface<Accessory> productAccessoryList) {
        this.productAccessoryList = productAccessoryList;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public FlowerArrangementStyle getArrangementStyle() {
        return arrangementStyle;
    }

    public void setArrangementStyle(FlowerArrangementStyle arrangementStyle) {
        this.arrangementStyle = arrangementStyle;
    }

}

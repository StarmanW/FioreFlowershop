package fioreflowershop.Models;

/**
 *
 * @author Thiban
 */
public class CatalogueOrder implements Comparable<CatalogueOrder> {

    private String flowerName;
    private double flowerPrice;
    private int ttlQty;
    private int ttlItem;

    public CatalogueOrder() {
        this("", 0.0, 0, 0);
    }

    public CatalogueOrder(String flowerName, double flowerPrice, int ttlQty, int ttlItem) {
        this.flowerName = flowerName;
        this.flowerPrice = flowerPrice;
        this.ttlQty = ttlQty;
        this.ttlItem = ttlItem;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public double getFlowerPrice() {
        return flowerPrice;
    }

    public int getTtlQty() {
        return ttlQty;
    }

    public int getTtlItem() {
        return ttlItem;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public void setFlowerPrice(double flowerPrice) {
        this.flowerPrice = flowerPrice;
    }

    public void setTtlQty(int ttlQty) {
        this.ttlQty = ttlQty;
    }

    public void setTtlItem(int ttlItem) {
        this.ttlItem = ttlItem;
    }

    @Override
    public int compareTo(CatalogueOrder o) {
        return 0;
    }
}

package model;

/**
 *
 * @author ChongJH
 */
public class Flower implements Comparable<Flower>{

    private String flowerID;
    private String flowerName;
    private int flowerQty;
    private double flowerPrice;

    public Flower() {
        this("", "", 0, 0.0);
    }
    
    public Flower(String flowerID, String flowerName, int flowerQty, double flowerPrice) {
        this.flowerID = flowerID;
        this.flowerName = flowerName;
        this.flowerQty = flowerQty;
        this.flowerPrice = flowerPrice;
    }

    public String getFlowerID() {
        return flowerID;
    }

    public void setFlowerID(String flowerID) {
        this.flowerID = flowerID;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public int getFlowerQty() {
        return flowerQty;
    }

    public void setFlowerQty(int flowerQty) {
        this.flowerQty = flowerQty;
    }

    public double getFlowerPrice() {
        return flowerPrice;
    }

    public void setFlowerPrice(double flowerPrice) {
        this.flowerPrice = flowerPrice;
    }

    @Override
    public int compareTo(Flower other) {
        return this.getFlowerName().compareTo(other.getFlowerName());
    }

}

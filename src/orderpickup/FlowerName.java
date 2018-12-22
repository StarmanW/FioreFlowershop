/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderpickup;

/**
 *
 * @author foong kian
 */
class FlowerName {
    private String flowerID;
    private String flowerName;
    private double price;

    public FlowerName(String flowerID, String flowerName, double price) {
        this.flowerID = flowerID;
        this.flowerName = flowerName;
        this.price = price;
    }

    public String getFlowerID() {
        return flowerID;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public double getPrice() {
        return price;
    }

    public void setFlowerID(String flowerID) {
        this.flowerID = flowerID;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}

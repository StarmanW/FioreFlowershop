package fioreflowershop.Models;

/**
 *
 * @author Samuel Wong Kim Foong
 */
public class FlowerArrangementStyle {

    // Private properties
    private String flowerArrangementStyleID;
    private String flowerArrangementStyleName;
    private double price;

    // Constructor
    public FlowerArrangementStyle() {
        this("", "", 0.0);
    }

    // Parameterized constructor
    public FlowerArrangementStyle(String flowerArrangementStyleID, String style, double price) {
        this.flowerArrangementStyleID = flowerArrangementStyleID;
        this.flowerArrangementStyleName = style;
        this.price = price;
    }

    // Getters
    public String getFlowerArrangementStyleID() {
        return flowerArrangementStyleID;
    }

    public String getFlowerArrangementStyleName() {
        return flowerArrangementStyleName;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setFlowerArrangementStyleID(String flowerArrangementStyleID) {
        this.flowerArrangementStyleID = flowerArrangementStyleID;
    }

    public void setFlowerArrangementStyleName(String flowerArrangementStyleName) {
        this.flowerArrangementStyleName = flowerArrangementStyleName;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

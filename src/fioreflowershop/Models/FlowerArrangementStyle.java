package fioreflowershop.Models;

/**
 *
 * @author Samuel Wong Kim Foong
 */
public class FlowerArrangementStyle {

    // Private properties
    private String flowerArrangementStyleID;
    private String styleName;
    private double price;

    // Constructor
    public FlowerArrangementStyle() {
        this.flowerArrangementStyleID = "";
        this.styleName = "";
        this.price = 0.0;
    }

    // Parameterized constructor
    public FlowerArrangementStyle(String flowerArrangementStyleID, String style, double price) {
        this.flowerArrangementStyleID = flowerArrangementStyleID;
        this.styleName = style;
        this.price = price;
    }

    // Getters
    public String getFlowerArrangementStyleID() {
        return flowerArrangementStyleID;
    }

    public String getStyleName() {
        return styleName;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setFlowerArrangementStyleID(String flowerArrangementStyleID) {
        this.flowerArrangementStyleID = flowerArrangementStyleID;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop.Models;

/**
 *
 * @author StarmanW
 */
public class FlowerArrangementSize implements Comparable<FlowerArrangementStyle> {

    // Private properties
    private String sizeType;
    private double cost;

    // Constructor
    public FlowerArrangementSize() {
        this("", 0.0);
    }

    // Parameterized constructor
    public FlowerArrangementSize(String sizeType, double cost) {
        this.sizeType = sizeType;
        this.cost = cost;
    }

    public String getSizeType() {
        return sizeType;
    }

    public double getCost() {
        return cost;
    }

    public void setSizeType(String sizeType) {
        this.sizeType = sizeType;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public int compareTo(FlowerArrangementStyle o) {
        return 0;
    }
}

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
public class Accessory implements Comparable<Accessory>{

    // Private properties
    private String accessory;
    private double cost;

    // Constructor
    public Accessory() {
        this("", 0.0);
    }

    // Parameterized constructor
    public Accessory(String accessory, double cost) {
        this.accessory = accessory;
        this.cost = cost;
    }

    // Getters
    public String getAccessory() {
        return accessory;
    }

    public double getCost() {
        return cost;
    }

    // Setters
    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public int compareTo(Accessory other) {
        return this.getAccessory().compareTo(other.getAccessory());
    }

}

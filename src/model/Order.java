package model;

import adt.LList;
import adt.ListInterface;
import java.util.Date;

/**
 * @author Thiban Kumar and Samuel Wong Kim Foong
 */
public class Order implements Comparable<Order> {

    private String orderID;
    private Customer customer;
    private ListInterface<ProductOrder> productOrders;
    private Date orderedOn;
    private Date pickUpDateTime;
    private String Address;
    private double totalPayment;

    public Order() {
        this("OD0001", new Customer(), new LList<ProductOrder>(), new Date(), new Date(), "Wangsa Maju", 0.00);
    }

    public Order(String orderID, Customer customer, ListInterface<ProductOrder> productOrders, Date orderedOn, Date pickUpDateTime, String Address, double totalPayment) {
        this.orderID = orderID;
        this.customer = customer;
        this.productOrders = productOrders;
        this.orderedOn = orderedOn;
        this.pickUpDateTime = pickUpDateTime;
        this.Address = Address;
        this.totalPayment = totalPayment;
    }

    // Getters
    public String getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ListInterface<ProductOrder> getProductOrders() {
        return productOrders;
    }

    public Date getOrderedOn() {
        return orderedOn;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public Date getPickUpDateTime() {
        return pickUpDateTime;
    }

    public String getAddress() {
        return Address;
    }

    // Setters
    public void setOrderID(String orderID) {
        if (orderID.matches("^OD\\d{4,}$")) {
            this.orderID = orderID;
        }
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProductOrders(ListInterface<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }

    public void setOrderedOn(Date orderedOn) {
        this.orderedOn = orderedOn;
    }

    public void setTotalPayment(double totalPayment) {
        if (totalPayment >= 0.0) {
            this.totalPayment = totalPayment;
        }
    }
    
    public void setPickUpDateTime(Date pickUpDateTime) {
        this.pickUpDateTime = pickUpDateTime;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    @Override
    public int compareTo(Order o) {
        return 1;
    }
}

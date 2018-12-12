package fioreflowershop.Models;

import fioreflowershop.ADT.LList;
import fioreflowershop.ADT.ListInterface;
import java.util.Date;

/**
 * @author Thiban
 */
public class Order {

    private String orderID;
    private Customer customer;
    private ListInterface<ProductOrder> productOrders;
    private Date orderedOn;
    private double totalPayment;

    public Order() {
        this("OD0001", new Customer(), new LList<ProductOrder>(), new Date(), 0.00);
    }

    public Order(String orderID, Customer customer, ListInterface<ProductOrder> productOrders, Date orderedOn, double totalPayment) {
        this.orderID = orderID;
        this.customer = customer;
        this.productOrders = productOrders;
        this.orderedOn = orderedOn;
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
}

package model;

import adt.LList;
import adt.ListInterface;
import java.util.Date;

/**
 * @author Samuel Wong Kim Foong
 */
public class Invoice implements Comparable<Invoice>{

    public final static double SALES_TAX = 5;

    private String invoiceID;
    private Customer corporate;
    private Date issuedOn;
    private Date dueDate;
    private ListInterface<Order> orders;
    private int status;

    // Default consturctor
    public Invoice() {
        this("INV0001", new Corporate(), new Date(), new Date(), new LList<Order>(), 0);
    }

    // Parameterized contrustor
    public Invoice(String invoiceID, Customer corporate, Date issuedOn, Date dueDate, ListInterface<Order> orders, int status) {
        this.invoiceID = invoiceID;
        this.corporate = corporate;
        this.issuedOn = issuedOn;
        this.dueDate = dueDate;
        this.orders = orders;
        this.status = status;
    }

    // Getters
    public String getInvoiceID() {
        return invoiceID;
    }

    public Corporate getCorporate() {
        return (Corporate) corporate;
    }

    public Date getIssuedOn() {
        return issuedOn;
    }

    public Date getDueDate() {

        return dueDate;
    }

    public ListInterface<Order> getOrders() {
        return orders;
    }
    
    public String getStatus() {
        String statusString = "";
        
        switch (status) {
            case 0:
                statusString = "Pending";
                break;
            case 1:
                statusString = "Paid";
                break;
            case 2:
                statusString = "Overdue Date";
                break;
        }
        return statusString;
    }
    
    // Setters
    public void setInvoiceID(String invoiceID) {
        if (invoiceID.matches("^INV\\d{4,}$")) {
            this.invoiceID = invoiceID;
        }
    }

    public void setCorporate(Customer corporate) {
        this.corporate = corporate;
    }

    public void setIssuedOn(Date issuedOn) {
        this.issuedOn = issuedOn;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setOrders(ListInterface<Order> orders) {
        this.orders = orders;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int compareTo(Invoice o) {
        return 1;
    }
}

package fioreflowershop.Models;

import fioreflowershop.ADT.LList;
import fioreflowershop.ADT.ListInterface;
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

    // Default consturctor
    public Invoice() {
        this("INV0001", new Corporate(), new Date(), new Date(), new LList<Order>());
    }

    // Parameterized contrustor
    public Invoice(String invoiceID, Customer corporate, Date issuedOn, Date dueDate, ListInterface<Order> orders) {
        this.invoiceID = invoiceID;
        this.corporate = corporate;
        this.issuedOn = issuedOn;
        this.dueDate = dueDate;
        this.orders = orders;
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

    @Override
    public int compareTo(Invoice o) {
        return 0;
    }
}

package model;

/**
 * Customer class
 *
 * @author Samuel Wong Kim Foong
 */
public class Customer implements Comparable<Customer> {

    // Private properties
    private String address;
    private String contactNo;

    // Default constructor
    public Customer() {
        this("", "");
    }

    // Parameterized constructor
    public Customer(String address, String contactNo) {
        this.address = address;
        this.contactNo = contactNo;
    }

    // Getters
    public String getAddress() {
        return address;
    }

    public String getContactNo() {
        return contactNo;
    }

    // Setters
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compareTo(Customer o) {
        return 1;
    }
}

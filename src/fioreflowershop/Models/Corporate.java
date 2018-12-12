package fioreflowershop.Models;

/**
 * Corporate class
 *
 * @author Samuel Wong Kim Foong
 */
public class Corporate extends Customer {

    // Private properties
    private String corporateId;
    private String corporateName;
    private double creditLimit;
    
    // Default constructor
    public Corporate() {
        this("CO0001", "Starman Ltd.", "No.45, Jalan Wangsa Maju, Petagas, Wilayah Persekutuan, Kuala Lumpur, Malaysia", "088654755", 1000.00);
    }

    // Parameterized constructor
    public Corporate(String corporateId, String corporateName, String address, String contactNo, double creditLimit) {
        super(address, contactNo);
        this.corporateId = corporateId;
        this.corporateName = corporateName;
        this.creditLimit = creditLimit;
    }

    // Getters
    public String getCorporateId() {
        return corporateId;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    // Setters
    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
}

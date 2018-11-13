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

    // Default constructor
    public Corporate() {
        this("CO0001", "Starman Ltd.", "No.45, Jalan Wangsa Maju, Petagas, Wilayah Persekutuan, Kuala Lumpur, Malaysia", "088654755");
    }

    // Parameterized constructor
    public Corporate(String corporateId, String corporateName, String address, String contactNo) {
        super(address, contactNo);
        this.corporateId = corporateId;
        this.corporateName = corporateName;
    }

    // Getters
    public String getCorporateId() {
        return corporateId;
    }

    public String getCorporateName() {
        return corporateName;
    }

    // Setters
    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }
}

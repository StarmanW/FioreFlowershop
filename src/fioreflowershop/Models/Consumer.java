package fioreflowershop.Models;

/**
 * Consumer class
 *
 * @author Samuel Wong Kim Foong
 */
public class Consumer extends Customer {

    // Private properties
    private String consumerId;
    private String consumerName;
    private String icNum;

    // Default constructor
    public Consumer() {
        this("CN0001", "John Doe", "650241123365", "No.88, Jalan Wangsa Maju, Petagas, Wilayah Persekutuan, Kuala Lumpur, Malaysia", "0142223568");
    }

    // Parameterized constructor
    public Consumer(String consumerId, String consumerName, String icNum, String address, String contactNo) {
        super(address, contactNo);
        this.consumerId = consumerId;
        this.consumerName = consumerName;
        this.icNum = icNum;
    }

    // Getters
    public String getConsumerId() {
        return consumerId;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public String getIcNum() {
        return icNum;
    }

    // Setters
    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public void setIcNum(String icNum) {
        this.icNum = icNum;
    }

}

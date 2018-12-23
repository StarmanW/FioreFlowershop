package OrderPickup_ChengFK;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Cheng Foong Kian
 * @param <T>
 */
public class orderList implements orderInterface {

    private String createdDate;
    private String orderNo;
    private String address;
    private String city;
    private String paymentStatus;
    private double TotalAmount;
    private String deliveryTimestamp;
    private String status;

    public orderList(String createdDate, String orderNo, String address, String city, String paymentStatus, double TotalAmount, String deliveryTimestamp, String status) {
        this.createdDate = createdDate;
        this.orderNo = orderNo;
        this.address = address;

        this.city = city;
        this.paymentStatus = paymentStatus;
        this.TotalAmount = TotalAmount;
        this.deliveryTimestamp = deliveryTimestamp;
        this.status = status;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public double getTotalAmount() {
        return TotalAmount;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setTotalAmount(double TotalAmount) {
        this.TotalAmount = TotalAmount;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDeliveryTimestamp() {
        return deliveryTimestamp;
    }

    public void setDeliveryTimestamp(String deliveryTimestamp) {
        this.deliveryTimestamp = deliveryTimestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int compareTo(orderInterface other) {
        return this.getCity().compareTo(other.getCity());
    }

    public String updateStatus() {
        this.status = "Delivered";
        return status;
    }

    public String updatePayment() {
        this.paymentStatus = "Paid";
        return paymentStatus;

    }

    @Override
    public String updateTimestamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:MM:ss");
        String dateToday = sdf.format(date);
        this.deliveryTimestamp = dateToday;
        return deliveryTimestamp;
    }

    @Override
    public double setTotalAmount() {
        this.TotalAmount = TotalAmount;
        return TotalAmount;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderpickup;

/**
 * @author Cheng Foong Kian
 * @param <T>
 */
public interface pickupInterface extends Comparable<pickupInterface> {

    public String getCreatedDate();

    public String getOrderNo();

    public String getAddress();

    public String getCity();

    public String getPaymentStatus();

    public double getTotalAmount();

    public String getDeliveryTimestamp();

    public String getStatus();

    public double setTotalAmount();

    public String updateStatus();

    public String updateTimestamp();

    public String updatePayment();
}

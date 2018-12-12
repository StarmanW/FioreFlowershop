/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop.Models;

/**
 *
 * @author cheng foong kian
 */
public class OrderList extends Customer{
         private String consumerId;
    private String consumerName;
    private String icNum;
    private String date;
    private String pickuptime;

    public OrderList() {
    }

     public OrderList(String consumerId, String consumerName, String icNum, String date, String pickuptime, String contactNo) {
        super(pickuptime,contactNo);
        this.consumerId = consumerId;
        this.consumerName = consumerName;
        this.icNum = icNum;
        this.date=date;
        this.pickuptime=pickuptime;
    }

    public void setPickuptime(String pickuptime) {
        this.pickuptime = pickuptime;
    }

    public String getPickuptime() {
        return pickuptime;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public String getIcNum() {
        return icNum;
    }

    public String getDate() {
        return date;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public void setIcNum(String icNum) {
        this.icNum = icNum;
    }

    public void setDate(String date) {
        this.date = date;
    }
     
    
    
    
}

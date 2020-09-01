package com.xinwen.openapi.gateway.dto;

public class PaymentRequest extends Request {

    public String transID;
    public int amount;
    public String payMethod;

    public String getTransID() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "transID='" + transID + '\'' +
                ", amount=" + amount +
                ", payMethod='" + payMethod + '\'' +
                '}';
    }
}

package com.xinwen.openapi.gateway.dto;

public class PaymentResponse extends Reponse {

    public String status;
    public String transID;
    public int amount;
    public String payMethod;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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
        return "PaymentResponse{" +
                "status='" + status + '\'' +
                ", transID='" + transID + '\'' +
                ", payMethod='" + payMethod + '\'' +
                ", resCode=" + resCode +
                ", message='" + message + '\'' +
                '}';
    }
}

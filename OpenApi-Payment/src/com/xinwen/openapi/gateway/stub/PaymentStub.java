package com.xinwen.openapi.gateway.stub;

import com.xinwen.openapi.gateway.Payment;
import com.xinwen.openapi.gateway.dto.PaymentRequest;
import com.xinwen.openapi.gateway.dto.PaymentResponse;

public class PaymentStub implements Payment {

    private Payment payment;

    public PaymentStub(Payment payment){
        this.payment = payment;
    }


    @Override
    public PaymentResponse pay(PaymentRequest payRequest) throws Exception {
        System.out.println("验证参数信息......");
        return payment.pay(payRequest);
    }
}

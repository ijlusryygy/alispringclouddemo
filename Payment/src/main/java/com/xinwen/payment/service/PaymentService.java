package com.xinwen.payment.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.xinwen.openapi.gateway.Payment;
import com.xinwen.openapi.gateway.dto.PaymentRequest;
import com.xinwen.openapi.gateway.dto.PaymentResponse;
import com.xinwen.payment.config.PaymentFallback;
import org.apache.dubbo.config.annotation.Service;

@Service(owner = "xinwen", version = "1.0", protocol = "dubbo", stub = "com.xinwen.openapi.gateway.stub.PaymentStub")
public class PaymentService implements Payment {


    @Override
    @SentinelResource(fallbackClass = PaymentFallback.class ,fallback = "pay")
    public PaymentResponse pay(PaymentRequest request) throws Exception {
        System.out.println("payment completed");
        PaymentResponse response = new PaymentResponse();
        response.setResCode(200);
        response.setMessage("success");

        return response;
    }

    public PaymentResponse paymentFallback(PaymentRequest request) throws Exception {
        PaymentResponse response = new PaymentResponse();
        response.setResCode(500);
        response.setMessage("payment fallback");
        return response;
    }
}

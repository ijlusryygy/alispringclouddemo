package com.xinwen.payment.config;

import com.xinwen.openapi.gateway.Payment;
import com.xinwen.openapi.gateway.dto.PaymentRequest;
import com.xinwen.openapi.gateway.dto.PaymentResponse;
import org.springframework.stereotype.Component;

public class PaymentFallback {


    public static PaymentResponse pay(PaymentRequest payRequest) throws Exception {
        PaymentResponse response = new PaymentResponse();
        response.setResCode(500);
        response.setMessage("payment fallback");
        return response;
    }
}

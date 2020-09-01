package com.xinwen.openapi.gateway;

import com.xinwen.openapi.gateway.dto.PaymentRequest;
import com.xinwen.openapi.gateway.dto.PaymentResponse;

public interface Payment {

    public PaymentResponse pay(PaymentRequest payRequest) throws Exception;

}

package com.xinwen.gateway.api.payment;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.xinwen.openapi.gateway.Payment;
import com.xinwen.openapi.gateway.Settlement;
import com.xinwen.openapi.gateway.dto.PaymentRequest;
import com.xinwen.openapi.gateway.dto.PaymentResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements Payment{

    @Reference(version = "1.0", protocol = "dubbo")
    private Payment payment;

    @Reference
    private Settlement settlement;


    @Override
    public PaymentResponse pay(PaymentRequest request) throws Exception {

        System.out.println("dddfff, traceID:"+ TraceContext.traceId());
        return payment.pay(request);
    }


}

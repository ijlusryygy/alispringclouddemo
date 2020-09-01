package com.xinwen.gateway.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.xinwen.gateway.api.payment.PaymentService;
import com.xinwen.openapi.gateway.Payment;
import com.xinwen.openapi.gateway.dto.PaymentRequest;
import com.xinwen.openapi.gateway.dto.PaymentResponse;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "支付接口列表", tags = "跳转型支付接口")
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Trace
    @ApiOperation(value = "支付接口", notes = "跳转接口")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "transID", value="交易ID", required = true, dataType = "string", paramType = "query", example = "15421421")
    )
    @GetMapping("/payment")
    @SentinelResource(value = "payment-pay", fallback = "payFallBack")
    public String payment(){

        System.out.println("d11dd, traceID:"+ TraceContext.traceId());
        try {
            PaymentRequest payRequest = new PaymentRequest();
           PaymentResponse response = paymentService.pay(payRequest);
            System.out.println("s:"+response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sss";
    }
    @GetMapping("/wechatPayment")
    public String wechatPayment(){

        System.out.println("wechatPayment, traceID:"+ TraceContext.traceId());
        return "wechatPayment";
    }

    public String payFallBack(){
        return "pay fallback";
    }

}

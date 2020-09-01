package com.xinwen.payment.service;

import com.xinwen.openapi.gateway.Settlement;
import org.apache.dubbo.config.annotation.Service;

@Service(protocol = "dubbo")
public class SettlementService implements Settlement {
    @Override
    public String settle() throws Exception {
        System.out.println("settle....");
        return "settle return";
    }
}

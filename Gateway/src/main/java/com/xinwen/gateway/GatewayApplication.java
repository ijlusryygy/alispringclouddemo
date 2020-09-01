package com.xinwen.gateway;

//import com.alibaba.dubbo.rpc.protocol.dubbo.FutureAdapter;
import com.xinwen.gateway.api.payment.PaymentService;
import com.xinwen.openapi.gateway.Payment;
import com.xinwen.openapi.gateway.dto.PaymentRequest;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableFeignClients
public class GatewayApplication {

    @Autowired
    private PaymentService paymentService;

    public static void main(String[] args) {

//        FutureAdapter a = new FutureAdapter(null);
//        System.out.println(a);
        ApplicationContext context = new SpringApplicationBuilder(GatewayApplication.class)
                .properties("spring.profiles.active=nacos").run(args);

    }

//    @PostConstruct
    public void init() throws Exception{
        ExecutorService services = Executors.newFixedThreadPool(10);
        services.submit(() ->{
            while (true){
                services.submit(() ->{
                    try {
                        System.out.println( paymentService.pay(new PaymentRequest()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                Thread.currentThread().sleep(100);
            }
        });

    }




}

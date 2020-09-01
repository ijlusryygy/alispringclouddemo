package com.xinwen.payment.config;

import org.apache.dubbo.config.ConsumerConfig;
//import org.apache.dubbo.config.SslConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {

/*

    @Bean
    public SslConfig initSSl(){
        SslConfig sslConfig = new SslConfig();
        */
/**
         * 单向认证只要加上ca证书就行
         *//*

//        sslConfig.setClientTrustCertCollectionPathStream(DubboConfig.class.getClassLoader().getResourceAsStream("cacert.pem"));
        */
/**
         * 双向认证还需要加上客户端证书，此证书需给服务供应方，让其加入到信任列表中
         *//*

//        sslConfig.setClientKeyCertChainPathStream(DubboConfig.class.getClassLoader().getResourceAsStream("cert/client/cert.pem"));
//        sslConfig.setClientPrivateKeyPathStream(DubboConfig.class.getClassLoader().getResourceAsStream("cert/client/key.pem"));
        return sslConfig;
    }
*/

    @Bean
    public ConsumerConfig consumerConfig(){
        ConsumerConfig consumerConfig = new ConsumerConfig();
//        consumerConfig.setFilter("tracing");
        return  consumerConfig;
    }

}

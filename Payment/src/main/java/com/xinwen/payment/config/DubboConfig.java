package com.xinwen.payment.config;

import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.SslConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {

    @Bean
    public SslConfig getSSLConfig(){
        SslConfig sslConfig = null;
        sslConfig = new SslConfig();
        /**
         * 单向认证，只要配一下服务的证书和私钥
         */
        sslConfig.setServerKeyCertChainPathStream(DubboConfig.class.getClassLoader().getResourceAsStream("cert/server/cert.pem"));
        sslConfig.setServerPrivateKeyPathStream(DubboConfig.class.getClassLoader().getResourceAsStream("cert/server/key.pem"));

        /**
         * 双向认证还需配一下CA证书
         */
//        sslConfig.setServerTrustCertCollectionPathStream(DubboConfig.class.getClassLoader().getResourceAsStream("cert/ca/cacert.pem"));
        return sslConfig;
    }

    @Bean
    public ProviderConfig providerConfig(){
        ProviderConfig providerConfig = new ProviderConfig();
//        providerConfig.setFilter("tracing");
        return providerConfig;
    }

}

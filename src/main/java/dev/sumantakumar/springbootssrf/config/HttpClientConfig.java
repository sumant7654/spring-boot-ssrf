package dev.sumantakumar.springbootssrf.config;

import org.springframework.boot.http.client.InetAddressFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class HttpClientConfig {

    @Bean
    public InetAddressFilter inetAddressFilter() {
        return InetAddressFilter.externalAddresses();
    }

}

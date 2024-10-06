package com.jts.saga.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Data
@Configuration
public class WebClientConfig {

    @Value("${service.endpoints.payment}")
    private String paymentEndpoint;
    @Value("${service.endpoints.inventory}")
    private String InventoryEndpoint;
    @Bean
    @Qualifier("payment")
    public WebClient paymentClient(){
        return WebClient.builder()
                .baseUrl(this.getPaymentEndpoint())
                .build();
    }

    @Bean
    @Qualifier("inventory")
    public WebClient inventoryClient(){
        return WebClient.builder()
                .baseUrl(this.getInventoryEndpoint())
                .build();
    }

}

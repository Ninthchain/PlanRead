package com.professional.bot.configuration;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class BotRestClientConfiguration {

    @Bean
    RestClient restClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl("http://localhost:45900/api/v1")
                .build();
        return restClient;
    }
}

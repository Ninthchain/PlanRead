package com.professional.bot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.professional.bot.data.model.BotProfile;

@Configuration
public class BotProfileConfiguration {

    @Value("${bot.token}")
    private String botToken;

    @Value("${bot.name}")
    private String botName;

    @Bean
    BotProfile botProfile () {
        return BotProfile.builder().botToken(botToken).botName(botName).build();
    }
}

package com.professional.bot;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
@ComponentScan
@SpringBootApplication
public class BotApplication {

	public static void main(String[] args) throws TelegramApiException {
		
		SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder(BotApplication.class);
		applicationBuilder.web(WebApplicationType.NONE);
		applicationBuilder.run(args);
	}

}

package com.professional.bot.data.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BotProfile {
    private String botToken;
    private String botName;
}
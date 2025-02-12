package com.professional.bot.runner.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.professional.bot.TelegramBot;
import com.professional.bot.command.BotCommand;
import com.professional.bot.runner.TelegramBaseCommandRunner;
import com.professional.bot.runner.TelegramCommandRunner;

@Component
public class HelpCommandRunner extends TelegramBaseCommandRunner {

    private final TelegramBot bot;

    public HelpCommandRunner(TelegramBot bot) {
        this.bot = bot;
    }


    @Override
    public void run(BotCommand command, String incomingMessage, long userId) throws TelegramApiException {
        bot.execute(buildTextMessage(userId, "TODO: finish FAQ"));
    }
}
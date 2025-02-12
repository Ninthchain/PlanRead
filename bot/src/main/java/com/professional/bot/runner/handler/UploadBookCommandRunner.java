package com.professional.bot.runner.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.professional.bot.command.BotCommand;
import com.professional.bot.runner.TelegramBaseCommandRunner;

@Component
public class UploadBookCommandRunner extends TelegramBaseCommandRunner{

    @Override
    public void run(BotCommand command, String incomingMessage, long userId) throws TelegramApiException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

}

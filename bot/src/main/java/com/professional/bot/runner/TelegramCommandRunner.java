package com.professional.bot.runner;

import java.rmi.UnexpectedException;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.professional.bot.command.BotCommand;

public interface TelegramCommandRunner {
    void run(BotCommand command, String incomingMessage, long userId) throws TelegramApiException, UnexpectedException;
}

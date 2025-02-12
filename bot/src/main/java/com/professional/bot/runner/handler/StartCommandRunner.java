package com.professional.bot.runner.handler;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.google.gson.Gson;
import com.professional.bot.TelegramBot;
import com.professional.bot.command.BotCommand;
import com.professional.bot.data.dto.UserCreationDto;
import com.professional.bot.data.dto.UserDto;
import com.professional.bot.data.entity.ReaderCache;
import com.professional.bot.dialog.DialogStatus;
import com.professional.bot.runner.TelegramBaseCommandRunner;
import com.professional.bot.service.ReaderCacheService;

@Component
public class StartCommandRunner extends TelegramBaseCommandRunner {
    @Autowired
    private TelegramBot bot;

    @Autowired
    private RestClient restClient;

    @Autowired
    private ReaderCacheService readerCacheService;

    @Override
    public void run(BotCommand command, String incomingMessage, long telegramId) throws TelegramApiException, UnexpectedException {

        bot.execute(this.buildTextMessage(telegramId,
                "Hey! How are you? I am PlanRead bot. I was created to help you with reading"));

        if (!readerCacheService.isReaderDataCached(telegramId)) {

            String response;
            ReaderCache readerCache;

            bot.execute(this.buildTextMessage(telegramId, "Hm, seems that I forgot you. Let me check my memory..."));

            try {

                response = restClient.get().uri(String.format("/users/search/telegram/%d", telegramId))
                        .retrieve().body(String.class);
            } catch (HttpClientErrorException e) {

                if (e.getStatusCode() != HttpStatus.BAD_REQUEST) {

                    throw new UnexpectedException(e.getMessage());
                }
                UserCreationDto userCreationDto = new UserCreationDto();
                userCreationDto.setBooks(new ArrayList<>());
                userCreationDto.setTasks(new ArrayList<>());
                userCreationDto.setTelegramId(telegramId);
                restClient.post()
                        .uri("/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(userCreationDto)
                        .retrieve()
                        .toBodilessEntity();
            }
            response = restClient.get().uri(String.format("/users/search/telegram/%d", telegramId)).retrieve()
                    .body(String.class);

            UserDto userDto = new Gson().fromJson(response, UserDto.class);

            readerCache = new ReaderCache(telegramId);
            readerCache.setDialogStatus(DialogStatus.REGISTERED.getDialogStatusCode());
            readerCache.setBooks((Set<Long>) userDto.getBooks());

            readerCacheService.saveReaderCache(readerCache);
        }
        bot.execute(buildTextMessage(telegramId, "Hello!"));
    }
}

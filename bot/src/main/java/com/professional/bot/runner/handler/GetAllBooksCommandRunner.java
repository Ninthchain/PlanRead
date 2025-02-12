package com.professional.bot.runner.handler;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup.EditMessageReplyMarkupBuilder;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.professional.bot.TelegramBot;
import com.professional.bot.command.BotCommand;
import com.professional.bot.data.dto.BookDto;
import com.professional.bot.data.dto.UserCreationDto;
import com.professional.bot.data.dto.UserDto;
import com.professional.bot.runner.TelegramBaseCommandRunner;

import jakarta.ws.rs.core.MediaType;

@Component
public class GetAllBooksCommandRunner extends TelegramBaseCommandRunner {
    @Autowired
    private RestClient restClient;
    @Autowired
    private TelegramBot bot;

    @Override
    public void run(BotCommand command, String incomingMessage, long userId) throws TelegramApiException {
        bot.execute(this.buildTextMessage(userId, getText(userId)));
    }

    private String getText(long userId) {
        StringBuilder sBuilder = new StringBuilder();
        String userResponse = restClient.get().uri(String.format("/users/search/telegram/%d", userId))
                .retrieve().body(String.class);

        Gson gson = new Gson();
        UserDto userDto = gson.fromJson(userResponse, UserDto.class);
        HashSet<Long> books = (HashSet<Long>) userDto.getBooks();
        if (books.isEmpty()) {
            return sBuilder.append(
                    "You don't have any book. Please upload it. It's free ;)\n To see all commands you can write /help tho.")
                    .toString();
        }
        sBuilder.append("Okee, let's seee your library:\n\t");

        int counter = 0;
        for (Long bookId : books) {
            String bookResponse = restClient.get().uri("/books/{id}", bookId).retrieve().body(String.class);
            BookDto bookDto = gson.fromJson(bookResponse, BookDto.class);
            sBuilder.append(counter + 1).append(' ').append(bookDto.getName() + "\n\t");
            counter++;
        }
        return sBuilder.toString();
    }

}

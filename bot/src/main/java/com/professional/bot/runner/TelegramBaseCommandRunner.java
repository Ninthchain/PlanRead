package com.professional.bot.runner;

import java.io.InputStream;

import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage.SendMessageBuilder;
import org.telegram.telegrambots.meta.api.objects.InputFile;

public abstract class TelegramBaseCommandRunner implements TelegramCommandRunner {

    protected SendMessage buildTextMessage(Long receiverId, String message) {
        SendMessageBuilder sendMessageBuilder = SendMessage.builder()
                .chatId(receiverId)
                .text(message);
        
         return sendMessageBuilder.build();       
    }

    protected SendDocument buildDocumentMessage(Long receiverId, String name, String path) {
        InputStream documentInputStream = this.getClass().getResourceAsStream(path);
        InputFile inputFile = new InputFile(documentInputStream, name);
        return SendDocument.builder()
                    .chatId(receiverId)
                    .document(inputFile)
                    .build();
    }
}

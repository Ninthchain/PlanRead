package com.professional.bot;

import java.rmi.UnexpectedException;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.professional.bot.command.BotCommand;
import com.professional.bot.command.CommandRegexMatcher;
import com.professional.bot.data.model.BotProfile;
import com.professional.bot.runner.TelegramCommandRunner;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final String botName;
    @Autowired
    private ApplicationContext applicationContext;
    // public final CommandsHandler commandsHandler;

    // public final CallbacksHandler callbacksHandler;

    public TelegramBot(BotProfile botProfile) {
        super(botProfile.getBotToken());

        this.botName = "PlanReadBot";

    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message receivedMessage = update.getMessage();
            Long senderId = receivedMessage.getChatId();
            if (receivedMessage.hasText()) {
                String text = receivedMessage.getText();
                Optional<BotCommand> command = Arrays.stream(BotCommand.values())
                        .filter(x -> CommandRegexMatcher.isMatch(x.getRegex(), text)).findFirst();

                if (command.isPresent()) {
                    getAndRunCommandHandler(command.get(), text, senderId);
                } else {
                    return;
                }
            }

        }
    }

    @Override
    public String getBotUsername() {
        // TODO Auto-generated method stub
        return botName;
    }

    // private void sendFile(long recieverId, String pathToFile) {
    // SendDocument sendDocument = new SendDocument();
    // sendDocument.setChatId(recieverId);
    // InputFile inputFile = new InputFile();
    // inputFile.setMedia(File)
    // sendDocument.setDocument();
    // }

    private boolean isDocumentPdf(String fileName) {
        Pattern pattern = Pattern.compile(".*\\.pdf$");
        if (pattern.matcher(fileName).matches()) {
            return true;
        } else {
            return false;
        }
    }

    private String getFileExtension(String fileName) {
        Pattern pattern = Pattern.compile("\\.[^.]+$");
        Matcher matcher = pattern.matcher(fileName);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }

    private void getAndRunCommandHandler(BotCommand command, String incomingMessage, long userId) {
        try {
            // converts the class name to Spring bean name, e.g.: StartCommandRunner ->
            // startCommandRunner
            char[] chars = command.getRunnerClass().toCharArray();
            chars[0] = Character.toLowerCase(chars[0]);
            String beanName = new String(chars);

            TelegramCommandRunner runner = applicationContext.getBean(beanName, TelegramCommandRunner.class);

            runner.run(command, incomingMessage, userId);
        } catch (TelegramApiException e) {

        } catch (UnexpectedException e) {

        }
    }
}

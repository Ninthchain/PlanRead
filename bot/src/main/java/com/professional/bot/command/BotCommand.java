package com.professional.bot.command;

import com.professional.bot.runner.handler.UploadBookCommandRunner;
import com.professional.bot.runner.handler.GetAllBooksCommandRunner;
import com.professional.bot.runner.handler.HelpCommandRunner;
import com.professional.bot.runner.handler.StartCommandRunner;
import lombok.Getter;

@Getter
public enum BotCommand {
    WELCOME("/start", StartCommandRunner.class.getSimpleName(), "user first time visit"),
    HELP("/help", HelpCommandRunner.class.getSimpleName(), "hello"),
    GET_ALL_BOOKS("/books", GetAllBooksCommandRunner.class.getSimpleName(), "Receives all user books"),
    UPLOAD_BOOK("/upload_book", UploadBookCommandRunner.class.getSimpleName(), "Uploads new book to you ilbrary");

    private final String regex;
    private final String runnerClass;
    private final String description;

    BotCommand(String regex, String runnerClass, String description) {
        this.regex = regex;
        this.runnerClass = runnerClass;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name() + ": "
                + "{"
                + "regex: \"" + regex + "\""
                + "}";
    }
}

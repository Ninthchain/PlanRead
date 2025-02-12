package com.professional.bot.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandRegexMatcher {

    public static boolean isMatch(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
}
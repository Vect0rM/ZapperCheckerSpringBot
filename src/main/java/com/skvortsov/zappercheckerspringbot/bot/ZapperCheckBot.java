package com.skvortsov.zappercheckerspringbot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class ZapperCheckBot extends TelegramLongPollingBot {

    public ZapperCheckBot(@Value("${bot.token}") String botToken){
        super(botToken);
    }
    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return "ZapperChecker";
    }
}

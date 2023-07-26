package com.skvortsov.zappercheckerspringbot.bot;

import com.skvortsov.zappercheckerspringbot.exception.ServiceException;
import com.skvortsov.zappercheckerspringbot.models.Token;
import com.skvortsov.zappercheckerspringbot.service.ZapperBotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class ZapperCheckBot extends TelegramLongPollingBot {

    @Autowired
    private ZapperBotService zapperBotService;
    private static final Logger log = LoggerFactory.getLogger(ZapperCheckBot.class);

    private static final String START = "/start";
    private static final String PORTFOLIO = "/portfolio";
    private static final String NFT = "/nft";
    private static final String HELP = "/help";
    public ZapperCheckBot(@Value("${bot.token}") String botToken){
        super(botToken);
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }
        String massage = update.getMessage().getText();
        var chatId = update.getMessage().getChatId();
        switch (massage) {
            case START -> {
                String username = update.getMessage().getChat().getUserName();
                startCommand(chatId, username);
            }
            case  NFT -> nftCommand(chatId);
            case  PORTFOLIO -> portfolioCommand(chatId);
            case HELP -> helpCommand(chatId);
            default -> unknownCommand(chatId);
        }
    }

    @Override
    public String getBotUsername() {
        return "ZapperChecker";
    }

    private void unknownCommand(Long chatId) {
        String text = "Не удалось распознать команду!";
        sendMessage(chatId, text);
    }
    private void sendMessage(Long chatId, String text) {
        String chatIdStr = String.valueOf(chatId);
        SendMessage sendMessage = new SendMessage(chatIdStr, text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Ошибка отправки сообщения", e);
        }
    }
    private void helpCommand(Long chatId) {
        String text = """
                Справочная информация по боту
               
                /portfolio - портфолио кошелька
                /nft - nft кошелька
                """;
        sendMessage(chatId, text);
    }
    private void startCommand(Long chatId, String userName) {
        var text = """
                Добро пожаловать в бот, %s!
   
                /help - получение справки
                """;
        var formattedText = String.format(text, userName);
        sendMessage(chatId, formattedText);
    }
    private void portfolioCommand(Long chatId) {
        Token token;
        String portfolio;
        try {
            token = zapperBotService.getPortfolio();
            portfolio = """
                    Монета: %s,
                    Цена за 1 штуку: %s $,
                    Количество монет: %s,
                    Общая сумма в долларах: %s $
                    """;
            portfolio = String.format(portfolio, token.getName(), token.getPrice(), token.getBalance(), token.getBalanceUSD());
        } catch (ServiceException e) {
            log.error("Ошибка получения курса доллара", e);
            portfolio = "Не удалось получить текущий курс доллара. Попробуйте позже.";
        }
        sendMessage(chatId, portfolio);
    }
    private void nftCommand(Long chatId) {
        String portfolio;
        try {
            portfolio = zapperBotService.getNFT();

        } catch (ServiceException e) {
            log.error("Ошибка получения курса доллара", e);
            portfolio = "Не удалось получить текущий курс доллара. Попробуйте позже.";
        }
        sendMessage(chatId, portfolio);
    }
}

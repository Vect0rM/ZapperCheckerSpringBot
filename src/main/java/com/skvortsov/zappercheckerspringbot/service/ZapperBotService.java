package com.skvortsov.zappercheckerspringbot.service;

import com.skvortsov.zappercheckerspringbot.Client.ZapperClient;
import com.skvortsov.zappercheckerspringbot.exception.ServiceException;
import com.skvortsov.zappercheckerspringbot.models.Token;
import com.skvortsov.zappercheckerspringbot.parser.ParserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZapperBotService implements ZapperBotServiceInterface{

    @Autowired
    private ZapperClient zapperClient;

    @Autowired
    private ParserToken parserToken;

    @Override
    public Token getPortfolio() throws ServiceException {
        return parserToken.getToken();
    }

    @Override
    public String getNFT() throws ServiceException {
        String reg = "<.*?>";
        String s = zapperClient.getDocument();
        return s.replaceAll(reg, "");

    }

}

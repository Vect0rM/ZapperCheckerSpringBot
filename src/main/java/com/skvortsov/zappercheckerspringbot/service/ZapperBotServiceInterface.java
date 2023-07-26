package com.skvortsov.zappercheckerspringbot.service;

import com.skvortsov.zappercheckerspringbot.exception.ServiceException;
import com.skvortsov.zappercheckerspringbot.models.Token;

public interface ZapperBotServiceInterface {

    Token getPortfolio() throws ServiceException;
    String getNFT() throws ServiceException;

}

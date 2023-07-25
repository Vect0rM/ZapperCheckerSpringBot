package com.skvortsov.zappercheckerspringbot.service;

import com.skvortsov.zappercheckerspringbot.exception.ServiceException;

public interface ZapperBotServiceInterface {

    String getPortfolio() throws ServiceException;
    String getNFT() throws ServiceException;

}

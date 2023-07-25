package com.skvortsov.zappercheckerspringbot.service;

import com.skvortsov.zappercheckerspringbot.Client.ZapperClient;
import com.skvortsov.zappercheckerspringbot.exception.ServiceException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZapperBotService implements ZapperBotServiceInterface{

    @Autowired
    private ZapperClient zapperClient;

    @Override
    public String getPortfolio() throws ServiceException {
        Document document = zapperClient.getDocument();
        Elements portfolioElements = document.getElementsByClass("_1b4wwya2ku");
        StringBuilder stringBuilder = new StringBuilder();
        for (Element elements : portfolioElements) {
           stringBuilder.append(elements.text()).append(", ");
        }
        return stringBuilder.toString();
    }

    @Override
    public String getNFT() throws ServiceException {
        Document document = zapperClient.getDocument();
        String f = document.title();
        return f;
    }
}

package com.skvortsov.zappercheckerspringbot.Client;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ZapperClient {

    @Value("${portfolio.url}")
    private String portfolioUrl;

    public Document getDocument() {
        Document document;
        try {
            document = Jsoup.connect(portfolioUrl).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36").referrer("https://zapper.xyz/ru").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return document;
    }
}

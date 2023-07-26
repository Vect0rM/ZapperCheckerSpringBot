package com.skvortsov.zappercheckerspringbot.parser;

import com.google.gson.Gson;
import com.skvortsov.zappercheckerspringbot.Client.ZapperClient;
import com.skvortsov.zappercheckerspringbot.models.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParserToken {

    @Autowired
    private ZapperClient zapperClient;

    public Token getToken(){
        String reg = "<.*?>";
        String jsonData  = zapperClient.getDocument();
        jsonData  = jsonData .replaceAll(reg, "");
        System.out.println(jsonData);
        jsonData = jsonData.substring(jsonData.lastIndexOf("token") + 7, jsonData.length() - 3);
        System.out.println(jsonData);
        Gson gson = new Gson();
        return gson.fromJson(jsonData, Token.class);
    }

}

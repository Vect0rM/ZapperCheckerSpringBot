package com.skvortsov.zappercheckerspringbot.Client;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ZapperClient {

    @Value("${portfolio.url}")
    private String portfolioUrl;

    public String getDocument() {

        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        options.addArguments("accept-language=ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7");
        options.addArguments("referer=https://zapper.xyz/ru/account/0x53fe5210aedf579eec4aa796a2ac165880a728f9?tab=portfolio");
        options.addArguments("sec-ch-ua=\"Not/A)Brand\";v=\"99\", \"Google Chrome\";v=\"115\", \"Chromium\";v=\"115\"");
        options.addArguments("sec-ch-ua-mobile=?0");
        options.addArguments("sec-ch-ua-platform=\"Windows\"");
        options.addArguments("sec-fetch-dest=empty");
        options.addArguments("sec-fetch-mode=cors");
        options.addArguments("sec-fetch-site=same-origin");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://zapper.xyz/z/v2/balances/tokens?addresses[]=0xb03abf64f0582be24cd8a17c79ab053c48c3fe7e&networks[]=ethereum&networks[]=polygon&networks[]=optimism&networks[]=gnosis&networks[]=binance-smart-chain&networks[]=fantom&networks[]=avalanche&networks[]=arbitrum&networks[]=celo&networks[]=moonriver&networks[]=bitcoin&networks[]=aurora&includeTokenWithoutPrice=true");

            Thread.sleep(5000);

            return driver.getPageSource();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
        return driver.getPageSource();
    }

}

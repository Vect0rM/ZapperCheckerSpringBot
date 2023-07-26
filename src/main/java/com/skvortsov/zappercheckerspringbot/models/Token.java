package com.skvortsov.zappercheckerspringbot.models;

import java.util.Date;

public class Token {
    private String id;
    private int networkId;
    private String address;
    private String label;
    private String name;
    private String symbol;
    private int decimals;
    private String coingeckoId;
    private String status;
    private boolean hide;
    private boolean canExchange;
    private boolean verified;
    private boolean externallyVerified;
    private Date priceUpdatedAt;
    private Date updatedAt;
    private Date createdAt;
    private double price;
    private double dailyVolume;
    private String totalSupply;
    private boolean holdersEnabled;
    private double marketCap;
    private double balance;
    private double balanceUSD;
    private String balanceRaw;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNetworkId() {
        return networkId;
    }

    public void setNetworkId(int networkId) {
        this.networkId = networkId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getDecimals() {
        return decimals;
    }

    public void setDecimals(int decimals) {
        this.decimals = decimals;
    }

    public String getCoingeckoId() {
        return coingeckoId;
    }

    public void setCoingeckoId(String coingeckoId) {
        this.coingeckoId = coingeckoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public boolean isCanExchange() {
        return canExchange;
    }

    public void setCanExchange(boolean canExchange) {
        this.canExchange = canExchange;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean isExternallyVerified() {
        return externallyVerified;
    }

    public void setExternallyVerified(boolean externallyVerified) {
        this.externallyVerified = externallyVerified;
    }

    public Date getPriceUpdatedAt() {
        return priceUpdatedAt;
    }

    public void setPriceUpdatedAt(Date priceUpdatedAt) {
        this.priceUpdatedAt = priceUpdatedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDailyVolume() {
        return dailyVolume;
    }

    public void setDailyVolume(double dailyVolume) {
        this.dailyVolume = dailyVolume;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public boolean isHoldersEnabled() {
        return holdersEnabled;
    }

    public void setHoldersEnabled(boolean holdersEnabled) {
        this.holdersEnabled = holdersEnabled;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalanceUSD() {
        return balanceUSD;
    }

    public void setBalanceUSD(double balanceUSD) {
        this.balanceUSD = balanceUSD;
    }

    public String getBalanceRaw() {
        return balanceRaw;
    }

    public void setBalanceRaw(String balanceRaw) {
        this.balanceRaw = balanceRaw;
    }

    public Token() {
    }

    @Override
    public String toString() {
        return "Token{" +
                "id='" + id + '\'' +
                ", networkId=" + networkId +
                ", address='" + address + '\'' +
                ", label='" + label + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", decimals=" + decimals +
                ", coingeckoId='" + coingeckoId + '\'' +
                ", status='" + status + '\'' +
                ", hide=" + hide +
                ", canExchange=" + canExchange +
                ", verified=" + verified +
                ", externallyVerified=" + externallyVerified +
                ", priceUpdatedAt=" + priceUpdatedAt +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", price=" + price +
                ", dailyVolume=" + dailyVolume +
                ", totalSupply='" + totalSupply + '\'' +
                ", holdersEnabled=" + holdersEnabled +
                ", marketCap=" + marketCap +
                ", balance=" + balance +
                ", balanceUSD=" + balanceUSD +
                ", balanceRaw='" + balanceRaw + '\'' +
                '}';
    }
}

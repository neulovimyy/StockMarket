package com.gtormo.StockMarket.stockMarket;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="CM_STOCK")
public class StockMarket {

    @Id
    private String stockSymbol;
    private String stockName;
    private float stockValue;
    @Transient
    private StockMarket stockMarket;


    @Override
    public String toString() {
        return "StockMarket{" +
                "stockSymbol='" + stockSymbol + '\'' +
                ", stockName='" + stockName + '\'' +
                ", stockValue=" + stockValue +
                '}';
    }
    public StockMarket getStockMarket() {
        return stockMarket;
    }

    public void setStockMarket(StockMarket stockMarket) {
        this.stockMarket = stockMarket;
    }
    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public float getStockValue() {
        return stockValue;
    }

    public void setStockValue(float stockValue) {
        this.stockValue = stockValue;
    }
}

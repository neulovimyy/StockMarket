package com.gtormo.StockMarket.stockMarket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class StockMarketService {

    Logger logger = LoggerFactory.getLogger(StockMarketService.class);
    StockMarketRepository stockMarketRepository;
    StockMarket sm;
    @Autowired
    private void setStockMarketRepository(StockMarketRepository stockMarketRepository) {
        this.stockMarketRepository = stockMarketRepository;
    }

    public List<StockMarket> stockMarkets () {
        List<StockMarket> stockMarkets = stockMarketRepository.findAll();
        for(StockMarket sm : stockMarkets) {
            this.sm = sm;
            sm.setStockMarket(this.sm);
        }
        return stockMarkets;
    }

    public StockMarket findById(String stockMarketSymbol) {
        List<StockMarket> stockMarkets = stockMarkets();
        return stockMarketRepository.findById(stockMarketSymbol)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, stockMarketSymbol + " not found")
                );
    }

    public void updateStockMarket(StockMarket stockMarket) {
        List<StockMarket> stockMarkets = stockMarkets();
        StockMarket sm = findById(stockMarket.getStockSymbol());
        sm.setStockMarket(sm);
        stockMarketRepository.save(stockMarket);
    }

}

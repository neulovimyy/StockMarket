package com.gtormo.StockMarket.stockMarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api")
public class StockMarketRestController{

    StockMarketService service;

    @Autowired
    private void setService(StockMarketService service) {
        this.service = service;
    }

    @GetMapping
    private List<StockMarket> getAllStockMarketList() {
        return service.stockMarkets();
    }

}

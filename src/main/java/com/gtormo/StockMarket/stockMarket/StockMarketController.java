package com.gtormo.StockMarket.stockMarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Controller
@RequestMapping("/stock")
public class StockMarketController {

    StockMarketService stockMarketService;
    StockMarketRepository stockMarketRepository;
    String stockMarketPath = "displayStock";
    String stockMarketInfoPath = "editStockInfo";
    String updateStockMarketPath = "updateStockValues";
    @Autowired
    private void setStockMarketService(StockMarketService stockMarketService, StockMarketRepository stockMarketRepository) {
        this.stockMarketService = stockMarketService;
        this.stockMarketRepository = stockMarketRepository;
    }

    @RequestMapping("")
    private String displayStockMarket(Model model, StockMarket stockMarket) {
        List<StockMarket> stockMarketList = stockMarketService.stockMarkets();
        model.addAttribute("stockMarketList", stockMarketList);
        return stockMarketPath;
    }

    @RequestMapping("/updateStockDetails/{stockSymbol}")
    private String editStockMarket(@PathVariable String stockSymbol, Model model) {
        StockMarket stockMarketInfo = stockMarketRepository.findById(stockSymbol)
                        .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, stockSymbol+" not found"));
        model.addAttribute("stockMarketInfo", stockMarketInfo);
        return stockMarketInfoPath;
    }

    @PostMapping("/submitStock")
    private String viewSingleStock(@ModelAttribute("stockForm") StockMarket stockMarket){
        stockMarketService.updateStockMarket(stockMarket);
        return "redirect:/stock";
    }

    @GetMapping("/updateStockValues/{stockSymbol}")
    private String updateSingleStock(@PathVariable String stockSymbol, Model model){
        StockMarket stockMarketInfo = stockMarketRepository.findById(stockSymbol)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, stockSymbol+" not found"));
        model.addAttribute("stockMarketInfo", stockMarketInfo);
        return updateStockMarketPath;
    }

}


package com.gtormo.StockMarket;

import com.gtormo.StockMarket.stockMarket.StockMarket;
import com.gtormo.StockMarket.stockMarket.StockMarketService;
import com.gtormo.StockMarket.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class StockMarketApplication {

	static Logger logger = LoggerFactory.getLogger(StockMarketApplication.class);
	static StockMarketService service;



	public static void main(String[] args) {

		SpringApplication.run(StockMarketApplication.class, args);

	}

}

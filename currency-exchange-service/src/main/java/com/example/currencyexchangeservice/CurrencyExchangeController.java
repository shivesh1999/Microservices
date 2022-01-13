package com.example.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository repo;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangevalue( @PathVariable String from,@PathVariable String to) {
		//CurrencyExchange currencyExchange= new CurrencyExchange(100,from,to,50);
		CurrencyExchange currencyExchange=repo.findByFromAndTo(from, to);
		if(currencyExchange ==null) {
			throw new RuntimeException("Unable to find data for "+from+" to "+to);
		}
		return currencyExchange;
	}
}

package com.example.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	private Logger logger=LoggerFactory.getLogger(CircuitBreakerController.class);
	@GetMapping("/sample-api")
	//@Retry(name="sample-api",fallbackMethod = "HardcodedResponse")
	//@CircuitBreaker(name="default",fallbackMethod = "HardcodedResponse")
	//@RateLimiter(name="default")
	@Bulkhead(name="default")
	public String sampleApi() {
//		logger.info("Sample API call received");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-website", String.class);
//		return forEntity.getBody();
		return "SAMPLE API";
	}
	
	public String HardcodedResponse(Exception ex) {
		return "fallback-response";
	}
	
}

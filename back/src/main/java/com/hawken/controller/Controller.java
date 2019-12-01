package com.hawken.controller;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class Controller {
	
	private String cachedJSON;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String api() {
		return (cachedJSON==null) ? "OUR TEMPLATE IS NULL" : cachedJSON;
	}
	
	@Scheduled(fixedRate = 10000)
	public void makeCall() {
		String url
		  = "http://chelhack.deletestaging.com/goods";
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.getForEntity(url, String.class);
		} catch(HttpServerErrorException e) {
			return;
		}
		cachedJSON = response.getBody();			
		JsonParser json = JsonParserFactory.getJsonParser();
		Map<String, Object> parsedMap = json.parseMap(response.getBody());
		if (parsedMap.get("status").equals("Success")) {
			this.cachedJSON = response.getBody();
		}
	}
	
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) 
    {
        return restTemplateBuilder
           .setConnectTimeout(Duration.ofSeconds(30))
           .setReadTimeout(Duration.ofSeconds(30))
           .build();
    }
}

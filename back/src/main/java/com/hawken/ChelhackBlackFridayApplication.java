package com.hawken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.hawken.controller.Controller;
import com.hawken.testdb.DBController;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class ChelhackBlackFridayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChelhackBlackFridayApplication.class, args);
	}

}

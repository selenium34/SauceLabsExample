package com.example.saucelabs.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("sauce")
public class SauceLabsConfiguration {

	@Bean
	public String baseURL() {
		return "http://localhost:8080/index.html";
	}
	
	@Bean
	public String userName() {
		throw new NullPointerException("Please eplace with your Sauce Labs Account User Name");
	}
	
	@Bean
	public String apiKey() {
		throw new NullPointerException("Please replace with your Suace Connect API Key");
	}
	
}

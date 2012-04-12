package com.example.saucelabs.web.configuration;

import java.net.MalformedURLException;

import javax.inject.Named;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class LocalConfiguration {

	@Bean @Named("baseURL")
	public String baseURL() {
		return "http://127.0.0.1:8080/index.html";
	}

	@Bean
	public WebDriver driver() throws MalformedURLException {
		return new FirefoxDriver();
	}
	
}

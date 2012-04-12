package com.example.saucelabs.web;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.saucelabs.web.configuration.LocalConfiguration;
import com.example.saucelabs.web.configuration.SauceLabsConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { LocalConfiguration.class, SauceLabsConfiguration.class })
@ActiveProfiles("sauce")
public class RemoteIndexControllerTest extends AbstractIndexControllerTest {

	@Autowired private String baseURL;
	@Autowired private String userName;
	@Autowired private String apiKey;
	
	@Test
	public void testLocalhostRedirect() throws MalformedURLException {
		super.testLocalhostRedirect(baseURL, createDriver(userName, apiKey));
	}
	
	private WebDriver createDriver(String userName, String apiKey) throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("platform", Platform.VISTA);
		capabilities.setCapability("name", "Testing Selenium 2 with Java on Testing Bot");
		capabilities.setCapability("selenium-version", "2.20.0");
		capabilities.setCapability("max-duration", "20");
		WebDriver driver = new RemoteWebDriver(
				new URL(
						"http://" + userName + ":" + apiKey + "@ondemand.saucelabs.com:80/wd/hub"),
				capabilities);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
}

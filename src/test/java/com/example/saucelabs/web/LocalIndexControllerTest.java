package com.example.saucelabs.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.saucelabs.web.configuration.LocalConfiguration;
import com.example.saucelabs.web.configuration.SauceLabsConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { LocalConfiguration.class, SauceLabsConfiguration.class })
@ActiveProfiles("local")
public class LocalIndexControllerTest extends AbstractIndexControllerTest {

	@Autowired private WebDriver driver;
	@Autowired private String baseURL;

	@Test
	public void testLocalhostRedirect() {
		super.testLocalhostRedirect(baseURL, driver);
	}
	
}

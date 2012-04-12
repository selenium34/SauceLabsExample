package com.example.saucelabs.web;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.example.saucelabs.web.pageobjects.IndexControllerPageObject;

public abstract class AbstractIndexControllerTest {

	protected AbstractIndexControllerTest() {
		
	}
	
	protected void testLocalhostRedirect(String URL, WebDriver driver) {
		driver.get(URL);
		IndexControllerPageObject icpo = PageFactory.initElements(driver, IndexControllerPageObject.class); 
		Assert.assertThat(driver.getTitle(), Matchers.containsString("Try "));
		Assert.assertThat(icpo.getParagraphText(), Matchers.equalTo("Test An Example Page"));
		driver.quit();
	}

}

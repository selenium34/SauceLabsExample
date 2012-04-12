package com.example.saucelabs.web.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexControllerPageObject {
	
	@FindBy(id = "testing")
	private WebElement testing;
	
	public String getParagraphText() {
		return testing.getText();
	}
	
}
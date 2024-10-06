package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

	
	private WebDriver driver;
	private By searchIcon=By.cssSelector("div#search>button");
//	private By forgotPwdLink=By.linkText("Forgotten Password");
	
	
	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
	}
	
}

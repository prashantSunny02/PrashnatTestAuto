package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount {

	
	private WebDriver driver;
	
	private By logoutLink=By.linkText("Logout");
	
	private By headers=By.cssSelector("div#content>h2");
	private By search=By.name ("search");
	private By searchIcon=By.cssSelector("div#search>button");
//	private By forgotPwdLink=By.linkText("Forgotten Password");
	
	
	public MyAccount(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	
	public String getMyAccountPageTitle() {
		String title=driver.getTitle();
		System.out.println("Account page title "+title);
		return title;
	}
	public String getMyAccountPageUrl() {
		String currentUrl=driver.getCurrentUrl();
		System.out.println("Account page url "+currentUrl);
		return currentUrl;
	}
	
	public boolean isLogoutLinkExist() {
		return driver.findElement(logoutLink).isDisplayed();
	}
	
	public List<String> getAccHeaders() {
		List<WebElement> headersList=driver.findElements(headers);
		List<String> headerValList=new ArrayList<String>();
		for(WebElement header:headersList) {
			String headerVal=header.getText();
			headerValList.add(headerVal);
		}
		return headerValList;
	}
	
	public boolean isSearchExist() {
		return driver.findElement(search).isDisplayed();
	}
	
	public SearchResultPage doSearch(String searchKey) {
		System.out.println("Searching .. " + searchKey);
		if (isSearchExist()) {
			driver.findElement(search).sendKeys(searchKey);
			driver.findElement(searchIcon).click();
			return new SearchResultPage(driver);
		} else {
			System.out.println("Search field do not exist");
		return null;
		}
	}
	
}

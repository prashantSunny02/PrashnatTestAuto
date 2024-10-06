package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;
import com.qa.opencart.utils.TimeUtils;

public class LoginPage {

	private WebDriver driver;
	private ElementUtils util;
	
	private By emailId=By.id("input-email");
	
	private By pwd=By.id("input-password");
	private By loginBtn=By.xpath("//input[@value='Login']");
	private By forgotPwdLink=By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		util=new ElementUtils(driver);
	}
	
	
	
	
	public String getLoginPageTitle() {
		String title="";
		try {
		util.waitForTitleContains(getLoginPageTitle(), 1);
		 title=driver.getTitle();
		System.out.println("login page title "+title);
		}catch(Exception e) {
			title="";
		}
		return title;
	}
	public String getLoginPageUrl() {
		String currentUrl=driver.getCurrentUrl();
		System.out.println("login page url "+currentUrl);
		return currentUrl;
	}
	
	public boolean checkForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
		 
	}
	
	public MyAccount doLogin(String username, String password) {
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(loginBtn).click();
		return new MyAccount(driver);
	}
	public RegistrationPage navigateToRegisterPage() {
		util.doClick(registerLink, TimeUtils.DEFAULT_TIME);
		return new RegistrationPage(driver);
	}
	
	
	
}

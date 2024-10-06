package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.contants.AppConstants;
import com.qa.opencart.utils.ElementUtils;
import com.qa.opencart.utils.TimeUtils;

public class RegistrationPage {

	private WebDriver driver;
	private ElementUtils util;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");

	private By successMessg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public boolean userRegister(String firstName, String lastName, String email, String telephone, String password,
			String subscribe) {

		util.doSendKeys(this.firstName, firstName, TimeUtils.DEFAULT_MEDIUM_TIME);
		util.doSendKeys(this.lastName, lastName);
		util.doSendKeys(this.email, email);
		util.doSendKeys(this.telephone, telephone);
		util.doSendKeys(this.password, password);
		util.doSendKeys(this.confirmpassword, password);

		if (subscribe.equalsIgnoreCase("yes")) {
			util.doClick(subscribeYes);
		} else {
			util.doClick(subscribeNo);
		}

		util.doClick(agreeCheckBox);
		util.doClick(continueButton);

		String successMesg = util.waitForElementVisible(successMessg, TimeUtils.DEFAULT_MEDIUM_TIME).getText();

		System.out.println(successMesg);		
				
		if (successMesg.contains(AppConstants.USER_REGISTER_SUCCESS_MESSG)) {
			util.doClick(logoutLink);
			util.doClick(registerLink);
			return true;
		} else {
			return false;
		}

	}

}
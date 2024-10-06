package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.contants.AppConstants;
import com.qa.opencart.errors.AppErrors;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest extends BaseTest {
	
	@Description("Checking page title")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=1)
	public void loginPageTitleTest() {
		String actTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE,AppErrors.Title_NOT_FOUND);
	}

	@Description("Checking page url")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void loginPageUrlTest() {
		String actUrl=loginPage.getLoginPageUrl();
		Assert.assertTrue(actUrl.contains(AppConstants.LOGIN_PAGE_FRACTION_URL),AppErrors.URL_NOT_FOUND);
	}
	
	@Description("Checking page ")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=3)
	public void checkForgotPwdLinkText() {
		Assert.assertTrue(loginPage.checkForgotPwdLinkExist(),AppErrors.LINK_NOT_FOUND);
		
	}
	
	@Description("Checking Account page title")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=4)
	public void doLogin() {
		accountPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accountPage.getMyAccountPageTitle(), AppConstants.ACCOUNT_PAGE_TITLE,AppErrors.Title_NOT_FOUND);;
		
	}
}

package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.contants.AppConstants;
import com.qa.opencart.errors.AppErrors;

public class AccountPageTest extends BaseTest {
	
	@BeforeTest
	public void accSetup() {
		accountPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test
	public void accPageTitleTest() {
		Assert.assertEquals(accountPage.getMyAccountPageTitle(), AppConstants.ACCOUNT_PAGE_TITLE,AppErrors.Title_NOT_FOUND);
	}


	@Test
	public void accPageUrlTest() {
		Assert.assertTrue(accountPage.getMyAccountPageUrl().contains(AppConstants.ACCOUNT_PAGE_FRACTION_URL),AppErrors.URL_NOT_FOUND);
	}
	
	
	@Test
	public void accPageHeaderTest() {
		List<String> accPageheadersList=accountPage.getAccHeaders();
//		Assert.assertEquals(accPageheadersList, AppConstants.ACC_PAGE_HEADER_LIST);
//		Assert.assertEquals(accPageheadersList, AppConstants.ACC_PAGE_HEADERS_LIST, AppErrors.LIST_IS_NOT_MATCHED);
	}
	
	
	
}

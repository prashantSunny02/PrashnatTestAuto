package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.contants.AppConstants;
import com.qa.opencart.errors.AppErrors;
import com.qa.opencart.utils.ExcelUtils;
import com.qa.opencart.utils.StringUtil;

import io.qameta.allure.Description;

public class RegistrationPageTest extends BaseTest{

		@BeforeClass
		@Description("Setup method to navigate to the registration page.")
		public void regSetup() {
			regPage = loginPage.navigateToRegisterPage();
//	        ExcelUtil.attachTestData();

		}

//		@DataProvider
//		public Object[][] userRegTestData() {
//			return new Object[][] {
//				{"Arti", "automation", "9876787656", "arti@123", "yes"},
//				{"Praful", "automation", "9876787690", "praful@123", "no"},
//				{"Madhu", "automation", "9876787876", "madhu@123", "yes"}
//			};
//		}
		

		@DataProvider
		public Object[][] userRegTestDataFromSheet() {
			return ExcelUtils.getTestData(AppConstants.REGISTER_SHEET_NAME);
		}

//		@DataProvider
//		public Object[][] userRegTestDataFromCSV() {
//			return CSVUtil.csvData(AppConstants.REGISTER_SHEET_NAME);
//		}

		
		@Test(dataProvider = "userRegTestDataFromSheet")
		public void userRegisterationTest(String firstName, String lastName, String telephone, String password, String subscribe) {
			Assert.assertTrue(
				regPage.userRegister(firstName, lastName, StringUtil.getRandomEmailId(), telephone, password, subscribe),
				AppErrors.USER_REG_NOT_DONE);
		}
	
	
	
	


	

}
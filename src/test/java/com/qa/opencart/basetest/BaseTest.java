package com.qa.opencart.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MyAccount;
import com.qa.opencart.pages.RegistrationPage;

public class BaseTest {
		
	
	WebDriver driver;
	protected Properties prop;
	DriverFactory df;
	protected LoginPage loginPage;
	protected MyAccount accountPage;
	protected RegistrationPage regPage;
	
	
	
	@BeforeTest
	public void setup(){
		df=new DriverFactory();
		prop=df.initProp();
		driver=df.initDriver(prop);
		System.out.println(driver);
		loginPage=new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}

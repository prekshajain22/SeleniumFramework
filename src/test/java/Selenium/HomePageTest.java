package Selenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import resources.base;

public class HomePageTest extends base {
	//For log4j
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void setUp() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String password) {
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
		HomePageObjects homePageObj = new HomePageObjects(driver);
		
		LoginPageObjects loginPgOb = homePageObj.getLoginClick();
		loginPgOb.getEmail().sendKeys(userName);
		loginPgOb.getPassword().sendKeys(password);
		loginPgOb.getLogin().click();
		log.info("Login button is clicked");
	}

	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data types test should run
		// Column stands for how many values for each test
		Object[][] data = new Object[2][2];
		data[0][0] = "test@test.com";
		data[0][1] = "123";

		
		 data[1][0] = "qa@test.com"; data[1][1] = "456";
		

		return data;
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}

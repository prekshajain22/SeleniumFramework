package Selenium;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import resources.base;

public class validateTitleTest extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void setUp() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Driver is initialized");
	}
	
	@Test
	public void basePageNavigation() {
		HomePageObjects homePageObj = new HomePageObjects(driver);
		assertEquals(homePageObj.getTitle().getText(), "FEATURED COURSES");	
		log.info("Successfully validated the title");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Driver is closed");
	}

}

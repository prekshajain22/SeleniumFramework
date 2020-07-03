package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
	
	public WebDriver driver;
	
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath("//h2[contains(text(), 'Featured Courses')]");
	
	public HomePageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public LoginPageObjects getLoginClick() {
		 driver.findElement(signin).click();
		 LoginPageObjects loginPgOb = new LoginPageObjects(driver);
		 return loginPgOb;
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}

}

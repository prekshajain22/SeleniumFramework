package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	
	public WebDriver driver;
	
	private By email = By.id("user_email");
	private By pwd = By.id("user_password");
	private By loginIn = By.cssSelector("input[value='Log In']");
	
	public LoginPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(pwd);
	}
	
	public WebElement getLogin() {
		return driver.findElement(loginIn);
	}

}

package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		// FileInputStream fis = new FileInputStream(
		// "C:\\Users\\Preksha\\eclipse-workspace\\SeleniumFramework\\src\\main\\java\\config\\config.properties");
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
		prop.load(fis);
		// When browserName is send via Maven command, use the following code
		// mvn test -Dbrowser=chrome
		// String browserName = System.getProperty("browser");

		String browserName = prop.getProperty("browser");
		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Preksha\\Downloads\\Work-Automation\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless"))
				options.addArguments("headless");
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Path of driver");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver. gecko. driver", "Path of driver");
			driver = new FirefoxDriver();

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		String destinationFile = System.getProperty("user.dir") + testCaseName + ".png";
		System.out.println("Des:::: " + destinationFile.toString());
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

}

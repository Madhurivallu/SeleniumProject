package ExtentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameworkScript {
	// start reporters
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Report1.html");

	// create ExtentReports and attach reporter(s)
	ExtentReports extent = new ExtentReports();

	@Test
	public void openBrowser() throws Exception {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demo.openmrs.org/openmrs/login.htm");

		WebElement username = driver.findElement(By.id("username"));

		username.sendKeys("abdckhd@gmail.com");

		System.out.println("Enter username:  abdckhd@gmail.com");

		WebElement password = driver.findElement(By.id("password"));

		password.sendKeys("madhu3@#");

		System.out.println("Enter password: madhuu3@#");

		driver.findElement(By.id("loginButton")).click();

		Thread.sleep(2000);

		driver.close();

		extent.flush();

	}

}





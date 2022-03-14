package ExtentReports;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTesting {

	WebDriver driver = null;

	ExtentReports extent;

	@Test
	public void extentTest() throws Exception {
		ExtentReports extent = new ExtentReports();
		String path = System.getProperty("user.dir") + "\\reports\\extent.html";
		ExtentSparkReporter spark = new ExtentSparkReporter("extent.html");
		spark.config().setReportName("parallel testing");
		spark.config().setDocumentTitle("multiple webpages");
		extent.attachReporter(spark);

		ExtentTest test = extent.createTest("Website loging").assignAuthor("madhuri");
		test.pass("website started successfully");
		test.info("url is entered");
		test.info("values entered");
		test.pass("guru99.com is login successfully");
		ExtentTest test1 = extent.createTest("guru99.com");
		System.out.println("first webpage is testing");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://www.guru99.com/selenium-tutorial.html");
		Thread.sleep(2000);
		ExtentTest test2 = extent.createTest("thepancard.com");
		System.out.println("second webpage is testing");
		driver.get("https://www.thepancard.com");
		Thread.sleep(2000);
		driver.close();
		extent.flush();
	}

}

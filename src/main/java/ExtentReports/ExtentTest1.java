package ExtentReports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class ExtentTest1 {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;
	WebDriver driver;

	@Test
	public void TestSuccessfull() {

		driver.get("https://mvnrepository.com/artifact/com.aventstack/extentreports/4.0.9");
		extentTest = extent.createTest("Successfull Test");
		extentTest.log(Status.PASS, "Test method is successfull");

	}

	public void Testfailed() {

		extentTest = extent.createTest("Failed Test");
		extentTest.log(Status.FAIL, "Test method is failed");
		Assert.fail("Executing fail test method");

	}

	public void TestSkipped() {

		extentTest = extent.createTest("Skipped Test");
		extentTest.log(Status.SKIP, "Test method is Skipped");
		throw new SkipException("Executing Skipped test method");

	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
		htmlReporter = new ExtentHtmlReporter("./reports/extent1.html");
		htmlReporter.config().setDocumentTitle("Extent Reports Implemented");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.setSystemInfo("Tester", "Madhuri");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		extent.flush();
	}

}


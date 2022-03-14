package Stockaccount;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaccountAdmin {

	
	public static void main(String[] args) throws Throwable {
		
		Properties config = new Properties();
		
		config.load(new FileInputStream("Log.properties"));
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(config.getProperty("Url"));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(config.getProperty("ObjReset"))).click();
		
		Thread.sleep(2000);
	
		driver.findElement(By.xpath(config.getProperty("Objusername"))).sendKeys(config.getProperty("usernamedata"));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(config.getProperty("Objpassword"))).sendKeys(config.getProperty("passworddata"));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(config.getProperty("ObjLogin"))).sendKeys((Keys.ENTER));
		
		Thread.sleep(2000);
		
		driver.close();
		
		
		
		
		

	}

}

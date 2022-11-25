package week5.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceBaseClass {
	
	public ChromeDriver driver;
	
	/*@DataProvider(name="salesforce")
	public String[][] fetchData() throws IOException
	{
	  ReadExcelData readExcel = new ReadExcelData();
	String[][] readData = readExcel.dataProviderMethod();
		
		return readData;
		
	}*/
	
	@Parameters({"URL","UserName","Password"})
	
	@BeforeMethod
	public void preCondition(String url,String username,String password) throws InterruptedException
	{
		//1. Login to https://login.salesforce.com
				WebDriverManager.chromedriver().setup();
				//Disable notifications 
				ChromeOptions options = new ChromeOptions();
		        options.addArguments("--disable-notifications");
				driver=new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get(url);
				driver.findElement(By.id("username")).sendKeys(username);
				driver.findElement(By.id("password")).sendKeys(password);
				driver.findElement(By.id("Login")).click();
				Thread.sleep(3000);
				
			
				
	}
	
	@AfterMethod
	public void postCondition()
	{
		
	}

}

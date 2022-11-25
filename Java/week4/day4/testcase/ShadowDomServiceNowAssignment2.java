package week4.day4.testcase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;


public class ShadowDomServiceNowAssignment2 {
	/*
	 * 1. Launch ServiceNow application
      2. Login with valid credentials username and password 
	  3. Click All
      4.Click  Incidents in Filter navigator
      5. Click on Create new option and fill the mandatory fields
      6. Verify the newly created incident by getting the incident number and put it in search field and 
		 enter then verify the instance number created or not
      7. Confirm incident exists !
	 */

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//1. Launch ServiceNow application
		driver.get("https://dev121461.service-now.com");
		
		//2. Login with valid credentials username and passwor
		//Login to the Service now by locating the webelements
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Testleaf@123");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(4000);
		
		//3. Click All
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(30);
		dom.findElementByXPath("//div[text()='All']").click();
		
		
	       //4.Click  Incidents in Filter navigator
		Thread.sleep(2000);		
		//Click on Filter and Enter Incidents
		dom.findElementByXPath("//input[@id='filter']").sendKeys("Incidents");
		//Click on incidents
		dom.findElementByXPath("//span[@class='label']/mark").click();
		
	      //5. Click on Create new option and fill the mandatory fields
		Thread.sleep(4000);
		WebElement frameElement = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frameElement);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		Thread.sleep(3000);
		
		//Get the Incident number
		String IncidentNumbertext = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Incident Number :"+IncidentNumbertext);
		
		//Enter the Short Description
		//driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("New IR");
		String parentWindow = driver.getWindowHandle();
		String parentWindowTitle = driver.getTitle();
		System.out.println("Parent Window Title: "+parentWindowTitle);
		driver.findElement(By.xpath("//a[@id='lookup.incident.short_description']")).click();
		//New Window opened
				//Handle the new window using the WindowHandles
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> windowHandlesList = new ArrayList<String>(windowHandles);
				System.out.println("No of Windows opened: "+windowHandlesList.size());
				System.out.println("Window Name : "+driver.getTitle());
				//Switch to next Window
				driver.switchTo().window(windowHandlesList.get(1));		
				//Select the Short Description
				driver.findElement(By.xpath("//a[text()='Issue with a web page']")).click();
				Thread.sleep(2000);
				//Switch to Parent Window
				driver.switchTo().window(parentWindow);
		
		//Click on Submit Button
		//Switch to Frame
		driver.switchTo().frame(frameElement);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
	     //6. Verify the newly created incident by getting the incident number and put it in search field and 
		//enter then verify the instance number created or not
		 driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(IncidentNumbertext,Keys.ENTER);
		 driver.findElement(By.xpath("//input[@id='incident_table_header_search_control']")).sendKeys(IncidentNumbertext,Keys.ENTER);
		 String searchResultTxt = driver.findElement(By.xpath("(//td[@class='vt'])[1]")).getText();
		 System.out.println("Incident Number Found :"+searchResultTxt);
		 Thread.sleep(2000);
		
	      //7. Confirm incident exists !
		
		List<WebElement> incidentElement = driver.findElements(By.xpath("//a[@class='linked formlink']"));
		List<String> incidentNumberList = new ArrayList<String>();
		for(int i =0;i< incidentElement.size();i++)
		{
			String IRTxt = incidentElement.get(i).getText();
			if(IRTxt.equals(IncidentNumbertext))
			{
				System.out.println("Incident Number Created and Verified ");
				break;
			}
		}
	}

}

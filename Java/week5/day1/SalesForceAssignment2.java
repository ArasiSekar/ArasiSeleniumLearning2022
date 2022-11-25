package week5.day1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceAssignment2 extends SalesforceBaseClass {
	
	/*
	 * Create Opportunity without mandatory fields
       "Test Steps:
        1. Login to https://login.salesforce.com
        2. Click on toggle menu button from the left corner
        3. Click view All and click Sales from App Launcher
        4. Click on Opportunity tab 
        5. Click on New button
        6. Choose Close date as Tomorrow Date
        7. Click on save 
        8. Verify the Alert message (Complete this field) displayed for Name and Stage"

	 */
	@Test
	public void salesForceVerifyAlertMessage() throws InterruptedException
	{
	/*
		//1. Login to https://login.salesforce.com
				WebDriverManager.chromedriver().setup();
				//Disable notifications 
				ChromeOptions options = new ChromeOptions();
		        options.addArguments("--disable-notifications");
				ChromeDriver driver=new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get("https://login.salesforce.com");
				driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
				driver.findElement(By.id("password")).sendKeys("Testleaf$321");
				driver.findElement(By.id("Login")).click();
				Thread.sleep(3000);
				*/
				//2. Click on toggle menu button from the left corner
				driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
				
				//3. Click view All and click Sales from App Launcher
				driver.findElement(By.xpath("//p[text()='Sales']")).click();
				Thread.sleep(3000);
				
				// 4. Click on Opportunity tab 
				WebElement oppurtunityClick = driver.findElement(By.xpath("//span[text()='Opportunities']"));
				Actions builder = new Actions(driver);
				builder.click(oppurtunityClick).build().perform();
				System.out.println("Clicked on Oppurtunity tab");
				Thread.sleep(2000);
				
			    // 5. Click on New button
				driver.findElement(By.xpath("//a[@class='forceActionLink']")).click();
				System.out.println("Clicked on the New tab");	
				Thread.sleep(2000);
				
				 //6. Choose Close date as Tomorrow Date
			    
				WebElement datePicker = driver.findElement(By.xpath("(//input[@class='slds-input'])[3]"));
				 Calendar cal = Calendar.getInstance();
				 //Getting today date
				 Date dateToday = cal.getTime();
				 System.out.println("Printing Today date : "+dateToday);
				 //To get Tommorrow date
				 cal.add(Calendar.DAY_OF_YEAR, 1);
				 Date dateTommorrow = cal.getTime();
				 System.out.println("Tomorrow Date : "+dateTommorrow);
				 
				 //Formatting the date
				 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				 String formattedDate = dateFormat.format(dateTommorrow);
				 System.out.println("dateFormattedTommorrow :"+formattedDate);
				 datePicker.sendKeys(formattedDate);
				 Thread.sleep(2000);
	
	           // 7. Click on save
				 driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
				 Thread.sleep(3000);
				 
				 //8. Verify the Alert message (Complete this field) displayed for Name and Stage"
				 
				//Clicking the Alert button to click on mandatort field for Oppurtuinity field
				 
				 driver.findElement(By.xpath("//button[@class='footer-button page-error-button slds-button slds-button_icon-error slds-m-right_small']")).click();
				 System.out.println("Clicked on Alert button");
				 driver.findElement(By.xpath("//a[text()='Opportunity Name']")).click();
				 System.out.println("Clicked on oppurtunity Name mandatory field");				 
				 String oppurtunityFieldTextVerify = driver.findElement(By.xpath("(//div[text()='Complete this field.'])[1]")).getText();
				 System.out.println("Mandatory Field Oppurtunity :"+oppurtunityFieldTextVerify);
				 if(oppurtunityFieldTextVerify.contains("Complete"))
				 {
					 System.out.println("Pls enter Mandatory Field msg displayed for Oppurtunity Field");
				 }
				 else
				 {
					 System.out.println("Mandatory Field not displayed for Oppurtunity field");
				 }
				 Thread.sleep(5000);
				 
				//Clicking Alert button to click on mandatory field for stage
				 driver.findElement(By.xpath("//button[@class='footer-button page-error-button slds-button slds-button_icon-error slds-m-right_small']")).click();
				 System.out.println("Clicked on Alert button");
				 driver.findElement(By.xpath("//a[text()='Stage']")).click();
				 System.out.println("Clicked on the Stage mandatory field in alert");
				 
				 String stageFieldTextVerify = driver.findElement(By.xpath("(//div[text()='Complete this field.'])[2]")).getText();
				 System.out.println("Mandatory Field Oppurtunity :"+stageFieldTextVerify);
				 
				 System.out.println("Clicked on the Stage mandatory field");
				 
				 if(stageFieldTextVerify.contains("Complete"))
				 {
					 System.out.println("Pls enter Mandatory Field msg displayed for Stage Field");
				 }
				 else
				 {
					 System.out.println("Mandatory Field not displayed for Stage field");
				 }
				 Thread.sleep(5000);
				
	    
	}

}

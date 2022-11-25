package week5.day1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceAssignment1 extends SalesforceBaseClass {
	/*
	 * 1. Login to https://login.salesforce.com
	 * hari.radhakrishnan@qeagle.com
       Testleaf$321
       2. Click on toggle menu button from the left corner
       3. Click view All and click Sales from App Launcher
       4. Click on Opportunity tab 
       5. Click on New button
       6. Enter Opportunity name as 'Salesforce Automation by Your Name,
          Get the text and Store it 
       7. Choose close date as Today
       8. Select 'Stage' as Need Analysis
       9. click Save and VerifyOppurtunity Name"
	 */

	    @Test
		public void SalesForce() throws InterruptedException
		{
		/*
		 /1. Login to https://login.salesforce.com
		 
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
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);
		
		
		
		//click on sales:
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(4000);
		
		//Switch to Parent Window
		//driver.switchTo().window(parentWindowHandle);
	
		
		// 4. Click on Opportunity tab 
		WebElement oppurtunityClick = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		Actions builder = new Actions(driver);
		builder.click(oppurtunityClick).build().perform();
		System.out.println("Clicked on Oppurtunity tab");
		Thread.sleep(2000);
		
	    // 5. Click on New button
		driver.findElement(By.xpath("//a[@class='forceActionLink']")).click();
		System.out.println("Clicked on the New tab");		
		
		
	    	
		
		 //6. Enter Opportunity name as 'Salesforce Automation by Your Name,
         //Get the text and Store it 
		String enterOppurtunityFieldText = "Salesforce Automation by Arasi";  
		driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys(enterOppurtunityFieldText);
		 
		 System.out.println("The entered text is : "+enterOppurtunityFieldText);
		 
		
      //7. Choose close date as Today
		 WebElement datePicker = driver.findElement(By.xpath("(//input[@class='slds-input'])[3]"));
		 Calendar cal = Calendar.getInstance();
		 Date date = cal.getTime();
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		 String formattedDate = dateFormat.format(date);
		 System.out.println("date :"+formattedDate);
		 datePicker.sendKeys(formattedDate);
		 
      //8. Select 'Stage' as Need Analysis
		 driver.findElement(By.xpath("(//span[contains(text(),'None')])[1]")).click();
		 Thread.sleep(2000);
		 
		 //Dropdown values are no inspectable
		 //So in the Dom > Event Listeners > Under blur remove all the items
		 //After doing that Now the values are inspectable
		 //driver.findElement(By.xpath("(//span[@class='slds-media__body']/span[text()='Needs Analysis']")).click();
		 driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		 System.out.println("Selected Need Analysis from the Stage Dropdown");
		 
      //9. click Save and VerifyOppurtunity Name"
		 driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		 Thread.sleep(2000);
		
		 //Get the Oppurtunity name
		 
			 
		 String verifyText = driver.findElement(By.xpath("//lightning-formatted-text[contains(text(),'Salesforce')]")).getText();
		 System.out.println("Text Displayed : "+verifyText);
		 if(verifyText.contains(enterOppurtunityFieldText))
		 {
			 System.out.println("Verified Oppurtunity Createdsuccessfully");
		 }
		 else
		 {
			 System.out.println("Created Oppurtunity not matched");
		 }
		 
		
		
		
		
		
		
         
		
	}

}

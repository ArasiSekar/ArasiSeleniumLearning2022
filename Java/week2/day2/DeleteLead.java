package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	/*
	 * * 1	Launch the browser
			* 2	Enter the username
			* 3	Enter the password
			* 4	Click Login
			* 5	Click crm/sfa link
			* 6	Click Leads link
			* 7	Click Find leads
			* 8	Click create leads
			* 9	enter your company name 
			* 10 enter your first name
            * 11 enter your last name
            *12 click on create lead
			* 13 Click on Delete
	 */

	public static void main(String[] args) {
		
		  //Setting up Chrome Browser
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			//implicit Wait
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			//maximize window
			driver.manage().window().maximize();
			//To open Url
			driver.get("http://leaftaps.com/opentaps/control/main");
			//To Enter uname,pwd and click login
			driver.findElement(By.id("username")).sendKeys("Democsr2");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			
			//To click crmsfa link in homepage
			driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
			
			//To Click Leads tab
			driver.findElement(By.xpath("//a[text()='Leads']")).click();
			
			//To Click FindLeads
			driver.findElement(By.xpath("//a[contains(text(),'Find ')]")).click();
			
			//To Click Create Leads
			driver.findElement(By.xpath("//a[contains(text(),'Create')]")).click();
			
			//To Enter Company Name,FName,LName,Click on CreateLead button
			driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Lister");
			WebElement fName = driver.findElement(By.xpath("(//input[@class='inputBox'])[3]"));
	        String firstName="Navi";
			fName.sendKeys(firstName);
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Raja");
			driver.findElement(By.xpath("//input[@name='submitButton']")).click();
			WebElement viewPageFName = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']"));
			String viewPageText = viewPageFName.getText();
			if(viewPageText.equals(firstName))
			{
				System.out.println(" Lead Created");
			}
			else
			{
				System.out.println("Lead not Created");
			}
		
		//Click on Delete
			driver.findElement(By.xpath("//a[text()='Delete']")).click();
			

	}

}

package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath {

	public static void main(String[] args) {
		/*
		 * 1. Create a class name as Xpath
		 * 2. Setup Chrome Driver
		 * 3. Apply Wait and maximize the screen
		 * 4. Go to the Url
		 * 5. Login Credentials
		 * 6. Click Crmsfa link
		 * 7. Click Leads tab
		 * 8. Click CreateLeads tab
		 * 9. Enter Compname,fname and lname
		 * 10. Click on CreateLead button
		 * 11. Details will be created and View lead page displayed.
		 */
		
		//Setup Chrome Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Applying Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Opening Url
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		//Entering UserName, Pwd and clicking login
		driver.findElement(By.id("username")).sendKeys("Democsr2");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//HomePage Click on the Crmsfa Link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//Click on Leads tab
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		
		//Click on CreateLeads tab
		driver.findElement(By.xpath("//a[contains(text(),'Create')]")).click();
		
		//Enter Company Name, FName and LNAMe
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("ABC");
		driver.findElement(By.xpath("(//input[@class='inputBox'])[3]")).sendKeys("Arasi");
		driver.findElement(By.xpath("(//input[@class='inputBox'])[4]")).sendKeys("S");
		
		//Click on CreateLead button
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		
		

	}

}

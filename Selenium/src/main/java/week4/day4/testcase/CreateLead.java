package week4.day4.testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseLead {

	 /* Extends from BaseLead Class
	  * PreConditions() from BaseLead Class will be executed before the @Test
	  * @Test from CreateLead Class will be executed
	  * Postconditions() from BaseClass will be executed after @Test
	  */
	 @Test//(timeOut=8000)
	public void createLead() {
		 
		 //The below steps can be skipped as we extended the Base class
		 //and the base class preconditions() method will be called
		 
		/*WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();*/
		 
		
		 //Base class before method will be executed before the @Test
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Subraja");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Subi");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("99");
		driver.findElement(By.name("submitButton")).click();

	}
}

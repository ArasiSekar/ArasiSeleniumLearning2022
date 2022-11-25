package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	/*http://leaftaps.com/opentaps/control/main
	 
	1	Launch the browser
	2	Enter the username
	3	Enter the password
	4	Click Login
	5	Click crm/sfa link
	6	Click Leads link
	7	Click Find leads
	8	Click on Email
	9	Enter Email
	10	Click find leads button
	11	Capture name of First Resulting lead
	12	Click First Resulting lead
	13	Click Duplicate Lead
	14	Verify the title as 'Duplicate Lead'
	15	Click Create Lead
	16	Confirm the duplicated lead name is same as captured name
	17	Close the browser (Do not log out)
	*/

	public static void main(String[] args) throws InterruptedException {
		
		
		//Setting up Chrome Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Applying Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Maximizing the window
		driver.manage().window().maximize();
		//Opening the Url
		driver.get("http://leaftaps.com/opentaps/control/main");
		//Enter UName,Pwd, Clicking Login button
		//Using ElderSibling to YoungerSibling Advanced xpath
		driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input")).sendKeys("Democsr2");
		//Using Younger Cousin to Elder Sibling xpath
		driver.findElement(By.xpath("(//input[@class='decorativeSubmit']/preceding::input)[2]")).sendKeys("crmsfa");
		//Using Elder Cousin to Younger Cousin Xpath
		driver.findElement(By.xpath("//label[text()='Password']/following::input[@class='decorativeSubmit']")).click();
		//Clicking CRM/SFA link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		//Clicking Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		//Click on Find Leads 
		driver.findElement(By.xpath("//a[contains(text(),'Find')]")).click();
		//Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		//Enter Email
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("abc@gmail.com");
		//Click on Find Leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
		//Click on First Displayed Search result and using parent child relationship xpath
		
		//driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext']")).click();
		//driver.findElement(By.xpath("//div[contains(@class,'partyId')]/a[@class='linktext']")).click();
		//driver.findElement(By.xpath("(//td[contains(@class,'partyId')])[2]/following::div")).click();
		//driver.findElement(By.xpath("//a[text()='10101']")).click();
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//div[contains(@class,'partyId')])[2]/a")).click();
			
		
		//Click on Duplicate lead button
		driver.findElement(By.xpath("//a[contains(text(),'Duplicate')]")).click();

		 //Checking the Duplicate Lead name
		String dupGetTextName = driver.findElement(By.xpath("//div[contains(text(),'Duplicate')]")).getText();
		System.out.println("The String Name displayed in Page is :"+dupGetTextName);
		String compareTextName ="Duplicate Lead";
		
		if(compareTextName.equals(dupGetTextName))
			{
			System.out.println("Duplicate Lead Name Displayed successfully");
		}
		else
		{
			System.out.println("Duplicate Lead Name not matched");
		}
		
		//Click Create Lead
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		//Capture the Duplicated Lead Name
		
		String  fNameText = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		String  comparingText ="Hema";
		if(fNameText.equals(comparingText))
		{
			System.out.println("FName Matched");
		}
		else
		{
			System.out.println("FName not matching");
		}
		driver.close();
		
		

	}

}

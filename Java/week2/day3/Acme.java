package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Acme {
	
	/*
	 * 1. Load url "https://acme-test.uipath.com/login"	 
	2. Enter email as "kumar.testleaf@gmail.com"
	3. Enter Password as "leaf@12"
	4. Click login button
	5. Get the title of the page and print
	6. Click on Log Out
	7. Close the browser (use -driver.close())
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
				driver.get("https://acme-test.uipath.com/login");
				//Entering Email
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");
				//Entering Pwd
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
				//Click on Login button
				driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
				//Get the Title of the Page
				String pageTitle = driver.getTitle();
				System.out.println("The Title of page is:"+pageTitle);
				//Click on Logout
				driver.findElement(By.xpath("//a[contains(text(),'Log')]")).click();
				Thread.sleep(5000);
				//closing the browser
				driver.close();
	}

}

package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {
	/*
	 * Step 1: Download and set the path 
     * Step 2: Launch the chromebrowser
// Step 3: Load the URL https://en-gb.facebook.com/
// Step 4: Maximise the window
// Step 5: Add implicit wait
// Step 6: Click on Create New Account button
// Step 7: Enter the first name
// Step 8: Enter the last name
// Step 9: Enter the mobile number
// Step 10: Enterthe password
// Step 11: Handle all the three drop downs
// Step 12: Select the radio button "Female" 
            ( A normal click will do for this step) 
	 */

	public static void main(String[] args) {
	
		//Setting up Chrome Driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//To maximize
		driver.manage().window().maximize();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//opening url
		driver.get("https://en-gb.facebook.com/");
		
		//Click on the Create New Link
		driver.findElement(By.linkText("Create New Account")).click();
		
		//Enter FirstName
		driver.findElement(By.name("firstname")).sendKeys("Arasi");
		
		//Enter LastName
		driver.findElement(By.name("lastname")).sendKeys("Sekar");
		
		//Enter MobileNumber
		driver.findElement(By.name("reg_email__")).sendKeys("1234567890");
		
		//To Enter New Password
		driver.findElement(By.id("password_step_input")).sendKeys("facebook@123");
		
		//Select the Day
		WebElement selectDay = driver.findElement(By.id("day"));
		Select selDayObj = new Select(selectDay);
		//Select by Value
		selDayObj.selectByValue("8");
		
		//Select Month
		WebElement selectMonth = driver.findElement(By.id("month"));
		Select selMonthObj = new Select(selectMonth);
		//Select by visibleText
		selMonthObj.selectByVisibleText("Sep");
		
		//Select Year
		WebElement selectYear = driver.findElement(By.id("year"));
		Select selYearObj = new Select(selectYear);
		//select by index
		selYearObj.selectByIndex(3);
		
		//Select Gender
				
		driver.findElement(By.name("sex")).click();
		

	}

}

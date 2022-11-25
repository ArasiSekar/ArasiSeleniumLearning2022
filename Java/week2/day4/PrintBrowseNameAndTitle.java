package week2.day4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintBrowseNameAndTitle {
	/*
	 * Open the browser
		Load the URL
		Maximize the browser
		Enter UserName
		Enter Password
		Click Login
		Click CRM/SFA
		Click Contacts Tab
		Click Create Contact
		Type First Name
		Type Last Name
		Click Create Contact Button
		Print the first name and browser title 
		Close the browser
	 */

	public static void main(String[] args) throws IOException, InterruptedException {
	
		//Setting up chrome Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	   //Open url
		driver.get("http://leaftaps.com/opentaps/control/main");
		//Enter uname,pwd,click login button
		//Using Younger Cousin to Elder Cousin xpath
		driver.findElement(By.xpath("//label[text()='Password']/preceding::input")).sendKeys("Democsr2");
		//Using Parent to Child xpath
		driver.findElement(By.xpath("(//form[@id='login']/p)[2]/input")).sendKeys("crmsfa");
		//Using Basic xpath
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		//Clicking CRM/SFA using basic xpath
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		//Clicking Contacts tab
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		//Clicking Create Contact
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		//Type First Name
		driver.findElement(By.xpath("//input[@id='firstNameField']")).sendKeys("AAA");
		//Type Last Name
		driver.findElement(By.xpath("//input[@id='lastNameField']")).sendKeys("RRR");
		
		Thread.sleep(5000);
		//Using JscriptExecutor
		//JavascriptExecutor js =(JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,250)", "");
		
		//Click Create Contact Button
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		//Getting the Screenshot
		File source=driver.getScreenshotAs(OutputType.FILE);
		//To set the File for the path to where the screen print to be saved
		File destination= new File("./ScreenShot/screen.png");
		//To put inside the file
		FileUtils.copyFile(source, destination);
		//To print the FirstName
		String fNameText = driver.findElement(By.xpath("//span[@id='viewContact_firstName_sp']")).getText();
        System.out.println("Created Contact First Name: "+fNameText);
        //To Print Browser Title
        String browserTitle = driver.getTitle();
        System.out.println("Browser Title: "+browserTitle);
        //Closing the Browser
        driver.close();
	}

}

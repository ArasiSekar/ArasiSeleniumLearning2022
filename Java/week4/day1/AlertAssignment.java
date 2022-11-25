package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertAssignment {

	/*
	 * 1. https://www.leafground.com/alert.xhtml
	 * 2. Handling Simple Alert
	 * 3. Handling Confirm Alert
	 * 4. Handling Sweet Alert
	 * 5. Handling Prompt Alert
	 * 6. Handling Alert Confirmation Alert with Delete button
	 * 7. Handling Min and Max , Close Alert
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.findElement(By.xpath("(//span[text()='Show'])[1]")).click();
		
		//Handling Simple Alert by just accepting 
		Alert alert = driver.switchTo().alert();
		//To click on ok button in the simple Alert
		Thread.sleep(2000);
		alert.accept();
		String simpleAlertTxt = driver.findElement(By.xpath("//body[@class='main-body ui-input-filled']")).getText();
		if(simpleAlertTxt.contains("successfully"))
		{
		System.out.println("Simple Alert Executed Successfully");
		
	}else
	{
		System.out.println("Simple Alert not Executed Successfully");
	}
	
	System.out.println("-----------------------------------------------");
	//Handling Confirm Alert
	driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
	String confirmAlertTxt = alert.getText();
	System.out.println("Confirm Alert text is : "+confirmAlertTxt);
	Thread.sleep(2000);
	//decline the alert by clicking cancel
	alert.dismiss();
	String confirmAlertResultTxt = driver.findElement(By.xpath("//span[@id='result']")).getText();
	if(confirmAlertResultTxt.contains("Cancel"))
			{
	           System.out.println("User Declined the Confirm Alert by Clicking Cancel ");
			}
	else
	{
		System.out.println("User Accepted the Confirm Alert by Clicking OK ");
	}
	
	System.out.println("-----------------------------------------------");
	
	//Handling Sweet Alert
	driver.findElement(By.xpath("(//span[text()='Show'])[3]")).click();
	String sweetAlertTxt = driver.findElement(By.xpath("(//p[contains(text(),'inspectable')])[1]")).getText();
	System.out.println("Sweet Alert Text : "+sweetAlertTxt);
	driver.findElement(By.xpath("//div[@class='ui-dialog-footer ui-widget-content']//button")).click();
	Thread.sleep(2000);
	
	System.out.println("-----------------------------------------------");
	//Handling Sweet Modal Dialog
	
	driver.findElement(By.xpath("(//span[text()='Show'])[4]")).click();
	String sweetAlertModalTxt = driver.findElement(By.xpath("//p[contains(text(),'Unless')]")).getText();
	System.out.println("Sweet Modal Alert Text : "+sweetAlertModalTxt);
	//To click on x button in sweet modal alert
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]/parent::a")).click();
	Thread.sleep(2000);
	System.out.println("Sweet Alert Modal window Closed");
	
	System.out.println("-----------------------------------------------");
	//Handling Prompt Alert
	
	driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
	String promptAlertTxt = alert.getText();
	System.out.println("Prompt Alert Text is "+promptAlertTxt);
	Thread.sleep(2000);
	alert.sendKeys("Arasi");
	Thread.sleep(2000);
	alert.accept();
	
	String promptTextCheck = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
	if(promptTextCheck.contains("Arasi"))
	{
		System.out.println("Prompt Text Entered successfully");
	}
	else
	{
		System.out.println("Prompt Text not entered properly");
	}
	
	System.out.println("--------------------------------------------------");
	
	//Handling Alert Confirmation Alert with Delete button
	
	driver.findElement(By.xpath("//span[text()='Delete']")).click();
	String sweetAlertDeleteTxt = driver.findElement(By.xpath("//span[@class='ui-confirm-dialog-message']")).getText();
	System.out.println("Sweet Alert Delete Msg :"+sweetAlertDeleteTxt);
	Thread.sleep(2000);
	//Clicking on No button
	driver.findElement(By.xpath("//span[text()='No']")).click();
	Thread.sleep(1000);
	
System.out.println("--------------------------------------------------");
	
	//Handling Max and Min Alert with
	driver.findElement(By.xpath("(//span[text()='Show'])[6]")).click();
	String minMaxText = driver.findElement(By.xpath("//p[contains(text(),'maximized')]")).getText();
	System.out.println("Min Max Text : "+minMaxText);
	//Clicking min button
	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']")).click();
	Thread.sleep(2000);
	//Clicking on + button to resume 
	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-plus']")).click();
	Thread.sleep(2000);
	//Clicking on Max button
	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-extlink']")).click();
	Thread.sleep(2000);
	//clicking on resume button
	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-newwin']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick']/parent::a)[3]")).click();
	Thread.sleep(1000);
	System.out.println("Min and Max Alert Closed Successfully");
	
	
	
	
	}
}


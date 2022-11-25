package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrame {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		//Identify frame using name
		//driver.switchTo().frame("iframeResult");
		//Identifying frame by Webelement
		WebElement webFrameElement = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(webFrameElement);
		//Clicking on try it button
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		//Alert open
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		String alertText = alert.getText();
		System.out.println("Alert Msg Text:"+alertText);
		alert.sendKeys("Arasi");
		Thread.sleep(2000);
		alert.accept();
		//Checking the text
		String chkText= driver.findElement(By.xpath("//p[@id='demo']")).getText();
		if(chkText.contains("Arasi"))
		{
			System.out.println("Entered Text in Alert Properly");
		}
		else
		{
			System.out.println("Not entered properly in alert");
		}
		
	}

}

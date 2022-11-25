package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testleaf.herokuapp.com/pages/Alert.html");
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		//Handling Alert
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		//to get the text in the alert
		String text = alert.getText();
		System.out.println(text);
		alert.sendKeys("TestLeaf");
		Thread.sleep(2000);
		alert.accept();
		//Checking testleaf entered txt is there or not
		String text3 = driver.findElement(By.xpath("//p[@id='result1']")).getText();
		if(text3.contains("TestLeaf"))
		{
			System.out.println("Text available");
		}
		else
		{
			System.out.println("Text not available");
		}

		 //Handling PromptAlert
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		Thread.sleep(2000);
		String text2 = alert.getText();
		System.out.println(text2);
		Thread.sleep(2000);
		alert.accept();
		
		
		
	}

}

package week5.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitLearning {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/waits.xhtml;jsessionid=node017mdpcqnd47yy1r9mjtw0ik8ka433234.node0");
		driver.findElement(By.xpath("(//span[text()='Click'])[3]")).click();
		
		//Element txt be visible after click
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement textInButton = driver.findElement(By.xpath("//span[text()='Did you notice?']"));
		wait.until(ExpectedConditions.textToBe(By.xpath("//span[text()='Did you notice?']"), "Did you notice?"));
		String textVerify = textInButton.getText();
		System.out.println("Text changed and displayed on button :"+textVerify);
		
		
		//Element to be visible after Click
		driver.findElement(By.xpath("(//span[text()='Click'])[1]")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='I am here']"))));
		System.out.println("Text Displayed after Click :"+driver.findElement(By.xpath("//span[text()='I am here']")).getText());
		
		
		//Element to be invisble after Click
		driver.findElement(By.xpath("(//span[text()='Click'])[2]")).click();
		WebElement chkInvisibleEle = driver.findElement(By.xpath("//span[text()='I am about to hide']"));
		
		wait.until(ExpectedConditions.invisibilityOf(chkInvisibleEle));	
		System.out.println("Invisble after click");
//		wait.until(ExpectedConditions.stalenessOf(chkInvisibleEle));
//		if(chkInvisibleEle.isDisplayed())
//		{
//			System.out.println("Not Success-->Element displayed even after Click");
//		}
//		else
//		{
//			
//			System.out.println("Not displayed after Click");
//		}
		
		
		
	}

}

package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizableAssignment3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/resizable/");
		
		//Switching to 1st Frame
		driver.switchTo().frame(0);
		
		//Locate the resizable element
		driver.findElement(By.id("resizable"));
		
		//Locating the resizable point
		WebElement reSize = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		
		//Creating Object for Actions Class
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(reSize, 50, 40).build().perform();
		Thread.sleep(2000);
		//driver.close();
		

	}

}

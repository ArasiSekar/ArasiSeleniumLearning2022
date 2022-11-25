package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectableAssignment3 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/selectable/");
		
		//Create obj for Actions class
		Actions builder = new Actions(driver);
		
		//Switch to Frame
		driver.switchTo().frame(0);
		
		//Locate the Elements		
		WebElement elementToSelect = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement elementToSelect2 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		
		//Click and Hold to select the Items
		builder.clickAndHold(elementToSelect).clickAndHold(elementToSelect2).click().build().perform();
		System.out.println("Items Selected");
	}
}

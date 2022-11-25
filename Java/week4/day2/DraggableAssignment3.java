package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DraggableAssignment3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/droppable/");
		
		//Switching to 1st Frame
		driver.switchTo().frame(0);
		
		//Creating obj for Actions class
		Actions builder=new Actions(driver);
		
		//Locating the draggable element
		WebElement drag = driver.findElement(By.id("draggable"));
		
		//Locating the droppable element
		WebElement drop = driver.findElement(By.id("droppable"));
		
		//Dragging to the droppable location
		builder.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(2000);
		driver.close();
		
		

	}

}

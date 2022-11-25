package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableAssignment3 {

	public static void main(String[] args) throws InterruptedException {
		
		//Sortable
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/sortable/");
		
		//Switching to Frame
		driver.switchTo().frame(0);
		
		//Locating Sortable Elements source and destination
		WebElement sourceItem = driver.findElement(By.xpath("(//ul[@id='sortable']/li/span)[1]"));
		WebElement destItem = driver.findElement(By.xpath("(//ul[@id='sortable']/li/span)[3]"));
		
		//Actions
		Actions builder=new Actions(driver);
		
		//X and Y values of destinations
		Point location=destItem.getLocation();
		int x =location.getX();
		int y= location.getY();
		System.out.println("X :"+x+" Y: "+y);
		
		//Click and hold the source then Drag and drop the source to the x and y location		
		builder.clickAndHold(sourceItem).dragAndDropBy(sourceItem, x, y).build().perform();
		Thread.sleep(2000);
		System.out.println("Item moved");
		//driver.close();
		
		

	}

}

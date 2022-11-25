package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameAssignment2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.leafground.com/frame.xhtml");
		
		//Clicking on Frame 1 
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//button[@id='Click'])[1]")).click();		
		Thread.sleep(2000);
		String frame1Txt = driver.findElement(By.xpath("//button[contains(text(),'Hurray')]")).getText();
		if(frame1Txt.contains("Hurray"))
		{
			System.out.println("Frame1  ClickMe button Clicked ");
		}
		else
		{
			System.out.println("Frame 1 ClickMe button not clicked");
		}
		
	// coming out of frame1
		driver.switchTo().defaultContent();
		
		//switching to frame3		
		driver.switchTo().frame(2);
		
		//switching to nested frame
		driver.switchTo().frame("frame2");
		
		driver.findElement(By.xpath("//button[@id='Click']")).click();
		Thread.sleep(2000);
		System.out.println("Clicked on Nested Frame Click me");
		
		//coming out of Frame3
		driver.switchTo().defaultContent();
		
		//Switching to Frame2
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//button[text()='Count Frames']")).click();
		System.out.println("Clicked Frame 2 ---Count frame button");
		//coming out of Frame2
		driver.switchTo().defaultContent();
		
		//To count the frame
		//Adding all the frames to list 
	List<WebElement> listFrameCount = driver.findElements(By.tagName("iframe"));
	
	//getting the size of the list and print the size
	int size = listFrameCount.size();
	System.out.println("Count of Frames : "+size);
	driver.close();
		
		
	}

}

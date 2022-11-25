package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowHandles {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("mobiles",Keys.ENTER);
		//driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//img[@class='s-image']")).click();
		//To get the Parent Window handle
		String windowParentHandle = driver.getWindowHandle();
		System.out.println("Parent Window Handle id: "+windowParentHandle);
		String parentWindowTitle = driver.getTitle();
		System.out.println("Parent Window Tile :"+parentWindowTitle);
		
		//To get the child Window Handle
		Set<String> windowHandles = driver.getWindowHandles();
		//To get the index value change to List
		List<String> list = new ArrayList<String>(windowHandles);
		System.out.println("The number of Window Opened:"+list.size());
		//Switch the Ctrl to new window
		driver.switchTo().window(list.get(1));
		//Verify the Window Title
		String secondWindowtitle = driver.getTitle();
		System.out.println("The second Window Title: "+secondWindowtitle);
		if(!parentWindowTitle.equals(secondWindowtitle))
		{
			System.out.println("Control switched to second window");
			
		}
		else
		{
			System.out.println("Control not switched to 2nd window");
		}
		//To click Addto cart
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		System.out.println("Clicked on the Addcart");

	}

}

package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snap {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		//2. Go to Mens Fashion
		//Mouse Hover by using moveToElement()
		WebElement mensFashion = driver.findElement(By.xpath("(//span[contains(text(),'Men')])[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(mensFashion).perform();
		System.out.println("Performed Mouse Hover on Men's Fashion");
		Thread.sleep(2000);
		//3. Go to Sports Shoes
		//Click on Sports Shoe
		driver.findElement(By.xpath("(//span[contains(text(),'Sports Shoes')])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='filter-content ']/button")).click();
        Thread.sleep(2000);
        builder.scrollToElement(driver.findElement(By.xpath("//input[@id='Color_s-Yellow']"))).build().perform();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='Color_s-Yellow']")).click();
        
        Thread.sleep(2000);
        System.out.println("Clicked on Yellow button");
        
	}

}

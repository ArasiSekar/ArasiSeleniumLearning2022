package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdvancedXpath {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Using Parent to Child xpath
		driver.findElement(By.xpath("//p[@class='top']/input")).sendKeys("Democsr2");
		
		//Using  GrandParent to GrandChild 
		driver.findElement(By.xpath("(//form[@id='login']//input)[2]")).sendKeys("crmsfa");
		
		//Using Child to Parent Xpath
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']/parent::p")).click();
		
		//Parent to Child Xpath
		driver.findElement(By.xpath("//div[@id='label']/a")).click();

		//Basic Xpath
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		
		//Basic Xpath
		driver.findElement(By.xpath("")).click();
		
		//GrandChild to GrandParent
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']/ancestor::tr")).sendKeys("TCS");

	}

}

package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrameAssignment1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		WebElement frame1Topic = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frame1Topic);
		driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("Inner Frame");
		System.out.println("Topic Entered in Frame1");
		Thread.sleep(2000);
		//Switching to Inner frame
		WebElement frame3NestedFrameChkbox = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(frame3NestedFrameChkbox);
		//Clicking the checkbox
		WebElement frame3chkboxElement = driver.findElement(By.xpath("//input[@id='a']"));
		frame3chkboxElement.click();
		if(frame3chkboxElement.isSelected())
		{
			System.out.println("Frame 1 Checkbox selected");
		}
		else
		{
			System.out.println("Frame1 Checkbox not selected ");
		}
		Thread.sleep(2000);
     //Coming out of the frame1 - Parent Frame
		driver.switchTo().defaultContent();
		
		//Handling Iframe2
		
		WebElement frame2DropdownSelection = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame2DropdownSelection);
		//Selecting the Chkbox
        WebElement animalDropdown = driver.findElement(By.xpath("//select[@id='animals']"));
        Select dd = new Select(animalDropdown);
        dd.selectByVisibleText("Big Baby Cat");
        Thread.sleep(2000);
        WebElement firstSelectedOption = dd.getFirstSelectedOption();
        String dropdownText = firstSelectedOption.getText();
        System.out.println("The Selected text in DD :"+dropdownText);
        

		

	}

}

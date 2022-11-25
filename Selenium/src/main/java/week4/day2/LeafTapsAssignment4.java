package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTapsAssignment4 {
	/*
	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		  
		  2. Enter UserName and Password Using Id Locator
		  
		  3. Click on Login Button using Class Locator
		  
		  4. Click on CRM/SFA Link
		  
		  5. Click on contacts Button
		  	
		  6. Click on Merge Contacts using Xpath Locator
		  
		  7. Click on Widget of From Contact
		  
		  8. Click on First Resulting Contact
		  
		  9. Click on Widget of To Contact
		  
		  10. Click on Second Resulting Contact
		  
		  11. Click on Merge button using Xpath Locator
		  
		  12. Accept the Alert
		  
		  13. Verify the title of the page
	 */

	public static void main(String[] args) throws InterruptedException {
		
		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps/control/login");
		  
		  //2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		  
		  //3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		  
		  //4. Click on CRM/SFA Link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		  
		  //5. Click on contacts Button
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		  	
		  //6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		  //7. Click on Widget of From Contact
		  driver.findElement(By.xpath("(//table[@id='widget_ComboBox_partyIdFrom']/following::a)[1]")).click();
		  Thread.sleep(2000);
		  //Switch to Window
		  Set<String> windowHandles = driver.getWindowHandles();
		  List<String>windowHandlesList=new ArrayList<String>(windowHandles);
		  System.out.println("No of Windows: "+windowHandlesList.size());
		  String parentWindow = driver.getWindowHandle();
		  System.out.println("The Title of Parent Window:"+driver.getTitle());
		  
		  //8. Click on First Resulting Contact
		  //Switching to window
		  driver.switchTo().window(windowHandlesList.get(1));
		  System.out.println("Current Window Title: "+driver.getTitle());
		  driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		  Thread.sleep(2000);
		  
		  
		  //9. Click on Widget of To Contact
		  driver.switchTo().window(parentWindow);
		    driver.findElement(By.xpath("(//table[@id='widget_ComboBox_partyIdFrom']/following::a)[2]")).click();
		    Thread.sleep(2000);
		  
		  //10. Click on Second Resulting Contact
		  //Switching to window
		    Set<String> windowHandles2 = driver.getWindowHandles();
			  List<String>windowHandlesList2=new ArrayList<String>(windowHandles2);
			  driver.switchTo().window(windowHandlesList2.get(1));
			  System.out.println("Current Window Title: "+driver.getTitle());
			  driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
			  Thread.sleep(2000);
			  
		  //11. Click on Merge button using Xpath Locator		  
               driver.switchTo().window(parentWindow);
			  driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
			  System.out.println("Clicked on Merge Button");
			  Thread.sleep(1000);
			  
		  //12. Accept the Alert
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      System.out.println("Alert Text :"+alertText);
		      alert.accept();
		      Thread.sleep(1000);
		      
		  //13. Verify the title of the page
		      String titlePage = driver.getTitle();
		      System.out.println("Title of the Page:"+titlePage);

	}

}

package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssignment2 {
	
	/*
	 * 1) Go to https://www.nykaa.com/
	   2) Mouseover on Brands and Search L'Oreal Paris
       3) Click L'Oreal Paris
       4) Check the title contains L'Oreal Paris(Hint-GetTitle)
       5) Click sort By and select customer top rated
       6) Click Category and click Hair->Click haircare->Shampoo
       7) Click->Concern->Color Protection
       8)check whether the Filter is applied with Shampoo
       9) Click on L'Oreal Paris Colour Protect Shampoo
      10) GO to the new window and select size as 175ml
      11) Print the MRP of the product
      12) Click on ADD to BAG
      13) Go to Shopping Bag 
      14) Print the Grand Total amount
      15) Click Proceed
      16) Click on Continue as Guest
      17) Check if this grand total is the same in step 14
      18) Close all windows
	 */

	public static void main(String[] args) throws InterruptedException {
		
		//1) Go to https://www.nykaa.com/		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.nykaa.com/");
		
		//2) Mouseover on Brands and Search L'Oreal Paris
		//Locate the Webelement
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brands).build().perform();
		WebElement brandSearch = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
		brandSearch.sendKeys("L'Oreal Paris");
		Thread.sleep(2000);
		
		//3) Click L'Oreal Paris
		driver.findElement(By.xpath("(//div[@class='css-ov2o3v']/a)[1]")).click();
		Thread.sleep(2000);
		
		//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		String titleLorealPage = driver.getTitle();
		System.out.println("Title of the Webpage :"+titleLorealPage);
		if(titleLorealPage.contains("L'Oreal Paris"))
		{
			System.out.println("We are in L'Oreal Paris Wrbpage");
		}
		else
		{
			System.out.println("we are not in L'Oreal Paris");
		}
		
		//5) Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//div[@class='control-value']/span[contains(text(),'customer')]")).click();
		Thread.sleep(2000);
		String sortTxtDisplayed = driver.findElement(By.xpath("//span[@class='sort-name']")).getText();
		if(sortTxtDisplayed.contains("Customer Top Rated"))
		{
			System.out.println("Customer Top rated selected");
		}else
		{
		System.out.println("Customer Top rated not selected");
		}
		
		//6) Click Category and click Hair->Click haircare->Shampoo
		//Clicked on Category
		Thread.sleep(2000);
		//Clicked Category
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		System.out.println("Category Clicked");
		
		WebElement hairCategoryElement = driver.findElement(By.xpath("//span[text()='Hair']"));
		builder.click(hairCategoryElement).build().perform();		
		System.out.println("Hair Clicked under Category");
		Thread.sleep(3000);
		//Click on Hair
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		System.out.println("Hair Care Clicked");
		Thread.sleep(2000);
		//Click on Shampoo
		driver.findElement(By.xpath("//span[(text()='Shampoo')]")).click();
		System.out.println("Shampoo Clicked");
		
		//7) Click->Concern->Color Protection
		//Click Concern
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		System.out.println("Clicked on the Concern");
		Thread.sleep(3000);
		//Click Color Protection
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		System.out.println("Clicked on Colcor Protection");
		//Checking whether Color protection in Filtered value
		String filteredTxtValue = driver.findElement(By.xpath("(//span[text()='Color Protection'])[1]")).getText();
		if(filteredTxtValue.contains("Color Protection"))
		{
			System.out.println("Filtered as Color Protection");
		}
		else
		{
			System.out.println("Color Protection not shown in Filter");
		}
		
		//8)check whether the Filter is applied with Shampoo
		String filteredTxtValueShampoo = driver.findElement(By.xpath("//span[text()='Shampoo']")).getText();
		if(filteredTxtValueShampoo.equals("Shampoo"))
		{
			System.out.println("Filtered as Shampoo");
		}
		else
		{
			System.out.println("Shampoo not shown in Filter");
		}
		String parentWindowHandle = driver.getWindowHandle();
		String parentWindowTitle = driver.getTitle();
		
		//9) Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
		System.out.println("Clicked on L'Oreal Paris Colour Protect Shampoo");
		
		//10) GO to the new window and select size as 175ml
		
	      Set<String> windowHandles = driver.getWindowHandles();
	      List<String> listWindowHandles =new ArrayList<String>(windowHandles);
	      System.out.println("No of Window Opened:"+listWindowHandles.size());
	      //switch to next Window
	      driver.switchTo().window(listWindowHandles.get(1));
	      //Verify the Title of the new Window
	      String titleOfNewWin= driver.getTitle();
	      if(!parentWindowTitle.equals(titleOfNewWin))
	      {
	    	  System.out.println("control switched to new Window");
	      }else
	      {
	    	  System.out.println("Stayed in the Same page");
	      }
	      
	      //Select 175ml from the Dropdown
	      WebElement dropDownElement = driver.findElement(By.xpath("//select[@class='css-2t5nwu']"));
	      Select option = new Select(dropDownElement);
	      option.selectByIndex(1);
	      Thread.sleep(2000);
	      if(dropDownElement.getText().contains("175ml"))
	      {
	    	  System.out.println("175 ml size selected");
	      }else
	      {
	    	  System.out.println("175ml size not selected");
	    	
	      }
	      
	      System.out.println("");
	     
		//11) Print the MRP of the product
	      String mrpValueOfProd = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]")).getText();
	      System.out.println("MRP Value of Product is :"+mrpValueOfProd);
	      
			//12) Click on ADD to BAG
	      driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
	      System.out.println("Added to the Bag");
	      
			//13) Go to Shopping Bag 
	      
	      driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
	      System.out.println("Clicked on the Shopping bag");
	      
		//14) Print the Grand Total amount
	    //Switch to Frame
	      driver.switchTo().frame(0);
	      String grandTotalVal = driver.findElement(By.xpath("//span[@class='css-n8gwxi e171rb9k3']")).getText();
	      System.out.println("Bag Grand Total :"+grandTotalVal);
	      
		//15) Click Proceed
	      driver.findElement(By.xpath("//div[@class='css-ltzjhp e25lf6d7']")).click();
	      Thread.sleep(2000);
	      System.out.println("Clicked Proceed button");
	      //Coming out of frame
	      driver.switchTo().parentFrame();
	      
			//16) Click on Continue as Guest
	      driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
	      System.out.println("Clicked on Contiune As Guest button");
	      driver.findElement(By.xpath("//div[@class='css-1801j3v eqr1d9n11']")).click();
	      System.out.println("Clicked on the Close buton in the New Address popup window");
			
	      //17) Check if this grand total is the same in step 14
	      String grandTotalChk = driver.findElement(By.xpath("//p[@class='css-5t7v9l eka6zu20']")).getText();
	      if(grandTotalChk.equals(grandTotalVal))
	      {
	    	  System.out.println("Bag Grand Total and Final Total values are same");
	      }
	      else
	      {
	    	  System.out.println("Bag Grand Total and Final Total values are not same");
	      }
	      
			//18) Close all windows
              driver.quit();
 
	}

}

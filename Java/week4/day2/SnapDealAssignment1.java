package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealAssignment1 {
	/*
	 * 1. Launch https://www.snapdeal.com/
       2. Go to Mens Fashion
	   3. Go to Sports Shoes
       4. Get the count of the sports shoes
       5. Click Training shoes
       6. Sort by Low to High
       7. Check if the items displayed are sorted correctly
       8.Select the price range (900-1200)
       9.Filter with color yellow 
       10 verify the all applied filters 
       11. Mouse Hover on first resulting Training shoes
       12. click QuickView button
       13. Print the cost and the discount percentage
       14. Take the snapshot of the shoes.
	 */

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//1. Launch https://www.snapdeal.com/
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
		
		//4. Get the count of the sports shoes
		//Shoes count		
		String shoesCount = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[1]")).getText();
		System.out.println("The number of Shoes Count : "+shoesCount);
		
		/*List<WebElement> shoeCountElement = driver.findElements(By.xpath("//picture[@class='picture-elem']"));
		int shoeCountSize = shoeCountElement.size();
		System.out.println("No of Shoe count from all page: "+shoeCountSize);*/
		
		//5. Click Training shoes
		//Clicking on Training Shoes
		driver.findElement(By.xpath("//div[contains(text(),'Training')]")).click();
		
		//6. Sort by Low to High
		//Sort by low to high
		//Clicking the Dropdown Arrow (not a dropdown so need to find the xpath and click on it
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
		System.out.println("Clicked on Sorted: Low to High");
		
		//7.Check if the Sorted items displayed properly
		Thread.sleep(2000);
		//Get the price value and store in arrayList
		List<WebElement> priceElement = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<Integer> priceList = new ArrayList<Integer>();
		
		for(int i=0;i<priceElement.size();i++)
		{
			String replaceAllText = priceElement.get(i).getText().replace("Rs. ", "").replaceAll(",","");
			System.out.println(replaceAllText);
			int shoePriceInt = Integer.parseInt(replaceAllText);
			priceList.add(shoePriceInt);
			
		}
		
		Collections.sort(priceList);
		System.out.println("The Sorted Price Value :"+priceList);
        //boolean sort;
		boolean sortPrice =true;
		for(int i=0;i<priceList.size()-1;i++)
		{
			
			if(priceList.get(i)<=priceList.get(i+1))
			{
			  sortPrice=true;		
				
			}else
			{
				sortPrice=false;
				break;
			}
		}
		
		if(sortPrice) {
			System.out.println("Sorted low to high");
		}
		else
		{
			System.out.println("Not Sorted low to high");
		}
		
		//8.Select the price range (900-1200)
		
		//Sending Values of 900 and 1200 in the From and To box under Price sliding bar
		WebElement priceRangeFrom = driver.findElement(By.xpath("(//input[@class='input-filter'])[1]"));
		priceRangeFrom.clear();
		priceRangeFrom.sendKeys("900");
		Thread.sleep(1000);
		WebElement priceRangeTo = driver.findElement(By.xpath("(//input[@class='input-filter'])[2]"));
		priceRangeTo.clear();
		priceRangeTo.sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(1000);
		//Adding the Displayed Shoes price to List
		List<WebElement> priceRangeElement = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<Integer> priceRangeList = new ArrayList<Integer>();
		for(int i=0;i<priceRangeElement.size();i++)
		{
			//As the Price value contains Rs , then by using the below line we are replacing it
			
			String replaceAllPriceRangeText = priceRangeElement.get(i).getText().replace("Rs. ", "").replaceAll(",","");
			//System.out.println(replaceAllPriceRangeText);
			//After replacing then changing the data type from String to Int
			 int parseIntPriceRange = Integer.parseInt(replaceAllPriceRangeText);  
			priceRangeList.add(parseIntPriceRange);
			
		}
		System.out.println("The Price Range between 900 to 1200 Shoes are: "+priceRangeList);
				
		//9.Filter with color yellow 
		//Clicking on the Yellow Filter under Color
		driver.findElement(By.xpath("//span[@class='filter-color-tile Yellow ']")).click();
		Thread.sleep(1000);
		//Verifying Yellow Shoe displayed
		String yellowShoeText = driver.findElement(By.xpath("//p[@class='product-title']")).getText();
		if(yellowShoeText.contains("Yellow"))
		{
			System.out.println("Yellow Filter Applied and Yellow shoes displayed");
		}
		else
		{
			System.out.println("Yellow Filter no Applied and Yellow shoes not displayed");
		}
		
		//10 verify the all applied filters 
		//Locate the Filtered Elements and get the Text
		     String filteredText = driver.findElement(By.xpath("//div[@class='filters']")).getText();
		     System.out.println("The Applied Filters Text are: "+filteredText);
		     //Using If-Else chk the filters are applied properly
			 if(filteredText.contains("Yellow")||filteredText.contains("900"))
			 {
				 System.out.println("Applied Filters Properly");
				 
			 }else
			 {
				 System.out.println("Filters are not applied Properly");
			 }
		 
		 
		
		//11. Mouse Hover on first resulting Training shoes
			WebElement firstTrainingShoe = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
			//using Actions moveToElement() -- mouse hover on the results 
			builder.moveToElement(firstTrainingShoe).build().perform();
			System.out.println("Mouse Hovered on the first displayed result");
			
		
		
		//12. click QuickView button
		 // While doing mousehover on the results then only Quick view will display
			//And Clicking on the QuickView button
			driver.findElement(By.xpath("//div[@class='clearfix row-disc']/div")).click();
			Thread.sleep(2000);
		
		//13. Print the cost and the discount percentage
		  String costOfShoeInQuickView = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		  System.out.println("Cost of the Shoe in Quick View : "+costOfShoeInQuickView);
		  String discountPriceInQuickView = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		  System.out.println("Discount Percentage in QuickView: "+discountPriceInQuickView);
		  
		//14. Take the snapshot of the shoes.
		   File source = driver.getScreenshotAs(OutputType.FILE);
		   File destination = new File("./snapshot/quickview.png");
		   FileUtils.copyFile(source, destination);
		   Thread.sleep(2000);
		   System.out.println("Screenshot taken successfully");
		   driver.close();
		  

	}

	
	
}

package week4day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class NykaaWebsite {
	
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.nykaa.com/");
		
		Actions action = new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"));
		action.moveToElement(brands).perform();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[text()='L']")).click();
		driver.findElement(By.xpath("//a[text()=\"L'Oréal Paris\"]")).click();
		
		String title = driver.getTitle();
		System.out.println("Title: "+title);
		if(title.contains("L'Oreal Paris")) {
			System.out.println("Title Verified.");
		}
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Colour Protection']")).click();
		String filter = driver.findElement(By.xpath("//span[text()='Shampoo']")).getText();
		System.out.println("Filter: "+filter);
		if(filter.contains("Shampoo")) {
			System.out.println("Filter is Applied with Shampoo.");
		}
		
		driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowChild = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowChild.get(1)).findElement(By.xpath("//span[text()='180ml']")).click();
        String priceMRP = driver.switchTo().window(windowChild.get(1)).findElement(By.xpath("//span[text()='₹209']")).getText();
        System.out.println("Rs: "+priceMRP);
        driver.switchTo().window(windowChild.get(1)).findElement(By.xpath("//span[text()='Add to Bag']")).click();
        
        
        driver.switchTo().window(windowChild.get(1)).findElement(By.xpath("//button[@class='css-aesrxy']")).click();
        String GrandTotal = driver.switchTo().window(windowChild.get(1)).findElement(By.xpath("//div//span[text()='₹279']")).getText();
        System.out.println("Grand Total Amount: "+GrandTotal);
        driver.switchTo().window(windowChild.get(1)).findElement(By.xpath("//span[text()='Proceed']")).click();
        driver.switchTo().window(windowChild.get(1)).findElement(By.xpath("//button[text()='Continue as guest']")).click();
        
        
        if(priceMRP != GrandTotal) {
        	System.out.println("Doesn't equal.");
        }
    	driver.switchTo().window(windowChild.get(1)).close();
    	driver.close();
    	
        
        
	}

}

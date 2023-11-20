package week4day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionClass {
	
	public static void main(String[] args) {
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus 9 Pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String price = driver.findElement(By.xpath("(//span[text()='37,999'])[1]")).getText();
		System.out.println("Price: "+price);
		
		String rating = driver.findElement(By.xpath("//span[text()='11']")).getText();
		System.out.println("Customer-Ratings: "+rating);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowChild = new ArrayList<String>(windowHandles);
		
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		driver.switchTo().window(windowChild.get(1)).findElement(By.xpath("//span[@id ='submit.add-to-cart']")).click();
		
		
		String countOfItem = driver.switchTo().window(windowChild.get(1)).findElement(By.xpath("//span[@id ='attach-accessory-cart-total-string']")).getText();
		System.out.println("Cart SubTotal: "+countOfItem);
		
		if(rating == countOfItem) {
			System.out.println("Verified...");
		}
		
		////span[@id='attach-accessory-cart-subtotal']
	}

}

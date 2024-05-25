package amazonPracticeSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BuyAProduct {
	
	///////////////////// This code works properly........////////////////////////

	@Test
	void BuyLower() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("lower");
		Thread.sleep(3000);
		List<WebElement> getLower = driver.findElements(
				By.xpath("//div[@id='nav-flyout-searchAjax']//div[@class='left-pane-results-container']/div"));

		for (WebElement ListOfLower : getLower) {

			if (ListOfLower.getText().contains("for men cotton")) {
				// hum getAttribute bhi use kr sakte the getText ki jgh but hame exact xapth
				// banana padta jha
				// attritute avaible hai..(See below example..)

				ListOfLower.click();
				break;

			}

		}
		
		// By using getAttribute method..
		
//		List<WebElement> list11=driver.findElements(By
//				.xpath("//div[@id='nav-flyout-searchAjax']//div[@class='left-pane-results-container']/div/div/div"));
//		for (WebElement list223 : list11) {
//			
//			if(list223.getAttribute("aria-label").contains("lower tshirt set for women")) {
//				
//				list223.click();
//				break;
//			}
//			
//		}
		
		///////////////////////////////// select vimal track pants..///////////////////////////

		
		driver.findElement(By.xpath("//div[@data-asin='B01BJZ2N8G']//img[@class='s-image']")).click();
		Set<String> allNewIds =driver.getWindowHandles();
		ArrayList<String> getallIdss=new ArrayList<>(allNewIds);
		String parentWind=getallIdss.get(0);
		String childWind=getallIdss.get(1);
		driver.switchTo().window(childWind);
		WebElement drop=driver.findElement(By.name("quantity"));
		Select sele=new Select(drop);
		sele.selectByValue("3");
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.xpath("(//a[normalize-space()='Go to Cart'])[2]")).click();
		String ActMsg=driver.findElement(By.xpath("//span[@class='a-truncate-cut']")).getText();
		Assert.assertEquals(ActMsg,"VIMAL JONNEY Multicolor Cotton Blend Pyjamas for Men(Pack of 2)-D10_MLG_NVY_0002-XL");
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

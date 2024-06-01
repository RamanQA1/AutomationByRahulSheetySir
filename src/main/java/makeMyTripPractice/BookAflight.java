package makeMyTripPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookAflight {
	
	@Test
	void myFlight() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("pu");
		List<WebElement> qq=driver.findElements(By.xpath("//div[@id='react-autowhatever-1']//li"));
		
		for (WebElement allAirP : qq) {
			
			if(allAirP.getText().contains("Puducherry, India")) {
				
				allAirP.click();
				break;
			}
			
		}
		
	}

}

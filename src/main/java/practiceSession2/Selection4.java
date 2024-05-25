package practiceSession2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selection4 {
	
	@Test
	void bookFlight() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.airvistara.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("button#cookieModalCloseBtn")).click();
		WebElement froms = driver.findElement(By.name("flightSearchFrom"));
		froms.click();
		froms.sendKeys("de");
		List<WebElement>allOptions =driver.findElements(By.xpath("//span[@class=\"airportName\"]"));
		
		for(WebElement option : allOptions) {
			
			if(option.getText().equalsIgnoreCase("Aberdeen International Airport")) {
				
				option.click();
				break;
			}
			}
		

		driver.findElement(By.name("flightSearchTo")).sendKeys("to");
     List<WebElement>allOptions2 =driver.findElements(By.xpath("//span[@class=\"airportName\"]"));
		
		for(WebElement optionss : allOptions2) {
			
			
			if(optionss.getText().equalsIgnoreCase("Haneda Airport")) {
				
				optionss.click();
				break;
			}
			}
		
	}

}

package practiceSession2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selection3 {

	@Test
	public void vistara() throws InterruptedException {

		// WebDriverManager.firefoxdriver().setup();
		// WebDriver driver= new FirefoxDriver();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.airvistara.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("button#cookieModalCloseBtn")).click();
		WebElement from = driver.findElement(By.name("flightSearchFrom"));
		from.click();
		from.sendKeys("del");
		WebElement airprt = driver.findElement(
				By.xpath("//li[@class=\"ui-autocomplete-category\"]/following-sibling::li[1]"));
		String airportName=airprt.getText();
		System.out.println(airportName);
		airprt.click();
		Thread.sleep(1000);
	
		driver.findElement(By.name("flightSearchTo")).sendKeys("mum");
		driver.findElement(
				By.xpath("//span[@class=\"airportName\"][normalize-space()=\"Chhatrapati Shivaji International Airport\"]")).click();
		

		
	}

}

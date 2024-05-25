package practiceSession2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selection2 {
	
	@Test
	public void goibioo() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[@aria-hidden=\"true\"]")).click();
		Thread.sleep(3000);
		WebElement origin=driver.findElement(By.xpath("//p[@class=\"sc-12foipm-20 bhnHeQ\"][normalize-space()=\"Enter city or airport\"]"));
		origin.click();
		Thread.sleep(2000);
		origin.sendKeys("mumbai");
	}

}

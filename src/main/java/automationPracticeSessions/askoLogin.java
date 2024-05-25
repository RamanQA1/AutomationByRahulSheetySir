package automationPracticeSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class askoLogin {
	
	@Test
	void loginInWeb() {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://askomdch.com/");
		driver.findElement(By.xpath("//li[@id=\"menu-item-1237\"]//a[text()=\"Account\"]")).click();
		driver.findElement(By.cssSelector("input#username")).sendKeys("Raman");
		driver.findElement(By.cssSelector("input#password")).sendKeys("raman123");
		driver.findElement(By.cssSelector("button[value=\"Log in\"]")).click();
		boolean dp=driver.findElement(By.xpath("//p[contains(text(),\"Hello\")]")).isDisplayed();
		Assert.assertEquals(dp,true);
		String getMsg=driver.findElement(By.xpath("//div[@class=\"woocommerce-MyAccount-content\"]/p")).getText();
		System.out.println(getMsg);
		Assert.assertEquals(getMsg,"Hello Raman (not Raman? Log out)");
		driver.findElement(By.linkText("Logout")).click();
	}

}

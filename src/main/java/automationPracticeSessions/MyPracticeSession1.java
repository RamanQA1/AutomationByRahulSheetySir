package automationPracticeSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyPracticeSession1 {

	@Test
	void mySessionClass() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://askomdch.com/");
		driver.findElement(By.xpath("//li[@id=\"menu-item-1237\"]//a[text()=\"Account\"]")).click();
		driver.findElement(By.cssSelector("input#username")).sendKeys("raman@gmail.com");
		driver.findElement(By.cssSelector("input#password")).sendKeys("1234567ra");
		driver.findElement(By.cssSelector("button[value=\"Log in\"]")).click();

		System.out.println("Error Message : " + driver.findElement(By.cssSelector("ul.woocommerce-error")).getText());

		boolean MSG = driver.findElement(By.cssSelector("ul.woocommerce-error")).isDisplayed();
		Assert.assertEquals(MSG, true);
		driver.findElement(By.linkText("Lost your password?")).click();
		driver.findElement(By.xpath("//input[@id=\"user_login\"]")).sendKeys("raman13@gmail.com");
		driver.close();

	}

}

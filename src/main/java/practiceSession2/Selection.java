package practiceSession2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import greenKart.AddToCartVeggies;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Selection {

	WebDriver driver = null;

	@Test
	public void testSelectOption() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/Shivam/OneDrive/Documents/SelectSite.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement ele = driver.findElement(By.id("pet-select"));

		Select sel = new Select(ele);

		sel.selectByVisibleText("Cat");
		System.out.println(sel.getFirstSelectedOption().getText());

	}
}

package practiceSession2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SumOfTableInteger {
	
	///////////////////////// In this class we sum all the integer values of the table../////////////////////// 

	@Test
	void summ1() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> values = driver.findElements(By.xpath("(//table[@id='product'])[2]//tbody/tr/td[4]"));
		int sum = 0;
		
		///////////////// by using for each loop..////////////

//		for (WebElement eachValues : values) {
//
//			System.out.println(eachValues.getText());
//			sum = sum + Integer.parseInt(eachValues.getText());
//
//		}
//		System.out.println(sum);
		
		
		
		///////////////// by using for loop../////////////////
		
		for (int i = 0; i < values.size(); i++) {
			
			System.out.println(values.get(i).getText());
			sum=sum+Integer.parseInt(values.get(i).getText());
			
		}
		
		System.out.println(sum);
		
		// we assert our sum equals to total sum..
		// capture text and split to get only total amount..
		
		String amt[]=driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":");
		// trim white space in amont value and convert string to Integer...
		int realAmt=Integer.parseInt(amt[1].trim());
		
		Assert.assertEquals(sum,realAmt);

	}

}

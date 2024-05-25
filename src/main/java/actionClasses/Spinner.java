package actionClasses;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Spinner {
	
	@Test
	void makeSpinner()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://jqueryui.com/spinner/");

		driver.switchTo().frame(0);
		
		// we want to select a value for 5 times so we implementing while loop..for clicking 5 times..
		/*
		 * int i=1;
		 * 
		 * while( i<6) {
		 * driver.findElement(By.xpath("//a[@tabindex=\"-1\"][1]")).click(); i++; }
		 */
		
		// we want to select a value for 5 times so we implementing For loop..for clicking 5 times..
		
		for (int i = 1; i < 6; i++) {
			
			  driver.findElement(By.xpath("//a[@tabindex=\"-1\"][1]")).click();
			  }
		
		System.out.println(driver.findElement(By.xpath("//input[@id='spinner']")).getText());
		
	}
}

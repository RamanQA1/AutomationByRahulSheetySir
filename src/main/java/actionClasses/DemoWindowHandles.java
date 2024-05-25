package actionClasses;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoWindowHandles {
	
	@Test
	void dualWindows() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> allWindowsIdss=driver.getWindowHandles();
		
		ArrayList<String> windowList=new ArrayList<>(allWindowsIdss);
		
		String parentWin=windowList.get(0);
		String childWin=windowList.get(1);
		
		driver.switchTo().window(childWin);
		System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText());
		//System.out.println(driver.findElement(By.linkText("mentor@rahulshettyacademy.com")).getText());// also works
		// second way to extract email address from text.
		
		String divv[]=driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at");
		String[] divv2=divv[1].trim().split("with");
		System.out.println(divv2[0]);
		
		driver.switchTo().window(parentWin);
		driver.findElement(By.cssSelector("input#username")).sendKeys(divv2[0]);
		
		driver.findElement(By.id("password")).sendKeys("learning");
		WebElement drop=driver.findElement(By.cssSelector("select.form-control"));
		
		Select  selection = new Select(drop);
		selection.selectByValue("teach");
		
	}
	

}

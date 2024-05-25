package practiceSession2;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selection5 {

	@Test
	void trainBooking() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

		driver.get("https://erail.in/");
		driver.findElement(By.id("txtStationFrom")).click();
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).sendKeys("de");
		System.out.println("raman loop");
		List<WebElement> allLocations = driver.findElements(By.xpath("//div[contains(@id,\"Autocomplete_1714\")]/div"));
		System.out.println("allElements :" + allLocations.size());
		for (WebElement Elementss : allLocations) {
//			String attri=Elementss.getAttribute("title");
//			System.out.println(attri);
			if (Elementss.getAttribute("title").equalsIgnoreCase("Debipur")) {
			

				Elementss.click();
				break;
			}

		}

		WebElement toStation = driver.findElement(By.cssSelector("input#txtStationTo"));
		toStation.click();
		toStation.clear();
		toStation.sendKeys("mum");

		List<WebElement> allLocations2 = driver.findElements(By.xpath("(//div[@class='autocomplete'])[2]/div"));
		for (WebElement Elementss2 : allLocations2) {

			if (Elementss2.getAttribute("title").contains("Navi-Mumbai")) {

				Elementss2.click();
				break;
				

			}

		}
		
		driver.findElement(By.xpath("//input[@title='Select Departure date for availability']")).click();
		driver.findElement(By.xpath("(//table[@class='Month'])[2]//tr[8]/td[2]")).click();

		WebElement category = driver.findElement(By.cssSelector("select#cmbQuota"));
		Select sel = new Select(category);
		sel.selectByValue("DF");

		WebElement category2 = driver.findElement(By.cssSelector("select#selectClassFilter"));
		Select sel2 = new Select(category2);
		sel2.selectByValue("3");

		driver.findElement(By.id("chkSelectFromOnly")).click();
		System.out.println(driver.findElement(By.id("chkSelectFromOnly")).isSelected());// tells chechbox is selected or
																						// not and return true is
																						// selected..
		
		Assert.assertTrue(driver.findElement(By.id("chkSelectFromOnly")).isSelected());// This method accept only true Value..
		
		
		// Count the total number of checkbox present in the home page...
		// we see that (type=checkbox) is common for all the checkboxs....
		
		//Both Code Works for no of checkbox...
		
//		int checkSize=driver.findElements(By.xpath("//input[@type='checkbox']")).size();
//		System.out.println("Total number of checkbox :" +checkSize);
//		
		List<WebElement> totalNo=driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("Total number of checkbox :" +totalNo.size());
		
		driver.findElement(By.xpath("(//input[@title='Select Departure date for availability'])")).click();
		driver.findElement(By.xpath("(//table[@class='Month'])[2]//tr[6]/td[3]")).click();

	}

}

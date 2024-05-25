package practiceSession2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeCalender {

	// This code works fines and see how calender works..

	@Test
	public void easeMyTrips() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.easemytrip.com/");
		
		                         ///////////// From Location ///////// 
		
		driver.findElement(By.id("frmcity")).click();
		driver.findElement(By.id("a_FromSector_show")).sendKeys("del");
		Thread.sleep(3000);
		List<WebElement> allFromCity=driver.findElements(By.xpath("//div[@id='fromautoFill']//li")); // both xpath works  == //div[@id='fromautoFill']//li//p
		
		for (WebElement getAllCities : allFromCity) {
			
			System.out.println(getAllCities.getText());
			
			if(getAllCities.getText().contains("Del Rio(DLF)")) {
				
				getAllCities.click();
				break;
				
			}
			
		}
		
		
		                              ///////// To Location ////////// 
		
		driver.findElement(By.id("a_Editbox13_show")).sendKeys("kol");
		Thread.sleep(3000);
		List<WebElement> allToLocation=driver.findElements(By.xpath("//div[@id='toautoFill']//li"));
		
		for (WebElement getTotalCities : allToLocation) {
			
			if(getTotalCities.getText().contains("Kolkata(CCU)")) {
				
				getTotalCities.click();
				break;
			}
			
		}
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		

		                          /////// Departure Date///////////

		// we capture all the dates in web elements..
		// we also use for each loop instead of for loop...
		// In this method we only select date not select month and year
//		driver.findElement(By.id("ddate")).click();
//		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='box']//li"));
//
//		int sizees = dates.size();
//
//		for (int i = 0; i < sizees; i++) {
//
//			String text = dates.get(i).getText();
//
//			if (text.contains("26")) { // use contains instead of equalIgnore case
//
//				dates.get(i).click();
//				break;
//
//			}
//
//		}
		
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		                        /////// Departure Date///////////
		
		// In this method we select date, month,year..
		
	//	driver.findElement(By.id("ddate")).click();  // we are not clicking on input date box becos it automatiaclly clicking after select to location..
		
		while(true) {
			
			String firstMonthYear =driver.findElement(By.xpath("(//div[@class='month2'])[2]")).getText();
			
			if(firstMonthYear.equalsIgnoreCase("Aug 2024")) {
				
				break;
			}
			
			else {
				
				driver.findElement(By.id("img2Nex")).click();
			}
		}
		
		driver.findElement(By.id("trd_4_15/08/2024")).click();
		
///////////////////////////////////////////////////////////////////////////////////////////////////////
		                        //////// Return Date///////
		// In this method we only select date not select month and year
		// we capture all the dates in web elements..
		// we also use for each loop...
//		driver.findElement(By.id("divRtnCal")).click();
//		List<WebElement> returndates =driver.findElements(By.xpath("//div[@class='box1']//li"));
//		for (WebElement allDatess : returndates) {
//			
//			if(allDatess.getText().contains("5")) {
//				
//				allDatess.click();
//				break;
//			}
//			
//		}
//////////////////////////////////////////////////////////////////////////////////////////////////
////////Return Date///////
		// In this method we select date, month,year..
		// this method is goodd in comparision of upper methods..

		// Another example of return date in this example we select jan 2025 and date..

		driver.findElement(By.id("divRtnCal")).click();

		while (true) {

			String monthYear = driver.findElement(By.xpath("(//div[@class='month2'])[2]")).getText();

			if (monthYear.equalsIgnoreCase("Jan 2025")) {

				break;

			}

			else {
				driver.findElement(By.xpath("//img[@id='img2Nex']")).click();

			}
			
			

		}
		driver.findElement(By.xpath("//li[@id='fiv_0_26/01/2025']")).click(); // we select date normally..

	}

}

package greenKart;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCartVeggies {

	@Test
	public void addVegetables() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		// we want to add cucumber to the cart. but we can not do by locating the xpath
		// of cucumber.
		// so we fetch all the products and store in list of web element.and by looping
		// we fetch the cucumber.
		// NOTE: it is different concept if we compares to selection5 (Erail project)
		// class..

		List<WebElement> allProducts = driver.findElements(By.cssSelector("h4.product-name"));
///////////////////////////////////////////////////////////////////////////////////////////////////
		// This method not work...

		/*
		 * for (WebElement getAllProducts : allProducts) {
		 * 
		 * String namess=getAllProducts.getText(); System.out.println(namess);
		 * 
		 * if(namess.equalsIgnoreCase("Cucumber - 1 Kg")) {
		 * 
		 * driver.findElement(By.xpath("//button[normalize-space()='ADD TO CART']")).
		 * click(); break;
		 * 
		 * 
		 * }
		 * 
		 * }
		 */
		/////////////////////////////////////////////////////////////////////////////////////////

		// This code is working...

		/*
		 * for (int i = 0; i < allProducts.size(); i++) {
		 * 
		 * String allName =allProducts.get(i).getText();
		 * 
		 * if(allName.contains("Cucumber")) {
		 * 
		 * driver.findElements(By.xpath("//button[normalize-space()='ADD TO CART']")).
		 * get(i).click(); break; }
		 * 
		 * }
		 */

		///////////////////////////////////////////////////////////////////////////////////////////

		// if you want to add 2 or more vegetables to the cart at the same time..
		// so, first we need to create a String type array.
		// then converts array to the array list . becose array list have contains
		// method..
		// Note: WE need to trim vegetable name from cucumber - 1kg to only Cucumber...
		// by using split method..
		// becos in string array we only pass vegetables name.. we we need to split
		// vegetable name..
		// Note : we can not use break Statement concept in if block.. becos when the
		// code find 1st element(tomato) it will comes
		// outside the loop. they dont go others elements..so we dont use break
		// statement..
		// but the for loop run unnecessary after the find all the 3 elements.. so we
		// use again if block for avoid unnecessary run for loop.
		
		// Imp Note:= code is working fine but it selected capsicum insteed of tomato becos we use xpath based on text
		// (Add to cart) so it is dynamic text when it click the add to cart button the text changed to added so 
		// by looping concept selenium is conduse because of index value changed of add to cart button..
		// so changed the xpath of add to cart button.

		int j = 0;
		String itemNeeded[] = { "Tomato", "Cucumber", "Beans" };

		for (int i = 0; i < allProducts.size(); i++) {

			// String allName =allProducts.get(i).getText();// we use this when we not need
			// to split item names..
			System.out.println("All Vegetables Names : " +allProducts.get(i).getText()); 

			String[] allName = allProducts.get(i).getText().split("-");
			String formattedName = allName[0].trim();// we use trim becos vegetable name contains white spaces.

			List itemNeededList = Arrays.asList(itemNeeded);

			if (itemNeededList.contains(formattedName)) {

				j++;

				//driver.findElements(By.xpath("//button[normalize-space()='ADD TO CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

			}

			if (j == itemNeeded.length) {

				break;
			}

		}
		
		driver.findElement(By.cssSelector("a.cart-icon img")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		String promoAppliedInfo=driver.findElement(By.cssSelector("span.promoInfo")).getText();
		Assert.assertEquals(promoAppliedInfo,"Code applied ..!" );

	}

}

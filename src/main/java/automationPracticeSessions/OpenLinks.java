package automationPracticeSessions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLinks {

	@Test
	public void openlinksInDifferentTabs() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://askomdch.com/");

		// count the links present in the footer section

		// first we inspect the footer section and store in the webElement..

		WebElement footerSection = driver.findElement(By.cssSelector("footer#colophon"));

		System.out.println(footerSection.findElements(By.tagName("a")).size());

		// and open links of 2nd section of footer links..
		// clicking on each link

		WebElement columnSecond = footerSection.findElement(By.cssSelector("section#nav_menu-8"));

		for (int i = 1; i < columnSecond.findElements(By.tagName("a")).size(); i++) {

			String clickOnLinkTabs = Keys.chord(Keys.CONTROL, Keys.ENTER); // it will open the new window tabs for each
																			// link..

			columnSecond.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTabs);

		}

		// Get the title of the each and every tabs of the links..

		Set<String> allLinksId = driver.getWindowHandles();
		Iterator<String> it = allLinksId.iterator(); // Itreator helps to move one window to another window..
		
		while(it.hasNext()) {
			
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}

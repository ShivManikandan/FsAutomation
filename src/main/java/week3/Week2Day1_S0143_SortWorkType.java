package week3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2Day1_S0143_SortWorkType {
	static List<String> expecteddesc = new ArrayList<String>();
	static List<String> actualdesc = new ArrayList<String>();
	static int totalNumberofRows;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Login to the salesforce app
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();

		// click on toggle menu
		driver.findElement(By.className("slds-icon-waffle")).click();

		// click on viewall and select sales from the search launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath(" //input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		driver.findElement(
				By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']"))
		.click();

		// click Dashboard tab using the js executor
		WebElement Dashboardstab = driver.findElement(By.xpath("//a[@title='Dashboards']/span[text()='Dashboards']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Dashboardstab);
		/*
		 * WebElement scrollbar =
		 * driver.findElement(By.xpath("//div[@class='slds-scrollable_y']"));
		 * js.executeScript("window.scrollBy(300,300)",""); scrollbar.click();
		 */

		// Get the total row counts of the dashboard
		WebElement totalNumberofItems = driver.findElement(By.xpath("//div[@class='test-listViewStatusInfo']/span"));
		wait.until(ExpectedConditions.textToBePresentInElement(totalNumberofItems, "item"));
		int totalNumberofRows = Integer.parseInt(totalNumberofItems.getText().split(" ")[0]);
		for (int i = 1; i <= totalNumberofRows; i++) {
			// store the total row desc in the webelement and sort it out by the default
			// java collection.
			WebElement itemDescription = driver
					.findElement(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr[" + i + "]/th//a"));
			js.executeScript("arguments[0].scrollIntoView();", itemDescription);
			expecteddesc.add(itemDescription.getText().trim());
			System.out.println(expecteddesc);
		}
		Collections.sort(expecteddesc, String.CASE_INSENSITIVE_ORDER);

		// click the description name
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@title='Dashboard Name']")));
		/* driver.findElement(By.xpath("//span[@title='Dashboard Name']")).click() */;

		totalNumberofRows = Integer.parseInt(
				driver.findElement(By.xpath("//div[@class='test-listViewStatusInfo']/span")).getText().split(" ")[0]);
		for (int i = 1; i <= totalNumberofRows; i++) {
			WebElement rowitemDescription = driver
					.findElement(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr[" + i + "]/th//a"));
			js.executeScript("arguments[0].scrollIntoView();", rowitemDescription);
			actualdesc.add(rowitemDescription.getText().trim());
		}

		System.out.println(expecteddesc.equals(actualdesc));

		if (actualdesc.equals(expecteddesc)) {
			System.out.println("Dashboard Name is Sorted : Passed");
		} else {
			driver.quit();
			System.out.println("Dashboard Name is Not sorted ");
			Assert.fail();
		}

	}

}
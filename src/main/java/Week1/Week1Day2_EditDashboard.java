package Week1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week1Day2_EditDashboard {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		// Handle Notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

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

		// click Search recent dashboard
		driver.findElement(By.xpath("//span[@title='Created On']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']"))
		.sendKeys("Automation by Manikandan", Keys.ENTER);

		// select the value in the search box
		// driver.findElement(By.xpath("//a[@title='Salesforce Automation by
		// Manikandan']"));

		// click edit from drop down
		driver.findElement(By.xpath(
				"//table[contains(@class,'slds-table slds-table_header-fixed slds-table_bordered slds-table_edit slds-table_resizable-cols')]/tbody/tr[1]/th//a[contains(@title,'Salesforce Automation by Manikandan')]"));
		driver.findElement(By.xpath(
				"//table[contains(@class,'slds-table slds-table_header-fixed slds-table_bordered slds-table_edit slds-table_resizable-cols')]/tbody/tr[1]/td[6]//button"))
		.click();
		driver.findElement(By.xpath("//a[@role='menuitem']/span[text()='Edit']")).click();

		// Edit Dashboard properties

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']")).click();

		// 8. Enter Description as 'SalesForce' and click on save.

		driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).clear();
		driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("SalesForce");
		Thread.sleep(1000);
		driver.findElement(By.id("submitBtn")).click();

		// 9. Click on Done and Click on save in the popup window displayed.
		// driver.findElement(By.xpath("//div[@class='actionRibbon']//button")).click();
		driver.findElement(By.xpath("//div[@class='actionRibbon']/following::button")).click();

		// click save button banner
		driver.findElement(By.xpath("//div[contains(@class,'saveModal')]/footer/button[text()='Save']")).click();

		driver.switchTo().defaultContent();

		// 10. Verify the Description.
		String description = "SalesForce";
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		String actualText = driver.findElement(By.xpath("//p[@class='slds-page-header__info']")).getText();
		System.out.println(actualText);
		Assert.assertEquals(actualText, description);
		driver.switchTo().defaultContent();

		// Close the driver
		driver.quit();

	}
}

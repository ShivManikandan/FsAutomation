package Week1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week1Day2_CreateDashboard {

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

		// click the newdashboard
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();

		// Enter the dashboard name
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		driver.findElement(By.id("dashboardNameInput")).sendKeys("Salesforce Automation by Manis245");

		// click save button
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// click Dashboard tab using the js executor

		WebElement ViewDashboardstab = driver
				.findElement(By.xpath("//a[@title='Dashboards']/span[text()='Dashboards']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ViewDashboardstab);

		// click the Dashboardmenu to view the saved Dashboard
		// driver.findElement(By.id("dashboardNameInput")).click();

		WebElement textInput = driver.findElement(By.xpath("//*[text()='Salesforce Automation by Manis245']"));

		if (textInput.isDisplayed()) {
			System.out.println("Element found using text");
		}

		else
			System.out.println("Element not found");

	}

}

package week3;

import java.io.IOException;
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


public class Week3Day1_Assesment {

	static int closedValue;
	static int openValue;
	static WebElement dashboardbutton;
	static JavascriptExecutor js;
	 
	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		js = (JavascriptExecutor) driver;
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
		driver.findElement(By.xpath(" //input[@placeholder='Search apps or items...']")).sendKeys("Service Console");
		driver.findElement(
				By.xpath("//mark[text()='Service Console']/ancestor::div[contains(@class,'slds-app-launcher')]"))
				.click();
		List<WebElement> listItem = driver.findElements(By.xpath("//ul[contains(@class,'tabBarItems slds-grid') and @role='presentation']/li[contains(@class,'oneConsoleTabItem')]//button[contains(@title,'Close')]"));
		System.out.println(listItem.size());
		if(listItem.size()>0) {
			for (WebElement item : listItem) {
				item.click();	
			}
		}
	
			
		driver.findElement(By.xpath("//div/button[@title='Show Navigation Menu']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Home']")).click();
		Thread.sleep(2000);
		
		
	
		
		// Converting the Int to String
		closedValue = Integer.parseInt(
				driver.findElement(By.xpath("//span[@class='metricLabel' and text()='Closed']/following-sibling::span"))
						.getText().split("\\$")[1]);
		System.out.println(closedValue);
		openValue = Integer.parseInt(driver
				.findElement(
						By.xpath("//span[@class='metricLabel' and contains(text(),'Open')]/following-sibling::span"))
				.getText().split("\\$")[1]);
		System.out.println(openValue);

		if ((closedValue + openValue) < 10000) {

			driver.findElement(By.xpath("//button[@title='Edit Goal']")).click();
			driver.findElement(By.xpath("//span[@id='currencyCode']/following-sibling::input")).clear();
			driver.findElement(By.xpath("//span[@id='currencyCode']/following-sibling::input")).sendKeys("10000");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Save']")).click();
			
			// WebElement ele =
			// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class,'label
			// bBody') and text()='Save']")));
			// ele.click();
			// driver.findElement(By.xpath("//span[contains(@class,'label bBody') and
			// text()='Save']")).click();
		}

		// click dashboard
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		dashboardbutton= driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Dashboards']"));
		js.executeScript("arguments[0].scrollIntoView();", dashboardbutton);
		js.executeScript("arguments[0].click();", dashboardbutton);
		
		

		driver.findElement(By.xpath("//a[@title='New Dashboard']/div")).click();

		// Enter dashboard details
		Thread.sleep(1000);

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("Manikandan_Workout");
		driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("Testing");
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		Thread.sleep(3000);

		// click done
		//driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Done']")));
		driver.findElement(By.xpath("//button[text()='Done']")).click();

		
		// Verify the Dash board is Created
		String actualText = driver.findElement(By.xpath("//span[@class='slds-page-header__title slds-truncate']"))
				.getText();
		String expectedTxt = "Manikandan_Workout";
		if (actualText.contains(expectedTxt)) {
			System.out.println("Dashboard is created successfully");
		} else {
			System.out.println("Dashboard is not created");
		}

		// click Subscribe
		driver.findElement(By.xpath("//button[text()='Subscribe']")).click();
		
	}

	

}

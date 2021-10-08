package week2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2Day2_S0164_Delete_Worktype {
	static String workTypeName;

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.xpath(" //input[@placeholder='Search apps or items...']")).sendKeys("Work Types");
		driver.findElement(By.xpath("//mark[text()='Work Types']")).click();

		// Select Edit button
		/*
		 * driver.findElement(By.xpath(
		 * "//table[contains(@class,'slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable')]/tbody/tr[1]/th//a[contains(@title,'new')]"
		 * ));
		 */
		/*
		 * driver.findElement(By.xpath(
		 * "//table[contains(@class,'slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable')]/tbody/tr[1]/td[6]//button"
		 * )) .click();
		 */
		driver.findElement(By.xpath("//table/tbody/tr[1]/td")).getSize();
		workTypeName=driver.findElement(By.xpath("//table/tbody/tr[1]/th//a")).getText();
		System.out.println(workTypeName);
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();


		// click Delete
		driver.findElement(By.xpath("//following-sibling::button[@title='Delete']")).click();
		
		// verify TimeFrame End success message
		//verify success message
				String finalMessage="Automation";
				String strValue = driver.findElement(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Work Type')]")).getText();
				System.out.println(strValue);
				Assert.assertEquals(strValue,"Work Type \""+finalMessage+"\" was deleted. Undo");
				
		driver.quit();

	}

}

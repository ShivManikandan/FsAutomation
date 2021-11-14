package testNG;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2Day2_S0162_Edit_Worktype extends LoginBaseClass {
	static String workTypeName;

	@BeforeClass(alwaysRun = true)
	public void readData() {

		fileName = "TestData";
		sheetName = "EditNewWorkType";
	}

	@Test(dataProvider = "fetchdata",dependsOnMethods="testNG.Week2Day2_CreateNewWorkType.CreateNewWorkType",priority=2,groups= {"functional"},retryAnalyzer=RetryFailedTestCase.class)
	public void EditWorkType(String timeFrameEnd, String timeFrameStart) throws InterruptedException {
		// click on toggle menu
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// click on viewall and select sales from the search launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		// click worktypes
		driver.findElement(By.xpath(" //input[@placeholder='Search apps or items...']")).sendKeys("Work Types");
		driver.findElement(By.xpath("//mark[text()='Work Types']")).click();

	
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
		// Select Edit button
		driver.findElement(By.xpath("//table/tbody/tr[1]/td")).getSize();
		workTypeName = driver.findElement(By.xpath("//table/tbody/tr[1]/th//a")).getText();
		System.out.println(workTypeName);
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();

		// change the Start time frame

		driver.findElement(By.xpath(
				"//span[text()='Timeframe Start']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"))
				.clear();
		driver.findElement(By.xpath(
				"//span[text()='Timeframe Start']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"))
				.sendKeys(timeFrameStart);

		// Change the End Time Frame
		driver.findElement(By.xpath(
				"//span[text()='Timeframe End']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"))
				.clear();
		driver.findElement(By.xpath(
				"//span[text()='Timeframe End']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"))
				.sendKeys(timeFrameEnd);

		// click save
		driver.findElement(By.xpath("//following-sibling::button[@title='Save']")).click();

		// verify success message

		wait.until(ExpectedConditions
				.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"), workTypeName));
		String strValue = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(strValue);
		Assert.assertEquals(strValue, "Work Type \"" + workTypeName + "\" was saved.");

	}

}

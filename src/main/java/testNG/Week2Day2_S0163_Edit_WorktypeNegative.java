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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2Day2_S0163_Edit_WorktypeNegative extends LoginBaseClass {
	static String workTypeName;
	
	@BeforeClass(alwaysRun = true)
	public void readData() {

		fileName = "TestData";
		sheetName = "EditWorkTypeNegative";
	}
	
	@Test(dataProvider="fetchdata",groups= {"regression"},retryAnalyzer=RetryFailedTestCase.class)
	public  void EditWorkTypeNegative(String timeFrameEnd,String timeFrameStart)  throws InterruptedException {
	
		// click on toggle menu
		driver.findElement(By.className("slds-icon-waffle")).click();

		// click on Viewall and select sales from the search launcher
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

		
		/*
		 * wait.until(ExpectedConditions .textToBePresentInElementLocated(By.xpath(
		 * "//span[contains(@class,'toastMessage')]"), workTypeName));
		 */
		// verify TimeFrame Start success message
		String timeFrameStartMessage = driver.findElement(By.xpath("//span[text()='Timeframe Start']/ancestor::div[contains(@class,'uiInputNumber')]/following-sibling::ul[contains(@class,'has-error')]/li")).getText();
		System.out.println(timeFrameStartMessage);
		Assert.assertEquals(timeFrameStartMessage, "Enter a Timeframe End number that is greater than the Timeframe Start number.: Timeframe Start");


		// verify TimeFrame End success message
		String timeFrameEndMessage = driver.findElement(By.xpath("//span[text()='Timeframe End']/ancestor::div[contains(@class,'uiInputNumber')]/following-sibling::ul[contains(@class,'has-error')]/li")).getText();
		System.out.println(timeFrameEndMessage);
		Assert.assertEquals(timeFrameEndMessage, "Enter a Timeframe End number that is greater than the Timeframe Start number.: Timeframe End");

		
	}

}

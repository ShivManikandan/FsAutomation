package testNG;

import java.time.Duration;
import java.util.NoSuchElementException;

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

public class Week2Day2_S0164_Delete_Worktype extends LoginBaseClass{
	static String workTypeName;
	@BeforeClass(alwaysRun = true)
	public void readData() {

		fileName = "TestData";
		sheetName = "EditWorkTypeNegative";
	}
	
	@Test(groups= {"smoke","functional"},retryAnalyzer=RetryFailedTestCase.class)

	public  void DeleteWorkType()  throws InterruptedException  {
		
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
				String finalMessage="Salesforce Project";
				String strValue = driver.findElement(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Work Type')]")).getText();
				System.out.println(strValue);
				Assert.assertEquals(strValue,"Work Type \""+finalMessage+"\" was deleted. Undo");
				
		
	}

}

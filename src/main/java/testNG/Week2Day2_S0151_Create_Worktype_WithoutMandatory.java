package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2Day2_S0151_Create_Worktype_WithoutMandatory extends LoginBaseClass{

	@Test
	public  void CreateWorkType() throws InterruptedException {
		
		
		// click on toggle menu
		driver.findElement(By.className("slds-icon-waffle")).click();

		// click on viewall and select sales from the search launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath(" //input[@placeholder='Search apps or items...']")).sendKeys("Work Type Groups");
		driver.findElement(By.xpath("//mark[text()='Work Type Groups']")).click();

		// click WorkTypeGroup tab 
		driver.findElement(By.xpath(
				"//a[@title='Work Type Groups']//following-sibling::one-app-nav-bar-item-dropdown"))
				.click();

		// Click New Work Type group
		WebElement WorkTypeGroup = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", WorkTypeGroup);

		// Create new workgroup
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='Work Type Group Name']/parent::label/following-sibling::input")).sendKeys("Automation");
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[@title='Capacity']")).click();
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		Thread.sleep(1000);
		
		//verify success message
		String finalMessage="Automation";
		String strValue = driver.findElement(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Work Type')]")).getText();
		System.out.println(strValue);
		Assert.assertEquals(strValue,"Work Type Group \""+finalMessage+"\" was created.");
		
	}

}

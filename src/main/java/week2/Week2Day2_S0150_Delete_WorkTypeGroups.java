package week2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2Day2_S0150_Delete_WorkTypeGroups {
	static String workTypeName;
	static String workTypeGroupName="Salesforce Automation Manikandan";
	static int dropdownColumn;
	static String finalMessage;
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
		driver.findElement(By.xpath(" //input[@placeholder='Search apps or items...']")).sendKeys("Work Type Groups");
		driver.findElement(By.xpath("//mark[text()='Work Type Groups']")).click();

		WebElement enterGroupName=driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
		enterGroupName.sendKeys(workTypeGroupName,Keys.ENTER);
		
		dropdownColumn= driver.findElements(By.xpath("//table/tbody/tr[1]/td")).size();
		workTypeName=driver.findElement(By.xpath("//table/tbody/tr[1]/th//a")).getText();
		System.out.println(workTypeName);
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).click();
		
		// click Delete
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//following-sibling::button[@title='Delete']")).click();
		
		
		
		
		 // verify TimeFrame End success message //verify success message String
		  finalMessage="Salesforce Automation by Manikandan"; 
		  String strValue = driver.findElement(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Work Type Group')]")).getText();
		  System.out.println(strValue);
		  Assert.assertEquals(strValue,"Work Type Group \""+finalMessage+"\" was deleted. Undo");
		  
		  driver.quit();
		 
	}

}

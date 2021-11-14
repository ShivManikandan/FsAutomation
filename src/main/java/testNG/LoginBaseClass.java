package testNG;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginBaseClass {
	public String fileName;
	public String sheetName;
	ChromeDriver driver;
	public WebDriverWait wait;

	@Parameters({ "url", "username", "password" })
	@BeforeMethod(alwaysRun = true)
	public void BeforeClassSetUp(String url, String username, String password) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);

		// Create JavascriptExecutor instance and assign driver object
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Wait Setup

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.navigate().to(url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();

	}

	@AfterMethod(alwaysRun = true)
	public void closeApplication() {
		driver.quit();
	}

	@DataProvider(name = "fetchdata")
	public String[][] sendData() throws IOException {
		// String[][]readData=ReadExcel.readExcel(fileName, sheetName);

		/*
		 * String[][] data=new String[1][4];
		 * 
		 * data[0][0]="Salesforce Project"; data[0][1]="Specimen";
		 * data[0][2]="UK Shift"; data[0][3]="7";
		 **/
		return ReadExcel.readExcel(fileName, sheetName);

		// instead of variable
		// return ReadExcel.readExcel();

	}
}

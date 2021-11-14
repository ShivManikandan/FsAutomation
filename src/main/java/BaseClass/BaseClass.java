package BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import utilities.ReadExcel;

import io.github.bonigarcia.wdm.WebDriverManager;
import threadlocalbaseclass.DriverFactory;

public class BaseClass extends DriverFactory {

	public String fileName;
	public String sheetName;
	public WebDriver driver;
	public WebDriverWait wait;
	

	@Parameters({ "url"})
	@BeforeMethod(alwaysRun = true)
	public void BeforeClassSetUp(String url) {
		
		// Webdriver Setup
		WebDriverManager.chromedriver().setup();
		// ChromeOption Setup
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
     // Create Chrome Driver Object
        driver = new ChromeDriver(options);
		
		
		

		// Create JavascriptExecutor instance and assign driver object
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Wait Setup

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.navigate().to(url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		

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



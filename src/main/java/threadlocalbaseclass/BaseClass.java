package threadlocalbaseclass;

import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import utilities.ReadExcel;

import io.github.bonigarcia.wdm.WebDriverManager;
import threadlocalbaseclass.DriverFactory;

public class BaseClass extends DriverFactory {

	public String fileName;
	public String sheetName;
	public WebDriver driver,browserInstance;
	public WebDriverWait wait;
	public String Browser;
	public static List<String> browserID_Chrome;
	public static List<String> browserID_Firefox;
	
	//@Parameters({"Browser"})
	//public void browserIntialization(String Browser)
	@BeforeClass(alwaysRun = true)
	public void browserIntialization() {
		this.Browser="chrome";
		browserID_Chrome = new LinkedList<String>();
		browserID_Firefox = new LinkedList<String>();
	}
	

	//@Parameters({ "url"})
	//public void BeforeClassSetUp(String url) 
	@BeforeMethod(alwaysRun = true)
	public void BeforeClassSetUp() {
		
		// Webdriver Setup
					if(Browser.equalsIgnoreCase("Chrome")) {
						WebDriverManager.chromedriver().setup();
						// ChromeOption Setup
						ChromeOptions option = new ChromeOptions();
						option.addArguments("--disable-notifications");
						// Create Chrome Driver Object
						browserInstance = new ChromeDriver(option);
					}
					else if(Browser.equalsIgnoreCase("Firefox")) {
						WebDriverManager.firefoxdriver().setup();
						//firefox option setup
						FirefoxOptions option = new FirefoxOptions();
						option.addPreference("dom.webnotifications.enabled", false);
						option.addPreference("dom.push.enabled", false);
						// Create Firefox Driver Object
						browserInstance = new FirefoxDriver(option);
					}
					setDriver(browserInstance);
					
					/*
					 * // Webdriver Setup WebDriverManager.chromedriver().setup(); // ChromeOption
					 * Setup ChromeOptions options = new ChromeOptions();
					 * options.addArguments("--disable-notifications"); // Create Chrome Driver
					 * Object driver = new ChromeDriver(options);
					 */
		
		

		// Create JavascriptExecutor instance and assign driver object
		JavascriptExecutor js = (JavascriptExecutor) 	getDriver();
		setJSExecutor(js);
		
		// Wait Setup

		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		 setWait(wait);
			getDriver().manage().window().maximize();
		//driver.navigate().to(url);
			getDriver().navigate().to("https://login.salesforce.com");

			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		

	}

	@AfterMethod(alwaysRun = true)
	public void closeApplication() {
		getDriver().quit();
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



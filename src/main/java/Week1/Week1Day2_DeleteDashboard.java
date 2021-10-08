package Week1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week1Day2_DeleteDashboard {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

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
				driver.findElement(By.xpath(" //input[@placeholder='Search apps or items...']")).sendKeys("Sales");
				driver.findElement(
						By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']"))
						.click();

				// click Dashboard tab using the js executor
				WebElement Dashboardstab = driver.findElement(By.xpath("//a[@title='Dashboards']/span[text()='Dashboards']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", Dashboardstab);
				
				// click Search recent dashboard
				driver.findElement(By.xpath("//span[@title='Created On']")).click();
				driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).click();
				driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']"))
				.sendKeys("Automation by Manis24", Keys.ENTER);

				//Click Delete From Drop Down
				driver.findElement(By.xpath(
						"//table[contains(@class,'slds-table slds-table_header-fixed slds-table_bordered slds-table_edit slds-table_resizable-cols')]/tbody/tr[1]/th//a[contains(@title,'Automation by Manis24')]"));
				driver.findElement(By.xpath(
						"//table[contains(@class,'slds-table slds-table_header-fixed slds-table_bordered slds-table_edit slds-table_resizable-cols')]/tbody/tr[1]/td[6]//button"))
				.click();
				driver.findElement(By.xpath("//a[@role='menuitem']/span[text()='Delete']")).click();
				
				//click Delete and assert
				String confirmationText;
				driver.findElement(By.xpath("//button[@title='Delete']")).click();
				confirmationText=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
				System.out.println(confirmationText);
				
				//Verify Dashboard Deleted

	}

}

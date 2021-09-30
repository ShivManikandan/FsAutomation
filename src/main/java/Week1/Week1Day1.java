package Week1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week1Day1 {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();

//Handle Notifications
ChromeOptions options=new ChromeOptions();
options.addArguments("--disable-notifications");

ChromeDriver driver=new ChromeDriver(options);

//Login to the salesforce app
driver.get("https://login.salesforce.com");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
driver.findElement(By.id("Login")).click();

//click on toggle menu 
driver.findElement(By.className("slds-icon-waffle")).click();

//click on viewall and select sales from the search launcher
driver.findElement(By.xpath("//button[text()='View All']")).click();
driver.findElement(By.xpath(" //input[@placeholder='Search apps or items...']")).sendKeys("Sales");
driver.findElement(By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']")).click();


//click oppurtunities tab using the js executor
WebElement Opportunitiestab= driver.findElement(By.xpath("//a[@title='Opportunities']/span[text()='Opportunities']"));
JavascriptExecutor js = (JavascriptExecutor) driver;  
js.executeScript("arguments[0].click();", Opportunitiestab);

//clicking add button using the js executor
WebElement NewButton=driver.findElement(By.xpath("//a[@title='New']"));
js.executeScript("arguments[0].click();", NewButton);

//click on Oppurtunity tab
/*
 * WebElement OppName= driver.findElement(By.xpath("//input[@name='Name']"));
 * OppName.sendKeys("Salesforce Automation by Maniwss");
 */
//String EnteredName=OppName.getText();
String oppName1="Opportunity";
String oppName2="\"Salesforce Automation by Mwanqdss\""; 
String oppName3="was created.";

String finalname= oppName1 + " " + oppName2 + " " + oppName3;

driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(oppName2);
System.out.println("Text content is : " + finalname);

//Choose Date 
driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("9/24/2021");

//Select the Stage Dropdown Value
Thread.sleep(1000);
driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div//input")).click();
driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']")).click();

//Click Save button
Thread.sleep(1000);
driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

//Assert the Entered name in Opportunity tab in search results

/*
 * Thread.sleep(1000); String createdOppName=driver.findElement(By.
 * xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"
 * )).getText(); //String createdOppName=driver.findElement(By.xpath(
 * "//span/a[@class='forceActionLink']]")).getText();
 * 
 * System.out.println(createdOppName);
 * Assert.assertEquals(oppName,createdOppName);
 */
Thread.sleep(1000);
WebElement strValue = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
String strActual = strValue.getText();
System.out.println(strActual);
Assert.assertEquals(finalname,strActual);
/*
 * String s1 = "Opportunity"; String s2 = "Salesforce Automation by Manawss";
 */
//String createdOppName = s1 + " " + s2;



/*
 * WebElement strValue = driver.findElement(By.
 * xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"
 * )); String strExpected = "Salesforce Automation by Manawss"; String strActual
 * = strValue.getText();
 */
/*
 * System.out.println(strActual); if (strExpected.equals(strActual)) {
 * System.out.println("Strings are equal"); } else {
 * System.out.println("Strings are NOT equal"); }
 */

driver.close();


/*
 * if(driver.findElement(By.
 * xpath(" //a[@title='Salesforce Automation by ManisTest1']")).isDisplayed()) {
 * System.out.println("Element is Visible"); } else{
 * 
 * System.out.println("Opputurniteies label is not displayed");
 * 
 * }
 */
	}

}

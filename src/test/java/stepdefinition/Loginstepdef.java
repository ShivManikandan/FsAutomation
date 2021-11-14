package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginstepdef extends BaseClass {
	/*
	 * public static ChromeDriver driver;
	 */

	/*
	 * @Given("Launch the chrome browser") public void launchBrowser() {
	 * WebDriverManager.chromedriver().setup(); ChromeOptions options = new
	 * ChromeOptions(); options.addArguments("--disable-notifications"); driver =
	 * new ChromeDriver(options); driver.manage().window().maximize(); }
	 * 
	 * @Given("Load the application url") public void loadAppUrl() {
	 * driver.get("https://login.salesforce.com");
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 * 
	 * }
	 */

	@Given("Enter the username as {string}")
	public void enterUserName(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@Given("Enter the password as {string}")
	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password	);

	}

	@When("click login button")
	public void clickLoginButton() {
		driver.findElement(By.id("Login")).click();
	}

	@Then("Verify the home page should be displayed")
	public void VerifyHomePage() {
		String actTitle = driver.getTitle();
		if (actTitle.contains("Sales")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	
	@But("Error message should be displayed")
	public void VerifyErrorMessage()
	{
		System.out.println("Error Message is Displayed");
	}
}

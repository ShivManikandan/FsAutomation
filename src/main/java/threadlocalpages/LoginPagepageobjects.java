package threadlocalpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginPagepageobjects extends BaseClass {
	

	/*
	 * public LoginPagepageobjects(WebDriver driver,WebDriverWait wait) {
	 * this.driver=driver; this.wait=wait; }
	 */
	@Given("Enter the username as {string}")
	public LoginPagepageobjects enterUserName(String username) {
		
	getDriver().findElement(By.id("username")).sendKeys(username);
		return this;
	}
	@Given("Enter the password as {string}")
	public LoginPagepageobjects enterpassWord(String password) {
		
		getDriver().findElement(By.id("password")).sendKeys(password);
		return this;
	}
	@When("click login button")
	public HomePagepageobjects clickLoginButton() {
		getWait().until(ExpectedConditions.elementToBeClickable(By.id("Login")));
		getDriver().findElement(By.id("Login")).click();
		return new HomePagepageobjects();
}
}

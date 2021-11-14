package pageObects;

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
	

	public LoginPagepageobjects(WebDriver driver,WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
	}

	public LoginPagepageobjects enterUserName(String username) {
		
		driver.findElement(By.id("username")).sendKeys(username);
		return this;
	}

	public LoginPagepageobjects enterpassWord(String password) {
		
		driver.findElement(By.id("password")).sendKeys(password);
		return this;
	}

	public HomePagepageobjects clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Login")));
		driver.findElement(By.id("Login")).click();
		return new HomePagepageobjects(driver,wait);
}
}

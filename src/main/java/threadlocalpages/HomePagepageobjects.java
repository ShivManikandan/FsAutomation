package threadlocalpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.BaseClass;
import io.cucumber.java.en.Then;

public class HomePagepageobjects extends BaseClass {

	/*
	 * public HomePagepageobjects(WebDriver driver,WebDriverWait wait) {
	 * this.driver=driver; this.wait=wait;
	 * 
	 * }
	 */
	@Then("click click on the App Launcher")
	public HomePagepageobjects clickToggleMenu() throws InterruptedException {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']")));
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		return this;

	}

	@Then("click on View All")
	public HomePagepageobjects clickViewAll() {
		getDriver().findElement(By.xpath("//button[text()='View All']")).click();
		return this;
	}

	@Then("click on Work Types")
	public NewWorkTypepageobjects clickworkType() {
		WebElement worktypeElement = getDriver()
				.findElement(By.xpath("//p[@class='slds-truncate' and text()='Work Types']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", worktypeElement);
		worktypeElement.click();
		return new NewWorkTypepageobjects();

	}

	public EditWorkTypepageobjects EditworkType() {
		WebElement worktypeElement = getDriver()
				.findElement(By.xpath("//p[@class='slds-truncate' and text()='Work Types']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", worktypeElement);
		worktypeElement.click();
		return new EditWorkTypepageobjects();

	}

	public void closeApplication() {
		getDriver().quit();
	}

}

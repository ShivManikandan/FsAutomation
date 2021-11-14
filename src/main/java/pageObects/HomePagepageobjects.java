package pageObects;

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

	public HomePagepageobjects(WebDriver driver,WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
	}
	
	
	public HomePagepageobjects clickToggleMenu() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		return this;
		
	}
	
	public HomePagepageobjects clickViewAll() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		return this;
	}
	

	public NewWorkTypepageobjects clickworkType() {
		WebElement worktypeElement = driver.findElement(By.xpath("//p[@class='slds-truncate' and text()='Work Types']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", worktypeElement);
		worktypeElement.click();
		return new NewWorkTypepageobjects(driver,wait);
		
	}
	
	public EditWorkTypepageobjects EditworkType() {
		WebElement worktypeElement = driver.findElement(By.xpath("//p[@class='slds-truncate' and text()='Work Types']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", worktypeElement);
		worktypeElement.click();
		return new EditWorkTypepageobjects(driver,wait);
		
	}
	public void closeApplication() {
		driver.quit();
	}
	
}

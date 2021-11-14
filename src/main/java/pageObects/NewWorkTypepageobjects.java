package pageObects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BaseClass.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewWorkTypepageobjects extends BaseClass {
	static String workTypeName = "Salesforce ProjectSpecimen";
	/*
	 * static String description = "Specimen"; static String operatingHours =
	 * "UK Shift"; static String duration = "7";
	 */
	static String actualText;

	public NewWorkTypepageobjects(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public NewWorkTypepageobjects clickOnNewButton() {

		driver.findElement(By.xpath("//a[@title='New']")).click();
		return this;
	}

	public NewWorkTypepageobjects enterWorkTypeName(String wname) {

		driver.findElement(By.xpath("//span[text()='Work Type Name']/parent::label/following-sibling::input"))
				.sendKeys(wname);

		return this;
	}

	public NewWorkTypepageobjects enterDesriptionName(String dname) {

		driver.findElement(By.xpath("//span[text()='Work Type Name']/parent::label/following-sibling::input"))
				.sendKeys(dname);

		return this;
	}

	public NewWorkTypepageobjects clickSearchOperatingHours() {
		driver.findElement(By.xpath("//input[@title='Search Operating Hours']")).click();
		return this;
	}

	public NewWorkTypepageobjects clicknewOperatingHours() {
		driver.findElement(By.xpath("//span[@title='New Operating Hours']")).click();
		return this;
	}

	public NewWorkTypepageobjects enternewOperatingHoursDescription(String Operatinghours) {
		driver.findElement(By.xpath("//span[text()='Name']/parent::label/following-sibling::input"))
				.sendKeys(Operatinghours);

		return this;
	}

	public NewWorkTypepageobjects clicknewTimeZone() {
		driver.findElement(By.xpath("//span[text()='Time Zone']/parent::span/following-sibling::div//a")).click();

		return this;
	}

	public NewWorkTypepageobjects selectTimeZone()

	{
		driver.findElement(By.xpath("//div[@class='select-options']/ul/li/a[contains(@title,'London')]")).click();

		return this;
	}

	public NewWorkTypepageobjects saveNewOperatingHours()

	{
		driver.findElement(By.xpath(
				"//h2[text()='New Operating Hours']/parent::div/following-sibling::div[contains(@class,'modal-footer')]//button[@title='Save']"))
				.click();

		return this;
	}

	public NewWorkTypepageobjects enterEstimatedDuration(String duration)

	{
		driver.findElement(By.xpath(
				"//span[text()='Estimated Duration']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"))
				.sendKeys(duration);

		return this;
	}

	public NewWorkTypepageobjects clickNewWOrkTypeSave()

	{
		driver.findElement(By.xpath("//div[contains(@class,'inlineFooter')]//button[@title='Save']")).click();

		return this;
	}

	public void verifyCreatedMessage() {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Work Type')]"), "Work Type"));
		actualText = driver
				.findElement(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Work Type')]"))
				.getText();
		Assert.assertEquals(actualText, "Work Type \"" + workTypeName + "\" was created.");

	}

}

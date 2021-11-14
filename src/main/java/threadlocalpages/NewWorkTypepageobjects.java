package threadlocalpages;

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

	/*
	 * public NewWorkTypepageobjects(WebDriver driver,WebDriverWait wait) {
	 * this.driver = driver; this.wait=wait; }
	 */

	@Then("click on New")
	public NewWorkTypepageobjects clickOnNewButton() {

		getDriver().findElement(By.xpath("//a[@title='New']")).click();
		return this;
	}

	@Then("Enter Work Type Name as {string}")
	public NewWorkTypepageobjects enterWorkTypeName(String wname) {

		getDriver().findElement(By.xpath("//span[text()='Work Type Name']/parent::label/following-sibling::input"))
				.sendKeys(wname);

		return this;
	}

	@Then("Enter Description as {string}")
	public NewWorkTypepageobjects enterDesriptionName(String dname) {

		getDriver().findElement(By.xpath("//span[text()='Work Type Name']/parent::label/following-sibling::input"))
				.sendKeys(dname);

		return this;
	}

	@Then("click clickSearchOperatingHours")
	public NewWorkTypepageobjects clickSearchOperatingHours() {
		getDriver().findElement(By.xpath("//input[@title='Search Operating Hours']")).click();
		return this;
	}

	@Then("click clicknewOperatingHours")
	public NewWorkTypepageobjects clicknewOperatingHours() {
		getDriver().findElement(By.xpath("//span[@title='New Operating Hours']")).click();
		return this;
	}

	@Then("Create new operating hours by Entering a name as {string}")
	public NewWorkTypepageobjects enternewOperatingHoursDescription(String Operatinghours) {
		getDriver().findElement(By.xpath("//span[text()='Name']/parent::label/following-sibling::input"))
				.sendKeys(Operatinghours);

		return this;
	}

	@Then("clicknewTimeZone button")
	public NewWorkTypepageobjects clicknewTimeZone() {
		getDriver().findElement(By.xpath("//span[text()='Time Zone']/parent::span/following-sibling::div//a")).click();

		return this;
	}

	@Then("selectTimeZone")
	public NewWorkTypepageobjects selectTimeZone()

	{
		getDriver().findElement(By.xpath("//div[@class='select-options']/ul/li/a[contains(@title,'London')]")).click();

		return this;
	}

	@Then("saveNewOperatingHours")
	public NewWorkTypepageobjects saveNewOperatingHours()

	{
		getDriver().findElement(By.xpath(
				"//h2[text()='New Operating Hours']/parent::div/following-sibling::div[contains(@class,'modal-footer')]//button[@title='Save']"))
				.click();

		return this;
	}

	@Then("Enter Estimated Duration as {string}")
	public NewWorkTypepageobjects enterEstimatedDuration(String duration)

	{
		getDriver().findElement(By.xpath(
				"//span[text()='Estimated Duration']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"))
				.sendKeys(duration);

		return this;
	}

	@When("Click on Save")
	public NewWorkTypepageobjects clickNewWOrkTypeSave()

	{
		getDriver().findElement(By.xpath("//div[contains(@class,'inlineFooter')]//button[@title='Save']")).click();

		return this;
	}

	@Then("Verify the Created message")
	public void verifyCreatedMessage() {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Work Type')]"), "Work Type"));
		actualText = getDriver()
				.findElement(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Work Type')]"))
				.getText();
		Assert.assertEquals(actualText, "Work Type \"" + workTypeName + "\" was created.");

	}

}

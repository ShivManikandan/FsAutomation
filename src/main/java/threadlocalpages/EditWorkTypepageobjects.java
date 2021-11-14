
package threadlocalpages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BaseClass.BaseClass;

public class EditWorkTypepageobjects extends BaseClass

{ 
	static String workTypeName;

	/*
	 * public EditWorkTypepageobjects(WebDriver driver,WebDriverWait wait) {
	 * this.driver = driver; this.wait= wait; }
	 */


public EditWorkTypepageobjects clickOnEditButton() {

	getDriver().findElement(By.xpath("//table/tbody/tr[1]/td")).getSize();
	workTypeName =
			getDriver().findElement(By.xpath("//table/tbody/tr[1]/th//a")).getText();
	System.out.println(workTypeName);
	getDriver().findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).click();
	getDriver().findElement(By.xpath("//a[@title='Edit']")).click();

	return this; 

}

public EditWorkTypepageobjects changetheStartTime(String timeFrameStart)

{ 
	getDriver().findElement(By.xpath(
			"//span[text()='Timeframe Start']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"
			)) .clear();
	getDriver().findElement(By.xpath(
					"//span[text()='Timeframe Start']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"
					)) .sendKeys(timeFrameStart);
			return this; 
}
public EditWorkTypepageobjects changetheEndTime(String timeFrameEnd)
{
	getDriver().findElement(By.xpath(
					"//span[text()='Timeframe End']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"))
					.clear();
	getDriver().findElement(By.xpath(
					"//span[text()='Timeframe End']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"))
					.sendKeys(timeFrameEnd);
			return this; 

}

public EditWorkTypepageobjects clickSave()

{
	getDriver().findElement(By.xpath("//div[contains(@class,'inlineFooter')]//button[@title='Save']")).click();

	return this;
}

public void verifyEditMessage()
{
	getWait().until(ExpectedConditions
		.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"), workTypeName));
String strValue = getDriver().findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
System.out.println(strValue);
Assert.assertEquals(strValue, "Work Type \"" + workTypeName + "\" was saved.");
}

}

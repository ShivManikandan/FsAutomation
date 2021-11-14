
package pageObects;

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

	public EditWorkTypepageobjects(WebDriver driver,WebDriverWait wait)
{
		this.driver = driver;
		this.wait= wait;
	}


public EditWorkTypepageobjects clickOnEditButton() {

	driver.findElement(By.xpath("//table/tbody/tr[1]/td")).getSize();
	workTypeName =
			driver.findElement(By.xpath("//table/tbody/tr[1]/th//a")).getText();
	System.out.println(workTypeName);
	driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).click();
	driver.findElement(By.xpath("//a[@title='Edit']")).click();

	return this; 

}

public EditWorkTypepageobjects changetheStartTime(String timeFrameStart)

{ 
	driver.findElement(By.xpath(
			"//span[text()='Timeframe Start']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"
			)) .clear(); driver.findElement(By.xpath(
					"//span[text()='Timeframe Start']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"
					)) .sendKeys(timeFrameStart);
			return this; 
}
public EditWorkTypepageobjects changetheEndTime(String timeFrameEnd)
{
			driver.findElement(By.xpath(
					"//span[text()='Timeframe End']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"))
					.clear();
			driver.findElement(By.xpath(
					"//span[text()='Timeframe End']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"))
					.sendKeys(timeFrameEnd);
			return this; 

}

public EditWorkTypepageobjects clickSave()

{
	driver.findElement(By.xpath("//div[contains(@class,'inlineFooter')]//button[@title='Save']")).click();

	return this;
}

public void verifyEditMessage()
{
wait.until(ExpectedConditions
		.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"), workTypeName));
String strValue = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
System.out.println(strValue);
Assert.assertEquals(strValue, "Work Type \"" + workTypeName + "\" was saved.");
}

}

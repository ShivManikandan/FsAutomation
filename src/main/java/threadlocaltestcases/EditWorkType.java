package threadlocaltestcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pageObects.LoginPagepageobjects;

public class EditWorkType extends BaseClass{
	public static String username;
	public static String password;

	@Parameters({"username", "password" })
		@BeforeClass(alwaysRun = true)
		public void readData(String username,String password ) {
			
			fileName="TestData";
			sheetName="EditNewWorkType";
			this.username=username;
			this.password=password;
		}
	
	@Test(dataProvider="fetchdata")
	public void editNewWorkType(String timeFrameEnd,String timeFrameStart) throws InterruptedException
	{
		new LoginPagepageobjects(driver,wait)
		.enterUserName(username)
		.enterpassWord(password)
		.clickLoginButton()
		.clickToggleMenu()
		.clickViewAll()
		.EditworkType()
		.clickOnEditButton()
		.changetheStartTime(timeFrameStart)
		.changetheEndTime(timeFrameEnd)
		.clickSave()
		.verifyEditMessage();
		
	}

	
}

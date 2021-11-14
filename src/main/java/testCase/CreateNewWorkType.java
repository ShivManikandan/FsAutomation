package testCase;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pageObects.LoginPagepageobjects;

public class CreateNewWorkType extends BaseClass {
	

public static String username;
public static String password;

@Parameters({"username", "password" })
	@BeforeClass(alwaysRun = true)
	public void readData(String username,String password ) {
		
		fileName="TestData";
		sheetName="CreateNewWorkType";
		this.username=username;
		this.password=password;
	}

	@Test(dataProvider="fetchdata")
	public void createNewWorkType(String wname,String dname,String Operatinghours,String duration) throws InterruptedException
	{
		new LoginPagepageobjects(driver,wait)
		.enterUserName(username)
		.enterpassWord(password)
		.clickLoginButton()
		.clickToggleMenu()
		.clickViewAll()
		.clickworkType()
		.clickOnNewButton()
		.enterWorkTypeName(wname)
		.enterDesriptionName(dname)
		.clickSearchOperatingHours()
		.clicknewOperatingHours()
		.enternewOperatingHoursDescription(Operatinghours)
		.clicknewTimeZone()
		.selectTimeZone()
		.saveNewOperatingHours()
		.enterEstimatedDuration(duration)
		.clickNewWOrkTypeSave()
		.verifyCreatedMessage();
	}

}

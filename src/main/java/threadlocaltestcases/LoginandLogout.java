package threadlocaltestcases;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pageObects.LoginPagepageobjects;

public class LoginandLogout extends BaseClass {
	
	
@Test
	public void runlogin(String username,String password)
	{
		//LoginPagepageobjects lp=new LoginPagepageobjects(driver);
		new LoginPagepageobjects(driver,wait)
		.enterUserName(username)
		.enterpassWord(password)
		.clickLoginButton();
		
		
	}

}

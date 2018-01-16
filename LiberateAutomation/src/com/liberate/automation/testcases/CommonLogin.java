package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.Login;

public class CommonLogin {
	public static TestActions action = new TestActions();
	
	@BeforeSuite
	public static void navigateToURL()
	{
		action.gotoURL("http://172.21.73.80:8081/liberate-LONI01-S10/");
//		action.gotoURL("http://172.21.73.80:8083/liberate-LONI02-S06/");

		Login login = new Login(action);
		
		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
	}
	
	@AfterSuite
	public static void endTesting()
	{
		action.closeTab();
		action.quit();
		action = null;
	}
}

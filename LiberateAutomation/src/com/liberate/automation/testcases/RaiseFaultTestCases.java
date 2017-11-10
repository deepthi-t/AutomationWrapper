package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.Login;
import com.liberate.automation.pom.RaiseFault;

public class RaiseFaultTestCases 
{
	static TestActions action = new TestActions();
	
	public void navigateToURL()
	{
		action.gotoURL("http://172.21.73.80:8081/liberate-LONI01-S10/");
	}
	

	public void raiseNewFault() 
	{
		RaiseFault rf = new RaiseFault(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("raiseNewFault");
		assertEquals(rf.navigate(),true);
		action.getScreenShot("raiseNewFault");
		
		assertEquals(rf.enterServiceNumber("154180"),true);
		action.getScreenShot("raiseNewFault");
		assertEquals(rf.clickonRaiseFaultbutton(),true);
		action.getScreenShot("raiseNewFault");
		assertEquals(rf.enterDataInFieldsToRaiseFault(),true);
		action.getScreenShot("raiseNewFault");
		assertEquals(rf.clickonAccepttbutton(),true);
		action.getScreenShot("raiseNewFault");
		assertEquals(rf.raisedFaultNumber(),true);
		action.getScreenShot("raiseNewFault");
	}
	
	public void raiseNewFault_reset() 
	{
		RaiseFault rf = new RaiseFault(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("raiseNewFault_reset");
		assertEquals(rf.navigate(),true);
		action.getScreenShot("raiseNewFault_reset");
		
		assertEquals(rf.enterServiceNumber("154180"),true);
		action.getScreenShot("raiseNewFault_reset");
		assertEquals(rf.clickonResetbutton(),true);
		action.getScreenShot("raiseNewFault_reset");
	}
	
	public void raiseNewFault_cancel() 
	{
		RaiseFault rf = new RaiseFault(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("raiseNewFault_cancel");
		assertEquals(rf.navigate(),true);
		action.getScreenShot("raiseNewFault_cancel");
		
		assertEquals(rf.enterServiceNumber("154180"),true);
		action.getScreenShot("raiseNewFault_cancel");
		assertEquals(rf.clickonCanceltbutton(),true);
		action.getScreenShot("raiseNewFault_cancel");
	}
}



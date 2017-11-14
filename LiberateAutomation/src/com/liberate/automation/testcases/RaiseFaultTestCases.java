package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.RaiseFault;

public class RaiseFaultTestCases 
{
	static TestActions action = CommonLogin.action;
	
	@Test
	public void raiseNewFault() 
	{
		RaiseFault rf = new RaiseFault(action);

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

		assertEquals(rf.navigate(),true);
		action.getScreenShot("raiseNewFault_cancel");
		
		assertEquals(rf.enterServiceNumber("154180"),true);
		action.getScreenShot("raiseNewFault_cancel");
		assertEquals(rf.clickonCanceltbutton(),true);
		action.getScreenShot("raiseNewFault_cancel");
	}
}



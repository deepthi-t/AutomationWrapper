package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.Login;
import com.liberate.automation.pom.ManageFault;

public class ManageFaultTestCases 
{
	static TestActions action = new TestActions();
	
	public void navigateToURL()
	{
		action.gotoURL("http://172.21.73.80:8081/liberate-LONI01-S10/");
	}
	

	public void addNotes_ManageFault() 
	{
		ManageFault mf = new ManageFault(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.navigate(),true);
		action.getScreenShot("manageFault");
		
		assertEquals(mf.enterFaultNumber(""),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSearchbutton(),true);
		action.getScreenShot("manageFault");
	
		assertEquals(mf.clickonMaintainFaultnotesactionbutton(),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonAddNotesbutton(),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.enterDataInAddNotestextfield("Test"),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonAddNotesApplybutton(),true);
		action.getScreenShot("manageFault");
	}
	
	public void assignFault_ManageFault() 
	{
		ManageFault mf = new ManageFault(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.navigate(),true);
		action.getScreenShot("manageFault");
		
		assertEquals(mf.enterFaultNumber(""),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSearchbutton(),true);
		action.getScreenShot("manageFault");
		
		assertEquals(mf.clickonAssignFaultactionbutton(),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.selectDepartmentDropdown(),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonAssignFaultAssignbutton(),true);
		action.getScreenShot("manageFault");
	}

	public void signoff_ManageFault() 
	{
		ManageFault mf = new ManageFault(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.navigate(),true);
		action.getScreenShot("manageFault");
		
		assertEquals(mf.enterFaultNumber(""),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSearchbutton(),true);
		action.getScreenShot("manageFault");
		
		assertEquals(mf.clickonSignOffactionbutton(),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.selectSignoffDropDowns(),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSignOffApplybutton(),true);
		action.getScreenShot("manageFault");
	}
	
	public void suspendRelease_ManageFault() 
	{
		ManageFault mf = new ManageFault(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.navigate(),true);
		action.getScreenShot("manageFault");
		
		assertEquals(mf.enterFaultNumber(""),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSearchbutton(),true);
		action.getScreenShot("manageFault");
		
		assertEquals(mf.clickonSuspendReleaseactionbutton(),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.selectSuspensionReason(),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSuspendbutton(),true);
		action.getScreenShot("manageFault");
	}
	public void upgradeFaultPriority_ManageFault() 
	{
		ManageFault mf = new ManageFault(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.navigate(),true);
		action.getScreenShot("manageFault");
		
		assertEquals(mf.enterFaultNumber(""),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSearchbutton(),true);
		action.getScreenShot("manageFault");
		
		assertEquals(mf.clickonUpgradeFaultPriorityactionbutton(),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.selectNewPriorityDropdown(),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonFaultPriorityAcceptbutton(),true);
		action.getScreenShot("manageFault");
	}
	public void recordFaultTest_ManageFault() 
	{
		ManageFault mf = new ManageFault(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.navigate(),true);
		action.getScreenShot("manageFault");
		
		assertEquals(mf.enterFaultNumber(""),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSearchbutton(),true);
		action.getScreenShot("manageFault");
		
		assertEquals(mf.clickonRecordFaultTestactionbutton(),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.selectRecordFaultTestDiagnosisDropDown(),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonRecordFaultTestApplybutton(),true);
		action.getScreenShot("manageFault");
	}
	public void printFaultDocket_ManageFault() 
	{
		ManageFault mf = new ManageFault(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.navigate(),true);
		action.getScreenShot("manageFault");
		
		assertEquals(mf.enterFaultNumber(""),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSearchbutton(),true);
		action.getScreenShot("manageFault");
		
		assertEquals(mf.clickonPrintFaultDocketactionbutton(),true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonPrintFaultDocketAcceptbutton(),true);
		action.getScreenShot("manageFault");
	}
}

package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.ManageFault;
import com.liberate.automation.pom.RaiseFault;

public class FaultManagement {
	static TestActions action = CommonLogin.action;
	
	@Test
	public void raiseFault() {		
		RaiseFault rf = new RaiseFault(action);

		assertEquals(rf.navigate(), true);
		action.getScreenShot("raiseNewFault");

		assertEquals(rf.enterServiceNumber("510284"), true);
		action.getScreenShot("raiseNewFault");
		assertEquals(rf.clickonRaiseFaultbutton(), true);
		action.getScreenShot("raiseNewFault");
		assertEquals(rf.enterDataInFieldsToRaiseFault(), true);
		action.getScreenShot("raiseNewFault");
		assertEquals(rf.clickonAccepttbutton(), true);
		action.getScreenShot("raiseNewFault");
		assertEquals(rf.raisedFaultNumber(), true);
		action.getScreenShot("raiseNewFault");
	}
	
	@Test
	public void manageFaultAddNotes() {
		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot("manageFault");

		assertEquals(mf.enterFaultNumber("C00003A"), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot("manageFault");

		assertEquals(mf.clickonMaintainFaultnotesactionbutton(), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonAddNotesbutton(), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.enterDataInAddNotestextfield("Test"), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonAddNotesApplybutton(), true);
		action.getScreenShot("manageFault");

	}

	@Test
	public void assignFault_ManageFault() {
		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot("manageFault");

		assertEquals(mf.enterFaultNumber(""), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot("manageFault");

		assertEquals(mf.clickonAssignFaultactionbutton(), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.selectDepartmentDropdown(), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonAssignFaultAssignbutton(), true);
		action.getScreenShot("manageFault");
	}

	@Test
	public void signoffFault() {
		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot("signoffFault");

		assertEquals(mf.enterFaultNumber("C00010A"), true);
		action.getScreenShot("signoffFault");
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot("signoffFault");

		assertEquals(mf.clickonSignOffactionbutton(), true);
		action.getScreenShot("signoffFault");
		assertEquals(mf.selectSignoffDropDowns(), true);
		action.getScreenShot("signoffFault");
		assertEquals(mf.clickonSignOffApplybutton(), true);
		action.getScreenShot("signoffFault");
		assertEquals(mf.statusOfFaultNumber(), "Cleared");
		action.getScreenShot("signoffFault");
	}

	@Test
	public void suspendRelease_ManageFault() {
		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot("manageFault");

		assertEquals(mf.enterFaultNumber("C00003A"), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot("manageFault");

		assertEquals(mf.clickonSuspendReleaseactionbutton(), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.selectSuspensionReason(), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSuspendbutton(), true);
		action.getScreenShot("manageFault");
	}

	@Test
	public void upgradeFaultPriority_ManageFault() {
		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot("manageFault");

		assertEquals(mf.enterFaultNumber("C00003A"), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot("manageFault");

		assertEquals(mf.clickonUpgradeFaultPriorityactionbutton(), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.selectNewPriorityDropdown(), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonFaultPriorityAcceptbutton(), true);
		action.getScreenShot("manageFault");
	}

	@Test
	public void recordFaultTest_ManageFault() {
		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot("manageFault");

		assertEquals(mf.enterFaultNumber("C00003A"), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot("manageFault");

		assertEquals(mf.clickonRecordFaultTestactionbutton(), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.selectRecordFaultTestDiagnosisDropDown(), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonRecordFaultTestApplybutton(), true);
		action.getScreenShot("manageFault");
	}

	@Test
	public void printFaultDocket_ManageFault() {
		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot("manageFault");

		assertEquals(mf.enterFaultNumber("C00003A"), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot("manageFault");

		assertEquals(mf.clickonPrintFaultDocketactionbutton(), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.clickonPrintFaultDocketAcceptbutton(), true);
		action.getScreenShot("manageFault");
	}

	@Test
	public void recordFaultActivity_ManageFault() {
		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot("manageFault");

		action.getScreenShot("manageFault");
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot("manageFault");

		assertEquals(mf.clickonRecordFaultTestactionbutton(), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.recordFaultActivitySelectActivityIDActivityNotes(), true);
		action.getScreenShot("manageFault");
		assertEquals(mf.recordFaultActivityRaiseActivityAceeptbutton(), true);
		action.getScreenShot("manageFault");
	}
}

package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.ManageFault;
import com.liberate.automation.pom.RaiseFault;

/***
 * Test Case with Fault Management Test Case
 * 
 * @author Nikhil
 *
 */
public class FaultManagementTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	/**
	 * Private constructor to disable creation of object
	 */
	private FaultManagementTC() {
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result, action);
	}

	@Test
	public static void raiseFault() {
		testCase = "FaultManagement_raiseFault";

		RaiseFault rf = new RaiseFault(action);

		assertEquals(rf.navigate(), true);
		action.getScreenShot(testCase);

		assertEquals(rf.enterServiceNumber("551002"), true);
		action.getScreenShot(testCase);
		assertEquals(rf.clickonRaiseFaultbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(rf.enterDataInFieldsToRaiseFault(), true);
		action.getScreenShot(testCase);
		assertEquals(rf.clickonAccepttbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(rf.raisedFaultNumber(), true);
		action.getScreenShot(testCase);
	}

	@Test
	public static void manageFaultAddNotes() {
		testCase = "FaultManagement_manageFaultAddNotes";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.enterFaultNumber("C00005C"), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.clickonMaintainFaultnotesactionbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonAddNotesbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.enterDataInAddNotestextfield("Test"), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonAddNotesApplybutton(), true);
		action.getScreenShot(testCase);
	}

	@Test
	public static void assignFault() {
		testCase = "FaultManagement_assignFault";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.enterFaultNumber(""), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.clickonAssignFaultactionbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.selectDepartmentDropdown(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonAssignFaultAssignbutton(), true);
		action.getScreenShot(testCase);
	}

	@Test
	public static void signoffFault() {
		testCase = "FaultManagement_signoffFault";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.enterFaultNumber("C00005C"), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.clickonSignOffactionbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.selectSignoffDropDowns(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonSignOffApplybutton(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.statusOfFaultNumber(), "Cleared");
		action.getScreenShot(testCase);
	}

	@Test
	public static void suspendRelease() {
		testCase = "FaultManagement_suspendRelease";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.enterFaultNumber("C00005C"), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.clickonSuspendReleaseactionbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.selectSuspensionReason(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonSuspendbutton(), true);
		action.getScreenShot(testCase);
	}

	@Test
	public static void upgradeFaultPriority() {
		testCase = "FaultManagement_upgradeFaultPriority";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.enterFaultNumber("C00005C"), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.clickonUpgradeFaultPriorityactionbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.selectNewPriorityDropdown(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonFaultPriorityAcceptbutton(), true);
		action.getScreenShot(testCase);
	}

	@Test
	public static void recordFaultTest() {
		testCase = "FaultManagement_recordFaultTest";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.enterFaultNumber("C00005C"), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.clickonRecordFaultTestactionbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.selectRecordFaultTestDiagnosisDropDown(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonRecordFaultTestApplybutton(), true);
		action.getScreenShot(testCase);
	}

	@Test
	public static void printFaultDocket() {
		testCase = "FaultManagement_printFaultDocket";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.enterFaultNumber("C00005C"), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.clickonPrintFaultDocketactionbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonPrintFaultDocketAcceptbutton(), true);
		action.getScreenShot(testCase);
	}

	@Test
	public static void recordFaultActivity() {
		testCase = "FaultManagement_recordFaultActivity";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(testCase);

		action.getScreenShot(testCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.clickonRecordFaultTestactionbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.recordFaultActivitySelectActivityIDActivityNotes(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.recordFaultActivityRaiseActivityAceeptbutton(), true);
		action.getScreenShot(testCase);
	}
}

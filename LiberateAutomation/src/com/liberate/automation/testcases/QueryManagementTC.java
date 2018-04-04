package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.core.ReportGenerator;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.pom.CRMaintainQuery;

/***
 * Class with all Query Management Test Cases
 * @author Nikhil
 *
 */
public class QueryManagementTC {
	static TestActions action = CommonLogin.action;
	
	static String nonAccountQuery = "";
	
	@Test(priority = 1)
	public static void raiseQueryAccount() {
		String TestCase = "QueryManagement_raiseQueryAccount";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(TestCase);
		mq.searchByAccount("260002260000");
		action.getScreenShot(TestCase);
		mq.raiseAccountQuery();
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 2)
	public static void amendQuery() {
		String TestCase = "QueryManagement_amendQuery";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(TestCase);
		mq.searchByQueryNumber(TestData.queryNumber);
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);
		mq.amendQuery();
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 3)
	public static void addNoteQuery() {
		String TestCase = "QueryManagement_addNoteQuery";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(TestCase);
		mq.searchByQueryNumber(TestData.queryNumber);
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);
		mq.addNote("Additional Note");
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 4)
	public static void progressQuery() {
		String TestCase = "QueryManagement_progressQuery";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(TestCase);
		mq.searchByQueryNumber(TestData.queryNumber);
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);
		mq.progressQuery("RE");
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void signOffQuery() {
		String TestCase = "QueryManagement_signOffQuery";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(TestCase);
		mq.searchByAccount("260002260000");
		action.getScreenShot(TestCase);
		mq.raiseAccountQuery();
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);

		mq.progressQuery("RE");
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);

		mq.signOffQuery();
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void raiseAndAuthoriseAdjustment() {
		String TestCase = "QueryManagement_raiseAndAuthoriseAdjustment";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(TestCase);
		mq.searchByAccount("260002260000");
		action.getScreenShot(TestCase);
		mq.raiseAccountQuery();
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);

		mq.progressQuery("RE");
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);

		mq.raiseAdjustment();
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);

		mq.authoriseAdjustment();
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(enabled = false)
	public static void verifyBills() {
		String TestCase = "QueryManagement_verifyBills";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(TestCase);
		mq.searchByQueryNumber("ZK00015");
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);
		mq.verifyBills();
		action.getScreenShot(TestCase);
		mq.navigateBackFromBillView();
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 5)
	public static void raiseQueryNonAccount() {
		String TestCase = "QueryManagement_raiseQueryNonAccount";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(TestCase);
		mq.raiseNonAccountQuery("Test Name", "mail", "test@cwc.com");
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		nonAccountQuery = mq.QueryNumber;
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 10)
	public static void amendQueryNonAccount() {
		String TestCase = "QueryManagement_amendQuery";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(TestCase);
		mq.searchByQueryNumber(nonAccountQuery);
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);
		mq.amendQuery();
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 11)
	public static void signOffQueryNonAccount() {
		String TestCase = "QueryManagement_signOffQuery";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(TestCase);
		mq.searchByQueryNumber(nonAccountQuery);
		action.getScreenShot(TestCase);
		mq.raiseAccountQuery();
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);

		mq.progressQuery("RE");
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);

		mq.signOffQuery();
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

}

package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.pom.CRMaintainQuery;

public class QueryManagement {
	static TestActions action = CommonLogin.action;

	@Test(priority = 1)
	public static void raiseQueryAccount() {
		String TestCase = "QueryManagement_raiseQueryAccount";
		
		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(TestCase);
		mq.searchByAccount("260002260000");
		action.getScreenShot(TestCase);
		mq.raiseAccountQuery();
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);
	}

	@Test(priority = 2)
	public static void amendQuery() {
		String TestCase = "QueryManagement_amendQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(TestCase);
		mq.searchByQueryNumber(TestData.QueryNumber);
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);
		mq.amendQuery();
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);
	}

	@Test(priority = 3)
	public static void addNoteQuery() {
		String TestCase = "QueryManagement_addNoteQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(TestCase);
		mq.searchByQueryNumber(TestData.QueryNumber);
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);
		mq.addNote("Additional Note");
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);
	}

	@Test(priority = 4)
	public static void progressQuery() {
		String TestCase = "QueryManagement_progressQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(TestCase);
		mq.searchByQueryNumber(TestData.QueryNumber);
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);
		mq.progressQuery("RE");
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void signOffQuery() {
		String TestCase = "QueryManagement_signOffQuery";

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
	}

	@Test
	public static void raiseAndAuthoriseAdjustment() {
		String TestCase = "QueryManagement_raiseAndAuthoriseAdjustment";

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
	}

	@Test(enabled = false)
	public static void verifyBills() {
		String TestCase = "QueryManagement_verifyBills";

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
	}

	@Test(priority = 5)
	public static void raiseQueryNonAccount() {
		String TestCase = "QueryManagement_raiseQueryNonAccount";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(TestCase);
		mq.raiseNonAccountQuery("Test Name", "mail", "test@cwc.com");
		action.getScreenShot(TestCase);
		mq.verifyQuery();
		action.getScreenShot(TestCase);
	}
}

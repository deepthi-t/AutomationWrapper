package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.common.TestData;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CRMaintainQuery;

public class QueryManagement {
	static TestActions action = CommonLogin.action;

	@Test(priority = 1)
	public static void raiseQueryAccount() {
		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot("raiseQueryAccount");
		mq.searchByAccount("260002260000");
		action.getScreenShot("raiseQueryAccount");
		mq.raiseAccountQuery();
		action.getScreenShot("raiseQueryAccount");
		mq.verifyQuery();
		action.getScreenShot("raiseQueryAccount");
	}

	@Test(priority = 2)
	public static void amendQuery() {
		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot("amendQuery");
		mq.searchByQueryNumber(TestData.QueryNumber);// "B00006A"); 
		action.getScreenShot("amendQuery");
		mq.verifyQuery();
		action.getScreenShot("amendQuery");
		mq.amendQuery();
		action.getScreenShot("amendQuery");
		mq.verifyQuery();
		action.getScreenShot("amendQuery");
	}

	@Test(priority = 3)
	public static void addNoteQuery() {
		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot("addNoteQuery");
		mq.searchByQueryNumber(TestData.QueryNumber);// "B00006A");
		action.getScreenShot("addNoteQuery");
		mq.verifyQuery();
		action.getScreenShot("addNoteQuery");
		mq.addNote("Additional Note");
		action.getScreenShot("addNoteQuery");
		mq.verifyQuery();
		action.getScreenShot("addNoteQuery");
	}

	@Test(priority = 4)
	public static void progressQuery() {
		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot("progressQuery");
		mq.searchByQueryNumber(TestData.QueryNumber);// "B00006A");
		action.getScreenShot("progressQuery");
		mq.verifyQuery();
		action.getScreenShot("progressQuery");
		mq.progressQuery("RE");
		action.getScreenShot("progressQuery");
		mq.verifyQuery();
		action.getScreenShot("progressQuery");
	}

	@Test
	public static void signOffQuery() {
		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot("raiseAndAuthoriseAdjustment");
		mq.searchByAccount("260002260000");
		action.getScreenShot("raiseAndAuthoriseAdjustment");
		mq.raiseAccountQuery();
		action.getScreenShot("raiseAndAuthoriseAdjustment");
		mq.verifyQuery();
		action.getScreenShot("raiseAndAuthoriseAdjustment");

		mq.progressQuery("RE");
		action.getScreenShot("raiseAndAuthoriseAdjustment");
		mq.verifyQuery();
		action.getScreenShot("raiseAndAuthoriseAdjustment");

		mq.signOffQuery();
		action.getScreenShot("raiseAndAuthoriseAdjustment");
		mq.verifyQuery();
		action.getScreenShot("raiseAndAuthoriseAdjustment");
	}

	@Test
	public static void raiseAndAuthoriseAdjustment() {
		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot("raiseAndAuthoriseAdjustment");
		mq.searchByAccount("260002260000");
		action.getScreenShot("raiseAndAuthoriseAdjustment");
		mq.raiseAccountQuery();
		action.getScreenShot("raiseAndAuthoriseAdjustment");
		mq.verifyQuery();
		action.getScreenShot("raiseAndAuthoriseAdjustment");

		mq.progressQuery("RE");
		action.getScreenShot("raiseAndAuthoriseAdjustment");
		mq.verifyQuery();
		action.getScreenShot("raiseAndAuthoriseAdjustment");

		mq.raiseAdjustment();
		action.getScreenShot("raiseAndAuthoriseAdjustment");
		mq.verifyQuery();
		action.getScreenShot("raiseAndAuthoriseAdjustment");

		mq.authoriseAdjustment();
		action.getScreenShot("raiseAndAuthoriseAdjustment");
		mq.verifyQuery();
		action.getScreenShot("raiseAndAuthoriseAdjustment");
	}

	@Test(enabled = false)
	public static void verifyBills() {
		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot("verifyBills");
		mq.searchByQueryNumber("ZK00015");
		action.getScreenShot("verifyBills");
		mq.verifyQuery();
		action.getScreenShot("verifyBills");
		mq.verifyBills();
		action.getScreenShot("verifyBills");
		mq.navigateBackFromBillView();
		action.getScreenShot("verifyBills");
		mq.verifyQuery();
		action.getScreenShot("verifyBills");
	}

	@Test(priority = 5)
	public static void raiseQueryNonAccount() {
		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot("raiseQueryNonAccount");
		mq.raiseNonAccountQuery("Test Name", "mail", "test@cwc.com");
		action.getScreenShot("raiseQueryNonAccount");
		mq.verifyQuery();
		action.getScreenShot("raiseQueryNonAccount");
	}
}

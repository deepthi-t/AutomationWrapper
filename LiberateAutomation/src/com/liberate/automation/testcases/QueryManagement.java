package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.common.TestData;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CCMaintainQuery;

public class QueryManagement {
	static TestActions action = CommonLogin.action;

	@Test(priority = 1)
	public void raiseQueryAccount() {
		CCMaintainQuery mq = new CCMaintainQuery(action);

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
	public void amendQuery() {
		CCMaintainQuery mq = new CCMaintainQuery(action);

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
	public void addNoteQuery() {
		CCMaintainQuery mq = new CCMaintainQuery(action);

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
	public void progressQuery() {
		CCMaintainQuery mq = new CCMaintainQuery(action);

		mq.navigate();
		action.getScreenShot("progressQuery");
		mq.searchByQueryNumber(TestData.QueryNumber);// "B00006A");
		action.getScreenShot("progressQuery");
		mq.verifyQuery();
		action.getScreenShot("progressQuery");
		mq.progressQuery("ES");
		action.getScreenShot("progressQuery");
		mq.verifyQuery();
		action.getScreenShot("progressQuery");
	}

	@Test(enabled = false)
	public void signOffQuery() {
		CCMaintainQuery mq = new CCMaintainQuery(action);

		mq.navigate();
		action.getScreenShot("signOffQuery");
		mq.searchByQueryNumber(TestData.QueryNumber);// "B00006A");
		action.getScreenShot("signOffQuery");
		mq.verifyQuery();
		action.getScreenShot("signOffQuery");
		mq.progressQuery("RE");
		action.getScreenShot("signOffQuery");
		mq.verifyQuery();
		action.getScreenShot("signOffQuery");
	}

	@Test(enabled = false)
	public void verifyBills() {
		CCMaintainQuery mq = new CCMaintainQuery(action);

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
	public void raiseQueryNonAccount() {
		CCMaintainQuery mq = new CCMaintainQuery(action);

		mq.navigate();
		action.getScreenShot("raiseQueryNonAccount");
		mq.raiseNonAccountQuery("Test Name", "mail", "test@cwc.com");
		action.getScreenShot("raiseQueryNonAccount");
		mq.verifyQuery();
		action.getScreenShot("raiseQueryNonAccount");
	}
}

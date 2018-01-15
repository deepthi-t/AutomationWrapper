package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.common.TestData;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CCMaintainQuery;

public class QueryManagement {
	static TestActions action = CommonLogin.action;
		
	@Test(priority = 1)
	public void raiseQueryAccount()
	{
		CCMaintainQuery mq = new CCMaintainQuery(action);
		mq.navigate();
		mq.searchByAccount("260002260000");
		mq.raiseAccountQuery();
		mq.verifyQuery();
	}
	
	@Test(priority = 2)
	public void amendQuery()
	{
		CCMaintainQuery mq = new CCMaintainQuery(action);
		mq.navigate();
		mq.searchByQueryNumber(TestData.QueryNumber);//"B00006A");
		mq.verifyQuery();
		mq.amendQuery();
		mq.verifyQuery();
	}
	
	@Test(priority = 3)
	public void addNoteQuery()
	{
		CCMaintainQuery mq = new CCMaintainQuery(action);
		mq.navigate();
		mq.searchByQueryNumber(TestData.QueryNumber);//"B00006A");
		mq.verifyQuery();
		mq.addNote("Additional Note");
		mq.verifyQuery();
	}
	
	@Test(priority = 4)
	public void progressQuery()
	{
		CCMaintainQuery mq = new CCMaintainQuery(action);
		mq.navigate();
		mq.searchByQueryNumber(TestData.QueryNumber);//"B00006A");
		mq.verifyQuery();
		mq.progressQuery("ES");
		mq.verifyQuery();
	}
	
	@Test(enabled = false)
	public void signOffQuery()
	{
		CCMaintainQuery mq = new CCMaintainQuery(action);
		mq.navigate();
		mq.searchByQueryNumber(TestData.QueryNumber);//"B00006A");
		mq.verifyQuery();
		mq.progressQuery("RE");
		mq.verifyQuery();
	}
	
	@Test(enabled = false)
	public void verifyBills()
	{
		CCMaintainQuery mq = new CCMaintainQuery(action);
		mq.navigate();
		mq.searchByQueryNumber("ZK00015");
		mq.verifyQuery();
		mq.verifyBills();
		mq.navigateBackFromBillView();
		mq.verifyQuery();
	}
	
	@Test(priority = 5)
	public void raiseQueryNonAccount()
	{
		CCMaintainQuery mq = new CCMaintainQuery(action);
		mq.navigate();
		mq.raiseNonAccountQuery("Test Name", "mail", "test@cwc.com");
		mq.verifyQuery();
	}
}

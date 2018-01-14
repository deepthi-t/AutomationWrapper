package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CCMaintainQuery;

public class QueryManagement {
	static TestActions action = CommonLogin.action;
	
	@Test
	public void raiseQuery()
	{
		CCMaintainQuery mq = new CCMaintainQuery(action);
		mq.navigate();
		mq.searchByAccount("260002260000");
		mq.raiseAccountQuery();
		mq.verifyQuery();
	}
	
	@Test
	public void amendQuery()
	{
		CCMaintainQuery mq = new CCMaintainQuery(action);
		mq.navigate();
		mq.searchByQueryNumber("B00006A");
		mq.verifyQuery();
		mq.amendQuery();
		mq.verifyQuery();
	}
	
	@Test
	public void addNoteQuery()
	{
		CCMaintainQuery mq = new CCMaintainQuery(action);
		mq.navigate();
		mq.searchByQueryNumber("B00006A");
		mq.verifyQuery();
		mq.addNote("Additional Note");
		mq.verifyQuery();
	}
	
	@Test
	public void progressQuery()
	{
		CCMaintainQuery mq = new CCMaintainQuery(action);
		mq.navigate();
		mq.searchByQueryNumber("B00006A");
		mq.verifyQuery();
		mq.progressQuery("ES");
		mq.verifyQuery();
	}
	
	@Test
	public void signOffQuery()
	{
		CCMaintainQuery mq = new CCMaintainQuery(action);
		mq.navigate();
		mq.searchByQueryNumber("B00006A");
		mq.verifyQuery();
		mq.progressQuery("RE");
		mq.verifyQuery();
	}
	
	@Test
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
}

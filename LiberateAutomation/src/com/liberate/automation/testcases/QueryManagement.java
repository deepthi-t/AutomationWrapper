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
}

package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.BrowseServiceOrder;

public class BulkSOProcessing {
	static TestActions action = CommonLogin.action;
	
	@Test
	public void bulkCancel()
	{
		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		msr.navigate();
		msr.selectMultipleServiceOrder("BGNET", 2);
		msr.bulkCancel();
		msr.verifyBulkProcessing();
	}
	
	@Test
	public void bulkSuspend()
	{
		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		msr.navigate();
		msr.selectMultipleServiceOrder("BGNET", 2);
		msr.bulkSuspend();
		msr.verifyBulkProcessing();
	}
	
	@Test
	public void bulkAccountSignOff()
	{
		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		msr.navigate();
		msr.selectMultipleServiceOrder("BGSOF", 2);
		msr.bulkSignOff();
		msr.verifyBulkProcessing();
	}
	
	@Test
	public void bulkGeneralSignOff()
	{
		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		msr.navigate();
		msr.selectMultipleServiceOrder("CRCL", 2);
		msr.bulkSignOff();
		msr.verifyBulkProcessing();
	}
}

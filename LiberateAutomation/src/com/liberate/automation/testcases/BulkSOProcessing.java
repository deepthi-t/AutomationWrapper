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
		action.getScreenShot("bulkCancel");
		msr.selectMultipleServiceOrder("BGNET", 2);
		action.getScreenShot("bulkCancel");
		msr.bulkCancel();
		action.getScreenShot("bulkCancel");
		msr.verifyBulkProcessing();
	}
	
	@Test
	public void bulkSuspend()
	{
		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		msr.navigate();
		action.getScreenShot("bulkSuspend");
		msr.selectMultipleServiceOrder("BGNET", 2);
		action.getScreenShot("bulkSuspend");
		msr.bulkSuspend();
		action.getScreenShot("bulkSuspend");
		msr.verifyBulkProcessing();
		action.getScreenShot("bulkSuspend");
	}
	
	@Test
	public void bulkAccountSignOff()
	{
		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		msr.navigate();
		action.getScreenShot("bulkAccountSignOff");
		msr.selectMultipleServiceOrder("BGSOF", 2);
		action.getScreenShot("bulkAccountSignOff");
		msr.bulkSignOff();
		action.getScreenShot("bulkAccountSignOff");
		msr.verifyBulkProcessing();
		action.getScreenShot("bulkAccountSignOff");
	}
	
	@Test
	public void bulkGeneralSignOff()
	{
		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		msr.navigate();
		action.getScreenShot("bulkGeneralSignOff");
		msr.selectMultipleServiceOrder("CRCL", 2);
		action.getScreenShot("bulkGeneralSignOff");
		msr.bulkSignOff();
		action.getScreenShot("bulkGeneralSignOff");
		msr.verifyBulkProcessing();
		action.getScreenShot("bulkGeneralSignOff");
	}
}

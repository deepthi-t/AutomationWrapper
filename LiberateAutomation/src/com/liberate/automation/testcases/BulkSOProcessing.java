package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.BrowseServiceOrder;

public class BulkSOProcessing {
	static TestActions action = CommonLogin.action;

	@Test
	public static void bulkCancel() {
		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot("bulkCancel");
		assertEquals(msr.selectMultipleServiceOrder("BGNET", 2), true);
		action.getScreenShot("bulkCancel");
		assertEquals(msr.bulkCancel(), true);
		action.getScreenShot("bulkCancel");
		assertEquals(msr.verifyBulkProcessing(), true);
	}

	@Test
	public static void bulkSuspend() {
		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot("bulkSuspend");
		assertEquals(msr.selectMultipleServiceOrder("BGNET", 2), true);
		action.getScreenShot("bulkSuspend");
		assertEquals(msr.bulkSuspend(), true);
		action.getScreenShot("bulkSuspend");
		assertEquals(msr.verifyBulkProcessing(), true);
		action.getScreenShot("bulkSuspend");
	}

	@Test
	public static void bulkAccountSignOff() {
		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot("bulkAccountSignOff");
		assertEquals(msr.selectMultipleServiceOrder("AQSOF", 2), true);
		action.getScreenShot("bulkAccountSignOff");
		assertEquals(msr.bulkSignOff(), true);
		action.getScreenShot("bulkAccountSignOff");
		assertEquals(msr.verifyBulkProcessing(), true);
		action.getScreenShot("bulkAccountSignOff");
	}

	@Test
	public static void bulkGeneralSignOff() {
		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot("bulkGeneralSignOff");
		assertEquals(msr.selectMultipleServiceOrder("BGINS", 2), true);
		action.getScreenShot("bulkGeneralSignOff");
		assertEquals(msr.bulkSignOff(), true);
		action.getScreenShot("bulkGeneralSignOff");
		assertEquals(msr.verifyBulkProcessing(), true);
		action.getScreenShot("bulkGeneralSignOff");
	}
}

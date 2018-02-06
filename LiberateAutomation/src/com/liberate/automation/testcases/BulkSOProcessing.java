package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.BrowseServiceOrder;

public class BulkSOProcessing {
	static TestActions action = CommonLogin.action;

	@Test
	public static void bulkCancel() {
		String TestCase = "BulkSOProcessing_bulkCancel";

		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		assertEquals(msr.navigate(),true);
		action.getScreenShot(TestCase);
		assertEquals(msr.selectMultipleServiceOrder("BGNET", 2),true);
		action.getScreenShot(TestCase);
		assertEquals(msr.bulkCancel(),true);
		action.getScreenShot(TestCase);
		assertEquals(msr.verifyBulkProcessing(),true);
		action.getScreenShot(TestCase);
	}

	@Test
	public static void bulkSuspend() {
		String TestCase = "BulkSOProcessing_bulkSuspend";

		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		assertEquals(msr.navigate(),true);
		action.getScreenShot(TestCase);
		assertEquals(msr.selectMultipleServiceOrder("BGNET", 2),true);
		action.getScreenShot(TestCase);
		assertEquals(msr.bulkSuspend(),true);
		action.getScreenShot(TestCase);
		assertEquals(msr.verifyBulkProcessing(),true);
		action.getScreenShot(TestCase);
	}

	@Test
	public static void bulkAccountSignOff() {
		String TestCase = "BulkSOProcessing_bulkAccountSignOff";

		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		assertEquals(msr.navigate(),true);
		action.getScreenShot(TestCase);
		assertEquals(msr.selectMultipleServiceOrder("AQSOF", 2),true);
		action.getScreenShot(TestCase);
		assertEquals(msr.bulkSignOff(),true);
		action.getScreenShot(TestCase);
		assertEquals(msr.verifyBulkProcessing(),true);
		action.getScreenShot(TestCase);
	}

	@Test
	public static void bulkGeneralSignOff() {
		String TestCase = "BulkSOProcessing_bulkGeneralSignOff";

		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		assertEquals(msr.navigate(),true);
		action.getScreenShot(TestCase);
		assertEquals(msr.selectMultipleServiceOrder("BGINS", 2),true);
		action.getScreenShot(TestCase);
		assertEquals(msr.bulkSignOff(),true);
		action.getScreenShot(TestCase);
		assertEquals(msr.verifyBulkProcessing(),true);
		action.getScreenShot(TestCase);
	}
}

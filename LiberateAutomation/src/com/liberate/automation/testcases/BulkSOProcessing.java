package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.BrowseServiceOrder;

public class BulkSOProcessing {
	static TestActions action = CommonLogin.action;

	static String networkDepartment = "BGNET";
	static String generalDepartment = "BGINS";
	static String accountDepartment = "AQSOF";

	@Test
	public static void bulkCancel() {
		String TestCase = "BulkSOProcessing_bulkCancel";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.selectMultipleServiceOrder(generalDepartment, 2), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.bulkCancel(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.verifyBulkProcessing(), true);
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void bulkSuspend() {
		String TestCase = "BulkSOProcessing_bulkSuspend";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.selectMultipleServiceOrder(generalDepartment, 2), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.bulkSuspend(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.verifyBulkProcessing(), true);
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void bulkAccountSignOff() {
		String TestCase = "BulkSOProcessing_bulkAccountSignOff";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.selectMultipleServiceOrder(accountDepartment, 2), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.bulkSignOff(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.verifyBulkProcessing(), true);
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void bulkGeneralSignOff() {
		String TestCase = "BulkSOProcessing_bulkGeneralSignOff";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.selectMultipleServiceOrder(generalDepartment, 2), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.bulkSignOff(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.verifyBulkProcessing(), true);
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}
}

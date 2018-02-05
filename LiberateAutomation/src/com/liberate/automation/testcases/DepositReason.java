package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.liberate.automation.core.RandomData;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.MaintainDepositReason;

public class DepositReason {

	static TestActions action = CommonLogin.action;

	@Test
	public static void createNewDepositReason() {
		String TestCase = "DepositReason_createNewDepositReason";

		RandomData random = new RandomData();
		MaintainDepositReason mdr = new MaintainDepositReason(action);

		action.getScreenShot(TestCase);
		assertEquals(mdr.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(mdr.clickNewButton(), true);
		action.getScreenShot(TestCase);
		assertEquals(mdr.provideDepositReasonDetailsNewCreation(random.nextString().substring(4), "TestingAutomation",
				"Y", "4"), true);
		action.getScreenShot(TestCase);
		assertEquals(mdr.clickAcceptButton(), true);
		action.getScreenShot(TestCase);
		action.waitFor(By.xpath("//span[@class='iceMsgInfo']"), 2, true);
		String x = action.getTextFromPage(By.xpath("//span[@class='iceMsgInfo']"));
		action.getScreenShot(TestCase);
		System.out.println(x);
	}

	public static void newDepositReasonCancel() {
		String TestCase = "DepositReason_newDepositReasonCancel";

		RandomData random = new RandomData();
		MaintainDepositReason mdr = new MaintainDepositReason(action);

		assertEquals(mdr.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(mdr.clickNewButton(), true);
		action.getScreenShot(TestCase);
		assertEquals(mdr.provideDepositReasonDetailsNewCreation(random.nextString().substring(4), "TestingAutomation",
				"Y", "4"), true);
		action.getScreenShot(TestCase);
		assertEquals(mdr.clickCancelButton(), true);
		action.getScreenShot(TestCase);

	}

	@Test
	public static void amendDepositReason() {
		String TestCase = "DepositReason_amendDepositReason";

		MaintainDepositReason mdr = new MaintainDepositReason(action);

		assertEquals(mdr.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(mdr.selectRecordToAmend(), true);
		action.getScreenShot(TestCase);
		assertEquals(mdr.clickAmendButton(), true);
		action.getScreenShot(TestCase);
		assertEquals(mdr.provideDetailsAmendDepositReason("TestingAutomationAmend", "Y", "4"), true);
		action.getScreenShot(TestCase);
		assertEquals(mdr.clickAcceptButton(), true);
		action.getScreenShot(TestCase);
	}

	public static void amendDepositReasonCancel() {
		String TestCase = "DepositReason_amendDepositReasonCancel";

		MaintainDepositReason mdr = new MaintainDepositReason(action);

		assertEquals(mdr.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(mdr.selectRecordToAmend(), true);
		action.getScreenShot(TestCase);
		assertEquals(mdr.clickAmendButton(), true);
		action.getScreenShot(TestCase);
		assertEquals(mdr.provideDetailsAmendDepositReason("TestingAutomationAmend", "Y", "4"), true);
		action.getScreenShot(TestCase);
		assertEquals(mdr.clickCancelButton(), true);
		action.getScreenShot(TestCase);
	}

}

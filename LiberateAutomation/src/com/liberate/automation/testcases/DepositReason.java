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
		RandomData random = new RandomData();
		MaintainDepositReason mdr = new MaintainDepositReason(action);

		action.getScreenShot("DepositReason");
		assertEquals(mdr.navigate(), true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.clickNewButton(), true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.provideDepositReasonDetailsNewCreation(random.nextString().substring(4), "TestingAutomation",
				"Y", "4"), true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.clickAcceptButton(), true);
		action.getScreenShot("DepositReason");
		action.waitFor(By.xpath("//span[@class='iceMsgInfo']"), 2, true);
		String x = action.getTextFromPage(By.xpath("//span[@class='iceMsgInfo']"));
		action.getScreenShot("DepositReason");
		System.out.println(x);
	}

	public static void newDepositReasonCancel() {
		RandomData random = new RandomData();
		MaintainDepositReason mdr = new MaintainDepositReason(action);

		assertEquals(mdr.navigate(), true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.clickNewButton(), true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.provideDepositReasonDetailsNewCreation(random.nextString().substring(4), "TestingAutomation",
				"Y", "4"), true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.clickCancelButton(), true);
		action.getScreenShot("DepositReason");

	}

	@Test
	public static void amendDepositReason() {
		MaintainDepositReason mdr = new MaintainDepositReason(action);

		assertEquals(mdr.navigate(), true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.selectRecordToAmend(), true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.clickAmendButton(), true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.provideDetailsAmendDepositReason("TestingAutomationAmend", "Y", "4"), true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.clickAcceptButton(), true);
		action.getScreenShot("DepositReason");
	}

	public static void amendDepositReasonCancel() {
		MaintainDepositReason mdr = new MaintainDepositReason(action);

		assertEquals(mdr.navigate(), true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.selectRecordToAmend(), true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.clickAmendButton(), true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.provideDetailsAmendDepositReason("TestingAutomationAmend", "Y", "4"), true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.clickCancelButton(), true);
		action.getScreenShot("DepositReason");
	}

}

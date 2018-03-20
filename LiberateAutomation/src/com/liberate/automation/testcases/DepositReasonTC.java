package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.liberate.automation.core.RandomData;
import com.liberate.automation.core.ReportGenerator;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.MaintainDepositReason;

public class DepositReasonTC {

	static TestActions action = CommonLogin.action;

	@Test
	public static void createNewDepositReason() {
		String TestCase = "DepositReason_createNewDepositReason";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

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
		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}
}

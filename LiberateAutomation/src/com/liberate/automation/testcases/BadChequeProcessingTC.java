package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.pom.PYBadCheckProcessing;

/***
 * Class with Bad Cheque Processing Test Cases
 * @author Nikhil
 *
 */
public class BadChequeProcessingTC {

	static TestActions action = CommonLogin.action;

	static String badChequePaymentNumber = "";

	@BeforeClass
	public static void loadData() {
		badChequePaymentNumber = TestData.badChequePaymentNumber;
	}

	@Test
	public static void badCheckProcessing() {
		String TestCase = "BadChequeProcessing_badCheckProcessing";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		PYBadCheckProcessing bcp = new PYBadCheckProcessing(action);

		assertEquals(bcp.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(bcp.SearchWithPaymentNumber(badChequePaymentNumber), true);
		action.getScreenShot(TestCase);
		assertEquals(bcp.openChequeDetails(), true);
		action.getScreenShot(TestCase);
		assertEquals(bcp.provideChequeCardDetails(), true);
		action.getScreenShot(TestCase);
		assertEquals(bcp.acceptBadChequeProcessing(), true);
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}
}
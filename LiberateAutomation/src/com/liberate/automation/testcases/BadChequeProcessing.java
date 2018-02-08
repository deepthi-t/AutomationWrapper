package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.PYBadCheckProcessing;

public class BadChequeProcessing {

	static TestActions action = CommonLogin.action;
	
	static String paymentNumber = "9264886";
	
	@Test
	public static void badCheckProcessing() {
		String TestCase = "BadChequeProcessing_badCheckProcessing";

		PYBadCheckProcessing bcp = new PYBadCheckProcessing(action);

		assertEquals(bcp.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(bcp.SearchWithPaymentNumber(paymentNumber), true);
		action.getScreenShot(TestCase);
		assertEquals(bcp.openChequeDetails(), true);
		action.getScreenShot(TestCase);
		assertEquals(bcp.provideChequeCardDetails(), true);
		action.getScreenShot(TestCase);
		assertEquals(bcp.acceptBadChequeProcessing(), true);
		action.getScreenShot(TestCase);
	}
}
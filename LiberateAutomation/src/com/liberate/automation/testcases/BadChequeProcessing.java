package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.PYBadCheckProcessing;

public class BadChequeProcessing {

	static TestActions action = CommonLogin.action;

	@Test
	public void badCheckProcessing() {
		PYBadCheckProcessing bcp = new PYBadCheckProcessing(action);

		assertEquals(bcp.navigate(), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.SearchWithPaymentNumber("9264886"), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.openChequeDetails(), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.provideChequeCardDetails(), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.acceptBadChequeProcessing(), true);
		action.getScreenShot("BadCheckProcessing");
	}
}
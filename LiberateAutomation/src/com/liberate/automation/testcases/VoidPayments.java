package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.PYVoidPayment;

public class VoidPayments {

	static TestActions action = CommonLogin.action;

	@Test
	public static void voidPayment() {
		PYVoidPayment vp = new PYVoidPayment(action);

		assertEquals(vp.navigate(), true);
		action.getScreenShot("VoidPayment");
		assertEquals(vp.PaymentNumber("9320148"), true);
		action.getScreenShot("VoidPayment");
		assertEquals(vp.Search(), true);
		action.getScreenShot("VoidPayment");
		assertEquals(vp.EnterVoidReason("3"), true);
		assertEquals(vp.Accept(), true);
		action.getScreenShot("VoidPayment");
	}

	public static void voidPaymentReset() {
		PYVoidPayment vp = new PYVoidPayment(action);

		assertEquals(vp.navigate(), true);
		action.getScreenShot("VoidPayment");
		assertEquals(vp.PaymentNumber("9320150"), true);
		action.getScreenShot("VoidPayment");
		assertEquals(vp.Reset(), true);
		action.getScreenShot("VoidPayment");

	}

	public static void newVoidPaymentCancel() {

		PYVoidPayment vp = new PYVoidPayment(action);

		assertEquals(vp.navigate(), true);
		action.getScreenShot("VoidPayment");
		assertEquals(vp.PaymentNumber("9320150"), true);
		action.getScreenShot("VoidPayment");
		assertEquals(vp.Search(), true);
		action.getScreenShot("VoidPayment");
		assertEquals(vp.Cancel(), true);
		action.getScreenShot("VoidPayment");
	}

}

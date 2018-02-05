package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.PYVoidPayment;

public class VoidPayments {

	static TestActions action = CommonLogin.action;

	@Test
	public static void voidPayment() {
		String TestCase = "VoidPayments_voidPayment";

		PYVoidPayment vp = new PYVoidPayment(action);

		assertEquals(vp.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(vp.PaymentNumber("9320148"), true);
		action.getScreenShot(TestCase);
		assertEquals(vp.Search(), true);
		action.getScreenShot(TestCase);
		assertEquals(vp.EnterVoidReason("3"), true);
		assertEquals(vp.Accept(), true);
		action.getScreenShot(TestCase);
	}
	
	@Test(enabled = false)
	public static void voidPaymentReset() {
		String TestCase = "VoidPayments_voidPaymentReset";

		PYVoidPayment vp = new PYVoidPayment(action);

		assertEquals(vp.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(vp.PaymentNumber("9320150"), true);
		action.getScreenShot(TestCase);
		assertEquals(vp.Reset(), true);
		action.getScreenShot(TestCase);

	}
	
	@Test(enabled = false)
	public static void newVoidPaymentCancel() {
		String TestCase = "VoidPayments_newVoidPaymentCancel";

		PYVoidPayment vp = new PYVoidPayment(action);

		assertEquals(vp.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(vp.PaymentNumber("9320150"), true);
		action.getScreenShot(TestCase);
		assertEquals(vp.Search(), true);
		action.getScreenShot(TestCase);
		assertEquals(vp.Cancel(), true);
		action.getScreenShot(TestCase);
	}

}

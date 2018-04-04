package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.PYPaymentEnquiriesPOM;

/***
 * Class with Payment Enquiries Test Cases
 * @author Nikhil
 *
 */
public class PaymentEnquiriesTC {
	static TestActions action = CommonLogin.action;

	@Test
	public static void searchWithAccountNumber() {
		String TestCase = "PaymentEnquiries_searchWithAccountNumber";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		PYPaymentEnquiriesPOM pe = new PYPaymentEnquiriesPOM(action);

		action.getScreenShot(TestCase);
		assertEquals(pe.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(pe.paymentEnquiryWithAccountNumber("260002280000"), true);
		action.getScreenShot(TestCase);
		String acctnum = action
				.getTextFromPage(By.xpath("//*[@class='icePnlGrp']/div[2]/div[2]/table/tbody/tr[2]/td[2]"));
		action.getScreenShot(TestCase);
		System.out.println("Searched Account number is" + " " + acctnum);
		if (acctnum.equals("260002280000")) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
}
	/*
	 * @Test public static void searchWithPaymentNumber() { PaymentEnquiriesPOM
	 * pe=new PaymentEnquiriesPOM(action);
	 * 
	 * action.getScreenShot(TestCase); assertEquals(pe.navigate(),true);
	 * action.getScreenShot(TestCase);
	 * assertEquals(pe.paymentEnquiryWithPaymentNo("9320150"),true);
	 * action.getScreenShot(TestCase); String paymntnum =
	 * action.getTextFromPage(By.xpath(
	 * "//*[@class='icePnlGrp']/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[2]/span"));
	 * action.getScreenShot(TestCase);
	 * System.out.println("Searched Payment number is"+" "+paymntnum); }
	 * 
	 * 
	 * @Test public static void SearchWithServiceOrderNumber() { PaymentEnquiriesPOM
	 * pe=new PaymentEnquiriesPOM(action);
	 * 
	 * action.getScreenShot(TestCase); assertEquals(pe.navigate(),true);
	 * action.getScreenShot(TestCase);
	 * assertEquals(pe.paymentEnquiryWithServiceOrderNo(""),true);
	 * action.getScreenShot(TestCase); }
	 * 
	 * @Test public static void accountDetailsForSearchedPayment() {
	 * PaymentEnquiriesPOM pe=new PaymentEnquiriesPOM(action);
	 * 
	 * action.getScreenShot(TestCase); assertEquals(pe.navigate(),true);
	 * action.getScreenShot(TestCase);
	 * assertEquals(pe.paymentEnquiryWithPaymentNo("9320150"),true);
	 * action.getScreenShot(TestCase); String acctDetailsPanelName =
	 * action.getTextFromPage(By.xpath("//*[text()='Account Payment Details']"));
	 * String customerdetail =
	 * action.getTextFromPage(By.xpath("//*[text()='Account Payment Details']"));
	 * action.getScreenShot(TestCase);
	 * System.out.println(acctDetailsPanelName+" "+customerdetail);
	 * 
	 * }
	 */
}

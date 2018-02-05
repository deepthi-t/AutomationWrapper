package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.PYPaymentEnquiriesPOM;

public class PaymentEnquiries {
	static TestActions action = CommonLogin.action;

	@Test
	public static void searchWithAccountNumber() {
		PYPaymentEnquiriesPOM pe = new PYPaymentEnquiriesPOM(action);

		action.getScreenShot("PaymentEnquiriesAccountNumber");
		assertEquals(pe.navigate(), true);
		action.getScreenShot("PaymentEnquiriesAccountNumber");
		assertEquals(pe.paymentEnquiryWithAccountNumber("260002280000"), true);
		action.getScreenShot("PaymentEnquiriesAccountNumber");
		String acctnum = action
				.getTextFromPage(By.xpath("//*[@class='icePnlGrp']/div[2]/div[2]/table/tbody/tr[2]/td[2]"));
		action.getScreenShot("PaymentEnquiriesAccountNumber");
		System.out.println("Searched Account number is" + " " + acctnum);
		if (acctnum.equals("260002280000")) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
	}
	@Test public static void searchWithPaymentNumber()
	{ 
		PYPaymentEnquiriesPOM	pe=new PYPaymentEnquiriesPOM(action);

		action.getScreenShot("PaymentEnquiries"); 
		assertEquals(pe.navigate(),true);
		action.getScreenShot("PaymentEnquiriesPaymentNumber");
		assertEquals(pe.paymentEnquiryWithPaymentNo("9320150"),true);
		action.getScreenShot("PaymentEnquiriesPaymentNumber"); 
	//	String paymntnum = action.getTextFromPage(By.xpath("//*[@class='icePnlGrp']/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[2]/span"));
	//	action.getScreenShot("PaymentEnquiriesPaymentNumber");
	//	System.out.println("Searched Payment number is"+" "+paymntnum); 
	}

	
		@Test public static void SearchWithServiceOrderNumber()
		{ 
		PYPaymentEnquiriesPOM	pe=new PYPaymentEnquiriesPOM(action);
		action.getScreenShot("PaymentEnquiriesServiceOrderNumber"); 
		assertEquals(pe.navigate(),true);
		action.getScreenShot("PaymentEnquiriesServiceOrderNumber");
		assertEquals(pe.paymentEnquiryWithServiceOrderNo(""),true);
		action.getScreenShot("PaymentEnquiriesServiceOrderNumber");
		}

		
		@Test public static void accountDetailsForSearchedPayment() 
		{
		PYPaymentEnquiriesPOM pe=new PYPaymentEnquiriesPOM(action);

		action.getScreenShot("PaymentEnquiriesSearchedPayment"); 
		assertEquals(pe.navigate(),true);
		action.getScreenShot("PaymentEnquiriesSearchedPayment");
		assertEquals(pe.paymentEnquiryWithPaymentNo("9320150"),true);
		action.getScreenShot("PaymentEnquiriesSearchedPayment"); 
		String acctDetailsPanelName = action.getTextFromPage(By.xpath("//*[text()='Account Payment Details']"));
		String customerdetail = action.getTextFromPage(By.xpath("//*[text()='Account Payment Details']"));
		action.getScreenShot("PaymentEnquiriesSearchedPayment");
		System.out.println(acctDetailsPanelName+" "+customerdetail);

		}
}

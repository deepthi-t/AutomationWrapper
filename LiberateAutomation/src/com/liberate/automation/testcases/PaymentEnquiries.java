package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.PaymentEnquiriesPOM;

public class PaymentEnquiries 
{
	static TestActions action = CommonLogin.action;
	
	@Test
	public void paymentEnquiry_SearchWithAccountNumber()
	{
		PaymentEnquiriesPOM pe=new PaymentEnquiriesPOM(action);
		
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.navigate(),true);
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.paymentEnquiryWithAccountNumber("270004460000"),true);
		action.getScreenShot("PaymentEnquiries");	
	}
	
	@Test
	public void paymentEnquiry_SearchWithPaymentNumber()
	{
		PaymentEnquiriesPOM pe=new PaymentEnquiriesPOM(action);
		
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.navigate(),true);
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.paymentEnquiryWithPaymentNo("9320150"),true);
		action.getScreenShot("PaymentEnquiries");	
	}
	
	
	@Test
	public void paymentEnquiry_SearchWithServiceOrderNumber()
	{
		PaymentEnquiriesPOM pe=new PaymentEnquiriesPOM(action);
		
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.navigate(),true);
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.paymentEnquiryWithServiceOrderNo(""),true);
		action.getScreenShot("PaymentEnquiries");	
	}
	
	@Test
	public void accountDetailsForSearchedPayment()
	{
		PaymentEnquiriesPOM pe=new PaymentEnquiriesPOM(action);
		
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.navigate(),true);
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.paymentEnquiryWithPaymentNo("9320150"),true);
		action.getScreenShot("PaymentEnquiries");	
		assertEquals(pe.clickOnAccountDetails_CommandButton(),true);
		action.getScreenShot("AccountDetails_payment");
	}
	
}
